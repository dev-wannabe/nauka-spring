package pl.devwannabe.naukaspring.domain.repository;

import org.springframework.stereotype.Repository;
import pl.devwannabe.naukaspring.domain.Knight;

import javax.annotation.PostConstruct;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static pl.devwannabe.naukaspring.Starter.BLUE;
import static pl.devwannabe.naukaspring.Starter.RESET_COLOR;

@Repository
public class KnightRepository {

    Map<String, Knight> knights = new HashMap<>();

    public KnightRepository() {

    }

    public void createKnight(String name, int age) {
        knights.put(name, new Knight(name, age));
    }

    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    public Knight getKnight(String name) {
        return knights.get(name);
    }

    public void deleteKnight(String name) {
        knights.remove(name);
    }

    @PostConstruct
    public void build() {
        System.out.println(BLUE + "The knight was recruited: " +
                RESET_COLOR);
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @Override
    public String toString() {
        return "KnightRepository{" +
                "knights=" + knights +
                '}';
    }
}
