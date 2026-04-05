package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 
/**
 * Unit Testing untuk ModulGrade - Penentuan Grade Mahasiswa
 * Metode: Path Testing (White Box Testing)
 *
 * Cyclomatic Complexity: V(G) = P + 1 = 5 + 1 = 6
 * Sehingga terdapat 6 independent path yang diuji:
 *
 * P1: 1-2             → Range skor tidak valid (IllegalArgumentException)
 * P2: 1-3-4           → Grade A (nilaiAkhir >= 85)
 * P3: 1-3-5-6         → Grade B (nilaiAkhir >= 70)
 * P4: 1-3-5-7-8       → Grade C (nilaiAkhir >= 55)
 * P5: 1-3-5-7-9-10    → Grade D (nilaiAkhir >= 40)
 * P6: 1-3-5-7-9-11    → Grade E (nilaiAkhir < 40)
 */
public class modulPenenteuanGradeTest {
 
    private modulPenentuanGrade modulGrade;
 
    @BeforeEach
    void setUp() {
        // Precondition: Object ModulGrade telah diinisialisasi
        modulGrade = new modulPenentuanGrade();
    }
 
    /**
     * TC-01 | Path P1: 1-2
     * Item Case    : Inputan di luar rentang valid
     * Data Test    : -5
     * Expected     : Memunculkan pesan error: IllegalArgumentException
     */
    @Test
    void testTC01_NilaiTidakValid_BawahNol() {
        assertThrows(IllegalArgumentException.class, () -> {
            modulGrade.tentukanGrade(-5);
        });
    }
 
    /**
     * TC-01 (tambahan) | Path P1: 1-2
     * Item Case    : Inputan di luar rentang valid (di atas 100)
     * Data Test    : 105
     * Expected     : Memunculkan pesan error: IllegalArgumentException
     */
    @Test
    void testTC01b_NilaiTidakValid_AtasSeratus() {
        assertThrows(IllegalArgumentException.class, () -> {
            modulGrade.tentukanGrade(105);
        });
    }
 
    /**
     * TC-02 | Path P2: 1-3-4
     * Item Case    : Menentukan Grade A
     * Data Test    : 90
     * Expected     : Mengembalikan nilai "A"
     */
    @Test
    void testTC02_GradeA() {
        String result = modulGrade.tentukanGrade(90);
        assertEquals("A", result);
    }
 
    /**
     * TC-03 | Path P3: 1-3-5-6
     * Item Case    : Menentukan Grade B
     * Data Test    : 75
     * Expected     : Mengembalikan nilai "B"
     */
    @Test
    void testTC03_GradeB() {
        String result = modulGrade.tentukanGrade(75);
        assertEquals("B", result);
    }
 
    /**
     * TC-04 | Path P4: 1-3-5-7-8
     * Item Case    : Menentukan Grade C
     * Data Test    : 60
     * Expected     : Mengembalikan nilai "C"
     */
    @Test
    void testTC04_GradeC() {
        String result = modulGrade.tentukanGrade(60);
        assertEquals("C", result);
    }
 
    /**
     * TC-05 | Path P5: 1-3-5-7-9-10
     * Item Case    : Menentukan Grade D
     * Data Test    : 45
     * Expected     : Mengembalikan nilai "D"
     */
    @Test
    void testTC05_GradeD() {
        String result = modulGrade.tentukanGrade(45);
        assertEquals("D", result);
    }
 
    /**
     * TC-06 | Path P6: 1-3-5-7-9-11
     * Item Case    : Menentukan Grade E
     * Data Test    : 25
     * Expected     : Mengembalikan nilai "E"
     */
    @Test
    void testTC06_GradeE() {
        String result = modulGrade.tentukanGrade(25);
        assertEquals("E", result);
    }
}