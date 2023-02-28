package org.StoreManage.Frame;


import org.StoreManage.Operate;
import org.StoreManage.unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DELETE extends JFrame {
    JPanel jp1, jp2, jp3, jp4;
    JLabel jl;
    JButton jb1, jb2, jb3;
    JTextArea jta;
    JTextField jtf;
    String toShow = "";
    JFrame question;
    JPanel jpUp, jpDown;
    JLabel ask;
    JButton confirm, cancel;
    int uid = 0;

    public DELETE() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();


        jb1 = new JButton("查询");
        jb2 = new JButton("删除");
        jb3 = new JButton("返回");
        jtf = new JTextField(10);
        jta = new JTextArea(5, 20);
        jta.setEditable(false);

        jl = new JLabel("请输入需要删除的商品名称");

        jp1.add(jl);
        jp1.add(jtf);
        jp1.add(jb1);

        jp2.add(jta);
        jp3.add(jb2);
        jp3.add(jb3);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.setLayout(new GridLayout(3, 1));
        this.setSize(300, 400);
        this.setTitle("删除数据");
        this.setVisible(true);
        this.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("src/main/java/org/StoreManage/icon/Delete.png");
        this.setIconImage(icon.getImage());
    }

    public void DELETE_init() {
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtf.getText() != null || !jtf.getText().equals("")) {
                    List<unit> dataList = Operate.selectInfo();
                    boolean flag = false;
                    for (unit i: dataList) {
                        if (i.getName().equals(jtf.getText())) {
                            toShow += "物品编码：" + i.getID() + '\n' +
                                      "物品名称：" + i.getName() + '\n' +
                                      "操作日期：" + i.getDate() + '\n' +
                                      "物品数量：" + i.getQuan() + '\n' +
                                      "物品注释：" + i.getNote() + '\n';
                            jta.setText("");
                            jta.setText(toShow);
                            toShow = "";
                            flag = true;
                        }
                    }
                    if (!flag) {
                        new Warning("此物品不存在！请检查物品名称是否正确！");
                    }
                }
                else {
                    new Warning("请填写正确的内容！");
                }
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jtf.getText() == null || jtf.getText().equals("")) {
                    new Warning("请填写正确的内容！");
                }
                else {
                    AskAgain();
                }
            }
        });

        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // new Menu().Menu_Init();
                DELETE.super.dispose();
            }
        });
    }


    public void AskAgain() {
        question = new JFrame();
        ask = new JLabel("您确定要删除该物品吗？");
        confirm = new JButton("是的");
        cancel = new JButton("取消");
        jpUp = new JPanel();
        jpDown = new JPanel();
        jpUp.add(ask);
        jpDown.add(confirm);
        jpDown.add(cancel);
        question.add(jpUp);
        question.add(jpDown);
        question.setLayout(new GridLayout(2, 1));
        question.setBounds(100, 100, 320, 120);
        question.setTitle("警告！您正在操作删除功能！请确认");
        question.setVisible(true);
        question.setResizable(false);
        Dimension SmallscreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension SmallframeSize = question.getSize();
        question.setLocation((SmallscreenSize.width - SmallframeSize.width) / 2, (SmallscreenSize.height - SmallframeSize.height) / 2);
        ImageIcon icon = new ImageIcon("src/main/java/org/StoreManage/icon/Tips.png");
        question.setIconImage(icon.getImage());
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Operate.deleteInfo(jtf.getText())) {
                    question.dispose();
                    new Congratulate("您已成功删除该条目！");
                }
                else {
                    new Warning("删除失败！");
                }
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                question.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new DELETE().DELETE_init();
    }
}

