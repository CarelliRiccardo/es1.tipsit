package com.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
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
        Socket s=new Socket("localhost", 3000);

        BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out=new DataOutputStream(s.getOutputStream());
        
        out.writeBytes("ciao a tutti"+"\n");
        String risposta=in.readLine();

        System.out.println("il server ha detto "+risposta);

        s.close();

       } 
       catch(Exception e)
       {
        System.out.println(e.getMessage());
        System.out.println("errore nel collegamento al server");
        System.exit(1);
       }
    }
}
