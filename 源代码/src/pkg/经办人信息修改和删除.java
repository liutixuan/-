package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class ��������Ϣ�޸ĺ�ɾ�� {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					��������Ϣ�޸ĺ�ɾ�� window = new ��������Ϣ�޸ĺ�ɾ��();
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
	public ��������Ϣ�޸ĺ�ɾ��() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("��������Ϣɾ�����޸�");
		frame.setBounds(100, 100, 450, 382);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7\u67E5\u8BE2");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(87, 33, 62, 25);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u59D3\u540D");
		label_2.setFont(new Font("����", Font.PLAIN, 14));
		label_2.setBounds(87, 79, 41, 35);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u6027\u522B");
		label_3.setFont(new Font("����", Font.PLAIN, 14));
		label_3.setBounds(87, 138, 41, 25);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u7535\u8BDD");
		label_4.setFont(new Font("����", Font.PLAIN, 14));
		label_4.setBounds(87, 183, 41, 35);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u5907\u6CE8");
		label_5.setFont(new Font("����", Font.PLAIN, 14));
		label_5.setBounds(87, 226, 41, 48);
		frame.getContentPane().add(label_5);
		
		JTextArea ano = new JTextArea();
		ano.setBounds(150, 34, 102, 27);
		frame.getContentPane().add(ano);
		
		JTextArea aname = new JTextArea();
		aname.setBounds(150, 85, 102, 27);
		frame.getContentPane().add(aname);
		
		JTextArea aphone = new JTextArea();
		aphone.setBounds(150, 189, 102, 27);
		frame.getContentPane().add(aphone);
		
		JTextArea aremark = new JTextArea();
		aremark.setBounds(150, 239, 192, 27);
		frame.getContentPane().add(aremark);
		
		JTextArea asex = new JTextArea();
		asex.setBounds(150, 139, 102, 27);
		frame.getContentPane().add(asex);
		
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
				   
				   String sql1 = "select count(*) from agency  where ano='"+ano.getText()+"'";//����Ҳ����д��select *,��ͬ�ķ���				
				   System.out.println(sql1);
				   Statement sta1 = dbConn.createStatement();
				   ResultSet rs1 = sta1.executeQuery(sql1);
					   int count = 0;
					   while (rs1.next()) {
					   count = rs1.getInt(1);
					   }   
                   String str=ano.getText();
                   if((count == 0)||(str.length()==0)) {					       
			             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
		               	"��ע�����¼���\n1����Ų���Ϊ���Ҵ���\n2����ѯ���������ż���", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);
			   }else {
				   
				                String sql="select * from agency where ano='"+ano.getText()+"'";//����һ��sql���
					            System.out.println(sql);
					            Statement sta = dbConn.createStatement();
								   ResultSet rs = sta.executeQuery(sql);
								   while(rs.next()){    //next������ȡ���������
									    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
									                         //getString��n����ȡ��n�е�����,���ݿ��е������Ǵ�1��ʼ��
									           //String str1=rs.getString(1);
									          /* String str2=rs.getString(2);
									           String str3=rs.getString(3);
									           String str4=rs.getString(4);*/
												aname.setText((String)rs.getString(2));
												asex.setText((String)rs.getString(3));
												aphone.setText((String)rs.getString(4));
												aremark.setText((String)rs.getString(5));

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
		button.setBounds(31, 284, 77, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
				  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=yiyao";
				  String userName="sa";
				  String userPwd="19971212";
				try {
					//������������
				   Class.forName(driverName);
				   //������ݿ������
				   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
				   System.out.println("�������ݿ�ɹ�");

				   String sql1 = "select count(*) from agency where  ano='"+ano.getText()+"'";//����Ҳ����д��select *,��ͬ�ķ���				
				   Statement sta = dbConn.createStatement();
				   ResultSet rs = sta.executeQuery(sql1);
					   int count = 0;
					   while (rs.next()) {
					   count = rs.getInt(1);
					   }
			          
                     String str=ano.getText();
					   if((count == 0)||(str.length()==0)) {					       
					             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				               	"��ע�����¼���\n1����Ų���Ϊ���Ҵ���\n2��ɾ�����������ż���", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);
					   }
				   else {
					   String sql="delete from agency where ano='"+ano.getText()+"'";//����һ��sql���
			           Statement stmt=dbConn.createStatement();  //����һ��Statement����
                         stmt.executeUpdate(sql);  //ִ��sql���
				             System.out.println("���ݿ�ɾ���ɹ�");
				             JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
				   }
					             dbConn.close();
					             System.out.println("���ݿ�رճɹ�");//�ر����ݿ������
					         }  
				   
				
				catch(Exception e1)
				    {
					 e1.printStackTrace();
				     System.out.print("����ʧ��");

					 }    
					         
			}
			
			
		});
		button_1.setBounds(232, 284, 77, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				������Ϣ����֮������.run();
				frame.setVisible(false);
			}
		});
		button_2.setBounds(334, 284, 77, 23);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("\u4FEE\u6539");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
				  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=yiyao";
				  String userName="sa";
				  String userPwd="19971212";
				try {
					//������������
				   Class.forName(driverName);
				   //������ݿ������
				   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
				   System.out.println("�������ݿ�ɹ�");

				   String str1=ano.getText();
				   String str=asex.getText();
				   if((str1.length()!= 0)&&(str.equals("��")||str.equals("Ů"))) {
					   			
				   String sql="update agency set aname='"+aname.getText()+"',asex='"+asex.getText()+"',aphone='"+aphone.getText()+"',aremark='"+aremark.getText()+"'  where ano='"+ano.getText()+"' ";//����һ��sql���
			           Statement stmt=dbConn.createStatement();  //����һ��Statement����
                    stmt.executeUpdate(sql);  //ִ��sql���
				             System.out.println("���ݿ��޸ĳɹ�");
				             JOptionPane.showMessageDialog(null, "�޸ĳɹ�������޷��޸ģ�");
				   }else {
					   JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				               	"��ע�����¼���\n1����Ų����޸�\n2���Ա�Ϊ�л�Ů", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);
				   }
				           dbConn.close();
					             System.out.println("���ݿ�رճɹ�");//�ر����ݿ������
					         }  
				   
				
				catch(Exception e1)
				    {
					 e1.printStackTrace();
				     System.out.print("����ʧ��");

					 }    
				
				
				
			}
		});
		button_3.setBounds(133, 284, 77, 23);
		frame.getContentPane().add(button_3);
		
	}

}
