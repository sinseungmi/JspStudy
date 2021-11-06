package chap02.model;

public class Apple {
	public int price;
	public int size;
	
	public Apple() {
		this.price = (int)(Math.random() * 10) + 10;
		this.size = (int)(Math.random() * 10) + 10;
	}
	
	@Override
	public String toString() {
		return String.format("<tr><td>%d</td><td>%d</td></tr>", price, size);
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getSize() {
		return size;
	}

}
