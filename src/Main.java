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

        TreeMap<String, String> ltNameBook = new TreeMap<>();
        TreeMap<String, String> ltPhoneBook = new TreeMap<>();

        //Бесконечный цикл
        for (; ; ) {
            System.out.println("Введите имя либо номер телефона");

            //Считать введенную строку
            String lvPhoneOrName = loScanner.nextLine();
            //Убрать лишние слова кроме первого
            int lvSpacePos = lvPhoneOrName.indexOf(" ");
            if (lvSpacePos > 0) {
                lvPhoneOrName = lvPhoneOrName.substring(0, lvSpacePos - 1);
            }

            //Отобразить справочник
            if (lvPhoneOrName.equals(MC_LIST)) {
                printNamePhoneBook(ltNameBook, ltPhoneBook);
                continue;
            }

            //Имя или номер телефона
            if (checkName(lvPhoneOrName)) {
                //Введено имя
                //Проверка на содержание имени в справочнике,
                // если есть - вывод на экран с телефоном
                // если нет - программа просит ввести номер телефона и запоминает его.
                if (checkNameAtNameBook(lvPhoneOrName, ltNameBook)) {
                    //вывод в консоль с телефоном одной записи по ключу
                    printSingleNamePhoneBookForName(lvPhoneOrName, ltNameBook, ltPhoneBook);
                } else {
                    //Программа просит ввести номер телефона и запоминает его
                    Scanner loScannerPhone = new Scanner(System.in);
                    System.out.print(lvPhoneOrName + " - нет в коллекции. ");
                    System.out.print("Введите номер телефона нового пользователя. \n");

                    //Введенный номер телефона
                    String lvPhone = loScannerPhone.nextLine();

                    //Добавить в коллекцию имен
                    putNameBook(lvPhoneOrName, ltNameBook);

                    //Запись в PhoneBook общей записи
                    putPhoneBookForNameBook(lvPhoneOrName,
                            lvPhone,
                            ltPhoneBook);
                }
            } else if (checkPhone(lvPhoneOrName)) {
                //Введен номер телефона
                //Проверка на содержание номера в справочнике,
                // если есть - вывод на экран с именем
                // если нет - программа просит ввести имя и запоминает его.
                if (checkPhoneAtPhoneBook(lvPhoneOrName, ltPhoneBook)) {
                    //вывод в консоль с телефоном одной записи по ключу
                    printSingleNamePhoneBookForPhone(lvPhoneOrName, ltNameBook, ltPhoneBook);
                } else {
                    //Программа просит ввести имя и запоминает его
                    Scanner loScannerName = new Scanner(System.in);
                    System.out.print(lvPhoneOrName + " - нет в коллекции. ");
                    System.out.print("Введите имя нового пользователя. \n");

                    //Введенное имя абонента
                    String lvName = loScannerName.nextLine();

                    //Добавить в коллекцию имен
                    putNameBook(lvName, ltNameBook);

                    //Запись в PhoneBook общей записи
                    putPhoneBookForNameBook(lvName,
                            lvPhoneOrName,
                            ltPhoneBook);
                }
            } else {
                System.out.println("Некорректный ввод");
            }
        }
    }


    /* Проверка на валидность введенного имени (не должно быть символов)*/
    private static Boolean checkName(String ivPhoneOrName) {
        //+ означает "один или несколько раз" и \D означает "нецифру"
        return ivPhoneOrName.matches("\\D+");
    }


    /* Проверка на валидность введенного номера (не должно быть букв) */
    private static Boolean checkPhone(String ivPhoneOrName) {
        //+ означает "один или несколько раз" и \d означает "цифру"
        return ivPhoneOrName.matches("\\d+");
    }


    /* Проверка на содержание имени в справочнике */
    private static Boolean checkNameAtNameBook(String ivPhoneOrName,
                                               Map<String, String> itNameBook) {
        return itNameBook.containsValue(ivPhoneOrName);
    }


    /* Проверка на содержание телефона в справочнике */
    private static Boolean checkPhoneAtPhoneBook(String ivPhoneOrName,
                                                 Map<String, String> itPhoneBook) {
        return itPhoneBook.containsValue(ivPhoneOrName);
    }


    /* Вставка в NameBook имени */
    private static void putNameBook(String ivNumber,
                                    TreeMap<String, String> itNameBook) {
        int lvCount = 1;
        itNameBook.put(ivNumber + lvCount, ivNumber);
    }


    /* Запись в PhoneBook общей записи */
    private static void putPhoneBookForNameBook(String lvName,
                                                String lvPhone,
                                                TreeMap<String, String> itPhoneBook) {
//        Вставка в ltPhoneBook key=Дима value=89276551681
        itPhoneBook.put(lvName, lvPhone);
        System.out.println("Запись сохранена в справочнике: " + lvName + " " + lvPhone);
    }


    /* Вывод в консоль абонента целиком */
    private static void printNamePhoneBook(TreeMap<String, String> itNameBook,
                                           TreeMap<String, String> itPhoneBook) {
        for (String lvKey : itNameBook.keySet()) {
            String lvValue = itNameBook.get(lvKey);

            System.out.println(lvValue + " " + itPhoneBook.get(lvValue));
        }
    }


    /* Вывод в консоль одного абонента целиком по имени */
    private static void printSingleNamePhoneBookForName(String ivName,
                                                        TreeMap<String, String> itNameBook,
                                                        TreeMap<String, String> itPhoneBook) {
        int lvCount = 1;
        String lvNameValue = itNameBook.get(ivName + lvCount);
        String lvPhoneValue = itPhoneBook.get(ivName);
        System.out.println(lvNameValue + " " + lvPhoneValue);
    }


    /* Вывод в консоль одного абонента целиком по телефону */
    private static void printSingleNamePhoneBookForPhone(String ivPhone,
                                                         TreeMap<String, String> itNameBook,
                                                         TreeMap<String, String> itPhoneBook) {
        for (String lvKey : itPhoneBook.keySet()) {
            //Поиск ключа из коллекции itPhoneBook
            String lvValue = itPhoneBook.get(lvKey);
            if (lvValue.equals(ivPhone)) {
                //Поиск в itNameBook имени по введенному номеру
                int lvCount = 1;
                String lvName = itNameBook.get(lvKey + lvCount);
                System.out.println(lvName + " " + ivPhone);
            }
        }
    }
}