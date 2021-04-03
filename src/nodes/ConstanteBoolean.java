package nodes;

public class ConstanteBoolean extends Constante{

    private boolean value;

    public ConstanteBoolean(String type, boolean value) {
        super(type);
        this.value = value;
    }

    public Boolean getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value + "";
    }
}
