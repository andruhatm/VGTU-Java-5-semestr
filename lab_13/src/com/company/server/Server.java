package com.company.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class Server {

	public static final int port = 8080;
	public static List<SessionListner> serverList = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(port);

		try{
			while (true){
				System.out.println("Server is now listening...");
				Socket socket = server.accept();
				try{
					serverList.add(new SessionListner(socket));
					System.out.println("added new client");
				}catch (IOException exception){
					socket.close();
				}
			}
		}
		finally {
			server.close();
		}
	}
}
