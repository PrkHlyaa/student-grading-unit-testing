package org.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class validasiNilaiTest {

    /**
     * Inisialisasi object sebelum setiap test dijalankan
     */
    Penilaian penilaian = new Penilaian();

    /**
     * TC1:
     * Menguji kondisi ketika nilai tugas < 0
     * Expected: tidak valid (false)
     */
    @Test
    void testValidasiNilai_TugasKurangDari0_ReturnFalse() {
        boolean result = penilaian.validasiNilai(-10, 80, 90);
        assertFalse(result, "Nilai tugas < 0 harus tidak valid");
    }

    /**
     * TC2:
     * Menguji kondisi ketika nilai tugas > 100
     * Expected: tidak valid (false)
     */
    @Test
    void testValidasiNilai_TugasLebihDari100_ReturnFalse() {
        boolean result = penilaian.validasiNilai(120, 80, 90);
        assertFalse(result, "Nilai tugas > 100 harus tidak valid");
    }

    /**
     * TC3:
     * Menguji kondisi ketika nilai UTS < 0
     * Expected: tidak valid (false)
     */
    @Test
    void testValidasiNilai_UTSKurangDari0_ReturnFalse() {
        boolean result = penilaian.validasiNilai(80, -5, 90);
        assertFalse(result, "Nilai UTS < 0 harus tidak valid");
    }

    /**
     * TC4:
     * Menguji kondisi ketika nilai UTS > 100
     * Expected: tidak valid (false)
     */
    @Test
    void testValidasiNilai_UTSLebihDari100_ReturnFalse() {
        boolean result = penilaian.validasiNilai(80, 120, 90);
        assertFalse(result, "Nilai UTS > 100 harus tidak valid");
    }

    /**
     * TC5:
     * Menguji kondisi ketika nilai UAS < 0
     * Expected: tidak valid (false)
     */
    @Test
    void testValidasiNilai_UASKurangDari0_ReturnFalse() {
        boolean result = penilaian.validasiNilai(80, 85, -1);
        assertFalse(result, "Nilai UAS < 0 harus tidak valid");
    }

    /**
     * TC6:
     * Menguji kondisi ketika nilai UAS > 100
     * Expected: tidak valid (false)
     */
    @Test
    void testValidasiNilai_UASLebihDari100_ReturnFalse() {
        boolean result = penilaian.validasiNilai(80, 85, 150);
        assertFalse(result, "Nilai UAS > 100 harus tidak valid");
    }

    /**
     * TC7:
     * Menguji kondisi khusus ketika semua nilai = 0
     * Expected: tidak valid (false)
     */
    @Test
    void testValidasiNilai_SemuaNilaiNol_ReturnFalse() {
        boolean result = penilaian.validasiNilai(0, 0, 0);
        assertFalse(result, "Semua nilai 0 dianggap belum input (tidak valid)");
    }

    /**
     * TC8:
     * Menguji kondisi normal ketika semua nilai valid (0–100)
     * Expected: valid (true)
     */
    @Test
    void testValidasiNilai_SemuaValid_ReturnTrue() {
        boolean result = penilaian.validasiNilai(80, 85, 90);
        assertTrue(result, "Semua nilai dalam range harus valid");
    }
}
