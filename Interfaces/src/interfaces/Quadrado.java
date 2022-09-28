/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

/**
 *
 * @author Luis
 */
public class Quadrado implements InterfaceFormas {
    
    private float lado;

    public Quadrado(float lado) {
        this.lado = lado;
    }

    public float getLado() {
        return lado;
    }

    public void setLado(float lado) {
        this.lado = lado;
    }
    
    @Override
    public float calcularArea(){
        float resultado = (float) Math.pow(this.lado,2);
        return resultado;
    }
    
    @Override
    public float calcularPerimetro(){
        float resultado = (float) this.lado*4;
        return resultado;
    }
}
