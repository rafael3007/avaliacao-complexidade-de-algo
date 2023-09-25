package br.edu.ifba.aeroportos.impl;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.aeroportos.ordenador.Ordenador;

/**
 * classe auxiliadora para ordenacao
 * 
 * o algoritmo foi adaptado a partir do que se encontra disponibilizado em:
 * https://www.delftstack.com/howto/java/merge-sort-arraylist-java/ e também
 * utilizado em sala de aula.
 * 
 * como se trata de um merge sort, a complexidade eh NLogN, porque primeiramente
 * o algoritmo divide a colecao de dados a ser ordenada e, apos a divisao,
 * junta cada sub-colecao de dados para chegar ao ordenamento.
 */
public class OrdenadorImpl extends Ordenador<Trafego> {

    public OrdenadorImpl(List<Trafego> leituras) {
        super(leituras);
    }

    /**
     * 
     */
    public void ordenar() {
        ordenar(0, leituras.size() - 1);
    }

    /**
     * algoritimo de ordenação binária
     * 
     * @param inicio tipo Int que deinife a posição inicial de verificação
     * @param fim    tipo Int que deinife a posição final de verificação
     */
    public void ordenar(int inicio, int fim) {
        if (inicio < fim && (fim - inicio) >= 1) {
            int meio = (fim + inicio) / 2;

            ordenar(inicio, meio);
            ordenar(meio + 1, fim);

            ordenar(inicio, meio, fim);
        }
    }

    private void ordenar(int inicio, int meio, int fim) {
        List<Trafego> leiturasAux = new ArrayList<>();

        int esquerda = inicio;
        int direita = meio + 1;

        while (esquerda <= meio && direita <= fim) {
            if (leituras.get(esquerda).getValor() <= leituras.get(direita).getValor()) {
                leiturasAux.add(leituras.get(esquerda));
                esquerda++;
            } else {
                leiturasAux.add(leituras.get(direita));
                direita++;
            }
        }

        while (esquerda <= meio) {
            leiturasAux.add(leituras.get(esquerda));
            esquerda++;
        }

        while (direita <= fim) {
            leiturasAux.add(leituras.get(direita));
            direita++;
        }

        for (int i = 0; i < leiturasAux.size(); inicio++) {
            leituras.set(inicio, leiturasAux.get(i++));
        }
    }

}