package PatternCommand;

public class Vider extends Action {

	public Vider(Bidon b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		volumeDeplace = source.getVolumeCourant();
		source.setVolumeCourant(0);
		volumeDeplace = source.getVolumeCourant() - volumeDeplace;
	}

	@Override
	public void undo() {
		source.setVolumeCourant(source.getVolumeCourant() - volumeDeplace);
	}
	
	public String toString()
	{
		return "Vider "+source;
	}
}
