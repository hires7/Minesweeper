/**
 * Tlačitko resetujúce hru
 * 
 * @author Adam Jelža
 * @version 1.0
 */
public class Tlacitko {
    /**
     * Constructor for objects of class Tlacidlo
     */
    private Obrazok pozadie;
    private Obrazok tlacitko;
    private int x;
    private int y;
    private int cas;
    private boolean jeStlacene;
    
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
    
    public void stlac() {        
        this.jeStlacene = true;
        this.cas = 0;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void tik() {
        if (!jeStlacene){
            return;
        }
        if (this.cas < 10) {
            this.cas++;
            this.pozadie.zmenObrazok("pics\\StvorecTmavy1.png");
        } else {
            this.pozadie.zmenObrazok("pics\\Stvorec1.png"); 
            this.tlacitko.zobraz();
            this.jeStlacene = false;
        }
    }
}
