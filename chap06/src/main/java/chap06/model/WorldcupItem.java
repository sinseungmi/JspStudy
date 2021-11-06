package chap06.model;

public class WorldcupItem {
	private int id;
	private String name;
	private int wid;
	private int win;
	private int lose;
	private int final_win;
	
	public WorldcupItem() {}
	
	public WorldcupItem(int id, String name,int wid, int win, int lose, int final_win) {
		this.id = id;
		this.name = name;
		this.wid = wid;
		this.win = win;
		this.lose = lose;
		this.final_win = final_win;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWid() {
		return wid;
	}
	public void setWid(int wid) {
		this.wid = wid;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public int getFinal_win() {
		return final_win;
	}
	public void setFinal_win(int final_win) {
		this.final_win = final_win;
	}

}
