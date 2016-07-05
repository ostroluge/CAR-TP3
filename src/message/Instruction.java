package message;

import java.io.Serializable;

import model.Personne;

public class Instruction implements Serializable {

	public int codeInstruction;
	public String nomPersonne;
	public Personne personne;
	
	public Instruction() {
		
	}
	
	public Instruction(int codeInstruction) {
		this.codeInstruction = codeInstruction;
	}

	public Instruction(int codeInstruction, String nomPersonne) {
		this.codeInstruction = codeInstruction;
		this.nomPersonne = nomPersonne;
	}

	public Instruction(int codeInstruction, Personne personne) {
		this.codeInstruction = codeInstruction;
		this.personne = personne;
	}
}
