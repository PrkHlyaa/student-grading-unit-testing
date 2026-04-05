package org.example;

public class ModulValidasi {                        //1
    /**
     * Memvalidasi nilai input mahasiswa.
     * @return true jika valid, false jika tidak valid.
     */

    public boolean validasiNilai(double tugas, double uts, double uas) {
        if (tugas < 0 || tugas > 100) {             //2
            return false;                           //3
        }
        if (uts < 0 || uts > 100) {                 //4
            return false;                           //5
        }
        if (uas < 0 || uas > 100) {                 //6
            return false;                           //7
        }
        if (tugas == 0 && uts == 0 && uas == 0) {   //8
            return false;                           //9
        }
        return true;                                //10
    }
}                                                   //11