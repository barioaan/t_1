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

public class World extends JPanel implements Space, ActionListener {

	public static int numar_masini = 15 ;
	
	public static Random random = new Random();

	Timer timer = new Timer(300,this);

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
		
		
		
		//POZA CU SCOALA - ALBU ADELA
		JLabel poza_sc = new JLabel("");
		URL scoala = getClass().getResource("/scoala.jpg");
		Icon imagine_scoala = new ImageIcon (scoala);
		poza_sc.setIcon(imagine_scoala);
		poza_sc.setBounds(70, 80, 300, 450);
		add(poza_sc);
		
		//POZA SENS UNIC - ALBU ADELA
		JLabel sens_unic = new JLabel("");
		URL sensunic = getClass().getResource("/imagine.jpg");
		Icon sens = new ImageIcon (sensunic);
		sens_unic.setIcon(sens);
		sens_unic.setBounds(1315, 280, 55, 55);
		add(sens_unic);
		
		
	}
	

	private static Port P1I, P2I, P3I, P4I, P5I, P6I, P7I, P8I, P9I, P10I, P11I, P12I, P13I, P14I, P15I, P16I, P17I, P18I, P19I;
	private static Port P1O, P2O, P3O, P4O, P5O, P6O, P7O, P8O, P9O, P10O, P11O, P12O, P13O, P14O, P15O, P16O, P17O, P18O, P19O;
	private static Road Road1, Road2, Road3, Road4, Road5, Road6, Road7, Road8, Road9, Road10, Road11, Road12, Road13, Road14, Road15, Road16, Road17, Road18, Road19;
	public static Semaphore semaphore1, semaphore2, semaphore3, semaphore4, semaphore5, semaphore6, semaphore7, semaphore8;
	

	private static List <Road> roads = new ArrayList <Road>();
	private List <Port> ports = new ArrayList <Port>();
	private static List <Intersection> intersections = new ArrayList <Intersection>();
	
	
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
		
		//ADAUGARE LINIE UNDE SA SE OPREASCA MASINILE - BRANESCU SERBAN
		
		Road1.areLiniePietoni = false;
		Road2.areLiniePietoni = true;
		Road3.areLiniePietoni = false;
		Road4.areLiniePietoni = false;
		Road5.areLiniePietoni = false;
		Road6.areLiniePietoni = false;
		Road7.areLiniePietoni = false;
		Road8.areLiniePietoni = true;
		Road9.areLiniePietoni = false;
		Road10.areLiniePietoni = true;
		Road11.areLiniePietoni = true;
		Road12.areLiniePietoni = false;
		Road13.areLiniePietoni = false;
		Road14.areLiniePietoni = true;
		Road15.areLiniePietoni = true;
		Road16.areLiniePietoni = false;
		Road17.areLiniePietoni = false;
		Road18.areLiniePietoni = true;
		Road19.areLiniePietoni = false;
		
		
		
		//aici pentru drumurile care au linie la cele orizontale pui coordonata x si la cele verticale pui coordonata y
		Road10.coordonataLiniePietoni  = 482; 
		Road11.coordonataLiniePietoni  = 482;
		Road2.coordonataLiniePietoni  = 282;
		Road8.coordonataLiniePietoni  = 707;
		Road14.coordonataLiniePietoni  = 1410;
		Road15.coordonataLiniePietoni  = 1410;
		Road18.coordonataLiniePietoni  = 710;
		
		
		//COMPARTIMENTE DRUMURI
		//Road 1 - 13 compartimente ALBU ADELA

	//	Road1.setCompartimente(13);
		
		Compartiment [] compartimenteR1 = new Compartiment[13];
		
		Compartiment compartiment0 = new Compartiment(555, 400);
		compartimenteR1[0] = compartiment0;
		Compartiment compartiment1 = new Compartiment(510,400);
		compartimenteR1[1] = compartiment1;
		Compartiment compartiment2 = new Compartiment(465,400);
		compartimenteR1[2] = compartiment2;
		Compartiment compartiment3 = new Compartiment(420,400);
		compartimenteR1[3] = compartiment3;
		Compartiment compartiment4 = new Compartiment(375,400);
		compartimenteR1[4] = compartiment4;
		Compartiment compartiment5 = new Compartiment(330,400);
		compartimenteR1[5] = compartiment5;
		Compartiment compartiment6 = new Compartiment(285,400);
		compartimenteR1[6] = compartiment6;
		Compartiment compartiment7 = new Compartiment(240,400);
		compartimenteR1[7] = compartiment7;
		Compartiment compartiment8 = new Compartiment(195,400);
		compartimenteR1[8] = compartiment8;
		Compartiment compartiment9 = new Compartiment(150,400);
		compartimenteR1[9] = compartiment9;
		Compartiment compartiment10 = new Compartiment(105,400);
		compartimenteR1[10] = compartiment10;
		Compartiment compartiment11 = new Compartiment(60,400);
		compartimenteR1[11] = compartiment11;
		Compartiment compartiment12 = new Compartiment(15,400);
		compartimenteR1[12] = compartiment12;
		
		Road1.compartimente = compartimenteR1;
		
		//Road 2 - 6 compartimente BRANESCU SERBAN
		
		Compartiment [] compartimenteR2 = new Compartiment[6];
		
		Compartiment c_road2_0 = new Compartiment(600, 12);
		compartimenteR2[0] = c_road2_0;
		Compartiment c_road2_1 = new Compartiment(600, 57);
		compartimenteR2[1] = c_road2_1;
		Compartiment c_road2_2 = new Compartiment(600, 102);
		compartimenteR2[2] = c_road2_2;
		Compartiment c_road2_3 = new Compartiment(600, 147);
		compartimenteR2[3] = c_road2_3;
		Compartiment c_road2_4 = new Compartiment(600, 192);
		compartimenteR2[4] = c_road2_4;
		Compartiment c_road2_5 = new Compartiment(600, 237);
		compartimenteR2[5] = c_road2_5;
		
		Road2.compartimente = compartimenteR2;
		
		//Road 3 - 8 compartimente BRANESCU SERBAN
		
		Compartiment [] compartimenteR3 = new Compartiment[8];
		
		Compartiment c_road3_0 = new Compartiment (650,40);
		compartimenteR3[0] = c_road3_0;
		Compartiment c_road3_1 = new Compartiment (650,85);
		compartimenteR3[1] = c_road3_1;
		Compartiment c_road3_2 = new Compartiment (650,130);
		compartimenteR3[2] = c_road3_2;
		Compartiment c_road3_3 = new Compartiment (650,175);
		compartimenteR3[3] = c_road3_3;
		Compartiment c_road3_4 = new Compartiment (650,220);
		compartimenteR3[4] = c_road3_4;
		Compartiment c_road3_5 = new Compartiment (650,265);
		compartimenteR3[5] = c_road3_5;
		Compartiment c_road3_6 = new Compartiment (650,310);
		compartimenteR3[6] = c_road3_6;
		Compartiment c_road3_7 = new Compartiment (650,355);
		compartimenteR3[7] = c_road3_7;
		
		Road3.compartimente = compartimenteR3;
		
		//Road4 - 10 c BRADEA OCTAVIA
		
		Compartiment [] compartimenteR4 = new Compartiment[10];
		
		Compartiment c_road4_0  = new Compartiment(750, 400);
		compartimenteR4[0] = c_road4_0;
		Compartiment c_road4_1 = new Compartiment(795,400);
		compartimenteR4[1] = c_road4_1;
		Compartiment c_road4_2 = new Compartiment(840,400);
		compartimenteR4[2] = c_road4_2;
		Compartiment c_road4_3 = new Compartiment(885,400);
		compartimenteR4[3] = c_road4_3;
		Compartiment c_road4_4 = new Compartiment(930,400);
		compartimenteR4[4] = c_road4_4;
		Compartiment c_road4_5 = new Compartiment(975,400);
		compartimenteR4[5] = c_road4_5;
		Compartiment c_road4_6 = new Compartiment(1020,400);
		compartimenteR4[6] = c_road4_6;
		Compartiment c_road4_7 = new Compartiment(1065,400);
		compartimenteR4[7] = c_road4_7;
		Compartiment c_road4_8 = new Compartiment(1110,400);
		compartimenteR4[8] = c_road4_8;
		Compartiment c_road4_9 = new Compartiment(1155,400);
		compartimenteR4[9] = c_road4_9;
		
		Road4.compartimente = compartimenteR4;

		//Road5 - 10 c BRADEA

		Compartiment [] compartimenteR5 = new Compartiment[10];
		
		Compartiment c_road5_0  = new Compartiment(750, 450);
		compartimenteR5[0] = c_road5_0;
		Compartiment c_road5_1 = new Compartiment(795,450);
		compartimenteR5[1] = c_road5_1;
		Compartiment c_road5_2 = new Compartiment(840,450);
		compartimenteR5[2] = c_road5_2;
		Compartiment c_road5_3 = new Compartiment(885,450);
		compartimenteR5[3] = c_road5_3;
		Compartiment c_road5_4 = new Compartiment(930,450);
		compartimenteR5[4] = c_road5_4;
		Compartiment c_road5_5 = new Compartiment(975,450);
		compartimenteR5[5] = c_road5_5;
		Compartiment c_road5_6 = new Compartiment(1020,450);
		compartimenteR5[6] = c_road5_6;
		Compartiment c_road5_7 = new Compartiment(1065,450);
		compartimenteR5[7] = c_road5_7;
		Compartiment c_road5_8 = new Compartiment(1110,450);
		compartimenteR5[8] = c_road5_8;
		Compartiment c_road5_9 = new Compartiment(1155,450);
		compartimenteR5[9] = c_road5_9;
		
		Road5.compartimente = compartimenteR5;
		//Road 6 - 11 compartimente ALBU ADELA
		
		//	Road6.setCompartimente(11);
	 
	  Compartiment [] compartimenteR6 = new Compartiment[11];
		
		Compartiment c_road6_0 = new Compartiment(705, 500);
		compartimenteR6[0] = c_road6_0;
		Compartiment c_road6_1 = new Compartiment(750, 500);
		compartimenteR6[1] = c_road6_1;
		Compartiment c_road6_2 = new Compartiment(795, 500);
		compartimenteR6[2] = c_road6_2;
		Compartiment c_road6_3 = new Compartiment(840, 500);
		compartimenteR6[3] = c_road6_3;
		Compartiment c_road6_4 = new Compartiment(885, 500);
		compartimenteR6[4] = c_road6_4;
		Compartiment c_road6_5 = new Compartiment(930, 500);
		compartimenteR6[5] = c_road6_5;
		Compartiment c_road6_6 = new Compartiment(975, 500);
		compartimenteR6[6] = c_road6_6;
		Compartiment c_road6_7 = new Compartiment(1020, 500);
		compartimenteR6[7] = c_road6_7;
		Compartiment c_road6_8 = new Compartiment(1065, 500);
		compartimenteR6[8] = c_road6_8;
		Compartiment c_road6_9 = new Compartiment(1110, 500);
		compartimenteR6[9] = c_road6_9;
		Compartiment c_road6_10 = new Compartiment(1155, 500);
		compartimenteR6[10] = c_road6_10;
		
		Road6.compartimente = compartimenteR6;
		
		//Road 7 - 11 compartiemnte ALBU ADELA
		
	
		
		Compartiment [] compartimenteR7 = new Compartiment[11];
		
		Compartiment c_road7_0 = new Compartiment(705, 550);
		compartimenteR7[0] = c_road7_0;
		Compartiment c_road7_1 = new Compartiment(750, 550);
		compartimenteR7[1] = c_road7_1;
		Compartiment c_road7_2 = new Compartiment(795, 550);
		compartimenteR7[2] = c_road7_2;
		Compartiment c_road7_3 = new Compartiment(840, 550);
		compartimenteR7[3] = c_road7_3;
		Compartiment c_road7_4 = new Compartiment(885, 550);
		compartimenteR7[4] = c_road7_4;
		Compartiment c_road7_5 = new Compartiment(930, 550);
		compartimenteR7[5] = c_road7_5;
		Compartiment c_road7_6 = new Compartiment(975, 550);
		compartimenteR7[6] = c_road7_6;
		Compartiment c_road7_7 = new Compartiment(1020, 550);
		compartimenteR7[7] = c_road7_7;
		Compartiment c_road7_8 = new Compartiment(1065, 550);
		compartimenteR7[8] = c_road7_8;
		Compartiment c_road7_9 = new Compartiment(1110, 550);
		compartimenteR7[9] = c_road7_9;
		Compartiment c_road7_10 = new Compartiment(1155, 550);
		compartimenteR7[10] = c_road7_10;
		
		Road7.compartimente = compartimenteR7;
		
		//Road8 - 6 c BRANESCU SERBAN
		
		Compartiment [] compartimenteR8 = new Compartiment[6];
		
		Compartiment c_road8_0 = new Compartiment(650, 950);
		compartimenteR8[0] = c_road8_0;
		Compartiment c_road8_1 = new Compartiment(650, 900);
		compartimenteR8[1] = c_road8_1;
		Compartiment c_road8_2 = new Compartiment(650, 850);
		compartimenteR8[2] = c_road8_2;
		Compartiment c_road8_3 = new Compartiment(650, 800);
		compartimenteR8[3] = c_road8_3;
		Compartiment c_road8_4 = new Compartiment(650, 755);
		compartimenteR8[4] = c_road8_4;
		Compartiment c_road8_5 = new Compartiment(650, 710);
		compartimenteR8[5] = c_road8_5;
		
		Road8.compartimente = compartimenteR8;
		
		//Road 9 - 8 compartimente ALBU ADELA
		
		//Road9.setCompartimente(8);
		
		Compartiment [] compartimenteR9 = new Compartiment[8];
		
		Compartiment c_road9_0 = new Compartiment (600,645);
		compartimenteR9[0] = c_road9_0;
		Compartiment c_road9_1 = new Compartiment (600,690);
		compartimenteR9[1] = c_road9_1;
		Compartiment c_road9_2 = new Compartiment (600,735);
		compartimenteR9[2] = c_road9_2;
		Compartiment c_road9_3 = new Compartiment (600,780);
		compartimenteR9[3] = c_road9_3;
		Compartiment c_road9_4 = new Compartiment (600,825);
		compartimenteR9[4] = c_road9_4;
		Compartiment c_road9_5 = new Compartiment (600,870);
		compartimenteR9[5] = c_road9_5;
		Compartiment c_road9_6 = new Compartiment (600,915);
		compartimenteR9[6] = c_road9_6;
		Compartiment c_road9_7 = new Compartiment (600,960);
		compartimenteR9[7] = c_road9_7;
		
		Road9.compartimente = compartimenteR9;
		
		//Road 10 - 10 compartimente ALBU ADELA
		
	//	Road10.setCompartimente(10);
		
		Compartiment [] compartimenteR10 = new Compartiment[10];
		
		Compartiment c_road10_0 = new Compartiment(10, 550);
		compartimenteR10[0] = c_road10_0;
		Compartiment c_road10_1 = new Compartiment(60, 550);
		compartimenteR10[1] = c_road10_1;
		Compartiment c_road10_2 = new Compartiment(105, 550);
		compartimenteR10[2] = c_road10_2;
		Compartiment c_road10_3 = new Compartiment(150, 550);
		compartimenteR10[3] = c_road10_3;
		Compartiment c_road10_4 = new Compartiment(200, 550);
		compartimenteR10[4] = c_road10_4;
		Compartiment c_road10_5 = new Compartiment(248, 550);
		compartimenteR10[5] = c_road10_5;
		Compartiment c_road10_6 = new Compartiment(298, 550);
		compartimenteR10[6] = c_road10_6;
		Compartiment c_road10_7 = new Compartiment(345, 550);
		compartimenteR10[7] = c_road10_7;
		Compartiment c_road10_8 = new Compartiment(390, 550);
		compartimenteR10[8] = c_road10_8;
		Compartiment c_road10_9 = new Compartiment(437, 550);
		compartimenteR10[9] = c_road10_9;
		
		Road10.compartimente = compartimenteR10;
		
		
		// Road 11 - 10 compartimente ALBU ADELA
		
		//Road11.setCompartimente(10);
		
		Compartiment [] compartimenteR11 = new Compartiment[10];
		
		Compartiment c_road11_0 = new Compartiment(10, 500);
		compartimenteR11[0] = c_road11_0;
		Compartiment c_road11_1 = new Compartiment(60, 500);
		compartimenteR11[1] = c_road11_1;
		Compartiment c_road11_2 = new Compartiment(105, 500);
		compartimenteR11[2] = c_road11_2;
		Compartiment c_road11_3 = new Compartiment(150, 500);
		compartimenteR11[3] = c_road11_3;
		Compartiment c_road11_4 = new Compartiment(200, 500);
		compartimenteR11[4] = c_road11_4;
		Compartiment c_road11_5 = new Compartiment(248, 500);
		compartimenteR11[5] = c_road11_5;
		Compartiment c_road11_6 = new Compartiment(298, 500);
		compartimenteR11[6] = c_road11_6;
		Compartiment c_road11_7 = new Compartiment(345, 500);
		compartimenteR11[7] = c_road11_7;
		Compartiment c_road11_8 = new Compartiment(390, 500);
		compartimenteR11[8] = c_road11_8;
		Compartiment c_road11_9 = new Compartiment(437, 500);
		compartimenteR11[9] = c_road11_9;

		Road11.compartimente = compartimenteR11;
		
		//Road 12 - 13 c BRADEA OCTAVIA
		
		Compartiment [] compartimenteR12 = new Compartiment[13];
		
		Compartiment c_road12_0 = new Compartiment(555, 450);
		compartimenteR12[0] = c_road12_0;
		Compartiment c_road12_1 = new Compartiment(510,450);
		compartimenteR12[1] = c_road12_1;
		Compartiment c_road12_2 = new Compartiment(465,450);
		compartimenteR12[2] = c_road12_2;
		Compartiment c_road12_3 = new Compartiment(420,450);
		compartimenteR12[3] = c_road12_3;
		Compartiment c_road12_4 = new Compartiment(375,450);
		compartimenteR12[4] = c_road12_4;
		Compartiment c_road12_5 = new Compartiment(330,450);
		compartimenteR12[5] = c_road12_5;
		Compartiment c_road12_6 = new Compartiment(285,450);
		compartimenteR12[6] = c_road12_6;
		Compartiment c_road12_7 = new Compartiment(240,450);
		compartimenteR12[7] = c_road12_7;
		Compartiment c_road12_8 = new Compartiment(195,450);
		compartimenteR12[8] = c_road12_8;
		Compartiment c_road12_9 = new Compartiment(150,450);
		compartimenteR12[9] = c_road12_9;
		Compartiment c_road12_10 = new Compartiment(105,450);
		compartimenteR12[10] = c_road12_10;
		Compartiment c_road12_11 = new Compartiment(60,450);
		compartimenteR12[11] = c_road12_11;
		Compartiment c_road12_12 = new Compartiment(15,400);
		compartimenteR12[12] = c_road12_12;
		
		Road12.compartimente = compartimenteR12;
		
		//Road 13 - 8 c BRANESCU SERBAN
		
		Compartiment [] compartimenteR13 = new Compartiment[8];
		
		Compartiment c_road13_0 = new Compartiment(1250, 40);
		compartimenteR13[0] = c_road13_0;
		Compartiment c_road13_1 = new Compartiment(1250, 85);
		compartimenteR13[1] = c_road13_1;
		Compartiment c_road13_2 = new Compartiment(1250, 130);
		compartimenteR13[2] = c_road13_2;
		Compartiment c_road13_3 = new Compartiment(1250, 175);
		compartimenteR13[3] = c_road13_3;	
		Compartiment c_road13_4 = new Compartiment(1250, 220);
		compartimenteR13[4] = c_road13_4;
		Compartiment c_road13_5 = new Compartiment(1250, 265);
		compartimenteR13[5] = c_road13_5;
		Compartiment c_road13_6 = new Compartiment(1250, 310);
		compartimenteR13[6] = c_road13_6;
		Compartiment c_road13_7 = new Compartiment(1250, 355);
		compartimenteR13[7] = c_road13_7;
		
		Road13.compartimente = compartimenteR13;

		//Road14 - 10 compartimente BRADEA OCTAVIA
		
		Compartiment [] compartimenteR14 = new Compartiment[10];
		
		Compartiment c_road14_0  = new Compartiment(1860, 400);
		compartimenteR14[0] = c_road14_0;
		Compartiment c_road14_1 = new Compartiment(1815,400);
		compartimenteR14[1] = c_road14_1;
		Compartiment c_road14_2 = new Compartiment(1770,400);
		compartimenteR14[2] = c_road14_2;
		Compartiment c_road14_3 = new Compartiment(1725,400);
		compartimenteR14[3] = c_road14_3;
		Compartiment c_road14_4 = new Compartiment(1680,400);
		compartimenteR14[4] = c_road14_4;
		Compartiment c_road14_5 = new Compartiment(1635,400);
		compartimenteR14[5] = c_road14_5;
		Compartiment c_road14_6 = new Compartiment(1590,400);
		compartimenteR14[6] = c_road14_6;
		Compartiment c_road14_7 = new Compartiment(1545,400);
		compartimenteR14[7] = c_road14_7;
		Compartiment c_road14_8 = new Compartiment(1500,400);
		compartimenteR14[8] = c_road14_8;
		Compartiment c_road14_9 = new Compartiment(1455,400);
		compartimenteR14[9] = c_road14_9;
			
		Road14.compartimente = compartimenteR14;
		
		//Road15 -10 c - BRADEA OCTAVIA
		
		Compartiment [] compartimenteR15 = new Compartiment[10];
		
		Compartiment c_road15_0  = new Compartiment(1860, 450);
		compartimenteR15[0] = c_road15_0;
		Compartiment c_road15_1 = new Compartiment(1815,450);
		compartimenteR15[1] = c_road15_1;
		Compartiment c_road15_2 = new Compartiment(1770,450);
		compartimenteR15[2] = c_road15_2;
		Compartiment c_road15_3 = new Compartiment(1725,450);
		compartimenteR15[3] = c_road15_3;
		Compartiment c_road15_4 = new Compartiment(1680,450);
		compartimenteR15[4] = c_road15_4;
		Compartiment c_road15_5 = new Compartiment(1635,450);
		compartimenteR15[5] = c_road15_5;
		Compartiment c_road15_6 = new Compartiment(1590,450);
		compartimenteR15[6] = c_road15_6;
		Compartiment c_road15_7 = new Compartiment(1545,450);
		compartimenteR15[7] = c_road15_7;
		Compartiment c_road15_8 = new Compartiment(1500,450);
		compartimenteR15[8] = c_road15_8;
		Compartiment c_road15_9 = new Compartiment(1455,450);
		compartimenteR15[9] = c_road15_9;
		
		Road15.compartimente = compartimenteR15;
		
		//Road16 - 10 c BRADEA OCTAVIA

		Compartiment [] compartimenteR16 = new Compartiment[13];
		
		Compartiment c_road16_0  = new Compartiment(1345, 500);
		compartimenteR16[0] = c_road16_0;
		Compartiment c_road16_1 = new Compartiment(1390,500);
		compartimenteR16[1] = c_road16_1;
		Compartiment c_road16_2 = new Compartiment(1435,500);
		compartimenteR16[2] = c_road16_2;
		Compartiment c_road16_3 = new Compartiment(1480,500);
		compartimenteR16[3] = c_road16_3;
		Compartiment c_road16_4 = new Compartiment(1525,500);
		compartimenteR16[4] = c_road16_4;
		Compartiment c_road16_5 = new Compartiment(1570,500);
		compartimenteR16[5] = c_road16_5;
		Compartiment c_road16_6 = new Compartiment(1615,500);
		compartimenteR16[6] = c_road16_6;
		Compartiment c_road16_7 = new Compartiment(1660,500);
		compartimenteR16[7] = c_road16_7;
		Compartiment c_road16_8 = new Compartiment(1705,500);
		compartimenteR16[8] = c_road16_8;
		Compartiment c_road16_9 = new Compartiment(1750,500);
		compartimenteR16[9] = c_road16_9;
		Compartiment c_road16_10 = new Compartiment(1795,500);
		compartimenteR16[10] = c_road16_10;
		Compartiment c_road16_11 = new Compartiment(1840,500);
		compartimenteR16[11] = c_road16_11;
		Compartiment c_road16_12 = new Compartiment(1885,500);
		compartimenteR16[12] = c_road16_12;
		
		Road16.compartimente = compartimenteR16;
		
		//Road 17 - 13 c BRADEA OCTAVIA

		Compartiment [] compartimenteR17 = new Compartiment[13];
		
		Compartiment c_road17_0  = new Compartiment(1345, 550);
		compartimenteR17[0] = c_road17_0;
		Compartiment c_road17_1 = new Compartiment(1390,550);
		compartimenteR17[1] = c_road17_1;
		Compartiment c_road17_2 = new Compartiment(1435,550);
		compartimenteR17[2] = c_road17_2;
		Compartiment c_road17_3 = new Compartiment(1480,550);
		compartimenteR17[3] = c_road17_3;
		Compartiment c_road17_4 = new Compartiment(1525,550);
		compartimenteR17[4] = c_road17_4;
		Compartiment c_road17_5 = new Compartiment(1570,550);
		compartimenteR17[5] = c_road17_5;
		Compartiment c_road17_6 = new Compartiment(1615,550);
		compartimenteR17[6] = c_road17_6;
		Compartiment c_road17_7 = new Compartiment(1660,550);
		compartimenteR17[7] = c_road17_7;
		Compartiment c_road17_8 = new Compartiment(1705,550);
		compartimenteR17[8] = c_road17_8;
		Compartiment c_road17_9 = new Compartiment(1750,550);
		compartimenteR17[9] = c_road17_9;
		Compartiment c_road17_10 = new Compartiment(1795,550);
		compartimenteR17[10] = c_road17_10;
		Compartiment c_road17_11 = new Compartiment(1840,550);
		compartimenteR17[11] = c_road17_11;
		Compartiment c_road17_12 = new Compartiment(1885,550);
		compartimenteR17[12] = c_road17_12;
		
		Road17.compartimente = compartimenteR17;
		
		//Road 18 - 6 c BRANESCU SERBAN
		
		Compartiment [] compartimenteR18 = new Compartiment[6];
		
		Compartiment c_road18_0 = new Compartiment(1250, 950);
		compartimenteR18[0] = c_road18_0;
		Compartiment c_road18_1 = new Compartiment(1250, 900);
		compartimenteR18[1] = c_road18_1;
		Compartiment c_road18_2 = new Compartiment(1250, 850);
		compartimenteR18[2] = c_road18_2;
		Compartiment c_road18_3 = new Compartiment(1250, 800);
		compartimenteR18[3] = c_road18_3;
		Compartiment c_road18_4 = new Compartiment(1250, 755);
		compartimenteR18[4] = c_road18_4;
		Compartiment c_road18_5 = new Compartiment(1250, 710);
		compartimenteR18[5] = c_road18_5;
		
		Road18.compartimente = compartimenteR18;
		
		//Road 19 - 8 c BRANESCU SERBAN

		Compartiment [] compartimenteR19 = new Compartiment[7];
		
		Compartiment c_road19_0 = new Compartiment(1200, 600);
		compartimenteR19[0] = c_road19_0;
		Compartiment c_road19_1 = new Compartiment(1200, 650);
		compartimenteR19[1] = c_road19_1;
		Compartiment c_road19_2 = new Compartiment(1200, 750);
		compartimenteR19[2] = c_road19_2;
		Compartiment c_road19_3 = new Compartiment(1200, 800);
		compartimenteR19[3] = c_road19_3;	
		Compartiment c_road19_4 = new Compartiment(1200, 850);
		compartimenteR19[4] = c_road19_4;
		Compartiment c_road19_5 = new Compartiment(1200, 900);
		compartimenteR19[5] = c_road19_5;
		Compartiment c_road19_6 = new Compartiment(1200, 950);
		compartimenteR19[6] = c_road19_6;
		
		
		
		Road19.compartimente = compartimenteR19;
		
		
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
		
		
		
		
		//BAR IOAN
		for(int j=0; j<roads.size(); j++) {
			
			for(int i=0; i<roads.get(j).compartimente.length; i++) {
				roads.get(j).compartimente[i].setEmpty(true);
		
			}
		}
			
		
		

		
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
		
		
		g.setColor(semaphore1.color);
		g.fillOval(semaphore1.cordX, semaphore1.cordY, 50, 50);
		g.fillOval(semaphore2.cordX, semaphore2.cordY, 50, 50);
		g.fillOval(semaphore3.cordX, semaphore3.cordY, 50, 50);
		g.fillOval(semaphore4.cordX, semaphore4.cordY, 50, 50);
		g.fillOval(semaphore6.cordX, semaphore6.cordY, 50, 50);
		g.fillOval(semaphore7.cordX, semaphore7.cordY, 50, 50);
		g.fillOval(semaphore8.cordX, semaphore8.cordY, 50, 50);
		
		
		
		for(Road r: roads) {
			for(int i=0; i<r.compartimente.length; i++) {
				if(r.compartimente[i].isEmpty == false) {
					g.setColor(r.compartimente[i].car.color);
					g.fillRect(r.compartimente[i].car.x, r.compartimente[i].car.y, r.compartimente[i].car.width, r.compartimente[i].car.height);
				}
			}
		}
			
				
			
		
		
		
		
/*
		for(Road r: roads) {
			
			for(int i=0; i<r.listOFcars.size(); i++) {
				g.setColor(r.listOFcars.get(i).color);
				g.fillRect(r.listOFcars.get(i).x, r.listOFcars.get(i).y, r.listOFcars.get(i).width, r.listOFcars.get(i).height);
				
			}
			
		}
		*/
		/*
		for(int j=0; j<roads.size(); j++) {
			
			//ORIENTATION WEST
				
				if(roads.get(j).orientation == Orientation.E_West && roads.get(j).areLiniePietoni == true) {
					
					for(int i=0; i<roads.get(j).listOFcars.size(); i++) {
						if(roads.get(j).listOFcars.get(i).x >= roads.get(j).coordonataLiniePietoni+14) {
							
							roads.get(j).listOFcars.get(i).x -= 10;
						}
						
						if(roads.get(j).listOFcars.get(i).x == roads.get(j).outputPort.cordX) {
							int randomDirection = random.nextInt(roads.get(j).directionList.length-1);
							
						}
					}	
					
				}
				
					if(roads.get(j).orientation == Orientation.E_West && roads.get(j).areLiniePietoni == false) {
					
					for(int i=0; i<roads.get(j).listOFcars.size(); i++) {
						if(roads.get(j).listOFcars.get(i).x >= roads.get(j).outputPort.cordX+14) {
							
							roads.get(j).listOFcars.get(i).x -= 10;
						}
						
						if(roads.get(j).listOFcars.get(i).x == roads.get(j).outputPort.cordX) {
							int randomDirection = random.nextInt(roads.get(j).directionList.length-1);
							
						}
					}
					}
					
					
				//ORIENTATION NORTH
				if(roads.get(j).orientation == Orientation.E_North && roads.get(j).areLiniePietoni ==true) {
					for(int i=0; i<roads.get(j).listOFcars.size(); i++) {
						if(roads.get(j).listOFcars.get(i).y >= roads.get(j).coordonataLiniePietoni+14) {
							
							roads.get(j).listOFcars.get(i).y -= 10;
							
						}	
					}
				}
				
				if(roads.get(j).orientation == Orientation.E_North && roads.get(j).areLiniePietoni == false) {
					for(int i=0; i<roads.get(j).listOFcars.size(); i++) {
						if(roads.get(j).listOFcars.get(i).y >= roads.get(j).outputPort.cordY+14) {
							
							roads.get(j).listOFcars.get(i).y -= 10;
							
						}	
					}
				}
				
				
				//ORIENTATION EAST
				if(roads.get(j).orientation == Orientation.E_East && roads.get(j).areLiniePietoni == false) {

					for(int i=0; i<roads.get(j).listOFcars.size(); i++) {
						if(roads.get(j).listOFcars.get(i).x < roads.get(j).outputPort.cordX-54) {
							
							roads.get(j).listOFcars.get(i).x += 10;
							
						}
						if(roads.get(j).listOFcars.get(i).x == roads.get(j).outputPort.cordX-54) {
							int randomDirection = random.nextInt(roads.get(j).directionList.length-1);
							if(roads.get(j).directionList[randomDirection] == Direction.E_Forward) {
								
							}
						}
					}
				}
				
				if(roads.get(j).orientation == Orientation.E_East && roads.get(j).areLiniePietoni == true) {

					for(int i=0; i<roads.get(j).listOFcars.size(); i++) {
						if(roads.get(j).listOFcars.get(i).x < roads.get(j).coordonataLiniePietoni-54) {
							
							roads.get(j).listOFcars.get(i).x += 10;
							
						}
						if(roads.get(j).listOFcars.get(i).x == roads.get(j).outputPort.cordX-50) {
							int randomDirection = random.nextInt(roads.get(j).directionList.length-1);
							if(roads.get(j).directionList[randomDirection] == Direction.E_Forward) {
								
							}
						}
					}
				}
				
				//ORIENTATION SOUTH
				if(roads.get(j).orientation == Orientation.E_South && roads.get(j).areLiniePietoni == true) {
					for(int i=0; i<roads.get(j).listOFcars.size(); i++) {
						if(roads.get(j).listOFcars.get(i).y < roads.get(j).coordonataLiniePietoni-54) {
							
							roads.get(j).listOFcars.get(i).y += 10;
							
						}	
					}
				}
				if(roads.get(j).orientation == Orientation.E_South && roads.get(j).areLiniePietoni == false) {
					for(int i=0; i<roads.get(j).listOFcars.size(); i++) {
						if(roads.get(j).listOFcars.get(i).y < roads.get(j).outputPort.cordY-50) {
							
							roads.get(j).listOFcars.get(i).y += 10;
							
						}	
					}
				}
				
			} */
			
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
				
				if(i==0 && roads.get(j).compartimente[i].isEmpty == true) {
					if(j==1 || j==7 || j==9 || j==10 || j==13 || j==14 || j==17) {
						boolean randomB = random.nextBoolean();
						if(randomB == true) {
							int nrRandomCulori = random.nextInt(7);
							roads.get(j).compartimente[i].car = new Car(roads.get(j).compartimente[i].x, roads.get(j).compartimente[i].y, carColors.get(nrRandomCulori),40,40);
							roads.get(j).compartimente[i].isEmpty = false;
						}						
					}
				}
				
				if(roads.get(j).compartimente[roads.get(j).compartimente.length-1].isEmpty == false && j==9 && roads.get(j-1).compartimente[0].isEmpty == true) {
					
						int nrRandomCulori = random.nextInt(7);
						roads.get(j-1).compartimente[0].car.color = roads.get(j).compartimente[i].car.color;
						roads.get(j-1).compartimente[0].car.width = roads.get(j).compartimente[i].car.width;
						roads.get(j-1).compartimente[0].car.height = roads.get(j).compartimente[i].car.height;
						roads.get(j-1).compartimente[0].car.x = roads.get(j-1).compartimente[0].x;
						roads.get(j-1).compartimente[0].car.y = roads.get(j-1).compartimente[0].y;
						roads.get(j).compartimente[i].isEmpty = true;
						roads.get(j-1).compartimente[0].isEmpty = false;
					
				}
			}
		}
				
		repaint();
		
	}
}
