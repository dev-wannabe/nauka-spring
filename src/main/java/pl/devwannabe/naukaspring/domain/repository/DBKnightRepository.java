package pl.devwannabe.naukaspring.domain.repository;

import org.springframework.transaction.annotation.Transactional;
import pl.devwannabe.naukaspring.domain.Knight;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.Optional;

import static pl.devwannabe.naukaspring.Starter.BLUE;
import static pl.devwannabe.naukaspring.Starter.RESET_COLOR;

public class DBKnightRepository implements KnightRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void createKnight(String name, int age) {
        Knight knight = new Knight(name, age);
        em.persist(knight);

    }

    @Override
    @Transactional
    public void createKnight(Knight knight) {
        em.persist(knight);
    }

    @Override
    @Transactional
    public void updateKnight(int id, Knight knight) {
        em.merge(knight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return em.createQuery("from Knight", Knight.class).getResultList();
    }

    @Override
    public Optional<Knight> getKnight(String name) {
        Knight knightByName = em.createQuery("from Knight k where k.name=:name", Knight.class)
                .setParameter("name", name).getSingleResult();
        return Optional.ofNullable(knightByName);
    }

    @Override
    @Transactional
    public void deleteKnight(Integer id) {
        em.remove(getKnightById(id));
    }

    @Override
    public void initiateKnights() {

    }

    @Override
    public Knight getKnightById(Integer id) {
        return em.find(Knight.class, id);
    }
}