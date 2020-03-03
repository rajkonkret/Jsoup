package com.raj.company.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("stanowisko")
    @Column(name = "JOB")
    private String job;

    @JsonIgnore
    @Column(name = "COMM")
    private Double commision;

    @Column(name = "HIREDATE")
    private LocalDate hiredate;

    @JoinColumn(name = "DEPTNO")
    @ManyToOne
    private Department department;

}
