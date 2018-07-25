package fr.ubordeaux.ao.productmanagement.infrastructure.persistence.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import fr.ubordeaux.ao.productmanagement.domain.model.exception.ProductManagementException;

public abstract class ConceptMapping {
    private Connection connection;
    private final String DATA_BASE = "PRODUCTS";
    private final String USER = "root";
    private final String PASSWORD = "root";

    public ConceptMapping() {
        try {
            connectToDataBase();
        } catch (Exception ex) {
            throw new ProductManagementException("Unable to connect DataBase");
        }
        
    }

    private void connectToDataBase() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String connectionUrl = "jdbc:mysql://127.0.0.1:3306/"+DATA_BASE+"?user="+USER+"&password="+PASSWORD;
        connection = DriverManager.getConnection(connectionUrl);
    }

    protected Connection getConnection() {
        return connection;
    }
}