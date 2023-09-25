package br.edu.ifba.aeroportos.sensor;

import java.util.List;

public interface Sensor<Quantidade> {

    public List<Quantidade> gerarLeituras(int totalLeituras);

}
