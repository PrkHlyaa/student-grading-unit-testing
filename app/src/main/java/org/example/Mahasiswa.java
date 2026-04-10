package org.example;

public class Mahasiswa {
    private double nilaiTugas;
    private double nilaiUTS;
    private double nilaiUAS;
    private double nilaiAkhir;
    private char grade;
    private String statusKelulusan;

    // Setter
    public void setNilaiTugas(double nilaiTugas) {
        this.nilaiTugas = nilaiTugas;
    }

    public void setNilaiUTS(double nilaiUTS) {
        this.nilaiUTS = nilaiUTS;
    }

    public void setNilaiUAS(double nilaiUAS) {
        this.nilaiUAS = nilaiUAS;
    }

    public void setNilaiAkhir(double nilaiAkhir) {
        this.nilaiAkhir = nilaiAkhir;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public void setStatusKelulusan(String statusKelulusan) {
        this.statusKelulusan = statusKelulusan;
    }

    // Getter
    public double getNilaiTugas() {
        return nilaiTugas;
    }

    public double getNilaiUTS() {
        return nilaiUTS;
    }

    public double getNilaiUAS() {
        return nilaiUAS;
    }

    public double getNilaiAkhir() {
        return nilaiAkhir;
    }

    public char getGrade() {
        return grade;
    }

    public String getStatusKelulusan() {
        return statusKelulusan;
    }

    // Method tampil hasil
    public void tampilkanHasil() {
        System.out.println("Nilai Akhir      : " + nilaiAkhir);
        System.out.println("Grade            : " + grade);
        System.out.println("Status Kelulusan : " + statusKelulusan);
    }
}