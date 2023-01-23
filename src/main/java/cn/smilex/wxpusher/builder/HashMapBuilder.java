package cn.smilex.wxpusher.builder;

import lombok.Data;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author smilex
 */
@SuppressWarnings("unused")
@Data
public final class HashMapBuilder<K, V> {
    private final HashMap<K, V> value;

    public HashMapBuilder() {
        this(10);
    }

    public HashMapBuilder(int capacity) {
        this.value = new HashMap<>(capacity);
    }

    public HashMapBuilder<K, V> put(K key, V value) {
        this.value.put(key, value);
        return this;
    }

    public HashMapBuilder<K, V> ifPut(Supplier<Boolean> resultHandler, Consumer<HashMapBuilder<K, V>> consumerHandler) {
        Boolean result;
        if ((result = resultHandler.get()) != null && result) {
            consumerHandler.accept(this);
        }
        return this;
    }
}
