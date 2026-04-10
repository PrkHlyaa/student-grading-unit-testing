package org.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class MainAppTest {

    @Test
    public void testMainAppValidInput() {
        // Simulasi input user
        String inputData = "80\n70\n90\nn\n";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        Scanner scanner = new Scanner(inputStream);

        // Tangkap output console
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        // Jalankan program
        MainApp.runApp(scanner);

        // Kembalikan output normal
        System.setOut(originalOut);

        String output = outputStream.toString();

        // Assertion (cek output)
        assertTrue(output.contains("Nilai Akhir"));
        assertTrue(output.contains("Grade"));
        assertTrue(output.contains("Status Kelulusan"));
    }
}