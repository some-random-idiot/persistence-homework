package persistence.dao;

import persistence.entity.RecordSkeleton;

import java.sql.SQLException;

public interface DaoSkeleton {
    RecordSkeleton findByPeriodAndRegion(int period, String region) throws SQLException;
    void createOrUpdateRec(RecordSkeleton record) throws SQLException;
}
