package com.uniovi.sdi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletEliminarProductoDelCarrito
 */
@WebServlet("/eliminarProducto")
public class ServletEliminarProductoDelCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEliminarProductoDelCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession	session=request.getSession();
		HashMap<String,Integer>	carrito	=	
				(HashMap<String,Integer>)	request.getSession().getAttribute("carrito");
				
				String	producto = request.getParameter("producto");
				if	(producto != null){
					borrarDelCarrito(carrito, producto);
				}
				
				//Retornar la	vista con parámetro	"carrito"
				request.setAttribute("paresCarrito", carrito);
				getServletContext().getRequestDispatcher("/vista-carrito.jsp").forward(request,	
				response);
				
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/html");
				PrintWriter	out	=	response.getWriter();
				out.println("<HTML>");
				out.println("<HEAD><TITLE>Tienda	SDI:	carrito</TITLE></HEAD>");
				out.println("<BODY>");
				out.println(carritoEnHTML(carrito)+"<br>");
				out.println("<a	href=\"index.jsp\">Volver</a></BODY></HTML>");
	}
	
	private String carritoEnHTML(HashMap<String, Integer> carrito) {
		String carritoEnHTML="";
		
		for(String key:carrito.keySet())
			carritoEnHTML+="<p>["+key+"], "+carrito.get(key)+" unidades</p>";
		return carritoEnHTML;
	}

	private void borrarDelCarrito(HashMap<String, Integer> carrito, String claveProducto) {
		int numeroArticulos=(Integer)carrito.get(claveProducto).intValue();
		
		if(numeroArticulos==1)
			carrito.remove(claveProducto);
		else {
			carrito.put(claveProducto, Integer.valueOf(numeroArticulos-1));
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
