package ru.easyjava.spring.data.jpa.dal.custom;

import ru.easyjava.spring.data.jpa.entity.Passport;

import java.util.List;

/**
 * Custom methods of Passport repository.
 */
public interface PassportRepositoryCustom {
    List<Passport> passportOwnedBy(final String lastName);

    List<Passport> passportOwnerStartsWith(final String lastName);
}
