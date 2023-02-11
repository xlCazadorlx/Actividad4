/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Camacho Renzo, Steeven Urdanigo
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msgHead = "<html> <title>Server de Practica - Arquitectura y Servicios Distribuidos</title>\n<body><br>";
		String msgTail = "</body> </html>";
		String resp, aux1, aux2;
		float res1, res2 = 0;
		resp = msgHead +"<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\"> "
                        +"<body class=\"body text-center\" > "
                        +"<div class=\"card\">"
                        +"<div class=\"container-md\">"
                        +"<H1>Universidad Tecnica de Manabi</H1> "
                        +"<H3>Integrantes:</H3><br> "
                        +"<div class=\"row\">"
                         +"   <div class=\"col\">"
                                +"<H5>Camacho Garzon Renzo Alejandro</H5>"
                            +"</div>"
                            +"<div class=\"col\">"
                                +"<H5>Urdanigo Lopez Steeven Hernan</H5>"
                            +"</div>"
                        +"</div> <br>"
                        +"<H3>Convertidor de monedas.</H3><br> "
                                
                                + "<div class=\"mb-3\">"
				+ "Escriba el valor que desea convertir: <br>\n"
                        
				+ "<form action= \"Servlet\" name=\"calc\" method=\"post\">\n"
                        
				+ "<h3>Cantidad: <input class=\"form-select\" type=\"text\" name=\"cantidad\">  </h3>\n"
                                + "</div>"
				+ "	Tipos de conversion:\n"
				+ "	<select name=\"conv\" class=\"form-select\" aria-label=\"Default select example\" size=\"1\" align=\"left\" >\n"
				+ "	<option selected=\"selected\" value=\"0\">--&gt; Indique el tipo de conversion</option>\n"
				+ "	<option value=\"1\"> USD --> Euros </option>\n"
				+ "	<option value=\"2\"> Euros --> USD </option>\n"
				+ "	</select> <br>\n"
				+ "<input type=\"submit\" class=\"btn btn-primary\" name=\"submit\" value=\"Convertir\" >\n"
				+ "<input type=\"submit\" class=\"btn btn-primary\" name=\"submit\" value=\"Recargar\" >\n</form>\n"
                                + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>"
                                + "</div>"
                                + "</div>"
                                + "</body>";
		if (request.getQueryString()!=null) {
			aux1 = request.getParameter("submit");
			if (aux1.equalsIgnoreCase("Convertir")) {
				aux1 = request.getParameter("cantidad");
			    aux2 = request.getParameter("conv");
			    if (!aux1.equalsIgnoreCase("") && aux1!=null) {
			    	res1 = Float.parseFloat(aux1);
			    	if (aux2.equalsIgnoreCase("1")) {
			    		//HACER LA OPERACION Y GUARDAR RESULTADO EN res2
			    		res2 = (float) (res1 / 1.02);
			    		resp = resp +"<br> Resultado: "+ res1 +" USD equivalen a "+ res2 +"Euros.<br>"+msgTail;
			    	}else if (aux2.equalsIgnoreCase("2")) {
			        //HACER LA OPERACION Y GUARDAR RESULTADO EN res2
			    		res2 = (float) (res1 * 1.02);
			    		resp = resp +"<br> Resultado: "+ res1 +" Euros equivalen a "+ res2 +"USD.<br>"+msgTail;	
			    	}else {
			    		resp = resp +"<br> Error, debe especificar el tipo de conversion." +msgTail;
			    	}
			    }else {
			    	resp = resp +"<br> Error, debe ingresar una cantidad." +msgTail;
			    }
			}
		}else {
			resp = resp + msgTail;
		}
		response.getWriter().append(resp);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String msgHead = "<html> <title>Server de Practica - Arquitectura y Servicios Distribuidos</title>\n<body><br>";
		String msgTail = "</body> </html>";
		String resp, aux1, aux2;
		float res1, res2 = 0;
		resp = msgHead+"<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65\" crossorigin=\"anonymous\"> "
                        +"<H1>Convertidor de monedas.</H2><br> "
                        +"<body class=\"body text-center\" > "
                        +"<div class=\"card\">"
                        +"<div class=\"container-md\">"
                        +"<H1>Universidad Tecnica de Manabi</H1> "
                        +"<H3>Integrantes:</H3><br> "
                        +"<div class=\"row\">"
                         +"   <div class=\"col\">"
                                +"<H5>Camacho Garzon Renzo Alejandro</H5>"
                            +"</div>"
                            +"<div class=\"col\">"
                                +"<H5>Urdanigo Lopez Steeven Hernan</H5>"
                            +"</div>"
                        +"</div> <br>"
                        +"<H3>Convertidor de monedas.</H3><br> "
                                
                                + "<div class=\"mb-3\">"
                                + "Escriba el valor que desea convertir: <br>\n"
                                + "<form action= \"Servlet\" name=\"calc\" method=\"post\">\n"
                                + "	<h3>Cantidad: <input class=\"form-control\" type=\"text\" placeholder=\"Cantidad\" aria-label=\"default input example\" > </h3>\n"
                                + "	Tipos de conversion:\n"
                                + "	<select name=\"conv\" class=\"form-select\" aria-label=\"Default select example\" size=\"1\" name=\"cantidad\" >\n"
                                + "	<option selected=\"selected\" value=\"0\">--&gt; Indique el tipo de conversion</option>\n"
                                + "	<option value=\"1\"> USD --> Euros </option>\n"
                                + "	<option value=\"2\"> Euros --> USD </option>\n"
                                + "	</select><br> \n"
                                        + "<input type=\"submit\" class=\"btn btn-primary\" name=\"submit\" value=\"Convertir\" >\n"
                                        + "<input type=\"submit\" class=\"btn btn-primary\" name=\"submit\" value=\"Recargar\" >\n</form>\n"
                                + "<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4\" crossorigin=\"anonymous\"></script>"
                                + "</div>"
                                + "</div>"
                                + "</body>";
		aux1 = request.getParameter("cantidad");
		aux2 = request.getParameter("conv");
		String aux3 = request.getParameter("submit");
		if (aux3.equals("Convertir")) {
			if (!aux1.equalsIgnoreCase("") && aux1!=null) {
				res1 = Float.parseFloat(aux1);
				if (aux2.equalsIgnoreCase("1")) {
					//HACER LA OPERACION Y GUARDAR RESULTADO EN res2
					res2 = (float) (res1 / 1.02);
					resp = resp +"<br> Resultado: "+ res1 +" USD equivalen a "+ res2 +" Euros.<br>"+msgTail;
			    }else if (aux2.equalsIgnoreCase("2")) {
			    	//HACER LA OPERACION Y GUARDAR RESULTADO EN res2
			    	res2 = (float) (res1 * 1.02);
			    	resp = resp +"<br> Resultado: "+ res1 +" Euros equivalen a "+ res2 +" USD.<br>"+msgTail;	
			    }else {
			    	resp = resp +"<br> Error, debe especificar el tipo de conversion." +msgTail;
			    }
			}else {
				resp = resp +"<br> Error, debe ingresar una cantidad." +msgTail;
			}
		}else 
			resp = resp + msgTail;
		response.getWriter().append(resp);

	}

}
