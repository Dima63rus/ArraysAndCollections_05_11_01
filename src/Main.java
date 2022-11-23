import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
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

        TreeMap<String, Integer> ltPhoneBook = new TreeMap<>();

        //Бесконечный цикл
        for (; ; ) {
            //Считать введенную строку
            String lvNumberOrName = loScanner.nextLine();
            //Проверка на валидность имени
            if (checkNumber(lvNumberOrName)) {
                //Проверка на содержание имени в справочнике,
                // если есть - вывод на экран с телефоном
                // если нет - программа просит ввести номер телефона и запоминает его.
                if (checkNumberAtPhoneBook(lvNumberOrName, ltPhoneBook)) {
//                   вывод на экран с телефоном
//                   printBook();
                } else {
//                    программа просит ввести номер телефона и запоминает его.
//                    putIntoBook();
                }
            } else {
                System.out.println("Некорректное имя");
                continue;
            }

            //Проверка на валидность телефона
            if (checkPhone(lvNumberOrName)) {
                //Проверка на содержание телефона в справочнике,
                // если есть - вывод на экран с именем
                // если нет - программа просит ввести имя и также запоминает.
                if (checkPhoneAtPhoneBook(lvNumberOrName, ltPhoneBook)) {
//                   вывод на экран с телефоном
//                   printBook();
                } else {
//                    программа просит ввести номер телефона и запоминает его.
//                    putIntoBook();
                }
            } else {
                System.out.println("Некорректный номер телефона");
                continue;
            }
        }
    }

    /* Проверка на валидность введенного имени (не должно быть символов)*/
    private static Boolean checkNumber(String ivNumberOrName) {
        //+ означает "один или несколько раз" и \D означает "нецифру"
        Boolean lvNoNumbers = ivNumberOrName.matches("\\D+");
        return lvNoNumbers;
    }

    /* Проверка на валидность введенного номера (не должно быть букв) */
    private static Boolean checkPhone(String ivNumberOrName) {
        //+ означает "один или несколько раз" и \d означает "цифру"
        Boolean lvOnlyNumbers = ivNumberOrName.matches("\\d+");
        return lvOnlyNumbers;
    }

    /* Проверка на содержание имени в справочнике */
    private static Boolean checkNumberAtPhoneBook(String ivNumberOrName,
                                                  Map<String, Integer> itPhoneBook) {
        Boolean lvIsInTheBook = itPhoneBook.containsKey(ivNumberOrName);
        return false;
    }

    /* Проверка на содержание телефона в справочнике */
    private static Boolean checkPhoneAtPhoneBook(String ivNumberOrName,
                                                 Map<String, Integer> itPhoneBook) {
        Boolean lvIsInTheBook = itPhoneBook.containsKey(ivNumberOrName);
        return false;
    }
}