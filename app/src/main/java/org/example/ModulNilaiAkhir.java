package org.example;

public class ModulNilaiAkhir {
    /**
     * Menghitung nilai akhir mahasiswa berdasarkan bobot tugas, UTS, dan UAS.
     * @return nilai akhir mahasiswa.
     */
    public double hitungNilaiAkhir(double tugas, double uts, double uas) {
        ModulValidasi validasi = new ModulValidasi();
        if (!validasi.validasiNilai(tugas, uts, uas)) {
            throw new IllegalArgumentException(
                "Nilai tidak valid. Pastikan nilai tugas, UTS, dan UAS berada di antara 0 dan 100, dan tidak semuanya nol."
            );
        }
        double nilaiAkhir = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);
        if (nilaiAkhir < 0 || nilaiAkhir > 100) {
            throw new IllegalStateException(
                "Nilai akhir tidak valid. Pastikan perhitungan benar dan nilai berada di antara 0 dan 100."
            );
        }
        return nilaiAkhir;
    }
}