package nodes;

public class Idf_String extends IDF{

    private String value;

    public Idf_String(String type, String name) {
        super(type, name);
        this.value = null;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void setValue(Object o) {
        this.value = (String) o;
    }

    @Override
    public String toString() {
        return super.toString()+"  Idf_String{" +
                "value='" + value + '\'' +
                '}';
    }
}
