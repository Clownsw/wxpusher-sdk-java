package cn.smilex.wxpusher.builder;

import lombok.Data;

import java.util.HashMap;

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
}
