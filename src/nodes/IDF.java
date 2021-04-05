package nodes;

public abstract class IDF extends Node{

    private String type;
    private String name;
    private Boolean declared=false;
    private Boolean said=false;

    public IDF(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public IDF(String name) {
        this.name = name;
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

    public Boolean getSaid() {
        return said;
    }

    public Boolean getDeclared() {
        return declared;
    }

    public void makeDeclared(){
        declared=true;
    }

    public void makeSaid(){
        said=true;
    }

    public abstract void setValue(Object o);

    @Override
    public String toString() {
        return name;
    }
}
