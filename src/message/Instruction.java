package message;

import model.Personne;

public class Instruction {

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
