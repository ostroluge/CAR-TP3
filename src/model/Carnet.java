package model;

import java.util.ArrayList;
import java.util.List;

public class Carnet implements Repertoire {

	public List<Personne> personnes = new ArrayList<>();
	
	public Carnet() {
		
	}
	
	public Carnet(List<Personne> personnes) {
		this.personnes = personnes;
	}
	
	public boolean ajouterPersonne(Personne personne) {
		return personnes.add(personne);
	}

	public boolean modifierPersonne(Personne personne) {
		retirerPersonne(personne.nom);
		return ajouterPersonne(personne);
	}

	public boolean retirerPersonne(String nom) {
		for (Personne personne : personnes) {
			if (personne.nom.equals(nom)) {
				return personnes.remove(personne);
			}
		}
		return false;
	}

	public Personne chercherPersonne(String nom) {
		for (Personne personne : personnes) {
			if (personne.nom.equals(nom)) {
				return personne;
			}
		}
		return null;
	}

	public String[] listerPersonnes() {
		String[] arrayPersonnes = null;
		List<String> nomPersonnes = new ArrayList<>();
		for (Personne personne : personnes) {
			nomPersonnes.add(personne.nom);
		}
		arrayPersonnes = nomPersonnes.toArray(new String[nomPersonnes.size()]);
		return arrayPersonnes;
	}	
}
