import java.awt.Rectangle;

/**
 * Stvorec(jedno pličko siete)
 * 
 * @author Maros Roncak 
 * @version 1.0
 */
public class Stvorec {
    private int poziciaX;
    private int poziciaY;
    private int stranaA;
    private int obsah;
    private Obrazok obrazok;
    private Obrazok pozadie;
    private boolean jeZobrazene;
    
    /**
     * konštruktor - vytvorí obrázok obsahu ako skrytý a pozadie
     */
    public Stvorec(int poziciaX, int poziciaY, int stranaA, int obsah) {
        this.pozadie = new Obrazok("pics//StvorecTmavy.png");
        this.pozadie.zmenPolohu(poziciaX, poziciaY);
        this.pozadie.zobraz();
        
        this.obrazok = new Obrazok("pics//Stvorec.png");
        this.obrazok.zmenPolohu(poziciaX, poziciaY);
        this.obrazok.zobraz();
        
        this.poziciaX = poziciaX;
        this.poziciaY = poziciaY;
        this.stranaA = stranaA;
        this.obsah = obsah;
        this.zmenObsah(this.obsah);
        
    }
    
    /**
     * Zobrazí obsah štvorca
     */
    public void zobraz() {
        if(!jeZobrazene) {
            this.obrazok.zmenObrazok("pics//Stvorec.png");
            switch (this.obsah) {
                case 0:
                    this.obrazok.zmenObrazok("pics\\StvorecTmavy.png"); //blank
                    break;
                case 1:
                    this.obrazok.zmenObrazok("pics\\1.png");
                    break;
                case 2:
                    this.obrazok.zmenObrazok("pics\\2.png");
                    break;
                case 3:
                    this.obrazok.zmenObrazok("pics\\3.png");
                    break;
                case 4:
                    this.obrazok.zmenObrazok("pics\\4.png");
                    break;
                case 5:
                    this.obrazok.zmenObrazok("pics\\5.png");
                    break;
                case 6:
                    this.obrazok.zmenObrazok("pics\\6.png");
                    break;
                case 7:
                    this.obrazok.zmenObrazok("pics\\7.png");
                    break;
                case 8:
                    this.obrazok.zmenObrazok("pics\\8.png");
                    break;
                case 9:
                    this.obrazok.zmenObrazok("pics\\mine.png");
                    
                    break;
            }
            this.jeZobrazene = true;
        }
    }
    
    /**
     * Zmení Obsah Stvorca na zadanu hodnotu
     */
    public void zmenObsah(int novyObsah) {
        this.obsah = novyObsah;
    }
    
    /**
     * Vráti obsah Stvorca
     */
    public int getObsah() {
        return this.obsah;
    }
    
    /**
     * Vráti informáciu či je štvorec zobrazený
     */
    public boolean getStavZobrazenia() {        
       return this.jeZobrazene;    
    }
    
    /**
     * Vráti informáciu či má štvorec v sebe mínu
     */
    public boolean maMinu() {
        if (obsah == 9) {
            return true;
        }
        return false;
    }
    
    /**
     * Vráti poziciuX
     */
    public int getPoziciaX() {
        return this.poziciaX;
    }
    
    /**
     * Vráti poziciuY
     */
    public int getPoziciaY() {
        return this.poziciaY;
    }   
}
