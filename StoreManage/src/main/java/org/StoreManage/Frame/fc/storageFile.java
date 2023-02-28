package org.StoreManage.Frame.fc;

import org.StoreManage.Operate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class storageFile extends JFrame {
    JFileChooser jfc;
    String path;

    String suc = "导出成功！";
    String unsuc = "导出失败！";
    public storageFile() {
        jfc = new JFileChooser();
        jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        Component parent = null;
        int returnVal = jfc.showSaveDialog(parent);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            path = jfc.getSelectedFile().getPath();
//            System.out.println(path);
        }

        if (Operate.ExStorage(path)) {
            Tips(suc);
        }
        else {
            Tips(unsuc);
        }

    }

    public void Tips(String info) {
        JFrame jfm = new JFrame();
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();
        JLabel jl = new JLabel(info);
        JButton jb = new JButton("了解");

        jp1.add(jl);
        jp2.add(jb);
        jfm.add(jp1);
        jfm.add(jp2);

        jfm.setLayout(new GridLayout(2, 1));
        jfm.setBounds(100, 100, 320, 120);
        jfm.setTitle(info);
        jfm.setVisible(true);
        jfm.setResizable(false);
        Dimension SmallscreenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension SmallframeSize = jfm.getSize();
        jfm.setLocation((SmallscreenSize.width - SmallframeSize.width) / 2, (SmallscreenSize.height - SmallframeSize.height) / 2);
        ImageIcon icon = new ImageIcon("src/main/java/org/StoreManage/icon/Tips.png");
        jfm.setIconImage(icon.getImage());
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jfm.dispose();
            }
        });
    }

    public static void main(String[] args) {
        new storageFile();
    }

}
