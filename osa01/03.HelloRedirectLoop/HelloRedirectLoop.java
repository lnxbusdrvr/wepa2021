
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.PrintWriter;
import java.util.Scanner;

public class HelloRedirectLoop {

  public static void main(String[] args) throws Exception {
    ServerSocket palvelin = new ServerSocket(8080);

    while(true) {
      // Odotetaan pyyntöä
      Socket soketti = palvelin.accept();

      // Käyttajan input
      Scanner lukija = new Scanner(soketti.getInputStream());

      // Palinvastauksen tulostaja
      PrintWriter tulostaja = new PrintWriter(soketti.getOutputStream());
      if ( "/quit".equals( lukija.hasNextLine() ) )  {
        lopetaIstunto(palvelin, soketti, lukija, tulostaja);
        break;
      }

      tulostaja.println("HTTP/1.1 302 FOUND");
      tulostaja.flush();
    }

  }

  public static void lopetaIstunto( ServerSocket palvelin, Socket soketti, 
      Scanner lukija, PrintWriter tulostaja ) throws IOException {
    // Vapautetaan resurssit
    soketti.close();
    lukija.close();
    soketti.close();
    palvelin.close();
  }

}
