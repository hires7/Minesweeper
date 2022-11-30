import java.util.Random;
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
       this.pozY = pozY + 16;
       Random rand = new Random();
       
       this.siet = new Stvorec[pocetRiadkov][pocetStlpcov];
       for (int i = 0; i < pocetRiadkov; i++) {
           int mina = 0;
           if (rand.nextInt(pocetMin/pocetRiadkov) == pocetMin/pocetRiadkov - 1) {
               mina = 1;
           }
           for (int j = 0; j < pocetStlpcov; j++) {
               this.siet[i][j] = new Stvorec((this.pozX + (j * 32)), (this.pozY + (i * 32)), 32, mina); 
               
           }
       }
    }
    
    public void vyberStvorec(int x, int y) {
        this.siet[x][y].stlac();
    }
}
