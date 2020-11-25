package com.company.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

public class ChatAppController implements Initializable {

	@FXML
	public Button sendButton;
	@FXML
	private TextArea dialogField;

	private Socket socket;
	private BufferedReader in;
	private BufferedWriter out;
	private String ip ="localhost";
	private int port= 8080;
	private String nickname;
	private Date time;
	private String dtime;
	private SimpleDateFormat dt1;

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	@FXML
	private Button nickButton;

	@FXML
	private TextField message;

	@FXML
	private TextField nicknameField;

	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		System.out.println("Initialize of Controller");

		try {
			this.socket = new Socket(ip,port);
		}catch (IOException exception){
			System.out.println("Socket Error");
		}
		try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

			// TODO заполнить данные о имени (method) @nickname

			new ReadMsg().start();
			//new WriteMsg().start();

		} catch (IOException exception) {
			this.socketShutdown();
		}

	}

	public void commit(ActionEvent actionEvent) {
		setNickname(nicknameField.getText());
		nickButton.setDisable(true);
		nicknameField.setDisable(true);
		System.out.println(getNickname());
	}

	private void socketShutdown() {
		try {
			if (!socket.isClosed()) {
				socket.close();
				in.close();
				out.close();
			}
		} catch (IOException ignored) {}
	}

	private void downService() {
		try {
			if (!socket.isClosed()) {
				socket.close();
				in.close();
				out.close();
			}
		} catch (IOException ignored) {}
	}

	public void send(ActionEvent actionEvent) {

		System.out.println("sending...");

		String msg;
				try {
					time = new Date();
					dt1 = new SimpleDateFormat("HH:mm:ss");
					dtime = dt1.format(time);
					msg = message.getText();

					System.out.println("in textfield was: "+msg);

					if (msg.equals("stop")) {
						out.write("stop" + "\n");
						downService(); // харакири
					} else {

						System.out.println("(" + dtime + ") " + nickname + ": " + msg + "\n");

						out.write("(" + dtime + ") " + nickname + ": " + msg + "\n"); // отправляем на сервер
						message.clear();
					}
					out.flush(); // чистим
				} catch (IOException e) {
					downService(); // в случае исключения тоже харакири
				}
	}

	private class ReadMsg extends Thread {

		@Override
		public void run() {

			String msg;
			try {
				while (true) {
					msg = in.readLine(); // ждем сообщения с сервера
					if (msg.equals("stop")) {
						downService(); // харакири
						break; // выходим из цикла если пришло "stop"
					}
					System.out.println("received from server: "+msg);
					dialogField.appendText(msg+"\n"); // пишем сообщение с сервера на консоль
				}
			} catch (IOException e) {
				downService();
			}
		}
	}

}
