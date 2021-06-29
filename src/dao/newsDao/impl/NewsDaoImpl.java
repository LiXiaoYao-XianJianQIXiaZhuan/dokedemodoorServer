package dao.newsDao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import dao.newsDao.INewsDao;
import pojo.news.News;
import util.publicDBUtil.DBUtil;

public class NewsDaoImpl implements INewsDao {

	@Override
	public ArrayList<News> queryAllNews() {
		String sql = "select * from information";
		News news = null;
		ArrayList<News> newsList = new ArrayList<News>();
		ResultSet rs = DBUtil.executeQuery(sql, null);
		try {
			while(rs.next()) {
				int newsid = rs.getInt("id");
				int type = rs.getInt("type");
				String title = rs.getString("title");
				String time = rs.getString("time");
				String content = rs.getString("content");
				String imageUrl = rs.getString("imageUrl");
				String videoUrl = rs.getString("videoUrl");
				String[] images = imageUrl.split(",");
				ArrayList<String> aimages = new ArrayList<String>();
				Collections.addAll(aimages, images);
				news = new News(newsid,type,title,time,content,aimages,videoUrl);
				newsList.add(news);
			}
			return newsList;
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
//	添加资讯
	public boolean addNews(News information,String imageUrl) {
		String sql = "insert into information(type,title,time,content,imageUrl,videoUrl) value(?,?,?,?,?,?)";
		Object[] params = {information.getType(),information.getTitle(),information.getTime(),information.getContent(),imageUrl,information.getVideoUrl()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
//	更新资讯数据
	public boolean updateNewsById(News information, String imageUrl) {
		String sql = "update information set type=?,title=?,time=?,content=?,imageUrl=?,videoUrl=? where id=?";
		Object[] params = {information.getType(),information.getTitle(),information.getTime(),information.getContent(),imageUrl,information.getVideoUrl(),information.getNewsid()};
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public News queryNewsById(int id) {
		String sql = "select * from information where id=?";
		Object[] params = {id};
		News information = new News();
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			if(rs.next()) {
				int news_id = rs.getInt("id");
				int type = rs.getInt("type");
				String title = rs.getString("title");
				String time = rs.getString("time");
				String content = rs.getString("content");
				String imageUrl = rs.getString("imageUrl");
				String[] images = imageUrl.split(",");
				ArrayList<String> aimages  = new ArrayList<String>();
				Collections.addAll(aimages, images);
				String videoUrl = rs.getString("videoUrl");
				information = new News(news_id,type,title,time,content,aimages,videoUrl);
			}
			return information;
		}catch(SQLException e) {
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
	public boolean deleteNewsById(int id) {
		String sql = "delete from information where id=?";
		Object[] params = {id};
		return DBUtil.executeUpdate(sql, params);
	}
	
	

}
