
public class QuadElement {
    private String operateur, operande1, operande2, resultats;

    public QuadElement(String operateur, String operande1, String operande2, String resultats) {
        this.operateur = operateur;
        this.operande1 = operande1;
        this.operande2 = operande2;
        this.resultats = resultats;
    }

    public String getOperateur() {
        return operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    public String getOperande1() {
        return operande1;
    }

    public void setOperande1(String operande1) {
        this.operande1 = operande1;
    }

    public String getOperande2() {
        return operande2;
    }

    public void setOperande2(String operande2) {
        this.operande2 = operande2;
    }

    public String getResultats() {
        return resultats;
    }

    public void setResultats(String resultats) {
        this.resultats = resultats;
    }

    @Override
    public String toString() {
        return "(" + operateur + "," + operande1 + "," + operande2 + "," + resultats + ")";
    }

}