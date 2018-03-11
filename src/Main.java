import java.io.*;

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

    private static String E1 = "D://IntelliJ IDEA/AoR/example/ex1.txt";
    private static String E2 = "D://IntelliJ IDEA/AoR/example/ex2.txt";
    private static String E3 = "D://IntelliJ IDEA/AoR/example/ex3.txt";
//    private static String E4 = "D://IntelliJ IDEA/AoR/example/ex4.txt";

    public static void main(String[] args) throws FileNotFoundException {

        //DNA
        String ex1 = read(E1);
        String pEx1 = "AGA";

        //DNA
        String ex2 = read(E2);
        String pEx2 = "aca";

        //Тихий Дон
        String ex3 = read(E3);
        String pEx3 = "кобылу";
//
//        String ex4 = read(E4);
//        String pEx4 = "aca";

        long startTimeBp = System.nanoTime();
        Pref pref = new Pref(pEx3 + "$" + ex3, pEx3);
        long endTimeBp = System.nanoTime();
        long durationBp = (endTimeBp - startTimeBp)/10000;
        System.out.println(pref.getResult());
        System.out.println("time for bp - " + durationBp);

        long startTimeZ = System.nanoTime();
        Blocks blocks = new Blocks(pEx3 + "$" + ex3, pEx3);
        long endTimeZ = System.nanoTime();
        long durationZ = (endTimeZ - startTimeZ)/10000;
        System.out.println(blocks.getResult());
        System.out.println("time for z-blocks - " + durationZ);

    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }

    public static String read(String fileName) throws FileNotFoundException {
        StringBuilder sb = new StringBuilder();
        exists(fileName);

        try {
            //Object for reading from file
            BufferedReader in = new BufferedReader(new FileReader(fileName));
            try {

                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {

                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //Возвращаем полученный текст с файла
        return sb.toString();
    }
}
