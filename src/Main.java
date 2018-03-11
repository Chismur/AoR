
/**
 * Алгоритмы на строках
 * Поиск паттерна P в тексте T
 * С использованием метода вычисления массива граней префиксов.
 * С использованием метода вычисления массива блоков.
 * Экспериментально оцените время ее работы для предельно больших строк.
 *
 * @author kingm
 */
public class Main {


    public static void main(String[] args) {


        String p = "c";
        String s = "ccccccccccccccccc";


        Pref pref = new Pref(p + "#" + s, p);
        System.out.println(pref.getResult());


        Blocks blocks = new Blocks(p + "#" + s, p);
        System.out.println(blocks.getResult());
    }
}
