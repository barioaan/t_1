package logic;

import java.util.ArrayList;
import java.util.List;

public class Road implements Space{
	
	public int size;
	public Port inputPort, outputPort;
	public ArrayList <Car> listOFcars = new ArrayList <Car>();
	public Direction [] directionList;
	public Orientation orientation;
	
	public Road(Port inputPort, Port outputPort, int size) {
		super();
		this.size = size;
		this.inputPort = inputPort;
		this.outputPort = outputPort;
		
	}

	
	



	public void move() {
		// TODO Auto-generated method stub
		
	}
}
