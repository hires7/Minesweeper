<<<<<<< HEAD
=======
/**
 * Write a description of class Stvorec here.
 * 
 * @author (Maros Roncak) 
 * @version (a version number or a date)
 */
>>>>>>> origin/Stvorec
public class Stvorec {
    private int poziciaX;
    private int poziciaY;
    private int stranaA;
    private int obsah;
<<<<<<< HEAD
    public Stvorec(int poziciaX, int poziciaY, int stranaA, int obsah) {
=======
    private Obrazok obrazok;
    private boolean jeZobrazene;
    
    public Stvorec() {
        this.obrazok = new Obrazok("");
>>>>>>> origin/Stvorec
        this.poziciaX = poziciaX;
        this.poziciaY = poziciaY;
        this.stranaA = stranaA;
        this.obsah = obsah;
    }
    
<<<<<<< HEAD
    public int getObsah(){
        return this.obsah;
    }
    
    public boolean getStavZobrazenia(){
         
    }
    
    public void zobraz(){
        
    }
}
=======
    public int getObsah() {
        return this.obsah;
    }
    
    public boolean getStavZobrazenia() {
        
       return this.jeZobrazene;
    
    }
    
    public void zobraz() {
        if(!jeZobrazene) {
            this.obrazok.zmenObrazok("");
        }
        
    }
    
    public int getPoziciaX() {
        return this.poziciaX;
    }
    
    public int getPoziciaY() {
        return this.poziciaY;
    }
    
}
>>>>>>> origin/Stvorec
