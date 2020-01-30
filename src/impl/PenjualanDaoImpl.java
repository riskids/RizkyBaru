/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import entity.Penjualan;
import error.PenjualanException;
import service.PenjualanDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rizki Adam Kurniawan
 */
public class PenjualanDaoImpl implements PenjualanDao {

    private Connection connection;
    private final String insertPenjualan = "INSERT INTO Penjualan"
            + "(Tgl, Galon_Terjual, Jumlah) VALUES"
            + "(?,?,?)";

    private final String updatePenjualan = "UPDATE Penjualan SET Tgl=?,Galon_Terjual=?,Jumlah=? WHERE ID=?";

    private final String deletePenjualan = "DELETE FROM Penjualan WHERE ID=?";

    private final String selectAll = "SELECT * FROM Penjualan";

    public PenjualanDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertPenjualan(Penjualan Penjualan) throws PenjualanException {

        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPenjualan, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, Penjualan.getTgl());
            statement.setInt(2, Penjualan.getGalon());
            statement.setInt(3, Penjualan.getJumlah());
            statement.executeUpdate();
            
            ResultSet result  = statement.getGeneratedKeys();
            if (result.next()) {
                Penjualan.setId(result.getInt(1));
            }
            
            connection.commit();
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenjualanException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public void updatePenjualan(Penjualan Penjualan) throws PenjualanException {

        PreparedStatement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePenjualan);
            statement.setString(1, Penjualan.getTgl());
            statement.setInt(2, Penjualan.getGalon());
            statement.setInt(3, Penjualan.getJumlah());
            statement.setInt(4, Penjualan.getId());
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenjualanException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public void deletePenjualan(Integer id) throws PenjualanException {

        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePenjualan);
            statement.setInt(1, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenjualanException(e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }
        }
    }

    @Override
    public List<Penjualan> selectAllPenjualan() throws PenjualanException {
        Statement statement = null;
        List<Penjualan> list2 = new ArrayList<Penjualan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectAll);
            while (result.next()) {
                Penjualan Penjualan = new Penjualan();
                Penjualan.setId(result.getInt("ID"));
                Penjualan.setTgl(result.getString("Tgl"));
                Penjualan.setGalon(result.getInt("Galon_Terjual"));
                Penjualan.setJumlah(result.getInt("Jumlah"));
                    
                list2.add(Penjualan);
            }
            connection.commit();
            return list2;
        } catch (SQLException exception) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            throw new PenjualanException(exception.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException exception) {
                }
            }

        }
    }

}
