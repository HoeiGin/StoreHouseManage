package org.StoreManage.Frame;



import org.StoreManage.Frame.fc.choice;
import org.StoreManage.Frame.op.selectOP;
import org.StoreManage.Frame.rev.REVISE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {

    JButton add, print, revise, delete, remain, summary, export, exit, logout;
    JPanel jp1, jp2;
    JTextArea jt;

    public Menu() {
        jp1 = new JPanel();
        jp2 = new JPanel();

        add = new JButton("新增");
        add.setToolTipText("向仓库中新增新的物品");
        print = new JButton("展示");
        print.setToolTipText("展示仓库内的所有物品");
        revise = new JButton("操作");
        revise.setToolTipText("对仓库内的物品进行各项操作");
        delete = new JButton("删除");
        delete.setToolTipText("删除仓库内不需要的物品");
        remain = new JButton("盈余");
        remain.setToolTipText("查看商品在仓库中的占比情况");

        export = new JButton("导出");
        export.setToolTipText("将仓库内的物品信息导出至电脑桌面");
        exit = new JButton("退出软件");
        exit.setToolTipText("退出仓储管理系统");
        logout = new JButton("退出登录");
        logout.setToolTipText("退出系统，返回至登录界面");


        jp1.add(add);
        jp1.add(print);
        jp1.add(revise);
        jp1.add(delete);
        jp1.add(remain);
        // jp1.add(summary);
        jp1.add(export);
        jp1.add(exit);
        jp1.add(logout);


        jt = new JTextArea("管理员 admin，您好！");
        jt.setEditable(false);

        this.add(jp1);
        this.add(jt, BorderLayout.SOUTH);

        ImageIcon icon = new ImageIcon("src/main/java/org/StoreManage/icon/Menu.png");
        this.setIconImage(icon.getImage());



        this.setTitle("仓储管理系统");
        this.setSize(715, 125);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();

        // this.setLayout(new GridLayout());

        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Menu().Menu_Init();
    }

    public void Menu_Init() {
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Entrance().Entrance_init();
                Menu.super.dispose();
            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ADD().ADD_init();
            }
        });

        print.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new selectOP().selectOP_init();
            }
        });

        revise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new REVISE().REVISE_init();
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DELETE().DELETE_init();
            }
        });

        remain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new REMAIN().REMAIN_init();
            }
        });

        export.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new choice().choice_init();
            }
        });
    }
}
