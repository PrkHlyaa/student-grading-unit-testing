package org.example;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ModulNilaiAkhir modulNilaiAkhir = new ModulNilaiAkhir();
        modulPenentuanGrade modulGrade = new modulPenentuanGrade();
        ModulKelulusan modulKelulusan = new ModulKelulusan();
        ModulValidasi modulValidasi = new ModulValidasi();

        boolean lanjut = true;
        while (lanjut) {
            System.out.println("=== Aplikasi Penilaian Mahasiswa ===");
            System.out.print("Masukkan nilai tugas: ");
            double tugas = scanner.nextDouble();
            System.out.print("Masukkan nilai UTS: ");
            double uts = scanner.nextDouble();
            System.out.print("Masukkan nilai UAS: ");
            double uas = scanner.nextDouble();

            if(!modulValidasi.validasiNilai(tugas, uts, uas)) {
                System.out.println("Input nilai tidak valid. Pastikan nilai berada di antara 0 dan 100, dan tidak semuanya nol.");
                continue;
            }

            double nilaiAkhir = modulNilaiAkhir.hitungNilaiAkhir(tugas, uts, uas);
            String grade = modulGrade.tentukanGrade(nilaiAkhir);
            String statusKelulusan = modulKelulusan.tentukanKelulusan(nilaiAkhir);

            System.out.printf("Nilai Akhir: %.2f\n", nilaiAkhir);
            System.out.println("Grade: " + grade);
            System.out.println("Status Kelulusan: " + statusKelulusan);

            System.out.print("Apakah Anda ingin memasukkan data lagi? (y/n): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("y")) {
                lanjut = false;
            }
        }
        System.out.println("Terima kasih telah menggunakan aplikasi penilaian mahasiswa.");
        scanner.close();
    }
}