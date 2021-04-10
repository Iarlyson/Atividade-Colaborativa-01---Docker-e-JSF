package br.edu.ifpb.dao;

import br.edu.ifpb.model.Banda;
import br.edu.ifpb.model.Integrante;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IntegranteDao{
    private Connection connection;

    public IntegranteDao() {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(
                    "jdbc:postgresql://host-banco:5432/atividadedac",
                    "user","123"
            );
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(IntegranteDao.class.getName()).log(Level.SEVERE,null,ex);
        }

    }

    public void novo(Integrante integrante) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO integrante (nome, dataDeNascimento, cpf, ) VALUES ( ?, ?, ?)");
            statement.setString(1,integrante.getNome());
            statement.setString(2, integrante.getDataDeNascimento().toString());
            statement.setString(3, integrante.getCpf());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            Logger.getLogger(IntegranteDao.class.getName()).log(Level.SEVERE,null,throwables);
        }

    }

    public void excluir(Integrante integrante) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM integrante WHERE id = ?");
            statement.setInt(1,integrante.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            Logger.getLogger(IntegranteDao.class.getName()).log(Level.SEVERE,null,throwables);
        }
    }

    public void editar(Integrante integrante) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE integrante SET  nome = ?, dataDeNascimento = ?, cpf = ? WHERE id = ?");
            statement.setString(1,integrante.getNome());
            statement.setString(2, integrante.getDataDeNascimento().toString());
            statement.setString(3, integrante.getCpf());
            statement.setInt(4, integrante.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            Logger.getLogger(IntegranteDao.class.getName()).log(Level.SEVERE,null,throwables);
        }
    }

    public List<Integrante> listar() {
        try {
            List<Integrante> lista = new ArrayList<>();
            ResultSet result = connection.prepareStatement("SELECT * FROM integrante").executeQuery();
            while (result.next()) {
                lista.add(
                        criarIntegrante(result)
                );
            }
            return lista;
        } catch (SQLException ex) {
            //            Logger.getLogger(ClientesEmJDBC.class.getName()).log(Level.SEVERE,null,ex);
            return Collections.EMPTY_LIST;
        }
    }


    private Integrante criarIntegrante(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String nome = result.getString("nome");
        String dataDeNascimento = result.getString("dataDeNascimento");
        String cpf = result.getString("cpf");
        return new Integrante(id,nome, LocalDate.parse(dataDeNascimento),cpf);
    }

}