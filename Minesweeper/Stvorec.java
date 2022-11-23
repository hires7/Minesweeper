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
    
    public Stvorec() {
        this.obrazok = new Obrazok(null);
        this.poziciaX = poziciaX;
        this.poziciaY = poziciaY;
        this.stranaA = stranaA;
        this.obsah = obsah;
    }
    
    public int getObsah() {
        return this.obsah;
    }
    
    public boolean getStavZobrazenia() {
        
       return this.jeZobrazene;
    
    }
    
    public void zobraz() {
        if(!jeZobrazene) {
            this.obrazok.zmenObrazok(null);
        }
        
    }
    
}