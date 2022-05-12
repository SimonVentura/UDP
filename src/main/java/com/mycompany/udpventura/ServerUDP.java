/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.udpventura;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studente
 */
public class ServerUDP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int port = 2000;
        DatagramSocket ds;
        DatagramPacket dpi; 
        DatagramPacket dpo;
        
        byte[] buffer; //contiene il payload(body)
        String msgIn,msgOut;
        
        try {
            ds=new DatagramSocket(port);
            System.out.println("server pronto!");
            
            while(true)
            {
                   System.out.println("server in ascolto");
                   buffer = new byte[256];
                   dpi = new DatagramPacket(buffer,buffer.length);//area di memoria che prepariamo per ricevere i messaggi
                   ds.receive(dpi);
                   InetAddress cliIP = dpi.getAddress();
                   int cliPort = dpi.getPort();
                   msgIn = new String(dpi.getData(),0,dpi.getLength());
                   
                   System.out.println("sono il client " + cliIP + "e ho detto" + msgIn);
            }
        } catch (SocketException ex) {
            Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
}
