package com.codegym.cms.repository.imp;

import com.codegym.cms.model.User;
import com.codegym.cms.repository.UserRepository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@SuppressWarnings("All")
@Transactional
public class UserRepositoryImp implements UserRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        Query query = em.createNamedQuery("findAll");
        return query.getResultList();
    }

    @Override
    public User findById(Long id) {
        TypedQuery<User> query = (TypedQuery<User>) em.createNamedQuery("findById");
        query.setParameter("id",id);
        try{
        return query.getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public void save(User model) {
        if (model.getId() != null){
            em.merge(model);
        } else {
            em.persist(model);
        }

    }

    @Override
    public void remove(Long id) {
        User user = findById(id);
        if (user != null){
            em.remove(user);
        }
    }
}
