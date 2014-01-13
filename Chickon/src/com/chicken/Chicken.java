package com.chicken;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;

/**
 * The main game class
 * @author Joel Gabriel
 *
 */

public class Chicken extends JFrame implements Runnable {
	
	private boolean running = false;
	
	private Image dbImage = null;
	private Graphics dbgx;
	private Graphics2D dbg;
	
	/**
	 * The Constructor
	 */
	public Chicken() {
		super("Chicken");
		setSize(640, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocation(200, 200);
		
		(new Thread(this)).start();
		
		setVisible(true);
	}
	
	public void update(Graphics g) {
		paint(g);
	}
	
	public void paint(Graphics g) {
		if(dbImage == null) {
			dbImage = createImage(640, 480);
			dbgx = dbImage.getGraphics();
			dbg = (Graphics2D) dbgx;
		}
		
		dbg.setColor(Color.WHITE);
		dbg.fillRect(0, 0, 640, 480);
		
		dbg.setColor(Color.RED);
		dbg.fillRect(58, 48, 48, 54);
		
		g.drawImage(dbImage, 0, 0, null);
	}
	
	/**
	 * The Main method 
	 */
	public static void main(String[] args) {
		new Chicken();
	}
	
	/**
	 * The run method - called upon a new Thread startup
	 */
	public void run() {
		running = true;
	
		while(running) {
			process();
			repaint();
			
			try{
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void process() {
		
	}
}
