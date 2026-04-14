package by.zloy.ai.pipeline.reasoning;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;

public class ModelClient {

    public String ask(String discordData) {
        ChatModel model = GoogleAiGeminiChatModel
                .builder()
                .apiKey("ваш_ключ")
                .build();
        String prompt = "Извлеки названия настольных игр и краткое описание из текста: " +
                discordData + ". Верни ответ в формате JSON: [{name: '', info: ''}]";

        String extractedJson = model.chat(prompt);
        System.out.println("LLM выделила игры: " + extractedJson);
        return extractedJson;
    }
}
