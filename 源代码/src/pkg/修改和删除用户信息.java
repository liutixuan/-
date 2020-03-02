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
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class 修改和删除用户信息 {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					修改和删除用户信息 window = new 修改和删除用户信息();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		/*});
	}*/

	/**
	 * Create the application.
	 */
	public 修改和删除用户信息() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("修改和删除用户信息");
		frame.setBounds(100, 100, 583, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\u67E5\u8BE2");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(32, 10, 84, 31);
		frame.getContentPane().add(label);
		
		JTextArea un = new JTextArea();
		un.setBounds(126, 14, 89, 23);
		frame.getContentPane().add(un);
		
		JTextArea pw = new JTextArea();
		pw.setBounds(21, 72, 93, 31);
		frame.getContentPane().add(pw);
		
		JTextArea phone = new JTextArea();
		phone.setBounds(114, 72, 96, 31);
		frame.getContentPane().add(phone);
		
		JTextArea address = new JTextArea();
		address.setBounds(210, 72, 106, 31);
		frame.getContentPane().add(address);
		
		JTextArea sex = new JTextArea();
		sex.setBounds(316, 72, 66, 31);
		frame.getContentPane().add(sex);
		
		JTextArea mailbox = new JTextArea();
		mailbox.setBounds(382, 72, 162, 31);
		frame.getContentPane().add(mailbox);
		
		JButton button = new JButton("\u67E5\u8BE2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
				   String sql1 = "select * from tb_yonghu  where un='"+un.getText()+"'";//这里也可以写成select *,不同的方法				
				   System.out.println(sql1);
				   Statement sta1 = dbConn.createStatement();
				   ResultSet rs1 = sta1.executeQuery(sql1);
					   int count = 0;
					   while (rs1.next()) {
					   count = rs1.getInt(1);
					   }   
                   String str=un.getText();
                   if((count == 0)||(str.length()==0)) {					       
			             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
		               	"请注意以下几点\n1、用户名不能为空且存在\n2、查询操作输入编号即可", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
			   }else {
				   
				   Statement sta = dbConn.createStatement();
				   
				                String sql="select * from tb_yonghu  where un='"+un.getText()+"'";//生成一条sql语句
					            System.out.println(sql);					           
								   ResultSet rs = sta.executeQuery(sql);
								   while(rs.next()){    //next（）获取里面的内容
									    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6));
									                         //getString（n）获取第n列的内容,数据库中的列数是从1开始的
									           /*String str1=rs.getString(1);
									           String str2=rs.getString(2);
									           String str3=rs.getString(3);
									           String str4=rs.getString(4);
									           String str5=rs.getString(5);
									           String str6=rs.getString(6);*/
												pw.setText((String)rs.getString(2));							          
												phone.setText((String)rs.getString(3));
												address.setText((String)rs.getString(4));
												sex.setText((String)rs.getString(5));
												mailbox.setText((String)rs.getString(6));

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
		button.setBounds(248, 14, 68, 23);
		frame.getContentPane().add(button);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"un", "pw", "phone", "address", "sex", "mailbox"
			}
		));
		
		JButton button_1 = new JButton("\u663E\u793A\u5168\u90E8\u7528\u6237\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
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
					
					String sql = "select * from tb_yonghu";
					System.out.println(sql);
					Statement sta = dbConn.createStatement();					
					ResultSet rs = sta.executeQuery(sql);
					
					
					ResultSetMetaData data=rs.getMetaData();
					int count=data.getColumnCount();
					int flag = 0;
					String[][] object = new String[100][6];
					//rs.first();
					//rs.previous();
					while (rs.next()) {
						object[flag][0] = (String)rs.getString("un");
						object[flag][1] = (String)rs.getString("pw");
						object[flag][2] = (String)rs.getString("phone");
						object[flag][3] = (String)rs.getString("address");
						object[flag][4] = (String)rs.getString("sex");
						object[flag][5] = (String)rs.getString("mailbox");
						flag++;
					}									
					table.setModel(new DefaultTableModel(object, new String[] { "un", "pw",
							"phone", "adddress","sex","mailbox" }));
			  
					
					
					dbConn.close();
					System.out.println("关闭数据库成功");
				}catch (Exception e1) {
					e1.printStackTrace();
					System.out.print("连接失败");

				}
			}
		});
		button_1.setBounds(364, 14, 142, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				主界面.run();
				frame.setVisible(false);
			}
		});
		button_2.setBounds(398, 351, 77, 23);
		frame.getContentPane().add(button_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 113, 547, 228);
		frame.getContentPane().add(scrollPane);
		
		
		table.getColumnModel().getColumn(4).setPreferredWidth(65);
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		scrollPane.setViewportView(table);
		
		JButton button_3 = new JButton("\u4FEE\u6539");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
				  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=yiyao";
				  String userName="sa";
				  String userPwd="19971212";
				try {
					//加载驱动程序
				   Class.forName(driverName);
				   //获得数据库的连接
				   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
				   System.out.println("连接数据库成功");

				   String str1=un.getText();
				   String str=sex.getText();
				   if((str1.length()!= 0)&&(str.equals("男")||str.equals("女"))) {
					   			
				   String sql="update tb_yonghu set pw='"+pw.getText()+"',phone='"+phone.getText()+"',address='"+address.getText()+"',sex='"+sex.getText()+"',mailbox='"+mailbox.getText()+"'  where un='"+un.getText()+"' ";//生成一条sql语句
			           Statement stmt=dbConn.createStatement();  //创建一个Statement对象
                  stmt.executeUpdate(sql);  //执行sql语句
				             System.out.println("数据库修改成功");
				             JOptionPane.showMessageDialog(null, "修改成功（编号无法修改）");
				   }else {
					   JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				               	"请注意以下几点\n1、用户名不能修改\n2、性别为男或女", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
				   }
				           dbConn.close();
					             System.out.println("数据库关闭成功");//关闭数据库的连接
					         }  
				   
				
				catch(Exception e1)
				    {
					 e1.printStackTrace();
				     System.out.print("连接失败");

					 }    
				
				
				
				
			}
		});
		button_3.setBounds(80, 351, 77, 23);
		frame.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("\u5220\u9664");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
				  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=yiyao";
				  String userName="sa";
				  String userPwd="19971212";
				try {
					//加载驱动程序
				   Class.forName(driverName);
				   //获得数据库的连接
				   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
				   System.out.println("连接数据库成功");

				   String sql1 = "select count(*) from tb_yonghu where  un='"+un.getText()+"'";//这里也可以写成select *,不同的方法				
				   Statement sta = dbConn.createStatement();
				   ResultSet rs = sta.executeQuery(sql1);
					   int count = 0;
					   while (rs.next()) {
					   count = rs.getInt(1);
					   }
			          
                    String str=un.getText();
					   if((count == 0)||(str.length()==0)) {					       
					             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				               	"请注意以下几点\n1、用户名不能为空且存在\n2、删除操作输入编号即可", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
					   }
				   else {
					   String sql="delete from tb_yonghu where un='"+un.getText()+"'";//生成一条sql语句
			           Statement stmt=dbConn.createStatement();  //创建一个Statement对象
                        stmt.executeUpdate(sql);  //执行sql语句
				             System.out.println("数据库删除成功");
				             JOptionPane.showMessageDialog(null, "删除成功");
				   }
					             dbConn.close();
					             System.out.println("数据库关闭成功");//关闭数据库的连接
					         }  
				   
				
				catch(Exception e1)
				    {
					 e1.printStackTrace();
				     System.out.print("连接失败");

					 }    
					         
				
			}
		});
		button_4.setBounds(235, 351, 77, 23);
		frame.getContentPane().add(button_4);
		
		JLabel label_3 = new JLabel("\u5BC6\u7801");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(32, 43, 51, 31);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u7535\u8BDD");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(124, 43, 41, 31);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u5730\u5740");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setBounds(209, 43, 51, 31);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u6027\u522B");
		label_6.setFont(new Font("宋体", Font.PLAIN, 14));
		label_6.setBounds(316, 43, 51, 31);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\u90AE\u7BB1");
		label_7.setFont(new Font("宋体", Font.PLAIN, 14));
		label_7.setBounds(382, 43, 51, 31);
		frame.getContentPane().add(label_7);
		
		
		
	}
}
