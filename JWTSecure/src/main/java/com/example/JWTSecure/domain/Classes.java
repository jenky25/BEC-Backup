package com.example.JWTSecure.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "class")
public class Classes {

    @Id
    @SequenceGenerator(
            name = "class_sequence",
            sequenceName = "class_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "class_sequence"
    )
    private Long id;
    @Column(name="room_id")
    private Long roomId;
    @Column(name="teacher_id")
    private Long teacherId;
    @Column(name="name")
    private String name;
    @Column(name="start_date")
    private Date startDate;
    @Column(name="course_id")
    private Long courseId;
    @Column(name="end_date")
    private Date endDate;
    @Column(name="active")
    private boolean active;
}
