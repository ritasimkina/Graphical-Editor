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

    public SVGAttributeList(SVGAttributeList attributes) {
        for(int i=0;i<attributes.size();i++) {
            atr.add( new Pair(attributes.get(i)) );
        }
    }


    public Pair get(int pos) {
        return atr.get(pos);
    }
    public String getValue(String key) {
        for( Pair p: atr ) {
            if(p.getKey().equals(key))  return p.getValue();
        }
        return "";
    }

    public void setValue(int pos, String value) {
        atr.get(pos).setValue(value);
    }
    public void setValue(String key, String value) {
        for( Pair p: atr ) {
            if(p.getKey().equals(key))  p.setValue(value);
        }
    }
    public void setValue(String key, double value) {
        for( Pair p: atr ) {
            if(p.getKey().equals(key))  p.setValue(Double.toString(value));
        }
    }

    public int size()  {
        return atr.size();
    }

    public String get_key(int pos) {
        return atr.get(pos).getKey();
    }
    public String get_value(int pos) {
        return atr.get(pos).getValue();
    }

}
