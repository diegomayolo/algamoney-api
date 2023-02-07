package com.algamoney.api.repository;

import com.algamoney.api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dm
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {}
