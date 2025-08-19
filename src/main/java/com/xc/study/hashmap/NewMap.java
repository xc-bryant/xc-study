package com.xc.study.hashmap;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/**
 * @author bryant
 * @date 2025/8/19
 **/
public interface NewMap<K,V> {
    V put(K key, V value);
    V get(K key);

    void forEach(BiConsumer<K,V> consumer);

    void replaceAll(BiFunction<? super K, ? super V, ? extends V> function);

    void replaceAllKey(BiFunction<? super K, ? super V, ? extends K> function);

    int size();

    interface Entry<K,V> {
        K getKey();
        V getValue();
    }
}
