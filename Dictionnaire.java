import java.math.BigInteger;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dictionnaire {

    private HTNaive tableHachage;

    public Dictionnaire(int m) {
        this.tableHachage = new HTNaive(m);
    }

    public Dictionnaire(String fileName, int m) {
        this.tableHachage = new HTNaive(Dictionnaire.calculeListeInt(fileName), m);
    }

    public Dictionnaire(String fileName, double f) {
        this.tableHachage = new HTNaive(Dictionnaire.calculeListeInt(fileName), f);
    }

    public static BigInteger stringToBigInteger(String s) {

        BigInteger res = new BigInteger("0");

        BigInteger multiplieur = new BigInteger("1");

        for (int i = s.length() - 1; i >= 0; i--) {
            
            res = res.add(BigInteger.valueOf((int) s.charAt(i)).multiply(multiplieur));
            multiplieur = multiplieur.multiply(BigInteger.valueOf(256));

        }

        return res;
    }

    public boolean ajout(String s) {

        BigInteger value = Dictionnaire.stringToBigInteger(s);
        return this.tableHachage.ajout(value);

    }

    public boolean contient(String s) {
        return this.tableHachage.contient(Dictionnaire.stringToBigInteger(s));
    }

    public int getCardinal() {
        return this.tableHachage.getCardinal();
    }

    public int getMaxSize() {
        return this.tableHachage.getMaxSize();
    }

    public int getNbListes() {
        return this.tableHachage.getNbListes();
    }
    public long getTotalTimeh() {
        return this.tableHachage.getTotalTimeh();
    }

    public long getTotalTimeContient() {
        return this.tableHachage.getTotalTimeContient();
    }

    public String toString() {
        return "Dictionnaire\n" + this.tableHachage.toString();
    }

    public String toStringV2() {
        return "Dictionnaire\n" + this.tableHachage.toStringV2();
    }

    public static ListeBigI calculeListeInt(String fileName) {

        File f = new File(fileName);
        ListeBigI res = new ListeBigI();
        Scanner sc;

        try {

            sc = new Scanner(f);

        } catch (FileNotFoundException e) {

            System.out.println(("problème d’accès au fichier " + e.getMessage()));
            return null;

        }

        sc.useDelimiter(" |\\n|,|;|:|\\.|!|\\?|-");

        String mot;
        

        while (sc.hasNext()) {

            mot = sc.next();
            res.ajoutTete(Dictionnaire.stringToBigInteger(mot));
            

        }

        sc.close();
        return res;

    }
}
