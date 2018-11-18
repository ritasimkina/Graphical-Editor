package Screen.DrawArray;

public class Circle {
    double cx=0, cy=0, cr=100;
    int stroke_width=2;

    int r=255, g=0,b=0;
    int r2=255, g2=0,b2=0;

    String rgb_html(int r,int g, int b)   {
        return "rgb(" +r+ "," +g+ "," +b+ ")";
    }

    String get_html() {
        String s;
        s= "<circle cx='" +cx+ "' cy='" +cy+ "' r='" +cr+ "' stroke='"+rgb_html(r,g,b)+"' stroke-width='" +stroke_width+ "' fill='"+rgb_html(r2,g2,b2)+"' />";
        return s;
    }
}
