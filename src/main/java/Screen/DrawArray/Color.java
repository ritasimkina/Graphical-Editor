package Screen.DrawArray;

public class Color {
    int r=0, g=0,b=0;

    public Color(int r, int g, int b) {
        this.r=r;
        this.g=g;
        this.b=b;
    }

    public String gethtml()   {
        return "rgb(" +r+ "," +g+ "," +b+ ")";
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
