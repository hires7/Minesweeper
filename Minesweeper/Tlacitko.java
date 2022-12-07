/**
 * Tlačitko resetujúce hru
 * 
 * @author Adam Jelža
 * @version 1.0
 */
public class Tlacitko {
    private Obrazok pozadie;
    private Obrazok tlacitko;
    private int x;
    private int y;
    private int cas;
    private boolean jeStlacene;
    
    /**
     * Konštruktor - vytvorý pozadie a smajlíka
     */
    public Tlacitko(int x, int y) {
        this.x = x;
        this.y = y;
        this.jeStlacene = false;
        this.cas = 11;
        
        this.pozadie = new Obrazok("pics\\Stvorec1.png");
        this.pozadie.zmenPolohu(this.x, this.y);
        this.pozadie.zobraz();
        
        this.tlacitko = new Obrazok("pics//smajlík.png");
        this.tlacitko.zmenPolohu(this.x, this.y);
        this.tlacitko.zobraz();
    }
    
    /**
     * Stlačí tlačidlo
     */
    public void stlac() {        
        this.jeStlacene = true;
        this.cas = 0;       
    }
    
    /**
     * Získa polohu na osi x
     */
    public int getX() {
        return this.x;
    }
    
    /**
     * Získa polohu na osi y
     */
    public int getY() {
        return this.y;
    }
    
    /**
     * Zobrazí animáciu stlacenia tlacitka
     */
    public void tik() {
        if (!this.jeStlacene) {
            return;
        }
        if (this.cas < 8) {
            this.cas++;
            this.pozadie.zmenObrazok("pics\\StvorecTmavy1.png");
            this.tlacitko.zobraz();
        } else {
            this.pozadie.zmenObrazok("pics\\Stvorec1.png"); 
            this.tlacitko.zobraz();
            this.jeStlacene = false;
        }
    }
}
