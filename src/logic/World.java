package logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class World extends JPanel implements Space, ActionListener {

	public static int numar_masini = 15 ;
	
	public static Random random = new Random();

	Timer timer = new Timer(100,this);
	
	public static ArrayList<Color> carColors = new ArrayList<Color>();

	public World() {
		setLayout(null);
		
		JButton btnClick = new JButton("CLICK");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.start();
			}
		});
		btnClick.setBounds(52, 78, 89, 23);
		add(btnClick);
		
	}
	
	public static int adaugare = 0;
	
	//COMENTARIU DE TEST
	 

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
		P1I = new Port (600,400); 
		P2I = new Port (600,0);  
		P3I = new Port (650,400); 
		P4I = new Port (1200,400);
		P5I = new Port (1200,450); 
		P6I = new Port (700,500);
		P7I = new Port (700,550);
		P8I = new Port (650,1000);
		P9I = new Port (600,1000);
		P10I = new Port (0,550);
		P11I = new Port (0,500);
		P12I = new Port (600,450); 
		P13I = new Port (1250,400); 
		P14I = new Port (1900,400);
		P15I = new Port (1900,450);
		P16I = new Port (1300,500);
		P17I = new Port (1300,550);
		P18I = new Port (1250,1000); 
		P19I = new Port (1200,1000);
		 
		//Porturile de iesire ale benzilor - BRANESCU SERBAN 
		P1O = new Port (0,400);
		P2O = new Port (600,400);  
		P3O = new Port (650,0); 
		P4O = new Port (700,400); 
		P5O = new Port (700,450);
		P6O = new Port (1200,500); 
		P7O = new Port (1200,550); 
		P8O = new Port (650,600); 
		P9O = new Port (600,600);
		P10O = new Port (600,550); 
		P11O = new Port (600,500); 
		P12O = new Port (0,450); 
		P13O = new Port (1250,0);  
		P14O = new Port (1300,400); 
		P15O = new Port (1300,450);  
		P16O = new Port (1900,500); 
		P17O = new Port (1900,550); 
		P18O = new Port (1250,600); 
		P19O = new Port (1200,600);  
		
		//Drumurile - ALBU ADELA
		Road1 = new Road(P1I, P1O, 600, Orientation.E_West);
		Road2 = new Road(P2I, P2O, 400, Orientation.E_South);
		Road3 = new Road(P3I, P3O, 400, Orientation.E_North);
		Road4 = new Road(P4I, P4O, 500, Orientation.E_West);
		Road5 = new Road(P5I, P5O, 500, Orientation.E_West);
		Road6 = new Road(P6I, P6O, 500, Orientation.E_East);
		Road7 = new Road(P7I, P7O, 500, Orientation.E_East);
		Road8 = new Road(P8I, P8O, 400, Orientation.E_North);
		Road9 = new Road(P9I, P9O, 400, Orientation.E_South);
		Road10 = new Road(P10I, P10O, 600, Orientation.E_East);
		Road11 = new Road(P11I, P11O, 600, Orientation.E_East);
		Road12 = new Road(P12I, P12O, 600, Orientation.E_West);
		Road13 = new Road(P13I, P13O, 400, Orientation.E_North);
		Road14 = new Road(P14I, P14O, 600, Orientation.E_West);
		Road15 = new Road(P15I, P15O, 600, Orientation.E_West);
		Road16 = new Road(P16I, P16O, 600, Orientation.E_East);
		Road17 = new Road(P17I, P17O, 600, Orientation.E_East);
		Road18 = new Road(P18I, P18O, 400, Orientation.E_North);
		Road19 = new Road(P19I, P19O, 400, Orientation.E_South);
		
		//ADAUGARE LINIE UNDE SA SE OPREASCA MASINILE
		
		Road1.areLiniePietoni = false;
		Road2.areLiniePietoni = true;
		//stergi comentariul asta si faci asa pentru toate cele 19 drumuri
		
		
		
		//aici pentru drumurile care au linie la cele orizontale pui coordonata x si la cele verticale pui coordonata y
		Road10.coordonataLiniePietoni  = 482; 
		
		
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
		    	roads.get(nrRandom_roads).listOFcars.add(new Car(roads.get(nrRandom_roads).inputPort.cordX, roads.get(nrRandom_roads).inputPort.cordY-50, carColors.get(nrRandom_colors),50,50));
		    	i++;
		    }
		    
		    
		    if (nrRandom_roads == 13 || nrRandom_roads == 14) {
			   	roads.get(nrRandom_roads).listOFcars.add(new Car(roads.get(nrRandom_roads).inputPort.cordX-50, roads.get(nrRandom_roads).inputPort.cordY, carColors.get(nrRandom_colors),50,50));
			   	i++;
			}
			
			
		}
		
		//SEMAFOARE 1-4 OCTAVIA
		semaphore1 = new Semaphore(Color.RED, 530, 330);
		semaphore2 = new Semaphore(Color.RED, 720, 330);
		semaphore3 = new Semaphore(Color.RED, 530, 620);
		semaphore4 = new Semaphore(Color.RED, 720, 620);
		//SEMAFOARE 6-8 SERBAN
		semaphore6 = new Semaphore(Color.RED, 1320, 340);
		semaphore7 = new Semaphore(Color.RED, 1130, 620);
		semaphore8 = new Semaphore(Color.RED, 1320, 620);
		
		
		//DIRECTII BENZI - ALBU ADELA
		Direction [] directionListRoad2 = new Direction[3];
		directionListRoad2[0] = Direction.E_left;
		directionListRoad2[1] = Direction.E_Forward;
		directionListRoad2[2] = Direction.E_right;
		
		roads.get(1).directionList = directionListRoad2;

		Direction [] directionListRoad4 = new Direction[3];
		directionListRoad4[0] = Direction.E_left;
		directionListRoad4[1] = Direction.E_Forward;
		directionListRoad4[2] = Direction.E_right;
		
		roads.get(3).directionList = directionListRoad4;

		Direction [] directionListRoad5 = new Direction[3];
		directionListRoad5[0] = Direction.E_left;
		directionListRoad5[1] = Direction.E_Forward;
		directionListRoad5[2] = Direction.E_right;
		
		roads.get(4).directionList = directionListRoad5;

		Direction [] directionListRoad6 = new Direction[3];
		directionListRoad6[0] = Direction.E_left;
		directionListRoad6[1] = Direction.E_Forward;
		directionListRoad6[2] = Direction.E_right;
		
		roads.get(5).directionList = directionListRoad6;

		Direction [] directionListRoad7 = new Direction[3];
		directionListRoad7[0] = Direction.E_left;
		directionListRoad7[1] = Direction.E_Forward;
		directionListRoad7[2] = Direction.E_right;
		
		roads.get(6).directionList = directionListRoad7;

		Direction [] directionListRoad8 = new Direction[3];
		directionListRoad8[0] = Direction.E_left;
		directionListRoad8[1] = Direction.E_Forward;
		directionListRoad8[2] = Direction.E_right;
		
		roads.get(7).directionList = directionListRoad8;

		Direction [] directionListRoad10 = new Direction[2];
		directionListRoad10[0] = Direction.E_Forward;
		directionListRoad10[1] = Direction.E_right;
		
		roads.get(9).directionList = directionListRoad10;

		Direction [] directionListRoad11 = new Direction[2];
		directionListRoad11[0] = Direction.E_left;
		directionListRoad11[1] = Direction.E_Forward;
		
		roads.get(10).directionList = directionListRoad11;

		Direction [] directionListRoad14 = new Direction[2];
		directionListRoad14[0] = Direction.E_left;
		directionListRoad14[1] = Direction.E_Forward;
		
		roads.get(13).directionList = directionListRoad14;

		Direction [] directionListRoad15 = new Direction[2];
		directionListRoad15[0] = Direction.E_Forward;
		directionListRoad15[1] = Direction.E_right;
		
		roads.get(14).directionList = directionListRoad15;

		Direction [] directionListRoad18 = new Direction[3];
		directionListRoad18[0] = Direction.E_left;
		directionListRoad18[1] = Direction.E_Forward;
		directionListRoad18[2] = Direction.E_right;
		
		roads.get(17).directionList = directionListRoad18;
		
		
		
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Color darkGreen = new Color(28,98,71);
		//timer.start();
		
		//DESENARE BACKGROUND - BAR IOAN\
		//g.setColor(darkGreen);
		g.setColor(Color.GREEN);
		g.fillRect(0,0,1900,1000);
		
		
		g.setColor(Color.DARK_GRAY);
		
		
		// TRASARE INTERSECTII BAR IOAN
		g.fillRect(Road1.inputPort.cordX, Road1.inputPort.cordY, 100, 200);
		g.fillRect(Road1.inputPort.cordX+600, Road1.inputPort.cordY, 100, 200);
		
		//TRASARE BENZI DE CIRCULATIE - BAR IOAN
		g.fillRect(Road1.outputPort.cordX, Road1.outputPort.cordY, Road1.size, 50);
		g.fillRect(Road12.outputPort.cordX, Road12.outputPort.cordY, Road12.size, 50);
		g.fillRect(Road11.inputPort.cordX, Road11.inputPort.cordY, Road11.size, 50);
		g.fillRect(Road10.inputPort.cordX, Road10.inputPort.cordY, Road10.size, 50);
		g.fillRect(Road4.outputPort.cordX, Road4.outputPort.cordY, Road4.size, 50);
		g.fillRect(Road5.outputPort.cordX, Road5.outputPort.cordY, Road5.size, 50);
		g.fillRect(Road6.inputPort.cordX, Road6.inputPort.cordY, Road6.size, 50);
		g.fillRect(Road7.inputPort.cordX, Road7.inputPort.cordY, Road7.size, 50);
		g.fillRect(Road14.outputPort.cordX, Road14.outputPort.cordY, Road14.size, 50);
		g.fillRect(Road15.outputPort.cordX, Road15.outputPort.cordY, Road15.size, 50);
		g.fillRect(Road16.inputPort.cordX, Road16.inputPort.cordY, Road16.size, 50);
		g.fillRect(Road17.inputPort.cordX, Road17.inputPort.cordY, Road17.size, 50);
		g.fillRect(Road2.inputPort.cordX, Road2.inputPort.cordY, 50, Road2.size);
		g.fillRect(Road3.outputPort.cordX, Road3.outputPort.cordY, 50, Road3.size);
		g.fillRect(Road13.outputPort.cordX, Road13.outputPort.cordY, 50, Road13.size);
		g.fillRect(Road9.outputPort.cordX, Road9.outputPort.cordY, 50, Road9.size);
		g.fillRect(Road8.outputPort.cordX, Road8.outputPort.cordY, 50, Road8.size);
		g.fillRect(Road19.outputPort.cordX, Road19.outputPort.cordY, 50, Road19.size);
		g.fillRect(Road18.outputPort.cordX, Road18.outputPort.cordY, 50, Road18.size);
		
		// TRASARE BENZI DELIMITATOARE - BRANESCU SERBAN
		g.setColor(Color.WHITE);
		g.fillRect(Road1.outputPort.cordX-110, Road1.outputPort.cordY+48, Road1.size, 2);
		g.fillRect(Road12.outputPort.cordX-110, Road12.outputPort.cordY+48, Road12.size, 4);
		g.fillRect(Road11.inputPort.cordX-110, Road11.inputPort.cordY+48, Road11.size, 2);
		g.fillRect(Road4.outputPort.cordX, Road4.outputPort.cordY+48, Road4.size, 2);
		g.fillRect(Road5.outputPort.cordX, Road5.outputPort.cordY+48, Road5.size, 4);
		g.fillRect(Road6.inputPort.cordX, Road6.inputPort.cordY+48, Road6.size, 2);
		g.fillRect(Road14.outputPort.cordX+110, Road14.outputPort.cordY+48, Road14.size, 2);
		g.fillRect(Road15.outputPort.cordX+110, Road15.outputPort.cordY+48, Road15.size, 4);
		g.fillRect(Road16.inputPort.cordX+110, Road16.inputPort.cordY+48, Road16.size, 2);
		g.fillRect(Road2.inputPort.cordX+48, Road2.inputPort.cordY-110, 2, Road2.size);
		g.fillRect(Road9.outputPort.cordX+48, Road9.outputPort.cordY+110, 2, Road9.size);
		g.fillRect(Road19.outputPort.cordX+48, Road19.outputPort.cordY+110, 2, Road19.size);
		
		//treceri pietoni Intersectia B - Branescu Serban
		
		g.fillRect(1350, Road14.outputPort.cordY+5,50, 10);
		g.fillRect(1350, Road14.outputPort.cordY+23,50, 10);
		g.fillRect(1350, Road14.outputPort.cordY+43,50, 10);
		g.fillRect(1350, Road14.outputPort.cordY+63,50, 10);
		g.fillRect(1350, Road14.outputPort.cordY+83,50, 10);
		g.fillRect(1350, Road14.outputPort.cordY+103,50, 10);
		g.fillRect(1350, Road14.outputPort.cordY+123,50, 10);
		g.fillRect(1350, Road14.outputPort.cordY+143,50, 10);
		g.fillRect(1350, Road14.outputPort.cordY+163,50, 10);
		g.fillRect(1350, Road14.outputPort.cordY+183,50, 10);
		
		g.fillRect(1205, 650, 10, 50);
		g.fillRect(1225, 650, 10, 50);
		g.fillRect(1245, 650, 10, 50);
		g.fillRect(1265, 650, 10, 50);
		g.fillRect(1285, 650, 10, 50);
		
		//treceri pietoni Intersectia A - Bradea Octavia
		g.fillRect(500, Road1.outputPort.cordY+5,50, 10);
		g.fillRect(500, Road1.outputPort.cordY+23,50, 10);
		g.fillRect(500, Road1.outputPort.cordY+43,50, 10);
		g.fillRect(500, Road1.outputPort.cordY+63,50, 10);
		g.fillRect(500, Road1.outputPort.cordY+83,50, 10);
		g.fillRect(500, Road1.outputPort.cordY+103,50, 10);
		g.fillRect(500, Road1.outputPort.cordY+123,50, 10);
		g.fillRect(500, Road1.outputPort.cordY+143,50, 10);
		g.fillRect(500, Road1.outputPort.cordY+163,50, 10);
		g.fillRect(500, Road1.outputPort.cordY+183,50, 10);	
		g.fillRect(Road2.inputPort.cordX+5,300, 10,50);
		g.fillRect(Road2.inputPort.cordX+23,300, 10,50);
		g.fillRect(Road2.inputPort.cordX+43,300, 10,50);
		g.fillRect(Road2.inputPort.cordX+63,300, 10,50);
		g.fillRect(Road2.inputPort.cordX+83,300, 10,50);	
		g.fillRect(Road9.outputPort.cordX+5, 650, 10, 50);
		g.fillRect(Road9.outputPort.cordX+23, 650, 10, 50);
		g.fillRect(Road9.outputPort.cordX+43, 650, 10, 50);
		g.fillRect(Road9.outputPort.cordX+63, 650, 10, 50);
		g.fillRect(Road9.outputPort.cordX+83, 650, 10, 50);
		
		g.fillRect(482,498, 8, 100);
		g.fillRect(1410,400, 8, 100);
		g.fillRect(600,282, 50, 8);
		g.fillRect(648,707, 50, 8);
		g.fillRect(1250,710, 50, 8);
		
		
		g.setColor(semaphore1.color);
		g.fillOval(semaphore1.cordX, semaphore1.cordY, 50, 50);
		g.fillOval(semaphore2.cordX, semaphore2.cordY, 50, 50);
		g.fillOval(semaphore3.cordX, semaphore3.cordY, 50, 50);
		g.fillOval(semaphore4.cordX, semaphore4.cordY, 50, 50);
		g.fillOval(semaphore6.cordX, semaphore6.cordY, 50, 50);
		g.fillOval(semaphore7.cordX, semaphore7.cordY, 50, 50);
		g.fillOval(semaphore8.cordX, semaphore8.cordY, 50, 50);
		
		
		
		
		
		
		
		

		for(Road r: roads) {
			
			for(int i=0; i<r.listOFcars.size(); i++) {
				g.setColor(r.listOFcars.get(i).color);
				g.fillRect(r.listOFcars.get(i).x, r.listOFcars.get(i).y, r.listOFcars.get(i).width, r.listOFcars.get(i).height);
				
			}
			
		}
		
		for(int j=0; j<roads.size(); j++) {
			
			
				
				if(roads.get(j).orientation == Orientation.E_West) {
					
					for(int i=0; i<roads.get(j).listOFcars.size(); i++) {
						if(roads.get(j).listOFcars.get(i).x >= roads.get(j).outputPort.cordX+10) {
							
							roads.get(j).listOFcars.get(i).x -= 10;
						}
						
						if(roads.get(j).listOFcars.get(i).x == roads.get(j).outputPort.cordX) {
							int randomDirection = random.nextInt(roads.get(j).directionList.length-1);
							
						}
					}	
					
				}
				
				if(roads.get(j).orientation == Orientation.E_North) {
					for(int i=0; i<roads.get(j).listOFcars.size(); i++) {
						if(roads.get(j).listOFcars.get(i).y >= roads.get(j).outputPort.cordY+10) {
							
							roads.get(j).listOFcars.get(i).y -= 10;
							
						}	
					}
				}
				
				if(roads.get(j).orientation == Orientation.E_East) {

					for(int i=0; i<roads.get(j).listOFcars.size(); i++) {
						if(roads.get(j).listOFcars.get(i).x < roads.get(j).outputPort.cordX-50) {
							
							roads.get(j).listOFcars.get(i).x += 10;
							
						}
						if(roads.get(j).listOFcars.get(i).x == roads.get(j).outputPort.cordX-50) {
							int randomDirection = random.nextInt(roads.get(j).directionList.length-1);
							if(roads.get(j).directionList[randomDirection] == Direction.E_Forward) {
								
							}
						}
					}
				}
				
				if(roads.get(j).orientation == Orientation.E_South) {
					for(int i=0; i<roads.get(j).listOFcars.size(); i++) {
						if(roads.get(j).listOFcars.get(i).y < roads.get(j).outputPort.cordY-50) {
							
							roads.get(j).listOFcars.get(i).y += 10;
							
						}	
					}
				}
				
			}
			
			
			/*
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
					if(roads.get(j).listOFcars.get(i).y == roads.get(j).outputPort.cordY) {
						int nrRandom_direction = random.nextInt(roads.get(j).directionList.length);
						if(nrRandom_direction == 2 || nrRandom_direction == 1 || nrRandom_direction == 0) {
							roads.get(0).listOFcars.add(roads.get(j).listOFcars.get(i));							
						}
					}
						
				}
				
				
			}*/
			
		}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		repaint();
		
	}
}
