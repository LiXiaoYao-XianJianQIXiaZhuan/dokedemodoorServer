package pojo.starUpvote;

public class StarUpvote {
	
	private int id;	//数据编号
	private String avatar;	//点赞人头像
	private String nickname;	//点赞人昵称
	private String time;		//点赞时间
	private String type;		//类型
	private String content;		//转发回复内容
	private int microblogid;	//相关微博id
	
	
	public StarUpvote() {
	}

	public StarUpvote(int id, String avatar, String nickname, String time, String type, String content,
			int microblogid) {
		this.id = id;
		this.avatar = avatar;
		this.nickname = nickname;
		this.time = time;
		this.type = type;
		this.content = content;
		this.microblogid = microblogid;
	}

	public StarUpvote(String avatar, String nickname, String time, String type, String content, int microblogid) {
		this.avatar = avatar;
		this.nickname = nickname;
		this.time = time;
		this.type = type;
		this.content = content;
		this.microblogid = microblogid;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMicroblogid() {
		return microblogid;
	}

	public void setMicroblogid(int microblogid) {
		this.microblogid = microblogid;
	}

	@Override
	public String toString() {
		return "StarUpvote [id=" + id + ", avatar=" + avatar + ", nickname=" + nickname + ", time=" + time + ", type="
				+ type + ", content=" + content + ", microblogid=" + microblogid + "]";
	}
	
	
	
	
	
}
