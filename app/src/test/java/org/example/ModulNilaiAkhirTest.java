package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Test ModulNilaiAkhir")
class ModulNilaiAkhirTest {

    private ModulNilaiAkhir modulNilai;

    @BeforeEach
    void setUp() {
        modulNilai = new ModulNilaiAkhir();
    }

    @Test
    @DisplayName("TC1: Nilai input kurang dari 0")
    void testNilaiKurangDari0() {
    IllegalArgumentException ex = assertThrows(
    IllegalArgumentException.class,
    () -> modulNilai.hitungNilaiAkhir(-1, -1, -1)
    );
    assertEquals(
    "Nilai tidak valid. Pastikan nilai tugas, UTS, dan UAS berada di antara 0 dan 100, dan tidak semuanya nol.",
    ex.getMessage()
    );
    }

    @Test
    @DisplayName("TC2: Nilai input lebih dari 100")
    void testNilaiLebihDari100() {
    IllegalArgumentException ex = assertThrows(
    IllegalArgumentException.class,
    () -> modulNilai.hitungNilaiAkhir(150, 150, 150)
    );
    assertEquals(
    "Nilai tidak valid. Pastikan nilai tugas, UTS, dan UAS berada di antara 0 dan 100, dan tidak semuanya nol.",
    ex.getMessage()
    );
    }

    @Test
    @DisplayName("TC3: Semua nilai 0 dianggap tidak valid")
    void testSemuaNolTidakValid() {
    IllegalArgumentException ex = assertThrows(
    IllegalArgumentException.class,
    () -> modulNilai.hitungNilaiAkhir(0, 0, 0)
    );
    assertEquals(
    "Nilai tidak valid. Pastikan nilai tugas, UTS, dan UAS berada di antara 0 dan 100, dan tidak semuanya nol.",
    ex.getMessage()
    );
    }

    @Test
    @DisplayName("TC4: Nilai input Valid")
    void testNilaiValid() {
        assertEquals(82.5, modulNilai.hitungNilaiAkhir(80, 75, 90), 0.001);
    }
}
