package dao.musicDao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.musicDao.IMusicDao;
import pojo.music.Album;
import pojo.music.Music;
import util.publicDBUtil.DBUtil;

public class MusicDaoImpl implements IMusicDao {

	@Override
	public ArrayList<Music> queryMusicByAlbumid(int albumid) {
		String sql = "select * from music where albumid=?";
		Object[] params = { albumid };
		Music music = null;
		ArrayList<Music> musics = new ArrayList<Music>();
		ResultSet rs = DBUtil.executeQuery(sql, params);
		try {
			while (rs.next()) {
				int musicid = rs.getInt("musicid");
				String songName = rs.getString("songName");
				String singer = rs.getString("singer");
				String songUrl = rs.getString("songUrl");
				String videoUrl = rs.getString("videoUrl");
				int album = rs.getInt("albumid");
				String albumName = rs.getString("albumName");
				music = new Music(musicid, songName, singer, songUrl, videoUrl, album, albumName);
				musics.add(music);
			}
			return musics;
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
	public ArrayList<Album> queryAllAlbum() {
		String sql = "select * from album where albumid>0";
		ResultSet rs = DBUtil.executeQuery(sql, null);
		Album album = null;
		ArrayList<Album> albums = new ArrayList<Album>();
		//获取音乐数据
		Music music1 = null;
		String sql1 = "select * from music where albumid=?";
		ResultSet rs1 = null;
		try {
//			rs.last();
			while (rs.next()) {
				int albumid = rs.getInt("albumid");
				String albumImage = rs.getString("albumImage");
				String albumName = rs.getString("albumName");
				ArrayList<Music> songList = new ArrayList<Music>();
				Object[] params1 = {albumid};
				rs1 = DBUtil.executeQuery(sql1, params1);
				while(rs1.next()) {
					int musicid1 = rs1.getInt("musicid");
					String songName1 = rs1.getString("songName");
					String singer1 = rs1.getString("singer");
					String songUrl1 = rs1.getString("songUrl");
					String videoUrl1 = rs1.getString("videoUrl");
					int album1= rs1.getInt("albumid");
					String albumName1 = rs1.getString("albumName");
					music1 = new Music(musicid1, songName1, singer1, songUrl1, videoUrl1, album1, albumName1);
					songList.add(music1);
				}
//				rs1.close();
				album = new Album(albumid,albumImage,albumName,songList);
				albums.add(album);
			}
			return albums;
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			System.out.println("获取失败");
			e.printStackTrace();
			return null;
		} finally {
			try {
				DBUtil.closeAll(rs1, null, null);
				DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}

	@Override
	public ArrayList<Music> queryAllMusic() {
		String sql = "select * from music";
		ResultSet rs = DBUtil.executeQuery(sql, null);
		
		Music music = null;
		ArrayList<Music> musics = new ArrayList<Music>();
		try {
//			rs.last();
			while (rs.next()) {
				int musicid = rs.getInt("musicid");
				String songName = rs.getString("songName");
				String singer = rs.getString("singer");
				String songUrl = rs.getString("songUrl");
				String videoUrl = rs.getString("videoUrl");
				int album = rs.getInt("album");
				String albumName = rs.getString("albumName");
				music = new Music(musicid, songName, singer, songUrl, videoUrl, album, albumName);
				musics.add(music);
			}
			return musics;
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

}
