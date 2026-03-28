package by.zloy.boardgames.unmatched;

import java.util.ArrayList;
import java.util.List;

public class Drafter {

    public static void main(String[] args) {

        // Elektra Bigfoot SunWukong Yennenga Achilles She-Hulk
        Hero achilles = new Hero("Achilles", new int[] {83, 53, 78, 58, -2, 45} );
        Hero bigfoot = new Hero("Bigfoot", new int[] {92, -2, 82, 62, 47, 46});
        Hero electra = new Hero("Electra", new int[] {-2, 8, 14, 17, 17, 44});
        Hero wukong = new Hero("Sun Wukong", new int[] {86, 18, -2, 63, 22, 51});
        Hero yennenga = new Hero("Yennenga", new int[] {83, 38, 37, -2, 42, 62});
        Hero shehulk = new Hero("She-Hulk", new int[] {56, 54, 49, 38, 55, -2});

        List<Hero> allHeroes = new ArrayList<>();
        allHeroes.add(achilles);
        allHeroes.add(bigfoot);
        allHeroes.add(electra);
        allHeroes.add(wukong);
        allHeroes.add(yennenga);
        allHeroes.add(shehulk);

        List<Hero> myHeroes = new ArrayList<>(); //no bigfoot
        myHeroes.add(achilles);
        myHeroes.add(electra);
        myHeroes.add(wukong);
        myHeroes.add(yennenga);
        myHeroes.add(shehulk);

        Drafter drafter = new Drafter();
        drafter.calculate(achilles, 2, allHeroes, myHeroes);
        drafter.calculate(achilles, 1, allHeroes, myHeroes);
        drafter.calculate(null, 1, allHeroes, myHeroes);
    }

    private void calculate(Hero hero, int amount, List<Hero> allHeroes, List<Hero> myHeroes) {

    }
}
