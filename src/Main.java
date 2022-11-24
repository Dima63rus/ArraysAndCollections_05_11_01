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

        TreeMap<String, String> ltNameBook = new TreeMap<>();
        TreeMap<String, String> ltPhoneBook = new TreeMap<>();

        //����������� ����
        for (; ; ) {
            System.out.println("������� ��� ���� ����� ��������");

            //������� ��������� ������
            String lvPhoneOrName = loScanner.nextLine();
            //������ ������ ����� ����� �������
            int lvSpacePos = lvPhoneOrName.indexOf(" ");
            if (lvSpacePos > 0) {
                lvPhoneOrName = lvPhoneOrName.substring(0, lvSpacePos - 1);
            }

            //���������� ����������
            if (lvPhoneOrName.equals(MC_LIST)) {
                printNamePhoneBook(ltNameBook, ltPhoneBook);
                continue;
            }

            //��� ��� ����� ��������
            if (checkName(lvPhoneOrName)) {
                //������� ���
                //�������� �� ���������� ����� � �����������,
                // ���� ���� - ����� �� ����� � ���������
                // ���� ��� - ��������� ������ ������ ����� �������� � ���������� ���.
                if (checkNameAtNameBook(lvPhoneOrName, ltNameBook)) {
                    //����� � ������� � ��������� ����� ������ �� �����
                    printSingleNamePhoneBookForName(lvPhoneOrName, ltNameBook, ltPhoneBook);
                } else {
                    //��������� ������ ������ ����� �������� � ���������� ���
                    Scanner loScannerPhone = new Scanner(System.in);
                    System.out.print(lvPhoneOrName + " - ��� � ���������. ");
                    System.out.print("������� ����� �������� ������ ������������. \n");

                    //��������� ����� ��������
                    String lvPhone = loScannerPhone.nextLine();

                    //�������� � ��������� ����
                    putNameBook(lvPhoneOrName, ltNameBook);

                    //������ � PhoneBook ����� ������
                    putPhoneBookForNameBook(lvPhoneOrName,
                            lvPhone,
                            ltPhoneBook);
                }
            } else if (checkPhone(lvPhoneOrName)) {
                //������ ����� ��������
                //�������� �� ���������� ������ � �����������,
                // ���� ���� - ����� �� ����� � ������
                // ���� ��� - ��������� ������ ������ ��� � ���������� ���.
                if (checkPhoneAtPhoneBook(lvPhoneOrName, ltPhoneBook)) {
                    //����� � ������� � ��������� ����� ������ �� �����
                    printSingleNamePhoneBookForPhone(lvPhoneOrName, ltNameBook, ltPhoneBook);
                } else {
                    //��������� ������ ������ ��� � ���������� ���
                    Scanner loScannerName = new Scanner(System.in);
                    System.out.print(lvPhoneOrName + " - ��� � ���������. ");
                    System.out.print("������� ��� ������ ������������. \n");

                    //��������� ��� ��������
                    String lvName = loScannerName.nextLine();

                    //�������� � ��������� ����
                    putNameBook(lvName, ltNameBook);

                    //������ � PhoneBook ����� ������
                    putPhoneBookForNameBook(lvName,
                            lvPhoneOrName,
                            ltPhoneBook);
                }
            } else {
                System.out.println("������������ ����");
            }
        }
    }


    /* �������� �� ���������� ���������� ����� (�� ������ ���� ��������)*/
    private static Boolean checkName(String ivPhoneOrName) {
        //+ �������� "���� ��� ��������� ���" � \D �������� "�������"
        return ivPhoneOrName.matches("\\D+");
    }


    /* �������� �� ���������� ���������� ������ (�� ������ ���� ����) */
    private static Boolean checkPhone(String ivPhoneOrName) {
        //+ �������� "���� ��� ��������� ���" � \d �������� "�����"
        return ivPhoneOrName.matches("\\d+");
    }


    /* �������� �� ���������� ����� � ����������� */
    private static Boolean checkNameAtNameBook(String ivPhoneOrName,
                                               Map<String, String> itNameBook) {
        return itNameBook.containsValue(ivPhoneOrName);
    }


    /* �������� �� ���������� �������� � ����������� */
    private static Boolean checkPhoneAtPhoneBook(String ivPhoneOrName,
                                                 Map<String, String> itPhoneBook) {
        return itPhoneBook.containsValue(ivPhoneOrName);
    }


    /* ������� � NameBook ����� */
    private static void putNameBook(String ivNumber,
                                    TreeMap<String, String> itNameBook) {
        int lvCount = 1;
        itNameBook.put(ivNumber + lvCount, ivNumber);
    }


    /* ������ � PhoneBook ����� ������ */
    private static void putPhoneBookForNameBook(String lvName,
                                                String lvPhone,
                                                TreeMap<String, String> itPhoneBook) {
//        ������� � ltPhoneBook key=���� value=89276551681
        itPhoneBook.put(lvName, lvPhone);
        System.out.println("������ ��������� � �����������: " + lvName + " " + lvPhone);
    }


    /* ����� � ������� �������� ������� */
    private static void printNamePhoneBook(TreeMap<String, String> itNameBook,
                                           TreeMap<String, String> itPhoneBook) {
        for (String lvKey : itNameBook.keySet()) {
            String lvValue = itNameBook.get(lvKey);

            System.out.println(lvValue + " " + itPhoneBook.get(lvValue));
        }
    }


    /* ����� � ������� ������ �������� ������� �� ����� */
    private static void printSingleNamePhoneBookForName(String ivName,
                                                        TreeMap<String, String> itNameBook,
                                                        TreeMap<String, String> itPhoneBook) {
        int lvCount = 1;
        String lvNameValue = itNameBook.get(ivName + lvCount);
        String lvPhoneValue = itPhoneBook.get(ivName);
        System.out.println(lvNameValue + " " + lvPhoneValue);
    }


    /* ����� � ������� ������ �������� ������� �� �������� */
    private static void printSingleNamePhoneBookForPhone(String ivPhone,
                                                         TreeMap<String, String> itNameBook,
                                                         TreeMap<String, String> itPhoneBook) {
        for (String lvKey : itPhoneBook.keySet()) {
            //����� ����� �� ��������� itPhoneBook
            String lvValue = itPhoneBook.get(lvKey);
            if (lvValue.equals(ivPhone)) {
                //����� � itNameBook ����� �� ���������� ������
                int lvCount = 1;
                String lvName = itNameBook.get(lvKey + lvCount);
                System.out.println(lvName + " " + ivPhone);
            }
        }
    }
}