package Screen.DrawArray;

import Component.*;
import Debug.Debug;
import Factory.*;
import Iterator.*;
import Strategy.*;

import java.util.ArrayList;
import java.util.List;


public class DrawArray extends Component {
    //Composite screen = new Composite();

    static final String SCRIPT=     "	<script type='text/javascript'>\n"+
                                    "SCRIPTS"+
                                    "	</script>\n\n";
    static final String FUNCTION=   "		function FUNCTION_NAME(clicked_id){\n"+
                                    "			window.location = 'FUNCTION_NAME.'+clicked_id;\n"+
                                    "		}\n";

    Strategy strategy=new StrategySvgShow(this);


    public void set_strategy(Strategy s) {
        strategy=s;
    };


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
        String r=SCRIPT;
        r=r.replace("SCRIPTS",s);
        return r;
    }
    private String souround_svg(String s)   {
        return "<svg height='500' width='500'>\n"+
                schripts_html()+
                s+
                "</svg>\n\n";
    }

    private Component aktiv_component() {
        Iterator it = new IteratorSvgs(layer.get(active_layer));
        while(it.hasNext()) {
            Component c=it.next();
            if (c.is_clicked()) return c;
        }
        //throw
        return null;
    }


    public DrawArray() { Debug.out(Thread.currentThread());
        factory_layer = new FactoryLayer();
    }




    public String get_html()   {
        return strategy.get_html();
    }
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
        Component c=aktiv_component();
        return c.get_edit_html();
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


}