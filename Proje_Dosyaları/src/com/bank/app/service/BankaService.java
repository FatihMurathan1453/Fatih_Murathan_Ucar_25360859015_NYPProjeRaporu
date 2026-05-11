package com.bank.app.service;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;
import com.bank.app.people.Musteri; //gerekli sınıfların importu

// Banka iş mantığını yöneten servis sınıfı
// Tüm işlemler bu sınıf üzerinden gerçekleştirilmektedir
public class BankaService {


    public void musteriOlustur(Musteri musteri) { //müşteri kaydı için metot
        System.out.println("Müşteri oluşturuldu: " + musteri.getAd() + " " + musteri.getSoyad()); //müşteri kaydının oluşturulduğunu konsola basma
    }

    public void hesapAc(Musteri musteri, String hesapTuru) { //müşteri kaydı için metot
        musteri.hesapEkle(hesapTuru); //musteri nesnesinden hesapEkle metodunu çağırarak müşteri ekler
        System.out.println(hesapTuru + " hesabı açıldı."); //müşterinin eklendiğini konsola basar
    }

    public void paraYatir(BankaHesabi hesap, double miktar) { //hesaba para eklemek için metot
        hesap.setBakiye(hesap.getBakiye() + miktar); //hesap nesnesinden SetBakiye metodunu çağırarak bakiye ekler
        System.out.println(miktar + " TL hesaba yatırıldı. Yeni bakiye: " + hesap.getBakiye()); //paranın yüklendiğini konsola basar
    }

    public void yatirimYap(YatirimHesabi hesap, double miktar) {// yatırım hesabına para yüklemek için metot
        hesap.paraEkle(miktar); //hesap nesnesinden paraEkle metodunu çağırarak bakiye ekler
    }


    public void transferYap(VadesizHesap araciHesap, BankaHesabi gonderenHesap, BankaHesabi aliciHesap, double miktar) { //para transferi için metot
        araciHesap.paraTransferi(aliciHesap, gonderenHesap, miktar); //araciHesap sınıfından paraTransferi metodunu kullanarak transfer yapar
    }

    // Müşteriye yeni bir kredi kartı tanımlar (limitli)
    public void krediKartiAta(Musteri musteri, double limit) {
        musteri.krediKartiEkle(limit);
        System.out.println("Kredi kartı tanımlandı.");
    }

    // Vadesiz hesaptan kredi kartı borcunu öder
    public void borcOde(VadesizHesap hesap, KrediKarti kart, double miktar) {
        hesap.krediKartiBorcOdeme(kart, miktar);
    }

    // Müşterinin hesabını siler (bakiye kontrolü Musteri sınıfında yapılır)
    public void hesapSil(Musteri musteri, BankaHesabi hesap) {
        musteri.hesapSil(hesap);
    }
}
