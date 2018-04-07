package application;

/**
 * This class contains information about person
 * @author Nikita.Ustyshenko
 * @version 1.0
 * */
public class Person {

	/** Property - name */
	private String name;
	
	/** Property- surname */
	private String surname;
	
	/** Property - day_of_birth */
	private int day_of_birth;
	
	/** Property - month_of_birth */
	private String month_of_birth;
	
	/** Property - year_of_birth */
	private int year_of_birth;
	
	/** Property - sex */
	private String sex;
	
	/** 
	 * Make new object Person 
	 * */
	public Person() {
		
		this.name = null;
		this.surname = null;
		this.day_of_birth = 0;
		this.month_of_birth = null;
		this.year_of_birth = 0;
		this.sex = null;
		
	}
	
	/** 
	 * Make new object Person 
	 * @param name value contains information about person name 
	 * @param surname value contains information about person surname 
	 * @param day_of_birth value contains information about day of birth person
	 * @param month_of_birth value contains information about month of birth person
	 * @param year_of_birth value contains information about year of birth person 
	 * @param sex value contains information about person sex
	 * */
	public Person(String name, String surname, int day_of_birth, String month_of_birth, int year_of_birth, String sex) {
		
		this.name = name;
		this.surname = surname;
		this.day_of_birth = day_of_birth;
		this.year_of_birth = year_of_birth;
		this.sex = sex;
		
	}
	
	/**
	 * This method returns the value of the person name
	 * @return String value of the person name
	 * */ 
	public String getName() {
		
		return this.name;
		
	}
	
	/** 
	 * This method sets the value of the person name
	 * @param name value of the person name
	 * */
	public void setName(String name) {
		
		this.name = name;
		
	}
	
	/**
	 * This method returns value of the person surname
	 * @return value of the person surname
	 * */
	public String getSurname() {
		
		return this.surname;
		
	}
	
	/**
	 * This method sets value of the person surname
	 * @param surname value of the person surname
	 * */
	public void setSurname(String surname) {
		
		this.surname = surname;
		
	}
	
	/**
	 * This method returns the value of the person day of birth
	 * @return value of the person day of birth
	 * */
	public int getDayOfBirth() {
		
		return this.day_of_birth;
		
	}
	
	/**
	 * This method sets value of the person day of birth
	 * @param day_of_birth value of the person day of birth
	 * */
	public void setDayOfBirth(int day_of_birth) {
		
		this.day_of_birth = day_of_birth;
		
	}
	
	/**
	 * This method returns the value of the person month of birth
	 * @return value of the person month of birth
	 * */
	public String getMonthOfBirth() {
		
		return this.month_of_birth;
		
	}
	
	/**
	 * This method sets value of the person month of birth
	 * @param month_of_birth value of the person month of birth
	 * */
	public void setMonthOfBirth(String month_of_birth) {
		
		this.month_of_birth = month_of_birth;
		
	}
	
	/**
	 * This method returns the value of the person year of birth
	 * @return value of the person year of birth
	 * */
	public int getYearOfBirth() {
		
		return this.year_of_birth;
		
	}
	
	/**
	 * This method sets value of the person year of birth
	 * @param year_of_birth value of the person year of birth
	 * */
	public void setYearOfBirth(int year_of_birth) {
		
		this.year_of_birth = year_of_birth;
		
	}
	
	/**
	 * This method returns the value of the person sex
	 * @return String value of the person sex
	 * */
	public String getSex() {
		
		return this.sex;
		
	}
	
	/**
	 * This method sets value of the person sex
	 * @param sex value of the person sex
	 * */
	public void setSex(String sex) {
		
		this.sex = sex;
		
	}
	
}
