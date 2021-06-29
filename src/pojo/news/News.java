package pojo.news;

import java.util.ArrayList;

public class News {
	private int newsid;
	private int type;
	private String title;
	private String time;
	private String content;
	private ArrayList<String> imageUrl;
	private String videoUrl;
	
	
	public News() {
	}

	

	public News(int newsid, int type, String title, String time, String content, ArrayList<String> imageUrl,
			String videoUrl) {
		this.newsid = newsid;
		this.type = type;
		this.title = title;
		this.time = time;
		this.content = content;
		this.imageUrl = imageUrl;
		this.videoUrl = videoUrl;
	}
	
	public News(int type, String title, String time, String content, String videoUrl) {
		super();
		this.type = type;
		this.title = title;
		this.time = time;
		this.content = content;
		this.videoUrl = videoUrl;
	}
	
	

	public News(int newsid, int type, String title, String time, String content, String videoUrl) {
		super();
		this.newsid = newsid;
		this.type = type;
		this.title = title;
		this.time = time;
		this.content = content;
		this.videoUrl = videoUrl;
	}



	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getNewsid() {
		return newsid;
	}

	public void setNewsid(int newsid) {
		this.newsid = newsid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArrayList<String> getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(ArrayList<String> imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	
	
	
}
