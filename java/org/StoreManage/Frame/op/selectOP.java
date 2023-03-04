package org.StoreManage.Frame.op;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectOP extends JFrame {
    JLabel jl;
    JButton jb1, jb2, jb3;
    JPanel jp1, jp2, jp3;

    public selectOP() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jb1 = new JButton("仓储总表");
        jb2 = new JButton("进出情况");
        jb3 = new JButton("返回");

        jl = new JLabel("请选择");

        jp1.add(jl);

        jp2.add(jb1);
        jp2.add(jb2);

        jp3.add(jb3);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setLayout(new GridLayout(3, 1));
        this.setTitle("Revise");
        this.setSize(300, 150);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src/main/java/org/StoreManage/icon/Print.png");
        this.setIconImage(icon.getImage());

    }

    public static void main(String[] args) {
        new selectOP().selectOP_init();
    }

    public void selectOP_init() {
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectOP.super.dispose();
            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new unitOP().unitOP_init();
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new detailOP().detailOP_init();
            }
        });
    }
}
