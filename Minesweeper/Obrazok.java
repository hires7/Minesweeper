import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;

/**
 * Trieda Obrazok, reprezentuje bitmapovy obrazok, ktory moze byt vykresleny na platno.
 * 
 * @author Miroslav Kvassay
 * @author Michal Varga
 * 
 * @version 1.1
 */
public class Obrazok {
    private boolean jeViditelny;
    
    private int lavyHornyX;
    private int lavyHornyY;
    private int uhol;
    
    private BufferedImage obrazok;

    /**
     * Parametricky konstruktor vytvori Obrazok na pozicii paX, paY s natocenim paUhol
     * 
     * @param suborSObrazkom cesta k suboru s obrazkom, ktory sa ma vykreslovat
     */
    public Obrazok(String suborSObrazkom) {      
        this.obrazok = this.nacitajObrazokZoSuboru(suborSObrazkom);                                   
 
        this.jeViditelny = false;
        this.lavyHornyX = 100;
        this.lavyHornyY = 100; 
        this.uhol = 0;         
    }
    
    /**
     * (Obrázok) Zobraz sa.
     */
    public void zobraz() {      
        this.jeViditelny = true;
        this.nakresli();
    }
    
    /**
     * (Obrázok) Zobraz sa.
     */
    public void skry() {       
        this.zmaz();
        this.jeViditelny = false;
    }                     
    
    /**
     * (Obrázok) Posuň sa vpravo o pevnú dĺžku.
     */
    public void posunVpravo() {
        this.posunVodorovne(20);
    }

    /**
     * (Obrázok) Posuň sa vľavo o pevnú dĺžku.
     */
    public void posunVlavo() {
        this.posunVodorovne(-20);
    }

    /**
     * (Obrázok) Posuň sa hore o pevnú dĺžku.
     */
    public void posunHore() {
        this.posunZvisle(-20);
    }

    /**
     * (Obrázok) Posuň sa dole o pevnú dĺžku.
     */
    public void posunDole() {
        this.posunZvisle(20);
    }

    /**
     * (Obrázok) Posuň sa vodorovne o dĺžku danú parametrom.
     */
    public void posunVodorovne(int vzdialenost) {
        this.zmaz();
        this.lavyHornyX += vzdialenost;
        this.nakresli();
    }

    /**
     * (Obrázok) Posuň sa zvisle o dĺžku danú parametrom.
     */
    public void posunZvisle(int vzdialenost) {
        this.zmaz();
        this.lavyHornyY += vzdialenost;
        this.nakresli();
    }

    /**
     * (Obrázok) Posuň sa pomaly vodorovne o dĺžku danú parametrom.
     */
    public void pomalyPosunVodorovne(int vzdialenost) {
        int delta;

        if (vzdialenost < 0) {
            delta = -1;
            vzdialenost = -vzdialenost;
        } else  {
            delta = 1;
        }

        for (int i = 0; i < vzdialenost; i++) {
            this.lavyHornyX += delta;
            this.nakresli();
        }
    }

    /**
     * (Obrázok) Posuň sa pomaly vodorovne o dĺžku danú parametrom.
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
     * (Obrázok) Zmení obrázok.
     * Súbor s obrázkom musí existovať.
     * 
     * @param suborSObrazkom cesta k súboru s obrázkom, ktorý sa má načítať
     */
    public void zmenObrazok(String suborSObrazkom) {
        boolean nakresleny = this.jeViditelny;
        this.zmaz();        
        this.obrazok = this.nacitajObrazokZoSuboru(suborSObrazkom);
        if (nakresleny) {
            this.nakresli();
        }
    }    
    
    /**
     * (Obrázok) Zmeň polohu stredu obrázka na hodnoty dané parametrami. 
     */
    public void zmenPolohu(int stredX, int stredY) {
        boolean nakresleny = this.jeViditelny;
        this.zmaz();
        this.lavyHornyX = stredX - this.sirka() / 2;
        this.lavyHornyY = stredY - this.vyska() / 2;
        if (nakresleny) {
            this.nakresli();
        }
    }
    
    /**
     * (Obrázok) Zmeň uhol natočenia obrázku podľa parametra. Sever = 0.
     */
    public void zmenUhol(int uhol) {
        boolean nakresleny = this.jeViditelny;
        this.zmaz();
        this.uhol = uhol;
        if (nakresleny) {
            this.nakresli();
        }
    }  
    
    /*
     * Načíta obrázok zo súboru.
     */
    private BufferedImage nacitajObrazokZoSuboru(String subor) {
        BufferedImage nacitanyOBrazok = null;
        
        try {
            nacitanyOBrazok = ImageIO.read(new File(subor));
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "Subor " + subor + " sa nenasiel.");
        }        
        
        return nacitanyOBrazok;
    }     
    
    /*
     * (Obrázok) Vráti všírku obrázka.
     */
    private int sirka() {
        return this.obrazok.getWidth();
    }
    
    /*
     * (Obrázok) Vráti výšku obrázka.
     */
    private int vyska() {
        return this.obrazok.getHeight();
    }    
    
    /*
     * Draw the square with current specifications on screen.
     */
    private void nakresli() {
        if (this.jeViditelny) {
            Platno canvas = Platno.dajPlatno();
        
            AffineTransform at = new AffineTransform();
            at.translate(this.lavyHornyX + this.sirka() / 2, lavyHornyY + this.vyska() / 2);
            at.rotate(this.uhol / 180.0 * Math.PI);
            at.translate(-this.sirka() / 2, -this.vyska() / 2);
        
            canvas.draw(this, obrazok, at);
            canvas.wait(10);
        }
    }

    /*
     * Erase the square on screen.
     */
    private void zmaz() {
        if (this.jeViditelny) {
            Platno canvas = Platno.dajPlatno();
            canvas.erase(this);
        }
    }
    
}
