package persistence.dao;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.support.ConnectionSource;
import persistence.entity.BirthRecord;
import persistence.entity.DeathRecord;
import persistence.entity.RecordSkeleton;

import java.sql.SQLException;

public class DeathDao extends BaseDaoImpl<DeathRecord, Integer> implements DaoSkeleton {
    public DeathDao(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, DeathRecord.class);
    }

    @Override
    public DeathRecord findByPeriodAndRegion(int period, String region) throws SQLException {
        // Find a record by period and region.
        return super.queryBuilder()
                .where()
                    .eq("period", period)
                    .and()
                    .eq("region", region)
                .queryForFirst();
    }

    @Override
    public void createOrUpdateRec(RecordSkeleton record) throws SQLException {
    // Create or update a record.
        DeathRecord deathRecord = (DeathRecord) record;
        if (findByPeriodAndRegion(deathRecord.getPeriod(), deathRecord.getRegion()) == null) {
            create(deathRecord);
        }
        else {
            // Update the birth count on certain records.
            executeRaw("UPDATE " + getTableName() + " SET death_count = " + deathRecord.getDeath_count() +
                    " WHERE period = " + deathRecord.getPeriod() + " AND region = '" + deathRecord.getRegion() + "'");
        }
    }
}
