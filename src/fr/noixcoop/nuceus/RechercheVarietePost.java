package fr.noixcoop.nuceus;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RechercheVarietePost
 */
@WebServlet("/RechercheVarietePost")
public class RechercheVarietePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheVarietePost() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String variete = request.getParameter("variete");
		if(variete != null){
			MetierVarietes nomVariete = new MetierVarietes();
			if(nomVariete.consulter(variete) != null){
				Variete leNom = nomVariete.consulter(variete);
				response.setContentType("text/html");
				PrintWriter sortie = response.getWriter();
				sortie.println("<html><body><center><h1>DETAIL VARIETE</h1></center>"
						+ "<center><table border=2><tr><td>Nom</td><td>Aoc</td></tr>"
						+ "<tr><td>"+leNom.getLibelle()+"</td><td>"+ leNom.isAoc()+"</td></tr></table></center></body></html>");
				
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

}
