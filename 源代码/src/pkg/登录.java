package pkg;

import java.awt.GraphicsEnvironment;
import javax.swing.JFrame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

	



public class 登录 {

	private JFrame frame;
	private JPasswordField passwordField;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				try {
					登录 window = new 登录();
					window.frame.setVisible(true);
			} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	public static void run() {
		try {
			登录 window = new 登录();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the application.
	 */
	public 登录() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("医药信息管理系统");
		frame.setBounds(100, 100, 443, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		  
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(215, 181, 69, 21);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7BA1\u7406\u5458", "\u7528\u6237"}));
		frame.getContentPane().add(comboBox);
		

		passwordField = new JPasswordField();
		passwordField.setBounds(309, 127, 103, 21);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setForeground(new Color(102, 255, 255));
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(237, 71, 62, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setForeground(new Color(102, 255, 255));
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(237, 130, 62, 15);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea yhm = new JTextArea();
		yhm.setBounds(309, 67, 103, 21);
		frame.getContentPane().add(yhm);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
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
				   System.out.println((String)yhm.getText());
				   System.out.println(passwordField.getText());
				   							   
				   if(comboBox.getSelectedItem() == "管理员") {  
					   String sql1 = "select count(*) from rb_users where password='"+passwordField.getText()+"'";//这里也可以写成select *,不同的方法	
					   System.out.println(sql1);
					   Statement sta1 = dbConn.createStatement();
					   ResultSet rs1 = sta1.executeQuery(sql1);
						   int count = 0;
						   while (rs1.next()) {
						   count = rs1.getInt(1);
						   }   
						   
						  /*String sql2 = "select count(*) from rb_users where username='"+yhm.getText()+"'";//这里也可以写成select *,不同的方法	
						   System.out.println(sql2);
						   Statement sta2 = dbConn.createStatement();
						   ResultSet rs2 = sta2.executeQuery(sql2);
							   int count1 = 0;
							   while (rs2.next()) {
							   count = rs2.getInt(1);
							   }*/   
						   	
							  if(count==0||yhm.getText().equals("")||passwordField.getText().equals("")) {
							  JOptionPane.showMessageDialog(null,"账号或密码错误");
							 }				
							 
									   else {
										   主界面.run();
											frame.setVisible(false);
									   }				        	  
				                	}
				   
				   if(comboBox.getSelectedItem() == "用户") {  
					   String sql1 = "select count(*) from tb_yonghu where pw='"+passwordField.getText()+"'";//这里也可以写成select *,不同的方法	
					   System.out.println(sql1);
					   Statement sta1 = dbConn.createStatement();
					   ResultSet rs1 = sta1.executeQuery(sql1);
						   int count = 0;
						   while (rs1.next()) {
						   count = rs1.getInt(1);
						   }   
						   
						  /* String sql2 = "select count(*) from tb_yonghu where un='"+yhm.getText()+"'";//这里也可以写成select *,不同的方法	
						   System.out.println(sql2);
						   Statement sta2 = dbConn.createStatement();
						   ResultSet rs2 = sta2.executeQuery(sql2);
							   int count1 = 0;
							   while (rs2.next()) {
							   count = rs2.getInt(1);
							   }*/   
						   	
							  if(count == 0||yhm.getText().equals("")||passwordField.getText().equals("")) {
							  JOptionPane.showMessageDialog(null,"账号或密码错误");
							 }				  
									   else {
										   副主界面.run();
											frame.setVisible(false);
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
		btnNewButton.setBounds(294, 180, 60, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			注册用户.run();
				frame.setVisible(false);
				
				
			}
		});
		button.setBounds(364, 180, 62, 23);
		frame.getContentPane().add(button);
		
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Administrator\\Desktop\\timg.jpg"));
		lblNewLabel_2.setBounds(0, 0, 431, 262);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		
		
	}

	protected int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
}
