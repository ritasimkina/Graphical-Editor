package Tools;

public class Pair {
    private String key;
    private String value;


    public Pair(String key, String value)   {
        this.key=key;
        this.value=value;
    }

    public Pair(Pair pair) {
        key=pair.key;
        value=pair.value;
    }

    public String getKey() {
        return key;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
