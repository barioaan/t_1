package logic;

import java.awt.Color;

public class Car {
	
	
	public Color color;
	public int width, height;
	public int x,y;
	private Direction direction;
	public int xPietoni, yPietoni;
	
	public Car(int x, int y, Color color, int width, int height) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.width = width;
		this.height = height;
	}

	public Car() {
		// TODO Auto-generated constructor stub
	}
	
	
}
