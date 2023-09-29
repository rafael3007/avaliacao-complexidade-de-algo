package br.edu.ifba.aeroportos.impl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import br.edu.ifba.aeroportos.operacoes.Operacoes;
import br.edu.ifba.aeroportos.ordenador.Ordenador;

public class OperacoesImpl implements Operacoes<Aeroporto, Trafego> {

    /**
     * Mostra os dados dos Aeroportos. A complexidade deste metodo é linear, O(N).
     * Justificativa -> porque o total de passos de execução cresce linearmente em
     * relação ao tamanho da entrada de dados.
     */
    @Override
    public void imprimir(List<Aeroporto> monitorados) {
        for (Aeroporto aeroporto : monitorados) {
            System.out.println(aeroporto);
        }
    }

    /**
     * Mostra as leituras do Trafego de cada Aeroporto. A complexidade é quadrática,
     * O(N^2).
     * Justificativa -> porque existe um loop aninhado em um mais externo.
     */
    @Override
    public void imprimir(Map<Aeroporto, List<Trafego>> leituras) {
        for (Aeroporto aeroporto : leituras.keySet()) {
            System.out.println("leituras do aeroporto " + aeroporto.getNome());
            for (Trafego leitura : leituras.get(aeroporto)) {
                System.out.println(leitura);
            }
        }
    }

    /**
     * Está função realiza a ordenação das leituras do Trafego de cada aeroporto. A
     * complexidade desse metodo é, N²LOGN.
     * Justificativa -> porque existe um loop neste metodo, porém ele chama a função
     * de ordenacao cuja complexidade é NLogN
     */
    @Override
    public Map<Aeroporto, List<Trafego>> ordenar(Map<Aeroporto, List<Trafego>> leituras) {
        Map<Aeroporto, List<Trafego>> leiturasOrdenadas = new TreeMap<>();

        for (Aeroporto aeroporto : leituras.keySet()) {
            // aeroporto em análise
            System.out.println("ordenando as leituras do aeroporto: " + aeroporto.getNome());

            List<Trafego> leiturasParaOrdenar = leituras.get(aeroporto);
            // chamada do Ordenador
            Ordenador<Trafego> ordenador = new OrdenadorImpl(leiturasParaOrdenar);
            ordenador.ordenar();

            leiturasOrdenadas.put(aeroporto, leiturasParaOrdenar);
        }

        return leiturasOrdenadas;
    }

    /**
     * Esta função encontra um radar de congestionamento nas leituras realizadas
     * dos aeroportos.a complexidade é O(N^3), portanto, cúbica.
     * Justificativa -> Porque existem 3 loops(for) aninhados
     * 
     * 
     **/
    @Override
    public void radar(Map<Aeroporto, List<Trafego>> leituras, List<Trafego> radar) {
        int totalDeIguais = 0;
        // for 1
        for (Aeroporto aeroporto : leituras.keySet()) {
            System.out.println("Radar...: " + aeroporto.getNome());
            List<Trafego> trafego = leituras.get(aeroporto);
            // for 2
            for (int i = 0; i < trafego.size() - radar.size(); i++) {
                // for 3
                for (int j = 0; j < radar.size(); j++) {
                    // se maior ou igual satisfaz a condição para o padrão( congestionamento )
                    if (trafego.get(i + j).getValor() >= radar.get(j).getValor()) {
                        totalDeIguais++;
                    }
                }
            }

            // Impressão do radar
            if (totalDeIguais > 1) {
                System.out
                        .println(aeroporto.getNome() + " com risco de congestionamento!");
            } else {
                System.out
                        .println(aeroporto.getNome() + " com trafego normal!");
            }
        }

    }

    public void imprimirTrafegoPadroes(Trafego medicoes) {
        System.out.println(medicoes);
    }

}
