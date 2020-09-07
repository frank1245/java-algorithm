package map;

/**
 * @description:
 * @author: LiGen
 * @version:
 * @date: 2020/4/19 13:52
 */
public interface MyMap<K, V> {
    //设置值
    public V put(K k, V v);

    //取值
    public V get(K k);
}
