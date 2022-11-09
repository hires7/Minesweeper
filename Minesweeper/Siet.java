
/**
 * Trieda podla zvolenej obtiaznosti vytvori siet zo stvocov. Nahodne rozlozi do pola miny
 * 
 * @author Patrik S. Ondreicka 
 * @version 0.1
 */
public class Siet {
    private int pocetRiadkov;
    private int pocetStlpcov;
    private int pocetMin;
    private int pozX;
    private int pozY;
    private Stvorec[][] siet;
    
    /**
     * Trieda hra vlozi parametre o rozmeroch a pocte min podla obztiaznosti
     */
    public Siet(int pocetRiadkov, int pocetStlpcov, int pocetMin, int pozX, int PozY) {
       this.pocetRiadkov = pocetRiadkov;
       this.pocetStlpcov = pocetStlpcov;
       this.pocetMin = pocetMin;
       this.pozX = pozX;
       this.pozY = pozY;
       
       this.siet = new Stvorec[pocetRiadkov][pocetStlpcov];
    }
}
