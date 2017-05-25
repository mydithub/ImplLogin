package com.mademeng.DB;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DB {
	static DataSource DS = null;
	static Connection con = null;
	static ThreadLocal<Connection> tc = new InheritableThreadLocal<Connection>();
	static {
		createDS();
	}

	/**
	 * 创建数据源（连接池）
	 */
	private static void createDS() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("src/dbcp.properties"));
			DS = BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 获得Connection
	 * 
	 * @return Connection
	 * @throws SQLException
	 */
	public static Connection getCon() throws SQLException {
		con = tc.get();//
		if (con == null) {
			con = DS.getConnection();
			tc.set(con);
		}
		return con;
	}

	/**
	 * @throws SQLException
	 */
	public static void close() throws SQLException {
		con = tc.get();// 从ThreadLocal中获得绑定的Connection
		con.close();
	}
}
