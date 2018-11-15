public class Elipse {
    private double cx=0, cy=0, cr=100;
    private double rx=0, ry=0;
    private int stroke_width=2;

    private int r=255, g=0,b=0;
    private int r2=255, g2=0,b2=0;

    private String rgb_html(int r,int g, int b)   {
        return "rgb(" +r+ "," +g+ "," +b+ ")";
    }

    public String get_html() {
        String s;
        s= "<ellipse cx='" +cx+ "' cy='" +cy+ "' rx='" +rx+ "' ry='" +ry+ "' style='fill:"+rgb_html(r,g,b)+";stroke:"+rgb_html(r2,g2,b2)+";stroke-width:" +stroke_width+ "' />";
        return s;
    }
}
