package com.developement.jpa_practice.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "course_material_tbl"
)@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    @OneToOne(
            cascade = CascadeType.ALL , // for creating Course if not available
            fetch = FetchType.LAZY
    )
    @JoinColumn(
            name = "course_id", // foreign key
            referencedColumnName = "courseId" // which column is foreign key referencing to
    )
    private Course course;
}
