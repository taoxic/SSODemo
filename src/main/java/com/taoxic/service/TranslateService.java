package com.taoxic.service;

import com.google.gson.Gson;
import com.taoxic.data.Parameters;
import com.taoxic.data.QwenTranslateContentRequest;
import com.taoxic.data.TranslateInput;
import com.taoxic.data.TranslateOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class TranslateService {

    private static final URI TRANSLATE_URL = URI.create("https://dashscope.aliyuncs.com/api/v1/services/aigc/text-generation/generation");

    @Autowired
    private RestTemplate restTemplate;

    public String translate(String address, String apikey, String targetLanguage, String sourceText, String prompt) {
        RequestEntity<QwenTranslateContentRequest> requestEntity = null;
        QwenTranslateContentRequest qwenTranslateContentRequest = new QwenTranslateContentRequest();
        TranslateInput input = new TranslateInput();
        input.setPrompt(String.format(prompt,targetLanguage,sourceText));
        qwenTranslateContentRequest.setInput(input);
        qwenTranslateContentRequest.setParameters(new Parameters(0.1f, 0.1f));
        System.out.println("qwenTranslateContentRequest:"+qwenTranslateContentRequest.toString());
        try {
            requestEntity = RequestEntity.post(TRANSLATE_URL)
                    .header("Authorization", "Bearer "+apikey)
                    //.header("cache-control", "no-cache")
                    .header("content-type", "application/json")
                    .body(qwenTranslateContentRequest);
        } catch ( Exception e) {
            System.err.println("UnsupportedEncodingException: " + e.getMessage());
        }
        ResponseEntity<String> result = restTemplate.exchange(requestEntity, String.class);
        System.out.println("result: " + result.getBody());
        Gson gson = new Gson();
        TranslateOutput output = gson.fromJson(result.getBody(), TranslateOutput.class);
        return output.getOutput().getText();
    }
}
