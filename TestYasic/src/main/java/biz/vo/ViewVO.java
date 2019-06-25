package biz.vo;

public class ViewVO {
	private String id;
	private String img;
	private String name;
	private String why;
	private String stime;
	private String color;
	
	public ViewVO() {
		super();
	}

	public ViewVO(String id, String img, String name, String why, String stime, String color) {
		super();
		this.id = id;
		this.img = img;
		this.name = name;
		this.why = why;
		this.stime = stime;
		this.color = color;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWhy() {
		return why;
	}

	public void setWhy(String why) {
		this.why = why;
	}

	public String getStime() {
		return stime;
	}

	public void setStime(String stime) {
		this.stime = stime;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "ViewVO [id=" + id + ", img=" + img + ", name=" + name + ", why=" + why + ", stime=" + stime + ", color="
				+ color + "]";
	}
	
}
