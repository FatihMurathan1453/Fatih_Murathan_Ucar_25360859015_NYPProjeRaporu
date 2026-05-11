package com.bank.app.people;

import java.util.ArrayList;
import java.util.Random;

// Banka personeline ait bilgileri tutan sınıf
// Kisi sınıfından miras almaktadır
public class BankaPersoneli extends Kisi {

    private String personelID;
    private ArrayList<Musteri> musteriler; // Personelin sorumlu olduğu müşteriler

    public BankaPersoneli() {
        super();
        this.personelID = olusturPersonelID();
        this.musteriler = new ArrayList<>();
    }

    public BankaPersoneli(String ad, String soyad, String email, int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        this.personelID = olusturPersonelID();
        this.musteriler = new ArrayList<>();
    }


    private String olusturPersonelID() {
        return "P" + (100000 + new Random().nextInt(900000));// P harfi + 6 haneli rastgele sayı ile personel ID üretimi
    }


    public void musteriEkle(Musteri musteri) {// Sorumlu müşteri listesine müşteri ekleme metodu
        musteriler.add(musteri);
    }


    public void musteriSil(Musteri musteri) { // Sorumlu müşteri listesinden müşteri çıkarma metodu
        musteriler.remove(musteri);
    }

    @Override //override hatırlatması
    public String toString() {
        return "BankaPersoneli{personelID='" + personelID + "', " + super.toString() + "}"; //toString metodu
    }

    public String getPersonelID() { return personelID; }
    public void setPersonelID(String personelID) { this.personelID = personelID; }

    public ArrayList<Musteri> getMusteriler() { return musteriler; }
    public void setMusteriler(ArrayList<Musteri> musteriler) { this.musteriler = musteriler; }  //getter ve setter metotları
}
