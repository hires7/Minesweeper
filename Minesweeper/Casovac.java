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
    private boolean ide;
    
    private int pozX;
    private int pozY;
    
    private int cas;
    
    private Obrazok pozadie;
    
    private CisloCasovaca cislo2;       //Minuty
    private CisloCasovaca cislo3;       //Sekundy * 10
    private CisloCasovaca cislo4;       //Sekundy
    
    public Casovac(int x, int y) {
        this.manazer = new Manazer();
        this.manazer.spravujObjekt(this);
        
        this.ide = false;
        
        this.pozX = x;
        this.pozY = y;
        
        this.cas = 0;
        
        this.pozadie = new Obrazok("pics\\cas_pozadie.png");
        this.pozadie.zmenPolohu(this.pozX + 40, this.pozY);
        this.pozadie.zobraz();
        
        this.cislo2 = new CisloCasovaca(this.pozX + 22, this.pozY);
        this.cislo3 = new CisloCasovaca(this.pozX + 40, this.pozY);
        this.cislo4 = new CisloCasovaca(this.pozX + 58, this.pozY);
    }
    
    public boolean getIde() {
        return this.ide;
    }
    
    public void setIde(boolean ide) {
        this.ide = ide;
    }
    
    public void tik() {
        if (!ide) {
            return;
        }
        cas++;
        
        //Tik sa spusti 4 krat za sekundu, this.cas % 4 pripocita cislo len kazdu sekundu
        if (this.cas % 4 == 0) {
            if (this.cislo3.getCislo() == 5 && this.cislo4.getCislo() == 9) {
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
    
    public void zmenPoziciu(int x, int y) {
        this.pozX = x;
        this.pozY = y;
        
        this.cislo2.skry();
        this.cislo3.skry();
        this.cislo4.skry();
        
        this.pozadie.zmenPolohu(this.pozX + 40, this.pozY);
        this.pozadie.zobraz();
        
        this.cislo2 = new CisloCasovaca(x + 20, y);
        this.cislo3 = new CisloCasovaca(x + 40, y);
        this.cislo4 = new CisloCasovaca(x + 60, y);
    }
}