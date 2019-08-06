package KS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SJGL {
    public static Connection conn = Data.getConn();
    private Statement st;
    private ResultSet rs = null;
    public static JTextField txt_1 = new JTextField();
    public static JTextField txt_2 = new JTextField();
    public static String nowButton;
    static private MAIN ma = new MAIN();

    public static void closeServ(Statement p, ResultSet r) {
        try {
            p.close();
            r.close();
        }
        catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

    public static void build() {
        SJGL sj = new SJGL();
        JFrame f = new JFrame("课节时间信息管理");
        f.setBounds(0, 0, 500, 600);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton btn_1 = new JButton("第一大节");
        btn_1.setBounds(100, 50, 100, 50);
        btn_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from sj where kj = '" + btn_1.getText() + "'";
                //System.out.println(sql);
                String kssj;
                String jssj;
                try {
                    sj.st = conn.createStatement();
                    sj.rs = sj.st.executeQuery(sql);
                    while (sj.rs.next()) {
                        kssj = sj.rs.getString("kssj");
                        jssj = sj.rs.getString("jssj");
                        txt_1.setText(kssj);
                        txt_2.setText(jssj);
                        nowButton = btn_1.getText();
                    }
                }
                catch (SQLException se) {
                    se.printStackTrace();
                }
                finally {
                    closeServ(sj.st, sj.rs);
                }
            }
        });
        JButton btn_2 = new JButton("第二大节");
        btn_2.setBounds(200, 50, 100, 50);
        btn_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from sj where kj = '" + btn_2.getText() + "'";
                String kssj;
                String jssj;
                try {
                    sj.st = conn.createStatement();
                    sj.rs = sj.st.executeQuery(sql);
                    while (sj.rs.next()) {
                        kssj = sj.rs.getString("kssj");
                        jssj = sj.rs.getString("jssj");
                        txt_1.setText(kssj);
                        txt_2.setText(jssj);
                        nowButton = btn_2.getText();
                    }
                }
                catch (SQLException se) {
                    se.printStackTrace();
                }
                finally {
                    closeServ(sj.st, sj.rs);
                }
            }
        });
        JButton btn_3 = new JButton("第三大节");
        btn_3.setBounds(300, 50, 100, 50);
        btn_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from sj where kj = '" + btn_3.getText() + "'";
                String kssj;
                String jssj;
                try {
                    sj.st = conn.createStatement();
                    sj.rs = sj.st.executeQuery(sql);
                    while (sj.rs.next()) {
                        kssj = sj.rs.getString("kssj");
                        jssj = sj.rs.getString("jssj");
                        txt_1.setText(kssj);
                        txt_2.setText(jssj);
                        nowButton = btn_3.getText();
                    }
                }
                catch (SQLException se) {
                    se.printStackTrace();
                }
                finally {
                    closeServ(sj.st, sj.rs);
                }
            }
        });
        JButton btn_4 = new JButton("第四大节");
        btn_4.setBounds(100, 100, 100, 50);
        btn_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from sj where kj = '" + btn_4.getText() + "'";
                String kssj;
                String jssj;
                try {
                    sj.st = conn.createStatement();
                    sj.rs = sj.st.executeQuery(sql);
                    while (sj.rs.next()) {
                        kssj = sj.rs.getString("kssj");
                        jssj = sj.rs.getString("jssj");
                        txt_1.setText(kssj);
                        txt_2.setText(jssj);
                        nowButton = btn_4.getText();
                    }
                }
                catch (SQLException se) {
                    se.printStackTrace();
                }
                finally {
                    closeServ(sj.st, sj.rs);
                }
            }
        });
        JButton btn_5 = new JButton("第五大节");
        btn_5.setBounds(200, 100, 100, 50);
        btn_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from sj where kj = '" + btn_5.getText() + "'";
                String kssj;
                String jssj;
                try {
                    sj.st = conn.createStatement();
                    sj.rs = sj.st.executeQuery(sql);
                    while (sj.rs.next()) {
                        kssj = sj.rs.getString("kssj");
                        jssj = sj.rs.getString("jssj");
                        txt_1.setText(kssj);
                        txt_2.setText(jssj);
                        nowButton = btn_5.getText();
                    }
                }
                catch (SQLException se) {
                    se.printStackTrace();
                }
                finally {
                    closeServ(sj.st, sj.rs);
                }
            }
        });
        JButton btn_6 = new JButton("第六大节");
        btn_6.setBounds(300, 100, 100, 50);
        btn_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "select * from sj where kj = '" + btn_6.getText() + "'";
                String kssj;
                String jssj;
                try {
                    sj.st = conn.createStatement();
                    sj.rs = sj.st.executeQuery(sql);
                    while (sj.rs.next()) {
                        kssj = sj.rs.getString("kssj");
                        jssj = sj.rs.getString("jssj");
                        txt_1.setText(kssj);
                        txt_2.setText(jssj);
                        nowButton = btn_6.getText();
                    }
                }
                catch (SQLException se) {
                    se.printStackTrace();
                }
                finally {
                    closeServ(sj.st, sj.rs);
                }
            }
        });
        JLabel lab_1 = new JLabel("上课时间：");
        lab_1.setBounds(50, 220, 100, 50);
        JLabel lab_2 = new JLabel("下课时间：");
        lab_2.setBounds(50, 310, 100, 50);

        txt_1.setBounds(130, 220, 320, 50);

        txt_2.setBounds(130, 310, 320, 50);
        JButton btn_7 = new JButton("修改");
        btn_7.setBounds(100, 450, 100, 50);

        btn_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "update sj set kssj = '" + txt_1.getText() + "', jssj = '" + txt_2.getText() + "' where kj = '" + nowButton + "'";
                try {
                    //ps = conn.prepareStatement(sql);
                    sj.st = conn.createStatement();
                    sj.st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "修改成功", "修改", JOptionPane.OK_CANCEL_OPTION);
                }
                catch (SQLException se) {
                    se.printStackTrace();
                }
                finally {
                    closeServ(sj.st, sj.rs);
                }
            }
        });

        JButton btn_8 = new JButton("返回");
        btn_8.setBounds(300, 450, 100, 50);

        btn_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                ma.mf.setVisible(true);
            }
        });

        f.add(btn_1);
        f.add(btn_2);
        f.add(btn_3);
        f.add(btn_4);
        f.add(btn_5);
        f.add(btn_6);
        f.add(lab_1);
        f.add(lab_2);
        f.add(txt_1);
        f.add(txt_2);
        f.add(btn_7);
        f.add(btn_8);
        f.setResizable(false);
        f.setVisible(true);
    }
}
