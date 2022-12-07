/**
 * Trieda Cislo
 * 
 * @author Jakub Danco
 * @version 1.0
 */
public class CisloCasovaca {
    
    private int pozX;
    private int pozY;
    
    private int cislo;
    
    private Obrazok obrazok;
    
    /**
     * Konštruktor - vytvory číslo časovaca
     */
    public CisloCasovaca(int x, int y) {
        this.pozX = x;
        this.pozY = y;
        this.cislo = 0;
        this.obrazok = new Obrazok("pics\\dig0.png");
        this.obrazok.zmenPolohu(this.pozX, this.pozY);
        this.obrazok.zobraz();
    }
    
    /**
     * Zvysi cislo o 1
     */
    public void pridajCislo() {
        if (this.cislo != 9) {
            this.cislo++;
            this.obrazok.zmenObrazok("pics\\dig" + this.cislo + ".png");
        } else {
            this.cislo = 0;
            this.obrazok.zmenObrazok("pics\\dig" + this.cislo + ".png");
        }
    }
    
    /**
     * Skryje číslo časovača
     */
    public void skry() {
        this.obrazok.skry();
    }
    
    /**
     * Zmení číslo na 0
     */
    public void vynuluj() {
        this.cislo = 0;
        this.obrazok.zmenObrazok("pics\\dig" + this.cislo + ".png");
    }
    
    /**
     * Získa hodnotu atribútu číslo
     */
    public int getCislo() {
        return this.cislo;
    }
}
