package logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JTextField;
import java.awt.Font;

public class World extends JPanel implements Space, ActionListener {


    public static int numar_masini = -20 ;

	public static Thread thread;
	
	public static Random random = new Random();

	Timer timer = new Timer(400,this);
	
	

//	public static ArrayList<Semaphore> semaphoreList;

	public static ArrayList<Color> carColors = new ArrayList<Color>();
	
	

	public World() {
		setLayout(null);
		txtTimer = new JTextField();
		txtTimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTimer.setBounds(86, 49, 86, 20);
		add(txtTimer);
		txtTimer.setColumns(10);
		
		thread = new Thread (new Runnable() {

			@Override
			public void run() {
				
			for(int i=0; i<1000; i++) {
				roads.get(9).semaphore.isGreen = true;
				roads.get(6).semaphore.isGreen = true;
				roads.get(13).semaphore.isGreen = true;
				roads.get(3).semaphore.isGreen = true;
				roads.get(7).semaphore.isGreen = false;
				roads.get(17).semaphore.isGreen = false;
				roads.get(1).semaphore.isGreen = false;
				
				try {
					thread.sleep(10000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
				roads.get(9).semaphore.isGreen = false;
				roads.get(6).semaphore.isGreen = false;
				roads.get(13).semaphore.isGreen = false;
				roads.get(3).semaphore.isGreen = false;
				roads.get(7).semaphore.isGreen = true;
				roads.get(17).semaphore.isGreen = true;
				roads.get(1).semaphore.isGreen = true;
				
				try {
					thread.sleep(10000);
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
				
			}
			
				
			
		});



		JButton btnClick = new JButton("START");
		btnClick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.start();
				thread.start();
				btnClick.setEnabled(false);
				
				
			}
		});
		btnClick.setBounds(86, 80, 89, 23);
		add(btnClick);
		
		
		
		//POZA CU SCOALA - ALBU ADELA
		JLabel poza_sc = new JLabel("");
		URL scoala = getClass().getResource("/scoala2.jpg");
		Icon imagine_scoala = new ImageIcon (scoala);
		poza_sc.setIcon(imagine_scoala);
		poza_sc.setBounds(70, 30, 300, 450);
		add(poza_sc);
		
		//POZA SENS UNIC - ALBU ADELA
		JLabel sens_unic = new JLabel("");
		URL sensunic = getClass().getResource("/imagine.jpg");
	    Icon sens = new ImageIcon (sensunic);
		sens_unic.setIcon(sens);
		sens_unic.setBounds(1315, 280, 55, 55);
		add(sens_unic);
		
		JButton buttonStop = new JButton("STOP");
		buttonStop.setBounds(213, 80, 89, 23);
		buttonStop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				//timer.stop();
				//verde = false;
				//roads.get(6).semaphore.isGreen = false;
				//roads.get(10).semaphore.isGreen = false;
				//repaint();
                //repaisafnsadfnafdsaf
			}
			
		});
		add(buttonStop);
		
		
		
		
	}
	

	public static Port P1I, P2I, P3I, P4I, P5I, P6I, P7I, P8I, P9I, P10I, P11I, P12I, P13I, P14I, P15I, P16I, P17I, P18I, P19I;
	public static Port P1O, P2O, P3O, P4O, P5O, P6O, P7O, P8O, P9O, P10O, P11O, P12O, P13O, P14O, P15O, P16O, P17O, P18O, P19O;
	public static Road Road1, Road2, Road3, Road4, Road5, Road6, Road7, Road8, Road9, Road10, Road11, Road12, Road13, Road14, Road15, Road16, Road17, Road18, Road19;
    public static Semaphore semaphore1, semaphore2, semaphore3, semaphore4, semaphore5, semaphore6, semaphore7, semaphore8, semaphoreP1_1, semaphoreP1_2, semaphoreP2_1, semaphoreP2_2, semaphoreP3_1, semaphoreP3_2;
	

	public static List <Road> roads = new ArrayList <>();
	public List <Port> ports = new ArrayList <Port>();
	public static List <Intersection> intersections = new ArrayList <Intersection>();
	
	
	public JTextField txtTimer;
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

        CreateObject.createPorts();

		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Color darkGreen = new Color(28,98,71);
		Color backgroundColor = new Color(109,219,54);
		//timer.start();
		
		//DESENARE BACKGROUND - BAR IOAN\
		//g.setColor(darkGreen);//
		g.setColor(backgroundColor);
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
		
		
			
			for( Road r: roads) {
				if(r.semaphore!=null && r.semaphore.isGreen == true) {
					g.setColor(Color.GREEN);
					g.fillOval(r.semaphore.cordX, r.semaphore.cordY, 50, 50);

				}
				if(r.semaphore!=null && r.semaphore.isGreen == false) {
					g.setColor(Color.RED);
					g.fillOval(r.semaphore.cordX, r.semaphore.cordY, 50, 50);

				}
			}

        g.setColor(Color.BLUE);
        g.fillOval(semaphoreP1_1.cordX, semaphoreP1_1.cordY, 25, 25);
        g.fillOval(semaphoreP1_2.cordX, semaphoreP1_1.cordY, 25, 25);
        g.fillOval(semaphoreP2_1.cordX, semaphoreP1_1.cordY, 25, 25);
        g.fillOval(semaphoreP2_2.cordX, semaphoreP1_1.cordY, 25, 25);
        g.fillOval(semaphoreP3_1.cordX, semaphoreP1_1.cordY, 25, 25);
        g.fillOval(semaphoreP3_2.cordX, semaphoreP1_1.cordY, 25, 25);
			
		
		
		
		
		
		
		for(Road r: roads) {
			for(int i=0; i<r.compartimente.length; i++) {
				if(r.compartimente[i].isEmpty == false) {
					g.setColor(r.compartimente[i].car.color);
					g.fillRect(r.compartimente[i].car.x, r.compartimente[i].car.y, r.compartimente[i].car.width, r.compartimente[i].car.height);
				}
			}
		}
			
				
			
	
			
		}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		for(int j=0; j<roads.size(); j++) {
			
			
				
					
					
					for(int i=roads.get(j).compartimente.length-1; i>=0; i--) {
						
						if(i>0 && roads.get(j).compartimente[i].isEmpty == true && roads.get(j).compartimente[i-1].isEmpty == false) {
							roads.get(j).compartimente[i].car.color = roads.get(j).compartimente[i-1].car.color;
							roads.get(j).compartimente[i].car.width = roads.get(j).compartimente[i-1].car.width;
							roads.get(j).compartimente[i].car.height = roads.get(j).compartimente[i-1].car.height;
							roads.get(j).compartimente[i].car.x = roads.get(j).compartimente[i].x;
							roads.get(j).compartimente[i].car.y = roads.get(j).compartimente[i].y;
							roads.get(j).compartimente[i-1].isEmpty = true;
							roads.get(j).compartimente[i].isEmpty = false;
						}
						if(j==12 || j==16 || j==15 || j==2 || j==0 || j==11 || j==18 || j==8) {
							if(i==roads.get(j).compartimente.length-1  && roads.get(j).compartimente[i-1].isEmpty == false) {
								roads.get(j).compartimente[i].car.color = roads.get(j).compartimente[i-1].car.color;
								roads.get(j).compartimente[i].car.width = roads.get(j).compartimente[i-1].car.width;
								roads.get(j).compartimente[i].car.height = roads.get(j).compartimente[i-1].car.height;
								roads.get(j).compartimente[i].car.x = roads.get(j).compartimente[i].x;
								roads.get(j).compartimente[i].car.y = roads.get(j).compartimente[i].y;
								roads.get(j).compartimente[i-1].isEmpty = true;
								roads.get(j).compartimente[i].isEmpty = false;
								numar_masini--;
							}
							
						}
						
						if(i==0 && roads.get(j).compartimente[i].isEmpty == true && numar_masini<20) {
							if(j==1 || j==7 || j==9 || j==10 || j==13 || j==14 || j==17) {
								boolean randomB = random.nextBoolean();
								if(randomB == true) {
									
									boolean randomB2 = random.nextBoolean();
									if(randomB2 == true) {
									int nrRandomCulori = random.nextInt(7);
									roads.get(j).compartimente[i].car = new Car(roads.get(j).compartimente[i].x, roads.get(j).compartimente[i].y, carColors.get(nrRandomCulori),40,40);
									roads.get(j).compartimente[i].isEmpty = false;
									numar_masini++;
									}
								}						
							}
						}
						
						if(roads.get(j).semaphore != null && roads.get(j).semaphore.isGreen == true) {
							if(i == roads.get(j).compartimente.length-1 && roads.get(j).compartimente[i].isEmpty == false ) {
								
								if(roads.get(j).hasDirection == true) {
									int randomNR = random.nextInt(roads.get(j).directionList.length);
									
									if(roads.get(j).directionList[randomNR].isEmpty == true) {
										roads.get(j).directionList[randomNR].car.color = roads.get(j).compartimente[i].car.color;
										roads.get(j).directionList[randomNR].car.width = roads.get(j).compartimente[i].car.width;
										roads.get(j).directionList[randomNR].car.height = roads.get(j).compartimente[i].car.height;
										roads.get(j).directionList[randomNR].car.x = roads.get(j).directionList[randomNR].x;
										roads.get(j).directionList[randomNR].car.y = roads.get(j).directionList[randomNR].y;
										roads.get(j).directionList[randomNR].isEmpty = false;
										roads.get(j).compartimente[i].isEmpty = true;
									}
								}
							}
							}
						
					}
				
				
				
			}

				
		repaint();
		
	}

}
