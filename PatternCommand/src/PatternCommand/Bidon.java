package PatternCommand;

public class Bidon {
	
	int volumeCourant;
	int volumeMax;
	
	public Bidon()
	{
		volumeCourant = 0;
		volumeMax = 1;
	}
	
	public Bidon(int VM)
	{
		volumeCourant = 0;
		volumeMax = VM;
	}
	
	public int getVolumeCourant() {
		return volumeCourant;
	}
	public void setVolumeCourant(int volumeCourant) {
		this.volumeCourant = volumeCourant;
	}
	public int getVolumeMax() {
		return volumeMax;
	}
	public void setVolumeMax(int volumeMax) {
		this.volumeMax = volumeMax;
	}
	
	public String toString()
	{
		return "Bidon de "+getVolumeMax()+"L (volumeCourant : "+getVolumeCourant()+"L)";		
	}
}
