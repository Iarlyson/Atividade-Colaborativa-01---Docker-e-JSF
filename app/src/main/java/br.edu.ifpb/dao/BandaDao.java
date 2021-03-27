package br.edu.ifpb.dao;

import br.edu.ifpb.model.Banda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BandaDao{
    private Connection connection;

    public BandaDao() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://host-banco:5432/atividadedac",
                    "user","123"
            );
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BandaDao.class.getName()).log(Level.SEVERE,null,ex);
        }

    }


    public void novo(Banda banda) {
        try {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO BANDA (localOrigim, nomeFantansia, ) VALUES ( ?, ?)");
            statement.setString(1,banda.getLocalDeOrigim());
            statement.setString(2, banda.getNomeFantansia());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void busca(Banda banda) {

    }

    @Override
    public void excluir(Banda objeto) {

    }

    @Override
    public void editar(Banda banda) {

    }

    @Override
    public void listar() {

    }
}
