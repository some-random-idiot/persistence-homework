package persistence.dao;

import com.j256.ormlite.jdbc.JdbcConnectionSource;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {
    private final JdbcConnectionSource connectionSource;

    public DaoFactory() throws IOException, SQLException {
        this.connectionSource = createConnection();
    }

    public DaoSkeleton getDao(String type) throws SQLException {
        if (type.equals("BirthDao")) {
            return new BirthDao(connectionSource);
        }
        else if (type.equals("DeathDao")) {
            return new DeathDao(connectionSource);
        }
        return null;
    }

    private static JdbcConnectionSource createConnection() throws IOException, SQLException {
        FileReader reader = new FileReader("././database.properties");
        Properties properties = new Properties();
        properties.load(reader);
        String DB_PATH = properties.getProperty("DB_PATH");
        return new JdbcConnectionSource("jdbc:sqlite:" + DB_PATH);
    }
}
