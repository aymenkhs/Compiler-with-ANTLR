package nodes;

public abstract class IDF extends Node{

    private String type;
    private final String name;
    private final Boolean declared;
    private boolean initialized = false;

    public IDF(String type, String name) {
        this.type = type;
        this.name = name;
        this.declared = true;
    }

    public IDF(String name) {
        this.name = name;
        this.declared = false;
    }

    public void initialize() {
        initialized = true;
    }

    public boolean isInitialized() {
        return this.initialized;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public Boolean isDeclared() {
        return declared;
    }

    public abstract void setValue(Object o);

    @Override
    public String toString() {
        return name;
    }
}
