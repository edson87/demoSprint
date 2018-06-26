package com.dh.spring5webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.dh.spring5webapp.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
