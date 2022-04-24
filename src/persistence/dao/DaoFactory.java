package persistence.dao;

import com.j256.ormlite.jdbc.JdbcConnectionSource;

import java.io.FileReader;
import java.sql.SQLException;
import java.util.Properties;

public class DaoFactory {
    private static final JdbcConnectionSource connectionSource = createConnection();

    public static DaoSkeleton getDao(String type) {
        try {
            if (type.equals("BirthDao")) {
                return new BirthDao(connectionSource);
            } else if (type.equals("DeathDao")) {
                return new DeathDao(connectionSource);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static JdbcConnectionSource createConnection() {
        try {
            FileReader reader = new FileReader("././database.properties");
            Properties properties = new Properties();
            properties.load(reader);
            String DB_PATH = properties.getProperty("DB_PATH");
            return new JdbcConnectionSource("jdbc:sqlite:" + DB_PATH);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
