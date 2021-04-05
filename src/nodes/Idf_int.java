package nodes;

public class Idf_int extends IDF {

    private int value;

    public Idf_int(String type, String name) {
        super(type, name);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public void setValue(Object o) {
        this.value = (int) o;
    }

    @Override
    public String toString() {
        return super.toString()+"  Idf_int{" +
                "value=" + value +
                '}';
    }
}
