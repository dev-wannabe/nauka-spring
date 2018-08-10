package pl.devwannabe.naukaspring.domain.repository;

import pl.devwannabe.naukaspring.domain.Knight;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;
import javax.annotation.PostConstruct;
import java.util.Collection;

public class DBKnightRepository implements KnightRepository {

    @Override
    public void createKnight(String name, int age) {
        System.out.println("I will use the database");
        throw new NotImplementedException();
    }

    @Override
    public void createKnight(Knight knight) {
        System.out.println("I will use the database");
        throw new NotImplementedException();
    }

    @Override
    public Collection<Knight> getAllKnights() {
        System.out.println("I will use the database");
        throw new NotImplementedException();
    }

    @Override
    public Knight getKnight(String name) {
        System.out.println("I will use the database");
        throw new NotImplementedException();
    }

    @Override
    public void deleteKnight(String name) {
        System.out.println("I use a database");
        throw new NotImplementedException();
    }

    @Override
    @PostConstruct
    public void initiateKnights() {
        System.out.println("I use a database");
        throw new NotImplementedException();
    }
}