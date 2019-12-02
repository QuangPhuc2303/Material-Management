package com.codegym.service;

import com.codegym.model.Material;
import com.codegym.model.Supplier;

public interface MaterialService {

    Iterable<Material> findAll();

    Material findById(Long id);

    void save(Material material);

    void remove(Long id);

    Iterable<Material> findAllBySupplier(Supplier supplier);
}
