package logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import static logic.CreateObject.*;

public class World extends JPanel implements ActionListener {


    static Port P1I, P2I, P3I, P4I, P5I, P6I, P7I, P8I, P9I, P10I, P11I, P12I, P13I, P14I, P15I, P16I, P17I, P18I, P19I;
    static Port P1O, P2O, P3O, P4O, P5O, P6O, P7O, P8O, P9O, P10O, P11O, P12O, P13O, P14O, P15O, P16O, P17O, P18O, P19O;
    static Road Road1, Road2, Road3, Road4, Road5, Road6, Road7, Road8, Road9, Road10, Road11, Road12, Road13, Road14, Road15, Road16, Road17, Road18, Road19;
    static Semaphore semaphore1, semaphore2, semaphore3, semaphore4, semaphore6, semaphore7, semaphore8, semaphoreP1_1, semaphoreP1_2, semaphoreP2_1, semaphoreP2_2, semaphoreP3_1, semaphoreP3_2;

    static List <Road> roads = new ArrayList <>();
    static List<Color> carColors = new ArrayList<>();


	private static Thread thread;
	private static Random random = new Random();
    private Timer timer = new Timer(400,this);
    private static int numar_masini = -20 ;
	
	





	private World() {
		setLayout(null);


		thread = new Thread (() -> {

		for(int i=0; i<1000; i++) {
			roads.get(9).semaphore.isGreen = true;
			roads.get(6).semaphore.isGreen = true;
			roads.get(13).semaphore.isGreen = true;
			roads.get(3).semaphore.isGreen = true;
			roads.get(7).semaphore.isGreen = false;
			roads.get(17).semaphore.isGreen = false;
			roads.get(1).semaphore.isGreen = false;

			try {
				Thread.sleep(10000);
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
				Thread.sleep(10000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

		});



		JButton btnClick = new JButton("START");
		btnClick.addActionListener(e -> {
			timer.start();
			thread.start();
			btnClick.setEnabled(false);


		});
		btnClick.setBounds(86, 80, 89, 23);
		add(btnClick);

		JButton buttonStop = new JButton("STOP");
		buttonStop.setBounds(213, 80, 89, 23);
		buttonStop.addActionListener(e -> {

        });
		add(buttonStop);

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

	}







	public static void main(String[] args) {
		
		World w = new World();
		
		JFrame frame = new JFrame();
		
		frame.setTitle("World - Traffic Simulation");
		frame.setSize(1900, 1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.getContentPane().add(w);

        createObjects();
		
	}
	






	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintObjects(g);
		}





	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		for(int j=0; j<roads.size(); j++) {

					for(int i=roads.get(j).compartimente.length-1; i>=0; i--) {
						
						if(i>0 && roads.get(j).compartimente[i].isEmpty && !roads.get(j).compartimente[i-1].isEmpty) {
							roads.get(j).compartimente[i].car.color = roads.get(j).compartimente[i-1].car.color;
							roads.get(j).compartimente[i].car.width = roads.get(j).compartimente[i-1].car.width;
							roads.get(j).compartimente[i].car.height = roads.get(j).compartimente[i-1].car.height;
							roads.get(j).compartimente[i].car.x = roads.get(j).compartimente[i].x;
							roads.get(j).compartimente[i].car.y = roads.get(j).compartimente[i].y;
							roads.get(j).compartimente[i-1].isEmpty = true;
							roads.get(j).compartimente[i].isEmpty = false;
						}


						if(j==12 || j==16 || j==15 || j==2 || j==0 || j==11 || j==18 || j==8) {
							if(i==roads.get(j).compartimente.length-1  && !roads.get(j).compartimente[i-1].isEmpty) {
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



						if(i==0 && roads.get(j).compartimente[i].isEmpty && numar_masini<20) {
							if(j==1 || j==7 || j==9 || j==10 || j==13 || j==14 || j==17) {
								boolean randomB = random.nextBoolean();
								if(randomB) {
									
									boolean randomB2 = random.nextBoolean();
									if(randomB2) {
									int nrRandomCulori = random.nextInt(7);
									roads.get(j).compartimente[i].car = new Car(roads.get(j).compartimente[i].x, roads.get(j).compartimente[i].y, carColors.get(nrRandomCulori),40,40);
									roads.get(j).compartimente[i].isEmpty = false;
									numar_masini++;
									}
								}						
							}
						}



						if(roads.get(j).semaphore != null && roads.get(j).semaphore.isGreen) {
							if(i == roads.get(j).compartimente.length-1 && !roads.get(j).compartimente[i].isEmpty ) {
								
								if(roads.get(j).hasDirection) {
									int randomNR = random.nextInt(roads.get(j).directionList.length);
									
									if(roads.get(j).directionList[randomNR].isEmpty) {
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
