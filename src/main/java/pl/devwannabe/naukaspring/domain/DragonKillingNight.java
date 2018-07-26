package pl.devwannabe.naukaspring.domain;

public class DragonKillingNight {
    private String name;
    private int age;
    private Quest quest;

    public DragonKillingNight(String name, int age) {
        this.name = name;
        this.age = age;
        this.quest = new Quest("Zabij smoka");
    }

    @Override
    public String toString() {
        return "Rycerz o imieniu " + name +
                "(" + age + ") - aktualne zadanie: \n" + quest + ".";
    }

}
