package json;

/**
 * This class contains information about object File and command
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class FileCommand {

	/** Property - user_login */
	private String user_login;

	/** Property - command */
	private String command;

	/** Property - file_name */
	private String file_name;

	/** Array - bytes */
	private byte[] bytes;

	/**
	 * Make new object FileCommand
	 * */
	public FileCommand() {

		this.user_login = null;
		this.command = null;
		this.file_name = null;
		this.bytes = null;

	}

	/**
	 * Make new object FileCommand
	 * @param bytes array
	 * @param file_name value of the object String what contains information about  file name
	 * @param user_login value of the object String what contains information about user login
	 * @param command value of the object String what contains information about command
	 * */
	public FileCommand(byte[] bytes, String file_name, String user_login, String command) {

		this.bytes = bytes;
		this.file_name = file_name;
		this.user_login = user_login;
		this.command = command;

	}

	/**
	 * This method return value of the object String
	 * @return value of the object String
	 * */
	public String getUserLogin() {

		return this.user_login;

	}

	/**
	 * This method set value of the object String
	 * @param user_login value of the object String what contains information about user login
	 * */
	public void setUserLogin(String user_login) {

		this.user_login = user_login;

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
	 * This method return array image bytes
	 * @return byte array
	 * */
	public byte[] getFileBytes() {

		return this.bytes;

	}

	/**
	 * This method set array image bytes
	 * @param bytes array image bytes
	 * */
	public void setFileBytes(byte[] bytes) {

		this.bytes = bytes;

	}

	/**
	 * This method get value of the object String what
	 * contains information about file name
	 * @return String object
	 * */
	public String getFileName() {

		return this.file_name;

	}

	/**
	 * This method set value of the object String
	 * what contains information about file name
	 * @param file_name value of the object String
	 * */
	public void setFileName(String file_name) {

		this.file_name = file_name;

	}

}
