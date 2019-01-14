package Tools;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Context {
    private final Map<String, String> store;

    public Context() {
        this.store = new HashMap<>();
    }

    public Context add(String key, String value) {
        store.put(key, value);
        return this;
    }

    public Optional<String> get(String key) {
        return Optional.ofNullable(store.get(key));
    }
}
