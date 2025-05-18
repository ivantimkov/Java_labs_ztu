package com.education.ztu;

public class MessagePrinter {
    private MessageService messageService;

    public MessagePrinter(MessageService messageService) {
        this.messageService = messageService;
    }

    public String printMessage() {
        return "Message: " + messageService.getMessage();
    }
}
