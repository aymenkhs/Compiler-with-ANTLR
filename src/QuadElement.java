
import nodes.*;

public class QuadElement {
    private String operateur;
    private Node operande1, operande2, resultats;
    private int num;

    public QuadElement(String operateur, Node operande1, Node operande2, Node resultats, int num) {
        this.operateur = operateur;
        this.operande1 = operande1;
        this.operande2 = operande2;
        this.resultats = resultats;
        this.num = num;
    }

    public String getOperateur() {
        return operateur;
    }

    public void setOperateur(String operateur) {
        this.operateur = operateur;
    }

    public Node getOperande1() {
        return operande1;
    }

    public void setOperande1(Node operande1) {
        this.operande1 = operande1;
    }

    public Node getOperande2() {
        return operande2;
    }

    public void setOperande2(Node operande2) {
        this.operande2 = operande2;
    }

    public Node getResultats() {
        return resultats;
    }

    public void setResultats(Node resultats) {
        this.resultats = resultats;
    }

    @Override
    public String toString() {
        return "(" + operateur + "," + operande1 + "," + operande2 + "," + resultats + ")";
    }

}