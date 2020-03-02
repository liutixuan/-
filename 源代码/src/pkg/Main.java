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
	  //加载驱动程序
   Class.forName(driverName);
   //获得数据库的连接
   Connection dbConn=DriverManager.getConnection(dbURL,userName,userPwd);
   System.out.println("连接数据库成功");
   
   /*String sql="insert into dbo.tb_users(id,username,password,flag) values('5','xiaomai',666,0)";        
                Statement stmt=dbConn.createStatement();//创建一个Statement对象
                stmt.executeUpdate(sql);//执行sql语句
                System.out.println("插入到数据库成功");
                dbConn.close();
                System.out.println("关闭数据库成功");*/
}

  catch(Exception e)
  {
   e.printStackTrace();
   System.out.print("连接失败");

  }    
 }

}