package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class KelulusanTest {

    private final Penilaian penilaian = new Penilaian();

    @Test
    void tentukanKelulusanLulusJikaNilaiMinimalEnamPuluh() {
        assertEquals("Lulus", penilaian.tentukanKelulusan(100)); 
        assertEquals("Lulus", penilaian.tentukanKelulusan(60));
        assertEquals("Tidak Lulus", penilaian.tentukanKelulusan(59.99));
        assertEquals("Tidak Lulus", penilaian.tentukanKelulusan(0));
    }
}