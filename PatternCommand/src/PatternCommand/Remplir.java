package PatternCommand;

public class Remplir extends Action {

	public Remplir(Bidon b) {
		super(b);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute() {
		volumeDeplace = source.getVolumeCourant();
		source.setVolumeCourant(source.getVolumeMax());
		volumeDeplace = source.getVolumeCourant() - volumeDeplace;
	}

	@Override
	public void undo() {
		source.setVolumeCourant(source.getVolumeCourant() - volumeDeplace);
	}
	
	public String toString()
	{
		return "Remplir "+source;
	}

}
