package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class �޸����� {

	private JFrame frame;
	private JTextField jma;
	private JTextField xma;
	private JTextField csxma;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					�޸����� window = new �޸�����();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	/*	});
	}*/

	/**
	 * Create the application.
	 */
	public �޸�����() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("�޸�����");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u65E7\u5BC6\u7801");
		label.setFont(new Font("����", Font.PLAIN, 14));
		label.setBounds(70, 83, 63, 23);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u65B0\u5BC6\u7801");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(70, 129, 52, 23);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u91CD\u8F93\u65B0\u5BC6\u7801");
		label_2.setFont(new Font("����", Font.PLAIN, 14));
		label_2.setBounds(70, 178, 78, 23);
		frame.getContentPane().add(label_2);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(152, 42, 118, 21);
		frame.getContentPane().add(username);
		
		jma = new JTextField();
		jma.setBounds(152, 84, 118, 21);
		frame.getContentPane().add(jma);
		jma.setColumns(10);
		
		xma = new JTextField();
		xma.setBounds(152, 130, 118, 21);
		frame.getContentPane().add(xma);
		xma.setColumns(10);
		
		csxma = new JTextField();
		csxma.setColumns(10);
		csxma.setBounds(152, 179, 118, 21);
		frame.getContentPane().add(csxma);
		
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
				  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=yiyao";
				  String userName="sa";
				  String userPwd="19971212";
				  
				  try
				  {
					  //������������
				   Class.forName(driverName);
				   //������ݿ������
				   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
				   System.out.println("�������ݿ�ɹ�");
				   
				   String sql1 = "select count(*) from rb_users where password='"+jma.getText()+"'";//����Ҳ����д��select *,��ͬ�ķ���				
				   Statement sta1 = dbConn.createStatement();
				   ResultSet rs1 = sta1.executeQuery(sql1);
				   
					   int count = 0;
					   while (rs1.next()) {
					   count = rs1.getInt(1);
					   }
				   
                 String str=jma.getText();

                 	if(count == 0&&str.equals("")) {					       
			             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
		               	"��ע�⣡\n�û��������벻��ȷ", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);
			   }else {
				   if(xma.getText().equals(csxma.getText())) {
					   String sql="update rb_users set password='"+xma.getText()+"'  where username='"+username.getText()+"' ";//����һ��sql���
			           Statement stmt=dbConn.createStatement();  //����һ��Statement����
	                        stmt.executeUpdate(sql);  //ִ��sql���
				             System.out.println("���ݿ��޸ĳɹ�");
				             JOptionPane.showMessageDialog(null, "�޸ĳɹ�");
				   }else {
					   JOptionPane.showMessageDialog(null, "�������������벻һ��");
				   }
				   
									    }
			   
				                
				                dbConn.close();
				                System.out.println("�ر����ݿ�ɹ�");
				}
				  		
				  catch(Exception e1)
				  {
				   e1.printStackTrace();
				   System.out.print("����ʧ��");

				  }    
				
				
			}

			private String String(String text) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		btnNewButton.setBounds(94, 229, 63, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				������.run();
				frame.setVisible(false);
			}
		});
		button.setBounds(223, 229, 63, 23);
		frame.getContentPane().add(button);
		
		JLabel label_3 = new JLabel("\u7528\u6237\u540D");
		label_3.setFont(new Font("����", Font.PLAIN, 14));
		label_3.setBounds(70, 35, 63, 29);
		frame.getContentPane().add(label_3);
		
	}
}
