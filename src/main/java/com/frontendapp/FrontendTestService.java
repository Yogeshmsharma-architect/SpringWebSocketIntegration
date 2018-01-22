package com.frontendapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.core.MessageSendingOperations;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@EnableScheduling
public class FrontendTestService {
    int counter = 0;
    private Map<String, List<String>> registeredServers = new HashMap<>();
    @Autowired
    private MessageSendingOperations<String> messagingTemplate;

    @Autowired
    SimpMessageSendingOperations simpMessageSendingOperations;

    @Scheduled(cron = "0/15 * * * * *")
    /**
     * Send Websocket message to subscriber per 15 seconds
     */
    public void callbackDashboard() {
        System.out.println("Sending message over websocket");
        simpMessageSendingOperations.convertAndSend("/topic", getMessage());
    }

    private MessageDTO getMessage() {
        return MessageDTO.newMessageDTO().withMsgId(counter).withMessage("Message" + counter++).build();
    }

}
