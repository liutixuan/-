package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class 注册用户 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					注册用户 window = new 注册用户();
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
	public 注册用户() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("用户注册");
		frame.setBounds(100, 100, 450, 308);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea phone = new JTextArea();
		phone.setBounds(267, 32, 135, 27);
		frame.getContentPane().add(phone);
		
		JTextArea un = new JTextArea();
		un.setBounds(95, 32, 102, 27);
		frame.getContentPane().add(un);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(44, 28, 54, 31);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(44, 102, 35, 31);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(44, 176, 35, 31);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u7535\u8BDD");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(232, 32, 35, 31);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u5730\u5740");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(232, 102, 35, 31);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u90AE\u7BB1");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setBounds(232, 176, 35, 31);
		frame.getContentPane().add(label_5);
		
		JTextArea pw = new JTextArea();
		pw.setBounds(95, 106, 102, 27);
		frame.getContentPane().add(pw);
		
		JTextArea address = new JTextArea();
		address.setBounds(267, 106, 135, 27);
		frame.getContentPane().add(address);
		
		JTextArea mailbox = new JTextArea();
		mailbox.setBounds(267, 180, 135, 27);
		frame.getContentPane().add(mailbox);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		comboBox.setBounds(95, 178, 98, 27);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
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
				   
				   String str1=un.getText();
				   String str2=pw.getText();
				  
				  if ((str1.length() != 0)&&(str2.length() !=0)) {
					   
				   	String sql="insert into tb_yonghu values ('"+un.getText()+"','"+pw.getText()+"','"+phone.getText()+"','"+address.getText()+"'"
				   			+ ",'"+comboBox.getSelectedItem()+"','"+mailbox.getText()+"')";
				                Statement stmt=dbConn.createStatement();  //创建一个Statement对象
				                stmt.executeUpdate(sql);  //执行sql语句
				                System.out.println("插入到数据库成功");
				                JOptionPane.showMessageDialog(null, "保存成功");
			                         }
				                else {
				                	JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				                			"请注意!\n用户名和密码不能为空", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);		
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
		btnNewButton.setBounds(104, 229, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				登录.run();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(260, 229, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
}
