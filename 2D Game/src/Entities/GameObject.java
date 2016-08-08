package Entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import SourceFiles.Engine;

public class GameObject
{
	protected int drawX = 0, drawY = 0, hp, maxHp = 1;
	
	protected double x, y, velX, velY, speed;
	
	public GameObject(double x, double y) {
		this.x = x;
		this.y = y;
		hp = maxHp;
		drawX = Engine.WIDTH/2;
		drawY = Engine.HEIGHT/2;
	}
	public GameObject(GameObject e)
	{
		hp = maxHp;
	}
	
	public void tick() {
//		targetX = (int)Engine.player.getX();
//		targetY = (int)Engine.player.getY();
//		this.id = ID.enemy;
//		double diffX = (x - targetX);
//		double diffY = (y - targetY);
//		double distance = Math.sqrt(Math.pow(x - targetX, 2) + (Math.pow(y - targetY, 2)));
//		
//		velX = ((-speed / distance ) * diffX);
//		velY = ((-speed / distance) * diffY);
		x += velX;
		y += velY;
		
	}
	
	public void render(Graphics g)
	{		
		g.setColor(Color.RED);
		g.fillRect(drawX - 40, drawY - 40,100, 10);
		g.setColor(Color.GREEN);
		g.fillRect(drawX-40, drawY - 40, (hp/maxHp)*100, 10);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		g.drawString(hp + "/" + maxHp, drawX - 8, drawY - 50);
	}
	public void updateDrawAxis()
	{
		drawX = (int)(this.x - Engine.cam.getX() + (Engine.WIDTH/2));
		drawY = (int)(this.y - Engine.cam.getY() + (Engine.HEIGHT/2));
	}
	public double getX() {
		return x; 
	}
	public double getY() {
		return y;
	}
	public int getDrawX() {
		return drawX;
	}
	public int getDrawY() {
		return drawY;
	}
	public double getVelX() {
		return velX;
	}
	public double getVelY() {
		return velY;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getMaxHp() {
		return maxHp;
	}
	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}
	
	
}
