package dao.musicDao;

import java.util.ArrayList;

import pojo.music.Album;
import pojo.music.Music;

public interface IMusicDao {
	
	
	public ArrayList<Music> queryMusicByAlbumid(int albumid);
	
	public ArrayList<Album> queryAllAlbum();
	
	public ArrayList<Music> queryAllMusic();
}
