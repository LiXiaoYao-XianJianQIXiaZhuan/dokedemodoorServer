package textMusic.testMusicDao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import dao.musicDao.IMusicDao;
import dao.musicDao.impl.MusicDaoImpl;
import pojo.music.Album;

public class TestMusicDao {
	
	
	IMusicDao imd = new MusicDaoImpl();
	@Test
	public void testQueryAllAlbum() {
		ArrayList<Album> albums = new ArrayList<Album>();
		albums = imd.queryAllAlbum();
		assertEquals(false,albums.isEmpty());
		System.out.println(albums.toString());
	}
}
