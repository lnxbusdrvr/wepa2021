

	 
	import java.io.PrintWriter;
	import java.util.Scanner;
	 
	import java.net.Socket;
	 
	public class HelloBrowser {
	 
	    public static void main(String[] args) throws Exception {
	        Scanner lukija = new Scanner(System.in);
	 
	        System.out.println("================");
	        System.out.println("THE INTERNETS!");
	        System.out.println("================");
	 
	        System.out.print("Where to? ");
	 
	        // Kysytään käyttäjältä
	        String osoite = lukija.next();
	        int portti = 80;
	 
	        System.out.println("================");
	        System.out.println("RESPONSE");
	        System.out.println("================");
	 
	        // muodosta yhteys
	        Socket soketti = new Socket(osoite, portti);
	 
	        // lähetä viesti palvelimelle
	        PrintWriter pWriter = new PrintWriter(soketti.getOutputStream());
	        pWriter.println("GET / HTTP/1.1");
	        pWriter.println("Host: "+osoite);
	        pWriter.println();
	        pWriter.flush();
	 
	        // lue vastaus palvelimelta
	        Scanner lueSrvr = new Scanner(soketti.getInputStream());
	        while(lueSrvr.hasNext()) {
	          System.out.println(lueSrvr.nextLine());
	 
	        }
	 
	        System.out.println("to? "+osoite);
	 
	    }
	}
