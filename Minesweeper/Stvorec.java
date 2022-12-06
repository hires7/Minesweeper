import java.awt.Rectangle;

/**
 * Write a description of class Stvorec here.
 * 
 * @author Maros Roncak 
 * @version 0.1
 */
public class Stvorec {
    private int poziciaX;
    private int poziciaY;
    private int stranaA;
    private int obsah;
    private Obrazok obrazok;
    private Obrazok pozadie;
    private boolean jeZobrazene;
    
    public Stvorec(int poziciaX, int poziciaY, int stranaA, int obsah) {
        this.obrazok = new Obrazok("pics//Stvorec.png");
        this.obrazok.zmenPolohu(poziciaX, poziciaY);
        this.obrazok.zobraz();
        
        this.pozadie = new Obrazok("pics//StvorecTmavy.png");
        this.pozadie.zmenPolohu(poziciaX, poziciaY);
        this.pozadie.zobraz();
        
        this.poziciaX = poziciaX;
        this.poziciaY = poziciaY;
        this.stranaA = stranaA;
        this.obsah = obsah;
        this.zmenObsah(this.obsah);
        
    }
    
    public void zobraz() {
        if(!jeZobrazene) {
            this.obrazok.zmenObrazok("pics//Stvorec.png");
            switch (this.obsah) {
                case 1:
                    this.obrazok.zmenObrazok("pics\\StvorecTmavy.png"); //blank
                case 0:
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
    
    public void zmenObsah(int novyObsah) {
        this.obsah = novyObsah;
        
    }

    public int getObsah() {
        return this.obsah;
    }
    
    public boolean getStavZobrazenia() {        
       return this.jeZobrazene;    
    }
    
    public boolean maMinu() {
        if (obsah == 9) {
            return true;
        }
        return false;
    }
    
    public int getPoziciaX() {
        return this.poziciaX;
    }
    
    public int getPoziciaY() {
        return this.poziciaY;
    }   
}
