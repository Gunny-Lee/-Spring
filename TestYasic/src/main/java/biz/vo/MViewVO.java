package biz.vo;

public class MViewVO {
	private int num;
	private String img;
	private String name;
	private String id;
	private String fid;
	private String req;
	private String msg;
	private String wtime;
	
	public MViewVO() {
		super();
	}

	public MViewVO(int num, String img, String name, String id, String fid, String req, String msg, String wtime) {
		super();
		this.num = num;
		this.img = img;
		this.name = name;
		this.id = id;
		this.fid = fid;
		this.req = req;
		this.msg = msg;
		this.wtime = wtime;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getWtime() {
		return wtime;
	}

	public void setWtime(String wtime) {
		this.wtime = wtime;
	}

	@Override
	public String toString() {
		return "MViewVO [num=" + num + ", img=" + img + ", name=" + name + ", id=" + id + ", fid=" + fid + ", req="
				+ req + ", msg=" + msg + ", wtime=" + wtime + "]";
	}
}
