package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class 顾客信息录入 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					顾客信息录入 window = new 顾客信息录入();
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
	public 顾客信息录入() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("顾客信息录入");
		frame.setBounds(100, 100, 474, 426);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel cno1 = new JLabel("\u7F16\u53F7");
		cno1.setFont(new Font("宋体", Font.PLAIN, 14));
		cno1.setBounds(52, 34, 35, 31);
		frame.getContentPane().add(cno1);
		
		JLabel cname1 = new JLabel("\u59D3\u540D");
		cname1.setFont(new Font("宋体", Font.PLAIN, 14));
		cname1.setBounds(52, 86, 35, 31);
		frame.getContentPane().add(cname1);
		
		JLabel csex1 = new JLabel("\u6027\u522B");
		csex1.setFont(new Font("宋体", Font.PLAIN, 14));
		csex1.setBounds(256, 34, 42, 31);
		frame.getContentPane().add(csex1);
		
		JLabel caddress1 = new JLabel("\u4F4F\u5740");
		caddress1.setFont(new Font("宋体", Font.PLAIN, 14));
		caddress1.setBounds(256, 86, 42, 31);
		frame.getContentPane().add(caddress1);
		
		JLabel cphone1 = new JLabel("\u7535\u8BDD");
		cphone1.setFont(new Font("宋体", Font.PLAIN, 14));
		cphone1.setBounds(256, 141, 35, 31);
		frame.getContentPane().add(cphone1);
		
		JLabel mno1 = new JLabel("\u5DF2\u8D2D\u836F\u54C1");
		mno1.setFont(new Font("宋体", Font.PLAIN, 14));
		mno1.setBounds(52, 239, 60, 47);
		frame.getContentPane().add(mno1);
		
		JLabel ano1 = new JLabel("\u7ECF\u529E\u4EBA");
		ano1.setFont(new Font("宋体", Font.PLAIN, 14));
		ano1.setBounds(51, 198, 42, 31);
		frame.getContentPane().add(ano1);
		
		JLabel cdate1 = new JLabel("\u5F55\u5165\u65E5\u671F");
		cdate1.setFont(new Font("宋体", Font.PLAIN, 14));
		cdate1.setBounds(256, 198, 60, 31);
		frame.getContentPane().add(cdate1);
		
		JLabel cremark1 = new JLabel("\u5907\u6CE8");
		cremark1.setFont(new Font("宋体", Font.PLAIN, 14));
		cremark1.setBounds(52, 285, 42, 47);
		frame.getContentPane().add(cremark1);
		
		JLabel csymptom1 = new JLabel("\u75C7\u72B6");
		csymptom1.setFont(new Font("宋体", Font.PLAIN, 14));
		csymptom1.setBounds(256, 247, 42, 31);
		frame.getContentPane().add(csymptom1);
		
		JTextArea cno = new JTextArea();
		cno.setBounds(115, 38, 102, 27);
		frame.getContentPane().add(cno);
		
		JTextArea cname = new JTextArea();
		cname.setBounds(115, 90, 102, 27);
		frame.getContentPane().add(cname);
		
		JTextArea cage = new JTextArea();
		cage.setBounds(115, 145, 102, 27);
		frame.getContentPane().add(cage);
		
		JTextArea ano = new JTextArea();
		ano.setBounds(115, 202, 102, 27);
		frame.getContentPane().add(ano);
		
		JTextArea mno = new JTextArea();
		mno.setBounds(115, 251, 102, 27);
		frame.getContentPane().add(mno);
		
		JTextArea cremark = new JTextArea();
		cremark.setBounds(115, 297, 215, 27);
		frame.getContentPane().add(cremark);
		
		JTextArea caddress = new JTextArea();
		caddress.setBounds(325, 90, 102, 27);
		frame.getContentPane().add(caddress);
		
		JTextArea cdate = new JTextArea();
		cdate.setBounds(325, 202, 102, 27);
		frame.getContentPane().add(cdate);
		
		JTextArea csymptom = new JTextArea();
		csymptom.setBounds(325, 251, 102, 27);
		frame.getContentPane().add(csymptom);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		comboBox.setBounds(325, 39, 102, 27);
		frame.getContentPane().add(comboBox);
		
		JTextArea cphone = new JTextArea();
		cphone.setBounds(326, 145, 101, 27);
		frame.getContentPane().add(cphone);
		
		JButton btnNewButton = new JButton("\u4FDD\u5B58");
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
				   String str=cno.getText();
				   String str1=mno.getText();
				   String str2=ano.getText();
				  
				  if ((str.length()!= 0)&&(str1.length() != 0)&&(str2.length() !=0)) {
					   
				   	String sql="insert into client values ('"+cno.getText()+"','"+cname.getText()+"','"+comboBox.getSelectedItem()+"','"+cage.getText()+"'"
				   			+ ",'"+caddress.getText()+"','"+cphone.getText()+"','"+csymptom.getText()+"','"+mno.getText()+"','"+ano.getText()+"'"
				   			+ ",'"+cdate.getText()+"','"+cremark.getText()+"')";
				                Statement stmt=dbConn.createStatement();  //创建一个Statement对象
				                stmt.executeUpdate(sql);  //执行sql语句
				                System.out.println("插入到数据库成功");
				                JOptionPane.showMessageDialog(null, "保存成功");
			                         }
				                else {
				                	JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				                			"请注意以下几点\n1、编号不能为空\n2、经办人和已购药品均是填编号(并且编号已有）\n3、日期输入格式：2019-1-1", "输入有误，请重新输入！", JOptionPane.INFORMATION_MESSAGE);		
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
		
		btnNewButton.setBounds(103, 344, 77, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel cage1 = new JLabel("\u5E74\u9F84");
		cage1.setFont(new Font("宋体", Font.PLAIN, 14));
		cage1.setBounds(52, 141, 42, 31);
		frame.getContentPane().add(cage1);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				基本信息管理之顾客.run();
				frame.setVisible(false);
			}
		});
		button.setBounds(280, 344, 77, 23);
		frame.getContentPane().add(button);
		
		
	}
}
