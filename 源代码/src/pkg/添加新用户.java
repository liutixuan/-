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

public class 添加新用户 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					添加新用户 window = new 添加新用户();
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
	public 添加新用户() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("添加新用户");
		frame.setBounds(100, 100, 450, 297);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(59, 34, 51, 31);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(59, 100, 35, 31);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u7535\u8BDD");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(246, 100, 35, 31);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u90AE\u7BB1");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(59, 164, 35, 31);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u6027\u522B");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(246, 34, 35, 31);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u5730\u5740");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setBounds(246, 164, 35, 31);
		frame.getContentPane().add(label_5);
		
		JTextArea name = new JTextArea();
		name.setBounds(106, 38, 130, 27);
		frame.getContentPane().add(name);
		
		JTextArea mm = new JTextArea();
		mm.setBounds(106, 104, 130, 27);
		frame.getContentPane().add(mm);
		
		JTextArea dh = new JTextArea();
		dh.setBounds(290, 104, 114, 27);
		frame.getContentPane().add(dh);
		
		JTextArea yx = new JTextArea();
		yx.setBounds(106, 168, 130, 27);
		frame.getContentPane().add(yx);
		
		JTextArea dz = new JTextArea();
		dz.setBounds(290, 168, 114, 27);
		frame.getContentPane().add(dz);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		comboBox.setBounds(290, 36, 114, 27);
		frame.getContentPane().add(comboBox);
		
		JButton button = new JButton("\u4FDD\u5B58");
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
				   
				   String str=name.getText();
				   String str1=mm.getText();
				   if ((str.length() !=0)&&(str1.length()!=0)) {
					   
				   	String sql="insert into tb_yonghu values ('"+name.getText()+"','"+mm.getText()+"','"+dh.getText()+"','"+dz.getText()+"' ,"
				   			+ "'"+comboBox.getSelectedItem()+"','"+yx.getText()+"')";
				                Statement stmt=dbConn.createStatement();  //创建一个Statement对象
				                stmt.executeUpdate(sql);  //执行sql语句
				                System.out.println("插入到数据库成功");
				                JOptionPane.showMessageDialog(null, "保存成功");
			                         }
				                else {
				                	JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				                			"请注意！\n用户名和密码不能为空", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
				                			
				                			
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
		button.setBounds(110, 218, 77, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				主界面.run();
				frame.setVisible(false);
			}
		});
		button_1.setBounds(268, 218, 77, 23);
		frame.getContentPane().add(button_1);
	}
}
