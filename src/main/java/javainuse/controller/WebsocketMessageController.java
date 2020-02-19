package javainuse.controller;

import javainuse.domain.WebsocketMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class WebsocketMessageController {
    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/javainuse")
    public WebsocketMessage sendMessage(@Payload WebsocketMessage websocketMessage){
        return websocketMessage;
    }

    @MessageMapping("/chat.newUser")
    @SendTo("/topic/javainuse")
    public WebsocketMessage newUser(@Payload WebsocketMessage websocketMessage, SimpMessageHeaderAccessor headerAccessor){
        headerAccessor.getSessionAttributes().put("username", websocketMessage.sender());
        return websocketMessage;

    }


}
