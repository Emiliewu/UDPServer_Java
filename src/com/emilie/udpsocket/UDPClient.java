package com.emilie.udpsocket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws IOException {
		//Send data to server
		
		//1. Server address, port, data
		InetAddress address = InetAddress.getByName("localhost");
		int port = 8800;
		byte[] data = "Username: admin; Password: 123456".getBytes();
		
		//2. Create datagram
		DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
		
		//3. create DatagramSocket object
		DatagramSocket socket = new DatagramSocket();
		
		//4. send to server
		socket.send(packet);
		
		//receive server responses
		
		//1. create datagram
		byte[] data2 = new byte[1024];
		DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
		
		//2. Receive server response
		socket.receive(packet2);
		
		//3. read data
		String reply = new String(data2, 0, packet.getLength());
		System.out.println("Client side, server message: " + reply);
		
		//4. close
		socket.close();
		
	}

}
