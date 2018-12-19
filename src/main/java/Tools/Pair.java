package Tools;

public class Pair {
    private String key;
    private String value;


    public Pair(String key, String value)   {
        this.key=key;
        this.value=value;
    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
