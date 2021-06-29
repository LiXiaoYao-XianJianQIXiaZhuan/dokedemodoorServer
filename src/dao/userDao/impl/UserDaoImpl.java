package dao.userDao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.userDao.IUserDao;
import pojo.user.User;
import util.publicDBUtil.DBUtil;

public class UserDaoImpl implements IUserDao{

	@Override
	public User queryUserByUserid(String userid) {
		String sql = "select * from user where user_id=?";
		Object[] params = {userid};
		ResultSet rs = DBUtil.executeQuery(sql, params);
		User user = new User();
		try {
			while(rs.next()) {
				int id = rs.getInt("id");
				String user_id = rs.getString("user_id");
				String avatar = rs.getString("avatar");
				String nickname = rs.getString("nickname");
				int gender = rs.getInt("gender");
				int fans = rs.getInt("fans");
				int focus = rs.getInt("focus");
				int love = rs.getInt("love");
				int star = rs.getInt("star");
				user = new User(id,user_id,avatar,nickname,gender,fans,focus,love,star);
			}
			return user;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}finally {
			try {
				DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean addUser(User user) {
		String sql = "insert into user(user_id,avatar,nickname,gender,fans,focus,love,star) value(?,?,?,?,?,?,?,?)";
		Object[] params = {user.getUser_id(),user.getAvatar(),user.getNickname(),user.getGender(),user.getFans(),user.getFocus(),user.getLove(),user.getStar()};
		return DBUtil.executeUpdate(sql, params);
	}
	
}
