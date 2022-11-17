package com.example.JWTSecure.domain;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "student_in_class")
public class StudentInClass {

    @Id
    @SequenceGenerator(
            name = "student_in_class_sequence",
            sequenceName = "student_in_class_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "student_in_class_sequence"
    )
    private Long id;
    @Column(name="student_id")
    private Long studentId;
    @Column(name="class_id")
    private Long classId;
    @Column(name="is_paid")
    private Boolean isPaid;

}