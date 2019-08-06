package KS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class bjjsxx extends JFrame {

	public static JPanel contentPane;
	public static JTextField JSBHtext;
	public static JTextField JXLBHtext;
	public static JTextField KJtext;
	public static JTextField SFSYtext;
	public static JTextField RNRStext;
	public static JPanel panel_1;
	public static JLabel label_7;
	public static JTextField JSBH_text0;
	public static JTable table;
	public static JTableHeader jth;
	public static JButton button_1;
	public static JButton button_2;
	public static JButton button_3;
	public static JTextField JSBHtext_xiugai;
	public static JTextField RNRStext_xiugai;
	public static JTextField JSBHtext_shanchu;
	public static JTextField KJtext_shanchu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	}
	public static void jiaoshi() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bjjsxx frame = new bjjsxx();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public bjjsxx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
										.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
		);

		label_7 = new JLabel("\u6839\u636E\u6559\u5BA4\u7F16\u53F7\u67E5\u8BE2\u6559\u5BA4\u4FE1\u606F");
		label_7.setForeground(new Color(0, 0, 0));
		label_7.setFont(new Font("宋体", Font.BOLD, 12));

		JSBH_text0 = new JTextField();
		JSBH_text0.setToolTipText("");
		JSBH_text0.setColumns(10);

		JButton button = new JButton("\u67E5\u8BE2");


		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
												.addGap(28)
												.addComponent(label_7)
												.addGap(18)
												.addComponent(JSBH_text0, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(button))
										.addGroup(gl_panel_1.createSequentialGroup()
												.addContainerGap()
												.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)))
								.addGap(15))
		);
		gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
										.addComponent(label_7, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
										.addComponent(JSBH_text0, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(button))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
		);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// 以下是连接数据源和显示数据的具体处理方法，请注意下
				try{
					// 获得连接
					Connection conn = Data.getConn();
					// 建立查询条件
					String sql = "select * from js where JSBH='"+JSBH_text0.getText()+"'";
					// 执行查询
					PreparedStatement pstm = conn.prepareStatement(sql);
					ResultSet rs = pstm.executeQuery();
					// 计算有多少条记录
					int count = 0;
					while(rs.next()){
						count++;
					}
					rs = pstm.executeQuery();
					// 将查询获得的记录数据，转换成适合生成JTable的数据形式
					Object[][] info = new Object[count][5];
					count = 0;
					while(rs.next()){
						info[count][0] = rs.getString("JSBH");
						info[count][1] = rs.getString("JXLBH");
						info[count][2] = rs.getString("KJ");
						info[count][3] = rs.getString("SFSY");
						info[count][4] = rs.getString("RNRS");
						count++;
					}
					// 定义表头
					String[] title = {"JSBH","JXLBH","KJ","SFSY","RNRS"};
					// 创建JTable
					bjjsxx.table = new JTable(info,title);
					// 显示表头
					bjjsxx.jth = bjjsxx.table.getTableHeader();
					scrollPane.setViewportView(table);
				} catch(SQLException sqle){
					JOptionPane.showMessageDialog(null,"数据操作错误","错误",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		panel_1.setLayout(gl_panel_1);

		JLabel lbljsbh = new JLabel("\u6559\u5BA4\u7F16\u53F7_JSBH");
		lbljsbh.setBackground(new Color(255, 255, 255));
		lbljsbh.setFont(new Font("宋体", Font.PLAIN, 15));

		JLabel lbljxlbh = new JLabel("\u6559\u5B66\u697C\u7F16\u53F7_JXLBH");
		lbljxlbh.setFont(new Font("宋体", Font.PLAIN, 15));

		JLabel lblkj = new JLabel("\u8BFE\u8282_KJ");
		lblkj.setFont(new Font("宋体", Font.PLAIN, 15));

		JLabel lblsfsy = new JLabel("\u662F\u5426\u4F7F\u7528_SFSY");
		lblsfsy.setFont(new Font("宋体", Font.PLAIN, 15));

		JLabel lblrnrs = new JLabel("\u5BB9\u7EB3\u4EBA\u6570_RNRS");
		lblrnrs.setFont(new Font("宋体", Font.PLAIN, 15));

		JSBHtext = new JTextField();
		JSBHtext.setToolTipText("");
		JSBHtext.setColumns(10);

		JXLBHtext = new JTextField();
		JXLBHtext.setColumns(10);

		KJtext = new JTextField();
		KJtext.setColumns(10);

		SFSYtext = new JTextField();
		SFSYtext.setColumns(10);

		RNRStext = new JTextField();
		RNRStext.setColumns(10);
		/*
		 * button_1  增加按钮
		 */
		button_1 = new JButton("\u589E\u52A0");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sJSBH=JSBHtext.getText();
				String sJXLBH=JXLBHtext.getText();
				String sKJ=KJtext.getText();
				String sSFSY=SFSYtext.getText();
				String sRNRS=RNRStext.getText();
				// 获得连接
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaks?useSSL=false&serverTimezone=UTC","root","lmh12358");
					// 建立查询条件
					String sql="select * from js where JSBH='"+sJSBH+"' and KJ='"+sKJ+"'";
					PreparedStatement pstm = conn.prepareStatement(sql);
					ResultSet rs = pstm.executeQuery();

					//JSBH,KJ存储查询出来的教室编号和课节
					//count判断是否有匹配结果
					int count=0;
					String JSBH=null;
					String KJ=null;
					while(rs.next()) {
						count++;
						JSBH=rs.getString("JSBH");
						KJ=rs.getString("KJ");
					}

					pstm.close();
					//有相同教室存在  课节不同
					if((sJSBH==JSBH && sKJ!=KJ&&KJ!=null)) {
						gongju.zengjia(JSBHtext.getText(), JXLBHtext.getText(), KJtext.getText(), SFSYtext.getText(), RNRStext.getText());

					}
					//没有相同教室存在 增加信息
					else if(count==0) {
						gongju.zengjia(JSBHtext.getText(), JXLBHtext.getText(), KJtext.getText(), SFSYtext.getText(), RNRStext.getText());
					}
					else if(sJSBH==JSBH&&KJ==null){
						//有相同教室存在，并且KJ为null，更新为sKJ
						String sql2="update js set KJ='"+null+"',KJ='"+KJ+"' where JSBH='"+JSBH+"' and KJ='"+null+"'";
						pstm=conn.prepareStatement(sql2);
						pstm.executeUpdate();
						pstm.close();
					}else {System.out.println("添加失败");}
					rs.close();
					conn.close();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}



			}
		});
		/*
		 * 根据教室编号修改教室容纳人数
		 */
		button_2 = new JButton("\u4FEE\u6539");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaks?useSSL=false&serverTimezone=UTC","root","lmh12358");
					String sql1="update js set RNRS='"+RNRStext_xiugai.getText()+"'where JSBH='"+JSBHtext_xiugai.getText()+"'";
					PreparedStatement pstm;
					pstm=conn.prepareStatement(sql1);
					pstm.executeUpdate();
					pstm.close();
					conn.close();
				}catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		button_3 = new JButton("\u5220\u9664");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaks?useSSL=false&serverTimezone=UTC","root","lmh12358");
					String sql1="DELETE from js WHERE JSBH='"+JSBHtext_shanchu.getText()+"' and KJ='"+KJtext_shanchu.getText()+"'";
					PreparedStatement pstm;
					pstm = conn.prepareStatement(sql1);
					pstm.executeUpdate();
					pstm.close();
					conn.close();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JSBHtext_xiugai = new JTextField();
		JSBHtext_xiugai.setToolTipText("");
		JSBHtext_xiugai.setColumns(10);

		RNRStext_xiugai = new JTextField();
		RNRStext_xiugai.setToolTipText("");
		RNRStext_xiugai.setColumns(10);

		JSBHtext_shanchu = new JTextField();
		JSBHtext_shanchu.setToolTipText("");
		JSBHtext_shanchu.setColumns(10);

		KJtext_shanchu = new JTextField();
		KJtext_shanchu.setToolTipText("");
		KJtext_shanchu.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblkj, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblrnrs, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblsfsy, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbljxlbh)
										.addComponent(lbljsbh, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
												.addComponent(RNRStext)
												.addComponent(SFSYtext)
												.addComponent(KJtext)
												.addComponent(JXLBHtext)
												.addComponent(JSBHtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(button_1))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel.createSequentialGroup()
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(button_2)
														.addComponent(JSBHtext_xiugai, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
												.addGap(18)
												.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
														.addComponent(KJtext_shanchu, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
														.addComponent(JSBHtext_shanchu, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
														.addComponent(button_3)))
										.addComponent(RNRStext_xiugai, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(79, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
								.addGap(41)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lbljsbh, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
										.addComponent(JSBHtext, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(JSBHtext_xiugai, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(JSBHtext_shanchu, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lbljxlbh, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
										.addComponent(JXLBHtext, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblkj, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
										.addComponent(KJtext, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(KJtext_shanchu, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblsfsy, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
										.addComponent(SFSYtext, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblrnrs, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
										.addComponent(RNRStext, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(RNRStext_xiugai, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
								.addGap(29)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
										.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
												.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
												.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
								.addGap(19))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
