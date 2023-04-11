package coursePractice.inheritance;

public class UIControl {
	private boolean isEnable=true;

//	public UIControl(boolean isEnable) {
//		this.isEnable = isEnable;
//	}
	
	public void render() {
	}
	
	public void enable() {
		isEnable = true;
	}
	
	public void disable() {
		isEnable = false;
	}
	
	public boolean isEnable() {
		return isEnable;
	}

}
