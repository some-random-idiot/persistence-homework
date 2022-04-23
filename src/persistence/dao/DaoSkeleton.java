package persistence.dao;

public interface DaoSkeleton {
    public void updateRecord(int period, String region, int count);
    public void findByPeriodAndRegion(int period, String region);
}
