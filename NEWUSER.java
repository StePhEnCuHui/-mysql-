package KS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class NEWUSER {
    public static Connection conn = Data.getConn();
    public static Statement st;
    public static ResultSet rs = null;

    public static void closeServ(Statement p, ResultSet r) {
        try {
            p.close();
            r.close();
        }
        catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

    public void build() {
        JFrame f = new JFrame("注册成为新用户");
        f.setBounds(0, 0, 500, 300);
        f.setLocationRelativeTo(null);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label_1 = new JLabel("账号：");
        label_1.setBounds(50, 50, 50, 50);
        JLabel label_2 = new JLabel("密码：");
        label_2.setBounds(50, 100, 50, 50);
        JLabel label_3 = new JLabel("确认：");
        label_3.setBounds(50, 150, 50, 50);

        JTextField txt_1 = new JTextField();
        txt_1.setBounds(100, 60, 200, 30);
        JPasswordField txt_2 = new JPasswordField();
        txt_2.setBounds(100, 110, 200, 30);
        JPasswordField txt_3 = new JPasswordField();
        txt_3.setBounds(100, 160, 200, 30);

        JButton btn_1 = new JButton("注册成为新用户");
        btn_1.setBounds(310, 60, 130, 130);
        btn_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txt_1.getText();
                String pass = txt_2.getText();
                String sql1 = "select * from users";
                String sql = "insert into users values('" + user + "', '" + pass + "')";
                int a = 0;
                try {
                    Statement stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql1);
                    while (rs.next()) {
                        String id = rs.getString("id");
                        String pas = rs.getString("password");
                        if(user.equals(id)) {
                            JOptionPane.showMessageDialog(null, "用户名重复！", "警告", JOptionPane.OK_CANCEL_OPTION);
                            a = 1;
                            break;
                        }
                        else {
                            continue;
                        }
                    }
                    if (txt_2.getText().equals(txt_3.getText())){
                        if (a == 0) {
                            stmt.executeUpdate(sql);
                            System.out.println("添加成功！");
                            JOptionPane.showMessageDialog(null, "注册成功！", "成功", JOptionPane.OK_CANCEL_OPTION);
                            MAIN m = new MAIN();
                            m.build();
                            f.dispose();
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "两次输入的密码不一致！", "警告", JOptionPane.OK_CANCEL_OPTION);
                        a = 1;
                    }
                }
                catch (Exception e01) {
                    e01.printStackTrace();
                }
//                finally {
//                    closeServ(st, rs);
//                }
            }
        });


        f.add(label_1);
        f.add(label_2);
        f.add(label_3);
        f.add(txt_1);
        f.add(txt_2);
        f.add(txt_3);
        f.add(btn_1);
        f.setResizable(false);
        f.setVisible(true);
    }
}
