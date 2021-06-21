package com.project.professor.allocation.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestPropertySource;

import com.project.professor.allocation.entity.Department;
//import com.project.professor.allocation.entity.Allocation;
//import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.entity.Department;
import com.project.professor.allocation.entity.Professor;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
@TestPropertySource(locations = "classpath:application.properties")
class ProfessorRepositoryTest {

	@Autowired
	private ProfessorRepository professorRepository;
	private DepartmentRepository departmentRepository;

	//READ
	@Test
	public void findAll() {
		
		//Act
		List<Professor> professors = professorRepository.findAll();
		
		//Print
		System.out.println(professors);
		
	}
	
	@Test
	public void findById() {
		//Arrange
		Long id = 1L;
		
		//Act
		Professor professor = professorRepository.findById(id).orElse(null);
		
		//Print
		System.out.println(professor);
	}

	@Test
	public void findByName() {
		
		//Arrange
		String name = "professor";
		
		//Act
		List<Professor> professors = professorRepository.findByNameContainingIgnoreCase(name);
		
		//Print
		
		professors.forEach(System.out::println);
	}
		
	//Save_Create	
	
	  @Test
	    public void save_create() {
	        // Arrange
	        Department department = new Department();
	        department.setId(1L);

	        Professor professor = new Professor();
	        professor.setId(null);
	        professor.setName("Professor 211");
	        professor.setCpf("111.111.221-11");
	        professor.setDepartment(department);

	        // Act
	        Professor newProfessor = professorRepository.save(professor);
	        Long departmentId = newProfessor.getDepartment().getId();
	        
	        Department newDepartment = departmentRepository.findById(departmentId).orElse(null);
	        newProfessor.setDepartment(newDepartment);

	        // Print 
	        System.out.println(professor);
	    }

	    @Test
	    public void save_update() {
	        // Arrange
	        Department department = new Department();
	        department.setId(1L);

	        Professor professor = new Professor();
	        professor.setId(1L);
	        professor.setName("Professor 2");
	        professor.setCpf("222.222.222-22");
	        professor.setDepartment(department);

	        // Act
	        professor = professorRepository.save(professor);

	        // Print
	        System.out.println(professor);
	    }
		
		

	    @Test
	    public void deleteById() {
	        // Arrange
	        Long id = 2L;

	        // Act
	        professorRepository.deleteById(id);
	    }
	
}
