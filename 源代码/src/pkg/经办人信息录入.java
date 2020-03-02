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
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class 经办人信息录入 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {//加 static
				try {
					经办人信息录入 window = new 经办人信息录入();
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
	public 经办人信息录入() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("经办人信息录入");
		frame.setBounds(100, 100, 450, 366);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel.setBounds(86, 25, 41, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(86, 66, 41, 53);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(86, 129, 41, 25);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u7535\u8BDD");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(86, 175, 41, 35);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5907\u6CE8");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(86, 221, 41, 42);
		frame.getContentPane().add(lblNewLabel_4);
		
		JTextArea ano = new JTextArea();
		ano.setBounds(158, 35, 102, 27);
		frame.getContentPane().add(ano);
		
		JTextArea aname = new JTextArea();
		aname.setBounds(158, 81, 102, 27);
		frame.getContentPane().add(aname);
		
		JTextArea aphone = new JTextArea();
		aphone.setBounds(158, 181, 102, 27);
		frame.getContentPane().add(aphone);
		
		JTextArea aremark = new JTextArea();
		aremark.setBounds(158, 231, 102, 27);
		frame.getContentPane().add(aremark);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		comboBox.setBounds(158, 131, 102, 27);
		frame.getContentPane().add(comboBox);
		
		JButton button = new JButton("\u4FDD\u5B58");
		button.addActionListener(new ActionListener() {
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
				   String str=ano.getText();
				  // String str1=asex.getText();
				   if ((str.length() !=0)){
					   
				   	String sql="insert into agency values ('"+ano.getText()+"','"+aname.getText()+"','"+comboBox.getSelectedItem()+"','"+aphone.getText()+"','"+aremark.getText()+"')";
				                Statement stmt=dbConn.createStatement();  //创建一个Statement对象
				                stmt.executeUpdate(sql);  //执行sql语句
				                System.out.println("插入到数据库成功");
				                JOptionPane.showMessageDialog(null, "保存成功");
			                         }
				                else {
				                	JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				                			"请注意以下几点\n1、编号不能为空", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
				                			
				                			
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
		button.setBounds(101, 284, 77, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				基本信息管理之经办人.run();
				frame.setVisible(false);
			}
		});
		button_1.setBounds(206, 284, 77, 23);
		frame.getContentPane().add(button_1);
		
	
	}

}
