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

        final String color = context.get("color").orElse("");
        final String x = context.get("x").orElse("100");
        final String y = context.get("y").orElse("100");

        s+="<div id=\"toolbar\">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;\n";
        s+="\t<table>";
        for (String i : toolbar_names) {
            String action = "/add_svg." + i;
            if (!color.equals("")) {
                action = String.format("%s.color:%s;", action, color);
            }

            s += "\n\t<form class=\"toolbar_form\" action=\"" + action + "\" original=\"add_svg." + i + "\"  method=\"GET\">";
            s += "\n\t\t<button style=\"height:30px; width:75px\">" + i + "</button>&emsp;&emsp;";
            s += "\n\t</form>";
        }
        s+="\n\t</table>\n";
        s+="<div style=\"background: #aacae4; padding: 10px;\">\n" +
            "        <label>Colour (HEX):</label> <input type=\"color\" onchange=\"changeAttr('color',hexToRgb(this.value));\" value=\"" + changeCollorFormat(color) + "\">\n" +
            "        <label>X:</label><input type=\"number\" min=\"1\" max=\"500\" onchange=\"changeAttr('x', this.value);\" value=\"" + x + "\"> \n" +
            "        <label>Y:</label><input type=\"number\" min=\"1\" max=\"500\" onchange=\"changeAttr('y', this.value);\" value=\"" + y + "\"> \n" +
            "    </div>\n" +
            "    <script>    \n" +
            "        function changeAttr(key, value) {\n" +
            "           var list = document.getElementsByClassName(\"toolbar_form\");\n" +
            "           console.log(list);\n" +
            "           for(var i = 0; i < list.length; i++) {\n" +
            "               var attr = list[i].getAttribute(\"action\");\n" +
            "               var res;\n" +
            "               if (attr.includes(key)) {\n" +
            "                   res = attr.replace(new RegExp(key + ':.+;', 'i'), key + \":\" + value + \";\")\n" +
            "               } else {\n" +
            "                   if (attr.charAt(attr.length - 1) != \";\")\n" +
            "                        attr += \".\";\n" +
            "                   res = attr + \"\" + key + \":\" + value + \";\"\n" +
            "               }\n" +
            "                list[i].setAttribute(\"action\", res);\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        function hexToRgb(hex) {\n" +
            "            var result = /^#?([a-f\\d]{2})([a-f\\d]{2})([a-f\\d]{2})$/i.exec(hex);\n" +
            "            return \"rgb(\" + parseInt(result[1], 16) + \",\" + parseInt(result[2], 16) + \",\" + parseInt(result[3], 16) + \")\";\n" +
            "        }\n" +
            "    </script>";
        s+="</div>\n\n";
        return s;
    }

    // change "rgb(255,255,255)" -> "#ffffff"
    private String changeCollorFormat(String collorAttr) {
        final Matcher matcher = Pattern.compile("rgb\\([0-9]+,[0-9]+,[0-9]+\\)").matcher(collorAttr);
        if (matcher.find()) {
            final String[] rgb = collorAttr.replace("rgb(", "").replace(")", "").split(",");
            StringBuilder res = new StringBuilder("#");
            for (String c : rgb) {
                res.append(Integer.toHexString(Integer.valueOf(c)));
            }
            return res.toString();
        }
        return "#e66465";
    }
}