package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EjemploServlet
 */
@WebServlet("/EjemploServlet/*")
public class EjemploServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private int visitCounter;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EjemploServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	this.visitCounter = 0;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().
		append("Served at: ").
		append(request.getContextPath()).
		append("\nCantidad de requests: ").
		append(Integer.toString(++this.visitCounter)).
		append('\n').
		append(request.getQueryString()).
		append('\n').
		append(request.getPathInfo());
	}

}
