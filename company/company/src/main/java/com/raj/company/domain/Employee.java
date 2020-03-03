package com.raj.company;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "emp")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPNO")
    private Integer id;

    @Column(name = "ENAME")
    private String name;

    @Column(name = "MGR")
    private Integer mgr;

    @Column(name = "SAL")
    private Double salary;

    @Column(name = "JOB")
    private String job;

    @Column(name = "COMM")
    private Double commision;

    @Column(name = "HIREDATE")
    private LocalDate hiredate;



}
