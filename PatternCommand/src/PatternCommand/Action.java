package PatternCommand;

public abstract class Action {
	
	int volumeDeplace;
	Bidon source;
	
	public Action(Bidon b)
	{
		volumeDeplace = 0;
		source = b;
	}
	
	public abstract void execute();
	public abstract void undo();
	 
}
