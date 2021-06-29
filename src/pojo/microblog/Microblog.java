package pojo.microblog;

import java.util.ArrayList;

public class Microblog {
	private int id;							//每天信息唯一的主键
	private String avatar;					//当条微博的头像
	private String nickname;				//当条微博的昵称
	private String time;					//当条微博发布的时间
	private String content;					//当条微博的内容
	private String video;					//微博视频
	private ArrayList<String> images;		//当条微博的图片
	private String type;					//当条微博的类型
	
	public Microblog() {
		
	}

	public Microblog(int id, String avatar, String nickname, String time, String content, String video,
			ArrayList<String> images, String type) {
		this.id = id;
		this.avatar = avatar;
		this.nickname = nickname;
		this.time = time;
		this.content = content;
		this.video = video;
		this.images = images;
		this.type = type;
	}
	public Microblog( String avatar, String nickname, String time, String content, String video,
			ArrayList<String> images, String type) {
		this.avatar = avatar;
		this.nickname = nickname;
		this.time = time;
		this.content = content;
		this.video = video;
		this.images = images;
		this.type = type;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public ArrayList<String> getImages() {
		return images;
	}
	public void setImages(ArrayList<String> images) {
		this.images = images;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "Microblog [id=" + id + ", avatar=" + avatar + ", nickname=" + nickname + ", time=" + time + ", content="
				+ content + ", video=" + video + ", images=" + images + ", type=" + type + "]";
	}
	
	
}
