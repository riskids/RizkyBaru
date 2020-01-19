/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl;

import entity.Penjualan;
import error.PenjualanException;
import service.PelangganDao;
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
public class PenjualanDaoImpl implements PelangganDao {

    private Connection connection;
    private final String insertPelanggan = "INSERT INTO Pelanggan"
            + "(Tgl, Galon_Terjual, Jumlah) VALUES"
            + "(?,?,?)";

    private final String updatePelanggan = "UPDATE Pelanggan SET Tgl=?,Galon_Terjual=?,Jumlah=?,WHERE ID=?";

    private final String deletePelanggan = "DELETE FROM Pelanggan WHERE ID=?";

    private final String selectAll = "SELECT * FROM Pelanggan";

    public PenjualanDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insertPelanggan(Penjualan Pelanggan) throws PenjualanException {

        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(insertPelanggan, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, Pelanggan.getTgl());
            statement.setInt(2, Pelanggan.getGalon());
            statement.setInt(3, Pelanggan.getJumlah());
            statement.executeUpdate();
            
            ResultSet result  = statement.getGeneratedKeys();
            if (result.next()) {
                Pelanggan.setId(result.getInt(1));
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
    public void updatePelanggan(Penjualan Pelanggan) throws PenjualanException {

        PreparedStatement statement = null;

        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(updatePelanggan);
            statement.setString(1, Pelanggan.getTgl());
            statement.setInt(2, Pelanggan.getGalon());
            statement.setInt(3, Pelanggan.getJumlah());
            statement.setInt(5, Pelanggan.getId());
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
    public void deletePelanggan(Integer id) throws PenjualanException {

        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(deletePelanggan);
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
    public List<Penjualan> selectAllPelanggan() throws PenjualanException {
        Statement statement = null;
        List<Penjualan> list2 = new ArrayList<Penjualan>();
        try {
            connection.setAutoCommit(false);
            statement = connection.createStatement();

            ResultSet result = statement.executeQuery(selectAll);
            while (result.next()) {
                Penjualan Pelanggan = new Penjualan();
                Pelanggan.setId(result.getInt("ID"));
                Pelanggan.setTgl(result.getString("Tgl"));
                Pelanggan.setGalon(result.getInt("Galon_Terjual"));
                Pelanggan.setJumlah(result.getInt("Jumlah"));
                    
                list2.add(Pelanggan);
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
