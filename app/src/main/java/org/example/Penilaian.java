package org.example;

public class Penilaian {

    // Konstanta bobot
    private final double bobotTugas = 0.3;
    private final double bobotUTS = 0.3;
    private final double bobotUAS = 0.4;

    // Validasi nilai
    public boolean validasiNilai(double tugas, double uts, double uas) {
        if (tugas < 0 || tugas > 100) {
            return false;
        }
        if (uts < 0 || uts > 100) {
            return false;
        }
        if (uas < 0 || uas > 100) {
            return false;
        }
        if (tugas == 0 && uts == 0 && uas == 0) {
            return false;
        }
        return true;
    }

    // Hitung nilai akhir
    public double hitungNilaiAkhir(double tugas, double uts, double uas) {      
        if (!validasiNilai(tugas, uts, uas)) {                                  
            return -1;                                                                                 
        }

        double nilaiAkhir = (bobotTugas * tugas) +
                            (bobotUTS * uts) +
                            (bobotUAS * uas);                                   

        if (nilaiAkhir > 100) {                                                 
            return -1;                                                          
        }

        return nilaiAkhir;                                                          
    }    

    // Tentukan grade
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



    // Tentukan kelulusan
    public String tentukanKelulusan(double nilaiAkhir) {
        if (nilaiAkhir >= 60) return "Lulus";
        else return "Tidak Lulus";
    }
}