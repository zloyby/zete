package by.zloy.poc.core.optional;

import java.util.Optional;

public class OptionalAntiPatterns {

    public static void main(String[] args) {
        OptionalAntiPatterns optionalAntiPatterns = new OptionalAntiPatterns();
        optionalAntiPatterns.run();
    }

    private void run() {
        var id = "11";
        var emptyRepo = new Repository();

        // ПАТТЕРН Выброс исключения, если значения нет
        try {
            emptyRepo.getById(id).orElseThrow(() -> new Exception("User not found"));
        } catch (Exception e) {
            System.out.println("Test 1 : Exception = " + e.getMessage());
        }

        // АНТИПАТТЕРН
        /**
        name = emptyRepo.getById(id).get().name; // Выбросит исключение, если user пуст!
        */

        // ПАТТЕРН Пустой user не свалится при map
        var name = emptyRepo.getById(id).map(User::name).map(String::toLowerCase).orElse("Test 2 name");
        System.out.println("Test 2 : " + name);

        // АНТИПАТТЕРН
        /**
        var optional = emptyRepo.getById(id);
        if (optional.isPresent()) {
            processUser(optional.get());
        } else {
            runFallback(); // сработает, но надо избавиться от if-else
        }
        */

        // ПАТТЕРН ^^
        emptyRepo.getById(id).ifPresentOrElse(this::processUser, this::runFallback);
        emptyRepo.getByIdReally(id).ifPresentOrElse(this::processUser, this::runFallback);

        // АНТИПАТТЕРН runQueryAgain() всегда вызовется, даже когда есть не пустой exist45
        Optional<User> empty45 = emptyRepo.getById(id);
        Optional<User> exist45 = emptyRepo.getByIdReally(id);
        var user = empty45.orElse(runQueryAgain());
        System.out.println("Test 4 : " + user.name);
        user = exist45.orElse(runQueryAgain());
        System.out.println("Test 5 : " + user.name);

        // ПАТТЕРН ^^ runQueryAgain() не вызовется, когда есть не пустой exist45
        user = empty45.orElseGet(this::runQueryAgain);
        System.out.println("Test 6 : " + user.name);
        user = exist45.orElseGet(this::runQueryAgain);
        System.out.println("Test 7 : " + user.name);
    }

    private User runQueryAgain() {
        return new User("22", "Retry name");
    }

    private void runFallback() {
        System.out.println("Fallback step");
    }

    private void processUser(User user) {
        System.out.println("Process right user " + user.name);
    }

    record Repository() {
        public Optional<User> getById(String id) {
            return Optional.empty();
        }
        public Optional<User> getByIdReally(String id) {
            return Optional.of(new User(id, "New name"));
        }
    }

    record User(String id, String name) {
    }
}
