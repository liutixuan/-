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

public class �ѹ�ҩƷɾ�� {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					�ѹ�ҩƷɾ�� window = new �ѹ�ҩƷɾ��();
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
	public �ѹ�ҩƷɾ��() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("�ѹ�ҩƷɾ��");
		frame.setBounds(100, 100, 450, 318);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\u67E5\u8BE2");
		label.setFont(new Font("����", Font.PLAIN, 14));
		label.setBounds(60, 25, 75, 31);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u836F\u54C1\u7F16\u53F7");
		label_1.setFont(new Font("����", Font.PLAIN, 14));
		label_1.setBounds(60, 79, 56, 31);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u836F\u54C1\u540D\u79F0");
		label_2.setFont(new Font("����", Font.PLAIN, 14));
		label_2.setBounds(60, 130, 56, 31);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\u7ECF\u529E\u4EBA");
		label_3.setFont(new Font("����", Font.PLAIN, 14));
		label_3.setBounds(60, 171, 60, 47);
		frame.getContentPane().add(label_3);
		
		JTextArea un = new JTextArea();
		un.setBounds(145, 25, 102, 27);
		frame.getContentPane().add(un);
		
		JTextArea mno = new JTextArea();
		mno.setBounds(145, 79, 102, 27);
		frame.getContentPane().add(mno);
		
		JTextArea mname = new JTextArea();
		mname.setBounds(145, 130, 102, 27);
		frame.getContentPane().add(mname);
		
		JTextArea ano = new JTextArea();
		ano.setBounds(145, 183, 102, 27);
		frame.getContentPane().add(ano);
		
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
				   
				   String sql1 = "select count(*) from ygyp  where un='"+un.getText()+"'";//����Ҳ����д��select *,��ͬ�ķ���				
				   System.out.println(sql1);
				   Statement sta1 = dbConn.createStatement();
				   ResultSet rs1 = sta1.executeQuery(sql1);
					   int count = 0;
					   while (rs1.next()) {
					   count = rs1.getInt(1);
					   }   
                  String str=un.getText();
                  if((count == 0)||(str.length()==0)) {					       
			             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
		               	"��ע�����¼���\n1����Ų���Ϊ���Ҵ���\n2����ѯ���������ż���", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);
			   }else {
				   
				                String sql="select * from ygyp where un='"+un.getText()+"'";//����һ��sql���
					            System.out.println(sql);
					            Statement sta = dbConn.createStatement();
								   ResultSet rs = sta.executeQuery(sql);
								   while(rs.next()){    //next������ȡ���������
									    System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4));
									                         //getString��n����ȡ��n�е�����,���ݿ��е������Ǵ�1��ʼ��
									           //String str1=rs.getString(1);
									          /* String str2=rs.getString(2);
									           String str3=rs.getString(3);
									           String str4=rs.getString(4);*/
												mno.setText((String)rs.getString(2));
												mname.setText((String)rs.getString(3));
												ano.setText((String)rs.getString(4));
											

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
		button.setBounds(82, 240, 77, 23);
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

				   String sql1 = "select count(*) from ygyp where  un='"+un.getText()+"'";//����Ҳ����д��select *,��ͬ�ķ���				
				   Statement sta = dbConn.createStatement();
				   ResultSet rs = sta.executeQuery(sql1);
					   int count = 0;
					   while (rs.next()) {
					   count = rs.getInt(1);
					   }
			          
                   String str=un.getText();
					   if((count == 0)||(str.length()==0)) {					       
					             JOptionPane.showMessageDialog(new JFrame().getContentPane(), 
				               	"��ע�����¼���\n1����Ų���Ϊ���Ҵ���\n2��ɾ�����������ż���", "�����������������룡", JOptionPane.INFORMATION_MESSAGE);
					   }
				   else {
					   String sql="delete from ygyp where un='"+un.getText()+"'";//����һ��sql���
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
		button_1.setBounds(187, 240, 77, 23);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				��������.run();
				frame.setVisible(false);
			}
		});
		button_2.setBounds(297, 240, 77, 23);
		frame.getContentPane().add(button_2);
	}

}
