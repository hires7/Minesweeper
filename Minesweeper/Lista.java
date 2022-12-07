
/**
 * Lišta obsahujúca časovač a tlačítko
 * 
 * @author Jakub Danco
 * @author Adam Jelža
 * 
 * @version 1.0
 */
public class Lista {
    
    private Tlacitko tlacitko;
    private int pocetStlpcov;
    
    private Manazer manazer;
    private Obdlznik pozadie;
    
    private Casovac casovac;
    
    /**
     * konštruktor - vytvorý pozadie, časovač a tlačitko
     */
    public Lista(Manazer manazer, int pocetStlpcov) {
        this.pocetStlpcov = pocetStlpcov;
        
        this.manazer = manazer;
        
        this.pozadie = new Obdlznik();
        this.pozadie.zmenStrany(this.pocetStlpcov * 32, 45);
        this.pozadie.zmenFarbu("gray");
        this.pozadie.zobraz();
        this.casovac = new Casovac(10, 20);
        if (this.pocetStlpcov < 6) {
            this.casovac.zmenPoziciu(this.pocetStlpcov * 32 - 70, 20);
        }
        
        this.tlacitko = new Tlacitko(this.pocetStlpcov * 32 / 2, 20);
        this.manazer.spravujObjekt(this.tlacitko);
    }
    
    /**
     * Zistí či ide časovač
     */
    public boolean getCasovacIde() {
        return this.casovac.getIde();
    }
    
    /**
     * nastaví chod časovaču podla zadanej hodnoti
     */
    public void setCasovacIde(boolean ide) {
        this.casovac.setIde(ide);
    }
    
    /**
     * Stlačí tlačítko
     */
    public boolean stlacTlacitko(int x, int y) {        
        if (x >= this.tlacitko.getX() - 16 && x <= this.tlacitko.getX() + 16 && y >= this.tlacitko.getY() - 16 && y <= this.tlacitko.getY() + 16) {
            this.tlacitko.stlac();
            return true;
        }
        return false;
    }
    
    /**
     * resetuje čas v časovači
     */
    public void resetujCasovac() {
        this.casovac.resetujCas();
    }
}
