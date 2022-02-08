package com.bonedone.logosshop.service;

import java.util.List;

public interface BaseService<T> {
    T create(T t);
    T update(T t);
    T delete(T t);
    Long deleteById(Long id);
    T getEntity(Long id);
    List<T> getAll();
}
