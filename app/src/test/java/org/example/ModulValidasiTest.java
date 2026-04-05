package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Testing untuk ModulValidasi
 * Metode: Path Testing (White Box Testing)
 *
 * Cyclomatic Complexity: V(G) = 4 + 1 = 5
 * Sehingga terdapat 5 independent path:
 *
 * P1: 1-2-3-11              → tugas tidak valid
 * P2: 1-2-4-5-11            → UTS tidak valid
 * P3: 1-2-4-6-7-11          → UAS tidak valid
 * P4: 1-2-4-6-8-9-11        → semua nilai 0
 * P5: 1-2-4-6-8-10-11       → semua valid
 */
public class ModulValidasiTest {

    private ModulValidasi modulValidasi;

    @BeforeEach
    void setUp() {
        // Precondition: Object ModulValidasi sudah diinisialisasi
        modulValidasi = new ModulValidasi();
    }

    /**
     * TC1 | Path P1: 1-2-3-11
     * Item Case    : Tugas tidak valid
     * Data Test    : tugas = -10, uts = 80, uas = 90
     * Expected     : false
     */
    @Test
    void testTC1_TugasTidakValid() {
        boolean result = modulValidasi.validasiNilai(-10, 80, 90);
        assertFalse(result);
    }

    /**
     * TC2 | Path P2: 1-2-4-5-11
     * Item Case    : UTS tidak valid
     * Data Test    : tugas = 80, uts = 120, uas = 90
     * Expected     : false
     */
    @Test
    void testTC2_UTSTidakValid() {
        boolean result = modulValidasi.validasiNilai(80, 120, 90);
        assertFalse(result);
    }

    /**
     * TC3 | Path P3: 1-2-4-6-7-11
     * Item Case    : UAS tidak valid
     * Data Test    : tugas = 80, uts = 85, uas = 150
     * Expected     : false
     */
    @Test
    void testTC3_UASTidakValid() {
        boolean result = modulValidasi.validasiNilai(80, 85, 150);
        assertFalse(result);
    }

    /**
     * TC4 | Path P4: 1-2-4-6-8-9-11
     * Item Case    : Semua nilai 0
     * Data Test    : tugas = 0, uts = 0, uas = 0
     * Expected     : false
     */
    @Test
    void testTC4_SemuaNilaiNol() {
        boolean result = modulValidasi.validasiNilai(0, 0, 0);
        assertFalse(result);
    }

    /**
     * TC5 | Path P5: 1-2-4-6-8-10-11
     * Item Case    : Semua nilai valid
     * Data Test    : tugas = 80, uts = 85, uas = 90
     * Expected     : true
     */
    @Test
    void testTC5_SemuaValid() {
        boolean result = modulValidasi.validasiNilai(80, 85, 90);
        assertTrue(result);
    }
}