package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import model.Carnet;

public class AuthentificationClient {

    protected Carnet carnet;
    protected Socket socket;
    protected ObjectInputStream ois;
    protected ObjectOutputStream oos;

    public AuthentificationClient(String address, Integer port) {
        try {
            this.carnet = new Carnet();
            this.socket = new Socket(address, port);
        } catch (IOException e) {
            System.out.println("ERROR: Connection refused.");
            System.exit(182);
        }
    }

    public Carnet getRepertoires() {
        return carnet;
    }

    public ObjectOutputStream oos() {
        if (this.oos == null) {
            try {
                this.oos = new ObjectOutputStream(this.socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error. Cannot instanciate the streams :(");
            }
        }
        return oos;

    }

    public ObjectInputStream ois() {
        if (this.ois == null) {
            try {
                this.ois = new ObjectInputStream(this.socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error. Cannot instanciate the streams :(");
            }
        }
        return ois;
    }
}
