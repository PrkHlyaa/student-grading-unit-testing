package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class NilaiAkhirTest {

    private final Penilaian penilaian = new Penilaian();

    @Test
    void validasiNilaiMengembalikanTrueUntukRentangNormal() {
        assertTrue(penilaian.validasiNilai(80, 75, 90));
    }

    @Test
    void validasiNilaiMengembalikanFalseUntukNilaiDiLuarRentang() {
        assertFalse(penilaian.validasiNilai(-1, 80, 90));
        assertFalse(penilaian.validasiNilai(80, 101, 90));
        assertFalse(penilaian.validasiNilai(80, 90, 120));
    }

    @Test
    void validasiNilaiMengembalikanFalseJikaSemuaNol() {
        assertFalse(penilaian.validasiNilai(0, 0, 0));
    }

    @Test
    void hitungNilaiAkhirSesuaiBobot() {
        double hasil = penilaian.hitungNilaiAkhir(80, 70, 90);
        assertEquals(81.0, hasil, 0.0001);
    }

    @Test
    void hitungNilaiAkhirMengembalikanMinusSatuJikaInputTidakValid() {
        assertEquals(-1.0, penilaian.hitungNilaiAkhir(0, 0, 0));
        assertEquals(-1.0, penilaian.hitungNilaiAkhir(120, 80, 90));
    }
}