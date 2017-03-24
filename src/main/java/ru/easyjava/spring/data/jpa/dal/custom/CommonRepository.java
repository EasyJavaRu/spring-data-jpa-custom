package ru.easyjava.spring.data.jpa.dal.custom;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Shared repository base.
 */
@NoRepositoryBean
public interface CommonRepository<T, ID extends Serializable> extends CrudRepository<T, ID>{
    String idToString(ID id);
}
