package lesson4main;

    public interface Stack <E> extends ICollection {

        boolean push(E value);  //вставка элемента

        E pop();          // удаление элемента

        E peek();        // чтение элемента

    }
