package com.example.restaurant_practice.db;


import java.util.List;
import java.util.Optional;

public interface MemoryDbIfs<T> {
    Optional<T> findById(int index);
    T save(T entity);
    void deleteById(int index);
    List<T> findAll();
}
