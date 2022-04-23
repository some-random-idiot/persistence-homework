package persistence.dao;

import persistence.entity.RecordSkeleton;

import java.sql.SQLException;

public interface DaoSkeleton {
    public RecordSkeleton findByPeriodAndRegion(int period, String region) throws SQLException;
}
