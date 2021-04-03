package nodes;

public class ConstanteString extends Constante{

    private String value;

    public ConstanteString(String type, String value) {
        super(type);
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
