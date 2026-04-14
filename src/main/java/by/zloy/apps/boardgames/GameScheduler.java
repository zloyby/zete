package by.zloy.apps.boardgames;

import java.util.*;

public class GameScheduler {

    public enum Game {
        NEMEZIDA("Немезида", 5, "3–5 часов"),
        DUNE("Дюна", 6, "3–5 часов"),
        MANSIONS("Особняки безумия", 5, "3–5 часов"),
        DRACULA("Дракула", 5, "3–5 часов"),
        CRYO("Крио", 4, "2–3 часа"),
        TZOLKIN("Тзолкин", 4, "1.5–3 часа"),
        THROUGH_THE_AGES("Сквозь века", 4, "3–5 часов"),
        DUNGEON_PETS("Питомцы подземелий", 4, "3–5 часов"),
        MARS("Марс", 5, "2–4 часа"),
        GOT("Игра престолов", 6, "3–6 часов"),
        INIS("Иниш", 4, "2–4 часа"),
        ROOT("Корни", 4, "2–4 часа");

        private final String displayName;
        private final int maxPlayers;
        private final String duration;

        Game(String displayName, int maxPlayers, String duration) {
            this.displayName = displayName;
            this.maxPlayers = maxPlayers;
            this.duration = duration;
        }

        public String getDisplayName() {
            return displayName;
        }

        public int getMaxPlayers() {
            return maxPlayers;
        }

        public String getDuration() {
            return duration;
        }

        public int getMaxDurationHours() {
            // Парсит максимальное значение из строки вроде "3–5 часов"
            try {
                String[] parts = duration.split("–");
                String maxPart = parts[1].replaceAll("[^\\d.]", ""); // Удалить "часов"
                return Integer.parseInt(maxPart);
            } catch (Exception e) {
                return 0; // безопасный фоллбэк
            }
        }
    }

    static class Person {
        String name;
        List<Game> chosenGames;

        Person(String name, List<Game> chosenGames) {
            this.name = name;
            this.chosenGames = chosenGames;
        }
    }

    static class Session {
        Game game;
        List<String> players;
        int slot;

        Session(Game game, List<String> players, int slot) {
            this.game = game;
            this.players = players;
            this.slot = slot;
        }
    }

    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Стас", Arrays.asList(Game.DUNE, Game.MARS, Game.GOT, Game.DRACULA)),
                new Person("Олег", Arrays.asList(Game.CRYO, Game.DUNE, Game.MARS, Game.MANSIONS)),
                new Person("Никита", Arrays.asList(Game.NEMEZIDA, Game.DRACULA, Game.MANSIONS, Game.DUNE)),
                new Person("Кирилл", Arrays.asList(Game.TZOLKIN, Game.DRACULA, Game.MARS, Game.THROUGH_THE_AGES)),
                new Person("Эд", Arrays.asList(Game.NEMEZIDA, Game.CRYO, Game.GOT, Game.DUNE)),
                new Person("Илья", Arrays.asList(Game.NEMEZIDA, Game.DUNGEON_PETS, Game.THROUGH_THE_AGES, Game.TZOLKIN)),
                new Person("Антон", Arrays.asList(Game.NEMEZIDA, Game.ROOT, Game.DUNGEON_PETS, Game.DUNE)),
                new Person("Женя", Arrays.asList(Game.NEMEZIDA, Game.INIS, Game.MANSIONS, Game.DRACULA))
        );

        Map<String, Set<Integer>> personToSlots = new HashMap<>();
        for (Person p : people) {
            personToSlots.put(p.name, new HashSet<Integer>());
        }

        Map<Game, List<String>> gameToPlayers = new HashMap<>();
        for (Person p : people) {
            for (Game game : p.chosenGames) {
                if (!gameToPlayers.containsKey(game)) {
                    gameToPlayers.put(game, new ArrayList<String>());
                }
                gameToPlayers.get(game).add(p.name);
            }
        }

        List<Session> allSessions = new ArrayList<>();
        int slotCounter = 1;

        for (Map.Entry<Game, List<String>> entry : gameToPlayers.entrySet()) {
            Game game = entry.getKey();
            List<String> players = new ArrayList<>(entry.getValue());
            Set<String> assigned = new HashSet<>();

            while (assigned.size() < players.size()) {
                List<String> group = new ArrayList<>();
                int slot = slotCounter++;

                for (String player : players) {
                    if (assigned.contains(player)) continue;
                    if (group.size() >= game.getMaxPlayers()) break;

                    Set<Integer> usedSlots = personToSlots.get(player);
                    if (!usedSlots.contains(slot)) {
                        boolean conflict = false;
                        for (String p : group) {
                            if (personToSlots.get(p).contains(slot)) {
                                conflict = true;
                                break;
                            }
                        }
                        if (!conflict) {
                            group.add(player);
                            assigned.add(player);
                            personToSlots.get(player).add(slot);
                        }
                    }
                }

                if (!group.isEmpty()) {
                    allSessions.add(new Session(game, group, slot));
                }
            }
        }

        // Группировка по играм
        Map<Game, Set<String>> outputByGame = new HashMap<>();
        for (Session session : allSessions) {
            outputByGame.computeIfAbsent(session.game, k -> new LinkedHashSet<>()).addAll(session.players);
        }

        // Сортировка по количеству игроков и макс. времени
        List<Map.Entry<Game, Set<String>>> sorted = new ArrayList<>(outputByGame.entrySet());
        Collections.sort(sorted, new Comparator<Map.Entry<Game, Set<String>>>() {
            @Override
            public int compare(Map.Entry<Game, Set<String>> o1, Map.Entry<Game, Set<String>> o2) {
                int cmpPlayers = Integer.compare(o2.getValue().size(), o1.getValue().size());
                if (cmpPlayers != 0) return cmpPlayers;
                return Integer.compare(o2.getKey().getMaxDurationHours(), o1.getKey().getMaxDurationHours());
            }
        });

        // Вывод
        System.out.println("Распределение по играм (сортировка по количеству игроков и длительности):\n");
        for (Map.Entry<Game, Set<String>> entry : sorted) {
            System.out.println(entry.getKey().getDisplayName() + " (" + entry.getKey().getDuration() + ") – " +
                    String.join(", ", entry.getValue()) + " ;");
        }
    }
}