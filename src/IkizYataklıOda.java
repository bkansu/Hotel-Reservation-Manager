public class IkizYataklıOda extends Oda {/* Oda sınıfından türetilmiş  bir sınıf. İçerisinde sadece constructor ve property var.. */
    public IkizYataklıOda(boolean havuzManzarali, int numara) {
        super(havuzManzarali, numara);
    }

    @Override
    public int getTip() {
        return havuzManzarali?3:6;
    }
}
