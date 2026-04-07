package org.example;

public class ModulKelulusan {
    /**
     * Menentukan status kelulusan berdasarkan nilai akhir mahasiswa.
     * @return status kelulusan mahasiswa.
     */
    public String tentukanKelulusan(double nilaiAkhir) {
        if (nilaiAkhir < 0 || nilaiAkhir > 100) {
            throw new IllegalArgumentException(
                "Nilai akhir tidak valid. Pastikan nilai berada di antara 0 dan 100."
            );
        }
        if (nilaiAkhir >= 60) {
            return "Lulus";
        } else {
            return "Tidak Lulus";
        }
    }
}