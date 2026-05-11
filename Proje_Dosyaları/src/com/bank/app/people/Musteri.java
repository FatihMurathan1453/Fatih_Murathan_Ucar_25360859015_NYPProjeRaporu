package com.bank.app.people;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;

import java.util.ArrayList;
import java.util.Random;

// Müşteri bilgilerini ve işlemlerini yöneten sınıf
// Kisi sınıfından miras almaktadır
public class Musteri extends Kisi {

    private String musteriNumarasi;
    private ArrayList<BankaHesabi> hesaplar;
    private ArrayList<KrediKarti> krediKartlari;

    public Musteri() {
        super();
        this.musteriNumarasi = olusturMusteriNumarasi();
        this.hesaplar = new ArrayList<>();
        this.krediKartlari = new ArrayList<>();
    }

    public Musteri(String ad, String soyad, String email, int telefonNumarasi) {
        super(ad, soyad, email, telefonNumarasi);
        this.musteriNumarasi = olusturMusteriNumarasi();
        this.hesaplar = new ArrayList<>();
        this.krediKartlari = new ArrayList<>();
    }

    private String olusturMusteriNumarasi() { //M harfi + 6 haneli rastgele sayı ile müşteri numarası üretir
        return "M" + (100000 + new Random().nextInt(900000));
    }

    public void hesapEkle(String hesapTuru) { //Parametre olarak gelen hesap türüne göre yeni hesap oluşturur ve listeye ekler
        if ("vadesiz".equalsIgnoreCase(hesapTuru)) {
            hesaplar.add(new VadesizHesap());
        } else if ("yatirim".equalsIgnoreCase(hesapTuru)) {
            hesaplar.add(new YatirimHesabi());
        } else {
            System.out.println("Geçersiz hesap türü: " + hesapTuru);
        }
    }


    public void krediKartiEkle(double limit) { //Kredi kartı oluşturma metodu
        krediKartlari.add(new KrediKarti(limit, 0.0));
    }


    public void hesapSil(BankaHesabi hesap) { // Hesap silme metodu
        if (hesap.getBakiye() > 0) {
            System.out.println("Lütfen öncelikle bakiyenizi başka bir hesaba aktarınız.");
        } else {
            hesaplar.remove(hesap);
            System.out.println("Hesap başarıyla silindi.");
        }
    }

    public void krediKartiSil(KrediKarti kart) { // Kredi kartı silme metodu
        if (kart.getGuncelBorc() == 0) {
            krediKartlari.remove(kart);
            System.out.println("Kredi kartı başarıyla silindi.");
        } else {
            System.out.println("Lütfen öncelikle borç ödemesi yapınız.");
        }
    }

    @Override //override hatırlatması
    public String toString() {
        return "Musteri{musteriNumarasi='" + musteriNumarasi + "', " + super.toString() +
               ", hesapSayisi=" + hesaplar.size() + ", kartSayisi=" + krediKartlari.size() + "}"; //toString metodu
    }



    public String getMusteriNumarasi() { return musteriNumarasi; }
    public void setMusteriNumarasi(String musteriNumarasi) { this.musteriNumarasi = musteriNumarasi; }

    public ArrayList<BankaHesabi> getHesaplar() { return hesaplar; }
    public void setHesaplar(ArrayList<BankaHesabi> hesaplar) { this.hesaplar = hesaplar; }

    public ArrayList<KrediKarti> getKrediKartlari() { return krediKartlari; }
    public void setKrediKartlari(ArrayList<KrediKarti> krediKartlari) { this.krediKartlari = krediKartlari; } // getter ve setter metotları
}
