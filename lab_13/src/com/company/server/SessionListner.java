package com.company.server;

import java.io.*;
import java.net.Socket;

public class SessionListner extends Thread{

	private Socket socket;
	private BufferedReader in;
	private BufferedWriter out;

	public SessionListner(Socket socket) throws IOException {
		this.socket = socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		start();
	}

	@Override
	public void run() {

		String word;
		try {

			while (true){
				word = in.readLine();

				System.out.println("server: "+word);

				if(word.equals("stop")){
					break;
				}
				for(SessionListner listner: Server.serverList){
					listner.send(word);
				}
			}
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}

	public void send(String msg){
		try{
			out.write(msg+"\n");
			out.flush();
		} catch (IOException exception) {
			exception.printStackTrace();
		}
	}
}
