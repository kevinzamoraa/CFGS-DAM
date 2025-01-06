package com.kevinzamora.hibernatemysql.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "emp")
public class Emp {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empno;

    @Column(name = "ename", nullable = false)
    private String name;

    @Column(name = "job", nullable = false)
    private String job;

    @Column(name = "mgr")
    private Integer mgr;

    @Column(name = "hiredate")
    private LocalDate hireDate;

    @Column(name = "sal")
    private double salary;

    @Column(name = "comm", nullable = true)
    private Double comm;

    @Column(name = "deptno")
    private  int deptno;

    public String toString() {
        return empno + " - Nombre:" + name + ", Salario: " + salary + "€";
    }

}

