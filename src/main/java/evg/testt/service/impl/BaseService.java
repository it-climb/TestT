package evg.testt.service.impl;

import evg.testt.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLException;
import java.util.List;

public abstract class BaseService <T , P extends JpaRepository<T,Integer>> implements Service<T> {

    protected  P dao;

    @Autowired
    public void setPersistence(P dao){
        this.dao = dao;
    }

    public List<T> getAll()  {
        return dao.findAll();
    }

    public T getById(Integer id) {
        return dao.findOne(id);
    }

    public void delete(T o) {
        dao.delete(o);
    }

     public void insert(T o) {
        dao.save(o);
    }

    public void update(T o)  {
        dao.save(o);
    }
}
