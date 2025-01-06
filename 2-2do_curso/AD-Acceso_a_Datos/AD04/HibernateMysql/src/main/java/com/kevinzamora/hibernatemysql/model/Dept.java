package com.kevinzamora.hibernatemysql.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "dept")
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int deptno;

    @Column(name = "dname")
    private String name;

    @Column(name = "loc")
    private String location;
}
