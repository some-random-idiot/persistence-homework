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
    public DeathRecord findByPeriodAndRegion(int period, String region) throws SQLException {
        // Find a record by period and region.
        return super.queryBuilder()
                .where()
                .eq("period", period)
                .and()
                .eq("region", region)
                .queryForFirst();
    }
}
