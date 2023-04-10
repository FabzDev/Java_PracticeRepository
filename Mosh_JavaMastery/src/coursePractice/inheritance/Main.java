package coursePractice.inheritance;

public class Main {
	public static void main(String[] args) {
		var control = new UIControl(true);
		var textBox = new TextBox();
		show(textBox);
	}
	
	public static void show(UIControl object) {
		var textBox = (TextBox)object;
		textBox.setText("Hello world");
		System.out.println(textBox);
	}
}
