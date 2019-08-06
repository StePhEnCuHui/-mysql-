package KS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class GUIdemo {
    private static String username = "root";
    private static String password = "lmh12358";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/TestDatabase?useSSL=false&serverTimezone=UTC";

    public static Connection getConn () {
        try {
            Connection conn = null;
            //注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库......");
            //连接数据库
            conn = DriverManager.getConnection(DB_URL, username, password);
            return conn;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet Select (Statement stmt, String sql) {
        //查询
        try {
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        try {
            conn = getConn();
            if (conn != null) {
                System.out.println("连接成功！");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        JFrame f = new JFrame();
        JPanel pal_1 = new JPanel();
        JPanel pal_2 = new JPanel();
        JPanel pal_3 = new JPanel();
        JTextField txt_1 = new JTextField(30);
        JTextField txt_2 = new JTextField(30);
        JButton btn_1 = new JButton("注册");
        JButton btn_2 = new JButton("登录");
        JButton btn_3 = new JButton("取消");
        JLabel lab_1 = new JLabel("登录|欢迎使用");

        f.setTitle("欢迎使用");
        //设置主窗体大小
        f.setSize(350, 400);
        //设置主窗体出现在屏幕的位置
        f.setLocationRelativeTo(null);
        //关闭窗体
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗体是否可见
        f.setVisible(true);
        //设置主窗体布局为东南西北布局
        f.setLayout(new BorderLayout(2, 4));
        //设置 panel 的布局格式
        pal_3.setLayout(new FlowLayout());
        pal_1.setLayout(new GridLayout(5, 1));
        f.add(pal_2, BorderLayout.NORTH);
        pal_2.add(lab_1);
        f.add(pal_1, BorderLayout.CENTER);
        pal_1.add(txt_1);
        pal_1.add(txt_2);
        f.add(pal_3, BorderLayout.SOUTH);
        pal_3.add(btn_1);
        pal_3.add(btn_2);
        pal_3.add(btn_3);
        //添加监听事件
        btn_2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String user = txt_1.getText();
                    String pass = txt_2.getText();
                    System.out.println("点击了登录");
                    try {
                        Connection conn = getConn();
                        Statement stmt = conn.createStatement();
                        ResultSet rs_id = Select(stmt, "select * from users");
                        while (rs_id.next()) {
                            //通过字段检索
                            String id = rs_id.getString("id");
                            String pas = rs_id.getString("password");
                            System.out.println(id + pas);
                            System.out.println(user + pass);
                            if (user.equals(id) && pass.equals(pas)) {
                                System.out.println("登陆成功");
                                JOptionPane.showMessageDialog(null, "欢迎使用！", "欢迎", JOptionPane.OK_CANCEL_OPTION);
                                MAIN m = new MAIN();
                                f.dispose();
                                m.build();
                                break;
                            }

                            else {
                                System.out.println("用户名或密码错误");
                                JOptionPane.showMessageDialog(null, "用户名或密码错误", "错误", JOptionPane.ERROR_MESSAGE);
                                continue;
                            }
                        }
                    }
                    catch (Exception e01) {
                        e01.printStackTrace();
                    }
                }
        });
    }
}