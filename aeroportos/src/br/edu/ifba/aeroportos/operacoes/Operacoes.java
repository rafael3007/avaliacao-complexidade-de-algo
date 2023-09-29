package br.edu.ifba.aeroportos.operacoes;

import java.util.List;
import java.util.Map;

public interface Operacoes<Monitorado, Sensor> {

    // d.1
    public void imprimir(List<Monitorado> monitorados);

    // d.2
    public void imprimir(Map<Monitorado, List<Sensor>> leituras);

    // d.3
    public Map<Monitorado, List<Sensor>> ordenar(Map<Monitorado, List<Sensor>> leituras);

    // d.4
    public void radar(Map<Monitorado, List<Sensor>> leituras, List<Sensor> padrao);

}
