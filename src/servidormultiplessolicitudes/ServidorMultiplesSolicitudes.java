/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidormultiplessolicitudes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Gabriel
 */
public class ServidorMultiplesSolicitudes{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
//        if (System.getenv("PORT_NUMER") == null) {
//            System.out.println("Port number is required");
//            System.exit(0);
//        }
//        Integer port = Integer.valueOf(System.getenv("PORT_NUMER"));
        ServerSocket serverSocket = null;
   try { 
      serverSocket = new ServerSocket(36000);
//      int a=new Integer(System.getenv(35000));
   } catch (IOException e) {
      System.err.println("Could not listen on port: 36000.");
      System.exit(1);
   }

   Socket clientSocket = null;
        while (true) {            
            System.out.println("Listo para recibir ...");
            clientSocket = serverSocket.accept();
   PrintWriter out = new PrintWriter(
                         clientSocket.getOutputStream(), true);
   BufferedReader in = new BufferedReader(
                         new InputStreamReader(clientSocket.getInputStream()));
   String inputLine, outputLine;
   while ((inputLine = in.readLine()) != null) {
      System.out.println("Recibí: " + inputLine);
      if (!in.ready()) {break; }
   }
   outputLine = 
           "HTTP/1.1 200 OK\r\n"
           + "Content-Type: text/html\r\n"
           +"\r\n"
           + "<!DOCTYPE html>\n"
           + "<html>\n"
           + "<head>\n"
           + "<meta charset=\"UTF-8\">\n"
           + "<title>Title of the document</title>\n"
           + "</head>\n"
           + "<body>\n"
           + "<h1>Mi propio mensaje</h1>\n"
           + "</body>\n"
           + "</html>\n" + inputLine; 
    out.println(outputLine);
        }
//    out.close(); 
//    in.close(); 
//    clientSocket.close(); 
//    serverSocket.close(); 
    }
    
}
