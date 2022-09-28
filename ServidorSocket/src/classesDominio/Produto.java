/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesDominio;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class Produto implements Serializable{
    private static final long serialVersionUID = 123L;
    private String nome;
    private int quantidade;
    private float preco;

    public Produto(String nome, int quantidade, float preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
