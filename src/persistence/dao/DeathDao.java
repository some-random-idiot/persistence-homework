package persistence.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import persistence.entity.DeathRecord;

import java.sql.SQLException;

public class DeathDao extends BaseDaoImpl<DeathRecord, Integer> implements DaoSkeleton {
    public DeathDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, DeathRecord.class);
    }

    @Override
    public void updateRecord(int period, String region, int count) {
        // Create a new record, or update an existing one if it already exists.
        try {
            super.createOrUpdate(new DeathRecord(period, region, count));
        }
        catch (SQLException e) {
            System.out.println("Error creating a death record: " + e.getMessage());
        }
    }

    @Override
    public void findByPeriodAndRegion(int period, String region) {
        // Find a record by period and region.
        try {
            super.queryForSameId(new DeathRecord(period, region, -1));
        }
        catch (SQLException e) {
            System.out.println("Error finding a death record: " + e.getMessage());
        }
    }
}
