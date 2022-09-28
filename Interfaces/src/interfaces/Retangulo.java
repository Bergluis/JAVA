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
public class Retangulo implements InterfaceFormas {
    
    private float largura;
    private float altura;

    public Retangulo(float largura, float altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }
    
    @Override
    public float calcularArea(){
        float resultado = (float) this.altura*this.largura;
        return resultado;
    }
    
    @Override
    public float calcularPerimetro(){
        float resultado = (float) (this.altura*2)+(this.largura*2);
        return resultado;
    }
}
