package com.example.JWTSecure.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "class_slot")
public class ClassSlot {
    @Id
    @SequenceGenerator(
            name = "classslot_sequence",
            sequenceName = "classslot_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "classslot_sequence"
    )
    private Long id;
    @Column(name="slot_id")
    private Long slotId;
    @Column(name="class_id")
    private Long classId;
    @Column(name="first_of_week")
    private Integer firstOfWeek;
    @Column(name="second_of_week")
    private Integer secondOfWeek;
}
