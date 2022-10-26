package org.ttn.springjpa1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;



import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestEntityManager
class EmployeeApplicationTests {

	@Autowired
	EmployeeRepository repository;

	@Autowired
	EmployeePagingAndSorting repo;

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate(){
		Employee employee = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		Employee e4 = new Employee();
		Employee e5 = new Employee();
		employee.setName("Sharda");
		employee.setAge(22);
		employee.setLocation("Delhi");

		e2.setName("Aditya");
		e2.setAge(28);
		e2.setLocation("Saharsa");

		e3.setName("Ashu");
		e3.setAge(29);
		e3.setLocation("Patna");

		e4.setName("Saloni");
		e4.setAge(20);
		e4.setLocation("Mumbai");

		e5.setName("Surbhi");
		e5.setAge(24);
		e5.setLocation("Indore");

		repository.save(employee);
		repository.save(e2);
		repository.save(e3);
		repository.save(e4);
		repository.save(e5);


	}

	@Test
	public void testRead(){
		Employee employee = repository.findById(1).get();
		assertNotNull(employee);
		assertEquals("Sharda", employee.getName());
	}

	@Test
	public void testUpdate(){
		Employee employee = repository.findById(1).get();
		employee.setName("Sneha");
		repository.save(employee);
	}

	@Test
	public void testDelete(){
		if(repository.existsById(1)) {
			repository.deleteById(1);
		}
	}

	@Test
	public void testCount(){
		System.out.println("total records==========>>>>>>>"+repository.count());
	}

	@Test
	public void findByName(){
		List<Employee> employees = repository.findByName("Sharda");
		employees.forEach(e -> System.out.println(e.getLocation()));
	}

	@Test
	public void findByAgeBetween(){
		List<Employee> employees = repository.findByAgeBetween(28,32);
		employees.forEach(e -> System.out.println(e.getName()));
	}

	@Test
	public void findByNameLike(){
		List<Employee> employees = repository.findByNameLike("%A%");
		employees.forEach(e -> System.out.println(e.getName()));
	}

	@Test
	public void testFindAllPagingAndSorting(){
		Pageable pageable =  PageRequest.of(0,2, Sort.Direction.DESC,"age");
		repo.findAll(pageable).forEach(p-> System.out.println(p.getAge()));

	}

}