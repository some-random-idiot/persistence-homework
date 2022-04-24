package persistence.entity;

import javax.persistence.*;

@Entity(name = "deaths_in_new_zealand")
public class DeathRecord implements RecordSkeleton {
    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private Integer period;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private Integer death_count;

    public DeathRecord() {
    }

    public DeathRecord(int period, String region, int count) {
        this.period = period;
        this.region = region;
        this.death_count = count;
    }

    public int getPeriod() {
        return period;
    }

    public String getRegion() {
        return region;
    }

    public int getDeath_count() {
        return death_count;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setDeath_count(int death_count) {
        this.death_count = death_count;
    }
}
