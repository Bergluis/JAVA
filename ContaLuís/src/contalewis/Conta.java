/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contalewis;


public class Conta {
    
    private String cpfTitular;
    private String nomeTitular;
    private float saldo;

    public Conta(String cpfTitular, String nomeTitular) {
        this.cpfTitular = cpfTitular;
        this.nomeTitular = nomeTitular;
        this.saldo = 0;
    }

    public String getCpfTitular() {
        return cpfTitular;
    }

    public void setCpfTitular(String cpfTitular) {
        this.cpfTitular = cpfTitular;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
    public boolean verificaSituacao(int maximo,int numconta) {
        boolean x = false;
        if(numconta < maximo && numconta >= 0){
            x = true;
        }
        return x;
    }
    
    public void depositar(float valorDeposito) {
        this.saldo = this.saldo + valorDeposito;
    }
    
    public boolean sacar(float valorSaque) {
        boolean teste = false;
        if(valorSaque <= this.saldo) {
            teste = true;
            this.saldo = this.saldo - valorSaque;
        }
        return teste;
    }
    
}
