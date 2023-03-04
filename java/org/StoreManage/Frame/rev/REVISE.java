package org.StoreManage.Frame.rev;



import org.StoreManage.Frame.Congratulate;
import org.StoreManage.Frame.Warning;
import org.StoreManage.Operate;
import org.StoreManage.detail;
import org.StoreManage.unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import static org.StoreManage.Operate.detId;

public class REVISE extends JFrame {
    JRadioButton jrb1, jrb2;
    JLabel jl1, jl2, jl3, jl4;
    JTextField jtf1, jtf2, jtf3, jtf4;
    JButton jb1, jb2, jb3, jb4;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8, jp9, jp10;
    JTextArea jta;
    ButtonGroup btg;

    String infoSHOW = "";
    String se = "";

    String stDate = "";
    int stQuan = 0;
    String stNote = "";
    String stName = "";
    int stId = 0;


    public static void main(String[] args) {
        new REVISE().REVISE_init();
    }

    public REVISE() {
        jrb1 = new JRadioButton("进货");
        jrb2 = new JRadioButton("出货");
        btg = new ButtonGroup();
        btg.add(jrb1);
        btg.add(jrb2);

        jl1 = new JLabel("请输入物品名称");
        jtf1 = new JTextField(10);
        jb1 = new JButton("查询");
        jb2 = new JButton("清空");

        jta = new JTextArea(8, 20);
        jta.setEditable(false);

        jl2 = new JLabel("操作数量");
        jl3 = new JLabel("操作日期");
        jl4 = new JLabel("操作备注");
        jtf2 = new JTextField(15);
        jtf3 = new JTextField(15);
        jtf4 = new JTextField(15);

        jb3 = new JButton("修改");
        jb4 = new JButton("返回");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();
        jp9 = new JPanel();
        jp10 = new JPanel();

//        jp1.add(jl1);
//        jp1.add(jtf1);
//
//        jp2.add(jb1);
//        jp2.add(jb2);
//
//        jp3.add(jta);
//
//        jp4.add(jrb1);
//        jp4.add(jrb2);
//
//        jp5.add(jl2);
//        jp5.add(jtf2);
//
//        jp6.add(jl3);
//        jp6.add(jtf3);
//
//        jp7.add(jl4);
//        jp7.add(jtf4);
//
//        jp8.add(jb3);
//        jp8.add(jb4);

        jp2.add(jrb1);
        jp2.add(jrb2);

        jp3.add(jl1);
        jp3.add(jtf1);

        jp4.add(jl2);
        jp4.add(jtf2);

        jp5.add(jb1);
        jp5.add(jb2);

        jp6.add(jl3);
        jp6.add(jtf3);

        jp7.add(jta);

        jp8.add(jl4);
        jp8.add(jtf4);

        jp10.add(jb3);
        jp10.add(jb4);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);
        this.add(jp7);
        this.add(jp8);
        this.add(jp9);
        this.add(jp10);

        this.setLayout(new GridLayout(5, 2));
        this.setSize(500, 475);
        this.setTitle("数据修改");
        this.setVisible(true);
        this.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        ImageIcon icon = new ImageIcon("src/main/java/org/StoreManage/icon/Revise.png");
        this.setIconImage(icon.getImage());
    }

    public void REVISE_init() {
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jtf1.setText("");
                jtf2.setText("");
                jtf3.setText("");
                jtf4.setText("");
                jta.setText("");
                se = "";
                infoSHOW = "";
            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtf1.getText() != null || !jtf1.getText().equals("")) {
                    se = jtf1.getText();
                    List<unit> dataList = Operate.selectInfo();
                    boolean flag = false;
                    for (unit i: dataList) {
                        if (i.getName().equals(se)) {
                            infoSHOW += "物品编号: " + i.getID() + "\n";
                            stId = i.getID();
                            infoSHOW += "物品名称: " + i.getName() + "\n";
                            stName = i.getName();
                            infoSHOW += "上一操作日期: " + i.getDate() + "\n";
                            stDate = i.getDate();
                            infoSHOW += "库存数量: " + i.getQuan() + "\n";
                            stQuan = i.getQuan();
                            infoSHOW += "物品备注: " + i.getNote() + "\n";
                            stNote = i.getNote();
                            jta.setText("");
                            jta.setText(infoSHOW);
                            flag = true;
                            infoSHOW = "";
                        }
                    }
                    if (!flag) {
                        new Warning("该物品不存在！");
                    }
                }
                else {
                    new Warning("请输入物品名称！");
                }
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detail det = new detail();
                String nDate = jtf3.getText();
                String nNote = jtf4.getText();
                int nQuan = Integer.parseInt(jtf2.getText());
                int aQuan = 0;

                detail mId = detId();

                det.setID(mId.getID() + 1);
                det.setName(stName);
                det.setQuan(Integer.parseInt(jtf2.getText()));
                det.setDate(jtf3.getText());
                det.setNote(jtf4.getText());
                if (jrb1.isSelected()) {
                    det.setType(jrb1.getText());
                    Operate.WriteDetail(det);
                    aQuan = stQuan + Integer.parseInt(jtf2.getText());
                }
                else if (jrb2.isSelected()) {
                    det.setType(jrb2.getText());
                    Operate.WriteDetail(det);
                    if (stQuan - Integer.parseInt(jtf2.getText()) > 0) {
                        aQuan = stQuan - Integer.parseInt(jtf2.getText());
                    }
                }

                if (Operate.updateDate(stName, jtf3.getText()) &&
                    Operate.updateQuan(stName, aQuan) &&
                    Operate.updateNote(stName, jtf4.getText())) {
                    new Congratulate("修改成功！");
                }
                else {
                    new Warning("修改失败！请检查数据是否输入正确！");
                }

            }
        });

        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                new Menu().Menu_Init();
                REVISE.super.dispose();
            }
        });
    }
}
