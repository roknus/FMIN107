package PatternCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Jeu {
	private ArrayList<Bidon> listeBidon;
	private ArrayList<Action> historique;
	private int volumeToWin;

	public Jeu()
	{
		listeBidon = new ArrayList<Bidon>();
		historique = new ArrayList<Action>();
		volumeToWin = 0;
	}
	
	public void start()
	{
		initiateGame();
		play();
	}
	
	private void initiateGame()
	{
		System.out.println("Bienvenue");
		System.out.println("Avec combien de bidon voulez vous jouer?");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int nbB = 0;
		
		try {
			nbB = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < nbB; i++)
		{
			System.out.println("Volume du bidon"+(i+1)+" ? :");
			br = new BufferedReader(new InputStreamReader(System.in));
			
			int volume = 0;
			
			try {
				volume = Integer.parseInt(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			Bidon b = new Bidon(volume);
			listeBidon.add(b);
		}
		
		System.out.println("Volume a trouver? :");
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int volumeWin = 0;
		
		try {
			volumeWin = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setVolumeToWin(volumeWin);		
	}
	
	private void play()
	{
		boolean continuer = true;
		int action = 0;
		BufferedReader br;
		while(continuer)
		{
			System.out.println("Vous devez trouver "+volumeToWin+"L !");
			System.out.println("Liste des etats des bidons :");
			int i = 1;
			for(Bidon b : listeBidon)
			{
				System.out.println("\t"+i+" - "+b);
				i += 1;
			}
			System.out.println("\nQuelle action ? :");
			System.out.println("\t1 - Remplir un bidon");
			System.out.println("\t2 - Vider un bidon");
			System.out.println("\t3 - Verser un bidon dans un autre");
			System.out.println("\t4 - Annuler la derniere action");

			br = new BufferedReader(new InputStreamReader(System.in));
			 
			try {
				action = Integer.parseInt(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(action != 4)
			{
				System.out.println("Quel bidon?");
				br = new BufferedReader(new InputStreamReader(System.in));
				
				int b1 = 0;
				
				try {
					b1 = Integer.parseInt(br.readLine()) -1;
				} catch (IOException e) {
					e.printStackTrace();
				}
				int b2 = 0;
				if(action == 3)
				{
					System.out.println("Vers quel bidon?");
					i = 1;
					for(Bidon b : listeBidon)
					{
						System.out.println(i+" - "+b);
						i += 1;
					}
					br = new BufferedReader(new InputStreamReader(System.in));			
					
					try {
						b2 = Integer.parseInt(br.readLine())-1;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}	
				Action a;
				switch(action)
				{
				case 1:
					a = new Remplir(listeBidon.get(b1));
					break;
				case 2:
					a = new Vider(listeBidon.get(b1));
					break;
				case 3:
					a = new Verser(listeBidon.get(b1),listeBidon.get(b2));
					break;
				default:
					a = new Remplir(listeBidon.get(b1));
					break;
				}
				a.execute();
				historique.add(a);
				continuer = isWin();
			}
			else
			{
				historique.get(historique.size()-1).undo();
				historique.remove(historique.get(historique.size()-1));
			}
		}
		System.out.println("Bravo !");
		for(Action a : historique)
		{
			System.out.println(a);
		}
	}
	
	private boolean isWin()			
	{
		for(Bidon b : listeBidon)
		{
			if(b.getVolumeCourant() == this.getVolumeToWin())
			{
				return false;
			}
		}
		return true;
	}
	
	
	public int getVolumeToWin() {
		return volumeToWin;
	}

	public void setVolumeToWin(int volumeToWin) {
		this.volumeToWin = volumeToWin;
	}
	
	public static void main(String[] args) {
		Jeu game = new Jeu();
		game.start();
	}
}
