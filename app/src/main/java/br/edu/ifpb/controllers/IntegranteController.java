package br.edu.ifpb.controllers;

import br.edu.ifpb.dao.IntegranteDao;
import br.edu.ifpb.model.Integrante;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class IntegranteController implements Serializable {

    private Integrante integrante = new Integrante();

//    private List<Banda> bandas = new ArrayList<Banda>();

    private IntegranteDao integranteDao = new IntegranteDao();

    public void criarIntegrante(){
        integranteDao.novo(integrante);
    }

    public List<Integrante> listarIntegrantes(){
        return integranteDao.listar();
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }
}
