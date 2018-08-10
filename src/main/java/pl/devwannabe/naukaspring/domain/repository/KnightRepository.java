package pl.devwannabe.naukaspring.domain.repository;

import pl.devwannabe.naukaspring.domain.Knight;

import java.util.Collection;

public interface KnightRepository {

    void createKnight(String name, int age);

    void createKnight(Knight knight);

    Collection<Knight> getAllKnights();

    Knight getKnight(String name);

    void deleteKnight(String name);

    void initiateKnights();
}
