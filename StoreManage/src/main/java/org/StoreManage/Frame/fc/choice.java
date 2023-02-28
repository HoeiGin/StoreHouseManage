package org.StoreManage.Frame.fc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class choice extends JFrame {
    JButton jb1, jb2, jb;
    JPanel jp1, jp2;

    public choice() {
        jb1 = new JButton("仓储总表");
        jb2 = new JButton("进出情况");
        jb = new JButton("返回");

        jp1 = new JPanel();
        jp2 = new JPanel();

        jp1.add(jb1);
        jp1.add(jb2);
        jp2.add(jb);

        this.add(jp1);
        this.add(jp2);

        this.setLayout(new GridLayout(2, 1));
        this.setSize(300, 150);
        this.setTitle("导出项");
        this.setVisible(true);
        this.setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

        ImageIcon icon = new ImageIcon("src/main/java/org/StoreManage/icon/Revise.png");
        this.setIconImage(icon.getImage());
    }

    public static void main(String[] args) {
        new choice().choice_init();
    }

    public void choice_init() {
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice.super.dispose();
//                new Menu().Menu_Init();
            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new storageFile();
            }
        });

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new detailFile();
            }
        });
    }
}
