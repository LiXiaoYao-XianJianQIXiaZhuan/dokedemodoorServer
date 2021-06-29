package dao.starUpvoteDao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.starUpvoteDao.IStarUpvoteDao;
import pojo.starUpvote.StarUpvote;
import util.publicDBUtil.DBUtil;
import util.tripDBUtil.TripDBUtil;

public class StarUpvoteDaoImpl implements IStarUpvoteDao{

	@Override
	public ArrayList<StarUpvote> queryAllStarUpvote() {
		StarUpvote starUpvote = null;
		ArrayList<StarUpvote> starUpvotes = new ArrayList<StarUpvote>();
		ResultSet rs = null;
		try {
			String sql = "select * from starupvote order by time desc limit 0,1000";
			rs = TripDBUtil.executeQuery(sql, null);
			while(rs.next()) {
				int id = rs.getInt("id");
				String avatar = rs.getString("avatar");
				String nickname = rs.getString("nickname");
				String time = rs.getString("time");
				String type = rs.getString("type");
				String content = rs.getString("content");
				int microblogid = rs.getInt("microblogid");
				starUpvote = new StarUpvote(id,avatar,nickname,time,type,content,microblogid);
				starUpvotes.add(starUpvote);
			}
			return starUpvotes;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("dao层获取数据失败了");
			return null;
		}finally {
			try {
				TripDBUtil.closeAll(rs, TripDBUtil.pstmt, TripDBUtil.connection);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean addStarUpvote(StarUpvote starUpvote) {
		String sql = "insert into starupvote(avatar,nickname,time,type,content,microblogid) values(?,?,?,?,?,?)";
		Object[] params = {starUpvote.getAvatar(),starUpvote.getNickname(),starUpvote.getTime(),starUpvote.getType(),starUpvote.getContent(),starUpvote.getMicroblogid()};
		int id = TripDBUtil.executeUpdateGet(sql, params);
		if(id>-1) {
			starUpvote.setId(id);
			System.out.println("添加明星点赞转发数据成功");
			return true;
		}else {
			System.out.println("添加明星点赞转发数据失败");
			return false;
		}
	}

	@Override
	public boolean updateStarUpvote(StarUpvote starUpvote) {
		String sql = "update starupvote set avatar=?,nickname=?,time=?,content=?,microblogid=? where id=?";
		Object[] params = {starUpvote.getAvatar(),starUpvote.getNickname(),starUpvote.getTime(),starUpvote.getType(),starUpvote.getContent(),starUpvote.getMicroblogid(),starUpvote.getId()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public boolean deleteStarUpvoteByid(int id) {
		String sql = "delete from starupvote where id=? ";
		Object[] params = {id};
		return TripDBUtil.executeUpdate(sql, params);
	}

	@Override
	public StarUpvote queryStarUpvoteByMicroblogid(int id,String type) {
		String sql ="select * from starupvote where microblogid=? and type=?";
		Object[] params = {id,type};
		ResultSet rs = TripDBUtil.executeQuery(sql, params);
		StarUpvote starupvote = null;
		try {
			if(rs.next()) {
				int starupvoteid = rs.getInt("id");
				String avatar = rs.getString("avatar");
				String nickname = rs.getString("nickname");
				String time = rs.getString("time");
				String s_type = rs.getString("type");
				String content = rs.getString("content");
				int microblogid = rs.getInt("microblogid");
				starupvote = new StarUpvote(starupvoteid,avatar,nickname,time,s_type,content,microblogid);
			}
			return starupvote;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}finally {
			try {
				TripDBUtil.closeAll(rs, TripDBUtil.pstmt, TripDBUtil.connection);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
}
