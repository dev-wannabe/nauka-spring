package pl.devwannabe.naukaspring.domain.repository;

import pl.devwannabe.naukaspring.domain.Knight;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

public interface KnightRepository {

    void createKnight(String name, int age);

    void createKnight(Knight knight);

    Collection<Knight> getAllKnights();

    Optional<Knight> getKnight(String name);

    void deleteKnight(Integer id);

    void initiateKnights();

    Knight getKnightById(Integer id);

   default void updateKnight(int id, Knight knight) {
       throw new NotImplementedException();
   }

}