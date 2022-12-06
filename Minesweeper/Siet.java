import java.util.Random;
/**
 * Trieda podla zvolenej obtiaznosti vytvori siet zo stvocov. Nahodne rozlozi do pola miny
 * 
 * @author Patrik S. Ondreicka 
 * @version 0.1
 */
public class Siet {
    private int pocetRiadkov;
    private int pocetStlpcov;
    private int pocetMin;
    private int pozX;
    private int pozY;
    private Stvorec[][] siet;
    
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
       
       this.siet = new Stvorec[this.pocetRiadkov][this.pocetStlpcov];
       for (int i = 0; i < this.pocetRiadkov; i++) {
           int mina = 0;
           int docPocetMin = this.pocetMin;
           
           if (rand.nextInt(9) == 1 && docPocetMin > 0) {
                mina = 9;
                docPocetMin--;
           }
           
           for (int j = 0; j < this.pocetStlpcov; j++) {
               this.siet[i][j] = new Stvorec((this.pozX + (j * 32)), (this.pozY + (i * 32)), 32, mina);               
           }
       }
       
       this.ocisluj();
    }
    
    private void ocisluj() {        
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
    }
    
    public void vyberStvorec(int x, int y) {
        this.siet[x][y].zobraz();
    }
    
    public void zobrazVsetko() {
        for (int riadok = 0; riadok < this.siet.length; riadok++) {
            for (int stlpec = 0; stlpec < this.siet[0].length; stlpec++) {
                this.siet[riadok][stlpec].zobraz();
            }
        }
    }
    
    public String getObsah(int x, int y) {
        return null;
    }
}
