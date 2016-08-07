package Entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import SourceFiles.Engine;

public class GameObject
{
	protected int x, y, drawX = 0, drawY = 0, hp, maxHp = 1;
	
	protected double velX, velY, speed;
	
	public GameObject(int x, int y) {
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
		x += Math.round(velX);
		y += Math.round(velY);
		
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
		drawX = (this.x - Engine.cam.getX() + (Engine.WIDTH/2));
		drawY = (this.y - Engine.cam.getY() + (Engine.HEIGHT/2));
	}
	public int getX() {
		return x; 
	}
	public int getY() {
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
