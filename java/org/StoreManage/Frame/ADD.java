package org.StoreManage.Frame;


import org.StoreManage.Operate;
import org.StoreManage.detail;
import org.StoreManage.unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ADD extends JFrame {
    JLabel jl1, jl2, jl3, jl4, jl5;
    JTextField jtf1, jtf2, jtf3, jtf4, jtf5;
    JButton jb1, jb2;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6;
    int maxCostId;

    public ADD() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();

        jl1 = new JLabel("物品编码");
        jl2 = new JLabel("物品名称");
        jl3 = new JLabel("操作日期");
        jl4 = new JLabel("物品数量");
        jl5 = new JLabel("物品注释");

        jb1 = new JButton("确认并添加");
        jb2 = new JButton("返回");

        jtf1 = new JTextField(5);
        unit tmp = new unit();
        tmp = Operate.maxID();
        maxCostId = tmp.getID() + 1;
        String idSHOW = "" + maxCostId;
        jtf1.setText(idSHOW);

        jtf2 = new JTextField(15);
        jtf3 = new JTextField(15);
        jtf4 = new JTextField(15);
        jtf5 = new JTextField(30);

        jp1.add(jl1);
        jp1.add(jtf1);

        jp2.add(jl2);
        jp2.add(jtf2);

        jp3.add(jl3);
        jp3.add(jtf3);

        jp4.add(jl4);
        jp4.add(jtf4);

        jp5.add(jl5);
        jp5.add(jtf5);

        jp6.add(jb1);
        jp6.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);

        this.setLayout(new GridLayout(6, 1));
        this.setSize(400, 350);
        this.setTitle("新增数据");
        this.setVisible(true);
        this.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

        ImageIcon icon = new ImageIcon("src/main/java/org/StoreManage/icon/Add.png");
        this.setIconImage(icon.getImage());

    }

    public static void main(String[] args) {
        new ADD().ADD_init();
    }

    public void ADD_init() {
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                unit factor = new unit();
                detail det = new detail();
                factor.setID(Integer.parseInt(jtf1.getText()));
                detail mid = Operate.detId();
                det.setID(mid.getID() + 1);
                if (jtf2.getText() != null || !jtf2.getText().equals("")) {
                    factor.setName(jtf2.getText());
                    det.setName(jtf2.getText());
                }
                else {
                    new Warning("物品名称不能为空");
                }
                if (jtf3.getText() != null || !jtf3.getText().equals("")) {
                    factor.setDate(jtf3.getText());
                    det.setDate(jtf3.getText());
                }
                else {
                    new Warning("操作日期不能为空");
                }
                if (jtf4.getText() != null || !jtf4.getText().equals("")) {
                    factor.setQuan(Integer.parseInt(jtf4.getText()));
                    det.setQuan(Integer.parseInt(jtf4.getText()));
                }
                else {
                    new Warning("物品数量不能为空");
                }
                factor.setNote(jtf5.getText());
                det.setNote(jtf5.getText());
                det.setType("进货");
                if (Operate.AddData(factor)) {
                    new Congratulate("仓库成功加入该商品！");
                    Operate.WriteDetail(det);
                }
                else {
                    new Warning("增添失败！请检查操作是否合法！");
                }
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ADD.super.dispose();
            }
        });
    }
}
