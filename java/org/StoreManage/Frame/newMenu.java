package org.StoreManage.Frame;

import org.StoreManage.Frame.fc.choice;
import org.StoreManage.Frame.op.selectOP;
import org.StoreManage.Frame.rev.REVISE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class newMenu extends JFrame {
    JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8;
    JLabel z1, z2, z3, z4, z5, z6, z7, z8;
    JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8, jp9, jp;
    JTextArea jta;
    String ori = "欢迎登录仓储管理系统";

    public newMenu() {
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();
        jp6 = new JPanel();
        jp7 = new JPanel();
        jp8 = new JPanel();
        jp9 = new JPanel();

        Font font = new Font("黑体", Font.PLAIN, 18);

        ImageIcon ico1 = new ImageIcon("src/main/java/org/StoreManage/icon/addData.png");
        z1 = new JLabel(ico1);
        jl1 = new JLabel("新增数据");
        jl1.setFont(font);

        ImageIcon ico2 = new ImageIcon("src/main/java/org/StoreManage/icon/printAllTheData.png");
        z2 = new JLabel(ico2);
        jl2 = new JLabel("展示数据");
        jl2.setFont(font);


        ImageIcon ico3 = new ImageIcon("src/main/java/org/StoreManage/icon/operateTheData.png");
        z3 = new JLabel(ico3);
        jl3 = new JLabel("进出管理");
        jl3.setFont(font);


        ImageIcon ico4 = new ImageIcon("src/main/java/org/StoreManage/icon/deleteTheData.png");
        z4 = new JLabel(ico4);
        jl4 = new JLabel("删除数据");
        jl4.setFont(font);


        ImageIcon ico5 = new ImageIcon("src/main/java/org/StoreManage/icon/remainOfTheData.png");
        z5 = new JLabel(ico5);
        jl5 = new JLabel("仓储数据");
        jl5.setFont(font);

        ImageIcon ico6 = new ImageIcon("src/main/java/org/StoreManage/icon/exportTheFile.png");
        z6 = new JLabel(ico6);
        jl6 = new JLabel("导出数据");
        jl6.setFont(font);

        ImageIcon ico7 = new ImageIcon("src/main/java/org/StoreManage/icon/logoutFromTheSystem.png");
        z7 = new JLabel(ico7);
        jl7 = new JLabel("退出登录");
        jl7.setFont(font);

        ImageIcon ico8 = new ImageIcon("src/main/java/org/StoreManage/icon/exit.png");
        z8 = new JLabel(ico8);
        jl8 = new JLabel("退出系统");
        jl8.setFont(font);

        Color w = new Color(0x0000000, true);
        jta = new JTextArea(ori);

        jta.setEditable(false);
        jta.setBackground(w);

        jp1.add(z1);
        jp1.add(jl1);
        jp2.add(z2);
        jp2.add(jl2);
        jp3.add(z3);
        jp3.add(jl3);
        jp4.add(z4);
        jp4.add(jl4);
        jp5.add(z5);
        jp5.add(jl5);
        jp6.add(z6);
        jp6.add(jl6);
        jp7.add(z7);
        jp7.add(jl7);
        jp8.add(z8);
        jp8.add(jl8);

        jp9.add(jta);

        // 新增的内容
        jp = new JPanel();
        jp.add(jp1);
        jp.add(jp2);
        jp.add(jp3);
        jp.add(jp4);
        jp.add(jp5);
        jp.add(jp6);
        jp.add(jp7);
        jp.add(jp8);
        jp.setLayout(new GridLayout(4, 2));

        /*
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);
        this.add(jp6);
        this.add(jp7);
        this.add(jp8);

         */
        this.add(jp);
        this.add(jp9, BorderLayout.SOUTH);

        // this.setLayout(new GridLayout(5, 2));
        this.setTitle("仓储管理系统");
        this.setSize(400, 500);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("src/main/java/org/StoreManage/icon/Menu.png");
        this.setIconImage(icon.getImage());




    }

    public void newMenu_init() {
        z1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ADD().ADD_init();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jta.setText("");
                jta.setText("向仓库中增加新的物品");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jta.setText("");
                jta.setText(ori);
            }
        });

        z2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new selectOP().selectOP_init();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jta.setText("");
                jta.setText("展示仓库进出记录或仓库物品列表");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jta.setText("");
                jta.setText(ori);
            }
        });

        z3.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new REVISE().REVISE_init();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jta.setText("");
                jta.setText("修改仓库物品，包括进货和出货");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jta.setText("");
                jta.setText(ori);
            }
        });

        z4.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new DELETE().DELETE_init();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jta.setText("");
                jta.setText("删除仓库内不需要的物品（仅删除物品，记录不会删除）");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jta.setText("");
                jta.setText(ori);
            }
        });

        z5.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new REMAIN().REMAIN_init();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jta.setText("");
                jta.setText("查看仓库内各商品的占比情况");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jta.setText("");
                jta.setText(ori);
            }
        });

        z6.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new choice().choice_init();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jta.setText("");
                jta.setText("导出仓储进出记录数据或仓库物品数据");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jta.setText("");
                jta.setText(ori);
            }
        });

        z7.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Entrance().Entrance_init();
                newMenu.super.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jta.setText("");
                jta.setText("退出系统，返回登录界面");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jta.setText("");
                jta.setText(ori);
            }
        });

        z8.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jta.setText("");
                jta.setText("退出系统");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jta.setText("");
                jta.setText(ori);
            }
        });
    }

    public static void main(String[] args) {
        new newMenu().newMenu_init();
    }
}
