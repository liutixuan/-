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

public class ����ҩƷ {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public  static void run() {
				try {
					����ҩƷ window = new ����ҩƷ();
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
	public ����ҩƷ() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("����ҩƷ");
		frame.setBounds(100, 100, 364, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(65, 21, 42, 31);
		frame.getContentPane().add(label_1);
		
		JLabel label = new JLabel("\u836F\u54C1\u7F16\u53F7");
		label.setFont(new Font("����", Font.PLAIN, 14));
		label.setBounds(65, 78, 56, 31);
		frame.getContentPane().add(label);
		
		JLabel label_2 = new JLabel("\u836F\u54C1\u540D\u79F0");
		label_2.setFont(new Font("����", Font.PLAIN, 14));
		label_2.setBounds(65, 128, 56, 31);
		frame.getContentPane().add(label_2);
		
		JTextArea un = new JTextArea();
		un.setBounds(145, 25, 102, 27);
		frame.getContentPane().add(un);
		
		JTextArea mno = new JTextArea();
		mno.setBounds(145, 82, 102, 27);
		frame.getContentPane().add(mno);
		
		JTextArea mname = new JTextArea();
		mname.setBounds(145, 132, 102, 27);
		frame.getContentPane().add(mname);
		
		JLabel label_6 = new JLabel("\u7ECF\u529E\u4EBA");
		label_6.setFont(new Font("����", Font.PLAIN, 14));
		label_6.setBounds(65, 169, 60, 47);
		frame.getContentPane().add(label_6);
		
		JTextArea ano = new JTextArea();
		ano.setBounds(145, 181, 102, 27);
		frame.getContentPane().add(ano);
		
		JButton button = new JButton("\u4FDD\u5B58");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
				   String str=un.getText();
				   String str1=mno.getText();				  				  
				  if ((str.length()!= 0)&&str1.length() != 0) {
					   
				   	String sql="insert into ygyp values ('"+un.getText()+"','"+mno.getText()+"','"+mname.getText()+"','"+ano.getText()+"')";
				                Statement stmt=dbConn.createStatement();  //����һ��Statement����
				                stmt.executeUpdate(sql);  //ִ��sql���
				                System.out.println("���뵽���ݿ�ɹ�");
				                JOptionPane.showMessageDialog(null, "����ɹ�");
			                         }
				                else {
				                	JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				                			"��ע�⣡\n��ź�ҩƷ���Ʋ���Ϊ��", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);		
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
		});
		button.setBounds(84, 238, 77, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				��������.run();
				frame.setVisible(false);
			}
		});
		button_1.setBounds(213, 238, 77, 23);
		frame.getContentPane().add(button_1);
	}
}
