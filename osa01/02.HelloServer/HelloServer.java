

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class HelloServer {

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

      tulostaja.println("HTTP/1.1 200 OK");
      tulostaja.println();
      Files.lines(Paths.get("index.html")).forEach(tulostaja::println);
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
