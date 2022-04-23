package persistence.dao;

import persistence.entity.RecordSkeleton;

import java.sql.SQLException;

public interface DaoSkeleton {
    public void updateRecord(int period, String region, int count) throws SQLException;
    public RecordSkeleton findByPeriodAndRegion(int period, String region) throws SQLException;
}
