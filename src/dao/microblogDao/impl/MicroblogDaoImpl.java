package dao.microblogDao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import dao.microblogDao.IMicroblogDao;
import pojo.microblog.Microblog;
import pojo.microblog.Upload_Microblog;
import util.publicDBUtil.DBUtil;

public class MicroblogDaoImpl implements IMicroblogDao {

	@Override
	public ArrayList<Microblog> queryAllMicroblog() {
		String sql = "select * from microblog";
		ResultSet rs = DBUtil.executeQuery(sql, null);
		Microblog microblog = null;
		ArrayList<Microblog> microblogs = new ArrayList<Microblog>();
		try {
			while (rs.next()) {
				int id = rs.getInt("id");	//获取微博id
				String avatar = rs.getString("avatar");//获取微博头像
				String nickname = rs.getString("nickname");//获取微博昵称
				String time = rs.getString("time");//获取微博发布时间
				String type = rs.getString("type");//获取微博类型
				String content = rs.getString("content");//获取微博内容
				String video = rs.getString("video");
				String image = rs.getString("image");//获取微博图片
				String[] images = image.split(",");//拆分image数组
				ArrayList<String> aimages = new ArrayList<String>();
				Collections.addAll(aimages, images);
				microblog = new Microblog(id, avatar, nickname, time, content,video, aimages, type);
				microblogs.add(microblog);
			}
			return microblogs;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("获取失败");
			e.printStackTrace();
			return null;
		} finally {
			try {
				DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	public Microblog queryMicroblogById(int id) {
		Microblog microblog = new Microblog();
		String sql = "select * from microblog where id=?";
		Object[] params = { id };
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			if (rs.next()) {
				int _id = rs.getInt("id");
				String avatar = rs.getString("avatar");
				String nickname = rs.getString("nickname");
				String time = rs.getString("time");
				String type = rs.getString("type");
				String content = rs.getString("content");
				String video = rs.getString("video");
				String image = rs.getString("image");
				String[] images = image.split(",");
				ArrayList<String> aimages = new ArrayList<String>();
				Collections.addAll(aimages, images);
				microblog = new Microblog(_id, avatar, nickname, time, content,video, aimages, type);
			}
			return microblog;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		} finally {
			try {
				DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	@Override
	public boolean addMicroblog(Microblog microblog) {
		String sql = "insert into microblog(avatar,nickname,time,content,video,image,type) values(?,?,?,?,?,?,?)";
		ArrayList<String> simages = microblog.getImages();
		String images = "";
		for (int i = 0; i < simages.size(); i++) {
			if (i == simages.size() - 1) {
				images = images + simages.get(i);
			} else {
				images = images + simages.get(i) + ",";
			}
		}
		Object[] params = { microblog.getAvatar(), microblog.getNickname(), microblog.getTime(), microblog.getContent(),microblog.getVideo(),
				images, microblog.getType() };
		int id = DBUtil.executeUpdateGet(sql, params);
		if (id > -1) {
			microblog.setId(id);
			System.out.println("Dao层添加数据成功");
			return true;
		} else {
			System.out.println("Dao层添加数据失败");
			return false;
		}
	}

	@Override
	public boolean deleteMicroblogById(int id) {
		String sql = "delete from microblog where id=? ";
		Object[] params = { id };
		return DBUtil.executeUpdate(sql, params);
	}

	@Override
	public boolean updateMicroblogById(Upload_Microblog umb) {
		String sql = "update microblog set avatar=?,nickname=?,time=?,content=?,video=?,image=?,type=? where id=?";
		Object[] params = {umb.getAvatar(),umb.getNickname(),umb.getTime(),umb.getContent(),umb.getVideo(),umb.getImages(),umb.getType(),umb.getId()};
		return DBUtil.executeUpdate(sql, params);
	}

}
