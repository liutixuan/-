package pkg;

import java.sql.*;

public class Main {

 public static void main(String [] args)

 {

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
   
   /*String sql="insert into dbo.tb_users(id,username,password,flag) values('5','xiaomai',666,0)";        
                Statement stmt=dbConn.createStatement();//����һ��Statement����
                stmt.executeUpdate(sql);//ִ��sql���
                System.out.println("���뵽���ݿ�ɹ�");
                dbConn.close();
                System.out.println("�ر����ݿ�ɹ�");*/
}

  catch(Exception e)
  {
   e.printStackTrace();
   System.out.print("����ʧ��");

  }    
 }

}