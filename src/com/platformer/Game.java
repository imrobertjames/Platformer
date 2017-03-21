package com.platformer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.platformer.window.Window;

public class Game extends Canvas implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4306882319349056766L;
	private boolean running = false;
	private Thread thread;
	public static boolean debug = true;
	
	public synchronized void start() {
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	private void tick() {
		
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		/////// START DRAW //////
		g.setColor(Color.black);
		
		g.fillRect(0, 0, getWidth(), getHeight());
		
		///// END DRAW /////
		g.dispose();
		bs.show();
	}
	
	@Override
	public void run() {
		if (debug) 
			System.out.println("Thread has begun.");
		
		/*
		 * Sequence of Events for Game loop
		 * 1. store the current time in nano seconds
		 * 2. specify amount of ticks per second as a double
		 * 3. calculate about of nano seconds per tick by 1000000000 / variable_from_#2
		 * 4. set a double delta variable to 0
		 * 5. set a timer (long) to current time in mili seconds
		 * 6. set to variables for updates and frames (ints)
		 * 7. open a while(running) loop
		 * 		a. set long now variable to current time in nano seconds
		 *		b. set delta += (now - lastTime) / ns
		 *		c. set lastTime to now
		 *		d. while/if delta >= 1 then tick(), ++ the update variable, and delta--
		 *		e. run render() and frames++
		 *		f. if current time in millis - timer > 1000
		 *			1) add 1000 to timer
		 *			2) print out your fps and updates variables
		 *			3. set them back to 0
		 */
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int updates = 0;
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000 && debug) {
				timer += 1000;
				System.out.println("Frames: " + frames + " | Updates: " + updates);
				frames = 0;
				updates = 0;
			}
		}
		//end game loop
	}
	
	public static void main(String args[]) {
		new Window(800, 600, "Platformer", new Game());
	}

}
