package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class 个人信息修改 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					个人信息修改 window = new 个人信息修改();
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
	public 个人信息修改() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("个人信息修改");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(36, 21, 70, 31);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(36, 87, 35, 31);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(36, 152, 35, 31);
		frame.getContentPane().add(label_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(109, 25, 102, 27);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(109, 91, 102, 27);
		frame.getContentPane().add(textArea_2);
		
		JLabel label_3 = new JLabel("\u7535\u8BDD");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(238, 21, 35, 31);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u5730\u5740");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(238, 87, 35, 31);
		frame.getContentPane().add(label_4);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(272, 25, 126, 27);
		frame.getContentPane().add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(272, 91, 126, 27);
		frame.getContentPane().add(textArea_4);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(272, 156, 126, 27);
		frame.getContentPane().add(textArea_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		comboBox.setBounds(109, 154, 102, 27);
		frame.getContentPane().add(comboBox);
		
		JButton button = new JButton("\u786E\u5B9A");
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
				   
				   String sql1 = "select count(*) from tb_yonghu  where un='"+textArea.getText()+"'";//这里也可以写成select *,不同的方法				
				   System.out.println(sql1);
				   Statement sta1 = dbConn.createStatement();
				   ResultSet rs1 = sta1.executeQuery(sql1);
					   int count = 0;
					   while (rs1.next()) {
					   count = rs1.getInt(1);
					   }   

				   String str1=textArea.getText();
				   if(count==0&&str1.length()== 0) {
					   
					   JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				               	"请注意!\n用户名不正确", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
					   			
				   
				   }else {
					   String sql="update tb_yonghu set pw='"+textArea_2.getText()+"',phone='"+textArea_3.getText()+"',address='"+textArea_4.getText()+"',mailbox='"+textArea_1.getText()+"'  where un='"+textArea.getText()+"' ";//生成一条sql语句
			           Statement stmt=dbConn.createStatement();  //创建一个Statement对象
                       stmt.executeUpdate(sql);  //执行sql语句
				             System.out.println("数据库修改成功");
				             JOptionPane.showMessageDialog(null, "修改成功");
					   
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
		button.setBounds(81, 210, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				副主界面.run();
				frame.setVisible(false);
			}
		});
		button_1.setBounds(256, 210, 93, 23);
		frame.getContentPane().add(button_1);
		
		JLabel label_5 = new JLabel("\u90AE\u7BB1");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setBounds(238, 152, 35, 31);
		frame.getContentPane().add(label_5);
		

		
	}

}
