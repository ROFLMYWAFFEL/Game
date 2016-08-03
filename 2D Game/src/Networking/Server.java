package Networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Server extends Thread implements Runnable
{
	private DatagramSocket socket;
	
	public Server()
	{
		try{
			this.socket = new DatagramSocket(19955);
		} catch (SocketException e)
		{
			e.printStackTrace();
		} 
		run();
	}
	
	public void run()
	{
		while(true)
		{
			byte[] data = new byte[1024];
			DatagramPacket packet = new DatagramPacket(data, data.length);
			try
			{
				socket.receive(packet);
			} catch (IOException e) 
			{
				e.printStackTrace();
			}
			String message = new String(packet.getData());
			if(message.equalsIgnoreCase("ping"));
			JOptionPane.showMessageDialog(null, ("CLIENT >> " + new String(packet.getData())));
			sendData("pong".getBytes(), packet.getAddress(), packet.getPort());
		}
	}
	
	
	public void sendData(byte[] data, InetAddress ipAddress, int port)
	{
		DatagramPacket packet = new DatagramPacket(data, data.length, ipAddress, port);
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		new Server();
		
	}
}
