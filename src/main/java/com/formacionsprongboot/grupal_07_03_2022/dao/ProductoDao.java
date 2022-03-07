package com.formacionsprongboot.grupal_07_03_2022.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.formacionsprongboot.grupal_07_03_2022.entity.Producto;




@Repository
public interface ProductoDao extends CrudRepository<Producto,Long>{

}
