package Screen.DrawArray;

import Component.*;
import Debug.Debug;
import Factory.*;
import Iterator.*;
import Strategy.*;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;


public class DrawArray extends Component {
    Factory factory_layer=null;
    int active_layer=0;
    List<Component> layer = new ArrayList<Component>();
    Strategy strategy=new StrategySvgShow(this);

    static final String SCRIPT=     "	<script type='text/javascript'>\n"+
                                    "SCRIPTS"+
                                    "	</script>\n\n";
    static final String FUNCTION=   "		function FUNCTION_NAME(clicked_id){\n"+
            "			window.location = 'FUNCTION_NAME.'+clicked_id;\n"+
            "		}\n";
    static final String FUNCTION_SVG_EDIT=  "		function FUNCTION_NAME(parameter_size){\n"+
                                            "			p=document.getElementById(0).value;\n"+
                                            "			for (i = 1; i < parameter_size; i++) {\n"+
                                            "				p=p+'&'+document.getElementById(i).value;\n"+
                                            "			}\n"+
                                            "			window.location = 'svg_edit_save.'+p;\n"+
                                            "		}\n";

    public DrawArray() { Debug.out(Thread.currentThread());
        factory_layer = new FactoryLayer();
    }

    private String svg_edit_save()   {
        String s=FUNCTION_SVG_EDIT;
        s=s.replace("FUNCTION_NAME","svg_edit_save");
        return s;
    }
    private String svg_edit_cancel()   {
        String s=FUNCTION;
        s=s.replace("FUNCTION_NAME","svg_edit_cancel");
        return s;
    }
    private String layer_add_function()   {
        String s=FUNCTION;
        s=s.replace("FUNCTION_NAME","layer_add");
        return s;
    }
    private String clicked_layer_function()   {
        String s=FUNCTION;
        s=s.replace("FUNCTION_NAME","clicked_layer_check");
        s+=FUNCTION;
        s=s.replace("FUNCTION_NAME","clicked_layer_radio");
        return s;
    }
    private String clicked_svg_function()   {
        String s=FUNCTION;
        s=s.replace("FUNCTION_NAME","clicked_svg");
        return s;
    }
    private String schripts_html()  {
        String s=clicked_svg_function();
        s+=layer_add_function();
        s+=clicked_layer_function();
        s+=svg_edit_save();
        s+=svg_edit_cancel();
        String r=SCRIPT;
        r=r.replace("SCRIPTS",s);
        return r;
    }

    private String souround_svg(String s)   {
        return "<svg height='500' width='900'>\n"+
                schripts_html()+
                s+
                "</svg>\n\n";
    }

    public Component aktiv_component() {
        Iterator it = new IteratorSvgs(layer.get(active_layer));
        while(it.hasNext()) {
            Component c=it.next();
            if (c.is_clicked()) return c;
        }
        //throw
        return null;
    }

    public void delete_aktiv_component() {

        Composite c = (Composite)layer.get(active_layer);
        c.remove(this.aktiv_component());
    }

    public void save() {
        try (PrintWriter out = new PrintWriter("forms.svg")) {
            out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            out.println("<svg xmlns=\"http://www.w3.org/2000/svg\"\n" +
                    "\txmlns:xlink=\"http://www.w3.org/1999/xlink\"\n" +
                    "\txmlns:ev=\"http://www.w3.org/2001/xml-events\"\n" +
                    "\tversion=\"1.1\" baseProfile=\"full\"\n" +
                    "\twidth=\"900px\" height=\"500px\" viewBox=\"0 0 900 500\">");
            String s="";
            for (Component c: layer  ) {
                s+=c.get_html();
            }
            out.println(s);
            out.println("</svg>");
            System.out.println("forms.svg file saved");
        }
        catch(FileNotFoundException e){
            System.out.println("ERROR while saving forms.svg file");
        }
    }



//-----------------------------------------------------------------------------------------------
    @Override
    public String get_show_html()   {
    String s="";
    for (Component c: layer  ) {
        s+=c.get_html();
    }
    return souround_svg(s);
}
    @Override
    public String get_edit_html()   {
        String s=schripts_html();
        Component c=aktiv_component();
        return s+c.get_edit_html();
    }
//-----------------------------------------------------------------------------------------------

    public void set_parameter(String parameter)    {

    }


    public void set_strategy(Strategy s) {
    strategy=s;
};
    public Component get_layer(int i) {
        return layer.get(i);
    }
    public int size() {
        return layer.size();
    }

    public String get_html()   {
        return strategy.get_html();
    }

    public Component add_layer() {
        Component l=factory_layer.create();
        //l.set_clicked(true);    // now draw on this layer
        layer.add(l);
        active_layer=layer.size()-1;
        return layer.get(active_layer);
    }
    public void show_layer(String name)  {
        for( Component c: layer )    {
            if (c.get_id().equals(name)) {
                c.toggle_visible();
            }
        }
    }
    public void select_layer(String name)  {
        for( int i=0; i<layer.size();i++ )    {
            if (layer.get(i).get_id().equals(name)) {
                active_layer=i;
                layer.get(i).set_clicked(true);
            } else {
                layer.get(i).set_clicked(false);
            }
        }
    }

    public boolean create_shape(String name, String params)    {
        return   ((Layer)layer.get(active_layer)).create_shape(name, params);
    }
    public void select_svg(String name)  {
        Iterator it = new IteratorSvgs(layer.get(active_layer));
        while(it.hasNext()) {
            Component c = it.next();
            if (c.get_id().equals(name)) {
                c.set_clicked(true);
            } else {
                c.set_clicked(false);
            }
        }
    }


}