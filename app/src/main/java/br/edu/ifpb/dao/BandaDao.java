package br.edu.ifpb.dao;

import br.edu.ifpb.model.Banda;
import br.edu.ifpb.model.Integrante;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        PreparedStatement statement = connection.prepareStatement("INSERT INTO banda (localOrigim, nomeFantansia, ) VALUES ( ?, ?)");
            statement.setString(1,banda.getLocalDeOrigim());
            statement.setString(2, banda.getNomeFantansia());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            Logger.getLogger(BandaDao.class.getName()).log(Level.SEVERE,null,throwables);
        }

    }

    public void excluir(Banda banda) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM banda WHERE id = ?");
            statement.setInt(1,banda.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            Logger.getLogger(BandaDao.class.getName()).log(Level.SEVERE,null,throwables);
        }
    }

    public void editar(Banda banda) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE banda SET  localOrigim = ?, nomeFantansia = ? WHERE id = ?");
            statement.setString(1, banda.getLocalDeOrigim());
            statement.setString(2, banda.getNomeFantansia());
            statement.setInt(3,banda.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            Logger.getLogger(BandaDao.class.getName()).log(Level.SEVERE,null,throwables);
        }
    }

    public List<Banda> listar() {
        try {
            List<Banda> lista = new ArrayList<>();
            ResultSet result = connection.prepareStatement("SELECT * FROM banda").executeQuery();
            while (result.next()) {
                lista.add(
                        criarBanda(result)
                );
            }
            return lista;
        } catch (SQLException ex) {
//            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE,null,ex);
            return Collections.EMPTY_LIST;
        }
    }


    private Banda criarBanda(ResultSet result) throws SQLException {
        String localOrigim = result.getString("localOrigim");
        String nomeFantansia = result.getString("nomeFantansia");
        int id = result.getInt("id");
        return new Banda(id,localOrigim,nomeFantansia);
    }


}
