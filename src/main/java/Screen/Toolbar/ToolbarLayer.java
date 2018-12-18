package Screen.Toolbar;

import Debug.*;
import Component.*;
import Observer.*;

public class ToolbarLayer  extends Component {

    static final String FORM_ALL_LAYER= "<div id='layers'>\n"+
                                        "	<div>\n"+
                                        "	FORM_LAYER_ADD"+
                                        "	</div>\n"+
                                        "	FORM_LAYER_CHECK"+
                                        "</div>\n\n";

    static final String FORM_LAYER_ADD= "	<form action=layer_add method='GET'>\n"+
                                        "		<button>New Layer</button>\n"+
                                        "	</form>\n";
    static final String FORM_LAYER_CHECK="	<form action=layer_check method='GET'>\n"+
                                         "CHECKBOX_RADIO\t</form>\n";
    static final String FORM_CHECKBOX_RADIO="		<input type='checkbox' name='' value='' CHECKED onchange='clicked_layer_check(ID)'>  "+
                                            "<input type='radio' name='layer_check' value='' RADIO onchange='clicked_layer_radio(ID)'>TEXT<br>\n";

    Observer layer_observer=null;

    public void set_observer(Observer o) {
        layer_observer=o;
    }

    public String get_html()   {Debug.out(Thread.currentThread());
        String s=FORM_ALL_LAYER;
        s=s.replace("FORM_LAYER_ADD",FORM_LAYER_ADD);
        s=s.replace("FORM_LAYER_CHECK",get_check_html());
        return s;
    }

    private String get_check_html()    {
        String cr="";
        for (int i=0; i<((ToolbarLayerObserver)layer_observer).size();i++)    {
            ToolbarLayerObserver o=((ToolbarLayerObserver)layer_observer);
            String s=FORM_CHECKBOX_RADIO;
            s=s.replace("ID",o.get_id(i));
            s=s.replace("TEXT","Layer "+i);
            if( !o.is_visible(i)) s=s.replace("CHECKED","");

            if( o.clicked_id().equals(o.get_id(i))) s=s.replace("RADIO","CHECKED");
            else s=s.replace("RADIO","");

            cr=cr+s;
        }
        String form_layer=FORM_LAYER_CHECK;
        form_layer=form_layer.replace("CHECKBOX_RADIO",cr);
        return form_layer;
    }
}
