package org.StoreManage.Frame;

import org.StoreManage.Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Entrance extends JFrame {
    JPanel jp1, jp2, jp3, jp;
    JLabel jlb1, jlb2, jl1, jl2;
    JButton jb1, jb3;
    JTextField jtf1;
    JPasswordField jpf1;

    public static void main(String[] args) {
        Entrance ent = new Entrance();
        ent.Entrance_init();
    }

    public Entrance() {
        jp = new JPanel();
        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jl1 = new JLabel(new ImageIcon("src/main/java/org/StoreManage/icon/Menu.png"));
        jl2 = new JLabel(new ImageIcon("src/main/java/org/StoreManage/icon/Software.png"));

        ImageIcon icon = new ImageIcon("src/main/java/org/StoreManage/icon/Menu.png");
        this.setIconImage(icon.getImage());


        jlb1 = new JLabel("用户名");
        jlb1.setSize(100, 25);
        jlb2 = new JLabel("密码    ");
        jlb2.setSize(100, 25);

        jb1 = new JButton("登录");

        // jb2 = new JButton("Sign");
        jb3 = new JButton("退出");

        jtf1 = new JTextField(15);
        jpf1 = new JPasswordField(15);
        this.setLayout(new GridLayout(3, 1));
        jpf1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if ((char) e.getKeyChar() == KeyEvent.VK_ENTER) {
                    String uName = jtf1.getText();
                    char[] passArray = jpf1.getPassword();
                    String uPass = "";
                    for (char i: passArray) {
                        uPass += i;
                    }
                    System.out.println(uName + "\t" + uPass);
                    if (Login.toLogin(uName, uPass)) {
                        new newMenu().newMenu_init();
                        Entrance.super.dispose();
                    }
                    else {
                        Failed();
                    }
                }
            }
        });

        jp.add(jl1);
        jp.add(jl2);
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jpf1);

        jp3.add(jb1);
        // jp3.add(jb2);
        jp3.add(jb3);

        this.add(jp);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setLayout(new FlowLayout());

        this.setSize(350, 300);
        this.setTitle("欢迎登录仓储管理系统");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
    }

    public void Failed() {
        Frame Failed = new JFrame();
        JPanel jp1, jp2;
        JLabel jt;
        JButton jb;

        jt = new JLabel("登陆失败！请重试！");
        jp1 = new JPanel();
        jp2 = new JPanel();
        jb = new JButton("了解");

        jp1.add(jt);
        jp2.add(jb);
        Failed.add(jp1);
        Failed.add(jp2);
        Failed.setLayout(new GridLayout(2, 1));

        Failed.setBounds(100, 100, 300, 120);
        Failed.setLocationRelativeTo(null);
        Failed.setVisible(true);
        Failed.setResizable(false);
        Failed.setTitle("操作失败");
        ImageIcon icon = new ImageIcon("src/main/java/org/StoreManage/icon/Failed.png");
        Failed.setIconImage(icon.getImage());

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Failed.dispose();
            }
        });

    }

    public void Entrance_init() {
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uName = jtf1.getText();
                char[] passArray = jpf1.getPassword();
                String uPass = "";
                for (char i: passArray) {
                    uPass += i;
                }
                System.out.println(uName + "\t" + uPass);
                if (Login.toLogin(uName, uPass)) {
                    new newMenu().newMenu_init();
                    Entrance.super.dispose();
                }
                else {
                    Failed();
                }
            }
        });
    }
}
