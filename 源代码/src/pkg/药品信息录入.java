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

public class ҩƷ��Ϣ¼�� {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					ҩƷ��Ϣ¼�� window = new ҩƷ��Ϣ¼��();
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
	public ҩƷ��Ϣ¼��() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("ҩƷ��Ϣ¼��");
		frame.setBounds(100, 100, 450, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7F16\u53F7");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel.setBounds(73, 28, 62, 25);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label_1 = new JLabel("\u540D\u79F0");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(73, 63, 44, 42);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u670D\u7528\u65B9\u6CD5");
		label_2.setFont(new Font("����", Font.PLAIN, 14));
		label_2.setBounds(73, 115, 72, 42);
		frame.getContentPane().add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("\u529F\u6548");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(73, 167, 35, 47);
		frame.getContentPane().add(lblNewLabel_1);
		
		JTextArea mno = new JTextArea();
		mno.setBounds(159, 29, 102, 27);
		frame.getContentPane().add(mno);
		
		JTextArea mname = new JTextArea();
		mname.setBounds(159, 73, 102, 27);
		frame.getContentPane().add(mname);
		
		JTextArea mefficacy = new JTextArea();
		mefficacy.setBounds(159, 179, 102, 27);
		frame.getContentPane().add(mefficacy);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5185\u670D", "\u5916\u7528"}));
		comboBox.setBounds(159, 123, 102, 27);
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
					  //������������
				   Class.forName(driverName);
				   //������ݿ������
				   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
				   System.out.println("�������ݿ�ɹ�");
				   
				   String str=mno.getText();
				  // String str1=mmode.getText();
				   if (str.length() !=0) {
					   
				   	String sql="insert into medicine values ('"+mno.getText()+"','"+mname.getText()+"','"+comboBox.getSelectedItem()+"','"+mefficacy.getText()+"')";
				                Statement stmt=dbConn.createStatement();  //����һ��Statement����
				                stmt.executeUpdate(sql);  //ִ��sql���
				                System.out.println("���뵽���ݿ�ɹ�");
				                JOptionPane.showMessageDialog(null, "����ɹ�");
			                         }
				                else {
				                	JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				                			"��ע�����¼���\n1����Ų���Ϊ��\n2�����÷���Ϊ�ڷ�������", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);
				                			
				                			
				                }
				                
				                dbConn.close();
				                System.out.println("�ر����ݿ�ɹ�");
				}
				  
						
						
				  catch(Exception e)
				  {
				   e.printStackTrace();
				   System.out.print("����ʧ��");

				  }    
				
			}
		});
		
		button.setBounds(83, 233, 77, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				������Ϣ����֮ҩƷ.run();
				frame.setVisible(false);
			}
		});
		button_1.setBounds(204, 233, 77, 23);
		frame.getContentPane().add(button_1);
		
	}
}
