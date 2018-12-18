package Screen.Toolbar;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.*;

public class ToolbarLayer  implements Component{//}, Observer {
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

    @Override
    public Component get(int i) {
        assert false;
        return null;
    }
    @Override
    public int size() {
        assert false;
        return 0;
    }
    @Override
    public String get_id() {
        return null;
    }
    @Override
    public void set_clicked(boolean state) {
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
            s += "\n\t<form action=layer_check method=\"GET\">";
            if( ((ToolbarLayerObserver)layer_observer).is_visible(i)) {
//                s+="<input type='checkbox' name='' value='' checked>Layer "+ ((ToolbarLayerObserver)layer_observer).get_id(i) +" <br>\n";
                s+="<input type='checkbox' name='' value='' checked>Layer "+ i +" <br>\n";
            } else {
                s+="<input type='checkbox' name='' value=''        >Layer "+ i +" <br>\n";
            }
            s += "\n\t</form>";
            s+="\n\t</div>";
        }
        return s;
    }



}
