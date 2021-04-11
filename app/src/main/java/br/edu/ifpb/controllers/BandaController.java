package br.edu.ifpb.controllers;

import br.edu.ifpb.dao.BandaDao;
import br.edu.ifpb.model.Banda;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class BandaController implements Serializable {

    private Banda banda = new Banda();

//    private List<Banda> bandas = new ArrayList<Banda>();

    private BandaDao bandaDao = new BandaDao();

    public void criarBanda(){
        bandaDao.novo(banda);
    }

    public List<Banda> listarBandas(){
        return bandaDao.listar();
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }

}
