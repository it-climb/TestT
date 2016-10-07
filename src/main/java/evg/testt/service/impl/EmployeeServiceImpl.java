package evg.testt.service.impl;

import evg.testt.dao.EmployeeDao;
import evg.testt.model.Department;
import evg.testt.model.Employee;
import evg.testt.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by abonent63 on 25.09.16.
 */
@Service
public class EmployeeServiceImpl extends BaseService<Employee, EmployeeDao> implements EmployeeService{
    @Override
    public List<Employee> getByDepartment(Department department) {
        return dao.findByDepartment(department);
    }
}
