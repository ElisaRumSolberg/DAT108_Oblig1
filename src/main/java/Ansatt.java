public class Ansatt {
    private String fornavn;
    private String etternavn;
    private Kjonn kjonn;
    private String stilling;
    private int aarslonn;


    public Ansatt(String fornavn, String etternavn,
                  Kjonn kjonn, String stilling, int aarslonn) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.kjonn = kjonn;
        this.stilling = stilling;
        this.aarslonn = aarslonn;
    }

    public int getAarslonn() {
        return aarslonn;
    }

    public void setAarslonn(int aarslonn) {
        this.aarslonn = aarslonn;
    }

    public Kjonn getKjonn() {
        return kjonn;
    }

    @Override
    public String toString() {
        return fornavn + " " + etternavn
                + ", " + kjonn
                + ", " + stilling
                + ", lønn: " + aarslonn;
    }

}
