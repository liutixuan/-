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
import java.awt.event.ActionEvent;

public class 个人信息查询 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					个人信息查询 window = new 个人信息查询();
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
	public 个人信息查询() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("个人信息查询");
		frame.setBounds(100, 100, 450, 288);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\u67E5\u8BE2");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(33, 23, 70, 31);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(33, 80, 70, 31);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(33, 139, 70, 31);
		frame.getContentPane().add(label_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(114, 27, 102, 27);
		frame.getContentPane().add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(114, 84, 102, 27);
		frame.getContentPane().add(textArea_1);
		
		JLabel label_3 = new JLabel("\u7535\u8BDD");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(226, 23, 35, 31);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u5730\u5740");
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(226, 80, 35, 31);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u90AE\u7BB1");
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setBounds(226, 139, 35, 31);
		frame.getContentPane().add(label_5);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setBounds(271, 27, 136, 27);
		frame.getContentPane().add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setBounds(271, 84, 136, 27);
		frame.getContentPane().add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setBounds(271, 143, 136, 27);
		frame.getContentPane().add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setBounds(114, 143, 102, 27);
		frame.getContentPane().add(textArea_5);
		
		JButton btnNewButton = new JButton("\u67E5\u8BE2");
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
				   
				   String sql1 = "select count(*) from tb_yonghu where un='"+textArea.getText()+"'";//这里也可以写成select *,不同的方法				
				   Statement sta1 = dbConn.createStatement();
				   ResultSet rs1 = sta1.executeQuery(sql1);
					   int count = 0;
					   while (rs1.next()) {
					   count = rs1.getInt(1);
					   }
			          
                String str=textArea.getText();
                if((count == 0)||(str.length()==0)) {					       
			             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
		               	"请注意!\n用户名不能为空且存在", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
			   }else {
				   
				                String sql="select * from tb_yonghu where un='"+textArea.getText()+"'";//生成一条sql语句
					            System.out.println(sql);
					            Statement sta = dbConn.createStatement();
								   ResultSet rs = sta.executeQuery(sql);
								   while(rs.next()){    //next（）获取里面的内容
									    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)
									    +" "+rs.getString(5)+" "+rs.getString(6));     //getString（n）获取第n列的内容,数据库中的列数是从1开始的
									        
									           String str2=rs.getString(2);
									           String str3=rs.getString(3);
									           String str4=rs.getString(4);
									           String str5=rs.getString(5);
									           String str6=rs.getString(6);				          
									       
									           textArea_1.setText((String)rs.getString(2));
									           textArea_2.setText((String)rs.getString(3));
									           textArea_3.setText((String)rs.getString(4));
									           textArea_5.setText((String)rs.getString(5));
									           textArea_4.setText((String)rs.getString(6));
												
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
		btnNewButton.setBounds(76, 209, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				副主界面.run();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(258, 209, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		
	}

}
