import java.util.Random;

/**
 * Trieda podla zvolenej obtiaznosti vytvori siet zo stvocov. Nahodne rozlozi do pola miny
 * 
 * @author Patrik S. Ondreicka 
 * @author Adam Jelža
 * 
 * @version 1.0
 */
public class Siet {
    private int pocetRiadkov;
    private int pocetStlpcov;
    private int pocetMin;
    private int pozX;
    private int pozY;
    private Stvorec[][] siet;
    
    private boolean najdenaMina;

    /**
     * Trieda hra vlozi parametre o rozmeroch a pocte min podla obztiaznosti
     */
    public Siet(int pocetRiadkov, int pocetStlpcov, int pocetMin, int pozX, int pozY) {
        this.pocetRiadkov = pocetRiadkov;
        this.pocetStlpcov = pocetStlpcov;
        this.pocetMin = pocetMin;
        this.pozX = pozX;
        this.pozY = pozY + 16;
        Random rand = new Random();
        this.najdenaMina = false;

        this.siet = new Stvorec[this.pocetRiadkov][this.pocetStlpcov];

        int pocMinNaRiad = pocetMin / this.pocetRiadkov;
        int pocMinNaRiadZvysok = pocetMin % this.pocetRiadkov;
        int pocMinNaPriadanie = this.pocetMin;
        for (int i = 0; i < this.pocetRiadkov; i++) {
            int mina = 0;
            int docPocetMin = this.pocetMin;
            for (int j = 0; j < this.pocetStlpcov; j++) {
                this.siet[i][j] = new Stvorec((this.pozX + (j * 32)), (this.pozY + (i * 32)), 32, 0);               
            }
        }

        for (int i = 0; i < this.pocetRiadkov; i++) {
            int pocMinNaTentoRiad = pocMinNaRiad;
            while (pocMinNaTentoRiad != 0) {
                for (int j = 0; j < this.pocetStlpcov; j++) {
                    if (pocMinNaTentoRiad > 0 && rand.nextInt(this.pocetStlpcov) == this.pocetStlpcov - 1) {
                        this.siet[i][j].zmenObsah(9);
                        pocMinNaTentoRiad--;
                        pocMinNaPriadanie--;
                    }
                    if (pocMinNaTentoRiad <= 0) {
                        break;
                    }
                }
            }
        }

        while (pocMinNaRiadZvysok > 0 || pocMinNaPriadanie > 0) {
            Stvorec vybStvorec = this.siet[rand.nextInt(this.pocetRiadkov)][rand.nextInt(this.pocetStlpcov)]; 
            if (vybStvorec.getObsah() != 9) {
                vybStvorec.zmenObsah(9);
                pocMinNaPriadanie--;
                pocMinNaRiadZvysok--;
            }
        }

        this.ocisluj();
    }
    
    /**
     * Zistí či v sieti bola nájdená/odokrytá mína
     */
    public boolean getNajdenaMina() {
        return this.najdenaMina;
    }
    
    /**
     * nastaví atribút najdená mína na zadanú hodnotu
     */
    public void setNajdenaMina(boolean najdenaMina) {
        this.najdenaMina = najdenaMina;
    }
    
    /*private void ocisluj() {        
    for (int riadok = 0; riadok < this.siet.length; riadok++) {
    for (int stlpec = 0; stlpec < this.siet[0].length; stlpec++) {
    if (this.siet[riadok][stlpec].getObsah() != 9) {
    int pocetMin = 0;
    if (riadok != 0 && stlpec != 0) { //pravy horny
    if (this.siet[riadok - 1][stlpec - 1].getObsah() == 9) {
    pocetMin++;
    }
    }
    if (riadok != 0) { //horny
    if (this.siet[riadok - 1][stlpec].getObsah() == 9) {
    pocetMin++;
    }
    }
    if (riadok != 0 && stlpec != this.siet[0].length - 1) { //lavy horny
    if (this.siet[riadok - 1][stlpec + 1].getObsah() == 9) {
    pocetMin++;
    }
    }
    if (stlpec != 0) { //lavy
    if (this.siet[riadok][stlpec - 1].getObsah() == 9) {
    pocetMin++;
    }
    }
    if (stlpec != this.siet[0].length - 1) { //pravy
    if (this.siet[riadok][stlpec + 1].getObsah() == 9) {
    pocetMin++;
    }
    }
    if (stlpec != 0 && riadok != this.siet.length - 1) { //lavydole
    if (this.siet[riadok + 1][stlpec - 1].getObsah() == 9) {
    pocetMin++;
    }
    }
    if (riadok != this.siet.length - 1) { //dole
    if (this.siet[riadok + 1][stlpec].getObsah() == 9) {
    pocetMin++;
    }
    }
    if (riadok != this.siet.length - 1 && stlpec != this.siet[0].length - 1) { //pravy dole
    if (this.siet[riadok + 1][stlpec + 1].getObsah() == 9) {
    pocetMin++;
    }
    }
    this.siet[riadok][stlpec].zmenObsah(pocetMin); 
    }
    }
    }
    }*/
    
    /**
     * Vloží na policka bez mín počet mín v okolí 1+ políčka
     */
    private void ocisluj() {
        for (int i = 0; i < this.siet.length; i++) {
            for (int j = 0; j < this.siet[0].length; j++) {
                int pocetMinOkolo = 0;
                if (this.siet[i][j].getObsah() != 9) {
                    for (int k = 0; k < 3; k++) {
                        int riadok = i;
                        int stlpec = j;
                        for (int l = 0; l < 3; l++) {
                            riadok =  i - 1 + k;
                            stlpec =  j - 1 + l;
                            if ((riadok >= 0 && riadok < this.pocetRiadkov) && (stlpec >= 0 && stlpec < this.pocetStlpcov)) {
                                if (this.siet[riadok][stlpec].getObsah() == 9) {
                                    pocetMinOkolo++;
                                }
                            }
                        }
                    }
                    this.siet[i][j].zmenObsah(pocetMinOkolo);
                }
            }
        }
    }
    
    /**
     * vyberie štvorec podla suradnic a ak má v sebe mínu, zmení atribut najdenaMina na true
     */
    public void vyberStvorec(int x, int y) {
        this.siet[x][y].zobraz();
        if (this.siet[x][y].getObsah() == 9) {
            this.najdenaMina = true;
        }
    }

    /**
     * odhalí všetky políčka siete
     */
    public void zobrazVsetko() {
        for (int riadok = 0; riadok < this.siet.length; riadok++) {
            for (int stlpec = 0; stlpec < this.siet[0].length; stlpec++) {
                this.siet[riadok][stlpec].zobraz();
            }
        }
    }
    
    /**
     * Odhalí všetky políčka obsahujúce mínu
     */
    public void zobrazVsetkyMiny() {
        for (int riadok = 0; riadok < this.siet.length; riadok++) {
            for (int stlpec = 0; stlpec < this.siet[0].length; stlpec++) {
                if (this.siet[riadok][stlpec].getObsah() == 9) {
                    this.siet[riadok][stlpec].zobraz();
                }
            }
        }
    }
      
    /**
     * restuje siete pre novu hru(zatial nefunguje)
     */
    public void resetujSiet() {
        for (int riadok = 0; riadok < this.siet.length; riadok++) {
            for (int stlpec = 0; stlpec < this.siet[0].length; stlpec++) {
                this.siet[riadok][stlpec].zmenObsah(0);
            }
        }
        
        Random rand = new Random();
        
        int pocMinNaRiad = this.pocetMin / this.pocetRiadkov;
        int pocMinNaRiadZvysok = this.pocetMin % this.pocetRiadkov;
        int pocMinNaPriadanie = this.pocetMin;
        
        for (int i = 0; i < this.pocetRiadkov; i++) {
            int pocMinNaTentoRiad = pocMinNaRiad;
            while (pocMinNaTentoRiad != 0) {
                for (int j = 0; j < this.pocetStlpcov; j++) {
                    if (pocMinNaTentoRiad > 0 && rand.nextInt(this.pocetStlpcov) == this.pocetStlpcov - 1) {
                        this.siet[i][j].zmenObsah(9);
                        pocMinNaTentoRiad--;
                        pocMinNaPriadanie--;
                    }
                    if (pocMinNaTentoRiad <= 0) {
                        break;
                    }
                }
            }
        }

        while (pocMinNaRiadZvysok > 0 || pocMinNaPriadanie > 0) {
            Stvorec vybStvorec = this.siet[rand.nextInt(this.pocetRiadkov)][rand.nextInt(this.pocetStlpcov)]; 
            if (vybStvorec.getObsah() != 9) {
                vybStvorec.zmenObsah(9);
                pocMinNaPriadanie--;
                pocMinNaRiadZvysok--;
            }
        }
        
        
    }
}
