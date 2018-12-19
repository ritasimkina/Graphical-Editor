package Tools;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SVGAttributeList {
    List<Pair> atr = new ArrayList<Pair>();
    
    public SVGAttributeList(List<String> pairs)   {
        for(int i=0;i<pairs.size();i+=2) {
            atr.add( new Pair(pairs.get(i),pairs.get(i+1)) );
        }
    }


    public String getValue(String key) {
        for( Pair p: atr ) {
            if(p.getKey().equals(key))  return p.getValue();
        }
        return "";
    }

    public void setValue(String key, String value) {
        for( Pair p: atr ) {
            if(p.getKey().equals(key))  p.setValue(value);
        }
    }    
    
}
