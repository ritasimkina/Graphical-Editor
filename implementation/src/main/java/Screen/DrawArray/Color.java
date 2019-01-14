package Screen.DrawArray;

import java.util.StringTokenizer;

public class Color {
    int r=0, g=0,b=0;

    public Color(int r, int g, int b) {
        this.r=r;
        this.g=g;
        this.b=b;
    }
    public Color(String rgb) {
        // rgb(r,g,b)
        rgb=rgb.replace("rgb(","");
        rgb=rgb.replace(")","");
        StringTokenizer tok = new StringTokenizer(rgb,",");
        this.r= Integer.valueOf(tok.nextToken()) ;
        this.g= Integer.valueOf(tok.nextToken()) ;
        this.b= Integer.valueOf(tok.nextToken()) ;
    }

    public String gethtml()   {
        return "rgb(" +r+ "," +g+ "," +b+ ")";
    }
    public String gethtml(boolean inverted)   {
        if (inverted) return "rgb(" + (255-r) + "," + (255-g) + "," + (255-b) + ")";
        else return gethtml();
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
