package stack;

import lesson3main.ICollection;

public interface Stack <E> extends ICollection {

   boolean push(E value);  //вставка элемента

    E pop();          // удаление элемента

    E peek();        // чтение элемента

}
