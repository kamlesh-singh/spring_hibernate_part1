package org.ttn.springjpa1.repository;

 import org.springframework.data.repository.PagingAndSortingRepository;
 import org.ttn.springjpa1.entity.Employee;

 import java.awt.print.Pageable;

public interface EmployeePagingAndSorting extends PagingAndSortingRepository<Employee, Integer> {

}