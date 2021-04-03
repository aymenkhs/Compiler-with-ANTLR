package nodes;

public class IDF extends Node{

    private String type;
    private String name;

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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IDF{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
