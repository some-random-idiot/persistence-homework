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
    public BirthRecord findByPeriodAndRegion(int period, String region) throws SQLException {
        // Find a record by period and region.
        return super.queryBuilder()
                .where()
                    .eq("period", period)
                    .and()
                    .eq("region", region)
                .queryForFirst();
    }
}
