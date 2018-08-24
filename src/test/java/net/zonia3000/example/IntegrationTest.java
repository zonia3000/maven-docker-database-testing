package net.zonia3000.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests the DBValueSelector on MariaDB and PostgreSQL.
 *
 * @author zonia3000
 */
public class IntegrationTest {

    @Test
    public void testMariaDB() throws Exception {
        String value = new DBValueSelector(getProperties("mariadb-config.properties")).getValue();
        assertEquals("Hello from MariaDB!", value);
    }

    @Test
    public void testPostgreSQL() throws Exception {
        String value = new DBValueSelector(getProperties("postgres-config.properties")).getValue();
        assertEquals("Hello from PostgreSQL!", value);
    }

    /**
     * Creates a Properties instance reading a file located in
     * src/test/resources.
     */
    private static Properties getProperties(String fileName) throws IOException {
        Properties properties = new Properties();
        try (InputStream in = IntegrationTest.class.getClassLoader().getResourceAsStream(fileName)) {
            properties.load(in);
        }
        return properties;
    }
}
