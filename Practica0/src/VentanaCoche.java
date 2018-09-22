

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class VentanaCoche extends JFrame{
	
	public JLabelGraficoAjustado cochej;
	public JButton acelerar;
	public JButton frenar;
	public JButton derecha;
	public JButton izquierda;
	public JPanel arriba;
	public JPanel abajo;
	public Coche coche = new Coche(1,1,0,0);
	
	
	
	public VentanaCoche() {
		Container cp = this.getContentPane();
		cp.setLayout(null);
		
		
		// paneles
		arriba = new JPanel();
		arriba.setBackground(Color.BLACK);
		abajo = new JPanel();
		abajo.setBackground(Color.BLACK);
		
		
		cp.add(arriba, BorderLayout.NORTH);
		arriba.setSize(1200,640);
		arriba.setLocation(0, 0);
		arriba.setLayout(null);
		cp.add(abajo,  BorderLayout.SOUTH);
		abajo.setSize(1200,200);
		abajo.setLocation(0,640);
		abajo.setLayout(new GridLayout());
		
		
		
		//panel abajo
		acelerar = new JButton("acelerar");
		acelerar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				coche.v=coche.v+1;
				
			}
			
		});
		
		frenar = new JButton("frenar");
		frenar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(coche.v>=01) {
					coche.v=coche.v-1;
			}}
			
		});
		derecha= new JButton("girar derecha");
		derecha.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				coche.a=coche.a+Math.toRadians(10);
			}
			
		});
		izquierda= new JButton("girar izquierda");
		izquierda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				coche.a=coche.a-Math.toRadians(10);
			}
			
		});
		
		abajo.add(acelerar);
		abajo.add(frenar);
		abajo.add(derecha);
		abajo.add(izquierda);
		
		//panel arriba
		cochej = new JLabelGraficoAjustado("coche",200,200);
		cochej.setImagen("car2.png");
	
		arriba.add(cochej);
		
//		cochej.setLocation(1,1);
		
		Thread t = new Thread() {
			
			public void run() {
				do {
					
					if(coche.x<=-30||coche.x>=1030) {
						
						coche.a=Math.PI-coche.a;
					}
					if(coche.y<=-30||coche.y>=480){
						coche.a=2*Math.PI-coche.a;
						
					}
				
					
					


			     
					coche.x=(coche.x+((Math.cos(coche.a)*coche.v*0.3)));
					coche.y=(coche.y+((Math.sin(coche.a)*coche.v*0.3)));
					cochej.setRotacion(coche.a);
					cochej.setLocation(coche.x,coche.y);
					

						
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
					}
				
				
				}while(this.isAlive());
			
			}
		
		};
		t.start();
	
		
		
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("coches");
		this.setSize(1200,840);
		this.setResizable(false);
		this.setIconImage(new ImageIcon("car.png").getImage());
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new VentanaCoche();
	}

}
