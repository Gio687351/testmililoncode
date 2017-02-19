package refactula.design.patterns;

public interface AbstractFactory<K, V> {

    V produce(K key);

}
