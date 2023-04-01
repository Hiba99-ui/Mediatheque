/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mediathequeserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.sql.SQLException;

/**
 *
 * @author hiba-
 */
public class MediathequeServer {
    public static void main(String[] args) throws IOException, SQLException, SocketException{
        try{
            ServerSocket server=new ServerSocket(1300);
            System.out.println("Serveur actif dans le port 1300 \n");
            while(true){
                Socket socket=server.accept();
                ThreadServer t=new ThreadServer(socket);
                Thread thread=new Thread(t);
                thread.start();
            }
        }
     catch(Exception e){
    System.out.println(e);
    e.printStackTrace();
}
}
}
