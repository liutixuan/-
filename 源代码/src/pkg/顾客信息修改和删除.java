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
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class �˿���Ϣ�޸ĺ�ɾ�� {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					�˿���Ϣ�޸ĺ�ɾ�� window = new �˿���Ϣ�޸ĺ�ɾ��();
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
	public �˿���Ϣ�޸ĺ�ɾ��() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("�˿���Ϣ�޸ĺ�ɾ��");
		frame.setBounds(100, 100, 483, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7F16\u53F7\u67E5\u8BE2");
		label.setFont(new Font("����", Font.PLAIN, 14));
		label.setBounds(60, 39, 60, 31);
		frame.getContentPane().add(label);
		
		JTextArea cno = new JTextArea();
		cno.setBounds(124, 43, 102, 27);
		frame.getContentPane().add(cno);
		
		JTextArea cname = new JTextArea();
		cname.setBounds(124, 88, 102, 27);
		frame.getContentPane().add(cname);
		
		JTextArea ano = new JTextArea();
		ano.setBounds(124, 186, 102, 27);
		frame.getContentPane().add(ano);
		
		JTextArea mno = new JTextArea();
		mno.setBounds(124, 246, 102, 27);
		frame.getContentPane().add(mno);
		
		JTextArea cage = new JTextArea();
		cage.setBounds(319, 43, 102, 27);
		frame.getContentPane().add(cage);
		
		JTextArea caddress = new JTextArea();
		caddress.setBounds(319, 88, 102, 27);
		frame.getContentPane().add(caddress);
		
		JTextArea cphone = new JTextArea();
		cphone.setBounds(319, 137, 102, 27);
		frame.getContentPane().add(cphone);
		
		JTextArea cdate = new JTextArea();
		cdate.setBounds(319, 186, 138, 27);
		frame.getContentPane().add(cdate);
		
		JTextArea csymptom = new JTextArea();
		csymptom.setBounds(319, 246, 102, 27);
		frame.getContentPane().add(csymptom);
		
		JTextArea csex = new JTextArea();
		csex.setBounds(124, 137, 102, 27);
		frame.getContentPane().add(csex);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(60, 84, 35, 31);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setFont(new Font("����", Font.PLAIN, 14));
		label_2.setBounds(60, 133, 35, 31);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u7ECF\u529E\u4EBA");
		label_3.setFont(new Font("����", Font.PLAIN, 14));
		label_3.setBounds(60, 182, 42, 31);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("\u5DF2\u8D2D\u836F\u54C1");
		label_4.setFont(new Font("����", Font.PLAIN, 14));
		label_4.setBounds(60, 238, 60, 39);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("\u5E74\u9F84");
		label_5.setFont(new Font("����", Font.PLAIN, 14));
		label_5.setBounds(257, 39, 42, 31);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("\u4F4F\u5740");
		label_6.setFont(new Font("����", Font.PLAIN, 14));
		label_6.setBounds(257, 84, 42, 31);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("\u7535\u8BDD");
		label_7.setFont(new Font("����", Font.PLAIN, 14));
		label_7.setBounds(257, 133, 35, 31);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("\u5F55\u5165\u65E5\u671F");
		label_8.setFont(new Font("����", Font.PLAIN, 14));
		label_8.setBounds(257, 182, 60, 31);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("\u75C7\u72B6");
		label_9.setFont(new Font("����", Font.PLAIN, 14));
		label_9.setBounds(257, 242, 42, 31);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("\u5907\u6CE8");
		label_10.setFont(new Font("����", Font.PLAIN, 14));
		label_10.setBounds(60, 287, 42, 31);
		frame.getContentPane().add(label_10);
		
		JTextArea cremark = new JTextArea();
		cremark.setBounds(124, 291, 215, 27);
		frame.getContentPane().add(cremark);
		
		JButton xiugai = new JButton("\u67E5\u8BE2");
		xiugai.addActionListener(new ActionListener() {
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
				   
				   String sql1 = "select count(*) from client where cno='"+cno.getText()+"'";//����Ҳ����д��select *,��ͬ�ķ���				
				   Statement sta1 = dbConn.createStatement();
				   ResultSet rs1 = sta1.executeQuery(sql1);
					   int count = 0;
					   while (rs1.next()) {
					   count = rs1.getInt(1);
					   }
			          
                  String str=cno.getText();
                  if((count == 0)||(str.length()==0)) {					       
			             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
		               	"��ע�����¼���\n1����Ų���Ϊ���Ҵ���\n2����ѯ���������ż���", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);
			   }else {
				   
				                String sql="select * from client where cno='"+cno.getText()+"'";//����һ��sql���
					            System.out.println(sql);
					            Statement sta = dbConn.createStatement();
								   ResultSet rs = sta.executeQuery(sql);
								   while(rs.next()){    //next������ȡ���������
									    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)
									    +" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9)
									    +" "+rs.getString(10)+" "+rs.getString(11));     //getString��n����ȡ��n�е�����,���ݿ��е������Ǵ�1��ʼ��
									        
									           String str2=rs.getString(2);
									           String str3=rs.getString(3);
									           String str4=rs.getString(4);
									           String str5=rs.getString(5);
									           String str6=rs.getString(6);
									           String str7=rs.getString(7);
									           String str8=rs.getString(8);
									           String str9=rs.getString(9);
									           String str10=rs.getString(10);
									           String str11=rs.getString(11);
									       
												cname.setText((String)rs.getString(2));
												csex.setText((String)rs.getString(3));
												cage.setText((String)rs.getString(4));
												caddress.setText((String)rs.getString(5));
												cphone.setText((String)rs.getString(6));
												csymptom.setText((String)rs.getString(7));
												mno.setText((String)rs.getString(8));
												ano.setText((String)rs.getString(9));
												cdate.setText((String)rs.getString(10));
												cremark.setText((String)rs.getString(11));

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
		xiugai.setBounds(34, 337, 79, 23);
		frame.getContentPane().add(xiugai);
		
		JButton shanchu = new JButton("\u5220\u9664");
		shanchu.addActionListener(new ActionListener() {
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

				   String sql1 = "select count(*) from client where  cno='"+cno.getText()+"'";//����Ҳ����д��select *,��ͬ�ķ���				
				   Statement sta = dbConn.createStatement();
				   ResultSet rs = sta.executeQuery(sql1);
					   int count = 0;
					   while (rs.next()) {
					   count = rs.getInt(1);
					   }
			          
                     String str=cno.getText();
					   if((count == 0)||(str.length()==0)) {					       
					             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				               	"��ע�����¼���\n1����Ų���Ϊ���Ҵ���\n2��ɾ�����������ż���", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);
					   }
				   else {
					   String sql="delete from client where cno='"+cno.getText()+"'";//����һ��sql���
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
		shanchu.setBounds(246, 337, 79, 23);
		frame.getContentPane().add(shanchu);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				������Ϣ����֮�˿�.run();
				frame.setVisible(false);
			}
		});
		button.setBounds(356, 337, 79, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
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
				   String str=csex.getText();
				   String str1=cno.getText();
				   if((str1.length()!= 0)&&(str.equals("��")||str.equals("Ů"))) {
			   			
				   String sql="update client set cname='"+cname.getText()+"',csex='"+csex.getText()+"',cage='"+cage.getText()+"'"
				   		+ ",caddress='"+caddress.getText()+"',cphone='"+cphone.getText()+"',csymptom='"+csymptom.getText()+"',mno='"+mno.getText()+"'"
				   				+ ",ano='"+ano.getText()+"',cdate='"+cdate.getText()+"',cremark='"+cremark.getText()+"'  where cno='"+cno.getText()+"' ";//����һ��sql���
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
		button_1.setBounds(134, 337, 79, 23);
		frame.getContentPane().add(button_1);
		
	}
}
