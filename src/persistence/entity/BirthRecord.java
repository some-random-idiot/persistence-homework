package persistence.entity;

import javax.persistence.*;

@Entity(name = "births_in_new_zealand")
public class BirthRecord implements RecordSkeleton {
    @Column(nullable = false)
    private Integer period;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private int birth_count;

    public BirthRecord() {

    }

    public BirthRecord(int period, String region, int birth_count) {
        this.period = period;
        this.region = region;
        this.birth_count = birth_count;
    }

    public int getPeriod() {
        return period;
    }

    public String getRegion() {
        return region;
    }

    public int getBirth_count() {
        return birth_count;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setBirth_count(int birth_count) {
        this.birth_count = birth_count;
    }
}
