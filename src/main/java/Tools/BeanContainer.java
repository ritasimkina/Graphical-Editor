package Tools;

import java.util.HashMap;
import java.util.Map;

public class BeanContainer {
    private static final Map<Class, Object> store = new HashMap<>();

    public static <T> void registerBean(T obj, Class<T> clazz) {
        store.put(clazz, obj);
    }

    public static <T> T get(Class<T> clazz) {
        return (T) store.get(clazz);
    }
}
