package evg.testt.dao;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Calendar;
import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {
    List<Employee> findByDepartment (Department department);
    @Query(value ="select * from employees b where MONTH(b.dateOfBirth) = MONTH(CURDATE())" +
            "AND DAY(b.dateOfBirth) = DAY(CURDATE())", nativeQuery = true)
    List<Employee> Birthday ();
}
//value = "select * from #{#entityName} b where b.name=?1", nativeQuery = true

//SELECT *
//        FROM Employees
//        WHERE DATEPART(d, ?1) = DATEPART(d, GETDATE())
//        AND DATEPART(m, ?1) = DATEPART(m, GETDATE())

