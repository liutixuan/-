package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class 药品信息报表 {

	private JFrame frame;
	private JTable table;
			public static void run() {
				try {
					药品信息报表 window = new 药品信息报表();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	public 药品信息报表() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("药品信息报表");
		frame.setBounds(100, 100, 499, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JButton btnNewButton = new JButton("\u62A5\u8868\u4E0B\u8F7D");
		btnNewButton.setBounds(232, 21, 93, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";
				  String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=yiyao";
				  String userName="sa";
				  String userPwd="19971212";
				  
				  try
				  {
					  //加载驱动程序
				   Class.forName(driverName);
				   //获得数据库的连接
				   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
				   System.out.println("连接数据库成功");
				  
				   Statement statement = dbConn.createStatement

						   (ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
						   		    ResultSet rs = statement.executeQuery("select * from medicine");
						   		    ResultSetMetaData rsmd=rs.getMetaData();//得到结果集rs的结构，比如字段数、字段名
						   		// rs.getMetaData().getTableName(1);//返回表名
						   		 //rs.getMetaData().getColumnCount();//取得列数
				             
						   						    
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
						    while(rs.next()){                    //循环遍历查询结果集 	
						    	for(int j=1;j<=count;j++)
						    	{
						    	obj[rowCount][j-1]=rs.getString(j); 
						        a [rowCount][j-1]=rs.getString(j); 
						    	}
						    	rowCount++;						    
						    }
						  						    
						    HSSFWorkbook workbook=new HSSFWorkbook();
						    HSSFSheet sheet=workbook.createSheet("药品表");
							
							HSSFRow row1=sheet.createRow(0);//创建第一行
							
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
							 
							FileOutputStream out=new FileOutputStream("D:\\yaopin.xls");
							workbook.write(out);
							out.close();
							JOptionPane.showMessageDialog(null, "导出成功(默认路径D://)");
				                dbConn.close();
				                System.out.println("关闭数据库成功");
				}
				  		
				  catch(Exception e1)
				  {
				   e1.printStackTrace();
				   System.out.print("连接失败");

				  }    
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u663E\u793A\u5168\u90E8\u836F\u54C1\u4FE1\u606F");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				String dbURL = "jdbc:sqlserver://localhost:1433;DatabaseName=yiyao";
				String userName = "sa";
				String userPwd = "19971212";

				try {
					// 加载驱动程序
					Class.forName(driverName);
					// 获得数据库的连接
					Connection dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
					System.out.println("连接数据库成功");
					
					String sql = "select * from medicine";
					System.out.println(sql);
					Statement sta = dbConn.createStatement();					
					ResultSet rs = sta.executeQuery(sql);
					
					
					ResultSetMetaData data=rs.getMetaData();
					int count=data.getColumnCount();
					int flag = 0;
					String[][] object = new String[100][4];
					//rs.first();
					//rs.previous();
					while (rs.next()) {
						object[flag][0] = (String)rs.getString("mno");
						object[flag][1] = (String)rs.getString("mname");
						object[flag][2] = (String)rs.getString("mmode");
						object[flag][3] = (String)rs.getString("mefficacy");
						flag++;
					}									
					table.setModel(new DefaultTableModel(object, new String[] { "\u7F16\u53F7", "\u540D\u79F0",
							"\u670D\u7528\u65B9\u6CD5", "\u529F\u6548" }));
			  
					
					
					dbConn.close();
					System.out.println("关闭数据库成功");
				}catch (Exception e1) {
					e1.printStackTrace();
					System.out.print("连接失败");

				}
				 
				         
			}
		});
		btnNewButton_1.setBounds(47, 21, 141, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u8FD4\u56DE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				主界面.run();
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(358, 21, 93, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 463, 215);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"mno", "mname", "mmode", "mefficacy"
			}
		));
		scrollPane.setViewportView(table);
	}
}
