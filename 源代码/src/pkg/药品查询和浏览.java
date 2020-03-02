package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.sql.ResultSetMetaData;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class 药品查询和浏览 {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() {
	 */
	public static void run() {
		try {
			药品查询和浏览 window = new 药品查询和浏览();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/*
	 * }); }
	 */

	/**
	 * Create the application.
	 */
	public 药品查询和浏览() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("药品查询和浏览");
		frame.setBounds(100, 100, 650, 467);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel label = new JLabel("\u9009\u62E9\u67E5\u8BE2\u6761\u4EF6");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(21, 20, 84, 23);
		frame.getContentPane().add(label);

		JLabel label_1 = new JLabel("\u7F16\u53F7");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(59, 53, 40, 23);
		frame.getContentPane().add(label_1);

		JLabel label_2 = new JLabel("\u540D\u79F0");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(175, 53, 48, 23);
		frame.getContentPane().add(label_2);

		JLabel label_3 = new JLabel("\u670D\u7528\u65B9\u6CD5");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(298, 53, 76, 23);
		frame.getContentPane().add(label_3);

		JLabel label_4 = new JLabel("\u529F\u6548");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(424, 53, 48, 23);
		frame.getContentPane().add(label_4);

		JTextArea mno = new JTextArea();
		mno.setBounds(45, 71, 118, 23);
		frame.getContentPane().add(mno);

		JTextArea mname = new JTextArea();
		mname.setBounds(163, 71, 127, 23);
		frame.getContentPane().add(mname);

		JTextArea mmode = new JTextArea();
		mmode.setBounds(290, 71, 111, 23);
		frame.getContentPane().add(mmode);

		JTextArea mefficacy = new JTextArea();
		mefficacy.setBounds(401, 71, 215, 23);
		frame.getContentPane().add(mefficacy);

		JLabel label_5 = new JLabel("\u836F\u54C1\u4FE1\u606F\u6D4F\u89C8");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setBounds(21, 104, 127, 23);
		frame.getContentPane().add(label_5);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "\u6309\u7F16\u53F7\u67E5\u8BE2", "\u6309\u836F\u54C1\u540D\u79F0\u67E5\u8BE2" }));
		comboBox.setBounds(114, 20, 103, 23);
		frame.getContentPane().add(comboBox);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(227, 20, 84, 23);
		frame.getContentPane().add(textArea);

		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=yiyao";
				String userName = "sa";
				String userPwd = "19971212";

				try {
					// 加载驱动程序
					Class.forName(driverName);
					// 获得数据库的连接
					Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
					System.out.println("连接数据库成功");

					if (comboBox.getSelectedItem() == "按编号查询") {

						String sql1 = "select count(*) from medicine where mno='" + textArea.getText() + "'";// 这里也可以写成select
																												// *,不同的方法
						Statement sta1 = dbConn.createStatement();
						ResultSet rs1 = sta1.executeQuery(sql1);
						int count = 0;
						while (rs1.next()) {
							count = rs1.getInt(1);
						}

						String str = textArea.getText();
						if ((count == 0)||(str.length() == 0)) {
							JOptionPane.showMessageDialog(new JFrame().getContentPane(), "请注意!\n编号不能为空且存在",
									"输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
						} else {
							String sql = "select * from medicine where mno='" + textArea.getText() + "'";// 生成一条sql语句
							System.out.println(sql);
							Statement sta = dbConn.createStatement();
							ResultSet rs = sta.executeQuery(sql);
							while (rs.next()) { // next（）获取里面的内容
								System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
										+ rs.getString(4));
								// getString（n）获取第n列的内容,数据库中的列数是从1开始的
								String str1 = rs.getString(1);
								String str2 = rs.getString(2);
								String str3 = rs.getString(3);
								String str4 = rs.getString(4);
								mno.setText((String) rs.getString(1));
								mname.setText((String) rs.getString(2));
								mmode.setText((String) rs.getString(3));
								mefficacy.setText((String) rs.getString(4));
							}

						}
					} 

					if (comboBox.getSelectedItem() == "按药品名称查询") {

						String sql1 = "select count(*) from medicine where mname='" + textArea.getText() + "'";// 这里也可以写成select
																												// *,不同的方法
						Statement sta1 = dbConn.createStatement();
						ResultSet rs1 = sta1.executeQuery(sql1);
						int count = 0;
						while (rs1.next()) {
							count = rs1.getInt(1);
						}

						String str = textArea.getText();
						if ((count == 0)||(str.length() == 0)) {
							JOptionPane.showMessageDialog(new JFrame().getContentPane(), "请注意!\n编号不能为空且存在",
									"输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
						} else {
							String sql = "select * from medicine where mname='" + textArea.getText() + "'";// 生成一条sql语句
							System.out.println(sql);
							Statement sta = dbConn.createStatement();
							ResultSet rs = sta.executeQuery(sql);
							while (rs.next()) { // next（）获取里面的内容
								System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " "
										+ rs.getString(4));
								// getString（n）获取第n列的内容,数据库中的列数是从1开始的
								String str1 = rs.getString(1);
								String str2 = rs.getString(2);
								String str3 = rs.getString(3);
								String str4 = rs.getString(4);
								mno.setText((String) rs.getString(1));
								mname.setText((String) rs.getString(2));
								mmode.setText((String) rs.getString(3));
								mefficacy.setText((String) rs.getString(4));
							}

						}
					}

					dbConn.close();
					System.out.println("关闭数据库成功");
				}

				catch (Exception e1) {
					e1.printStackTrace();
					System.out.print("连接失败");

				}

			}
		});
		button.setBounds(321, 20, 68, 23);
		frame.getContentPane().add(button);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u7F16\u53F7", "\u540D\u79F0", "\u670D\u7528\u65B9\u6CD5", "\u529F\u6548"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(166);

		JButton button_1 = new JButton("\u663E\u793A\u5168\u90E8\u836F\u54C1\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=yiyao";
				String userName = "sa";
				String userPwd = "19971212";

				try {
					// 加载驱动程序
					Class.forName(driverName);
					// 获得数据库的连接
					Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
					System.out.println("连接数据库成功");
					
					String sql = "select * from medicine";
					System.out.println(sql);
					Statement sta = dbConn.createStatement();					
					ResultSet rs = sta.executeQuery(sql);
					
					
					ResultSetMetaData data=rs.getMetaData();
					int count=data.getColumnCount();
					int flag = 0;
					String[][] object = new String[100][4];
					//rs.first();
					//rs.previous();
					while (rs.next()) {
						object[flag][0] = (String)rs.getString("mno");
						object[flag][1] = (String)rs.getString("mname");
						object[flag][2] = (String)rs.getString("mmode");
						object[flag][3] = (String)rs.getString("mefficacy");
						flag++;
					}									
					table.setModel(new DefaultTableModel(object, new String[] { "\u7F16\u53F7", "\u540D\u79F0",
							"\u670D\u7528\u65B9\u6CD5", "\u529F\u6548" }));
			  
					
					
					dbConn.close();
					System.out.println("关闭数据库成功");
				}catch (Exception e) {
					e.printStackTrace();
					System.out.print("连接失败");

				}
				 
				         
				

			}
		});
		button_1.setBounds(399, 20, 142, 23);
		frame.getContentPane().add(button_1);

		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				副主界面.run();
				frame.setVisible(false);
			}
		});
		button_2.setBounds(548, 20, 68, 23);
		frame.getContentPane().add(button_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 137, 595, 282);
		frame.getContentPane().add(scrollPane);
		
		scrollPane.setViewportView(table);

	}
}
