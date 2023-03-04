package org.StoreManage.Frame;



import org.StoreManage.Operate;
import org.StoreManage.unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;

public class REMAIN extends JFrame {
    JPanel jp1, jp2, jp3, jp4, jp5, jp6;
    JComboBox<String> jcb;
    JButton jb1, jb2;
    JProgressBar jpb;
    JLabel jl1, jl2;
    JTextField jtf1, jtf2;
    JButton jb;

    String chose;
    List<String> oList;
    int split = 0;

    public static int cla(List<unit> data) {
        int sum = 0;
        for (unit i: data) {
            sum += i.getQuan();
        }
        return sum;
    }

    public static int reu(List<unit> data, String fa) {
        for (unit i: data) {
            if (i.getName().equals(fa)) {
                return i.getQuan();
            }
        }
        return -1;
    }

    public REMAIN() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();

        jb1 = new JButton("查询");
        jb2 = new JButton("清空");
        jb = new JButton("返回");

        jcb = new JComboBox<String>();

        oList = new ArrayList<String>();
        List<unit> dList = Operate.selectInfo();
        for (unit i: dList) {
            oList.add(i.getName());
        }
        for (String i: oList) {
            jcb.addItem(i);
        }

        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);



        jl1 = new JLabel("当前物品数量");
        jl2 = new JLabel("仓储物品总量");
        jtf1.setEditable(false);
        jtf2.setEditable(false);



        jpb = new JProgressBar(0, 100);
        jpb.setStringPainted(true);

        jp2.add(jb1);
        jp2.add(jb2);

        jp3.add(jpb);
        jp4.add(jl1);
        jp4.add(jtf1);
        jp5.add(jl2);
        jp5.add(jtf2);
        jp6.add(jb);
        jp1.add(jcb);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);




        this.setLayout(new GridLayout(6, 1));
        this.setTitle("数据统计");
        this.setSize(300, 320);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("src/main/java/org/StoreManage/icon/Remain.png");
        this.setIconImage(icon.getImage());

    }

    public static void main(String[] args) {
        new REMAIN().REMAIN_init();
    }

    public void REMAIN_init() {
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jcb.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            chose = (String)jcb.getSelectedItem();
                        }
                    }
                });
                List<unit> pri = Operate.selectInfo();
                double im = cla(pri);
                double in = reu(pri, chose);
                jtf1.setText("" + in);
                jtf2.setText("" + im);
                split = (int) ((in / im) * 100);
                jpb.setValue(split);
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf1.setText("");
                jtf2.setText("");
                jpb.setValue(0);
            }
        });

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new Menu().Menu_Init();
                REMAIN.super.dispose();
            }
        });
    }
}
