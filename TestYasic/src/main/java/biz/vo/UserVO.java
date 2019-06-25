package biz.vo;

public class UserVO {
	private String id;
	private String pw;
	private String name;
	private String sex;
	private int age;
	private String img;

	public UserVO() {
		super();
	}

	public UserVO(String id, String pw, String name, String sex, int age, String img) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.img = img;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", pw=" + pw + ", name=" + name + ", sex=" + sex + ", age=" + age + ", img=" + img
				+ "]";
	}
}
