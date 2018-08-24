package net.zonia3000.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Performs a SELECT query providing the value contained into the example table.
 *
 * @author zonia3000
 */
public class DBValueSelector {

    private final Properties config;

    /**
     * @param config Properties defining the configuration necessary for setting
     * up the connection to the database.
     */
    public DBValueSelector(Properties config) {
        this.config = config;
    }

    /**
     * @return the value contained in example table.
     * @throws SQLException
     */
    public String getValue() throws SQLException {

        String sql = "SELECT value FROM example";

        try (Connection conn = DriverManager.getConnection(config.getProperty("url"),
                config.getProperty("user"), config.getProperty("password"));
                Statement stat = conn.createStatement();
                ResultSet rs = stat.executeQuery(sql)) {

            if (rs.next()) {
                return rs.getString(1);
            }
        }

        return null;
    }
}
