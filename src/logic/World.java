package logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Cursor;
import javax.swing.JTextField;

public class World extends JPanel implements Space, ActionListener {
	
	public static int numar_masini = 15 ;
	
	public static Random random = new Random();
	
	
	public static ArrayList<Color> carColors = new ArrayList<Color>();

	public World() {
		setLayout(null);
		
	}
	
	public static int adaugare = 0;
	
	Timer timer = new Timer(100,this);
	 

	private static Port P1I, P2I, P3I, P4I, P5I, P6I, P7I, P8I, P9I, P10I, P11I, P12I, P13I, P14I, P15I, P16I, P17I, P18I, P19I;
	private static Port P1O, P2O, P3O, P4O, P5O, P6O, P7O, P8O, P9O, P10O, P11O, P12O, P13O, P14O, P15O, P16O, P17O, P18O, P19O;
	private static Road Road1, Road2, Road3, Road4, Road5, Road6, Road7, Road8, Road9, Road10, Road11, Road12, Road13, Road14, Road15, Road16, Road17, Road18, Road19;
	public static Semaphore semaphore1, semaphore2, semaphore3, semaphore4, semaphore5, semaphore6, semaphore7, semaphore8;
	
	private static Intersection intersectia_A;
	
	
	
	private static List <Road> roads = new ArrayList <Road>();
	private List <Port> ports = new ArrayList <Port>();
	private static List <Intersection> intersections = new ArrayList <Intersection>();
	
	private static int xx = 0;
	
	
	
	public void move() {
		
	}
	
	public static void main(String[] args) {
		
		World w = new World();
		
		JFrame frame = new JFrame();
		
		frame.setTitle("World - Traffic Simulation");
		frame.setSize(1900, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(w);
	
		//Porturile de intrare ale benzilor - BRADEA OCTAVIA
		P1I = new Port(0,400);
		P2I = new Port(600,0); 
		P3I = new Port(650,0); 
		P4I = new Port(700,400);
		P5I = new Port(700,450);
		P6I = new Port(700,500);
		P7I = new Port(700,550);
		P8I = new Port (650,600);
		P9I = new Port (600,600);
		P10I = new Port(0,550);
		P11I = new Port(0,500);
		P12I = new Port(0,450);
		P13I = new Port(1250,0); 
		P14I = new Port(1300,400);
		P15I = new Port(1300,450);
		P16I = new Port(1300,500);
		P17I = new Port(1300,550);
		P18I = new Port (1250,600); 
		P19I = new Port (1200,600); 
		 
		//Porturile de iesire ale benzilor - BRANESCU SERBAN 
		P1O = new Port (600,400); 
		P2O = new Port (600,400); 
		P3O = new Port (650,400); 
		P4O = new Port (1200,400); 
		P5O = new Port (1200,450); 
		P6O = new Port (1200,500); 
		P7O = new Port (1200,550); 
		P8O = new Port(650,1000); 
		P9O = new Port(600,1000);
		P10O = new Port (600,550); 
		P11O = new Port (600,500); 
		P12O = new Port (600,450); 
		P13O = new Port (1250,400); 
		P14O = new Port (1900,400); 
		P15O = new Port (1900,450); 
		P16O = new Port (1900,500); 
		P17O = new Port (1900,550); 
		P18O = new Port(1250,1000); 
		P19O = new Port(1200,1000);
		
		//Drumurile - ALBU ADELA
		Road1 = new Road(P1I, P1O, 600);
		Road2 = new Road(P2I, P2O, 400);
		Road3 = new Road(P3I, P3O, 400);
		Road4 = new Road(P4I, P4O, 500);
		Road5 = new Road(P5I, P5O, 500);
		Road6 = new Road(P6I, P6O, 500);
		Road7 = new Road(P7I, P7O, 500);
		Road8 = new Road(P8I, P8O, 400);
		Road9 = new Road(P9I, P9O, 400);
		Road10 = new Road(P10I, P10O, 600);
		Road11 = new Road(P11I, P11O, 600);
		Road12 = new Road(P12I, P12O, 600);
		Road13 = new Road(P13I, P13O, 400);
		Road14 = new Road(P14I, P14O, 600);
		Road15 = new Road(P15I, P15O, 600);
		Road16 = new Road(P16I, P16O, 600);
		Road17 = new Road(P17I, P17O, 600);
		Road18 = new Road(P18I, P18O, 400);
		Road19 = new Road(P19I, P19O, 400);
		
		roads.add(Road1);
		roads.add(Road2);
		roads.add(Road3);
		roads.add(Road4);
		roads.add(Road5);
		roads.add(Road6);
		roads.add(Road7);
		roads.add(Road8);
		roads.add(Road9);
		roads.add(Road10);
		roads.add(Road11);
		roads.add(Road12);
		roads.add(Road13);
		roads.add(Road14);
		roads.add(Road15);
		roads.add(Road16);
		roads.add(Road17);
		roads.add(Road18);
		roads.add(Road19);
		
		//CULORILE MASINILOR - BRANESCU SERBAN
		carColors.add(Color.BLACK);
		carColors.add(Color.YELLOW);
		carColors.add(Color.RED);
		carColors.add(Color.PINK);
		carColors.add(Color.ORANGE);
		carColors.add(Color.MAGENTA);
		carColors.add(Color.CYAN);
		carColors.add(Color.BLUE);
		
		//GENERAREA RANDOM A MASINILOR, CULORILOR MASINILOR SI PE CE DRUM SE POZITIONEAZA
		//for(int i=0; i<numar_masini; i++) {
		int i=0;
		while(i<numar_masini) {
			
			int nrRandom_colors = random.nextInt(7);
		    int nrRandom_roads = random.nextInt(18);
		    if(nrRandom_roads == 1 || nrRandom_roads == 9 || nrRandom_roads == 10  ) {
		    	roads.get(nrRandom_roads).listOFcars.add(new Car(roads.get(nrRandom_roads).inputPort.cordX, roads.get(nrRandom_roads).inputPort.cordY, carColors.get(nrRandom_colors),50,50));
		    	i++;
		    }
		    if (nrRandom_roads == 7 || nrRandom_roads == 17) {
		    	roads.get(nrRandom_roads).listOFcars.add(new Car(roads.get(nrRandom_roads).outputPort.cordX, roads.get(nrRandom_roads).outputPort.cordY-50, carColors.get(nrRandom_colors),50,50));
		    	i++;
		    }
		    
		    
		    		if (nrRandom_roads == 13 || nrRandom_roads == 14) {
				    	roads.get(nrRandom_roads).listOFcars.add(new Car(roads.get(nrRandom_roads).outputPort.cordX-50, roads.get(nrRandom_roads).outputPort.cordY, carColors.get(nrRandom_colors),50,50));
				    	i++;
				    }
			
			
		}
		
		semaphore1 = new Semaphore(Color.RED, 530, 330);
		semaphore2 = new Semaphore(Color.RED, 720, 330);
		semaphore3 = new Semaphore(Color.RED, 530, 620);
		semaphore4 = new Semaphore(Color.RED, 720, 620);
		
		// = new Semaphore(Color.RED, 1130, 340);
		semaphore6 = new Semaphore(Color.RED, 1320, 340);
		semaphore7 = new Semaphore(Color.RED, 1130, 620);
		semaphore8 = new Semaphore(Color.RED, 1320, 620);
		
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		timer.start();
		
		//DESENARE BACKGROUND - BAR IOAN
		g.setColor(Color.GREEN);
		g.fillRect(0,0,1900,1000);
		
		
		g.setColor(Color.GRAY);
		
		
		// TRASARE INTERSECTII
		g.fillRect(Road1.inputPort.cordX+600, Road1.inputPort.cordY, 100, 200);
		g.fillRect(Road1.inputPort.cordX+1200, Road1.inputPort.cordY, 100, 200);
		
		//TRASARE BENZI DE CIRCULATIE - BAR IOAN
		g.fillRect(Road1.inputPort.cordX, Road1.inputPort.cordY, Road1.size, 50);
		g.fillRect(Road12.inputPort.cordX, Road12.inputPort.cordY, Road12.size, 50);
		g.fillRect(Road11.inputPort.cordX, Road11.inputPort.cordY, Road11.size, 50);
		g.fillRect(Road10.inputPort.cordX, Road10.inputPort.cordY, Road10.size, 50);
		g.fillRect(Road4.inputPort.cordX, Road4.inputPort.cordY, Road4.size, 50);
		g.fillRect(Road5.inputPort.cordX, Road5.inputPort.cordY, Road5.size, 50);
		g.fillRect(Road6.inputPort.cordX, Road6.inputPort.cordY, Road6.size, 50);
		g.fillRect(Road7.inputPort.cordX, Road7.inputPort.cordY, Road7.size, 50);
		g.fillRect(Road14.inputPort.cordX, Road14.inputPort.cordY, Road14.size, 50);
		g.fillRect(Road15.inputPort.cordX, Road15.inputPort.cordY, Road15.size, 50);
		g.fillRect(Road16.inputPort.cordX, Road16.inputPort.cordY, Road16.size, 50);
		g.fillRect(Road17.inputPort.cordX, Road17.inputPort.cordY, Road17.size, 50);
		g.fillRect(Road2.inputPort.cordX, Road2.inputPort.cordY, 50, Road2.size);
		g.fillRect(Road3.inputPort.cordX, Road3.inputPort.cordY, 50, Road3.size);
		g.fillRect(Road13.inputPort.cordX, Road13.inputPort.cordY, 50, Road13.size);
		g.fillRect(Road9.inputPort.cordX, Road9.inputPort.cordY, 50, Road9.size);
		g.fillRect(Road8.inputPort.cordX, Road8.inputPort.cordY, 50, Road8.size);
		g.fillRect(Road19.inputPort.cordX, Road19.inputPort.cordY, 50, Road19.size);
		g.fillRect(Road18.inputPort.cordX, Road18.inputPort.cordY, 50, Road18.size);
		
		// TRASARE BENZI DELIMITATOARE - BAR IOAN
		g.setColor(Color.WHITE);
		g.fillRect(Road1.inputPort.cordX, Road1.inputPort.cordY+48, Road1.size, 2);
		g.fillRect(Road12.inputPort.cordX, Road12.inputPort.cordY+48, Road12.size, 4);
		g.fillRect(Road11.inputPort.cordX, Road11.inputPort.cordY+48, Road11.size, 2);
		g.fillRect(Road4.inputPort.cordX, Road4.inputPort.cordY+48, Road4.size, 2);
		g.fillRect(Road5.inputPort.cordX, Road5.inputPort.cordY+48, Road5.size, 4);
		g.fillRect(Road6.inputPort.cordX, Road6.inputPort.cordY+48, Road6.size, 2);
		g.fillRect(Road14.inputPort.cordX, Road14.inputPort.cordY+48, Road14.size, 2);
		g.fillRect(Road15.inputPort.cordX, Road15.inputPort.cordY+48, Road15.size, 4);
		g.fillRect(Road16.inputPort.cordX, Road16.inputPort.cordY+48, Road16.size, 2);
		g.fillRect(Road2.inputPort.cordX+48, Road2.inputPort.cordY, 2, Road2.size);
		g.fillRect(Road9.inputPort.cordX+48, Road9.inputPort.cordY, 2, Road9.size);
		g.fillRect(Road19.inputPort.cordX+48, Road19.inputPort.cordY, 2, Road19.size);
		
		g.setColor(semaphore1.color);
		g.fillRect(semaphore1.cordX, semaphore1.cordY, 50, 50);
		g.fillRect(semaphore2.cordX, semaphore2.cordY, 50, 50);
		g.fillRect(semaphore3.cordX, semaphore3.cordY, 50, 50);
		g.fillRect(semaphore4.cordX, semaphore4.cordY, 50, 50);
		//g.fillRect(semaphore5.cordX, semaphore5.cordY, 50, 50);
		g.fillRect(semaphore6.cordX, semaphore6.cordY, 50, 50);
		g.fillRect(semaphore7.cordX, semaphore7.cordY, 50, 50);
		g.fillRect(semaphore8.cordX, semaphore8.cordY, 50, 50);
		
		
		
		
		

		for(Road r: roads) {
			
			for(int i=0; i<r.listOFcars.size(); i++) {
				g.setColor(r.listOFcars.get(i).color);
				g.fillRect(r.listOFcars.get(i).x, r.listOFcars.get(i).y, 50, 50);
				
			}
			
		}
		
		for(int j=0; j<roads.size(); j++) {
			
			for(int i=0; i<roads.get(j).listOFcars.size(); i++) {
				
				if(j==0 || j==3 || j==4) {
					if(roads.get(j).listOFcars.get(i).x < roads.get(j).outputPort.cordX) {
						roads.get(j).listOFcars.get(i).x += 10;
						g.setColor(roads.get(j).listOFcars.get(i).color);
						g.fillRect(roads.get(j).listOFcars.get(i).x, roads.get(j).listOFcars.get(i).y, 50, 50);
					}
					if(j==0 && roads.get(j).listOFcars.get(i).x == roads.get(j).outputPort.cordX) {
						Car car_test = roads.get(j).listOFcars.get(i);
						roads.get(3).listOFcars.add(car_test);
						//sjbdaf
					}
						
				}
				
				if(j==1 ) {
					if(roads.get(j).listOFcars.get(i).y < roads.get(j).outputPort.cordY) {
						roads.get(j).listOFcars.get(i).y += 10;
						g.setColor(roads.get(j).listOFcars.get(i).color);
						g.fillRect(roads.get(j).listOFcars.get(i).x, roads.get(j).listOFcars.get(i).y, 50, 50);
					}
						
				}
				
				
			}
			
		}
	
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		repaint();
		
	}
}
