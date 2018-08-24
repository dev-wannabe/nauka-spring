package pl.devwannabe.naukaspring.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.devwannabe.naukaspring.domain.PlayerInformation;
import pl.devwannabe.naukaspring.domain.Quest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PlayerInformationRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createPlayerInformation(PlayerInformation playerInformation) {
        playerInformation = new PlayerInformation();
        em.persist(playerInformation);
    }

    public PlayerInformation getFirst() {
        return em.createQuery("from PlayerInformation", PlayerInformation.class)
                .getResultList().get(0);
    }
}
