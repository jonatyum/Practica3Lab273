package Ejercicio1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
	
	public Cliente() throws UnknownHostException, IOException {
		Scanner lee=new Scanner(System.in);
		while(lee.hasNext()){
			Socket cli=new Socket("127.0.0.1",9090);
			String n=lee.nextLine();
			DataOutputStream flujout = new DataOutputStream(cli.getOutputStream());
			flujout.writeUTF(n);
			cli.close();
			if(n.equals(" "))break;
		}
	}
	public static void main(String[] args) throws UnknownHostException, IOException {
		new Cliente();
	}

}
