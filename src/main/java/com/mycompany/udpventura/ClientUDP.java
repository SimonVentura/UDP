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
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Studente
 */
public class ClientUDP {

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
        
        msgOut = "ciao sever mi dicic la data";
        try {
            InetAddress srvAdd=InetAddress.getLocalHost();
            ds = new DatagramSocket();
            dpo = new DatagramPacket(msgOut.getBytes(),msgOut.length(),srvAdd,port);
            ds.send(dpo);
            System.out.println("sono il client" + srvAdd + "messaggio:" +msgOut);
            
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(ClientUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(ClientUDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ClientUDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
