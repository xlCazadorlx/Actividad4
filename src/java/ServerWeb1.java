
/* Ejemplo obtenido de https://programacion.net/articulo/crear_un_servidor_http_simple_en_java_1059
 */
import com.sun.net.httpserver.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Map.Entry;

/* Clase controlador HTTP para procesar las solicitudes. */
class RootHandler implements HttpHandler {
	int port = 8081;
    public void handle(HttpExchange he) throws IOException {
            String response = "hola el Server start success if you see this message" + " Port: " + port;
            //Se crea la respuesta CODIGO y LONGITUD que se va a enviar
            System.out.println(he.getProtocol()+" "+he.getRequestMethod()+ " "+he.getRequestURI());
            System.out.println(he.getRemoteAddress().toString());
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.getBytes());
            os.close();
    }

}

/* Clase echoHeader para mostrar cualquier información del header: */
class EchoHeaderHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange he) throws IOException {
            Headers headers = he.getRequestHeaders();
            Set<Entry<String, List<String>>> entries = headers.entrySet();
            String response = "";
            for (Entry<String, List<String>> entry : entries)
                     response += entry.toString() + "\n";
            he.sendResponseHeaders(200, response.length());
            OutputStream os = he.getResponseBody();
            os.write(response.toString().getBytes());
            os.close();
    }
}

/* Clase controlador echoGet para procesar el Get Request */
class EchoGetHandler implements HttpHandler {
         @Override
         public void handle(HttpExchange he) throws IOException {
                 // parse request
                 Map<String, Object> parameters = new HashMap<String, Object>();
                 URI requestedUri = he.getRequestURI();
                 String query = requestedUri.getRawQuery();
                 System.out.println(he.getProtocol()+" "+he.getRequestMethod()+" "+requestedUri);
                 System.out.println(he.getRemoteAddress().toString());
                 //Aqui podría obtener los campos de peticion con he.getRequestHeaders()
                 //Y revisarlos o mostrarlos
                 Parse.parseQuery(query, parameters);
                 // send response
                 String response = "Este es el mensaje de respuesta de echoGET";
                 for (String key : parameters.keySet())
                          response += key + " = " + parameters.get(key) + "\n";
                 he.sendResponseHeaders(200, response.length());
                 OutputStream os = he.getResponseBody();
                 os.write(response.toString().getBytes());
                 os.close();
         }
}

/*Clase controlador echoPost para procesar el Post Request: */
class EchoPostHandler implements HttpHandler{
         @Override
         public void handle(HttpExchange he) throws IOException {
                 // parse request
                 Map<String, Object> parameters = new HashMap<String, Object>();
                 InputStreamReader isr = new InputStreamReader(he.getRequestBody(), "utf-8");
                 BufferedReader br = new BufferedReader(isr);
                 String query = br.readLine();
                 System.out.println(he.getProtocol()+" "+he.getRequestMethod()+" "+he.getRequestURI());
                 System.out.println(he.getRemoteAddress().toString());
                 Parse.parseQuery(query, parameters);
                 // send response
                 String response = "Este es el mensaje de respuesta de echoPOST";
                 for (String key : parameters.keySet())
                          response += key + " = " + parameters.get(key) + "\n";
                 he.sendResponseHeaders(200, response.length());
                 OutputStream os = he.getResponseBody();
                 os.write(response.toString().getBytes());
                 os.close();
         }
}

/* Clase con método estático parseQuery() para parsear los parámetros de la petición: */

class Parse{
  public static void parseQuery(String query, Map<String, Object> parameters) throws UnsupportedEncodingException {
    if (query != null) {
            String pairs[] = query.split("[&]");
            for (String pair : pairs) {
                     String param[] = pair.split("[=]");
                     String key = null;
                     String value = null;
                     if (param.length > 0) {
                     key = URLDecoder.decode(param[0], System.getProperty("file.encoding"));
                     }


                     if (param.length > 1) {
                              value = URLDecoder.decode(param[1], System.getProperty("file.encoding"));
                     }

                     if (parameters.containsKey(key)) {
                              Object obj = parameters.get(key);
                              if (obj instanceof List<?>) {
                                       List values = (List) obj;
                                       values.add(value);

                              } else if (obj instanceof String) {
                                       List values = new ArrayList();
                                       values.add((String) obj);
                                       values.add(value);
                                       parameters.put(key, values);
                              }
                     } else {
                              parameters.put(key, value);
                     }
            }
    }
  }
}

public class ServerWeb1 {
	static int port = 8081;
	
	public static void main(String[] args) {	
		HttpServer server;
		try {
			server = HttpServer.create(new InetSocketAddress(port), 0);
			System.out.println("server started at " + port);
			server.createContext("/", new RootHandler());
			server.createContext("/echoHeader", new EchoHeaderHandler());
			server.createContext("/echoGet", new EchoGetHandler());
			server.createContext("/echoPost", new EchoPostHandler());
			server.setExecutor(null);
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


}
