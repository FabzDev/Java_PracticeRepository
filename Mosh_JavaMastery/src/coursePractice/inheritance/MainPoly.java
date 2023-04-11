package coursePractice.inheritance;

public class MainPoly {
	public static void main(String[] args) {
		UIControl[] controls = { new TextBox(), new Checkbox() };
		for (UIControl control : controls) {
			// if (control = TextBox)
			// render TextBox
			// else
			// render CheckBox
			control.render();
		}

	}
}