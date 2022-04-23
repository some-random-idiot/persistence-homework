package persistence.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import persistence.entity.BirthRecord;

import java.sql.SQLException;

public class BirthDao extends BaseDaoImpl<BirthRecord, Integer> implements DaoSkeleton {
    public BirthDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, BirthRecord.class);
    }

    @Override
    public void updateRecord(int period, String region, int count) {
        // Create a new record, or update an existing one if it already exists.
        try {
            super.createOrUpdate(new BirthRecord(period, region, count));
        }
        catch (SQLException e) {
            System.out.println("Error creating a birth record: " + e.getMessage());
        }
    }

    @Override
    public void findByPeriodAndRegion(int period, String region) {
        // Find a record by period and region.
        try {
            super.queryForSameId(new BirthRecord(period, region, -1));
        }
        catch (SQLException e) {
            System.out.println("Error finding a birth record: " + e.getMessage());
        }
    }
}
