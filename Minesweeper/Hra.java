
/**
 * Write a description of class Hra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hra {
        
    /*private int pocetRiadkov;
    private int pocetStlpcov;
    private int pocetMin;
    private int pozX;
    private int pozY;*/
    
    private Lista lista;
    private Siet siet;
    private Manazer manazer;
    private boolean ide;

    public Hra(int pocetRiadkov, int pocetStlpcov, int pocetMin/*, int pozX, int PozY*/) {
       this.ide = false;
        /*this.pocetRiadkov = pocetRiadkov;
       this.pocetStlpcov = pocetStlpcov;
       this.pocetMin = pocetMin;
       this.pozX = pozX + 16;
       this.pozY = pozY + 56;*/
       if((pocetRiadkov * pocetStlpcov - pocetMin) > 0) {
           this.manazer = new Manazer();
           this.manazer.spravujObjekt(this);
           
           this.lista = new Lista(this.manazer, pocetStlpcov);
           
           this.siet = new Siet(pocetRiadkov, pocetStlpcov, pocetMin, 0+16, 0+56);
           
           this.lista.setCasovacIde(true);
           this.ide = true;
           //this.siet.zobrazVsetko();
        } else {
            System.out.println("Pri tvorbe hre doslo k chybe:\npocet min bol nastaveny na prilis vysoku hodnotu");
        }
    }
    
    public void vyberSuradnice(int x, int y) {
        
        if (this.lista.stlacTlacitko(x, y)) {
            this.ide = true;
            this.siet.resetujSiet();
            this.lista.resetujCasovac();
            this.siet.setnajdenaMina(false);
        }
        
        if (!ide) {
            return;
        }
        
        if (y > 45) {
            x /= 32;
            y = (y - 55) / 32;
            //System.out.println(x + "  " + y);
            this.siet.vyberStvorec(y, x);
        }
        
        if (this.siet.getnajdenaMina()) {
            this.lista.setCasovacIde(false);
            this.siet.zobrazVsetkyMiny();
            this.ide = false;
        }
    }
    
    public void zobrazVsetko() {
        this.siet.zobrazVsetko();
    }
}
