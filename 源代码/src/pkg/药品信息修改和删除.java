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
import java.util.*;
import java.awt.event.ActionEvent;



public class ҩƷ��Ϣ�޸ĺ�ɾ�� {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					ҩƷ��Ϣ�޸ĺ�ɾ�� window = new ҩƷ��Ϣ�޸ĺ�ɾ��();
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
	public ҩƷ��Ϣ�޸ĺ�ɾ��() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("ҩƷ��Ϣ�޸ĺ�ɾ��");
		frame.setBounds(100, 100, 488, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label_1 = new JLabel("\u7F16\u53F7\u67E5\u8BE2");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(94, 35, 62, 25);
		frame.getContentPane().add(label_1);
		
		JTextArea mno = new JTextArea();
		mno.setBounds(180, 36, 102, 27);
		frame.getContentPane().add(mno);
		
		JTextArea mname = new JTextArea();
		mname.setBounds(180, 80, 102, 27);
		frame.getContentPane().add(mname);
		
		JTextArea mmode = new JTextArea();
		mmode.setBounds(180, 132, 102, 27);
		frame.getContentPane().add(mmode);
		
		JTextArea mefficacy = new JTextArea();
		mefficacy.setBounds(180, 179, 263, 27);
		frame.getContentPane().add(mefficacy);
		
		JLabel label_2 = new JLabel("\u540D\u79F0");
		label_2.setFont(new Font("����", Font.PLAIN, 14));
		label_2.setBounds(94, 70, 44, 42);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u670D\u7528\u65B9\u6CD5");
		label_3.setFont(new Font("����", Font.PLAIN, 14));
		label_3.setBounds(94, 122, 72, 42);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u529F\u6548");
		label_4.setFont(new Font("����", Font.PLAIN, 14));
		label_4.setBounds(94, 174, 35, 33);
		frame.getContentPane().add(label_4);
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
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

				   String str1=mno.getText();
				   String str=mmode.getText();
				   if((str1.length()!= 0)&&(str.equals("�ڷ�")||str.equals("����"))) {
					   			
				       String sql="update medicine set mname='"+mname.getText()+"',mmode='"+mmode.getText()+"',mefficacy='"+mefficacy.getText()+"'  where mno='"+mno.getText()+"' ";//����һ��sql���
			           Statement stmt=dbConn.createStatement();  //����һ��Statement����
                       stmt.executeUpdate(sql);  //ִ��sql���
				             System.out.println("���ݿ��޸ĳɹ�");
				             JOptionPane.showMessageDialog(null, "�޸ĳɹ�������޷��޸ģ�");
				   }else {
					   JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				               	"��ע�����¼���\n1����Ų����޸�\n2�����÷���Ϊ�ڷ�������", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);
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
		button.setBounds(138, 236, 79, 23);
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

				   String sql1 = "select count(*) from medicine where  mno='"+mno.getText()+"'";//����Ҳ����д��select *,��ͬ�ķ���				
				   Statement sta = dbConn.createStatement();
				   ResultSet rs = sta.executeQuery(sql1);
					   int count = 0;
					   while (rs.next()) {
					   count = rs.getInt(1);
					   }
			          
                     String str=mno.getText();
					   if((count == 0)||(str.length()==0)) {					       
					             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				               	"��ע�����¼���\n1����Ų���Ϊ���Ҵ���\n2��ɾ�����������ż���", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);
					   }
				   else {
					   String sql="delete from medicine where mno='"+mno.getText()+"'";//����һ��sql���
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
		
		button_1.setBounds(244, 234, 79, 27);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				������Ϣ����֮ҩƷ.run();
				frame.setVisible(false);
			}
		});
		button_2.setBounds(349, 234, 79, 27);
		frame.getContentPane().add(button_2);
		
		JButton chaxun = new JButton("\u67E5\u8BE2");
		chaxun.addActionListener(new ActionListener() {
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
				   
				   String sql1 = "select count(*) from medicine  where mno='"+mno.getText()+"'";//����Ҳ����д��select *,��ͬ�ķ���				
				   System.out.println(sql1);
				   Statement sta1 = dbConn.createStatement();
				   ResultSet rs1 = sta1.executeQuery(sql1);
					   int count = 0;
					   while (rs1.next()) {
					   count = rs1.getInt(1);
					   }   
                   String str=mno.getText();
                   if((count == 0)||(str.length()==0)) {					       
			             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
		               	"��ע�����¼���\n1����Ų���Ϊ���Ҵ���\n2����ѯ���������ż���", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);
			   }else {
				   
				                String sql="select * from medicine where mno='"+mno.getText()+"'";//����һ��sql���
					            System.out.println(sql);
					            Statement sta = dbConn.createStatement();
								   ResultSet rs = sta.executeQuery(sql);
								   while(rs.next()){    //next������ȡ���������
									    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
									                         //getString��n����ȡ��n�е�����,���ݿ��е������Ǵ�1��ʼ��
									           //String str1=rs.getString(1);
									           String str2=rs.getString(2);
									           String str3=rs.getString(3);
									           String str4=rs.getString(4);
												mname.setText((String)rs.getString(2));
												mmode.setText((String)rs.getString(3));
												mefficacy.setText((String)rs.getString(4));

									    }
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
		chaxun.setBounds(36, 236, 79, 23);
		frame.getContentPane().add(chaxun);
		
	}
}
