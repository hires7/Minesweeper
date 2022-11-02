import java.awt.Polygon;

/**
 * Rovnoramenný trojuholník, s ktorým možno pohybovať a nakreslí sa na plátno.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0  (15 July 2000)
 */

public class Trojuholnik {
    private int vyska;
    private int zakladna;
    private int lavyHornyX; // lavy horny bod oblasti
    private int lavyHornyY; // lavy horny bod oblasti
    private String farba;
    private boolean jeViditelny;

    /**
     * Vytvor nový rovnoramenný trojuholník preddefinovanej farby na preddefinovanej pozícii.
     */
    public Trojuholnik() {
        this.vyska = 30;
        this.zakladna = 40;
        this.lavyHornyX = 50;
        this.lavyHornyY = 15;
        this.farba = "green";
        this.jeViditelny = false;
    }

    /**
     * (Trujuholník) Zobraz sa.
     */
    public void zobraz() {
        this.jeViditelny = true;
        this.nakresli();
    }
    
    /**
     * (Trujuholník) Skry sa.
     */
    public void skry() {
        this.zmaz();
        this.jeViditelny = false;
    }
    
    /**
     * (Trujuholník) Posuň sa vpravo o pevnú dĺžku.
     */
    public void posunVpravo() {
        this.posunVodorovne(20);
    }

    /**
     * (Trujuholník) Posuň sa vľavo o pevnú dĺžku.
     */
    public void posunVlavo() {
        this.posunVodorovne(-20);
    }

    /**
     * (Trujuholník) Posuň sa hore o pevnú dĺžku.
     */
    public void posunHore() {
        this.posunZvisle(-20);
    }

    /**
     * (Trujuholník) Posuň sa dole o pevnú dĺžku.
     */
    public void posunDole() {
        this.posunZvisle(20);
    }

    /**
     * (Trujuholník) Posuň sa vodorovne o dĺžku danú parametrom.
     */
    public void posunVodorovne(int vzdialenost) {
        this.zmaz();
        this.lavyHornyX += vzdialenost;
        this.nakresli();
    }

    /**
     * (Trujuholník) Posuň sa zvisle o dĺžku danú parametrom.
     */
    public void posunZvisle(int vzdialenost) {
        this.zmaz();
        this.lavyHornyY += vzdialenost;
        this.nakresli();
    }

    /**
     * (Trujuholník) Posuň sa pomaly vodorovne o dĺžku danú parametrom.
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
     * (Trujuholník) Posuň sa pomaly zvisle o dĺžku danú parametrom.
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
     * (Trujuholník) Zmeň rozmery výšky a základne na hodnoty dané parametrami.
     * Obe hodnoty musia byť nezáporné celé čísla. 
     */
    public void zmenRozmery(int vyska, int zakladna) {
        this.zmaz();
        this.vyska = vyska;
        this.zakladna = zakladna;
        this.nakresli();
    }


    /**
     * (Trujuholník) Zmeň farbu na hodnotu danú parametrom.
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
     * Draw the triangle with current specifications on screen.
     */
    private void nakresli() {
        if (this.jeViditelny) {
            Platno canvas = Platno.dajPlatno();
            int[] xpoints = { this.lavyHornyX, this.lavyHornyX + (this.zakladna / 2), this.lavyHornyX - (this.zakladna / 2) };
            int[] ypoints = { this.lavyHornyY, this.lavyHornyY + this.vyska, this.lavyHornyY + this.vyska };
            canvas.draw(this, this.farba, new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
        }
    }

    /*
     * Erase the triangle on screen.
     */
    private void zmaz() {
        if (this.jeViditelny) {
            Platno canvas = Platno.dajPlatno();
            canvas.erase(this);
        }
    }
}
