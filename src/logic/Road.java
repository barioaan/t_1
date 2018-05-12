package logic;

import java.util.ArrayList;
import java.util.List;

public class Road implements Space{
	
	public int size;
	public Port inputPort, outputPort;
	public ArrayList <Car> listOFcars = new ArrayList <Car>();
	public Direction [] directionList;
	
	public Road(Port inputPort, Port outputPort, int size) {
		super();
		this.size = size;
		this.inputPort = inputPort;
		this.outputPort = outputPort;
		//this.entities = entities;
	}

	
	


	public Direction[] getDirectionList() {
		return directionList;
	}
	
	public void setDirectionList(Direction[] directionList) {
		this.directionList = directionList;
	}





	public void move() {
		// TODO Auto-generated method stub
		
	}
}
