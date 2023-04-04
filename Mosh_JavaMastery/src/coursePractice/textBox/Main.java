package coursePractice.textBox;

public class Main {
	
	public static void main(String[] args) {
		var textBox1 = new TextBox();
		var textBox2 = textBox1;
//		textBox1.setText("Box 1");
//		System.out.println(textBox1.text);
		
//		var textBox2 = new TextBox();
//		textBox2.setText("Box 2");
//		System.out.println(textBox2.text);
		
		System.out.println(textBox1.text);
		textBox2.text = "fabio";
		System.out.println(textBox2.text);
		System.out.println(textBox1.text);
	}
	
}
