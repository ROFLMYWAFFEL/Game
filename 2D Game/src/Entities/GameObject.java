package Entities;

import java.awt.Graphics;

public class GameObject
{

	protected int x, y;
	protected double velX, velY;
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick() {
		
		x += Math.round(velX);
		y += Math.round(velY);
		
	}
	
	public void render(Graphics g) {
		
		g.fillRect(x, y, 20, 20);
		
	}
}
