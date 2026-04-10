package org.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class validasiNilaiTest {

    Penilaian penilaian = new Penilaian();

    @Test
    public void testValidasiNilai_TC1_TugasTidakValid() {
        boolean result = penilaian.validasiNilai(-10, 80, 90);
        assertFalse(result);
    }

    @Test
    public void testValidasiNilai_TC2_UTSTidakValid() {
        boolean result = penilaian.validasiNilai(80, 120, 90);
        assertFalse(result);
    }

    @Test
    public void testValidasiNilai_TC3_UASTidakValid() {
        boolean result = penilaian.validasiNilai(80, 85, 150);
        assertFalse(result);
    }

    @Test
    public void testValidasiNilai_TC4_SemuaNol() {
        boolean result = penilaian.validasiNilai(0, 0, 0);
        assertFalse(result);
    }

    @Test
    public void testValidasiNilai_TC5_SemuaValid() {
        boolean result = penilaian.validasiNilai(80, 85, 90);
        assertTrue(result);
    }
}
