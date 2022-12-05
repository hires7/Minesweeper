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
           if (rand.nextInt(this.pocetMin/this.pocetRiadkov) == this.pocetMin/this.pocetRiadkov - 1) {
               mina = 9;
           }
           for (int j = 0; j < this.pocetStlpcov; j++) {
               this.siet[i][j] = new Stvorec((this.pozX + (j * 32)), (this.pozY + (i * 32)), 32, mina);               
           }
       }
       
       this.ocisluj();
    }
    
    private void ocisluj() {        
        for (int x = 0; x < this.siet.length; x++) {
            for (int y = 0; y < this.siet[0].length; y++) {
                if (this.siet[y][x].getObsah() != 9) {
                    int pocetMin = 0;
                    if (x != 0 && y != 0) {
                        if (this.siet[x - 1][y + 1].getObsah() == 9) {
                            pocetMin++;
                        }
                    }
                    if (y != 0) {
                        if (this.siet[x][y + 1].getObsah() == 9) {
                            pocetMin++;
                        }
                    }
                    if (x != this.siet[0].length && y != 0) {
                        if (this.siet[x + 1][y + 1].getObsah() == 9) {
                            pocetMin++;
                        }
                    }
                    if (x != 0) {
                        if (this.siet[x - 1][y].getObsah() == 9) {
                            pocetMin++;
                        }
                    }
                    if (x != this.siet[0].length) {
                        if (this.siet[x + 1][y].getObsah() == 9) {
                            pocetMin++;
                        }
                    }
                    if (x != 0 && y != this.siet.length) {
                        if (this.siet[x - 1][y - 1].getObsah() == 9) {
                            pocetMin++;
                        }
                    }
                    if (y != this.siet.length) {
                        if (this.siet[x][y - 1].getObsah() == 9) {
                            pocetMin++;
                        }
                    }
                    if (x != this.siet[0].length && y != this.siet.length) {
                        if (this.siet[x + 1][y - 1].getObsah() == 9) {
                            pocetMin++;
                        }
                    }
                    this.siet[x][y].zmenObsah(pocetMin); 
                }
            }
        }
    }
    
    public void vyberStvorec(int x, int y) {
        this.siet[x][y].stlac();
    }
    
    public void zobrazVsetko() {
        for (int y = 0; y <= this.siet.length; y++) {
            for (int x = 0; x <= this.siet[0].length; x++) {
                this.siet[x][y].zobraz();
            }
        }
    }
    
    public String getObsah(int x, int y) {
        return null;
    }
}
