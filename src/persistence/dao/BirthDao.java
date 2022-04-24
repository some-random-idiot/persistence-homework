package persistence.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import persistence.entity.BirthRecord;
import persistence.entity.RecordSkeleton;

import java.sql.SQLException;

public class BirthDao extends BaseDaoImpl<BirthRecord, Integer> implements DaoSkeleton {
    public BirthDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, BirthRecord.class);
    }

    @Override
    public BirthRecord findByPeriodAndRegion(int period, String region) throws SQLException {
        // Find a record by period and region.
        return queryBuilder()
                .where()
                    .eq("period", period)
                    .and()
                    .eq("region", region)
                .queryForFirst();
    }

    @Override
    public void createOrUpdateRec(RecordSkeleton record) throws SQLException {
        // Create or update a record.
        BirthRecord birthRecord = (BirthRecord) record;
        if (findByPeriodAndRegion(birthRecord.getPeriod(), birthRecord.getRegion()) == null) {
            create(birthRecord);
        }
        else {
            // Update the birth count on certain records.
            executeRaw("UPDATE " + getTableName() + " SET birth_count = " + birthRecord.getBirth_count() +
                        " WHERE period = " + birthRecord.getPeriod() + " AND region = '" + birthRecord.getRegion() + "'");
        }
    }
}
