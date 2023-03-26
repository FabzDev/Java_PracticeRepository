package state;

public class Selection implements Tool {

	@Override
	public void mouseDown() {
		System.out.println("Select icon");
		
	}

	@Override
	public void mouseUp() {
		System.out.println("Draw dashed rectangle");
		
	}

}
