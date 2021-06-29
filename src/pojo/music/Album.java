package pojo.music;

import java.util.ArrayList;

public class Album {
	private int albumid;
	private String albumImage;
	private String albumName;
	private ArrayList<Music> songList;
	
	public Album() {
	}

	public Album(int albumid, String albumImage, String albumName, ArrayList<Music> songList) {
		this.albumid = albumid;
		this.albumImage = albumImage;
		this.albumName = albumName;
		this.songList = songList;
	}

	public int getAlbumid() {
		return albumid;
	}

	public void setAlbumid(int albumid) {
		this.albumid = albumid;
	}

	public String getAlbumImage() {
		return albumImage;
	}

	public void setAlbumImage(String albumImage) {
		this.albumImage = albumImage;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public ArrayList<Music> getSongList() {
		return songList;
	}

	public void setSongList(ArrayList<Music> songList) {
		this.songList = songList;
	}
	
	
	
}
