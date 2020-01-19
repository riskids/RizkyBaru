/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import impl.PenjualanDaoImpl;
import service.PelangganDao;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Rizki Adam Kurniawan
 */
public class RizkyBaruDatabase {

    private static Connection connection;
    private static PelangganDao PelangganDao;

    public static Connection getConnection() throws SQLException {
        if (connection == null) {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setUrl("jdbc:mysql://localhost:3306/lat_rizkybaru");
            dataSource.setUser("root");
            dataSource.setPassword("");
            connection = dataSource.getConnection();
        }
        return connection;
    }

    public static PelangganDao getPelangganDao() throws SQLException {
        if (PelangganDao == null) {
            PelangganDao = new PenjualanDaoImpl(getConnection());
        }
        return PelangganDao;
    }
}
