public class Idf_float extends IDF{

    private float value;

    public Idf_float(String type, String name) {
        super(type, name);
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString()+"Idf_float{" +
                "value=" + value +
                '}';
    }
}
