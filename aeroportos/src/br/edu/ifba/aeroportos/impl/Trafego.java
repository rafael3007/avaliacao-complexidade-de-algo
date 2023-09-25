package br.edu.ifba.aeroportos.impl;

/**
 * classe para simular o valor monitorado( Trafego ), cuja complexidade, de
 * forma geral, é constante, O(1)
 */
public class Trafego {

    Integer id = 0;
    Integer valor = 0;

    public Trafego(Integer id, Integer valor) {
        this.id = id;
        this.valor = valor;
    }

    public Trafego(Integer valor) {
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Quantidade de vôos: " + valor;
    }

}
