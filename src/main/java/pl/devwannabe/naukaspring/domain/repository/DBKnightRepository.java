package pl.devwannabe.naukaspring.domain.repository;

import org.springframework.stereotype.Repository;
import pl.devwannabe.naukaspring.domain.Knight;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.annotation.PostConstruct;
import java.util.Collection;

import static pl.devwannabe.naukaspring.Starter.BLUE;
import static pl.devwannabe.naukaspring.Starter.RESET_COLOR;


public class DBKnightRepository implements KnightRepository {

    @Override
    public void createKnight(String name, int age) {
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

    }
}