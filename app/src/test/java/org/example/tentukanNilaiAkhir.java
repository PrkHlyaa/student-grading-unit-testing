package org.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class tentukanNilaiAkhirTest {

    private final Penilaian penilaian = new Penilaian();

    @Test
    public void testValidasiNilai_TC1_NilaiInputKurangDari0() {
        boolean result = penilaian.validasiNilai(-1, -1, -1);
        assertFalse(result);
    }

    @Test
    public void testValidasiNilai_TC2_NilaiInputLebihDari100() {
        boolean result = penilaian.validasiNilai(150, 150, 150);
        assertFalse(result);
    }

    @Test
    public void testValidasiNilai_TC3_NilaiInputBenarTapiHitungSalah() {
        boolean result = penilaian.validasiNilai(0, 0, 0);
        assertFalse(result);
    }

    @Test
    public void testValidasiNilai_TC4_NilaiInputValidPadaBatasAkhir() {
        boolean result = penilaian.validasiNilai(100, 100, 100);
        assertTrue(result);
    }

    @Test
    public void testValidasiNilai_TC5_NilaiInputValidPadaBatasBawah() {
        boolean result = penilaian.validasiNilai(1, 1, 1);
        assertTrue(result);
    }
}