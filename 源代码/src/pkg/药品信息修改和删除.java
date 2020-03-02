package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.awt.event.ActionEvent;



public class 药品信息修改和删除 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					药品信息修改和删除 window = new 药品信息修改和删除();
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
	public 药品信息修改和删除() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("药品信息修改和删除");
		frame.setBounds(100, 100, 488, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7\u67E5\u8BE2");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(94, 35, 62, 25);
		frame.getContentPane().add(label_1);
		
		JTextArea mno = new JTextArea();
		mno.setBounds(180, 36, 102, 27);
		frame.getContentPane().add(mno);
		
		JTextArea mname = new JTextArea();
		mname.setBounds(180, 80, 102, 27);
		frame.getContentPane().add(mname);
		
		JTextArea mmode = new JTextArea();
		mmode.setBounds(180, 132, 102, 27);
		frame.getContentPane().add(mmode);
		
		JTextArea mefficacy = new JTextArea();
		mefficacy.setBounds(180, 179, 263, 27);
		frame.getContentPane().add(mefficacy);
		
		JLabel label_2 = new JLabel("\u540D\u79F0");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(94, 70, 44, 42);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u670D\u7528\u65B9\u6CD5");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(94, 122, 72, 42);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u529F\u6548");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(94, 174, 35, 33);
		frame.getContentPane().add(label_4);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
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

				   String str1=mno.getText();
				   String str=mmode.getText();
				   if((str1.length()!= 0)&&(str.equals("内服")||str.equals("外用"))) {
					   			
				       String sql="update medicine set mname='"+mname.getText()+"',mmode='"+mmode.getText()+"',mefficacy='"+mefficacy.getText()+"'  where mno='"+mno.getText()+"' ";//生成一条sql语句
			           Statement stmt=dbConn.createStatement();  //创建一个Statement对象
                       stmt.executeUpdate(sql);  //执行sql语句
				             System.out.println("数据库修改成功");
				             JOptionPane.showMessageDialog(null, "修改成功（编号无法修改）");
				   }else {
					   JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				               	"请注意以下几点\n1、编号不能修改\n2、服用方法为内服或外用", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
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
		button.setBounds(138, 236, 79, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
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

				   String sql1 = "select count(*) from medicine where  mno='"+mno.getText()+"'";//这里也可以写成select *,不同的方法				
				   Statement sta = dbConn.createStatement();
				   ResultSet rs = sta.executeQuery(sql1);
					   int count = 0;
					   while (rs.next()) {
					   count = rs.getInt(1);
					   }
			          
                     String str=mno.getText();
					   if((count == 0)||(str.length()==0)) {					       
					             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				               	"请注意以下几点\n1、编号不能为空且存在\n2、删除操作输入编号即可", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
					   }
				   else {
					   String sql="delete from medicine where mno='"+mno.getText()+"'";//生成一条sql语句
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
		
		button_1.setBounds(244, 234, 79, 27);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				基本信息管理之药品.run();
				frame.setVisible(false);
			}
		});
		button_2.setBounds(349, 234, 79, 27);
		frame.getContentPane().add(button_2);
		
		JButton chaxun = new JButton("\u67E5\u8BE2");
		chaxun.addActionListener(new ActionListener() {
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
				   
				   String sql1 = "select count(*) from medicine  where mno='"+mno.getText()+"'";//这里也可以写成select *,不同的方法				
				   System.out.println(sql1);
				   Statement sta1 = dbConn.createStatement();
				   ResultSet rs1 = sta1.executeQuery(sql1);
					   int count = 0;
					   while (rs1.next()) {
					   count = rs1.getInt(1);
					   }   
                   String str=mno.getText();
                   if((count == 0)||(str.length()==0)) {					       
			             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
		               	"请注意以下几点\n1、编号不能为空且存在\n2、查询操作输入编号即可", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
			   }else {
				   
				                String sql="select * from medicine where mno='"+mno.getText()+"'";//生成一条sql语句
					            System.out.println(sql);
					            Statement sta = dbConn.createStatement();
								   ResultSet rs = sta.executeQuery(sql);
								   while(rs.next()){    //next（）获取里面的内容
									    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
									                         //getString（n）获取第n列的内容,数据库中的列数是从1开始的
									           //String str1=rs.getString(1);
									           String str2=rs.getString(2);
									           String str3=rs.getString(3);
									           String str4=rs.getString(4);
												mname.setText((String)rs.getString(2));
												mmode.setText((String)rs.getString(3));
												mefficacy.setText((String)rs.getString(4));

									    }
			   }
				                
				                dbConn.close();
				                System.out.println("关闭数据库成功");
				}
				  		
				  catch(Exception e)
				  {
				   e.printStackTrace();
				   System.out.print("连接失败");

				  }    
				  
				
			}
		});
		chaxun.setBounds(36, 236, 79, 23);
		frame.getContentPane().add(chaxun);
		
	}
}
