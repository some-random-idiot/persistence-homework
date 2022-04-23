package persistence;

import javax.persistence.*;

@Entity(name = "births_in_new_zealand")
public class BirthRecord {
    @Column(nullable = false)
    private int period;

    @Column(nullable = false)
    private String region;

    @Column(nullable = false)
    private int birth_count;
}
