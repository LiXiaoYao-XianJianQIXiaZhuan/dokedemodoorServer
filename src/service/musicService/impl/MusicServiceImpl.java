package service.musicService.impl;

import java.util.ArrayList;

import dao.musicDao.IMusicDao;
import dao.musicDao.impl.MusicDaoImpl;
import pojo.music.Album;
import pojo.music.Music;
import service.musicService.IMusicService;

public class MusicServiceImpl implements IMusicService {
	
	IMusicDao imd = new MusicDaoImpl();
	@Override
	public ArrayList<Music> queryMusicByAlbumid(int albumid) {
		return imd.queryMusicByAlbumid(albumid);
	}
	@Override
	public ArrayList<Album> queryAllAlbum() {
		return imd.queryAllAlbum();
	}
	@Override
	public ArrayList<Music> queryAllMusic() {
		// TODO 自动生成的方法存根
		return imd.queryAllMusic();
	}
	
	

}
