package com.algamoney.api.repository;

import com.algamoney.api.model.People;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dm
 */
public interface PeopleRepository extends JpaRepository<People, Long> {}
