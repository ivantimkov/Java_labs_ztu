package com.education.ztu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MessagePrinterTest {

    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessagePrinter messagePrinter;

    @Test
    public void testPrintMessage() {
        when(messageService.getMessage()).thenReturn("Hello, Mockito!");

        String result = messagePrinter.printMessage();

        assertEquals("Message: Hello, Mockito!", result);
        verify(messageService, times(1)).getMessage();
    }

    @Test
    public void testPrintMessageMultipleTimes() {
        when(messageService.getMessage()).thenReturn("Repeated");

        messagePrinter.printMessage();
        messagePrinter.printMessage();

        verify(messageService, times(2)).getMessage();
    }
}
