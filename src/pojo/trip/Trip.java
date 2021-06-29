package pojo.trip;

public class Trip {
	private int id;
	private String time;
	private String place;
	private String title;
	
	public Trip() {
		
	}
	
	public Trip(String time, String place, String title) {
		this.time = time;
		this.place = place;
		this.title = title;
	}

	public Trip(int id, String time, String place, String title) {
		this.id = id;
		this.time = time;
		this.place = place;
		this.title = title;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Trip [id=" + id + ", time=" + time + ", place=" + place + ", title=" + title + "]";
	}
	
	
	
}
