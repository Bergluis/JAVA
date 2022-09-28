/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorsocket;

import classesDominio.Produto;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class ServidorSocket2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
           
           ServerSocket servidor = new ServerSocket(12345);          
           System.out.println("Servidor inicializado. Aguardando conexão...");
           while (true) {
               // cria a thread do cliente a cada nova conexão
               Socket cliente = servidor.accept();
               TrataCliente2 trataCliente = new TrataCliente2(cliente);
           }            
           
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }    
 
}

class TrataCliente2 extends Thread{
    Socket cliente;
    
    public TrataCliente2(Socket cliente) {
        this.cliente = cliente;        
        this.start();
    }
    
    public void run() {
        Scanner entrada = new Scanner (System.in);
        try {
            System.out.println("Cliente conectadooooo!"); 
            // Recebendo mensagem do cliente
            ObjectOutputStream out = new ObjectOutputStream(this.cliente.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(this.cliente.getInputStream());
                     
            
            ArrayList<Produto> listaProdutos = new ArrayList<>();
            String mensagemRecebida = (String) in.readObject();
            String mensagemEnviar = "";
            while (!mensagemRecebida.equals("fim")) {
                System.out.println("Recebido do cliente: " + mensagemRecebida);
                if (mensagemRecebida.equals("cadastroProduto")) {                    
                    out.writeObject("Ok");
                    Produto produto = (Produto) in.readObject();
                    listaProdutos.add(produto);
                    mensagemEnviar = "Produto adicionado!";
                    out.writeObject(mensagemEnviar);
                    System.out.println("Produto adicionado na lista!");
                } else if(mensagemRecebida.equals("listaProdutos")) {                    
                    out.writeObject(listaProdutos);                    
                    System.out.println("Enviando lista de produtos para o cliente! Tamanho da lista: " + listaProdutos.size());
                }   else {                
                    
                    System.out.println("Enviar para o cliente: ");
                    mensagemEnviar = entrada.nextLine();  
                    out.writeObject(mensagemEnviar);
                }
                
                mensagemRecebida = (String)in.readObject();
            }      
            
           in.close();
           out.close();
           this.cliente.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (ClassNotFoundException classNot) {
            
        }
    }
}
