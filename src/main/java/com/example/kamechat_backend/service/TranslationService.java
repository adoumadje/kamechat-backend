package com.example.kamechat_backend.service;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import org.springframework.stereotype.Service;

@Service
public class TranslationService {
    private final Translate translate;

    public TranslationService() {
        this.translate = TranslateOptions.getDefaultInstance().getService();
    }

    public String translateText(String text) {
        Translation translation = translate.translate(text);
        return translation.getTranslatedText();
    }
}
