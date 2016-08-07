package SourceFiles;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Entities.Player;

public class KeyInput implements KeyListener
{

 public void keyPressed(KeyEvent arg0) {
  Player temp = Engine.p;
  if(arg0.getKeyCode() == KeyEvent.VK_W)
   temp.setGoingUp(true);
  if(arg0.getKeyCode() == KeyEvent.VK_S)
   temp.setGoingDown(true);
  if(arg0.getKeyCode() == KeyEvent.VK_A)
   temp.setGoingLeft(true);
  if(arg0.getKeyCode() == KeyEvent.VK_D)
   temp.setGoingRight(true);
 }

 public void keyReleased(KeyEvent arg0) {
  
  Player temp = Engine.p;
  if(arg0.getKeyCode() == KeyEvent.VK_W)
   temp.setGoingUp(false);
  if(arg0.getKeyCode() == KeyEvent.VK_S)
   temp.setGoingDown(false);
  if(arg0.getKeyCode() == KeyEvent.VK_A)
   temp.setGoingLeft(false);
  if(arg0.getKeyCode() == KeyEvent.VK_D)
   temp.setGoingRight(false);
  if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
   System.exit(0);
 }

 public void keyTyped(KeyEvent arg0) {
  // Auto-generated method stub
  
 }

}