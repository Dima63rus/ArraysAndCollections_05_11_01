import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    static final String MC_LIST = "LIST";

    public static void main(String[] args) {
/*
  Цель задания
     Научиться работать с коллекцией Map.
  Что нужно сделать
     1. Напишите программу, которая будет работать как телефонная книга:
      	Если пишем новое имя, программа просит ввести номер телефона и запоминает его.
      	Если новый номер телефона — просит ввести имя и также запоминает.
      	Если вводим существующее имя или номер телефона, программа выводит всю информацию о контакте.
      	При вводе команды LIST программа печатает в консоль список всех абонентов в алфавитном порядке с номерами.
     2. Определяйте имя и телефон с помощью регулярных выражений.
     3. Подумайте, что выбрать в качестве ключа и значения для Map,
        выберите лучший вариант по вашему мнению. Опишите, какие минусы и плюсы видите в вашем выборе.
*/
        Scanner loScanner = new Scanner(System.in);
        System.out.println("Введите имя либо номер телефона");

        TreeMap<String, String> ltNameBook = new TreeMap<>();
        TreeMap<String, String> ltPhoneBook = new TreeMap<>();

        //Бесконечный цикл
        for (; ; ) {
            //Считать введенную строку
            String lvPhoneOrName = loScanner.nextLine();
            String[] ltPhoneOrName = lvPhoneOrName.split("\\s+");

            //Отобразить справочники
            if (lvPhoneOrName.equals(MC_LIST)) {
                printNameBook(ltNameBook);
                printPhoneBook(ltPhoneBook);
                continue;
            }

            //Проверка на валидность имени
            if (checkName(ltPhoneOrName[0])) {
                //Проверка на содержание имени в справочнике,
                // если есть - вывод на экран с телефоном
                // если нет - программа просит ввести номер телефона и запоминает его.
                if (checkNameAtNameBook(ltPhoneOrName[0], ltNameBook)) {
//                   вывод в консоль с телефоном
                    printNameBook(ltNameBook);
                } else {
////                    программа просит ввести номер телефона и запоминает его.
                    ltNameBook = putNameBook(ltPhoneOrName[0], ltNameBook);
                }
            } else {
                System.out.println("Некорректное имя");
                continue;
            }

            //Проверка на валидность телефона
            if (checkPhone(ltPhoneOrName[1])) {
                //Проверка на содержание телефона в справочнике,
                // если есть - вывод на экран с именем
                // если нет - программа просит ввести имя и также запоминает.
                if (checkPhoneAtPhoneBook(ltPhoneOrName[1], ltPhoneBook)) {
//                   вывод на экран с телефоном
                    printPhoneBook(ltPhoneBook);
                } else {
//                    программа просит ввести номер телефона и запоминает его.
                    ltPhoneBook = putPhoneBook(ltPhoneOrName[1], ltPhoneBook);
                }
            } else {
                System.out.println("Некорректный номер телефона");
                continue;
            }
        }
    }

    /* Вывод в консоль коллекции itNameMap */
    private static void printNameBook(TreeMap<String, String> itNameMap) {
        for (Map.Entry Entry : itNameMap.entrySet()) {
            System.out.println(Entry);
        }
//        for (String lvKey : itNameMap.keySet()) {
//            System.out.println("lvKey = " + lvKey + "itNameMap.get(lvKey) = " + itNameMap.get(lvKey));
//        }
    }

    /* Вывод в консоль коллекции itPhoneMap */
    private static void printPhoneBook(TreeMap<String, String> itPhoneMap) {
        for (Map.Entry Entry : itPhoneMap.entrySet()) {
            System.out.println(Entry);
        }
//        for (String lvKey : itPhoneMap.keySet()) {
//            System.out.println("lvKey = " + lvKey + "itPhoneMap.get(lvKey) = " + itPhoneMap.get(lvKey));
//        }
    }

    /* Проверка на валидность введенного имени (не должно быть символов)*/
    private static Boolean checkName(String ivPhoneOrName) {
        //+ означает "один или несколько раз" и \D означает "нецифру"
        Boolean lvNoNumbers = ivPhoneOrName.matches("\\D+");
        return lvNoNumbers;
    }

    /* Проверка на валидность введенного номера (не должно быть букв) */
    private static Boolean checkPhone(String ivPhoneOrName) {
        //+ означает "один или несколько раз" и \d означает "цифру"
        Boolean lvOnlyNumbers = ivPhoneOrName.matches("\\d+");
        return lvOnlyNumbers;
    }

    /* Проверка на содержание имени в справочнике */
    private static Boolean checkNameAtNameBook(String ivPhoneOrName,
                                               Map<String, String> itNameBook) {
        Boolean lvIsInTheBook = itNameBook.containsValue(ivPhoneOrName);
        return lvIsInTheBook;
    }

    /* Проверка на содержание телефона в справочнике */
    private static Boolean checkPhoneAtPhoneBook(String ivPhoneOrName,
                                                 Map<String, String> itPhoneBook) {
        Boolean lvIsInTheBook = itPhoneBook.containsValue(ivPhoneOrName);
        return lvIsInTheBook;
    }

    /* Вставка в NameBook имени */
    private static TreeMap<String, String> putNameBook(String ivNumberOrName,
                                                       TreeMap<String, String> itNameBook) {
        //Проверка на существование ключа
        Integer lvCount = 1;
//        if (!itNameBook.containsKey(lvCount)) {
        //Ключ не найден - добавить запись
        itNameBook.put(ivNumberOrName + lvCount, ivNumberOrName);
//        } else {
//            //Ключ найден - добавить/изменить запись с другим ключом
//            itPhoneBook.put(lvCount, lvNumberOrName);
//        }

        return itNameBook;
    }

    /* Вставка в PhoneBook номера */
    private static TreeMap<String, String> putPhoneBook(String ivNumberOrName,
                                                        TreeMap<String, String> itPhoneBook) {
        //Проверка на существование ключа
        Integer lvCount = 1;
//        if (!itPhoneBook.containsKey(lvCount)) {
        //Ключ не найден - добавить запись
        itPhoneBook.put(ivNumberOrName + lvCount, ivNumberOrName);
//        } else {
//            //Ключ найден - добавить/изменить запись с другим ключом
//            itPhoneBook.put(lvCount, lvNumberOrName);
//        }

        return itPhoneBook;
    }
}