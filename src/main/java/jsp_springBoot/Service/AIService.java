package jsp_springBoot.Service;

import com.openai.client.OpenAIClient;
import com.openai.models.responses.ResponseCreateParams;
import org.springframework.stereotype.Service;

@Service
public class AIService {

    private final OpenAIClient openAIClient;

    public AIService(OpenAIClient openAIClient) {
        this.openAIClient = openAIClient;
    }

    public String askAI(String question) {

        ResponseCreateParams params = ResponseCreateParams.builder()
                .model("gpt-5-mini")
                .input(question)
                .build();

        return openAIClient.responses()
                .create(params)
                .output()
                .stream()
                .flatMap(item -> item.message().stream())
                .flatMap(message -> message.content().stream())
                .flatMap(content -> content.outputText().stream())
                .map(outputText -> outputText.text())
                .collect(java.util.stream.Collectors.joining());
    }
}
