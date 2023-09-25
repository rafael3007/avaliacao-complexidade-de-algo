package br.edu.ifba.aeroportos.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.ifba.aeroportos.sensor.Sensor;

public class SensorImpl implements Sensor<Trafego> {

    private static final int TRAFEGO_MEDIO_EM_UM_AEROPORTO = 1000; // Média próxima ao real
    private static final int OSCILACAO_MAXIMA = 50; // 50% da média 1000 500voos até 1500 voos

    /**
     * Gerador de leituras aleatorias, cuja complexidade é linear, O(N).
     * Justificativa -> porque tem um loop que itera uma vez pelo total de leituras
     * pedidas
     */
    @Override
    public List<Trafego> gerarLeituras(int totalLeituras) {
        List<Trafego> leituras = new ArrayList<>();

        Random randomizador = new Random();

        for (int i = 0; i < totalLeituras; i++) {

            int oscilacao = TRAFEGO_MEDIO_EM_UM_AEROPORTO * randomizador.nextInt(OSCILACAO_MAXIMA) / 100;

            // variância entre periodos de muitos voos e poucos voos
            int trafego = (randomizador.nextBoolean() ? TRAFEGO_MEDIO_EM_UM_AEROPORTO + oscilacao
                    : TRAFEGO_MEDIO_EM_UM_AEROPORTO - oscilacao);

            Trafego leitura = new Trafego(i + 1, trafego);
            leituras.add(leitura);
        }

        return leituras;
    }

}
