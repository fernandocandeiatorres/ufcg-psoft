package com.psoft.atvprat2.repository;

import java.util.List;

public interface LoteRepository<T, ID> {
    T save(T lote);
    T find(ID id);

    List<T> findAll();
    T update(T lote);
    void delete(T lote);
    void deleteAll();
}
