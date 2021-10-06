package com.emilie.udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws IOException {
		// receive client data
		
		//1. create DatagramSocket, port
		DatagramSocket socket= new DatagramSocket(8800);
		
		//2. Create data variable for receiving data.
		byte[] data = new byte[1024]; 
		DatagramPacket packet = new DatagramPacket(data, data.length);
		
		//3. Receiving data
		System.out.println("Server started, waiting for client data");
		socket.receive(packet);
		
		//4.read data
		String info = new String(data, 0, packet.getLength());
		System.out.println("Server side, message from client: "+info);
		
		// response to client
		
		//1. client address, port, data
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		byte[] data2 = "Welcome".getBytes();
		
		//2. Create datagram
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
		
		//3. respond to client
		socket.send(packet2);
		
		//4. close
		socket.close();
	}

}
