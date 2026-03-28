package by.zloy.boardgames;

import java.util.*;

public class ParallelGameScheduler {

    static class Game {
        String name;
        int maxPlayers;
        int duration; // in hours

        public Game(String name, int maxPlayers, int duration) {
            this.name = name;
            this.maxPlayers = maxPlayers;
            this.duration = duration;
        }
    }

    static class Person {
        String name;
        List<String> selectedGames;

        public Person(String name, List<String> selectedGames) {
            this.name = name;
            this.selectedGames = selectedGames;
        }
    }

    static class ScheduledGame {
        String gameName;
        List<String> players;
        int startSlot;
        int duration;

        public ScheduledGame(String gameName, List<String> players, int startSlot, int duration) {
            this.gameName = gameName;
            this.players = players;
            this.startSlot = startSlot;
            this.duration = duration;
        }
    }

    static final int TOTAL_HOURS = 16;
    static final int SLOT_DURATION = 1; // 1 hour slots
    static final int TOTAL_SLOTS = TOTAL_HOURS / SLOT_DURATION;

    public static void main(String[] args) {
        Map<String, Game> games = new HashMap<>();
        games.put("NEMEZIDA", new Game("NEMEZIDA", 5, 4));
        games.put("DUNE", new Game("DUNE", 6, 4));
        games.put("MANSIONS", new Game("MANSIONS", 5, 4));
        games.put("DRACULA", new Game("DRACULA", 5, 4));
        games.put("CRYO", new Game("CRYO", 4, 3));
        games.put("TZOLKIN", new Game("TZOLKIN", 4, 3));
        games.put("THROUGH_THE_AGES", new Game("THROUGH_THE_AGES", 4, 4));
        games.put("DUNGEON_PETS", new Game("DUNGEON_PETS", 4, 4));
        games.put("MARS", new Game("MARS", 5, 3));
        games.put("GOT", new Game("GOT", 6, 5));
        games.put("INIS", new Game("INIS", 4, 3));
        games.put("ROOT", new Game("ROOT", 4, 3));

        List<Person> players = Arrays.asList(
                new Person("Стас", Arrays.asList("DUNE", "MARS", "GOT", "DRACULA")),
                new Person("Олег", Arrays.asList("CRYO", "DUNE", "MARS", "MANSIONS")),
                new Person("Никита", Arrays.asList("NEMEZIDA", "DRACULA", "MANSIONS", "DUNE")),
                new Person("Кирилл", Arrays.asList("TZOLKIN", "DRACULA", "MARS", "THROUGH_THE_AGES")),
                new Person("Эд", Arrays.asList("NEMEZIDA", "CRYO", "GOT", "DUNE")),
                new Person("Илья", Arrays.asList("NEMEZIDA", "DUNGEON_PETS", "THROUGH_THE_AGES", "TZOLKIN")),
                new Person("Антон", Arrays.asList("NEMEZIDA", "ROOT", "DUNGEON_PETS", "DUNE")),
                new Person("Женя", Arrays.asList("NEMEZIDA", "INIS", "MANSIONS", "DRACULA"))
        );

        Map<String, List<String>> gameToPlayers = new HashMap<>();
        for (Person p : players) {
            for (String game : p.selectedGames) {
                gameToPlayers.computeIfAbsent(game, k -> new ArrayList<>()).add(p.name);
            }
        }

        List<ScheduledGame> schedule = new ArrayList<>();
        Map<String, boolean[]> playerBusy = new HashMap<>();
        for (Person p : players) {
            playerBusy.put(p.name, new boolean[TOTAL_SLOTS]);
        }

        for (String gameName : gameToPlayers.keySet()) {
            Game game = games.get(gameName);
            List<String> gamePlayers = new ArrayList<>(gameToPlayers.get(gameName));
            Queue<String> queue = new LinkedList<>(gamePlayers);

            while (!queue.isEmpty()) {
                List<String> group = new ArrayList<>();
                while (!queue.isEmpty() && group.size() < game.maxPlayers) {
                    group.add(queue.poll());
                }

                outer:
                for (int slot = 0; slot <= TOTAL_SLOTS - game.duration; slot++) {
                    boolean allFree = true;
                    for (String p : group) {
                        for (int d = 0; d < game.duration; d++) {
                            if (playerBusy.get(p)[slot + d]) {
                                allFree = false;
                                break;
                            }
                        }
                        if (!allFree) break;
                    }

                    if (allFree) {
                        for (String p : group) {
                            for (int d = 0; d < game.duration; d++) {
                                playerBusy.get(p)[slot + d] = true;
                            }
                        }
                        schedule.add(new ScheduledGame(gameName, group, slot, game.duration));
                        break outer;
                    }
                }
            }
        }

        schedule.sort(Comparator.comparingInt(g -> g.startSlot));
        for (ScheduledGame g : schedule) {
            System.out.printf("С %02d:00 до %02d:00 — %s: %s\n",
                    g.startSlot, g.startSlot + g.duration,
                    g.gameName, String.join(", ", g.players));
        }
    }
}