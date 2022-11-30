
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
    private Obrazok tlacitko;
    private int x;
    private int y;
    private int cas;
    private boolean jeStlacene;
    
    public Tlacitko(int x, int y) {
        this.x = x;
        this.y = y;
        this.jeStlacene = false;
        this.cas = 0;
        
        this.tlacitko = new Obrazok("pics//smajlík.png");
        this.tlacitko.posunVodorovne(-100);
        this.tlacitko.posunZvisle(-100);
        this.tlacitko.zobraz();
    }
    
    public void stlac() {
        
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void tik() {        
        if (this.jeStlacene && this.cas < 10) {
            this.cas++;
            this.tlacitko.zmenObrazok("");
        } else {
            this.tlacitko.zmenObrazok("");
            this.jeStlacene = false;
        }
    }
}
