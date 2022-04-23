package persistence.dao;

import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class DaoFactory {
    private final ConnectionSource connectionSource;

    public DaoFactory(ConnectionSource connectionSource) {
        this.connectionSource = connectionSource;
    }

    public DaoSkeleton getDao(String type) {
        if (type.equals("BirthDao")) {
            try {
                return new BirthDao(connectionSource);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else if (type.equals("DeathDao")) {
            try {
                return new DeathDao(connectionSource);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
