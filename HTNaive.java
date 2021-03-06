import java.math.BigInteger;

public class HTNaive {

    private ListeBigI[] table;
    private long totalTimeh;
    private long totalTimeContient;

    public HTNaive(int m) {
        this.table = new ListeBigI[m];
        this.totalTimeh = 0;
        this.totalTimeContient = 0;
        for (int i = 0; i < m; i++)
            this.table[i] = new ListeBigI();
    }

    public HTNaive(ListeBigI l, int m) {
        this(m);
        this.ajoutListe(l);
    }

    public HTNaive(ListeBigI l, double f) {
        this(l, (int) (f * HTNaive.cardListe(l)));
    }

    private static int cardListe(ListeBigI l) {
        HTNaive temporaire = new HTNaive(l, 1000);
        return temporaire.getCardinal();
    }

    public ListeBigI getListe(int i) {
        return this.table[i];
    }

    public long getTotalTimeh() {
        return this.totalTimeh;
    }

    public long getTotalTimeContient() {
        return this.totalTimeContient;
    }

    private int h(BigInteger u) {
        long deb = System.currentTimeMillis();
        int res = u.mod(BigInteger.valueOf(this.table.length)).intValue();
        long fin = System.currentTimeMillis();
        this.totalTimeh += (fin - deb);
        return res;
    }

    public boolean contient(BigInteger u) {
        long deb = System.currentTimeMillis();
        boolean res = this.table[this.h(u)].contient(u);
        long fin = System.currentTimeMillis();
        this.totalTimeContient += (fin - deb);
        return res;
    }

    public boolean ajout(BigInteger u) {
        return this.contient(u) ? false : this.ajoutAux(u);
    }

    private boolean ajoutAux(BigInteger u) {
        this.table[this.h(u)].ajoutTete(u);
        return true;
    }

    public void ajoutListe(ListeBigI L) {

        ListeBigI listeCourante = new ListeBigI(L);
        while (!listeCourante.estVide())
            this.ajout(listeCourante.supprTete());

    }

    public ListeBigI getElements() {

        ListeBigI L = new ListeBigI();

        for (int i = 0; i < this.table.length; i++)
            L.ajoutListe(this.table[i]);

        return L;
    }

    public String toString() {

        String res = "";

        for (int i = 0; i < this.table.length; i++)
            res += "Table[" + i + "] : "
                    + this.table[i].toString()
                    + "\n";

        return res;
    }

    public int getNbListes() {
        return this.table.length;
    }

    public int getCardinal() {
        return this.getElements().longueur();
    }

    public int getMaxSize() {

        int res = 0;

        for (int i = 0; i < this.table.length; i++)
            if (this.table[i].longueur() > res)
                res = this.table[i].longueur();

        return res;
    }

    public String toStringV2() {

        String res = "";

        for (int i = 0; i < this.table.length; i++)

            if (!this.table[i].estVide()) {

                res += "Table[" + i + "] : ";

                for (int j = 0; j < this.table[i].longueur(); j++)
                    res += "*";

                res += "\n";
            }

        return res;
    }
}