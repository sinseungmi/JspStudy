package chap06.model;

public class Worldcup {
	
	private int wid;
	private String name;
	private int voted;
	private String status;
	
	//특정 라이브러리에서는 기본 생성자가 존재해야 하는 경우가 많다.
	public Worldcup() {}
	
	public Worldcup(int wid, String name, int voted, String status) {
		this.wid = wid;
		this.name = name;
		this.voted = voted;
		this.status = status;
	}
	
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVoted() {
		return voted;
	}
	public void setVoted(int voted) {
		this.voted = voted;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
