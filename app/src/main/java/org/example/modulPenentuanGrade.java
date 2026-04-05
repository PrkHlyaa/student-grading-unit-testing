package org.example;

public class modulPenentuanGrade {
    /**
     * Menentukan grade berdasarkan nilai akhir mahasiswa.
     * @return grade mahasiswa.
     */
    public String tentukanGrade(double nilaiAkhir) {
        if (nilaiAkhir < 0 || nilaiAkhir > 100) {
            throw new IllegalArgumentException("Nilai akhir tidak valid. Pastikan nilai berada di antara 0 dan 100.");
        }
        if (nilaiAkhir >= 85) {
            return "A";
        } else if (nilaiAkhir >= 70) {
            return "B";
        } else if (nilaiAkhir >= 55) {
            return "C";
        } else if (nilaiAkhir >= 40) {
            return "D";
        } else {
            return "E";
        }
    }
}
