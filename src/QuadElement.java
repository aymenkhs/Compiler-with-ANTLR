
public class QuadElement {
    private String element[] = new String[4];

    public QuadElement(String val1, String val2, String val3, String val4)
    {
        this.element[0] = val1;
        this.element[1] = val2;
        this.element[2] = val3;
        this.element[3] = val4;
    }

    public String getVal(int indice) {
        return this.element[indice];
    }

    public void setVal(int indice, String val) {
        this.element[indice]=val;
    }

    public String ToString() {
        return "(" + element[0] + "," + element[1] + "," + element[2] + "," + element[3] + ")";
    }
}