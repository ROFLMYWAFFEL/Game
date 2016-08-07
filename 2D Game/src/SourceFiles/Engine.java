package SourceFiles;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

import Entities.BasicNPC;
import Entities.GameObject;
import Entities.Player;

public class Engine extends Canvas implements Runnable
{
	private static final long serialVersionUID = 1L;
	private boolean running;
	static JFrame frame;
	public static final String TITLE = "MPGame";
	Timer timer = new Timer(16, new TimerEventListener());

	String outputFrames = "";
	int frames = 0;
	private Thread thread;
	static Engine game;

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public static final int HEIGHT = screenSize.height;
	public static final int WIDTH = screenSize.width;

	public static ArrayList<GameObject> Entities = new ArrayList<GameObject>();
	
	public static Player p;
	public static Camera cam;
	
	static KeyInput kPut = new KeyInput();

	public static void StartRun()
	{
		game = new Engine();
		game.setSize(new Dimension(WIDTH, HEIGHT));
		frame = new JFrame(TITLE);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setAutoRequestFocus(true);
		game.setFocusable(true);
		frame.setVisible(true);
		game.addKeyListener(kPut);
		game.start();
	}

	public void init()
	{
		timer.start();
		p = new Player((WIDTH / 2) - 8, (HEIGHT / 2) - 8);
		cam = new Camera(p);
		Entities.add(new BasicNPC(0,0));
		Entities.add(p);
		Entities.add(cam);
	}

	public void tick()
	{
		@SuppressWarnings("unchecked")
		ArrayList<GameObject> TempEntities = (ArrayList<GameObject>) Entities.clone();
		for(GameObject e : TempEntities) 
		{
			e.tick();
		}
	}

	public void render()
	{

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null)
		{
			createBufferStrategy(4);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(new Color(0, 88, 14));
		g.fillRect(0, 0, WIDTH, HEIGHT);

		@SuppressWarnings("unchecked")
		ArrayList<GameObject> TempEntities = (ArrayList<GameObject>) Entities
				.clone();

		for (GameObject e : TempEntities)
		{
			e.updateDrawAxis();
			if(e.getDrawX() < WIDTH && e.getDrawX() > 0 && e.getDrawY() > 0 && e.getDrawY() < HEIGHT)
			e.render(g);
		}

		g.drawString(outputFrames, 10, 10);

		g.dispose();
		bs.show();
	}

	private synchronized void start()
	{
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();

		/*
		 * if(JOptionPane.showConfirmDialog(this,
		 * "Do you want to run the server") == 0) { socketServer = new Server();
		 * socketServer.start(); }
		 */
	}

	private synchronized void stop()
	{
		if (!running)
			return;
		running = false;
		try
		{
			thread.join();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.exit(1);
	}

	public void run()
	{
		init();
		long lastTime = System.nanoTime();
		final double amountOfFrames = 999.0;
		double ns = 1000000000 / amountOfFrames;
		double delta = 0;
		long timer = System.currentTimeMillis();
		while (running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			boolean shouldRender = false;
			if (delta >= 1)
			{
				delta--;
				shouldRender = true;
			}
			try
			{
				Thread.sleep(2);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			if (shouldRender)
			{
				render();
				frames++;
			}
			if (System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				outputFrames = Integer.toString(frames);
				frames = 0;
			}
		}
		stop();
	}

	private class TimerEventListener implements ActionListener
	{
		public void actionPerformed(ActionEvent arg0)
		{
			tick();
		}

	}
}
