package com.taoxic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;

@Service
public class TranslateService {

    private static final URI TRANSLATE_URL = URI.create("https://translate.alibaba.com/api/translate/text");

    @Autowired
    private RestTemplate restTemplate;

    public String translate(String address, String apikey, String targetLanguage, String sourceText, String prompt) {
        RequestEntity<String> requestEntity = null;
        try {
            requestEntity = RequestEntity.post(TRANSLATE_URL)
                    .header("authority", "translate.alibaba.com")
                    .header("cache-control", "no-cache")
                    .header("content-type", "application/x-www-form-urlencoded")
                    .body("srcLang=zh&tgtLang=en&query="+ URLEncoder.encode(sourceText, "UTF-8") +"&domain=general&_csrf=d5db4f4e-3413-4bb0-bb25-8dca994c8973");
        } catch (UnsupportedEncodingException e) {
            System.err.println("UnsupportedEncodingException: " + e.getMessage());
        }
        ResponseEntity<String> result = restTemplate.exchange(requestEntity, String.class);
        System.out.println("result: " + result.getBody());
        return result.getBody();
    }
}
