package persistence.dao;

import persistence.entity.RecordSkeleton;

public interface DaoSkeleton {
    public void updateRecord(int period, String region, int count);
    public RecordSkeleton findByPeriodAndRegion(int period, String region);
}
