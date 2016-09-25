package evg.testt.service.impl;

import evg.testt.dao.EmployeeDao;
import evg.testt.model.Employee;
import evg.testt.service.EmployeeService;
import org.springframework.stereotype.Service;

/**
 * Created by abonent63 on 25.09.16.
 */
@Service
public class EmployeeServiceImpl extends BaseService<Employee, EmployeeDao> implements EmployeeService{
}
