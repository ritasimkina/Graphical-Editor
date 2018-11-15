public class Text {
    private double x1=0, y1=0, x2=100, y2=100;
    private int r=255, g=0,b=0;
    private String txt="";

    private String rgb_html(int r,int g, int b)   {
        return "rgb(" +r+ "," +g+ "," +b+ ")";
    }

    public String get_html() {
        String s;
        s= "<text x='" +x1+ "' y='" +y1+ "' fill='"+rgb_html(r,g,b)+"'>"+txt+"</text>";
        return s;
    }
}