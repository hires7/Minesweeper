/**
 * Trieda Casovac vytvori casovac v lavom hornom rohu obrazovky
 * 
 * !!!Potrebuje manazera!!!
 * 
 * @author Jakub Danco
 * @version 1.0
 */
public class Casovac {
    
    private Manazer manazer;
    
    private int pozX;
    private int pozY;
    
    private int cas;
    
    private CisloCasovaca cislo1;       //Minuty * 10
    private CisloCasovaca cislo2;       //Minuty
    private CisloCasovaca cislo3;       //Sekundy * 10
    private CisloCasovaca cislo4;       //Sekundy
    
    private Obdlznik bodka1;
    private Obdlznik bodka2;
    
    public Casovac() {
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
        
        this.pozX = 20;
        this.pozY = 25;
        
        this.cas = 0;
        
        this.cislo1 = new CisloCasovaca(this.pozX, this.pozY);
        this.cislo2 = new CisloCasovaca(this.pozX + 20, this.pozY);
        this.cislo3 = new CisloCasovaca(this.pozX + 49, this.pozY);
        this.cislo4 = new CisloCasovaca(this.pozX + 69, this.pozY);
        
        this.bodka1 = new Obdlznik();
        this.bodka2 = new Obdlznik();
        
        this.vytvorDvojBodku();
    }
    
    public void tik() {
        cas++;
        
        //Tik sa spusti 4 krat za sekundu, this.cas % 4 pripocita cislo len kazdu sekundu
        if (this.cas % 4 == 0) {
            if (this.cislo2.getCislo() == 9) {
                this.cislo1.pridajCislo();
                this.cislo2.vynuluj();
                this.cislo3.vynuluj();
                this.cislo4.vynuluj();
            } else if (this.cislo3.getCislo() == 5 && this.cislo4.getCislo() == 9) {
                this.cislo2.pridajCislo();
                this.cislo3.vynuluj();
                this.cislo4.vynuluj();
            } else if (this.cislo4.getCislo() == 9) {
                this.cislo3.pridajCislo();
                this.cislo4.vynuluj();
            } else {
                this.cislo4.pridajCislo();
            }
        }
    }
    
    private void vytvorDvojBodku() {
        this.bodka1.posunVodorovne(52);
        this.bodka2.posunVodorovne(52);
        
        this.bodka1.posunZvisle(18);
        this.bodka2.posunZvisle(27);
        
        this.bodka1.zmenStrany(5, 5);
        this.bodka2.zmenStrany(5, 5);
        
        this.bodka1.zobraz();
        this.bodka2.zobraz();
    }
    
    public void zmenPoziciu(int x, int y) {
        this.cislo1.skry();
        this.cislo2.skry();
        this.cislo3.skry();
        this.cislo4.skry();
        
        this.cislo1 = new CisloCasovaca(x, y);
        this.cislo2 = new CisloCasovaca(x + 20, y);
        this.cislo3 = new CisloCasovaca(x + 49, y);
        this.cislo4 = new CisloCasovaca(x + 69, y);
        
        this.bodka1.posunVodorovne(-this.pozX);
        this.bodka2.posunVodorovne(-this.pozX);
        
        this.bodka1.posunVodorovne(x);
        this.bodka2.posunVodorovne(x);
        
        this.bodka1.posunZvisle(-this.pozY);
        this.bodka2.posunZvisle(-this.pozY);
        
        this.bodka1.posunZvisle(y);
        this.bodka2.posunZvisle(y);
        
        this.pozX = x;
        this.pozY = y;
    }
}
