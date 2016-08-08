package Entities;

import java.awt.Color;
import java.awt.Graphics;

import SourceFiles.Engine;

public class BasicNPC extends GameObject
{

	public BasicNPC(int x, int y)
	{
		super(x, y);
		speed = .5;
	}
	
	public void tick()
	{
		int targetX = Engine.p.getX();
		int targetY = Engine.p.getY();
		double diffX = (x - targetX);
		double diffY = (y - targetY);
		double distance = Math.sqrt(Math.pow(x - targetX, 2) + (Math.pow(y - targetY, 2)));
		
		velX = ((-speed / distance ) * diffX);
		velY = ((-speed / distance) * diffY);
		super.tick();
	}
	public void render(Graphics g)
	{
		super.render(g);
		
		g.setColor(new Color(255,255,190));
		g.fillRect(drawX, drawY, 20, 20);
	}
	
}
