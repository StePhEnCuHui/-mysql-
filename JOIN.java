package KS;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JOIN {
    public static Connection conn = Data.getConn();
    public static Statement st = null;
    public static ResultSet rs = null;
    public JFrame joinF = new JFrame("请登录");
    public static void main(String[] args) {
        JOIN join = new JOIN();
        join.joinF.setBounds(0, 0, 500, 300);
        join.joinF.setLocationRelativeTo(null);
        join.joinF.setLayout(null);
        join.joinF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel lab_1 = new JLabel("账号：");
        lab_1.setBounds(100, 50, 100, 50);
        lab_1.setFont(new Font("宋体", 1, 20));
        JLabel lab_2 = new JLabel("密码：");
        lab_2.setBounds(100, 100, 100, 50);
        lab_2.setFont(new Font("宋体", 1, 20));

        JTextField txt_1 = new JTextField();
        txt_1.setBounds(180, 50, 200, 40);
        JPasswordField txt_2 = new JPasswordField();
        txt_2.setBounds(180, 100, 200, 40);


        JButton btn_1 = new JButton("登录");

        btn_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txt_1.getText();
                String pass = txt_2.getText();
                String sql = "select * from users";
                //System.out.println("点击了登录");
                try {
                    Statement stmt = conn.createStatement();
                    ResultSet rs_id = stmt.executeQuery(sql);
                    int a = 0;
                    while (rs_id.next()) {
                        //通过字段检索

                        String id = rs_id.getString("id");
                        String pas = rs_id.getString("password");
//                        System.out.println(id + pas);
//                        System.out.println(user + pass);
                        if (user.equals(id) && pass.equals(pas)) {
                            a = 1;
                            System.out.println("登陆成功");
                            JOptionPane.showMessageDialog(null, "欢迎使用！", "欢迎", JOptionPane.OK_CANCEL_OPTION);
                            MAIN m = new MAIN();
                            join.joinF.dispose();
                            m.build();
                            break;
                        }
                        else {
                            System.out.println("用户名或密码错误");

                            a = 0;
                            continue;
                        }
                    }
                    if (a == 0) {
                        JOptionPane.showMessageDialog(null, "用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (Exception e01) {
                    e01.printStackTrace();
                }
            }
        });

        btn_1.setBounds(50, 180, 100, 50);
        JButton btn_2 = new JButton("注册");
        btn_2.setBounds(200, 180, 100, 50);
        btn_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NEWUSER n = new NEWUSER();
                join.joinF.dispose();
                n.build();
            }
        });


        JButton btn_3 = new JButton("退出");
        btn_3.setBounds(350, 180, 100, 50);
        btn_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                join.joinF.dispose();
            }
        });

        join.joinF.add(lab_1);
        join.joinF.add(lab_2);
        join.joinF.add(txt_1);
        join.joinF.add(txt_2);
        join.joinF.add(btn_1);
        join.joinF.add(btn_2);
        join.joinF.add(btn_3);

        join.joinF.setResizable(false);
        join.joinF.setVisible(true);
    }
}
