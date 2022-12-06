
/**
 * Write a description of class Hra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hra {
        
    private int pocetRiadkov;
    private int pocetStlpcov;
    private int pocetMin;
    private int pozX;
    private int pozY;
    
    private Lista lista;
    private Siet siet;
    private Manazer manazer;
    
    public Hra(int pocetRiadkov, int pocetStlpcov, int pocetMin, int pozX, int PozY) {
       this.pocetRiadkov = pocetRiadkov;
       this.pocetStlpcov = pocetStlpcov;
       this.pocetMin = pocetMin;
       this.pozX = pozX + 16;
       this.pozY = pozY + 56;
       
       this.manazer = new Manazer();
       this.manazer.spravujObjekt(this);
       
       this.lista = new Lista(this.manazer, this.pocetStlpcov);
       
       this.siet = new Siet(this.pocetRiadkov, this.pocetStlpcov, this.pocetMin, this.pozX, this.pozY);
       this.siet.zobrazVsetko();
    }
    
    public void vyberSuradnice(int x, int y) {
        this.lista.stlacTlacitko(x, y);
        if (y > 45) {
            x /= 32;
            y = (y - 55) / 32;
            System.out.println(x + "  " + y);
            this.siet.vyberStvorec(y, x);
        }
    }
    
    public void zobrazVsetko() {
        this.siet.zobrazVsetko();
    }
}
