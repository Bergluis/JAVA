package servidormulticast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class ClienteMulticast {

  public static void main(String[] args) throws IOException {
         MulticastSocket mcs = new MulticastSocket(12347);
          InetAddress grp = InetAddress.getByName("239.0.0.1");
          mcs.joinGroup(grp);
          byte rec[] = new byte[256];
          DatagramPacket pkg = new DatagramPacket(rec, rec.length);
      while(true) {
        try {       
         
          //na linha abaixo recebe a mensagem....
          mcs.receive(pkg);
          //na linha abaixo transforma a mensagem em string...
          String data = new String(pkg.getData());
          System.out.println("Dados recebidos:" + data);
      }
      catch(Exception e) {
        System.out.println("Erro: " + e.getMessage()); 
      } 
    }
  }
}