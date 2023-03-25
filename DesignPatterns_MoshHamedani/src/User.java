
public class User {
	// Fields (Attributes)
	public String name;
	
	public User(String name, int age) {
		this.name = name;
	}
	
	//Methods
	public void sayHello() {
		System.out.println("-Hi, my name is " + this.name);
	}
}
