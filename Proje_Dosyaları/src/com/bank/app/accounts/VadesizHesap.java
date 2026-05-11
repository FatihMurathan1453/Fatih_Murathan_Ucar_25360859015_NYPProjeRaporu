package com.bank.app.accounts;

import com.bank.app.cards.KrediKarti;

// Vadesiz hesap işlemlerini gerçekleştiren sınıf
// BankaHesabi sınıfından miras almaktadır
public class VadesizHesap extends BankaHesabi {

    private String hesapTuru; // UML'de hesapTürü alanı

    public VadesizHesap() {
        super();
        this.hesapTuru = "Vadesiz";
    }

    public VadesizHesap(double bakiye) { // Başlangıç bakiyesiyle hesap açmak için parametreli constructor
        super(bakiye);
        this.hesapTuru = "Vadesiz";
    }

    public void paraTransferi(BankaHesabi aliciHesap, BankaHesabi gonderenHesap, double miktar) { //para transferi metodu
        if (gonderenHesap.getBakiye() < miktar) {
            System.out.println("Yetersiz bakiye. Transfer gerçekleştirilemedi.");
            return;
        }
        gonderenHesap.setBakiye(gonderenHesap.getBakiye() - miktar);
        aliciHesap.setBakiye(aliciHesap.getBakiye() + miktar);
        System.out.println(miktar + " TL transfer gerçekleştirildi.");
    }

    public void krediKartiBorcOdeme(KrediKarti kart, double miktar) { // Kredi kartı borç ödeme metodu
        if (getBakiye() < miktar) {
            System.out.println("Yetersiz bakiye. Borç ödemesi gerçekleştirilemedi.");
            return;
        }
        if (miktar > kart.getGuncelBorc()) {
            System.out.println("Ödeme miktarı güncel borçtan fazla olamaz.");
            return;
        }
        setBakiye(getBakiye() - miktar);
        kart.setGuncelBorc(kart.getGuncelBorc() - miktar);
        System.out.println(miktar + " TL borç ödemesi yapıldı.");
    }

    @Override //overide hatırlatması
    public String toString() {
        return "VadesizHesap{hesapTuru='" + hesapTuru + "', " + super.toString() + "}"; //toString metodu
    }

    public String getHesapTuru() { return hesapTuru; }
    public void setHesapTuru(String hesapTuru) { this.hesapTuru = hesapTuru; }  //getter ve Setter metotları
}
