package Screen.Toolbar;

import Debug.*;
import Iterator.*;
import Component.*;
import Observer.Observer;
import Tools.Context;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Toolbar extends Component {
    List<String> toolbar_names = new ArrayList<String>();
    private final Context context;
    public void registerObserver(Observer o)  {assert false;}
    public void notifyObservers()  {assert false;}

    public Iterator createIterator() {
        assert false;
        return null;
    }

    public Toolbar(Context context) {
        getClassnames();
        this.context = context;
    }
    private void getClassnames() {
        File directory = new File("./src/main/java/Screen/DrawArray/Draws");
        //get all the files from a directory
        File[] files = directory.listFiles();
        for (File file : files){
            if (file.isFile()){
                //System.out.println(file.getName());
                String str = file.getName().replace(".java", "");
                toolbar_names.add(str);
            }
        }
    }

    public String get_html() {
        Debug.out(Thread.currentThread());
        String s = "";

        final String attributes = context.get("attributes").orElse("");

        s+="<div id=\"toolbar\">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;\n";
        s+="\t<table>";
        for (String i : toolbar_names) {
            s += "\n\t<form class=\"toolbar_form\" action=\"add_svg." + i + attributes + "\" original=\"add_svg." + i + "\"  method=\"GET\">";
            s += "\n\t\t<button style=\"height:30px; width:75px\">" + i + "</button>&emsp;&emsp;";
            s += "\n\t</form>";
        }
        s+="\n\t</table>\n";
        s+="<div style=\"background: #aacae4; padding: 10px;\">\n" +
            "        Colour (HEX): <input type=\"color\" onchange=\"changeColor(this.value);\" value=\"" + changeCollorFormat(attributes) + "\">\n" +
            "    </div>\n" +
            "    <script>\n" +
            "        function changeColor(color) {\n" +
            "            console.log(color);\n" +
            "            var list = document.getElementsByClassName(\"toolbar_form\");\n" +
            "            console.log(list);\n" +
            "            for(var i = 0; i < list.length; i++) {\n" +
            "                list[i].setAttribute(\"action\", list[i].getAttribute(\"original\") + \".color:\" + hexToRgb(color) + \";\")\n" +
            "            }\n" +
            "        }\n" +
            "        \n" +
            "        function hexToRgb(hex) {\n" +
            "            var result = /^#?([a-f\\d]{2})([a-f\\d]{2})([a-f\\d]{2})$/i.exec(hex);\n" +
            "            return \"rgb(\" + parseInt(result[1], 16) + \",\" + parseInt(result[2], 16) + \",\" + parseInt(result[3], 16) + \")\";\n" +
            "        }\n" +
            "    </script>";
        s+="</div>\n\n";
        return s;
    }

    // change "color:rgb(255,255,255)" -> "#ffffff"
    private String changeCollorFormat(String collorAttr) {
        final Matcher matcher = Pattern.compile("color:rgb\\([0-9]+,[0-9]+,[0-9]+\\)").matcher(collorAttr);
        if (matcher.find()) {
            final String[] rgb = matcher.group().replace("color:rgb(", "").replace(")", "").split(",");
            StringBuilder res = new StringBuilder("#");
            for (String c : rgb) {
                res.append(Integer.toHexString(Integer.valueOf(c)));
            }
            return res.toString();
        }
        return "#e66465";
    }
}