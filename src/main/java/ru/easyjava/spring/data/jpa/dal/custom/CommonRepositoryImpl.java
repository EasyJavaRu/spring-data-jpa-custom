package ru.easyjava.spring.data.jpa.dal.custom;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public class CommonRepositoryImpl<T, ID extends Serializable>
        extends SimpleJpaRepository<T, ID> implements CommonRepository<T, ID> {
    public CommonRepositoryImpl(JpaEntityInformation entityInformation, EntityManager em) {
        super(entityInformation, em);
    }

    @Override
    public String idToString(ID id) {
        return id.toString();
    }
}
