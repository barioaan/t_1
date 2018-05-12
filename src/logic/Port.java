package logic;

public class Port {
	public int id;
	public int cordX, cordY;
	public Entity entity;
	public Port(int id, int cordX, int cordY) {
		super();
		this.id = id;
		this.cordX = cordX;
		this.cordY = cordY;
		
	}
	
	public Port(int cordX, int cordY) {
		super();
		
		this.cordX = cordX;
		this.cordY = cordY;
		
	}
	

}
