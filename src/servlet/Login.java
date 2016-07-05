package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Personne;
import network.TCPClient;
import network.TCPServer;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TCPServer serverTCP;
	private TCPClient clientTCP;
    /**
     * Default constructor. 
     */
    public Login() {
	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    this.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   
	    connectAnnuaire();
	   
	    String hostTCP = clientTCP.HOSTNAME;
	    int portTCP = clientTCP.PORT;
	    String login = (String) request.getParameter("login");
	    
	    HttpSession session = request.getSession(true);
	    session.setAttribute("hostTCP", hostTCP);
	    session.setAttribute("portTCP", portTCP);
	    session.setAttribute("login", login);
	    
//	    clientTCP.getProxyCarnet().ajouterPersonne(new Personne("Lol", "lol@lol.com", "www.lol.com", "info"));
//	    
//	    String[] listPersonnes = serverTCP.getCarnet().listerPersonnes();
//	    
//	    for (String name : listPersonnes) {
//		System.out.println(name);
//	    }
	    
	    //AUthentifier l'user
	    //Créer une session et stocker login mdp host et port
	    //Affiche la liste des annuaires etc...
//	    getServletContext().getRequestDispatcher("/WEB-INF/resume.jsp").forward(request, response);
	    
	    request.setAttribute("Carnet", TCPServer.getCarnet());
	    request.setAttribute("ProxyCarnet", TCPClient.getProxyCarnet());
	    
	    getServletContext().getRequestDispatcher("/WEB-INF/contenuCarnet.jsp").forward(request, response);
	}
	
	private void connectAnnuaire(){
	    serverTCP = new TCPServer();
	    clientTCP = new TCPClient();
	}

}
