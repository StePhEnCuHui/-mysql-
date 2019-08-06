package KS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JXLGL {
    static private JTextField txt_1 = new JTextField();
    static private JTextField txt_2 = new JTextField();
    static private MAIN ma = new MAIN();
    public static  JFrame mf = new JFrame("教学楼管理");

    private Connection conn = Data.getConn();
    private Statement st;
    private ResultSet rs = null;
    private Object [][]data=null;
    private static String[] column = {"教学楼编号", "教学楼名称"};

    public void printData(JTable table) {
        //Connection conn = Data.getConn();
        int row = table.getSelectedRow();
        int col = table.getSelectedColumn();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        String bh = (String)model.getValueAt(row, 0);
        String a = model.getColumnName(col);//

//        System.out.println(model.getValueAt(row, col) + "" + a + "" + bh);
        System.out.println(bh);
        String sql = "update jxl set jxlbh = '" + txt_1.getText() + "', jxlmc = '" + txt_2.getText() + "' where jxlbh = '" + bh + "'";
        try {
            //ps = conn.prepareStatement(sql);
            st = conn.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "修改成功", "修改", JOptionPane.OK_CANCEL_OPTION);
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        finally {
            closeServ(st, rs);
        }
    }

    public String[] getData(JTable table) {
        //Connection conn = Data.getConn();
        int row = table.getSelectedRow();
        int col = table.getSelectedColumn();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        String bh = (String)model.getValueAt(row, 0);
        String mc = (String)model.getValueAt(row, 1);
        String a = model.getColumnName(col);//
        System.out.println(model.getValueAt(row, col) + "" + a + "" + bh);
        System.out.println(bh);
        String[] bhmc = {bh, mc};
        return bhmc;
    }

    public java.util.List<JXL> queryALLjxl() {

        String sql = "select * from jxl";
        List<JXL> list = new ArrayList<JXL>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            System.out.println(st.toString());
            while(rs.next()) {
                JXL newJXL = new JXL();
                newJXL.setJXLBH(rs.getString(1));
                newJXL.setJXLMC(rs.getString(2));
                list.add(newJXL);
            }
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        finally {
            closeServ(st, rs);
        }
        return list;
    }

    public Object[][] querywkData() {
        List<JXL> list = this.queryALLjxl();
        data = new Object[list.size()][column.length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j <column.length; j++) {
                data[i][0] = list.get(i).getJXLBH();
                data[i][1] = list.get(i).getJXLMC();
            }
        }
        return data;
    }

    public static void closeServ(Statement p, ResultSet r) {
        try {
            p.close();
            r.close();
        }
        catch (SQLException sq) {
            sq.printStackTrace();
        }
    }

    public void insertData(JTable table) {
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        String sql = "insert into jxl values('" + txt_1.getText() + "', '" + txt_2.getText() + "')";
        try {
            st = conn.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "添加成功", "添加", JOptionPane.OK_CANCEL_OPTION);
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        finally {
            closeServ(st, rs);
        }
    }

    public void deleteData(JTable table) {
        int row = table.getSelectedRow();
        int col = table.getSelectedColumn();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        String bh = (String)model.getValueAt(row, 0);
        String a = model.getColumnName(col);//

//        System.out.println(model.getValueAt(row, col) + "" + a + "" + bh);
        System.out.println(bh);
        String sql = "delete from JXL where jxlbh = '" + bh + "'";
        try {
            //ps = conn.prepareStatement(sql);
            st = conn.createStatement();
            st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "删除成功", "删除", JOptionPane.OK_CANCEL_OPTION);
        }
        catch (SQLException se) {
            se.printStackTrace();
        }
        finally {
            closeServ(st, rs);
        }
    }

    public void build() {
        mf.setBounds(0, 0, 500, 600);
        mf.setLocationRelativeTo(null);
        mf.setLayout(null);
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel lab_1 = new JLabel("教学楼编号：");
        lab_1.setBounds(30, 20, 150, 30);
        lab_1.setFont(new Font("宋体", 1, 20));
        JLabel lab_2 = new JLabel("教学楼名称：");
        lab_2.setBounds(30, 60, 150, 30);
        lab_2.setFont(new Font("宋体", 1, 20));
        txt_1.setBounds(170,15,290,40);
        txt_1.setFont(new Font("楷体", Font.PLAIN, 30));
        txt_2.setBounds(170,60,290,40);
        txt_2.setFont(new Font("楷体", Font.PLAIN, 30));
        //DefaultTableModel dtModel = new DefaultTableModel();
        //dtModel.setColumnIdentifiers(new Object[]{"教学楼编号", "教学楼名称"});
        JXLGL jxl = new JXLGL();
        JButton btn_3 = new JButton("查询所有教学楼");
        btn_3.setBounds(50, 110, 400, 40);


        JTable dt_1 = new JTable();
        dt_1.setRowHeight(50);

        DefaultTableModel tableModel=new DefaultTableModel(jxl.querywkData(), column){
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        dt_1.setModel(tableModel);

//        String[] Row_1 = {"01", "第一教学楼"};
//        dtModel.addRow(Row_1);

        dt_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String[] BHMC = jxl.getData(dt_1);
                txt_1.setText(BHMC[0]);
                txt_2.setText(BHMC[1]);
            }
        });

        JScrollPane scroll = new JScrollPane(dt_1);
        mf.add(scroll);
        scroll.setBounds(50, 170, 400, 300);
        btn_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel = new DefaultTableModel(jxl.querywkData(), column) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                dt_1.setModel(tableModel);
            }
        });
        JButton btn_1 = new JButton("修改");
        btn_1.setBounds(50, 490, 90, 50);

        btn_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jxl.printData(dt_1);
            }
        });

        JButton btn_2 = new JButton("添加");
        btn_2.setBounds(250, 490, 90, 50);

        btn_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jxl.insertData(dt_1);
            }
        });

        JButton btn_4 = new JButton("删除该行");
        btn_4.setBounds(150, 490, 90, 50);

        btn_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jxl.deleteData(dt_1);
            }
        });

        JButton btn_5 = new JButton("返回");
        btn_5.setBounds(350, 490, 90, 50);
        btn_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.dispose();
                ma.mf.setVisible(true);
            }
        });

        mf.add(lab_1);
        mf.add(lab_2);
        mf.add(txt_1);
        mf.add(txt_2);
        mf.add(btn_1);
        mf.add(btn_2);
        mf.add(btn_3);
        mf.add(btn_4);
        mf.add(btn_5);
        mf.setResizable(false);
        mf.setVisible(true);
    }
}
