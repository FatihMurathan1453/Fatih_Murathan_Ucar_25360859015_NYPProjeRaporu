package com.bank.app.accounts;

import java.util.Random;

// Tüm hesap türlerinin temel özelliklerini barındıran sınıf
// VadesizHesap ve YatirimHesabi bu sınıftan miras almaktadır
public class BankaHesabi {

    private String iban;
    private double bakiye;

    public BankaHesabi() {
        this.iban = olusturIban();
        this.bakiye = 0.0; // Varsayılan constructor: IBAN otomatik üretilir, bakiye sıfırdan başlar
    }

    public BankaHesabi(double bakiye) {
        this.iban = olusturIban();
        this.bakiye = bakiye;  // Başlangıç bakiyesiyle hesap açmak için parametreli constructor
    }


    protected String olusturIban() { // TR + 16 haneli rastgele sayı ile IBAN üretir
        long sayi = Math.abs(new Random().nextLong()) % 10000000000000000L;
        return String.format("TR%016d", sayi);
    }

    @Override //overrride hatırlatması
    public String toString() {
        return "BankaHesabi{iban='" + iban + "', bakiye=" + bakiye + "}"; //toStiring Metodu
    }

    public String getIban() { return iban; }
    public void setIban(String iban) { this.iban = iban; }

    public double getBakiye() { return bakiye; }
    public void setBakiye(double bakiye) { this.bakiye = bakiye; } //getter ve Setter metotları
}
