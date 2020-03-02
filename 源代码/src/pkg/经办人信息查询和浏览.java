package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ��������Ϣ��ѯ����� {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					��������Ϣ��ѯ����� window = new ��������Ϣ��ѯ�����();
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
	public ��������Ϣ��ѯ�����() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("��������Ϣ��ѯ�����");
		frame.setBounds(100, 100, 642, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u9009\u62E9\u67E5\u8BE2\u6761\u4EF6");
		label.setFont(new Font("����", Font.PLAIN, 14));
		label.setBackground(SystemColor.menu);
		label.setBounds(20, 20, 84, 23);
		frame.getContentPane().add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u6309\u7F16\u53F7\u67E5\u8BE2", "\u6309\u59D3\u540D\u67E5\u8BE2"}));
		comboBox.setBounds(114, 20, 103, 23);
		frame.getContentPane().add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(227, 20, 84, 23);
		frame.getContentPane().add(textArea);
		
		JTextArea ano = new JTextArea();
		ano.setBounds(41, 77, 100, 23);
		frame.getContentPane().add(ano);
		
		JTextArea aname = new JTextArea();
		aname.setBounds(141, 77, 100, 23);
		frame.getContentPane().add(aname);
		
		JTextArea asex = new JTextArea();
		asex.setBounds(240, 77, 94, 23);
		frame.getContentPane().add(asex);
		
		JTextArea aphone = new JTextArea();
		aphone.setBounds(330, 77, 94, 23);
		frame.getContentPane().add(aphone);
		
		JTextArea aremark = new JTextArea();
		aremark.setBounds(424, 77, 192, 23);
		frame.getContentPane().add(aremark);
		
		JButton button = new JButton("\u67E5\u8BE2");
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

                 if(comboBox.getSelectedItem() == "����Ų�ѯ"){
              	   
              	   String sql1 = "select count(*) from agency where ano='"+textArea.getText()+"'";//����Ҳ����д��select *,��ͬ�ķ���				
 				       Statement sta1 = dbConn.createStatement();
 				       ResultSet rs1 = sta1.executeQuery(sql1);
 					   int count = 0;
 					   while (rs1.next()) {
 					   count = rs1.getInt(1);
 					   }
 			          
                   String str=textArea.getText();
                   if((count == 0)||(str.length()==0)) {					       
			             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
		               	"��ע��!\n��Ų���Ϊ���Ҵ���", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);
			   }else {
				   
			   
              	  
              	  String sql="select * from agency where ano='"+textArea.getText()+"'";//����һ��sql���
			            System.out.println(sql);
			            Statement sta = dbConn.createStatement();
						   ResultSet rs = sta.executeQuery(sql);
						   while(rs.next()){    //next������ȡ���������
							    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
							                         //getString��n����ȡ��n�е�����,���ݿ��е������Ǵ�1��ʼ��
							           String str1=rs.getString(1);
							           String str2=rs.getString(2);
							           String str3=rs.getString(3);
							           String str4=rs.getString(4);
							           String str5=rs.getString(5);
							            ano.setText((String)rs.getString(1));
										aname.setText((String)rs.getString(2));
										asex.setText((String)rs.getString(3));
										aphone.setText((String)rs.getString(4));
										aremark.setText((String)rs.getString(5));
						   }

                     }
                }

                 if(comboBox.getSelectedItem() == "��������ѯ"){
              	   
              	   String sql1 = "select count(*) from agency where aname='"+textArea.getText()+"'";//����Ҳ����д��select *,��ͬ�ķ���				
 				       Statement sta1 = dbConn.createStatement();
 				       ResultSet rs1 = sta1.executeQuery(sql1);
 					   int count = 0;
 					   while (rs1.next()) {
 					   count = rs1.getInt(1);
 					   }
 			          
                   String str=textArea.getText();
                   if((count == 0)||(str.length()==0)) {					       
			             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
		               	"��ע��!\n��Ų���Ϊ���Ҵ���", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);
			   }else {
				   
			   
              	  
              	  String sql="select * from agency where aname='"+textArea.getText()+"'";//����һ��sql���
			            System.out.println(sql);
			            Statement sta = dbConn.createStatement();
						   ResultSet rs = sta.executeQuery(sql);
						   while(rs.next()){    //next������ȡ���������
							    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
							                         //getString��n����ȡ��n�е�����,���ݿ��е������Ǵ�1��ʼ��
							           String str1=rs.getString(1);
							           String str2=rs.getString(2);
							           String str3=rs.getString(3);
							           String str4=rs.getString(4);
							           String str5=rs.getString(5);
							            ano.setText((String)rs.getString(1));
										aname.setText((String)rs.getString(2));
										asex.setText((String)rs.getString(3));
										aphone.setText((String)rs.getString(4));
										aremark.setText((String)rs.getString(5));
						   }

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
		});
		button.setBounds(321, 20, 68, 23);
		frame.getContentPane().add(button);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ano", "aname", "asex", "aphone", "aremark"
			}
		));
		
		JButton button_1 = new JButton("\u663E\u793A\u5168\u90E8\u7ECF\u529E\u4EBA\u4FE1\u606F");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=yiyao";
				String userName = "sa";
				String userPwd = "19971212";

				try {
					// ������������
					Class.forName(driverName);
					// ������ݿ������
					Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
					System.out.println("�������ݿ�ɹ�");					
					String sql = "select * from agency";
					System.out.println(sql);
					Statement sta = dbConn.createStatement();					
					ResultSet rs = sta.executeQuery(sql);
					ResultSetMetaData data=rs.getMetaData();
					int count=data.getColumnCount();
					int flag = 0;
					String[][] object = new String[100][5];
					//rs.first();
					//rs.previous();
					while (rs.next()) {
						object[flag][0] = (String)rs.getString("ano");
						object[flag][1] = (String)rs.getString("aname");
						object[flag][2] = (String)rs.getString("asex");
						object[flag][3] = (String)rs.getString("aphone");
						object[flag][4] = (String)rs.getString("aremark");
						flag++;
					}
					table.setModel(new DefaultTableModel(object, new String[] {
							"ano", "aname", "asex", "aphone", "aremark"
					}));
					dbConn.close();
					System.out.println("�ر����ݿ�ɹ�");
				}catch (Exception e) {
					e.printStackTrace();
					System.out.print("����ʧ��");

				}			
				
			}
		});
		button_1.setBounds(393, 20, 154, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				������.run();
				frame.setVisible(false);
			}
		});
		button_2.setBounds(551, 20, 68, 23);
		frame.getContentPane().add(button_2);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(53, 53, 40, 23);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u59D3\u540D");
		label_2.setFont(new Font("����", Font.PLAIN, 14));
		label_2.setBounds(153, 53, 40, 23);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u6027\u522B");
		label_3.setFont(new Font("����", Font.PLAIN, 14));
		label_3.setBounds(248, 53, 40, 23);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u7535\u8BDD");
		label_4.setFont(new Font("����", Font.PLAIN, 14));
		label_4.setBounds(341, 53, 40, 23);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u5907\u6CE8");
		label_5.setFont(new Font("����", Font.PLAIN, 14));
		label_5.setBounds(434, 53, 40, 23);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u7ECF\u529E\u4EBA\u4FE1\u606F\u6D4F\u89C8");
		label_6.setFont(new Font("����", Font.PLAIN, 14));
		label_6.setBounds(20, 110, 127, 23);
		frame.getContentPane().add(label_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 606, 193);
		frame.getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		
		
	}
}
