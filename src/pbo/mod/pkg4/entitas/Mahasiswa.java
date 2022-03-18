package pbo.mod.pkg4.entitas;

import pbo.mod.pkg4.relasi.AmbilMK;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Mahasiswa {

    private String nama;
    private String nim;
    private String kelas;
    private String prodi;

    public Mahasiswa(String nim, String nama, int nokelas){
        this.nama = nama;
        this.nim = nim;
        init(nokelas);
    }

    private void init(int nokelas){
        initProdi();
        initKelas(nokelas);
    }

    // Set Prodi dari NIM
    private void initProdi(){
        String nimFirstFour = getNim().substring(0, 4);
        switch (nimFirstFour) {
            case "1301":
                setProdi("IF");
                break;
            case "1302":
                setProdi("SE");
                break;
            case "1303":
                setProdi("IT");
                break;
        }
    }

    // Set kelas
    private void initKelas(int nokelas){
        StringBuilder kelas = new StringBuilder();

        String nimAngkatan = getNim().substring(4, 6);
        int angkatan = Integer.parseInt(nimAngkatan);
        angkatan += 24;

        kelas.append(getProdi()).append("-").append(angkatan).append("-");
        if (String.valueOf(nokelas).length() == 1){
            kelas.append("0").append(nokelas);
        }else{
            kelas.append(nokelas);
        }
        setKelas(kelas.toString());
    }

    public void hitungIPK(AmbilMK[] mks){
        DecimalFormat format = new DecimalFormat("#.##");

        // Tahun ajaran, IPK
        HashMap<String, Double> resultMap = new HashMap<>();
        HashMap<String, Integer> sksMap = new HashMap<>();

        // Nilai awal
        for (AmbilMK mk : mks){
            if (!mk.getMahasiswa().equals(this)) continue;

            resultMap.put(mk.getTahunAjaran(), 0.0);
            sksMap.put(mk.getTahunAjaran(), 0);
        }

        for (AmbilMK mk : mks){
            if (mk.getMahasiswa().equals(this)){
                double skor = 0;
                double result = resultMap.get(mk.getTahunAjaran());
                int sks = sksMap.get(mk.getTahunAjaran());

                switch (mk.getNilai()){
                    case "A":
                        skor = 4;
                        break;
                    case "AB":
                        skor = 3.5;
                        break;
                    case "B":
                        skor = 3;
                        break;
                    case "BC":
                        skor = 2.5;
                        break;
                    case "C":
                        skor = 2;
                        break;
                    case "D":
                        skor = 1;
                        break;
                }

                skor = skor * mk.getMataKuliah().getSks();
                sks += mk.getMataKuliah().getSks();
                result += skor;

                resultMap.put(mk.getTahunAjaran(), result);
                sksMap.put(mk.getTahunAjaran(), sks);
            }
        }

        for (Map.Entry<String, Double> entry : resultMap.entrySet()){
            String tahunAjaran = entry.getKey();
            Double result = entry.getValue();
            result = result / sksMap.get(tahunAjaran);

            System.out.println("IPK " + getNama() + " (" + getKelas() + ") TA " + tahunAjaran + " : " + format.format(result));
        }
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    // TODO
    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }
}
