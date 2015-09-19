package model;

public class User {

	private int id;
	private String firstname;
	private String lastname;
	private String country;
	private String state;
	private String address;
	private String email;
	private String gender;
	
	public int getId() {
		return id;
	}

	public String getfirstname() {
		return firstname;
	}

	public String getlastname() {
		return lastname;
	}

	public String getcountry() {
		return country;
	}
	 
	public String getstate() {
		return state;
	}

	public String getaddress() {
		return address;
	}

	public  String getemail() {
		return email;
	}
	
	public String getgender(String gender) {
		return gender;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}

	public void setfirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setlastname(String lastname) {
		this.lastname = lastname;
	}

	public void setcountry(String country) {
		this.country = country;
	}
	
	public void setstate(String state) {
		this.state = state;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public void setgender(String gender) {
		this.gender = gender;
	}
 }
