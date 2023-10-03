package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try{
            System.out.println("server avviato");
            ServerSocket server=new ServerSocket(3000);//crea il server
    
            Socket s=server.accept();//accetta la richiesta di collegamento del client
            System.out.println("un client si è connesso");
    
            BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));//crea il modo per ascoltare
            DataOutputStream out= new DataOutputStream(s.getOutputStream());//crea il modo per rispondere

            String stringaRicevuta=in.readLine();//riceve il messaggio dal client
            System.out.println("il client ha inviato "+stringaRicevuta);//stampa il messaggio del client

            String stringaModificata=stringaRicevuta.toUpperCase();//modifica la stringa del client
            out.writeBytes(stringaModificata+"\n");//invia un messaggio al client
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("errore nella creazione del server");
            System.exit(1);
        }


    }
}
