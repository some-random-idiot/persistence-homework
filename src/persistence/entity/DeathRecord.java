package persistence.entity;

import javax.persistence.*;

@Entity(name = "births_in_new_zealand")
public class DeathRecord {
    @Id
    @OneToOne
    private int period;

    @Id
    @OneToOne
    private String region;

    @Column(nullable = false)
    private int death_count;
}
