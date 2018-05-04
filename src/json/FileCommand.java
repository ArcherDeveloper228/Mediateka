package json;

import java.io.File;

/**
 * This class contains information about object File and command
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class FileCommand {

	/** Property - command */ 
	private String command;
	
	/** Property - file */
	private File file;
	
	/**
	 * Make new object FileCommand
	 * */ 
	public FileCommand() {
		
		this.command = null;
		this.file = null;
		
	}
	
	/**
	 * Make new object FileCommand
	 * @param file value of the object File
	 * @param command value of the object String what contains information about command
	 * */
	public FileCommand(File file, String command) {
		
		this.file = file;
		this.command = command;
		
	}
	
	/**
	 * This method get value of the object String 
	 * what contains information about command
	 * @return value of the object String what contains information about command
	 * */
	public String getCommand() {
		
		return this.command;
		
	}
	
	/**
	 * This method set value of the object String 
	 * what contains information about command
	 * @param command value of the object String
	 * */
	public void setCommand(String command) {
		
		this.command = command;
		
	}
	
	/**
	 * This method get value of the object File
	 * @return value of the object File
	 * */
	public File getFile() {
		
		return this.file;
		
	}
	
	/**
	 * This method set value of the object File
	 * @param file value of the object File
	 * */
	public void setFile(File file) {
		
		this.file = file;
		
	} 
	
}
