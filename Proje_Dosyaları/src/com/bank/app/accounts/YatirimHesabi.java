package com.bank.app.accounts;

// Yatırım hesabı işlemlerini gerçekleştiren sınıf
// BankaHesabi sınıfından miras almaktadır
public class YatirimHesabi extends BankaHesabi {

    private String hesapTuru; // UML'de hesapTürü alanı

    public YatirimHesabi() {
        super();
        this.hesapTuru = "Yatirim";
    }

    public YatirimHesabi(double bakiye) { //Başlangıç bakiyesiyle hesap açmak için parametreli constructor
        super(bakiye);
        this.hesapTuru = "Yatirim";
    }

    public void paraEkle(double miktar) { //hesaba para ekleme metodu
        setBakiye(getBakiye() + miktar);
        System.out.println(miktar + " TL yatırım hesabına eklendi.");
    }

    public void paraCek(double miktar) { //hesaptan para çekme metodu
        if (getBakiye() < miktar) {
            System.out.println("Yetersiz bakiye. Para çekme işlemi gerçekleştirilemedi.");
            return;
        }
        setBakiye(getBakiye() - miktar);
        System.out.println(miktar + " TL yatırım hesabından çekildi.");
    }

    @Override //override hatırlatması
    public String toString() {
        return "YatirimHesabi{hesapTuru='" + hesapTuru + "', " + super.toString() + "}"; //toString metodu
    }

    public String getHesapTuru() { return hesapTuru; }
    public void setHesapTuru(String hesapTuru) { this.hesapTuru = hesapTuru; } //getter ve setter metotları
}
