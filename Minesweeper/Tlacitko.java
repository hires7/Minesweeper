
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
    private Stvorec vypln;
    private Stvorec obrys;
    private Obrazok smajlik;
    private int x;
    private int y;
    private boolean jeStlacene;
    
    public Tlacitko(int x, int y) {
        this.x = x;
        this.y = y;
        this.jeStlacene = false;
        
        this.smajlik = new Obrazok("pics//smajlík.png");
        this.smajlik.posunVodorovne(-100);
        this.smajlik.posunZvisle(-100);
        
        this.vypln = new Stvorec();
        this.vypln.posunVodorovne(-60);
        this.vypln.posunZvisle(-50);
        this.vypln.zmenFarbu("yellow");
        
        this.obrys = new Stvorec();
        this.vypln.posunVodorovne(-60);
        this.vypln.posunZvisle(-50);
        this.obrys.zmenFarbu("red");
        
        this.vypln.zobraz();
        this.smajlik.zobraz();
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void tik() {
        if (!this.jeStlacene) {
            return;
        }
        
    }
}
