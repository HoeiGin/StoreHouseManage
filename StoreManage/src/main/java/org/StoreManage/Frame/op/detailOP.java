package org.StoreManage.Frame.op;



import org.StoreManage.Operate;
import org.StoreManage.detail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class detailOP extends JFrame {
    JTextArea jta;
    JPanel jp1, jp2;
    JButton jb;

    private static String detSHOW(List<detail> aList) {
        String det = "";
        for (detail i: aList) {
            String hInfo = "" + i.getID() + '\t' +
                                i.getName() + '\t' +
                                i.getDate() + '\t' +
                                i.getType() + '\t' +
                                i.getQuan() + '\t' +
                                i.getNote() + '\n';
            det += hInfo;
        }
        return det;
    }

    public detailOP() {
        jp1 = new JPanel();
        jp2 = new JPanel();

        jb = new JButton("返回");
        jta = new JTextArea(40, 60);
        jta.setEditable(false);

        JScrollPane jsp = new JScrollPane(jta);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jp1.add(jsp);
        jp2.add(jb);

        this.add(jp1);
        this.add(jp2);
        this.setLayout(new FlowLayout());
        this.setTitle("进出情况");
        this.setSize(800, 700);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = this.getSize();
        this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
        this.setVisible(true);
        this.setResizable(false);

        List<detail> toPrint = Operate.moreInfo();
        String header = "物品编码 \t 物品名称 \t 操作日期 \t 操作类型 \t 物品数量 \t 物品注释\n" + "----------------------------------------------------------";
        header += "---------------------------------------------------------------------------------\n";
        String toShow = header + detSHOW(toPrint);
        jta.setText(toShow);

        ImageIcon icon = new ImageIcon("src/main/java/org/StoreManage/icon/Print.png");
        this.setIconImage(icon.getImage());
    }

    public void detailOP_init() {
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                detailOP.super.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new detailOP().detailOP_init();
    }
}
