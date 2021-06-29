package pojo.user;

public class User {
	private int id;
	private String user_id;
	private String avatar;
	private String nickname;
	private int gender;
	private int fans;
	private int focus;
	private int love;
	private int star;
	
	
	
	public User() {
		super();
	}

	public User(int id, String user_id, String avatar, String nickname, int gender, int fans, int focus, int love,
			int star) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.avatar = avatar;
		this.nickname = nickname;
		this.gender = gender;
		this.fans = fans;
		this.focus = focus;
		this.love = love;
		this.star = star;
	}
	
	public User(String user_id, String avatar, String nickname, int gender, int fans, int focus, int love,
			int star) {
		super();
		this.user_id = user_id;
		this.avatar = avatar;
		this.nickname = nickname;
		this.gender = gender;
		this.fans = fans;
		this.focus = focus;
		this.love = love;
		this.star = star;
	}
	
	




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getFans() {
		return fans;
	}
	public void setFans(int fans) {
		this.fans = fans;
	}
	public int getFocus() {
		return focus;
	}
	public void setFocus(int focus) {
		this.focus = focus;
	}
	public int getLove() {
		return love;
	}
	public void setLove(int love) {
		this.love = love;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", user_id=" + user_id + ", avatar=" + avatar + ", nickname=" + nickname + ", gender="
				+ gender + ", fans=" + fans + ", focus=" + focus + ", love=" + love + ", star=" + star + "]";
	}
	
	
	
	
	
}
