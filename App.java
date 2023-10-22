/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany;

import java.io.IOException;
import java.net.Socket;
/**
 *
 * @author Ваня
 */
public class App {

    public static void main(String[] args) throws IOException {
        String hostname="kst.tugab.bg";
        int[]ports={80,443,22,3306};
        for(int port:ports){
            scanPort(hostname,port);
        }
    }
    public static void scanPort(String hostname,int port) throws IOException{
        try{
            Socket socket=new Socket(hostname,port);
            System.out.println("Port "+port+" e otvoren.");
            String protocol=getProtocol(port);
            System.out.println("Protocol: "+protocol);
            socket.close();
        }catch(IOException e){
            System.out.println("Port "+port+" e zatvoren.");
        }
    }
    public static String getProtocol(int port){
        switch(port){
            case 80:
                return "HTTP";
            case 443:
                return "HTTPS";
            case 22:
                return "SSH";
            case 3306:
                return "MySQL";
            default:
                return "Nepoznat";
        }
    }
}
