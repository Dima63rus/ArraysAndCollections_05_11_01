import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
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

        TreeMap<String, Integer> ltPhoneBook = new TreeMap<>();

        //����������� ����
        for (; ; ) {
            //������� ��������� ������
            String lvNumberOrName = loScanner.nextLine();
            //�������� �� ���������� �����
            if (checkNumber(lvNumberOrName)) {
                //�������� �� ���������� ����� � �����������,
                // ���� ���� - ����� �� ����� � ���������
                // ���� ��� - ��������� ������ ������ ����� �������� � ���������� ���.
                if (checkNumberAtPhoneBook(lvNumberOrName, ltPhoneBook)) {
//                   ����� �� ����� � ���������
//                   printBook();
                } else {
//                    ��������� ������ ������ ����� �������� � ���������� ���.
//                    putIntoBook();
                }
            } else {
                System.out.println("������������ ���");
                continue;
            }

            //�������� �� ���������� ��������
            if (checkPhone(lvNumberOrName)) {
                //�������� �� ���������� �������� � �����������,
                // ���� ���� - ����� �� ����� � ������
                // ���� ��� - ��������� ������ ������ ��� � ����� ����������.
                if (checkPhoneAtPhoneBook(lvNumberOrName, ltPhoneBook)) {
//                   ����� �� ����� � ���������
//                   printBook();
                } else {
//                    ��������� ������ ������ ����� �������� � ���������� ���.
//                    putIntoBook();
                }
            } else {
                System.out.println("������������ ����� ��������");
                continue;
            }
        }
    }

    /* �������� �� ���������� ���������� ����� (�� ������ ���� ��������)*/
    private static Boolean checkNumber(String ivNumberOrName) {
        //+ �������� "���� ��� ��������� ���" � \D �������� "�������"
        Boolean lvNoNumbers = ivNumberOrName.matches("\\D+");
        return lvNoNumbers;
    }

    /* �������� �� ���������� ���������� ������ (�� ������ ���� ����) */
    private static Boolean checkPhone(String ivNumberOrName) {
        //+ �������� "���� ��� ��������� ���" � \d �������� "�����"
        Boolean lvOnlyNumbers = ivNumberOrName.matches("\\d+");
        return lvOnlyNumbers;
    }

    /* �������� �� ���������� ����� � ����������� */
    private static Boolean checkNumberAtPhoneBook(String ivNumberOrName,
                                                  Map<String, Integer> itPhoneBook) {
        Boolean lvIsInTheBook = itPhoneBook.containsKey(ivNumberOrName);
        return false;
    }

    /* �������� �� ���������� �������� � ����������� */
    private static Boolean checkPhoneAtPhoneBook(String ivNumberOrName,
                                                 Map<String, Integer> itPhoneBook) {
        Boolean lvIsInTheBook = itPhoneBook.containsKey(ivNumberOrName);
        return false;
    }
}