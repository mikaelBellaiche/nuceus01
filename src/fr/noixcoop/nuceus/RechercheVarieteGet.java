package fr.noixcoop.nuceus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RechercheVarieteGet
 */
@WebServlet("/RechercheVarieteGet")
public class RechercheVarieteGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheVarieteGet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String variete = request.getParameter("variete");
		if(variete != null){
			MetierVarietes nomVariete = new MetierVarietes();
			if(nomVariete.consulter(variete) != null){
				String leNom = nomVariete.consulter(variete).toString();
				response.setContentType("text/html");
				PrintWriter sortie = response.getWriter();
				sortie.println("<html><body><h1>"+ leNom +"</h1></body></html>");
				
			}
			else{
				response.setContentType("text/html");
				PrintWriter sortie = response.getWriter();
				sortie.println("<html><body><h1>Variété de noix inconnu</h1></body></html>");
			}
		}
		else{
			response.setContentType("text/html");
			PrintWriter sortie = response.getWriter();
			sortie.println("<html><body><h1>Variété de noix inconnu 2</h1></body></html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
