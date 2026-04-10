package org.example;

import java.util.Scanner;

public class MainApp {

    public static void runApp(Scanner input) {
        Penilaian penilaian = new Penilaian();
        boolean lanjut = true;

        while (lanjut) {
            Mahasiswa mhs = new Mahasiswa();

            double tugas, uts, uas;

            while (true) {
                System.out.print("Masukkan nilai tugas: ");
                tugas = input.nextDouble();

                System.out.print("Masukkan nilai UTS: ");
                uts = input.nextDouble();

                System.out.print("Masukkan nilai UAS: ");
                uas = input.nextDouble();

                if (penilaian.validasiNilai(tugas, uts, uas)) {
                    break;
                } else {
                    System.out.println("Input tidak valid! Ulangi.\n");
                }
            }

            mhs.setNilaiTugas(tugas);
            mhs.setNilaiUTS(uts);
            mhs.setNilaiUAS(uas);

            double nilaiAkhir = penilaian.hitungNilaiAkhir(tugas, uts, uas);
            char grade = penilaian.tentukanGrade(nilaiAkhir);
            String status = penilaian.tentukanKelulusan(nilaiAkhir);

            mhs.setNilaiAkhir(nilaiAkhir);
            mhs.setGrade(grade);
            mhs.setStatusKelulusan(status);

            System.out.println("\n=== HASIL ===");
            mhs.tampilkanHasil();

            System.out.print("\nInput lagi? (y/n): ");
            String pilihan = input.next();

            if (pilihan.equalsIgnoreCase("n")) {
                lanjut = false;
            }

            System.out.println();
        }

        System.out.println("Program selesai.");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        runApp(input);
        input.close();
    }
}