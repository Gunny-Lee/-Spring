package biz.vo;

public class FriendVO {
	private String id;
	private String fid;
	
	public FriendVO() {
		super();
	}

	public FriendVO(String id, String fid) {
		super();
		this.id = id;
		this.fid = fid;
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

	@Override
	public String toString() {
		return "FriendVO [id=" + id + ", fid=" + fid + "]";
	}
}
