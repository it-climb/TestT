package evg.testt.service;

import evg.testt.model.Department;
import evg.testt.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional
public interface Service<T> {
    List<T> getAll() throws SQLException;

    T getById(Integer id) throws SQLException;

    void delete(T o) throws SQLException;

    void insert(T o) throws SQLException;

    void update(T o) throws SQLException;

}
