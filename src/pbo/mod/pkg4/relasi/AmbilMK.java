package pbo.mod.pkg4.relasi;

import pbo.mod.pkg4.entitas.Mahasiswa;
import pbo.mod.pkg4.entitas.MataKuliah;

public class AmbilMK {

    private Mahasiswa mahasiswa;
    private MataKuliah mataKuliah;
    private String tahunAjaran;
    private String nilai;

    public AmbilMK(Mahasiswa mahasiswa, MataKuliah mataKuliah, String nilai, String tahunAjaran) {
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.tahunAjaran = tahunAjaran;
        this.nilai = nilai;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public MataKuliah getMataKuliah() {
        return mataKuliah;
    }

    public void setMataKuliah(MataKuliah mataKuliah) {
        this.mataKuliah = mataKuliah;
    }

    public String getTahunAjaran() {
        return tahunAjaran;
    }

    public void setTahunAjaran(String tahunAjaran) {
        this.tahunAjaran = tahunAjaran;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }
}
