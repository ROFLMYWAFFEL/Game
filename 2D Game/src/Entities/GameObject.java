package Entities;

import java.awt.Graphics;

import SourceFiles.Engine;

public class GameObject
{
	protected int x, y, drawX, drawY;
	protected double velX, velY;
	
	public GameObject(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public GameObject(GameObject e)
	{
		
	}
	
	public void tick() {
		
		x += Math.round(velX);
		y += Math.round(velY);
		
	}
	
	public void render(Graphics g) {
		//only gets the drawX and drawY for offsetting each individual object
		drawX = (x - Engine.cam.getX() + Engine.WIDTH - 8);
		drawY = (y - Engine.cam.getY() + Engine.HEIGHT - 8);		
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public double getVelX() {
		return velX;
	}
	public double getVelY() {
		return velY;
	}
	
	
}
