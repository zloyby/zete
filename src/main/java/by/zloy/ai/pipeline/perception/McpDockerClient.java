package by.zloy.ai.pipeline.perception;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Map;

public class McpDockerClient {

    private BufferedWriter writer;
    private BufferedReader reader;
    private final ObjectMapper mapper = new ObjectMapper();

    public void startDockerMcpServer() throws IOException {
        // 1. Запускаем докер в интерактивном режиме
        ProcessBuilder pb = new ProcessBuilder(
                "docker", "run", "-i", "--rm",
                "-e", "DISCORD_TOKEN=ваш_токен",
                "mcp/discord-server"
        );
        Process process = pb.start();
        writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
    }

    public String callTool(String toolName, Map<String, Object> arguments) throws IOException {
        // 2. Формируем JSON-RPC запрос
        Map<String, Object> request = Map.of(
                "jsonrpc", "2.0",
                "id", "1",
                "method", "tools/call",
                "params", Map.of("name", toolName, "arguments", arguments)
        );

        writer.write(mapper.writeValueAsString(request));
        writer.newLine();
        writer.flush();

        // 3. Читаем ответ от MCP сервера
        return reader.readLine();
    }
}
