package PatternCommand;

public class Verser extends Action {
	
	Bidon destination;
	
	public Verser(Bidon b, Bidon b2) {
		super(b);
		destination = b2;
	}

	@Override
	public void execute() {
		volumeDeplace = destination.getVolumeMax() - destination.getVolumeCourant();
		if(volumeDeplace > source.getVolumeCourant())
		{
			volumeDeplace = source.getVolumeCourant();
		}
		source.setVolumeCourant(source.getVolumeCourant() - volumeDeplace);
		destination.setVolumeCourant(destination.getVolumeCourant() + volumeDeplace);
	}

	@Override
	public void undo() {
		source.setVolumeCourant(source.getVolumeCourant() + volumeDeplace);
		destination.setVolumeCourant(destination.getVolumeCourant() - volumeDeplace);
	}
	
	public String toString()
	{
		return "Verser "+volumeDeplace+"L depuis "+source+" vers "+destination;
	}

}
