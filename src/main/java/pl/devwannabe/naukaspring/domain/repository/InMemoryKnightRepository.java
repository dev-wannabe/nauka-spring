package pl.devwannabe.naukaspring.domain.repository;

import pl.devwannabe.naukaspring.domain.Knight;

import javax.annotation.PostConstruct;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static pl.devwannabe.naukaspring.Starter.BLUE;
import static pl.devwannabe.naukaspring.Starter.RESET_COLOR;

public class InMemoryKnightRepository implements KnightRepository {

    private Map<Integer, Knight> knights = new HashMap<>();

    public InMemoryKnightRepository() {

    }
    @Override
    public void createKnight(String name, int age) {
        Knight newKnight = new Knight(name, age);
        newKnight.setId(getNewId());
        knights.put(newKnight.getId(), newKnight);
    }

    @Override
    public void createKnight(Knight knight) {
        knights.put(knight.getId(), knight);
    }

    @Override
    public Collection<Knight> getAllKnights() {
        return knights.values();
    }

    @Override
    public Optional <Knight> getKnight(String name) {
        Optional<Knight> knightByName = knights.values().stream().filter(knight -> knight.getName().equals(name)).findAny();
        return knightByName ;
    }

    @Override
    public void deleteKnight(Integer id) {
        System.out.println(knights);
        System.out.println("Removing " + id);
        knights.remove(id);
    }

    @Override
    @PostConstruct
    public void initiateKnights() {
        System.out.println(BLUE + "The knight was recruited: " +
                RESET_COLOR);
        createKnight("Lancelot", 29);
        createKnight("Percival", 25);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knights.get(id);
    }

    @Override
    public String toString() {
        return "InMemoryKnightRepository{" +
                "knights=" + knights +
                '}';
    }

    private int getNewId() {
        if(knights.isEmpty()){
            return 0;
        } else {
          Integer integer = knights.keySet().stream().max(Integer::max).get();
          return integer +1;
        }
    }
}