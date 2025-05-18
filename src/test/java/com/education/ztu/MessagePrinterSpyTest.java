package com.education.ztu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MessagePrinterSpyTest {

    @Spy
    private MessageService realService = new MessageService() {
        public String getMessage() {
            return "Real Message";
        }
    };

    @InjectMocks
    private MessagePrinter printer;

    @Captor
    private ArgumentCaptor<String> captor;

    @Test
    public void testSpy() {
        doReturn("Spy Message").when(realService).getMessage();

        String result = printer.printMessage();

        assertEquals("Message: Spy Message", result);
        verify(realService).getMessage();
    }
}
