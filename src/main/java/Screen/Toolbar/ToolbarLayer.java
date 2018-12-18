package Screen.Toolbar;

import Debug.*;
import Component.*;
import Observer.*;

public class ToolbarLayer  extends Component {//}, Observer {
    Observer layer_observer=null;

//    public Iterator createIterator() {
//        assert false;
//        return null;
//    }
    /*public void registerObserver(Observer o)  {assert false;}
    public void notifyObservers()  {assert false;}
*/
    /*public Observer get_observer() {
        return toolbar_layer_observer;
    }*/
    public void set_observer(Observer o) {
        layer_observer=o;
    }




    public String get_html()   {Debug.out(Thread.currentThread());
        assert false;
        String s="<div id=\"layers\">\n"+
                add_button_html()+
                get_check_html()+
                "</div>\n\n";
        return s;
    }

    private String add_button_html()    {
        String s="\t<div>";
            s += "\n\t<form action=layer_add method=\"GET\">";
            s += "\n\t\t<button>New Layer</button>";
            s += "\n\t</form>";
            s+="\n\t</div>";
            return s;
    }

    private String get_check_html()    {
        String s="\t<div>";
        for (int i=0; i<((ToolbarLayerObserver)layer_observer).size();i++)    {

            ToolbarLayerObserver o=((ToolbarLayerObserver)layer_observer);

            s += "\n\t<form action=layer_check method=\"GET\">";

            s+="<input type='checkbox' name='' value='' ";

            if( o.is_visible(i)) {
//                s+="<input type='checkbox' name='' value='' checked>Layer "+ ((ToolbarLayerObserver)layer_observer).get_id(i) +" <br>\n";
                s+="checked";
            }
            s+=" onchange=\"clicked_layer(" + o.get_id(i)+   ")\">Layer "+ i +" <br>\n";
            s += "\n\t</form>";
        }
        s+="\n\t</div>";
        return s;
    }



}
