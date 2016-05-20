package ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Carnet;
import model.Repertoire;
import network.TCPClient;

public class IHMAuthentification extends JFrame implements ActionListener {

	    protected JTextField c_identifiant;
	    protected JPasswordField c_password;

	    protected JButton b_valider;

	    protected JLabel l_probleme;

	    protected TCPClient client;

	    // Constructeur.
	    public IHMAuthentification(TCPClient client) {
		
	        super("Authentification");

	        this.client = client;

	        Container contentPane = super.getContentPane();
	        contentPane.setLayout(new BorderLayout());

	        this.setSize(400, 400);

	        Panel pb = new Panel();
	        pb.setLayout(new GridLayout(6, 1));
	        contentPane.add("Center", pb);

	        this.b_valider = new JButton("Valider");
	        pb.add(this.b_valider);
	        this.b_valider.addActionListener(this);

	        Panel pc = new Panel();
	        pc.setLayout(new GridLayout(2, 1));
	        contentPane.add("North", pc);

	        Panel pc1 = new Panel();
	        pc1.setLayout(new GridLayout(2, 2));
	        pc.add(pc1);

	        pc1.add(new JLabel("Identifiant :"));
	        this.c_identifiant = new JTextField(20);
	        pc1.add(this.c_identifiant);

	        pc1.add(new JLabel("Password :"));
	        this.c_password = new JPasswordField(20);
	        pc1.add(this.c_password);

	        this.l_probleme = new JLabel("");
	        contentPane.add("South", this.l_probleme);

	        fixerErreur(null);

	    }

	    
	    @Override
	    public void actionPerformed(ActionEvent e) {
		    Object source = e.getSource();
		        if (source == this.b_valider)
		            this.valider();
	    }
	    
	    public void fixerErreur(String message) {
	        if (message == null)
	            this.l_probleme.setText("Aucun probleme a signaler.");
	        else
	            this.l_probleme.setText(message + " !");
	    }

	    public void valider() {
	        if (isAuthorizedToLog()) {
	            this.launchRepertoires();
	        } else {
	            this.l_probleme.setText("Wrong login or password!");
	        }
	    }
	    
	    public Boolean isAuthorizedToLog() {
		
	        return true;
	    }

	    public void launchRepertoires() {
		IHM ihmRepertoire = new IHM();
		Repertoire carnet = new Carnet();
		ihmRepertoire.fixerRepertoire (carnet);
	
		this.setVisible(false);
		this.dispose();
		ihmRepertoire.setVisible(true);
	    }
}
