package br.edu.ifba.aeroportos.impl;

/**
 * classe para simular o "objeto" monitorado, no caso um aeroporto, cuja
 * complexidade, de forma geral, eh constante, O(1)
 */
public class Aeroporto implements Comparable<Aeroporto> {

    private String id; // id do aeroporto
    private String nome; // nome do aeroporto

    public Aeroporto(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "nome do Aeropoto: " + nome + ", id: " + id;
    }

    @Override
    public int compareTo(Aeroporto outroPaciente) {
        return this.getId().compareTo(outroPaciente.getId());
    }
}
