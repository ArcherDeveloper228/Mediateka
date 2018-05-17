package json;

/**
 * This class contains information about file name and byte array
 * @author Nikita.Ustyushenko
 * @version 1.0
 * */
public class ListFiles {

	/** Property - file_name */
	private String file_name;

	/** Array - byte_array */
	private byte[] byte_array;

	/**
	 * Make new object ListFiles
	 * */
	public ListFiles() {

		this.file_name = null;
		this.byte_array = null;

	}

	/**
	 * Make new object ListFiles
	 * @param file_name value of the object String
	 * what contains information about file name
	 * @param byte_array value of the array
	 * */
	public ListFiles(String file_name, byte[] byte_array) {

		this.file_name = file_name;
		this.byte_array = byte_array;

	}

	/**
	 * This method return value of the object String
	 * what contains information about file name
	 * @return value of the object String
	 * */
	public String getFileName() {

		return this.file_name;

	}

	/**
	 * This method set value of the object String
	 * what contains information about file name
	 * @param file_name value of the object String
	 * what contains information about file name
	 * */
	public void setFileName(String file_name) {

		this.file_name = file_name;

	}

	/**
	 * This method return value of the byte array
	 * @return value of the byte array
	 * */
	public byte[] getByteArray() {

		return this.byte_array;

	}

	/**
	 * This method set value of the byte array
	 * @param byte_array value of the byte array
	 * */
	public void setByteArray(byte[] byte_array) {

		this.byte_array = byte_array;

	}

}
