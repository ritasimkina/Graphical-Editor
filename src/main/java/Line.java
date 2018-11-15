import java.util.ArrayList;
import java.util.List;

public class Line {
    double x1=0, y1=0, x2=100, y2=100;
    int stroke_width=2;

    int r=255, g=0,b=0;

    String rgb_html(int r,int g, int b)   {
        return "rgb(" +r+ "," +g+ "," +b+ ")";
    }

    String get_html() {
        String s;
        s= "<line x1='" +x1+ "' y1='" +y1+ "' x2='" +x2+ "' y2='" +y2+ "' style='stroke:'"+rgb_html(r,g,b)+";stroke-width:" +stroke_width+ "' />";
        return s;
    }
}
