package abuse;

public class RunningState implements State{
	Cronometro cronometro;
	
	
	public RunningState(Cronometro cronometro) {
		this.cronometro = cronometro;
	}

	@Override
	public void Click() {
		this.cronometro.setCurrentState(new StoppedState(cronometro));
		System.out.println("Stopped");

	}
	

}
