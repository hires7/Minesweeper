import java.awt.Rectangle;

/**
 * Write a description of class Stvorec here.
 * 
 * @author (Maros Roncak) 
 * @version (a version number or a date)
 */
public class Stvorec {
    private int poziciaX;
    private int poziciaY;
    private int stranaA;
    private int obsah;
    private Obrazok obrazok;
    private boolean jeZobrazene;
    public Stvorec(int poziciaX, int poziciaY, int stranaA, int obsah) {
        this.obrazok = new Obrazok("pics//Stvorec.png");
        this.obrazok.zmenPolohu(poziciaX, poziciaY);
        this.obrazok.zobraz();
        this.poziciaX = poziciaX;
        this.poziciaY = poziciaY;
        this.stranaA = stranaA;
        this.obsah = obsah;
    }
    
    public void zobraz() {
        if(!jeZobrazene) {
            this.obrazok.zmenObrazok("pics//Stvorec.png");
        }
        
    }
    
    public void stlac() {
        this.jeZobrazene = true;
        this.obrazok.zmenObrazok("pics//StvorecTmavy.png");
    }

    public int getObsah() {
        return this.obsah;
    }
    
    public boolean getStavZobrazenia() {        
       return this.jeZobrazene;    
    }
    
    public int getPoziciaX() {
        return this.poziciaX;
    }
    
    public int getPoziciaY() {
        return this.poziciaY;
    }   
}
