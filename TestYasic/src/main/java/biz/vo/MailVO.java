package biz.vo;

public class MailVO {
	private int num;
	private String id;
	private String fid;
	private String req;
	private String msg;
	private String wtime;
	
	public MailVO() {
		super();
	}
	
	public MailVO(int num, String id, String fid, String req, String msg, String wtime) {
		super();
		this.num = num;
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getReq() {
		return req;
	}

	public void setReq(String req) {
		this.req = req;
	}

	public String getWtime() {
		return wtime;
	}

	public void setWtime(String wtime) {
		this.wtime = wtime;
	}

	@Override
	public String toString() {
		return "MailVO [num=" + num + ", id=" + id + ", fid=" + fid + ", why=" + req + ", msg=" + msg + "]";
	}

}
