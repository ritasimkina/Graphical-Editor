package Screen.DrawArray;

public class Triangle {
    private double mx=0,my=0,l1x=0,l1y=0,l2x=0,l2y=0;

    public String get_html() {
        /*
        M = moveto
        L = lineto
        H = horizontal lineto
        V = vertical lineto
        C = curveto
        S = smooth curveto
        Q = quadratic Bézier curve
        T = smooth quadratic Bézier curveto
        A = elliptical Arc
        Z = closepath
         */
        String s;
        s= "<path d='M" +mx+ " " +my+ " L" +l1x+ " " +l1y+ " L" +l2x+ " " +l2y+ " Z' />";
        return s;
    }
}