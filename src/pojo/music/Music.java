package pojo.music;

public class Music {
	private int musicid;
	private String songName;
	private String singer;
	private String songUrl;
	private String videoUrl;
	private int album;
	private String albumName;
	
	public Music() {
	}

	public Music(int musicid, String songName, String singer, String songUrl, String videoUrl, int album,
			String albumName) {
		this.musicid = musicid;
		this.songName = songName;
		this.singer = singer;
		this.songUrl = songUrl;
		this.videoUrl = videoUrl;
		this.album = album;
		this.albumName = albumName;
	}

	public int getMusicid() {
		return musicid;
	}

	public void setMusicid(int musicid) {
		this.musicid = musicid;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}

	public String getSongUrl() {
		return songUrl;
	}

	public void setSongUrl(String songUrl) {
		this.songUrl = songUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public int getAlbum() {
		return album;
	}

	public void setAlbum(int album) {
		this.album = album;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	@Override
	public String toString() {
		return "Music [musicid=" + musicid + ", songName=" + songName + ", singer=" + singer + ", songUrl=" + songUrl
				+ ", videoUrl=" + videoUrl + ", album=" + album + ", albumName=" + albumName + "]";
	}
	
}
