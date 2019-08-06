package KS;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MAIN {
    private JSselect jss = new JSselect();
    private String[] column = {"教室编号", "教学楼名称", "课节", "是否使用", "可容纳人数"};
    private Object [][]data=null;
    static private JTextField txt_1 = new JTextField();
    static private JTextField txt_2 = new JTextField();
    public static  JFrame mf = new JFrame("管理系统");
    public static JXLGL jxlgl = new JXLGL();
    public static SJGL sjgl = new SJGL();
    public static bjjsxx js = new bjjsxx();

    public Object[][] queryjxlykData() {
        List<JS> list = jss.queryALLjxlykjs(txt_1.getText());
        data = new Object[list.size()][column.length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j <column.length; j++) {
                data[i][0] = list.get(i).getJSBH();
                data[i][1] = list.get(i).getJXLBH();
                data[i][2] = list.get(i).getKJ();
                data[i][3] = list.get(i).getSFSY();
                data[i][4] = list.get(i).getRNRS();
            }
        }
        return data;
    }

    public Object[][] queryjxlwkData() {
        List<JS> list = jss.queryALLjxlwkjs(txt_1.getText());
        data = new Object[list.size()][column.length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j <column.length; j++) {
                data[i][0] = list.get(i).getJSBH();
                data[i][1] = list.get(i).getJXLBH();
                data[i][2] = list.get(i).getKJ();
                data[i][3] = list.get(i).getSFSY();
                data[i][4] = list.get(i).getRNRS();
            }
        }
        return data;
    }

    public Object[][] querykjykData() {
        List<JS> list = jss.queryALLkjykjs(txt_2.getText());
        data = new Object[list.size()][column.length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j <column.length; j++) {
                data[i][0] = list.get(i).getJSBH();
                data[i][1] = list.get(i).getJXLBH();
                data[i][2] = list.get(i).getKJ();
                data[i][3] = list.get(i).getSFSY();
                data[i][4] = list.get(i).getRNRS();
            }
        }
        return data;
    }

    public Object[][] querykjwkData() {
        List<JS> list = jss.queryALLkjwkjs(txt_2.getText());
        data = new Object[list.size()][column.length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j <column.length; j++) {
                data[i][0] = list.get(i).getJSBH();
                data[i][1] = list.get(i).getJXLBH();
                data[i][2] = list.get(i).getKJ();
                data[i][3] = list.get(i).getSFSY();
                data[i][4] = list.get(i).getRNRS();
            }
        }
        return data;
    }

    public Object[][] querywkData() {
        List<JS> list = jss.queryALLwkjs();
        data = new Object[list.size()][column.length];
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j <column.length; j++) {
                data[i][0] = list.get(i).getJSBH();
                data[i][1] = list.get(i).getJXLBH();
                data[i][2] = list.get(i).getKJ();
                data[i][3] = list.get(i).getSFSY();
                data[i][4] = list.get(i).getRNRS();
            }
        }
        return data;
    }

    public void build() {

        mf.setBounds(0, 0, 1500, 800);
        mf.setLocationRelativeTo(null);
        mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mf.setLayout(null);
        JPanel Top = new JPanel();
        Top.setLayout(null);
        Top.setBounds(0, 0, 1500, 150);
        //Top.setBackground(Color.GRAY);
        mf.add(Top);
        JLabel lab_1 = new JLabel("按教学楼编号查找:");
        lab_1.setFont(new Font("宋体", 1, 15));
        lab_1.setBounds(10, 10, 150,60);
        JLabel lab_2 = new JLabel("按时间段查找:");
        lab_2.setFont(new Font("宋体", 1, 15));
        lab_2.setBounds(40, 75, 150, 60);
        Top.add(lab_1);
        Top.add(lab_2);

        txt_1.setBounds(170, 15, 700, 50);
        txt_1.setFont(new Font("楷体", Font.PLAIN, 30));
        txt_2.setBounds(170, 80, 700, 50);
        txt_2.setFont(new Font("楷体", Font.PLAIN, 30));
        Top.add(txt_1);
        Top.add(txt_2);
        JButton btn_1 = new JButton("查看空教室");
        btn_1.setBounds(900, 15, 150, 50);
        btn_1.setFont(new Font("楷体", Font.BOLD, 20));
        JButton btn_2 = new JButton("查看非空教室");
        btn_2.setBounds(1055, 15, 190, 50);
        btn_2.setFont(new Font("楷体", Font.BOLD, 20));
        JButton btn_3 = new JButton("查看空教室");
        btn_3.setBounds(900, 80, 150, 50);
        btn_3.setFont(new Font("楷体", Font.BOLD, 20));
        JButton btn_4 = new JButton("查看非空教室");
        btn_4.setBounds(1055, 80, 190, 50);
        btn_4.setFont(new Font("楷体", Font.BOLD, 20));
        JButton btn_5 = new JButton("查询所有空教室");
        btn_5.setBounds(1250, 15, 230, 115);
        btn_5.setFont(new Font("楷体", Font.BOLD, 20));
        Top.add(btn_1);
        Top.add(btn_2);
        Top.add(btn_3);
        Top.add(btn_4);
        Top.add(btn_5);
        String[] column = {"教室编号", "教学楼名称", "课节", "是否使用", "可容纳人数"};

        DefaultTableModel dtModel = new DefaultTableModel();
        dtModel.setColumnIdentifiers(new Object[]{"教室编号", "教学楼编号", "课节", "是否使用", "容纳人数"});
        JTable dt_1 = new JTable(dtModel);
        dt_1.setRowHeight(50);
        MAIN m = new MAIN();
        JScrollPane scroll = new JScrollPane(dt_1);
        mf.add(scroll);
        scroll.setBounds(30, 160, 1420, 470);
        btn_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel=new DefaultTableModel(m.queryjxlwkData(), column){
                    public boolean isCellEditable(int row, int column)
                    {
                        return false;
                    }
                };
                dt_1.setModel(tableModel);
            }
        });
        btn_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel=new DefaultTableModel(m.queryjxlykData(), column){
                    public boolean isCellEditable(int row, int column)
                    {
                        return false;
                    }
                };
                dt_1.setModel(tableModel);
            }
        });
        btn_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel=new DefaultTableModel(m.querykjwkData(), column){
                    public boolean isCellEditable(int row, int column)
                    {
                        return false;
                    }
                };
                dt_1.setModel(tableModel);
            }
        });
        btn_4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel=new DefaultTableModel(m.querykjykData(), column){
                    public boolean isCellEditable(int row, int column)
                    {
                        return false;
                    }
                };
                dt_1.setModel(tableModel);
            }
        });
        btn_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel tableModel=new DefaultTableModel(m.querywkData(), column){
                    public boolean isCellEditable(int row, int column)
                    {
                        return false;
                    }
                };
                dt_1.setModel(tableModel);
            }
        });
        JButton btn_6 = new JButton("编辑教室信息");
        btn_6.setFont(new Font("楷体", Font.BOLD, 20));
        btn_6.setBounds(280, 650, 200, 100);

        btn_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.setVisible(false);
                js.jiaoshi();
            }
        });

        JButton btn_7 = new JButton("编辑教学楼信息");
        btn_7.setFont(new Font("楷体", Font.BOLD, 20));
        btn_7.setBounds(530, 650, 200, 100);

        btn_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.setVisible(false);
                jxlgl.build();
            }
        });

        JButton btn_8 = new JButton("编辑时间段信息");
        btn_8.setFont(new Font("楷体", Font.BOLD, 20));
        btn_8.setBounds(780, 650, 200, 100);

        btn_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.setVisible(false);
                sjgl.build();
            }
        });

        JButton btn_9 = new JButton("退出");
        btn_9.setFont(new Font("楷体", Font.BOLD, 20));
        btn_9.setBounds(1030, 650, 200, 100);
        btn_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mf.dispose();
            }
        });
        mf.add(btn_6);
        mf.add(btn_7);
        mf.add(btn_8);
        mf.add(btn_9);
        mf.setResizable(false);
        mf.setVisible(true);
    }
}
