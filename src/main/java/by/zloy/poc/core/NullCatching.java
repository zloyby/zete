package by.zloy.poc.core;

import java.util.Objects;

public class NullCatching {

    public static void main(String[] args) {

        User user = new User(null); // user.name == null

        // Fail-fast проверка при входе в метод (бросает NPE с понятным сообщением)
        try {
            Objects.requireNonNull(user.name, "User name must not be null");
        } catch (Exception e) {
            System.out.println("Test 1 : " + e.getMessage());
        }

        // Значение по умолчанию (Java 9+)
        var name = Objects.requireNonNullElse(user.name, "Anonymous as default user");
        System.out.println("Test 2 : " + name);

        // Если переменная равна null, выражение вернёт false без выброса NPE
        if (name instanceof String s) {
            System.out.println("Test 3 : " + s); // Вызовется только если obj != null
        }
        if (user.name instanceof String) {
            System.out.println("Test 4 will never be shown");
        }

        // Обработка null в switch (Java 21)
        switch (user.name) {
            case null -> System.out.println("Test 5 : name is null");
            case String s -> System.out.println("Test 6 : name is " + s);
        }
    }

    record User(String name) {
    }
}
