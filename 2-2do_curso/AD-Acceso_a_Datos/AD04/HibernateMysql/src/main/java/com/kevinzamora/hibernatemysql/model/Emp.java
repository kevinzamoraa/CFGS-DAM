package com.kevinzamora.hibernatemysql.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "emp")
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empno;

    @Column(name = "ename")
    private String name;

    @Column(name = "job")
    private String job;

    @Column(name = "mgr")
    private int mgr;

    @Column(name = "hiredate")
    private LocalDate hireDate;

    @Column(name = "sal")
    private double salary;

    @Column(name = "comm")
    private double comm;

    @Column(name = "deptno")
    private  int deptno;

}
