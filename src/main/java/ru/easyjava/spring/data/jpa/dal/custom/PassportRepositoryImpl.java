package ru.easyjava.spring.data.jpa.dal.custom;

import org.springframework.stereotype.Repository;
import ru.easyjava.spring.data.jpa.entity.Passport;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class PassportRepositoryImpl implements PassportRepositoryCustom {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public List<Passport> passportOwnedBy(final String lastName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Passport> passportOwnerCriteria = cb.createQuery(Passport.class);
        Root<Passport> ownerPassportRoot = passportOwnerCriteria.from(Passport.class);
        passportOwnerCriteria.select(ownerPassportRoot);
        passportOwnerCriteria.where(cb.equal(ownerPassportRoot.get("owner").get("lastName"), lastName));
        return em.createQuery(passportOwnerCriteria)
                .getResultList();
    }

    @Override
    public List<Passport> passportOwnerStartsWith(String lastName) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Passport> passportLikeCriteria = cb.createQuery(Passport.class);
        Root<Passport> likePassportRoot = passportLikeCriteria.from(Passport.class);
        passportLikeCriteria.select(likePassportRoot);
        passportLikeCriteria.where(cb.like(likePassportRoot.get("owner").get("lastName"), lastName+"%"));
        return em.createQuery(passportLikeCriteria)
                .getResultList();

    }
}
