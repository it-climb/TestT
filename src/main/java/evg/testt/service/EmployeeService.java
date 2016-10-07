package evg.testt.service;

import evg.testt.model.Department;
import evg.testt.model.Employee;

import java.util.List;

/**
 * Created by abonent63 on 25.09.16.
 */
public interface EmployeeService extends Service<Employee>{
    List<Employee> getByDepartment(Department department);
}
