package com.bank.app.cards;

import java.util.Random; //gerekli sınıfların importu

// Kredi kartı bilgilerini tutan sınıf
public class KrediKarti {

    private String kartNumarasi; //kart numarası için String değişken oluşturma
    private double limit; //kart limiti için double değişken oluşturma
    private double guncelBorc; //güncel borç için double değişken oluşturma
    private double kullanilabilirLimit; //kartın kullanılabilir limiti için double değişken oluşturma

    public KrediKarti(double limit, double guncelBorc) { //
        this.kartNumarasi = olusturKartNumarasi();
        this.limit = limit;
        this.guncelBorc = guncelBorc;
        this.kullanilabilirLimit = limit - guncelBorc;
    }

    // 4 ile başlayan 16 haneli rastgele kart numarası üretimi
    private String olusturKartNumarasi() {//rastgele kart numarası üretmek için metot
        long sayi = Math.abs(new Random().nextLong()) % 1000000000000000L; //
        return String.format("4%015d", sayi); //
    }

    private void guncelleKullanilabilirLimit() { //kullanılabilir limiti güncellemek için fonksiyon
        this.kullanilabilirLimit = this.limit - this.guncelBorc;
    }

    @Override //aşağıdaki metodun override yapacağının hatırlatması için koydum
    public String toString() {
        return "KrediKarti{kartNumarasi='" + kartNumarasi + "', limit=" + limit +
               ", guncelBorc=" + guncelBorc + ", kullanilabilirLimit=" + kullanilabilirLimit + "}"; //toString metodu
    }


    public String getKartNumarasi() { return kartNumarasi; } //kart numarasını getter metodu ile elde etme
    public void setKartNumarasi(String kartNumarasi) { this.kartNumarasi = kartNumarasi; } //kart numarasını setter metodu ile değiştirme

    public double getLimit() { return limit; } //kart limitini getter metodu elde etme
    public void setLimit(double limit) { //kart limitini setter metodu ile değiştirme
        this.limit = limit; //parametre olarak aldığımız "limit"'i değişken "limit"'e atama
        guncelleKullanilabilirLimit(); //kullanılabilir limiti değiştirecek fonksiyonu çağırma
    }

    public double getGuncelBorc() { return guncelBorc; } //güncel borcu getter metodu ile elde etme
    public void setGuncelBorc(double guncelBorc) { //güncel borcu setter metodu ile değiştirme
        this.guncelBorc = guncelBorc; //parametre olarak aldığımız "guncelBorc"'u değişken "guncelBorc"'a atama
        guncelleKullanilabilirLimit(); //kullanılabilir limiti değiştirecek fonksiyonu çağırma
    }

    public double getKullanilabilirLimit() { return kullanilabilirLimit; } //kullanılabilir limiti getter metodu ile elde etme
}
