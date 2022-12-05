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
    private int maMinu;
    
    public Stvorec(int poziciaX, int poziciaY, int stranaA, int maMinu) {
        this.obrazok = new Obrazok("pics//Stvorec.png");
        this.obrazok.zmenPolohu(poziciaX, poziciaY);
        this.obrazok.zobraz();
        this.poziciaX = poziciaX;
        this.poziciaY = poziciaY;
        this.stranaA = stranaA;
        this.obsah = maMinu;
        this.maMinu = maMinu;
        this.zmenObsah(this.maMinu);
    }
    
    public void zobraz() {
        if(!jeZobrazene) {
            this.obrazok.zmenObrazok("pics//Stvorec.png");
            switch (this.obsah) {
                case 0:
                    this.obrazok.zmenObrazok("pics\\StvorecTmavy.png");
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
        }
        
    }
    
    public void stlac() {
        this.jeZobrazene = true;
        this.obrazok.zmenObrazok("pics//StvorecTmavy.png");
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
        if (maMinu == 9) {
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
