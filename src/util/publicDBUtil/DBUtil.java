package util.publicDBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtil {
	private static final String URL = "jdbc:mysql://localhost:3306/randomdoor";
	private static final String USER = "root";
	private static final String PASSWORD ="12345";
	public static Connection connection = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);
	}
	
	public static PreparedStatement creatPreparedStatement(String sql,Object[] params) throws ClassNotFoundException, SQLException {
		pstmt = DBUtil.getConnection().prepareStatement(sql);
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				pstmt.setObject(i+1,params[i]);
			}
		}
		return pstmt;
	}
	
	public static PreparedStatement creatPreparedStatementGet(String sql,Object[] params) throws ClassNotFoundException, SQLException {
		pstmt = DBUtil.getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				pstmt.setObject(i+1,params[i]);
			}
		}
		return pstmt;
	}
	
	public static void closeAll(ResultSet rs,Statement stmt,Connection conn) throws SQLException {
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (conn != null)
			conn.close();
	}
	
	//更新数据库中的数据(不返回主键形式）
	public static boolean executeUpdate(String sql,Object[] params) {
		try {
			pstmt = DBUtil.creatPreparedStatement(sql, params);
		
			int count = pstmt.executeUpdate();
			if(count>0) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally {
				try {
					DBUtil.closeAll(null, pstmt, connection);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
	
	//添加数据元素，返回主键
		public static int executeUpdateGet(String sql,Object[] params) {
			int key = -1;
			try {
				pstmt = DBUtil.creatPreparedStatementGet(sql, params);
				int count = pstmt.executeUpdate();
				if(count>0) {
					rs = pstmt.getGeneratedKeys();
					if(rs.next()) {
						key = rs.getInt(1);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
					try {
						DBUtil.closeAll(null, pstmt, connection);
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
			return key;
		}
	
	public static ResultSet executeQuery(String sql,Object[] params) {
		try {
			pstmt = DBUtil.creatPreparedStatement(sql, params);
			// ִ��
			rs = pstmt.executeQuery();
			// ������
			return rs;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
//			finally {
//			try {
//				if (rs != null)
//					rs.close();
//				if (pstmt != null)
//					pstmt.close();
//				if (connection != null)
//					connection.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}
}
