package com.raj.company.domain;

import lombok.Data;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

@Data
@Entity
@Table(name = "dept")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPTNO")
    private Integer id;

    @Column(name = "DNAME")
    private String name;

    @Column(name = "LOC")
    private String loc;



}
