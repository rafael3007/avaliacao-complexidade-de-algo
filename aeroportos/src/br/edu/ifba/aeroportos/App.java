package br.edu.ifba.aeroportos;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import com.github.javafaker.Faker;

import br.edu.ifba.aeroportos.impl.Aeroporto;
import br.edu.ifba.aeroportos.impl.OperacoesImpl;
import br.edu.ifba.aeroportos.impl.SensorImpl;
import br.edu.ifba.aeroportos.impl.Trafego;
import br.edu.ifba.aeroportos.operacoes.Operacoes;
import br.edu.ifba.aeroportos.sensor.Sensor;

public class App {

    private static final int TOTAL_DE_AEROPORTOS = 10; // quantidade de Aeroportos para análise
    private static final int TOTAL_DE_LEITURAS = 100; // quantidade de leituras

    /**
     * complexidade linear, O(N)
     * Justificativa -> porque tem um for que depende do total de Aeroportos da
     * simulação
     * 
     */
    public static void main(String[] args) throws Exception {
        Operacoes<Aeroporto, Trafego> operacoes = new OperacoesImpl();
        Sensor<Trafego> sensor = new SensorImpl();

        Map<Aeroporto, List<Trafego>> leiturasPorAeroporto = new TreeMap<>();
        for (int i = 0; i < TOTAL_DE_AEROPORTOS; i++) {
            String id = (i + 1) + "";

            // geração do nome 'fake' do aeroporto ( siglas )
            Faker faker = new Faker(Locale.forLanguageTag("pt-BR"));
            leiturasPorAeroporto.put(new Aeroporto(id, "Aerporto - " + faker.aviation().airport()),
                    sensor.gerarLeituras(TOTAL_DE_LEITURAS));
        }

        // Execução d)1
        operacoes.imprimir(new ArrayList<Aeroporto>(leiturasPorAeroporto.keySet()));

        // Execução d)2
        operacoes.imprimir(leiturasPorAeroporto);

        // Execução d)3
        Map<Aeroporto, List<Trafego>> leiturasOrdenadas = operacoes.ordenar(leiturasPorAeroporto);
        operacoes.imprimir(leiturasOrdenadas);

        // Execução d)4 - radar de congestionamento
        List<Trafego> padrao = new ArrayList<>();

        // padrão de consgestionamento - curva crescente
        padrao.add(new Trafego(1470));
        padrao.add(new Trafego(1480));
        padrao.add(new Trafego(1490));

        System.out.println("--------- Radar Aereo ---------");
        operacoes.procurarPadrao(leiturasPorAeroporto, padrao);

    }
}
