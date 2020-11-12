import java.util.Objects;

public class Student {

	private String name;
	private String email;
	private int id;
	
	public Student(String name, String email, int id) {
		setName(name);
		setEmail(email);
		setId(id);
	}
	
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name.isEmpty() || Objects.isNull(name) ? "Unknown" : name;
	}
	
	public void setEmail(String email) {
		this.email = email.isEmpty() || Objects.isNull(email) ? "Unknown" : email;
	}
	
	public void setId(int id) {
		this.id = id < 100000 && id > 1000 ? id : 1000 + (int)Math.random(); 
	}
	
	
	@Override
	public String toString() {
		return  "\n \nStudent: \nName: " + getName()
						+ "\nEmail: " + getEmail()
						+ "\nPhone number: " + getId();
	}
}
