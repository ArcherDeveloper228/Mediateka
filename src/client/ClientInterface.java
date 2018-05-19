package client;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import javax.imageio.ImageIO;

import com.google.gson.JsonSyntaxException;

import application.User;
import json.Container;
import json.JsonParser;
import json.UserComand;

public class ClientInterface implements ConstClient {

	/** Property - socket */
	private Socket socket;

	/** Property - print_stream */
	private PrintStream print_stream;

	/** Property - buffered_reader */
	private BufferedReader buffered_reader;

	/** Property - json_parser */
	private JsonParser json_parser;

	/**
	 * Make new object ClientInterface
	 * */
	public ClientInterface() {

		this.socket = null;
		this.print_stream = null;
		this.buffered_reader = null;
		this.json_parser = null;

	}

	/**
	 * Make new object ClietnInterface
	 * @param socket value of the object socket
	 * */
	public ClientInterface(Socket socket) {

		try {

			this.socket = socket;
			this.print_stream = new PrintStream(this.socket.getOutputStream());
			this.print_stream.flush();
			this.buffered_reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
			this.json_parser = new JsonParser();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// реализация метода передачи информации серверу
	@Override
	public boolean writeMessage(User user, String server_command) {

		if (this.print_stream == null) return false;
		else {

			this.print_stream.println("User" + "\n" + this.json_parser.makeUserJson(user, server_command));
			this.print_stream.flush();
			return true;

		}

	}

	// реализация метода чтения информации от сервера
	@Override
	public UserComand readMessage() {

		UserComand user_command = null;
		String json = null;

		try {

			if ((json = this.buffered_reader.readLine()) != null)
				user_command = this.json_parser.parseUserJson(json);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return user_command;

	}

	// реализация метода передачи файла серверу
	@Override
	public boolean writeFile(File file, String user_login, String server_command) {

		String file_name = null;
		byte[] byte_array = null;

		if (this.print_stream == null) return false;
		else {

			if (file != null) {

				file_name = file.getName();
				if (server_command.equals("AddImage") || server_command.equals("LoadImage") || server_command.equals("DeleteImage"))
					byte_array = this.getImageBytes(file);
				else byte_array = this.getFileBytes(file);

				this.print_stream.println("File" + "\n" + this.json_parser.makeFileJson(byte_array, file_name, user_login, server_command));
				this.print_stream.flush();

			} else {

				this.print_stream.println("File" + "\n" + this.json_parser.makeFileJson(byte_array, file_name, user_login, server_command));
				this.print_stream.flush();

			}

			return true;

		}

	}

	// реализация метода чтения информации от сервера
	@Override
	public Container readFile() {

		Container files = null;
		String json = null;

		try {

			if ((json = this.buffered_reader.readLine()) != null)
				files = this.json_parser.getGson().fromJson(json, Container.class);

		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return files;

	}

	/**
	 * This method return array image bytes
	 * @param file value of the object File
	 * @return array image bytes
	 * */
	public byte[] getImageBytes(File file) {

		byte[] file_bytes = null;
		String extension = null;

		try {

			extension = this.getFileExtension(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			BufferedImage buffered_image = ImageIO.read(file);

			ImageIO.write(buffered_image, extension, baos);
			file_bytes = baos.toByteArray();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return file_bytes;

	}
	
	/**
	 * This method return array file bytes
	 * @param file value of the object File
	 * @return array file bytes
	 * */
	public byte[] getFileBytes(File file) {
		
		byte[] file_bytes = new byte[(int) file.length()];
		
		try {
			
			FileInputStream file_input_stream = new FileInputStream(file);
			file_input_stream.read(file_bytes);
			file_input_stream.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return file_bytes;
		
	}

	/**
	 * This method return file extension
	 * @param file value of the object File
	 * @return value of the object String
	 * */
	private final String getFileExtension(File file) {

        String fileName = file.getName();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
        return fileName.substring(fileName.lastIndexOf(".")+1);
        // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";

	}

	/**
	 * This method close all threads
	 * */
	public void closeConnection() {

		// если поток чтения не null, то закрываем его
		if (this.buffered_reader != null) {

			try {
				this.buffered_reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		// если поток записи не null, то закрываем его
		if (this.print_stream != null) {

			this.print_stream.flush();
			this.print_stream.close();

		}

	}

	/**
	 * This method return value of the object Socket
	 * @return value of the object Socket
	 * */
	public Socket getSocket() {

		return this.socket;

	}

	/** This method set value of the object Socket
	 * @param socket value of the object Socket
	 * */
	public void setSocket(Socket socket) {

		this.socket = socket;

	}

	/**
	 * This method return value of the object PrintStream
	 * @return value of the object PrintStream
	 * */
	public PrintStream getPrintStream() {

		return this.print_stream;

	}

	/**
	 * This method set value of the object PrintStream
	 * @param print_stream value of the object PrintStream
	 * */
	public void setPrintStream(PrintStream print_stream) {

		this.print_stream = print_stream;

	}

	/**
	 * This method return value of the object BufferedReader
	 * @return value of the object BufferedReader
	 * */
	public BufferedReader getBufferedReader() {

		return this.buffered_reader;

	}

	/**
	 * This method set value of the object BufferedReader
	 * @param buffered_reader value of the object BufferedReader
	 * */
	public void setBufferedReader(BufferedReader buffered_reader) {

		this.buffered_reader = buffered_reader;

	}

	/**
	 * This method return value of the object JsonParser
	 * @return value of the object JsonParser
	 * */
	public JsonParser getJsonParser() {

		return this.json_parser;

	}

	/**
	 * This method set value of the object JsonParser
	 * @param json_parser value of the object JsonParser
	 * */
	public void setJsonParser(JsonParser json_parser) {

		this.json_parser = json_parser;

	}

}
