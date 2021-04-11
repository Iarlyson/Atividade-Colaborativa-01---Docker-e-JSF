package br.edu.ifpb.controllers;

import br.edu.ifpb.dao.BandaDao;
import br.edu.ifpb.dao.IntegranteDao;
import br.edu.ifpb.model.Banda;
import br.edu.ifpb.model.Integrante;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class IntegranteController implements Serializable {

    private Integrante integrante = new Integrante();

    private IntegranteDao integranteDao = new IntegranteDao();


}
