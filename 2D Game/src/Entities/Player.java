package Entities;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject
{

	public boolean goingUp = false, goingDown = false, goingLeft = false,
			goingRight = false;

	public Player(int x, int y)
	{
		super(x, y);
	}

	public void tick()
	{
		if(goingUp)
			   velY = -4;
			  if(goingDown)
			   velY = 4;
			  if(goingLeft)
			   velX = -4;
			  if(goingRight)
			   velX = 4;
			  
			  if(goingUp && goingDown)
			   velY = 0;
			  if(goingLeft && goingRight)
			   velX = 0;
			  if(!goingUp && !goingDown)
			   velY = 0;
			  if(!goingLeft && !goingRight)
			   velX = 0;
			  
			  super.tick();
	}

	public void render(Graphics g)
	{
		super.render(g);
		g.setColor(Color.black);
		g.fillRect(drawX - 1, drawY - 1, 16, 16);
		g.setColor(Color.red);
		g.fillRect(drawX, drawY, 15, 15);
		System.out.println(drawX + " " + drawY);
	}

	public void setGoingUp(boolean goingUp)
	{
		this.goingUp = goingUp;
	}

	public void setGoingDown(boolean goingDown)
	{
		this.goingDown = goingDown;
	}

	public void setGoingLeft(boolean goingLeft)
	{
		this.goingLeft = goingLeft;
	}

	public void setGoingRight(boolean goingRight)
	{
		this.goingRight = goingRight;
	}

}
