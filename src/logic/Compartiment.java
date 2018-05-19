package logic;

public class Compartiment {
	
	public int x,y;

	public Car car = null;
	
	public Compartiment(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	public boolean isEmpty;
	
	public void setEmpty(boolean isEmpty) {
		this.isEmpty = isEmpty;

	}
	
	

}
