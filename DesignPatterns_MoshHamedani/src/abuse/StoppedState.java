package abuse;

public class StoppedState implements State {
	Cronometro cronometro;
	
	
	public StoppedState(Cronometro cronometro) {
		this.cronometro = cronometro;
	}
	@Override
	public void Click() {
		this.cronometro.setCurrentState(new RunningState(cronometro));
		System.out.println("Running");
	}

}
