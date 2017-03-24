package ru.easyjava.spring.data.jpa.dal;

import ru.easyjava.spring.data.jpa.dal.custom.CommonRepository;
import ru.easyjava.spring.data.jpa.dal.custom.PassportRepositoryCustom;
import ru.easyjava.spring.data.jpa.entity.Passport;

/**
 * Repository for passport entity.
 */
public interface PassportRepository extends CommonRepository<Passport, Long>, PassportRepositoryCustom { }
