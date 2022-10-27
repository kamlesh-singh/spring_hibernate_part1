package org.ttn.springjpa1.repository;

 import org.springframework.data.repository.CrudRepository;
 import org.ttn.springjpa1.entity.Employee;

 import java.awt.print.Pageable;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findByName(String name);

    List<Employee> findByAgeBetween(int age1, int age2);

    List<Employee> findByNameLike(String name);


}