package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JScrollPane;


public class 顾客信息查询和浏览 {

	private JFrame frame;
	private JTable table;

	
	 // Launch the application.
	 
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					顾客信息查询和浏览 window = new 顾客信息查询和浏览();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		/*});
	}*/

	
	  //Create the application.
	 
	public 顾客信息查询和浏览() {
		initialize();
	}

	
	 //Initialize the contents of the frame.
	 
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("顾客信息查询和浏览");
		frame.setBounds(100, 100, 703, 496);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u9009\u62E9\u67E5\u8BE2\u6761\u4EF6");
		lblNewLabel_1.setBackground(new Color(240, 240, 240));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(20, 20, 84, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(244, 20, 84, 23);
		frame.getContentPane().add(textArea);
		
		JTextArea cno = new JTextArea();
		cno.setBounds(50, 75, 83, 23);
		frame.getContentPane().add(cno);
		
		JTextArea cname = new JTextArea();
		cname.setBounds(133, 75, 80, 23);
		frame.getContentPane().add(cname);
		
		JTextArea csex = new JTextArea();
		csex.setBounds(213, 75, 86, 23);
		frame.getContentPane().add(csex);
		
		JTextArea cage = new JTextArea();
		cage.setBounds(299, 75, 87, 23);
		frame.getContentPane().add(cage);
		
		JTextArea mno = new JTextArea();
		mno.setBackground(new Color(255, 255, 255));
		mno.setBounds(386, 75, 88, 23);
		frame.getContentPane().add(mno);
		
		JTextArea cphone = new JTextArea();
		cphone.setBounds(114, 132, 107, 23);
		frame.getContentPane().add(cphone);
		
		JTextArea caddress = new JTextArea();
		caddress.setBounds(221, 132, 133, 23);
		frame.getContentPane().add(caddress);
		
		JTextArea csymptom = new JTextArea();
		csymptom.setBounds(354, 132, 110, 23);
		frame.getContentPane().add(csymptom);
		
		JTextArea cremark = new JTextArea();
		cremark.setBounds(474, 75, 192, 23);
		frame.getContentPane().add(cremark);
		
		JTextArea ano = new JTextArea();
		ano.setBounds(49, 132, 65, 23);
		frame.getContentPane().add(ano);
		
		JTextArea cdate = new JTextArea();
		cdate.setBounds(464, 132, 202, 23);
		frame.getContentPane().add(cdate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6309\u7F16\u53F7\u67E5\u8BE2", "\u6309\u59D3\u540D\u67E5\u8BE2"}));
		comboBox.setBounds(114, 20, 103, 23);
		frame.getContentPane().add(comboBox);
		
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
				  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=yiyao";
				  String userName="sa";
				  String userPwd="19971212";
				  
				  try
				  {
					  //加载驱动程序
				   Class.forName(driverName);
				   //获得数据库的连接
				   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
				   System.out.println("连接数据库成功");

               if(comboBox.getSelectedItem() == "按编号查询"){
            	   
            	   String sql1 = "select count(*) from client where cno='"+textArea.getText()+"'";//这里也可以写成select *,不同的方法	
				   System.out.println(sql1);
				   Statement sta1 = dbConn.createStatement();
				   ResultSet rs1 = sta1.executeQuery(sql1);
					   int count = 0;
					   while (rs1.next()) {
					   count = rs1.getInt(1);
					   }   
			          
                 String str=textArea.getText();
                 if((count == 0)||(str.length()==0)) {					       
			             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
		               	"请注意!\n编号不能为空且存在", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
			   }else {
				   
			   
            	  
            	  String sql="select * from client where cno='"+textArea.getText()+"'";//生成一条sql语句
			            System.out.println(sql);
			            Statement sta = dbConn.createStatement();
						   ResultSet rs = sta.executeQuery(sql);
						   while(rs.next()){    //next（）获取里面的内容
							    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)
							    +" "+rs.getString(8)+" "+rs.getString(9)+" "+rs.getString(10)+" "+rs.getString(11));
							                         //getString（n）获取第n列的内容,数据库中的列数是从1开始的
							          /* String str1=rs.getString(1);
							           String str2=rs.getString(2);
							           String str3=rs.getString(3);
							           String str4=rs.getString(4);
							           String str5=rs.getString(5);
							           String str6=rs.getString(6);
							           String str7=rs.getString(7);
							           String str8=rs.getString(8);
							           String str9=rs.getString(9);
							           String str10=rs.getString(10);
							           String str11=rs.getString(11);*/
							            cno.setText((String)rs.getString(1));
										cname.setText((String)rs.getString(2));
										csex.setText((String)rs.getString(3));
										cage.setText((String)rs.getString(4));
										caddress.setText((String)rs.getString(5));
										cphone.setText((String)rs.getString(6));									
										csymptom.setText((String)rs.getString(7));
										mno.setText((String)rs.getString(8));
										ano.setText((String)rs.getString(9));
										cdate.setText((String)rs.getString(10));
										cremark.setText((String)rs.getString(11));
										
						   }

                   }
              }
  if(comboBox.getSelectedItem() == "按姓名查询"){
            	   
            	   String sql1 = "select count(*) from client where cname='"+textArea.getText()+"'";//这里也可以写成select *,不同的方法	
				   System.out.println(sql1);
				   Statement sta1 = dbConn.createStatement();
				   ResultSet rs1 = sta1.executeQuery(sql1);
					   int count = 0;
					   while (rs1.next()) {
					   count = rs1.getInt(1);
					   }   
			          
                 String str=textArea.getText();
                 if((count == 0)||(str.length()==0)) {					       
			             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
		               	"请注意!\n编号不能为空且存在", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
			   }else {
				   
			   
            	  
            	  String sql="select * from client where cname='"+textArea.getText()+"'";//生成一条sql语句
			            System.out.println(sql);
			            Statement sta = dbConn.createStatement();
						   ResultSet rs = sta.executeQuery(sql);
						   while(rs.next()){    //next（）获取里面的内容
							    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)
							    +" "+rs.getString(8)+" "+rs.getString(9)+" "+rs.getString(10)+" "+rs.getString(11));
							                         //getString（n）获取第n列的内容,数据库中的列数是从1开始的
							           String str1=rs.getString(1);
							           String str2=rs.getString(2);
							           String str3=rs.getString(3);
							           String str4=rs.getString(4);
							           String str5=rs.getString(5);
							           String str6=rs.getString(6);
							           String str7=rs.getString(7);
							           String str8=rs.getString(8);
							           String str9=rs.getString(9);
							           String str10=rs.getString(10);
							           String str11=rs.getString(11);
							            cno.setText((String)rs.getString(1));
										cname.setText((String)rs.getString(2));
										csex.setText((String)rs.getString(3));
										cage.setText((String)rs.getString(4));
										caddress.setText((String)rs.getString(5));
										cphone.setText((String)rs.getString(6));									
										csymptom.setText((String)rs.getString(7));
										mno.setText((String)rs.getString(8));
										ano.setText((String)rs.getString(9));
										cdate.setText((String)rs.getString(10));
										cremark.setText((String)rs.getString(11));
										
						   }

                   }
              }
				                
				                dbConn.close();
				                System.out.println("关闭数据库成功");
				}
				  		
				  catch(Exception e1)
				  {
				   e1.printStackTrace();
				   System.out.print("连接失败");

				  }    
	
			}
		});
		btnNewButton_1.setBounds(338, 20, 68, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"cno", "cname", "csex", "cage", "caddress", "cphone", "csymptom", "mno", "ano", "cdate", "cremark"
			}
		));
		
		JButton btnNewButton = new JButton("\u663E\u793A\u5168\u90E8\u987E\u5BA2\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
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
					
					String sql = "select *  from client";
					System.out.println(sql);
					Statement sta = dbConn.createStatement();					
					ResultSet rs = sta.executeQuery(sql);
					
					ResultSetMetaData data=rs.getMetaData();
					int count=data.getColumnCount();
					
					int flag = 0;
					String[][] object = new String[100][11];
					//rs.first();
					//rs.previous();
					while (rs.next()) {
						object[flag][0] = (String)rs.getString("cno");
						object[flag][1] = (String)rs.getString("cname");
						object[flag][2] = (String)rs.getString("csex");
						object[flag][3] = (String)rs.getString("cage");
						object[flag][4] = (String)rs.getString("caddress");
						object[flag][5] = (String)rs.getString("cphone");
						object[flag][6] = (String)rs.getString("csymptom");
						object[flag][7] = (String)rs.getString("mno");
						object[flag][8] = (String)rs.getString("ano");
						object[flag][9] = (String)rs.getString("cdate");
						object[flag][10] = (String)rs.getString("cremark");
						flag++;
					}
					table.setModel(new DefaultTableModel(object, new String[] {
							"cno", "cname", "csex", "cage", "caddress", "cphone", "csymptom", "mno", "ano", "cdate", "cremark"
					}));
					dbConn.close();
					System.out.println("关闭数据库成功");
				}catch (Exception e1) {
					e1.printStackTrace();
					System.out.print("连接失败");

				}					
			}
		});
		btnNewButton.setBounds(425, 20, 142, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				主界面.run();
				frame.setVisible(false);
			}
		});
		button.setBounds(577, 20, 68, 23);
		frame.getContentPane().add(button);
		
		JLabel label = new JLabel("\u7F16\u53F7");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBackground(SystemColor.menu);
		label.setBounds(56, 53, 51, 23);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBackground(SystemColor.menu);
		label_1.setBounds(144, 53, 51, 23);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBackground(SystemColor.menu);
		label_2.setBounds(221, 53, 51, 23);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u5E74\u9F84");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBackground(SystemColor.menu);
		label_3.setBounds(307, 53, 51, 23);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u836F\u54C1");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBackground(SystemColor.menu);
		label_4.setBounds(389, 53, 51, 23);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u7ECF\u529E\u4EBA");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setBackground(SystemColor.menu);
		label_5.setBounds(56, 108, 51, 23);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u4F4F\u5740");
		label_6.setFont(new Font("宋体", Font.PLAIN, 14));
		label_6.setBackground(SystemColor.menu);
		label_6.setBounds(221, 108, 51, 23);
		frame.getContentPane().add(label_6);
	
		JLabel label_9 = new JLabel("\u65E5\u671F");
		label_9.setFont(new Font("宋体", Font.PLAIN, 14));
		label_9.setBackground(SystemColor.menu);
		label_9.setBounds(464, 108, 61, 23);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("\u75C7\u72B6");
		label_10.setFont(new Font("宋体", Font.PLAIN, 14));
		label_10.setBackground(SystemColor.menu);
		label_10.setBounds(355, 108, 51, 23);
		frame.getContentPane().add(label_10);
		
		
		JLabel label_11 = new JLabel("\u5907\u6CE8");
		label_11.setFont(new Font("宋体", Font.PLAIN, 14));
		label_11.setBackground(SystemColor.menu);
		label_11.setBounds(474, 53, 51, 23);
		frame.getContentPane().add(label_11);
		
		JLabel label_7 = new JLabel("\u7535\u8BDD");
		label_7.setFont(new Font("宋体", Font.PLAIN, 14));
		label_7.setBackground(SystemColor.menu);
		label_7.setBounds(119, 108, 51, 23);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\u987E\u5BA2\u4FE1\u606F\u6D4F\u89C8");
		label_8.setFont(new Font("宋体", Font.PLAIN, 14));
		label_8.setBounds(20, 165, 127, 23);
		frame.getContentPane().add(label_8);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 198, 646, 250);
		frame.getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(table);

	}
}
