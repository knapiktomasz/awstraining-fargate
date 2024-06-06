package com.awstraining.backend.business.notifyme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotifyMeService {

    // TODO: lab1
    //  1. Inject MessageSender.
    // TODO lab2
    //  1. Inject Translator
    // TODO lab3
    //  1. Inject sentiment detector
    private final MessageSender messageSender;
    private final Translator translator;
    private final Sentiment sentimentDetector;

    @Autowired
    public NotifyMeService(MessageSender messageSender, Translator translator, Sentiment sentimentDetector) {
        this.messageSender = messageSender;
        this.translator = translator;
        this.sentimentDetector = sentimentDetector;
    }
    
    public String notifyMe(NotifyMeDO notifyMe) {
        // TODO: lab1
        //  1. Send text using sender.
        //  2. Return sent message.
        String text = notifyMe.text();
        messageSender.send(text);


        // TODO: lab2
        //  Translate text from using translator
//  1. Translate text.
        String translatedText = translator.translate(notifyMe);
        messageSender.send(translatedText);


        //  2. Change sending of text to "translated text" and return it.


        // TODO: lab3
        //  Detect sentiment of translated message
//  1. Detect sentiment of translated text.
        String sentiment = sentimentDetector.detectSentiment("", translatedText);
        String translatedSentiment = sentiment + ": " + translatedText;
        messageSender.send(translatedSentiment);


        //  2. Change sending of text to "setiment: translated text" and return it.
//        return text;
//        return translatedText;
        return translatedSentiment;
    }

}
