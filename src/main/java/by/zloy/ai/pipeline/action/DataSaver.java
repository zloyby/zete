package by.zloy.ai.pipeline.action;

public class DataSaver {

    public void normalizeAndSave(String json) {
        // Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/games", "user", "pass");
        System.out.printf("Данные '%s' успешно сохранены в БД.", json);
    }
}
