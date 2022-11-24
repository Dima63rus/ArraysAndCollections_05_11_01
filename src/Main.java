import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    static final String MC_LIST = "LIST";

    public static void main(String[] args) {
/*
  ���� �������
     ��������� �������� � ���������� Map.
  ��� ����� �������
     1. �������� ���������, ������� ����� �������� ��� ���������� �����:
      	���� ����� ����� ���, ��������� ������ ������ ����� �������� � ���������� ���.
      	���� ����� ����� �������� � ������ ������ ��� � ����� ����������.
      	���� ������ ������������ ��� ��� ����� ��������, ��������� ������� ��� ���������� � ��������.
      	��� ����� ������� LIST ��������� �������� � ������� ������ ���� ��������� � ���������� ������� � ��������.
     2. ����������� ��� � ������� � ������� ���������� ���������.
     3. ���������, ��� ������� � �������� ����� � �������� ��� Map,
        �������� ������ ������� �� ������ ������. �������, ����� ������ � ����� ������ � ����� ������.
*/
        Scanner loScanner = new Scanner(System.in);
        System.out.println("������� ��� ���� ����� ��������");

        TreeMap<String, String> ltNameBook = new TreeMap<>();
        TreeMap<String, String> ltPhoneBook = new TreeMap<>();

        //����������� ����
        for (; ; ) {
            //������� ��������� ������
            String lvPhoneOrName = loScanner.nextLine();
            String[] ltPhoneOrName = lvPhoneOrName.split("\\s+");

            //���������� �����������
            if (lvPhoneOrName.equals(MC_LIST)) {
                printNameBook(ltNameBook);
                printPhoneBook(ltPhoneBook);
                continue;
            }

            //�������� �� ���������� �����
            if (checkName(ltPhoneOrName[0])) {
                //�������� �� ���������� ����� � �����������,
                // ���� ���� - ����� �� ����� � ���������
                // ���� ��� - ��������� ������ ������ ����� �������� � ���������� ���.
                if (checkNameAtNameBook(ltPhoneOrName[0], ltNameBook)) {
//                   ����� � ������� � ���������
                    printNameBook(ltNameBook);
                } else {
////                    ��������� ������ ������ ����� �������� � ���������� ���.
                    ltNameBook = putNameBook(ltPhoneOrName[0], ltNameBook);
                }
            } else {
                System.out.println("������������ ���");
                continue;
            }

            //�������� �� ���������� ��������
            if (checkPhone(ltPhoneOrName[1])) {
                //�������� �� ���������� �������� � �����������,
                // ���� ���� - ����� �� ����� � ������
                // ���� ��� - ��������� ������ ������ ��� � ����� ����������.
                if (checkPhoneAtPhoneBook(ltPhoneOrName[1], ltPhoneBook)) {
//                   ����� �� ����� � ���������
                    printPhoneBook(ltPhoneBook);
                } else {
//                    ��������� ������ ������ ����� �������� � ���������� ���.
                    ltPhoneBook = putPhoneBook(ltPhoneOrName[1], ltPhoneBook);
                }
            } else {
                System.out.println("������������ ����� ��������");
                continue;
            }
        }
    }

    /* ����� � ������� ��������� itNameMap */
    private static void printNameBook(TreeMap<String, String> itNameMap) {
        for (Map.Entry Entry : itNameMap.entrySet()) {
            System.out.println(Entry);
        }
//        for (String lvKey : itNameMap.keySet()) {
//            System.out.println("lvKey = " + lvKey + "itNameMap.get(lvKey) = " + itNameMap.get(lvKey));
//        }
    }

    /* ����� � ������� ��������� itPhoneMap */
    private static void printPhoneBook(TreeMap<String, String> itPhoneMap) {
        for (Map.Entry Entry : itPhoneMap.entrySet()) {
            System.out.println(Entry);
        }
//        for (String lvKey : itPhoneMap.keySet()) {
//            System.out.println("lvKey = " + lvKey + "itPhoneMap.get(lvKey) = " + itPhoneMap.get(lvKey));
//        }
    }

    /* �������� �� ���������� ���������� ����� (�� ������ ���� ��������)*/
    private static Boolean checkName(String ivPhoneOrName) {
        //+ �������� "���� ��� ��������� ���" � \D �������� "�������"
        Boolean lvNoNumbers = ivPhoneOrName.matches("\\D+");
        return lvNoNumbers;
    }

    /* �������� �� ���������� ���������� ������ (�� ������ ���� ����) */
    private static Boolean checkPhone(String ivPhoneOrName) {
        //+ �������� "���� ��� ��������� ���" � \d �������� "�����"
        Boolean lvOnlyNumbers = ivPhoneOrName.matches("\\d+");
        return lvOnlyNumbers;
    }

    /* �������� �� ���������� ����� � ����������� */
    private static Boolean checkNameAtNameBook(String ivPhoneOrName,
                                               Map<String, String> itNameBook) {
        Boolean lvIsInTheBook = itNameBook.containsValue(ivPhoneOrName);
        return lvIsInTheBook;
    }

    /* �������� �� ���������� �������� � ����������� */
    private static Boolean checkPhoneAtPhoneBook(String ivPhoneOrName,
                                                 Map<String, String> itPhoneBook) {
        Boolean lvIsInTheBook = itPhoneBook.containsValue(ivPhoneOrName);
        return lvIsInTheBook;
    }

    /* ������� � NameBook ����� */
    private static TreeMap<String, String> putNameBook(String ivNumberOrName,
                                                       TreeMap<String, String> itNameBook) {
        //�������� �� ������������� �����
        Integer lvCount = 1;
//        if (!itNameBook.containsKey(lvCount)) {
        //���� �� ������ - �������� ������
        itNameBook.put(ivNumberOrName + lvCount, ivNumberOrName);
//        } else {
//            //���� ������ - ��������/�������� ������ � ������ ������
//            itPhoneBook.put(lvCount, lvNumberOrName);
//        }

        return itNameBook;
    }

    /* ������� � PhoneBook ������ */
    private static TreeMap<String, String> putPhoneBook(String ivNumberOrName,
                                                        TreeMap<String, String> itPhoneBook) {
        //�������� �� ������������� �����
        Integer lvCount = 1;
//        if (!itPhoneBook.containsKey(lvCount)) {
        //���� �� ������ - �������� ������
        itPhoneBook.put(ivNumberOrName + lvCount, ivNumberOrName);
//        } else {
//            //���� ������ - ��������/�������� ������ � ������ ������
//            itPhoneBook.put(lvCount, lvNumberOrName);
//        }

        return itPhoneBook;
    }
}