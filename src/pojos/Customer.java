package pojos;

public class Customer {
	public int cid;
	public String fname,lname,city,state,email,mob;
	public Customer(int cid, String mob, String fname, String lname, String city, String state, String email) {
		super();
		this.cid = cid;
		this.mob = mob;
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.state = state;
		this.email = email;
	}
	public Customer(String mob, String fname, String lname, String city, String state, String email) {
		super();
		this.mob = mob;
		this.fname = fname;
		this.lname = lname;
		this.city = city;
		this.state = state;
		this.email = email;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Customer [mob=" + mob + ", fname=" + fname + ", lname=" + lname + ", city=" + city + ", state=" + state
				+ ", email=" + email + "]";
	}
	
	
}
