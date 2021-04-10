package nodes;

public class Idf_float extends IDF{

    private float value;

    public Idf_float(String type, String name) {
        super(type, name);
    }

    public float getValue() {
        return value;
    }


    @Override
    public void setValue(Object o) {
        this.value = (float) o;
    }

    @Override
    public String toString() {
        return "{nom var : '"+super.toString()+"', type var : floatCompil}\n";
    }
}
