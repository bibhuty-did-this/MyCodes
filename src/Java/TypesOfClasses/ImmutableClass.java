package Java.TypesOfClasses;

import java.util.Date;

// 1. Make java class final
public final class ImmutableClass{
	// 2. Make instance variables are final
	private final Integer id;
	private final String name;


	// 4. Problem occurs when the variable class is mutable
	private final Date date;

	public ImmutableClass(Integer id,String name, Date date){
		this.id=id;
		this.name=name;


		// Don't do this as date class is mutable and performing this
		// step can change its value through a setter method
		// this.date=date;

		// Always create a new instance
		this.date=new Date(date.getTime());
	}

	// 3. No setter method for instance variables


	public int getId(){
		return id;
	}

	public String getName(){
		return name;
	}

	public Date getDate(){

		// Don't do it as the caller will get direct access to it
		// return date;


		// It'll give a new instance
		return new Date(date.getTime());
	}
}
