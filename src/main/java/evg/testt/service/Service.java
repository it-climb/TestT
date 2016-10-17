package evg.testt.service;

import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional
public interface Service<T> {
    List<T> getAll();

    T getById(Integer id);

    void delete(T o);

    void insert(T o);

    void update(T o);

}
