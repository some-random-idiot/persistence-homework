package persistence.dao;

import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class DaoFactory {
    private final ConnectionSource connectionSource;

    public DaoFactory(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
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
}
