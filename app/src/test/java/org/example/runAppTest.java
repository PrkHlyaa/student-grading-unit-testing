package org.example;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * Test berdasarkan PATH (CFG) pada method runApp()
 * Setiap test merepresentasikan 1 independent path
 */
public class runAppTest {

    /**
     * Helper untuk menjalankan runApp dengan input simulasi
     */
    private String runWithInput(String inputData) {
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        Scanner scanner = new Scanner(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        MainApp.runApp(scanner);

        System.setOut(originalOut);

        return outputStream.toString();
    }

    /**
     * P1:
     * Path normal (tanpa error, tanpa loop tambahan)
     * 1 → 2 → 3 → 4 → 5 → 6 → 7
     */
    @Test
    void testPathP1_InputValid_LangsungSelesai() {
        String input = "80\n85\n90\nn\n";

        String output = runWithInput(input);

        // Harus langsung menampilkan hasil dan selesai
        assertTrue(output.contains("HASIL"));
        assertTrue(output.contains("Program selesai"));
    }

    /**
     * P2:
     * Path validasi gagal lalu berhasil
     * 1 → 2 → 3 → 4 → loop → ... → 7
     */
    @Test
    void testPathP2_InvalidLaluValid() {
        String input =
                "-10\n80\n90\n" +   // invalid
                "80\n85\n90\n" +   // valid
                "n\n";

        String output = runWithInput(input);

        // Harus muncul pesan error
        assertTrue(output.contains("Input tidak valid"));

        // Lalu tetap menghasilkan output
        assertTrue(output.contains("HASIL"));
    }

    /**
     * P3:
     * Path loop menu (lebih dari 1 iterasi)
     * 1 → 2 → 3 → 4 → 5 → 6 → loop → ... → 7
     */
    @Test
    void testPathP3_LoopMenu() {
        String input =
                "80\n85\n90\ny\n" +   // iterasi 1
                "70\n75\n80\nn\n";   // iterasi 2

        String output = runWithInput(input);

        // Harus ada 2 hasil
        int countHasil = output.split("HASIL").length - 1;
        assertEquals(2, countHasil);
    }

    /**
     * P4:
     * Path kombinasi (invalid + loop menu)
     * path paling kompleks
     */
    @Test
    void testPathP4_KombinasiInvalidDanLoop() {
        String input =
                "-10\n80\n90\n" +   // invalid 1
                "120\n85\n90\n" +  // invalid 2
                "80\n85\n90\ny\n" + // valid + lanjut
                "70\n75\n80\nn\n";  // iterasi kedua lalu keluar

        String output = runWithInput(input);

        // Harus ada error lebih dari sekali
        int countError = output.split("Input tidak valid").length - 1;
        assertTrue(countError >= 2);

        // Harus ada lebih dari 1 hasil
        int countHasil = output.split("HASIL").length - 1;
        assertTrue(countHasil >= 2);
    }
}