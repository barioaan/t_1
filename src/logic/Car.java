package logic;

import java.awt.Color;

class Car {
	
	Color color;
	int width, height;
	int x,y;
	private Direction direction;
	public int xPietoni, yPietoni;

    public Car() {

    }

    Car(int x, int y, Color color, int width, int height) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.width = width;
		this.height = height;
	}

	
	
}
