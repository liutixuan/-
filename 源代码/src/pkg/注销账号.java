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

public class 注销账号 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					注销账号 window = new 注销账号();
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
	public 注销账号() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 308, 176);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(52, 26, 62, 25);
		frame.getContentPane().add(label);
		
		JTextArea un = new JTextArea();
		un.setBounds(113, 27, 102, 27);
		frame.getContentPane().add(un);
		
		JButton button = new JButton("\u6CE8\u9500");
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
				               	"请注意！\n用户名不能为空且存在", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);
					   }
				   else {
					   String sql="delete from tb_yonghu where un='"+un.getText()+"'";//生成一条sql语句
			           Statement stmt=dbConn.createStatement();  //创建一个Statement对象
                         stmt.executeUpdate(sql);  //执行sql语句
				             System.out.println("数据库删除成功");
				             JOptionPane.showMessageDialog(null, "注销成功");
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
		button.setBounds(52, 95, 77, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				副主界面.run();
				frame.setVisible(false);
			}
		});
		button_1.setBounds(174, 95, 77, 23);
		frame.getContentPane().add(button_1);
	}

}
