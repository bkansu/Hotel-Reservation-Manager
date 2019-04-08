import java.util.Date;

public class RezervationManager {
    int sorgu;
    private Otel otel;

    public RezervationManager(Otel otel) {
        this.otel = otel;
    }

    void rezervasyonSorgula(Date tarih1, Date tarih2) {
        Oda[] odalar = otel.getOdalar();
        for (Oda oda : odalar) {
            if ((otel.isOdaMüsait(oda, tarih1, tarih2))) {
                System.out.print(oda.getNumara() + " numaralı oda müsait" + "(" + (oda.isHavuzManzarali() ? "Havuz Manzaralı" : "Deniz Manzaralı ") + " ");
                System.out.println(oda.getTip() == 1 || oda.getTip() == 3 ? "Tek Yataklı)" : oda.getTip() == 2 || oda.getTip() == 5 ? "Çift Yataklı)" : "İkiz Yataklı)");
            }
        }
    }

    void rezervasyonYap(int odaNo, Date tarih1, Date tarih2) {
        Oda[] odalar = otel.getOdalar();
        for (Oda oda : odalar) {
            if (oda.getNumara() == odaNo) {
                otel.makeRezervation(oda, new Rezervation(tarih1, tarih2));
                break;
            }
        }
    }

    void rezervasyonIptal(int odaNo, Date tarih1, Date tarih2) {
        Oda[] odalar = otel.getOdalar();
        for (Oda oda : odalar) {
            if(oda.getNumara() == odaNo){
                otel.cancelRezervation(oda,tarih1,tarih2);
                break;
            }
        }
    }

    void dolulukIstatistigiAl() {
        System.out.println("Odaların doluluk oranı = " + otel.dolulukOrani());
    }

    void tarih_ile_doluluk_istatistiği_al(Date tarih1, Date tarih2) {
        System.out.println("Odaların verilen tarihlerde doluluk oranı = "+otel.tarihliDolulukOrani(tarih1, tarih2));
    }

    void tipe_göre_doluluk_istatistiği_al(int tip) {
        System.out.println("Odaların verilen tarihlerde doluluk oranı = "+otel.tipDolulukOrani(tip));
    }



}
