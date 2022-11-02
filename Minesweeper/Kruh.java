import java.awt.geom.Ellipse2D;

/**
 * Kruh, s ktorým možno pohybovať a nakreslí sa na plátno.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class Kruh {
    private int priemer;
    private int lavyHornyX;
    private int lavyHornyY;
    private String farba;
    private boolean jeViditelny;
    
    /**
     * Vytvor nový kruh preddefinovanej farby na preddefinovanej pozícii. 
     */
    public Kruh() {
        this.priemer = 30;
        this.lavyHornyX = 20;
        this.lavyHornyY = 60;
        this.farba = "blue";
        this.jeViditelny = false;
    }

    /**
     * (Kruh) Zobraz sa.
     */
    public void zobraz() {
        this.jeViditelny = true;
        this.nakresli();
    }
    
    /**
     * (Kruh) Skry sa.
     */
    public void skry() {
        this.zmaz();
        this.jeViditelny = false;
    }
    
    /**
     * (Kruh) Posuň sa vpravo o pevnú dĺžku. 
     */
    public void posunVpravo() {
        this.posunVodorovne(20);
    }

    /**
     * (Kruh) Posuň sa vľavo o pevnú dĺžku. 
     */
    public void posunVlavo() {
        this.posunVodorovne(-20);
    }

    /**
     * (Kruh) Posuň sa hore o pevnú dĺžku. 
     */
    public void posunHore() {
        this.posunZvisle(-20);
    }

    /**
     * (Kruh) Posuň sa dole o pevnú dĺžku. 
     */
    public void posunDole() {
        this.posunZvisle(20);
    }

    /**
     * (Kruh) Posuň sa vodorovne o dĺžku danú parametrom. 
     */
    public void posunVodorovne(int vzdialenost) {
        this.zmaz();
        this.lavyHornyX += vzdialenost;
        this.nakresli();
    }

    /**
     * (Kruh) Posuň sa zvisle o dĺžku danú parametrom. 
     */
    public void posunZvisle(int vzdialenost) {
        this.zmaz();
        this.lavyHornyY += vzdialenost;
        this.nakresli();
    }

    /**
     * (Kruh) Posuň sa pomaly vodorovne o dĺžku danú parametrom. 
     */
    public void pomalyPosunVodorovne(int vzdialenost) {
        int delta;

        if (vzdialenost < 0) {
            delta = -1;
            vzdialenost = -vzdialenost;
        } else {
            delta = 1;
        }

        for (int i = 0; i < vzdialenost; i++) {
            this.lavyHornyX += delta;
            this.nakresli();
        }
    }

    /**
     * (Kruh) Posuň sa pomaly zvisle o dĺžku danú parametrom. 
     */
    public void pomalyPosunZvisle(int vzdialenost) {
        int delta;

        if (vzdialenost < 0) {
            delta = -1;
            vzdialenost = -vzdialenost;
        } else {
            delta = 1;
        }

        for (int i = 0; i < vzdialenost; i++) {
            this.lavyHornyY += delta;
            this.nakresli();
        }
    }

    /**
     * (Kruh) Zmeň priemer na hodnotu danú parametrom.
     * Priemer musí byť nezáporné celé číslo. 
     */
    public void zmenPriemer(int priemer) {
        this.zmaz();
        this.priemer = priemer;
        this.nakresli();
    }

    /**
     * (Kruh) Zmeň farbu na hodnotu danú parametrom.
     * Nazov farby musí byť po anglicky.
     * Možné farby sú tieto:
     * červená - "red"
     * žltá    - "yellow"
     * modrá   - "blue"
     * zelená  - "green"
     * fialová - "magenta"
     * čierna  - "black"
     */
    public void zmenFarbu(String farba) {
        this.farba = farba;
        this.nakresli();
    }

    /*
     * Draw the circle with current specifications on screen.
     */
    private void nakresli() {
        if (this.jeViditelny) {
            Platno canvas = Platno.dajPlatno();
            canvas.draw(this, this.farba, new Ellipse2D.Double(this.lavyHornyX, this.lavyHornyY, 
                                                          this.priemer, this.priemer));
            canvas.wait(10);
        }
    }

    /*
     * Erase the circle on screen.
     */
    private void zmaz() {
        if (this.jeViditelny) {
            Platno canvas = Platno.dajPlatno();
            canvas.erase(this);
        }
    }
}
