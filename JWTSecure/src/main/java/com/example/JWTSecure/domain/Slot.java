package com.example.JWTSecure.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "slot")
public class Slot {

    @Id
    @SequenceGenerator(
            name = "slot_sequence",
            sequenceName = "slot_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "slot_sequence"
    )
    private Long id;
    @Column(name="from_time")
    private java.sql.Time fromTime;
    @Column(name="to_time")
    private java.sql.Time toTime;
}
