package cn.et.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Dbutil {
	static Properties p=new Properties();
	static {
		
		InputStream is=Dbutil.class.getResourceAsStream("/jdbc.properties");
		try {
			p.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws Exception{
		String url=p.getProperty("url");
		String driverClass=p.getProperty("driverClass");
		String userName=p.getProperty("userName");
		String password=p.getProperty("password");
		Class.forName(driverClass);
		Connection conn=DriverManager.getConnection(url, userName, password);
		return conn;
	}
	public static List<Map> query(String sql) throws Exception{
		Connection conn=getConnection();
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		ResultSetMetaData rsmd=rs.getMetaData();
		List list=new ArrayList();
		//获取列的个数
		int columnCount =rsmd.getColumnCount();
		while(rs.next()){
			Map map=new HashMap();
			for(int i=1;i<=columnCount;i++){
				String colName=rsmd.getColumnName(i);
				String colValue=rs.getString(i);
				map.put(colName, colValue);
			}
			list.add(map);
		}
		return list;
	}
	public static void main(String[] args) throws Exception {
		List<Map> result=query("select * from desk");
		System.out.println(result);
	}
	public static void execute(String sql){
		
		try {
			Connection conn=Dbutil.getConnection();
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
