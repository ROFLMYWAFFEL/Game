package SourceFiles;

import java.awt.Graphics;

import Entities.GameObject;

public class Camera extends GameObject{
	
	public GameObject trackedObject;
	
	public Camera(int x, int y) {
		super(x, y);
	}
	
	public Camera(GameObject e)
	{
		super(e);
		trackedObject = e;
	}

	public void tick()
	{
		x = trackedObject.getX();
		y = trackedObject.getY();
	}
	
	public void render(Graphics g)
	{
		//intentionally blank
	}
}
