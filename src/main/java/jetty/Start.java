package jetty;
import org.mortbay.jetty.Connector;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.bio.SocketConnector;
import org.mortbay.jetty.webapp.WebAppContext;


public class Start {
	
	public static void main(String[] args) throws Exception { 
		Server server = new Server(); 
		SocketConnector connector = new SocketConnector();
		
		connector.setMaxIdleTime(1000 * 60 * 60); 
		connector.setSoLingerTime(-1);
		/* Cambie el puerto porque lo tengo ocupado, sorry */
		connector.setPort(8080); 
		server.setConnectors(new Connector[] { connector });
		
		WebAppContext bb = new WebAppContext(); 
		bb.setServer(server); 
		bb.setContextPath("/tp1"); 
		bb.setWar("src/main/webapp"); 
		server.addHandler(bb);
		
		try { 
			System.out.println(">>> STARTING EMBEDDED JETTY SERVER, "
					+ "PRESS ANY KEY TO STOP"); 
			server.start();
			while (System.in.available() == 0) { 
				Thread.sleep(5000);
			} 
			server.stop(); 
			server.join();
		} catch (Exception e) { 
			e.printStackTrace(); 
			System.exit(100);
		}
	}
	
}