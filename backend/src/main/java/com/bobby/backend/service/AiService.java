package com.bobby.backend.service;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiService {


    private ChatClient chatClient;

    public AiService(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    public String getHealthAnalysis(List<String> ingredients) {
        String prompt = "Based on the following ingredients, please provide a health analysis of the product. " +
                "Consider the presence of any harsh chemicals or unhealthy additives. " +
                "Ingredients: " + String.join(", ", ingredients);

        return chatClient.prompt().user(prompt).call().content();
    }
}