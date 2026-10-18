package by.zloy.apps.boardgames;

import java.util.*;

/**
 Every person has his own preferences, and vote for 4 best games for him, first voted game is more important.
 We want to play X hours (usually 24h), minimizing the time of inactivity.
 Every game has a time in hours - for how long prolonged.
 Every game has a maximum number of gamers, who can play at the same time.
 Player cannot play a lot of games at the same period of time, only one game, so there are no overlaps.
 Need to find optimal match between person and game, to satisfy most persons per their votes.

 The result should be like:
 Person1 (he likes Game1, Game2, Game3, Game4) - plays Game1 from 0:00 till 12:00; Game2 from 12:00 till 14:00; Game3 from 16:00 till 22:00 = total is 22 hours
 Person2 (he likes Game1, Game5, Game4, Game3) - plays Game1 from 0:00 till 12:00; Game4 from 12:00 till 15:00; Game3 from 16:00 till 22:00 = total is 23 hours
 ... and so on.
 */
public class GameScheduler {

    public enum Game {
        NEMESIS("Немезида", 5, "3–5 часов"),
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
            // Simplification: assuming the number before the first dash/space is the minimum duration in hours.
            // E.g., "3–5 часов" -> 3, "1.5–3 часа" -> 1
            String cleanDuration = this.duration.split("–")[0].trim().replaceAll("\\s+", "");
            if (cleanDuration.contains(".")) {
                // Handle fractional hours (e.g., 1.5 hours) by rounding up to ensure time slot reservation is conservative
                return (int) Math.ceil(Double.parseDouble(cleanDuration));
            }
            return Integer.parseInt(cleanDuration);
        }
    }

    // --- ADDED: Custom Person class for preferences ---
    static class Person {
        private final String name;
        private final List<Game> preferences; // Ranked preferences (Rank 1 is highest)

        public Person(String name, List<Game> preferences) {
            this.name = name;
            this.preferences = preferences;
        }

        public String getName() {
            return name;
        }

        public List<Game> getPreferences() {
            return preferences;
        }
    }

    // --- ADDED: Custom Session class to track time slots ---
    static class Session {
        private final String gameName;
        private final Game game;
        private final int startTime;
        private final int endTime;
        private final List<Person> participants;

        public Session(String gameName, Game game, int startTime, int endTime, List<Person> participants) {
            this.gameName = gameName;
            this.game = game;
            this.startTime = startTime;
            this.endTime = endTime;
            this.participants = participants;
        }

        public String getGameName() { return gameName; }
        public Game getGame() { return game; }
        public int getStartTime() { return startTime; }
        public int getEndTime() { return endTime; }
        public List<Person> getParticipants() { return participants; }
    }


    public static void main(String[] args) {
        // 1. Define People and Preferences (SAMPLE DATA for demonstration)
        // NOTE: Since actual input data for people preferences was not provided, sample data is used to demonstrate the scheduling logic.
        List<Person> people = new ArrayList<>();
        // Person1: NEMEZIDA (Rank 1) > DUNE (Rank 2) > MANSIONS (Rank 3) > DRACULA (Rank 4)
        people.add(new Person("Person1", Arrays.asList(Game.NEMESIS, Game.DUNE, Game.MANSIONS, Game.DRACULA)));
        // Person2: DUNE (Rank 1) > NEMEZIDA (Rank 2) > MANSIONS (Rank 3) > CRYO (Rank 4)
        people.add(new Person("Person2", Arrays.asList(Game.DUNE, Game.NEMESIS, Game.MANSIONS, Game.CRYO)));
        // Person3: DRACULA (Rank 1) > NEMEZIDA (Rank 2) > DUNE (Rank 3) > MANSIONS (Rank 4)
        people.add(new Person("Person3", Arrays.asList(Game.DRACULA, Game.NEMESIS, Game.DUNE, Game.MANSIONS)));

        // 2. Initialization
        int totalHours = 24;
        
        // Maps Game -> List of allocated sessions
        Map<Game, List<Session>> gameSchedules = new HashMap<>();
        // Tracks player availability: Person -> Set of occupied time slots (hours 0-23)
        Map<Person, Set<Integer>> playerAvailability = new HashMap<>();

        for (Game game : Game.values()) {
            gameSchedules.put(game, new ArrayList<>());
        }
        for (Person person : people) {
            playerAvailability.put(person, new HashSet<>());
        }
        
        // 3. Scheduling Loop (Greedy prioritization: Person Rank 1, then Game Capacity, then Time)
        // Iterate through every possible start hour slot (0 to 23)
        for (int startTime = 0; startTime < totalHours; startTime++) {
            
            // Potential assignment for this time slot: Map<Game, List<Person>>
            Map<Game, List<Person>> potentialGameAssignments = new HashMap<>();
            for (Game game : Game.values()) {
                potentialGameAssignments.put(game, new ArrayList<>());
            }
            
            // Check each person to find their highest ranked, available game at this time
            for (Person person : people) {
                
                for (Game preferredGame : person.getPreferences()) {
                    
                    int duration = preferredGame.getMaxDurationHours();
                    int endTime = startTime + duration;
                    
                    // Check time constraints (must finish within 24h) and player availability
                    if (endTime <= totalHours && !playerAvailability.get(person).contains(startTime)) {
                        
                        // Capacity Check: Count running instances that overlap with startTime
                        int currentInstances = 0;
                        for(Session session : gameSchedules.get(preferredGame)) {
                            // Overlap occurs if session starts before or at startTime AND ends after startTime
                            if (session.getStartTime() <= startTime && session.getEndTime() > startTime) {
                                currentInstances++;
                            }
                        }
                        
                        // If capacity allows
                        if (currentInstances < preferredGame.getMaxPlayers()) {
                            potentialGameAssignments.get(preferredGame).add(person);
                            break; // Person is assigned to their highest ranked available game
                        }
                    }
                }
            }

            // 4. Commit Assignments for this time slot
            for (Game game : Game.values()) {
                List<Person> playersForGame = potentialGameAssignments.get(game);

                if (!playersForGame.isEmpty()) {
                    
                    int duration = game.getMaxDurationHours();
                    
                    Session newSession = new Session(
                        game.getDisplayName(), 
                        game, 
                        startTime, 
                        startTime + duration, 
                        playersForGame
                    );
                    
                    gameSchedules.get(game).add(newSession);
                    
                    // Mark all involved people as busy for the duration
                    for (Person person : playersForGame) {
                        for (int t = startTime; t < startTime + duration; t++) {
                            playerAvailability.get(person).add(t);
                        }
                    }
                }
            }
        }

        // 5. Generate Output
        System.out.println("\n--- Optimal Game Schedule (24 Hours) ---");
        
        for (Person person : people) {
            // Filter sessions for this person
            List<Session> personSessions = gameSchedules.values().stream()
                    .flatMap(List::stream)
                    .filter(s -> s.getParticipants().contains(person))
                    .toList();

            double totalHoursOfPerson = personSessions.stream()
                    .mapToDouble(s -> s.getEndTime() - s.getStartTime())
                    .sum();
            
            System.out.printf("\n%s (Total Hours: %.1f)\n", person.getName(), totalHoursOfPerson);
            
            // Sort sessions by start time for clean output
            personSessions.stream()
                    .sorted(Comparator.comparingInt(Session::getStartTime))
                    .forEach(session -> {
                        System.out.printf("  - Plays %s from %02d:00 till %02d:00\n", 
                            session.getGameName(), 
                            session.getStartTime(), 
                            session.getEndTime());
                    });
        }
    }
}