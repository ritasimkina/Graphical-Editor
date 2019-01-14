//package Component;

import Screen.DrawArray.Draws.Ellipse;
import Screen.DrawArray.Draws.NGon;
import Screen.DrawArray.Draws.Quadrangle;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CompositeTest {

    @Test

    public void ITestCompositeComponentReturnHtml(){

        Ellipse trialEllipse = new Ellipse(4,100, 60, 200);
        NGon trialCircle = new NGon(12, 12);
        Quadrangle quadrangle = new Quadrangle(12 , 4,4, 1);
        Composite myComposite = new Composite();
        myComposite.add(trialEllipse);
        myComposite.add(trialCircle);
        myComposite.add(quadrangle);

        String actualHtml = myComposite.get_html();
        String expected = "\t<ellipse class='svg_ellipse' transform='' cx='4.0' cy='100.0' rx='60.0' ry='200.0' id='1' onclick='clicked_svg(this.id)' fill='rgb(255,255,255)' stroke='rgb(25,118,210)' stroke-width='2'  />\n" +
                "\t<polygon class='svg_ngon' transform='' points='-12.0,12.0 -10.0,0.0 -2.0,-8.0 26.0,-8.0 34.0,0.0 36.0,12.0 34.0,24.0 26.0,32.0 -2.0,32.0 -10.0,24.0 -12.0,12.0' id='2' onclick='clicked_svg(this.id)' fill='rgb(255,255,255)' stroke='rgb(25,118,210)' stroke-width='2'  />\n" +
                "\t<rect class='svg_rect' transform='' x='12.0' y='4.0' width='4.0' height='1.0' rx='0' ry='0' id='3' onclick='clicked_svg(this.id)' fill='rgb(255,255,255)' stroke='rgb(25,118,210)' stroke-width='2'  />\n";

        Assert.assertEquals(actualHtml, expected);

    }

}