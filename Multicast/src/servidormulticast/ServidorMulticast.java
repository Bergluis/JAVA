package servidormulticast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class ServidorMulticast {

  public static void main(String[] args) {

    Scanner e1 = new Scanner(System.in);
    try {

          MulticastSocket mcs = new MulticastSocket(12347);
          InetAddress grp = InetAddress.getByName("239.0.0.1");
          mcs.joinGroup(grp);
        
        
      
      
      
      InetAddress addr = InetAddress.getByName("239.0.0.1");     
      
      DatagramSocket ds = new DatagramSocket();    
      
      while(true){
      System.out.println("Digite a mensagem para enviar:");
      String mensagem = e1.nextLine() + "ip de quem enviou :"+ds.getLocalAddress();
      int tamanho = mensagem.length();
    //aqui abaixo transforma a mensagem no formato do datagramsocket
      byte[] b = mensagem.getBytes(); 
             
      DatagramPacket pkg = new DatagramPacket(b, tamanho, addr, 12347);  
      ds.send(pkg);       
      }
    }
    catch(Exception e) {
      System.out.println("Nao foi possivel enviar a mensagem");    
    }
  }
}