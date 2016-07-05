package network;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import message.Instruction;
import model.Carnet;
import model.Personne;
import model.ProxyCarnet;

public class TCPServer {

    static Carnet carnet;
    
	public static void main(String[] args) throws Exception {

		ServerSocket welcomeSocket = new ServerSocket(TCPClient.PORT);
		carnet = new Carnet();

		while (true) {

			Socket connectionSocket = welcomeSocket.accept();

			ObjectInputStream inputObject = new ObjectInputStream(connectionSocket.getInputStream());
			ObjectOutputStream outputObject = new ObjectOutputStream(connectionSocket.getOutputStream());

			Instruction instruction = (Instruction) inputObject.readObject();

			switch (instruction.codeInstruction) {
			case ProxyCarnet.AJOUTER_PERSONNE:
				outputObject.writeBoolean(carnet.ajouterPersonne(instruction.personne));
				break;
			case ProxyCarnet.CHERCHER_PERSONNE:
				outputObject.writeObject(carnet.chercherPersonne(instruction.nomPersonne));
				break;
			case ProxyCarnet.LISTER_PERSONNES:
				outputObject.writeObject(carnet.listerPersonnes());
				break;
			case ProxyCarnet.MODIFIER_PERSONNE:
				outputObject.writeObject(carnet.modifierPersonne(instruction.personne));
				break;
			case ProxyCarnet.RETIRER_PERSONNE:
				outputObject.writeBoolean(carnet.retirerPersonne(instruction.nomPersonne));
				break;
			default:
				break;

			}
		}
	}

	public static Carnet getCarnet() {
	    if (carnet == null) {
	    	List<Personne> personnes = new ArrayList<>();
	    	return new Carnet(personnes);
	    }
		return carnet;
	}

	public static void setCarnet(Carnet carnet) {
	    TCPServer.carnet = carnet;
	}
}
