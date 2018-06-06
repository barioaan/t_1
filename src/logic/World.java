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
    private Timer timer = new Timer(1000,this);
    static int numar_masini ;
    static int numar_actual_masini = 0;
    static int timp_semafoare;
	static int timerSemafoarePrincipaleVerde, timerSemafoarePrincipaleRosu ,timerSemafoareSecundareVerde, timerSemafoareSecundareRosu;
    static int ts;
    static JLabel timerSP, timerSP2, timerSP3, timerSP4, timerSS, timerSS2, timerSS3, numarMasiniText;
    static JTextArea textArea;
    private JButton btnScenariu3, btnScenariu4;
    static int timp_timer;
    static int verde_pietoni_principal, verde_pietoni_secundar;




	private World() {
		setLayout(null);
		
		
		//Thread semafoare Albu Adela


		thread = new Thread (() -> {


		for(int i=0; i<1000; i++) {

			//2 secunde inainte de a incepe semafoarele se isi schimbe starea
			try{
				Thread.sleep(2000);
			}catch (Exception e){
				
			}

			//semafoarele principale devin verde

			roads.get(0).compartimente[0].pietoni = false;
			roads.get(9).compartimente[0].pietoni = false;
			roads.get(10).compartimente[0].pietoni = false;
			roads.get(11).compartimente[0].pietoni = false;
			roads.get(13).compartimente[0].pietoni = false;
			roads.get(14).compartimente[0].pietoni = false;
			roads.get(15).compartimente[0].pietoni = false;
			roads.get(16).compartimente[0].pietoni = false;


			roads.get(1).compartimente[0].pietoni = true;
			roads.get(2).compartimente[0].pietoni = true;
			roads.get(7).compartimente[0].pietoni = true;
			roads.get(8).compartimente[0].pietoni = true;
			roads.get(17).compartimente[0].pietoni = true;
			roads.get(18).compartimente[0].pietoni = true;



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
				roads.get(8).compartimente[0].pietoni = true;
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
					if(k==verde_pietoni_secundar-1){
						roads.get(0).compartimente[0].pietoni = false;
						roads.get(9).compartimente[0].pietoni = false;
						roads.get(10).compartimente[0].pietoni = false;
						roads.get(11).compartimente[0].pietoni = false;
						roads.get(13).compartimente[0].pietoni = false;
						roads.get(14).compartimente[0].pietoni = false;
						roads.get(15).compartimente[0].pietoni = false;
						roads.get(16).compartimente[0].pietoni = false;


						roads.get(1).compartimente[0].pietoni = false;
						roads.get(2).compartimente[0].pietoni = false;
						roads.get(7).compartimente[0].pietoni = false;
						roads.get(8).compartimente[0].pietoni = false;
						roads.get(17).compartimente[0].pietoni = false;
						roads.get(18).compartimente[0].pietoni = false;
					}

				}
				timerSP.setText("" + ts);
				timerSP2.setText("" + ts);
				timerSP3.setText("" + ts);
				timerSP4.setText("" + ts);
				timerSS.setText("" + ts);
				timerSS2.setText("" + ts);
				timerSS3.setText("" + ts);

			} catch (InterruptedException e) {

				
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
				
			}
			
			//semafoarele secundare devin verzi

			roads.get(0).compartimente[0].pietoni = true;
			roads.get(9).compartimente[0].pietoni = true;
			roads.get(10).compartimente[0].pietoni = true;
			roads.get(11).compartimente[0].pietoni = true;
			roads.get(13).compartimente[0].pietoni = true;
			roads.get(14).compartimente[0].pietoni = true;
			roads.get(15).compartimente[0].pietoni = true;
			roads.get(16).compartimente[0].pietoni = true;


			roads.get(1).compartimente[0].pietoni = false;
			roads.get(2).compartimente[0].pietoni = false;
			roads.get(7).compartimente[0].pietoni = false;
			roads.get(8).compartimente[0].pietoni = false;
			roads.get(17).compartimente[0].pietoni = false;
			roads.get(18).compartimente[0].pietoni = false;



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
					if(k==verde_pietoni_principal-1){
						roads.get(0).compartimente[0].pietoni = false;
						roads.get(9).compartimente[0].pietoni = false;
						roads.get(10).compartimente[0].pietoni = false;
						roads.get(11).compartimente[0].pietoni = false;
						roads.get(13).compartimente[0].pietoni = false;
						roads.get(14).compartimente[0].pietoni = false;
						roads.get(15).compartimente[0].pietoni = false;
						roads.get(16).compartimente[0].pietoni = false;


						roads.get(1).compartimente[0].pietoni = false;
						roads.get(2).compartimente[0].pietoni = false;
						roads.get(7).compartimente[0].pietoni = false;
						roads.get(8).compartimente[0].pietoni = false;
						roads.get(17).compartimente[0].pietoni = false;
						roads.get(18).compartimente[0].pietoni = false;
					}

				}
				timerSP.setText("" + ts);
				timerSP2.setText("" + ts);
				timerSP3.setText("" + ts);
				timerSP4.setText("" + ts);
				timerSS.setText("" + ts);
				timerSS2.setText("" + ts);
				timerSS3.setText("" + ts);

			} catch (InterruptedException e) {

				
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





		JButton btnScenariu1 = new JButton("SCENARIU 1");
		btnScenariu1.setBounds(798,47,115,20);
		btnScenariu1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				
				if(!timer.isRunning()) {
					timer.start();
				}
				
				if(thread.isAlive()){
					thread.interrupt();
				}
				
				timp_timer = 100;
				timer.setDelay(timp_timer);
				numar_masini = 50;

				timerSemafoarePrincipaleVerde = 20;
				timerSemafoarePrincipaleRosu = 15;
				verde_pietoni_principal = 6;
				verde_pietoni_secundar = 4;

				textArea.setText(null);
				textArea.append("\n");
				textArea.append("\n");
				textArea.append("####################################################\n\n");
				textArea.append("#INTERVAL_ORAR : " + " 07:00 - 09:00 | 17:00 - 19:00\n");
				textArea.append("#NUMAR_MASINI : " + numar_masini + "\n");
				textArea.append("#SEMAFOARE_PRINCIPALE_VERDE : " + timerSemafoarePrincipaleVerde + "\n");
				textArea.append("#SEMAFOARE_SECUNDARE_VERDE : " + timerSemafoarePrincipaleRosu + "\n");
				textArea.append("\n");
				textArea.append("\n");
				textArea.append("####################################################\n");


				if(!thread.isAlive()){
					thread.start();
				}

			}
		});
		add(btnScenariu1);


		JButton btnScenariu2 = new JButton("SCENARIU 2");
		btnScenariu2.setBounds(923,47,115,20);
		btnScenariu2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				if(!timer.isRunning()) {
					timer.start();
				}

				if(thread.isAlive()){
					thread.interrupt();
				}

				timp_timer = 100;
				timer.setDelay(timp_timer);
				numar_masini = 35;

				timerSemafoarePrincipaleVerde = 16;
				timerSemafoarePrincipaleRosu = 12;
				verde_pietoni_principal = 8;
				verde_pietoni_secundar = 6;

				textArea.setText(null);
				textArea.append("\n");
				textArea.append("\n");
				textArea.append("####################################################\n\n");
				textArea.append("#INTERVAL_ORAR : " + " 09:00 - 12:00 | 15:00 - 16:00 | 20:00 - 22:00\n");
				textArea.append("#NUMAR_MASINI : " + numar_masini + "\n");
				textArea.append("#SEMAFOARE_PRINCIPALE_VERDE : " + timerSemafoarePrincipaleVerde + "\n");
				textArea.append("#SEMAFOARE_SECUNDARE_VERDE : " + timerSemafoarePrincipaleRosu + "\n");
				textArea.append("\n");
				textArea.append("\n");
				textArea.append("####################################################\n");


				if(!thread.isAlive()){
					thread.start();
				}

			}		});
		add(btnScenariu2);
		
		btnScenariu3 = new JButton("SCENARIU 3");
	    btnScenariu3.setBounds(1049, 47, 115, 20);
	    btnScenariu3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				if(!timer.isRunning()) {
					timer.start();
				}

				if(thread.isAlive()){
					thread.interrupt();
				}

				timp_timer = 100;
				timer.setDelay(timp_timer);
				numar_masini = 28;

				timerSemafoarePrincipaleVerde = 14;
				timerSemafoarePrincipaleRosu = 11;
				verde_pietoni_principal = 10;
				verde_pietoni_secundar = 8;

				textArea.setText(null);
				textArea.append("\n");
				textArea.append("\n");
				textArea.append("####################################################\n\n");
				textArea.append("#INTERVAL_ORAR : " + " 12:00 - 15:00 \n");
				textArea.append("#NUMAR_MASINI : " + numar_masini + "\n");
				textArea.append("#SEMAFOARE_PRINCIPALE_VERDE : " + timerSemafoarePrincipaleVerde + "\n");
				textArea.append("#SEMAFOARE_SECUNDARE_VERDE : " + timerSemafoarePrincipaleRosu + "\n");
				textArea.append("\n");
				textArea.append("\n");
				textArea.append("####################################################\n");


				if(!thread.isAlive()){
					thread.start();
				}

			}
		});
	    add(btnScenariu3);

		btnScenariu4 = new JButton("SCENARIU 4");
		btnScenariu4.setBounds(1170, 47, 115, 20);
		btnScenariu4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {


				if(!timer.isRunning()) {
					timer.start();
				}

				if(thread.isAlive()){
					thread.interrupt();
				}

				timp_timer = 100;
				timer.setDelay(timp_timer);
				numar_masini = 10;

				timerSemafoarePrincipaleVerde = 10;
				timerSemafoarePrincipaleRosu = 7;
				verde_pietoni_principal = 5;
				verde_pietoni_secundar = 4;

				textArea.setText(null);
				textArea.append("\n");
				textArea.append("\n");
				textArea.append("####################################################\n\n");
				textArea.append("#INTERVAL_ORAR : " + " 22:00 - 07:00 \n");
				textArea.append("#NUMAR_MASINI : " + numar_masini + "\n");
				textArea.append("#SEMAFOARE_PRINCIPALE_VERDE : " + timerSemafoarePrincipaleVerde + "\n");
				textArea.append("#SEMAFOARE_SECUNDARE_VERDE : " + timerSemafoarePrincipaleRosu + "\n");
				textArea.append("\n");
				textArea.append("\n");
				textArea.append("####################################################\n");


				if(!thread.isAlive()){
					thread.start();
				}

			}
		});
		add(btnScenariu4);

        //POZA CU SCOALA - ALBU ADELA
        JLabel poza_sc = new JLabel("");
        URL scoala = getClass().getResource("/scoala2.jpg");
        Icon imagine_scoala = new ImageIcon (scoala);       

        //POZA SENS UNIC - ALBU ADELA
        JLabel sens_unic = new JLabel("");
        URL sensunic = getClass().getResource("/imagine.jpg");
        Icon sens = new ImageIcon (sensunic);
        sens_unic.setIcon(sens);
        sens_unic.setBounds(1315, 280, 55, 55);
        add(sens_unic);
        
        textArea = new JTextArea();
        textArea.setBounds(798, 99, 366, 200);
        textArea.setEditable(false);
        add(textArea);
        poza_sc.setIcon(imagine_scoala);
        poza_sc.setBounds(70, 30, 300, 450);
        add(poza_sc);
        
        //TIMERE SEMAFOARE - BAR IOAN
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
		repaint();




	}
}
