package Ejercicio1;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	static int MAX=10000000;
	static boolean vpri[]=new boolean[MAX];
	public Servidor() throws IOException {
		ServerSocket server=new ServerSocket(9090);
		Socket cliente;
		criba();
		while(true){
			cliente=server.accept();
			DataInputStream flujint = new DataInputStream(cliente.getInputStream());
			String Numero = flujint.readUTF();
			cliente.close();
			
			if(Numero.equals(" ")){
				server.close();
				break;
			}
			if(vpri[Integer.parseInt(Numero)])System.out.println(Numero+" :Es primo");
			else System.out.println(Numero+" :No es primo");
		}
	}
	public static void main(String[] args) throws IOException {
		new Servidor();

	}
	private static void criba() {
		for (int i = 0; i < MAX; i++){
			vpri[i]=true;
		}
		vpri[0]=false;
		vpri[1]=false;
		for (int i = 2; i < MAX; i++) {
			if(vpri[i]==true){
				for (int j = i+i; j < MAX; j=j+i) {
					vpri[j]=false;
				}
			}
		}
	}


}
