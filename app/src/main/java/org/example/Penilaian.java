package org.example;

public class Penilaian {

    // Konstanta bobot
    private final double bobotTugas = 0.3;
    private final double bobotUTS = 0.3;
    private final double bobotUAS = 0.4;

    // Validasi nilai
    public boolean validasiNilai(double tugas, double uts, double uas) {
        if (tugas < 0 || tugas > 100 ||
            uts < 0 || uts > 100 ||
            uas < 0 || uas > 100) {
            return false;
        }

        if (tugas == 0 && uts == 0 && uas == 0) {
            return false;
        }

        return true;
    }

    // Hitung nilai akhir


    // Tentukan grade
    

    // Tentukan kelulusan

}