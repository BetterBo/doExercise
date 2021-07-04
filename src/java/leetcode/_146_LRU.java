package java.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName _146_LRU
 * @Description LRU 最近最少使用缓存机制，如果get或者put请求会更新key的使用时间
 * 1 <= capacity <= 3000
 * 0 <= key <= 3000
 * 0 <= value <= 104
 * 最多调用 3 * 104 次 get 和 put
 * data可以放入所有key值，queue先进先出，保证最久没用的key放在最前面，最近使用过的放在最后面
 * capacity保存容量大小
 * @Author yangxiaobo
 * @Date 2020/11/30 21:02
 * @Version 1.0
 */
public class _146_LRU {
    int[] data = new int[3001];
    List<Integer> queue = new LinkedList<>();
    int capacity = 0;
    public _146_LRU(int capacity) {
        this.capacity = capacity;
        for(int i=0;i<data.length;i++){
            data[i] = -1;
        }
        queue.clear();
    }

    public int get(int key) {
        if(data[key]==-1){
            return -1;
        }
        int index = queue.indexOf(key);
        queue.remove(index);
        queue.add(key);
        return data[key];
    }

    public void put(int key, int value) {
        if(data[key]!=-1){
            int index = queue.indexOf(key);
            queue.remove(index);
        }else if(queue.size()==capacity){
            data[queue.get(0)] = -1;
            queue.remove(0);
        }
        queue.add(key);
        data[key] = value;
    }
}
