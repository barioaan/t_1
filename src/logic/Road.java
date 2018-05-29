package logic;

import java.util.ArrayList;
import java.util.List;

public class Road {
	
	int size;
	Port inputPort, outputPort;
	public ArrayList <Car> listOFcars = new ArrayList <Car>();
	Compartiment [] directionList;
	private Orientation orientation;
	int coordonataLiniePietoni;
	boolean areLiniePietoni = false;
	Compartiment compartimente [];
	int id;
	
	boolean hasDirection = false;
	
	Semaphore semaphore;
	
	
	Road(Port inputPort, Port outputPort, int size, Orientation orientation) {
		super();
		this.size = size;
		this.inputPort = inputPort;
		this.outputPort = outputPort;
		this.orientation = orientation;
		
	}

	public Road(int id) {
		this.id = id;
	}


}
