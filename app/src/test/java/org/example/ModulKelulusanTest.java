package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Test ModulKelulusan")
class ModulKelulusanTest {

    private ModulKelulusan modulKelulusan;

    @BeforeEach
    void setUp() {
        modulKelulusan = new ModulKelulusan();
    }

   @Test
    @DisplayName("kalkulasi nilai akhir kurang dari 0")
    void testNilaiKurangDari0() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> modulKelulusan.tentukanKelulusan(-1)
        );
        assertEquals("Nilai akhir tidak valid. Pastikan nilai berada di antara 0 dan 100.", ex.getMessage());
    }

    @Test
    @DisplayName("kalkulasi nilai akhir lebih dari 100")
    void testNilaiLebihDari100() {
        IllegalArgumentException ex = assertThrows(
            IllegalArgumentException.class,
            () -> modulKelulusan.tentukanKelulusan(150)
        );
        assertEquals("Nilai akhir tidak valid. Pastikan nilai berada di antara 0 dan 100.", ex.getMessage());
    }
    
    @Test
    @DisplayName("nilai akhir valid dan lulus")
    void testLulus() {
        assertEquals("Lulus", modulKelulusan.tentukanKelulusan(90));
    }

    @Test
    @DisplayName("Nilai akhir valid dan tidak lulus")
    void testTidakLulusLagiYa() {
        assertEquals("Tidak Lulus", modulKelulusan.tentukanKelulusan(40));
    }
}
