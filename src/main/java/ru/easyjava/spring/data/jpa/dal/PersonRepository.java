package ru.easyjava.spring.data.jpa.dal;

import ru.easyjava.spring.data.jpa.dal.custom.CommonRepository;
import ru.easyjava.spring.data.jpa.entity.Person;

/**
 * Repository for person entity.
 */
public interface PersonRepository extends CommonRepository<Person, Long> { }
