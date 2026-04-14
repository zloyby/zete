package by.zloy.ai.pipeline;

import by.zloy.ai.pipeline.action.DataSaver;
import by.zloy.ai.pipeline.perception.McpDockerClient;
import by.zloy.ai.pipeline.reasoning.ModelClient;

import java.util.Map;

// Agent - это система, которая может воспринимать среду, рассуждать и действовать для достижения цели.
// Это линейный агент (Pipeline Agent). Он идет по четким шагам 1->2->3.
// Чтобы превратить его в автономного агента, нужно дать ему «петлю рассуждения» (Agentic Loop)
public class OrchestratorAgent {

    public static void main(String[] args) throws Exception {
        // 1. Perception. Получаем данные из Discord через MCP
        McpDockerClient mcpClient = new McpDockerClient();
        mcpClient.startDockerMcpServer();
        String discordData = mcpClient.callTool("get_messages", Map.of("channelId", "12345"));

        // 2. Reasoning. Инициализируем LLM (например, через OpenAI или Claude) и модель рассуждает
        ModelClient modelClient = new ModelClient();
        String extractedJson = modelClient.ask(discordData);

        // 3. Action. На основе вывода LLM ваш код совершает физическое действие в реальном мире
        DataSaver dataSaver = new DataSaver();
        dataSaver.normalizeAndSave(extractedJson);
    }
}
