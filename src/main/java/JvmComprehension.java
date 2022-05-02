
//Запускаем JVM, запускается ClassLoader и он подгружает информацию о классе JvmComprehension
// Метаданные о классе JvmComprehension попадают в Metaspace.

public class JvmComprehension {

    //JVM ищет точку входа, вызывает  main, начинается выполнение программы.

    public static void main(String[] args) { //В Stack создается frame для main.
        int i = 1;                      // В frame для main  помещается данные о переменной i.
        Object o = new Object();        // В куче создается объект object, ссылка на него (o) помещается в frame для main
        //Возможно сработал GC, выделенный универсальный размер кучи 96 мб. уменьшился
        Integer ii = 2;                 // В куче создается объект, ссылка на него (ii) хранится в frame для main
        printAll(o, i, ii);             // Запускается ClassLoader и он подгружает информацию о классе printAll.
        // Метаданные о printAll попадают в Metaspace.В Stack создается  frame для printAll,
        // куда помещается ссылка на (о), значение i и ссылка на ii. Данные об i и ii хранятся в куче.
        System.out.println("finished"); // создается новый фрейм куда помещается значение "finished"
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // В куче создается объект uselessVar , ссылка на него помещается в frame для printAll
        System.out.println(o.toString() + i + ii);  // Запускается ClassLoader и он подгружает информацию о классе System.
        //  Метаданные о нем помещаются в  Metaspace. В  Stack создается новый фрейм, куда передается ссылки на объект.
        //Создается новый фрейм для toString, передается ссылка на o. Фрейм для toString удаляется

    }
}

