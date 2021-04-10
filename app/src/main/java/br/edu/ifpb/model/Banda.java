package br.edu.ifpb.model;


import java.util.List;

public class Banda{
    private int id;
    private String localDeOrigim;
    private String nomeFantansia;
    private List<Integrante> integrantes;

    public Banda(){

    }

    public Banda(int id, String localOrigim, String nomeFantansia){

    }

    public Banda(int id, String localDeOrigim, String nomeFantansia, List<Integrante> integrantes) {
        this.id = id;
        this.localDeOrigim = localDeOrigim;
        this.nomeFantansia = nomeFantansia;
        this.integrantes = integrantes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalDeOrigim() {
        return localDeOrigim;
    }

    public void setLocalDeOrigim(String localDeOrigim) {
        this.localDeOrigim = localDeOrigim;
    }

    public String getNomeFantansia() {
        return nomeFantansia;
    }

    public void setNomeFantansia(String nomeFantansia) {
        this.nomeFantansia = nomeFantansia;
    }

    public List<Integrante> getIntegrantes() {
        return integrantes;
    }

    public void setIntegrantes(List<Integrante> integrantes) {
        this.integrantes = integrantes;
    }
}