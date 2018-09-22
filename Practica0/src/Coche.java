
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Coche {
	public double x;
	public double y;
	public double v;
	public double a;
	
	
	public Coche(int x, int y, double v, double a) {
		super();
		this.x = x;
		this.y = y;
		this.v = v;
		this.a = a;
	}


	public double getX() {
		return x;
	}


	public void setX(double x) {
		this.x = x;
	}


	public double getY() {
		return y;
	}


	public void setY(double y) {
		this.y = y;
	}


	public double getV() {
		return v;
	}


	public void setV(double v) {
		this.v = v;
	}


	public double  getA() {
		return a;
	}


	public void setA(double a) {
		this.a = a;
	}
	
	
	}
	
	


