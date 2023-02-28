package org.StoreManage.Frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Warning extends JFrame {
    public Warning(String text) {
        Frame Failed = new JFrame();
        JPanel jp1, jp2;
        JLabel jt;
        JButton jb;

        jt = new JLabel(text);
        jp1 = new JPanel();
        jp2 = new JPanel();
        jb = new JButton("了解");

        jp1.add(jt);
        jp2.add(jb);
        Failed.add(jp1);
        Failed.add(jp2);
        Failed.setLayout(new GridLayout(2, 1));

        Failed.setBounds(100, 100, 320, 120);
        Failed.setLocationRelativeTo(null);
        Failed.setVisible(true);

        Failed.setResizable(false);

        ImageIcon icon = new ImageIcon("src/main/java/org/StoreManage/icon/Failed.png");
        this.setIconImage(icon.getImage());

        Failed.setTitle("操作失败");
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Failed.dispose();
            }
        });
    }
}
