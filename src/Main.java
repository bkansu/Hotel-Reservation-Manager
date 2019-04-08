import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws ParseException {
        Otel otel = new Otel(12);
        Scanner sc = new Scanner(System.in);
        otel.addOda(new TekYataklıOda(true, 101));
        otel.addOda(new TekYataklıOda(true, 102));
        otel.addOda(new TekYataklıOda(false, 103));
        otel.addOda(new TekYataklıOda(false, 104));
        otel.addOda(new ÇiftYataklıOda(true, 105));
        otel.addOda(new ÇiftYataklıOda(true, 106));
        otel.addOda(new ÇiftYataklıOda(false, 107));
        otel.addOda(new ÇiftYataklıOda(false, 108));
        otel.addOda(new IkizYataklıOda(true, 109));
        otel.addOda(new IkizYataklıOda(true, 110));
        otel.addOda(new IkizYataklıOda(false, 111));
        otel.addOda(new IkizYataklıOda(false, 112));
        RezervationManager rezervasyonmenejeri = new RezervationManager(otel);


        System.out.println("Mevcut odalarımız ve özellikleri :");/* Otel tipindeki objemizin içerisinde yer alan odaların tamamını
         while+for döngüleri içerisinde yazdırıyoruz.. */
        int k = 1;
        while (k <= 6) {
            if (k == 1)
                System.out.print("Tek yataklı ve havuz manzaralı odalarımız : ");
            if (k == 2)
                System.out.print("Çift yataklı ve havuz manzaralı odalarımız : ");
            if (k == 3)
                System.out.print("İkiz yataklı ve havuz manzaralı odalarımız : ");
            if (k == 4)
                System.out.print("Tek yataklı ve deniz manzaralı odalarımız : ");
            if (k == 5)
                System.out.print("Çift yataklı ve deniz manzaralı odalarımız : ");
            if (k == 6)
                System.out.print("İkiz yataklı ve deniz manzaralı odalarımız : ");

            for (int i = 0; i < otel.getOdalar().length; i++) {
                if (otel.getOdalar()[i].getTip() == k) {
                    System.out.print(otel.getOdalar()[i].getNumara() + " ");
                }

            }
            k++;
            System.out.print("\n");

        }
        int x;

        int menu = 1; /* birden fazla rezervasyon yapabilmemiz için rezervasyon yaptıktan sonra kullanıcıya
         yeniden rezervasyon yapmak isteyip istemediğini sormalı ve rezervasyon yapmak isterse bir arayüze yönlendirmemiz gerek.
          Bunun için menu isimli bir değişken tutarak arayüz oluşturuyoruz... */
        while (menu != 0) {


            System.out.println("Oda numarasına göre rezervasyon yapmak için (1)'e Oda tipine göre " +
                    "rezervasyon yapmak için (2)'ye Girilen tarihler arasındaki müsait odaları görmek için (3)'e basınız");
            x = sc.nextInt();
            if(x==3){
                System.out.println("Rezervasyon başlangıç tarihini (gg/aa/yyyy) biçiminde giriniz...");
                String tarih1 = sc.next();
                System.out.println("Rezervasyon bitiş tarihini (gg/aa/yyyy) biçiminde giriniz...");
                String tarih2 = sc.next();
                rezervasyonmenejeri.rezervasyonSorgula((format.parse(tarih1)), (format.parse(tarih2)));

            }
            if (x == 2) {
                int flag = 0;

                while (flag == 0) {
                    System.out.println("Rezervasyon yapmak istediğiniz oda tipini(1-6) biçiminde giriniz...");
                    int tip = sc.nextInt();
                    for (int i = 0; i < otel.getOdalar().length; i++) {
                        if ((otel.getOdalar())[i].getTip() == tip) {
                            System.out.println("Rezervasyon başlangıç tarihini (gg/aa/yyyy) biçiminde giriniz...");
                            String tarih1 = sc.next();
                            System.out.println("Rezervasyon bitiş tarihini (gg/aa/yyyy) biçiminde giriniz...");
                            String tarih2 = sc.next();
                            if (otel.isOdaMüsait((otel.getOdalar())[i], format.parse(tarih1), format.parse(tarih2))) {
                                Rezervation rezervation = new Rezervation(format.parse(tarih1), format.parse(tarih2));
                                otel.makeRezervation((otel.getOdalar())[i], rezervation);
                                System.out.println(tip + " tipindeki " + (otel.getOdalar())[i].getNumara() + " numaralı oda girdiğiniz tarihler için rezerve edilmiştir...");
                                flag=1;
                                System.out.println("Yeniden rezervasyon yapmak için (1)'e çıkmak için (0)'a basınız...");
                                menu = sc.nextInt();
                                break;
                            } else {
                                System.out.println("Girdiğiniz Tarihler için " + tip + " tipinde müsait odamız yoktur...");
                                flag=1;
                                System.out.println("Yeniden rezervasyon yapmak için (1)'e çıkmak için (0)'a basınız...");
                                menu = sc.nextInt();
                                break;
                            }
                        }

                    }
                    if (flag == 0) {
                        System.out.println(tip + " tipinde bir odamız yoktur. Lütfen geçerli bir tip numarası giriniz...");
                    }

                }
            }
            if (x == 1) {
                int flag = 0;
                while (flag == 0) {
                    System.out.println("Rezervasyon yapmak istediğiniz oda numarasını giriniz...");
                    int tip = sc.nextInt();


                    for (int i = 0; i < otel.getOdalar().length; i++) {
                        if ((otel.getOdalar())[i].getNumara() == tip) {
                            flag = 1;
                            System.out.println("Rezervasyon başlangıç tarihini (gg/aa/yyyy) biçiminde giriniz...");
                            String tarih1 = sc.next();
                            System.out.println("Rezervasyon bitiş tarihini (gg/aa/yyyy) biçiminde giriniz...");
                            String tarih2 = sc.next();
                            if (otel.isOdaMüsait((otel.getOdalar())[i], format.parse(tarih1), format.parse(tarih2))) {
                                Rezervation rezervation = new Rezervation(format.parse(tarih1), format.parse(tarih2));
                                otel.makeRezervation((otel.getOdalar())[i], rezervation);
                                System.out.println(otel.getOdalar()[i].getTip() + " tipindeki " + tip + " numaralı oda girdiğiniz tarihler için rezerve edilmiştir...");
                                System.out.println("Yeniden rezervasyon yapmak için (1)'e çıkmak için (0)'a basınız...");
                                menu = sc.nextInt();
                            } else {
                                System.out.println("Girilen tarihler için " + tip + " numaralı oda müsait değildir...");
                                System.out.println("Yeniden rezervasyon yapmak için (1)'e çıkmak için (0)'a basınız...");
                                menu = sc.nextInt();
                            }
                        }

                    }
                    if (flag == 0) {
                        System.out.println(tip + " Numaralı bir odamız yoktur. Lütfen geçerli bir oda numarası giriniz...");
                    }
                }

            }
            if(x!= 1 && x!= 2 && x!=3){
                System.out.println("Hatalı giriş yaptınız...Lütfen 1, 2 veya 3'ü tuşlayın");
            }
        }
    }
}
