package Screen.DrawArray;

import Component.*;
import Debug.Debug;
import Factory.*;
import Iterator.*;

import java.util.ArrayList;
import java.util.List;


public class DrawArray extends Component {
    //Composite screen = new Composite();
    Factory factory_layer=null;
    int active_layer=0;

    List<Component> layer = new ArrayList<Component>();

    //@Override
    public Component get_layer(int i) {
        return layer.get(i);
    }
    //@Override
    public int size() {
        return layer.size();
    }

    private String get_clicked_svg_function()   {
        return "\t<script type=\"text/javascript\">"+
//                "\n\t\tfunction clicked_svg(clicked_id){alert('SVG-Element '+clicked_id+ ' wurde angeklickt!');}"+
                "\n\t\tfunction clicked_svg(clicked_id){\n"+
                "\t\t\twindow.location = \"clicked_svg.\"+clicked_id;\n"+
                "\t\t}\n"+
                "\t</script>\n\n";
    }
    private String get_clicked_layer_function()   {
        return "\t<script type=\"text/javascript\">"+
//                "\n\t\tfunction clicked_svg(clicked_id){alert('SVG-Element '+clicked_id+ ' wurde angeklickt!');}"+
                "\n\t\tfunction clicked_layer(clicked_id){\n"+
                "\t\t\twindow.location = \"clicked_layer.\"+clicked_id;\n"+
                "\t\t}\n"+
                "\t</script>\n\n";
    }
    private String souround_svg(String s)   {
        return "<svg height='500' width='500'>\n"+
                get_clicked_svg_function()+s+
                get_clicked_layer_function()+s+
                "</svg>\n\n";
    }


    public DrawArray() { Debug.out(Thread.currentThread());
        factory_layer = new FactoryLayer();
    }

    public Component add_layer() {
        Component l=factory_layer.create();
        layer.add(l);
        active_layer=layer.size()-1;
        //System.out.println(active_layer);
        // info an ToolbarLayer
        return layer.get(active_layer);
    }
    public void select_layer(String name)  {
        for( Component c: layer )    {
            if (c.get_id().equals(name)) {
                c.toggle_visible();
            }
        }
    }

    public boolean create_shape(String name)    {
        return   ((Layer)layer.get(active_layer)).create_shape(name);
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

    public String get_html()   {
        String s="";
        for (IComponent c: layer  ) {
            s+=c.get_html();
        }
        return souround_svg(s);
    }



}