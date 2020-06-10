package io.neolab.internship.stringreverse.handler;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class StringHandlerTest {
    @Test
    public void shouldConvertCorrectlyAtFirst() {
        Scanner scanner = mock(Scanner.class);
        when(scanner.nextLine()).thenReturn("Hello, World!", "ultr53o?n", "Testovoe_Zadanie_Ot_NEOLAB.docx");

        Assert.assertEquals("dlroWolleH", StringHandler.revertString(scanner.nextLine()));
        Assert.assertEquals("nortlu", StringHandler.revertString(scanner.nextLine()));
        Assert.assertEquals("xcodBALOENtOeinadaZeovotseT", StringHandler.revertString(scanner.nextLine()));
    }
}