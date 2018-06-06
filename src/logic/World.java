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
import java.awt.Font;

public class World extends JPanel implements ActionListener {


    static Port P1I, P2I, P3I, P4I, P5I, P6I, P7I, P8I, P9I, P10I, P11I, P12I, P13I, P14I, P15I, P16I, P17I, P18I, P19I;
    static Port P1O, P2O, P3O, P4O, P5O, P6O, P7O, P8O, P9O, P10O, P11O, P12O, P13O, P14O, P15O, P16O, P17O, P18O, P19O;
    static Road Road1, Road2, Road3, Road4, Road5, Road6, Road7, Road8, Road9, Road10, Road11, Road12, Road13, Road14, Road15, Road16, Road17, Road18, Road19;
	static Road Road2_1, Road2_6, Road2_9, Road4_1, Road4_3, Road5_2, Road5_9, Road6_13, Road6_16, Road7_17, Road7_19, Road8_3, Road8_7, Road8_12, Road10_7, Road10_9, Road11_6, Road11_3, Road14_4, Road14_13, Road15_5, Road15_19, Road18_5, Road18_13, Road18_17;
    static Semaphore semaphore1, semaphore2, semaphore3, semaphore4, semaphore6, semaphore7, semaphore8, semaphoreP1_1, semaphoreP1_2, semaphoreP2_1, semaphoreP2_2, semaphoreP3_1, semaphoreP3_2, semaphoreP4_1, semaphoreP4_2, semaphoreP5_1, semaphoreP5_2;

    static List <Road> roads = new ArrayList <>();
    static List <Road> roadsIntersection = new ArrayList<>();
    static List<Color> carColors = new ArrayList<>();


	private static Thread thread;
	static Random random = new Random();
    private Timer timer = new Timer(400,this);
    static int numar_masini ;
    static int numar_actual_masini = 0;
    static int timp_semafoare;
	static int timerSemafoarePrincipaleVerde, timerSemafoarePrincipaleRosu ,timerSemafoareSecundareVerde, timerSemafoareSecundareRosu;
    static int ts;
    static JLabel timerSP, timerSP2, timerSP3, timerSP4, timerSS, timerSS2, timerSS3, numarMasiniText;




	private World() {
		setLayout(null);
		
		
		//Thread semafoare Albu Adela


		thread = new Thread (() -> {


		for(int i=0; i<1000; i++) {

//2 secunde inainte de a incepe semafoarele se isi schimbe starea
			try{
				Thread.sleep(2000);
			}catch (Exception e){
				e.printStackTrace();
			}

//semafoarele principale devin verde

			roads.get(9).semaphore.isGreen = true;
			roads.get(6).semaphore.isGreen = true;
			roads.get(13).semaphore.isGreen = true;
			roads.get(3).semaphore.isGreen = true;
			roads.get(7).semaphore.isGreen = false;
			roads.get(17).semaphore.isGreen = false;
			roads.get(1).semaphore.isGreen = false;


			try {
				ts = timerSemafoarePrincipaleVerde;
				timerSP.setText("" + ts);
				timerSP2.setText("" + ts);
				timerSP3.setText("" + ts);
				timerSP4.setText("" + ts);
				timerSS.setText("" + ts);
				timerSS2.setText("" + ts);
				timerSS3.setText("" + ts);
				for(int k=0; k<timerSemafoarePrincipaleVerde; k++){
					timerSP.setText("" + ts);
					timerSP2.setText("" + ts);
					timerSP3.setText("" + ts);
					timerSP4.setText("" + ts);
					timerSS.setText("" + ts);
					timerSS2.setText("" + ts);
					timerSS3.setText("" + ts);
					ts--;
					Thread.sleep(1000);

				}
				timerSP.setText("" + ts);
				timerSP2.setText("" + ts);
				timerSP3.setText("" + ts);
				timerSP4.setText("" + ts);
				timerSS.setText("" + ts);
				timerSS2.setText("" + ts);
				timerSS3.setText("" + ts);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
//toate semafoarele devin rosii pt 2 secunde
			roads.get(9).semaphore.isGreen = false;
			roads.get(6).semaphore.isGreen = false;
			roads.get(13).semaphore.isGreen = false;
			roads.get(3).semaphore.isGreen = false;
			roads.get(7).semaphore.isGreen = false;
			roads.get(17).semaphore.isGreen = false;
			roads.get(1).semaphore.isGreen = false;

			try{
				Thread.sleep(2000);
			}catch (Exception e){
				e.printStackTrace();
			}
//semafoarele secundare devin verzi
			roads.get(9).semaphore.isGreen = false;
			roads.get(6).semaphore.isGreen = false;
			roads.get(13).semaphore.isGreen = false;
			roads.get(3).semaphore.isGreen = false;
			roads.get(7).semaphore.isGreen = true;
			roads.get(17).semaphore.isGreen = true;
			roads.get(1).semaphore.isGreen = true;

			try {
				ts = timerSemafoarePrincipaleRosu;
				timerSP.setText("" + ts);
				timerSP2.setText("" + ts);
				timerSP3.setText("" + ts);
				timerSP4.setText("" + ts);
				timerSS.setText("" + ts);
				timerSS2.setText("" + ts);
				timerSS3.setText("" + ts);
				for(int k=0; k<timerSemafoarePrincipaleRosu; k++){
					timerSP.setText("" + ts);
					timerSP2.setText("" + ts);
					timerSP3.setText("" + ts);
					timerSP4.setText("" + ts);
					timerSS.setText("" + ts);
					timerSS2.setText("" + ts);
					timerSS3.setText("" + ts);
					ts--;
					Thread.sleep(1000);

				}
				timerSP.setText("" + ts);
				timerSP2.setText("" + ts);
				timerSP3.setText("" + ts);
				timerSP4.setText("" + ts);
				timerSS.setText("" + ts);
				timerSS2.setText("" + ts);
				timerSS3.setText("" + ts);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
//toate semafoarele rosii din nou
			roads.get(9).semaphore.isGreen = false;
			roads.get(6).semaphore.isGreen = false;
			roads.get(13).semaphore.isGreen = false;
			roads.get(3).semaphore.isGreen = false;
			roads.get(7).semaphore.isGreen = false;
			roads.get(17).semaphore.isGreen = false;
			roads.get(1).semaphore.isGreen = false;

			

		}

		});



		JButton btnClick = new JButton("START");
		btnClick.addActionListener(e -> {
			timer.start();
			thread.start();
			numar_masini = 20;
			btnClick.setEnabled(false);


		});
		btnClick.setBounds(86, 100, 89, 23);
		add(btnClick);

		JButton buttonStop = new JButton("STOP");
		buttonStop.setBounds(213, 100, 89, 23);
		buttonStop.addActionListener(e -> {

        });
		add(buttonStop);

		JButton btnScenariu1 = new JButton("SCENARIU 1");
		btnScenariu1.setBounds(50,50,120,20);
		btnScenariu1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				timer.start();
				numar_masini = 15;
				//TIMP SEMAFOARE * 1 SECUNDE

				timerSemafoarePrincipaleVerde = 20;
				timerSemafoarePrincipaleRosu = 15;



				if(!thread.isAlive()){
					thread.start();
				}

			}
		});
		add(btnScenariu1);


		JButton btnScenariu2 = new JButton("SCENARIU 2");
		btnScenariu2.setBounds(180,50,120,20);
		btnScenariu2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				timer.start();
				numar_masini = 20;
				timp_semafoare = 6000;



			}
		});
		add(btnScenariu2);

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
        
        
        
        numarMasiniText = new JLabel("Numar masini: ");
        numarMasiniText.setFont(new Font("Tahoma", Font.PLAIN, 15));
        numarMasiniText.setBounds(339, 30, 200, 200);
        add(numarMasiniText);
        
        timerSP = new JLabel("");
        timerSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
        timerSP.setBounds(738, 348, 46, 14);
        add(timerSP);
        
        timerSP2 = new JLabel("");
        timerSP2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        timerSP2.setBounds(549, 638, 46, 14);
        add(timerSP2);
        
        timerSP3 = new JLabel("");
        timerSP3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        timerSP3.setBounds(1338, 355, 46, 14);
        add(timerSP3);
        
        timerSP4 = new JLabel("");
        timerSP4.setFont(new Font("Tahoma", Font.PLAIN, 15));
        timerSP4.setBounds(1153, 640, 46, 14);
        add(timerSP4);

        
        timerSS = new JLabel("");
        timerSS.setFont(new Font("Tahoma", Font.PLAIN, 15));
        timerSS.setBounds(545, 348, 46, 14);
        add(timerSS);
        
        timerSS2 = new JLabel("");
        timerSS2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        timerSS2.setBounds(735, 638, 46, 14);
        add(timerSS2);
        
        timerSS3 = new JLabel("");
        timerSS3.setFont(new Font("Tahoma", Font.PLAIN, 15));
        timerSS3.setBounds(1337, 638, 46, 14);
        add(timerSS3);
        
       

	}


	public static void main() {
		
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


		doSimulation();
		//doSim();
		repaint();




	}
}
