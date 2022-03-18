package pbo.mod.pkg4.driver;

import pbo.mod.pkg4.entitas.Mahasiswa;
import pbo.mod.pkg4.entitas.MataKuliah;
import pbo.mod.pkg4.relasi.AmbilMK;

public class DriverAmbilMK {

    public static void main(String[] args){

        MataKuliah pbo = new MataKuliah("CII3B4", "Pemrograman Berbasis Objek", 4),
                kpl = new MataKuliah("CII3H4", "Konstruksi Perangkat Lunak", 4),
                apb = new MataKuliah("CTI3I3", "Aplikasi Perangkat Bergerak", 3);

        Mahasiswa mhs1 = new Mahasiswa("1303209999", "Joseph Stalin", 12);
        Mahasiswa mhs2 = new Mahasiswa("1302204090", "Adolf Hitler", 2);

        AmbilMK[] mks = new AmbilMK[]{
                new AmbilMK(mhs1, pbo, "A", "20/21"),
                new AmbilMK(mhs1, apb, "B", "20/21"),
                new AmbilMK(mhs1, kpl, "A", "20/21"),
                new AmbilMK(mhs1, kpl, "C", "19/20"),

                new AmbilMK(mhs2, pbo, "A", "19/20"),
                new AmbilMK(mhs2, apb, "A", "19/20"),
                new AmbilMK(mhs2, kpl, "A", "19/20"),
        };

        mhs1.hitungIPK(mks);
        mhs2.hitungIPK(mks);

    }

}
