package com.developement.jpa_practice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "student_tbl",
        uniqueConstraints = @UniqueConstraint(
                name = "emailid_unique",
                columnNames = "email_address"
        )
)
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "sequence_generator",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sequence_generator"
    )
    private long studentId;
    private String firstName;
    private String lastName;
    @Column(
            name = "email_address",
            nullable = false
    )
    private String emailId;
    @Embedded
    private Guardian guardian;
}
