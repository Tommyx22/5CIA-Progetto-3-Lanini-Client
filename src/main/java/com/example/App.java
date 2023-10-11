package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        try {

            System.out.println("Il client è partito");
            Socket s = new Socket("localhost", 3000);

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            Scanner tastiera = new Scanner(System.in);

            int nRicevuto;

            do {

                System.out.println("Client indovina il numero tra 1 e 100: ");
                out.writeBytes(tastiera.nextLine() + "\n");
                nRicevuto = Integer.parseInt(in.readLine());

                if(nRicevuto == 1) {
                    System.out.println("il numero inserito è più grande");
                } else if (nRicevuto == 2){
                    System.err.println("il numero inserito è più piccolo");
                }

            } while(nRicevuto != 3);

            System.out.println("bravo hai indovinato");

            tastiera.close();
            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
    }
}
