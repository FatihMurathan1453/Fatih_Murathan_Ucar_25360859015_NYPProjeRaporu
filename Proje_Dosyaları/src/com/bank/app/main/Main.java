package com.bank.app.main;

import com.bank.app.accounts.BankaHesabi;
import com.bank.app.accounts.VadesizHesap;
import com.bank.app.accounts.YatirimHesabi;
import com.bank.app.cards.KrediKarti;
import com.bank.app.people.BankaPersoneli;
import com.bank.app.people.Musteri;
import com.bank.app.service.BankaService; //gerekli sınıfların importu

public class Main {
    public static void main(String[] args) {

        BankaService bankaService = new BankaService(); //BankaService sınıfından benkaservice adlı yeni bir nesne oluşturma

        //Banka Personeli Oluşturma
        BankaPersoneli personel = new BankaPersoneli("Ayşe", "Kaya", "ayse.kaya@banka.com", 3); //5321234567
        System.out.println("Personel ID: " + personel.getPersonelID());
        System.out.println(personel);
        System.out.println("\n"); //güzel gözüksün diye araya boşluk

        //1-Müşteri Oluşturma
        Musteri musteri1 = new Musteri("Ahmet", "Yılmaz", "ahmet.yilmaz@mail.com", 5); //5551234567
        bankaService.musteriOlustur(musteri1);
        System.out.println("Müşteri No: " + musteri1.getMusteriNumarasi());
        System.out.println(musteri1);
        System.out.println("\n"); //güzel gözüksün diye araya boşluk

        // Personel müşteriyi kendi listesine ekler
        personel.musteriEkle(musteri1);

        //2-Müşteri Adına Hesap Açma
        bankaService.hesapAc(musteri1, "vadesiz");
        bankaService.hesapAc(musteri1, "yatirim");
        System.out.println("Toplam hesap sayısı: " + musteri1.getHesaplar().size());
        System.out.println("\n"); //güzel gözüksün diye araya boşluk

        //hesaplara erişim
        VadesizHesap vadesizHesap = (VadesizHesap) musteri1.getHesaplar().get(0);
        YatirimHesabi yatirimHesabi = (YatirimHesabi) musteri1.getHesaplar().get(1);

        System.out.println("Vadesiz IBAN: " + vadesizHesap.getIban());
        System.out.println("Yatırım IBAN: " + yatirimHesabi.getIban());
        System.out.println("\n"); //güzel gözüksün diye araya boşluk

        //3-Hesaba Para Yatırma
        bankaService.paraYatir(vadesizHesap, 8000);
        bankaService.yatirimYap(yatirimHesabi, 3000);
        System.out.println("\n"); //güzel gözüksün diye araya boşluk

        //4-Hesaplar Arası Para Transferi
        //vadesiz hesaptan yatırım hesabına 2000 TL transfer
        bankaService.transferYap(vadesizHesap, vadesizHesap, yatirimHesabi, 2000);
        System.out.println("Vadesiz bakiye: " + vadesizHesap.getBakiye());
        System.out.println("Yatırım bakiye: " + yatirimHesabi.getBakiye());
        System.out.println("\n"); //güzel gözüksün diye araya boşluk

        //5-Müşteriye Kredi Kartı Tanımlama
        bankaService.krediKartiAta(musteri1, 10000.0);
        System.out.println("Toplam kart sayısı: " + musteri1.getKrediKartlari().size());

        KrediKarti kart = musteri1.getKrediKartlari().get(0);
        System.out.println("Kart Numarası: " + kart.getKartNumarasi());
        System.out.println("Kart Limiti: " + kart.getLimit());
        System.out.println("Kullanılabilir Limit: " + kart.getKullanilabilirLimit());

        kart.setGuncelBorc(2500); //kart borcunu setter metodu ile 2500'e ayarlama
        System.out.println("Güncel Borç: " + kart.getGuncelBorc()); //Güncel borcu konsola yazdırma
        System.out.println("Kullanılabilir Limit (güncel): " + kart.getKullanilabilirLimit()); //Kullanılabilir limit ekrana yazdırma
        System.out.println("\n"); //güzel gözüksün diye araya boşluk

        //6-Kredi Kartı Borcu Ödeme
        bankaService.borcOde(vadesizHesap, kart, 1500); //kart borcunu 1500 tl azaltma
        System.out.println("Ödeme sonrası vadesiz bakiye: " + vadesizHesap.getBakiye()); //Vadesiz hesaptaki kalan bakiyeyi konsola yazdırma
        System.out.println("Ödeme sonrası kart borcu: " + kart.getGuncelBorc()); //güncel borcu konsola yazdırma
        System.out.println("\n"); //güzel gözüksün diye araya boşluk

        //7-Hesap Silme İşlemi
        System.out.println("Bakiyeli hesabı silme denemesi:"); //Bakiyeli hesabı silme denemesininin yapıldığını konsola yazdırma
        bankaService.hesapSil(musteri1, yatirimHesabi); //hesap silmek için bankaService sınıfındaki hesapSil fonksiyonunu çağırma

        yatirimHesabi.setBakiye(0); //yatırım hesabındaki bakiyeyi 0'a ayarlama
        System.out.println("Bakiye sıfırlandıktan sonra silme:"); // Bakiyenin sıfırlandığını konsola bastırma
        bankaService.hesapSil(musteri1, yatirimHesabi); //musteri1'in yatırım hesabını silme
        System.out.println("Kalan hesap sayısı: " + musteri1.getHesaplar().size()); //Kalan hesap sayısını konsola bastırma
    }
}
