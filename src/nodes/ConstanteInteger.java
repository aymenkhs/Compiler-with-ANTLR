package nodes;

public class ConstanteInteger extends Constante{

    private int value;

    public ConstanteInteger(String type, int value) {
        super(type);
        this.value = value;
    }

    public ConstanteInteger() {}

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
