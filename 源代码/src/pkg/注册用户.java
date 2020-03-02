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

public class ע���û� {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					ע���û� window = new ע���û�();
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
	public ע���û�() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("�û�ע��");
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
		label.setFont(new Font("����", Font.PLAIN, 14));
		label.setBounds(44, 28, 54, 31);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(44, 102, 35, 31);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("����", Font.PLAIN, 14));
		label_2.setBounds(44, 176, 35, 31);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u7535\u8BDD");
		label_3.setFont(new Font("����", Font.PLAIN, 14));
		label_3.setBounds(232, 32, 35, 31);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u5730\u5740");
		label_4.setFont(new Font("����", Font.PLAIN, 14));
		label_4.setBounds(232, 102, 35, 31);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u90AE\u7BB1");
		label_5.setFont(new Font("����", Font.PLAIN, 14));
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
					  //������������
				   Class.forName(driverName);
				   //������ݿ������
				   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
				   System.out.println("�������ݿ�ɹ�");
				   
				   String str1=un.getText();
				   String str2=pw.getText();
				  
				  if ((str1.length() != 0)&&(str2.length() !=0)) {
					   
				   	String sql="insert into tb_yonghu values ('"+un.getText()+"','"+pw.getText()+"','"+phone.getText()+"','"+address.getText()+"'"
				   			+ ",'"+comboBox.getSelectedItem()+"','"+mailbox.getText()+"')";
				                Statement stmt=dbConn.createStatement();  //����һ��Statement����
				                stmt.executeUpdate(sql);  //ִ��sql���
				                System.out.println("���뵽���ݿ�ɹ�");
				                JOptionPane.showMessageDialog(null, "����ɹ�");
			                         }
				                else {
				                	JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				                			"��ע��!\n�û��������벻��Ϊ��", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);		
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
		btnNewButton.setBounds(104, 229, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				��¼.run();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(260, 229, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
	}
}
