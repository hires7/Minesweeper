
/**
 * Write a description of class Lista here.
 * 
 * @author Jakub Danco 
 * @version 1.0
 */
public class Lista {
    
    private Tlacitko tlacitko;
    private int pocetStlpcov;
    
    private Manazer manazer;
    private Obdlznik pozadie;
    
    private Casovac casovac;
    
    public Lista(Manazer manazer, int pocetStlpcov) {
        this.pocetStlpcov = pocetStlpcov;
        
        this.manazer = manazer;
        
        this.pozadie = new Obdlznik();
        this.pozadie.zmenStrany(this.pocetStlpcov * 32, 45);
        this.pozadie.zmenFarbu("gray");
        this.pozadie.zobraz();
        this.casovac = new Casovac();
        
        this.tlacitko = new Tlacitko(this.pocetStlpcov * 32 / 2, 20);
        this.manazer.spravujObjekt(this.tlacitko);
    }
    
    public void stlacTlacitko(int x, int y) {        
        if (x >= this.tlacitko.getX() - 16 && x <= this.tlacitko.getX() + 16 && y >= this.tlacitko.getY() - 16 && y <= this.tlacitko.getY() + 16) {
            this.tlacitko.stlac();
            System.out.println("Stlacene");
        }
    }
}
