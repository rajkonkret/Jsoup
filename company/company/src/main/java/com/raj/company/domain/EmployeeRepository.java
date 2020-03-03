package com.raj.company;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

//Odpowiedzialnośc tej klasy to zapytania do bazy danych

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

//sposób 1
    @Query("SELECT e FROM Employee e WHERE e.job =?1")
    Iterable<Employee> findEmployeesByJob(String job);

    //sposób 2 - jeśli nazwiemy metode zgodnie z konwersją to @Query zrobi za nas hibernate
    Iterable<Employee> findByJob(String job);

    //sposób 1 z modyfikacją = użycie sql zmiast hibernate sql
    @Query(value = "SELECT * FROM EMP WHERE job=?1", nativeQuery = true)
    Iterable<Employee> findEMP(String job);

}
