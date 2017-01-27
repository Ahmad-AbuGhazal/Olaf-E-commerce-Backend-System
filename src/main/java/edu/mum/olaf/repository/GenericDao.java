package edu.mum.olaf.repository;

import java.util.List;

public interface GenericDao<T> {

    void save(T t);

    void delete(Long id);

    T findOne(Long id);

    T update(T t);   
    
    List<T> findAll();
    
    
}

