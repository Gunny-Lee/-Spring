package biz.vo;

import java.sql.Date;

public class CheckVO {
	private String id;
	private String why;
	private String stime;
	private String etime;
	private int ppnum;
	private int nownum;
	private String color;
	private String msg;
	
	public CheckVO() {
		super();
	}
	
	public CheckVO(String id, String why, String stime, String etime, int ppnum, int nownum, String color, String msg) {
		super();
		this.id = id;
		this.why = why;
		this.stime = stime;
		this.etime = etime;
		this.ppnum = ppnum;
		this.nownum = nownum;
		this.color = color;
		this.msg = msg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getEtime() {
		return etime;
	}

	public void setEtime(String etime) {
		this.etime = etime;
	}

	public int getNownum() {
		return nownum;
	}

	public void setNownum(int nownum) {
		this.nownum = nownum;
	}

	public int getPpnum() {
		return ppnum;
	}

	public void setPpnum(int ppnum) {
		this.ppnum = ppnum;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "CheckVO [id=" + id + ", why=" + why + ", stime=" + stime + ", etime=" + etime + ", ppnum=" + ppnum
				+ ", nownum=" + nownum + ", color=" + color + ", msg=" + msg + "]";
	}
}
