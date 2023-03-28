package abuse;

public class Cronometro {
	private State currentState;
	

	public Cronometro() {
		this.currentState = new StoppedState(this);
	}

	public void click() {
		currentState.Click();
	}
	
	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}
}
