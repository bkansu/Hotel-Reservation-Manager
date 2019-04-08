public class ÇiftYataklıOda extends Oda {/* Oda sınıfından türetilmiş  bir sınıf. İçerisinde sadece constructor ve property var.. */
    public ÇiftYataklıOda(boolean havuzManzarali, int numara) {
        super(havuzManzarali, numara);
    }

    @Override
    public int getTip() {
        return havuzManzarali?2:5;
    }
}
