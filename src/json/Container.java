package json;

import java.util.ArrayList;
import java.util.List;

public class Container {

	/** Collection - container */
	private List<ListFiles> container;

	/**
	 * Make new object Container
	 * */
	public Container() {

		this.container = new ArrayList<>();

	}

	/**
	 * Make new object Container
	 * @param container ArrayList collection what contains objects ListFiles
	 * */
	public Container(List<ListFiles> container) {

		this.container = container;

	}

	/**
	 * This method add element in ArrayList collection
	 * @param list_file ArrayList collection
	 * @return boolean value
	 * */
	public boolean addElement(ListFiles list_file) {

		return this.container.add(list_file);

	}

	/**
	 * This method remove element from ArrayList collection
	 * @param list_file ArrayList collection
	 * @return boolean value
	 * */
	public boolean removeElement(ListFiles list_file) {

		return this.container.remove(list_file);

	}

	/**
	 * This method return value of the ArrayList collection
	 * @return ArrayList collection
	 * */
	public List<ListFiles> getContainer() {

		return this.container;

	}

	/**
	 * This method set value of the ArrayList collection
	 * @param container ArrayList collection
	 * */
	public void setContainer(List<ListFiles> container) {

		this.container = container;

	}

}
