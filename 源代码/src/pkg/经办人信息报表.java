package pkg;

import java.awt.EventQueue;
import java.awt.EventQueue;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ��������Ϣ���� {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					��������Ϣ���� window = new ��������Ϣ����();
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
	public ��������Ϣ����() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("��������Ϣ����");
		frame.setBounds(100, 100, 494, 324);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ano", "aname", "asex", "aphone", "aremark"
			}
		));
		
		JButton btnNewButton = new JButton("\u663E\u793A\u5168\u90E8\u7ECF\u529E\u4EBA\u4FE1\u606F");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(45, 10, 153, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u62A5\u8868\u4E0B\u8F7D");
		btnNewButton_1.addActionListener(new ActionListener() {
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
				  
				   Statement statement = dbConn.createStatement

						   (ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
						   		    ResultSet rs = statement.executeQuery("select * from agency");
						   		    ResultSetMetaData rsmd=rs.getMetaData();//�õ������rs�Ľṹ�������ֶ������ֶ���
						   		// rs.getMetaData().getTableName(1);//���ر���
						   		 //rs.getMetaData().getColumnCount();//ȡ������
				             
						   						    
							int rowCount = 0;
						    int row = 0;
						   while(rs.next()) {
						    row++;
						    }
						    System.out.println(rowCount);
						    int count=rsmd.getColumnCount(); 

						    System.out.println(count);
						    System.out.println(rsmd.getColumnName(1));
						    
						    String [] str=new String[11];
						    for(int i=1;i<=count;i++)
						    {
						    	str [i-1]=rsmd.getColumnName(i);
						    	}
						    Object[][] obj= new Object[row][11];
						    
						   rs.first();
						   rs.previous();
						   String [][]a= new String [100][100];
						    while(rs.next()){                    //ѭ��������ѯ����� 	
						    	for(int j=1;j<=count;j++)
						    	{
						    	obj[rowCount][j-1]=rs.getString(j); 
						        a [rowCount][j-1]=rs.getString(j); 
						    	}
						    	rowCount++;						    
						    }
						  						    
						    HSSFWorkbook workbook=new HSSFWorkbook();
						    HSSFSheet sheet=workbook.createSheet("�����˱�");
							
							HSSFRow row1=sheet.createRow(0);//������һ��
							
							for(int i=0;i<count;i++)
							{
								row1.createCell(i).setCellValue(rsmd.getColumnName(i+1));
							}
							 
							
							 rowCount=0;
							for(int i=1;i<=10;i++)
							{
								
								HSSFRow row_i=sheet.createRow(i);
								
								for(int j=0;j<count;j++)
								{
									
									row_i.createCell(j).setCellValue( a [rowCount][j]);
									
									
								}
								rowCount++;
							}
							 
							FileOutputStream out=new FileOutputStream("D:\\jingbanren.xls");
							workbook.write(out);
							out.close();
							JOptionPane.showMessageDialog(null, "�����ɹ�(Ĭ��·��D://)");
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
		btnNewButton_1.setBounds(230, 10, 93, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				������.run();
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(363, 10, 93, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 50, 458, 226);
		frame.getContentPane().add(scrollPane);
		
		
		scrollPane.setViewportView(table);
	}
}
