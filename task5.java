/*В ВУЗе Никите задали домашнее задание по программированию, которое он никак не мог решить, поэтому он попросил вас решить следующую задачу.
Дана строка  длины , состоящая из "(" и ")". Со строкой можно проделывать две операции:
Выбрать пару  такую, что  и поменять символы и  местами за  монет.
Заменить произвольный символ строки на "(" или ")" за  монет.
Требуется сделать строку  правильной скобочной последовательностью за минимальное количество монет.
Строка является правильной скобочной последовательностью, если выполнено одно из трех условий:
Строка пустая.
Строку можно представить в виде , где  правильная скобочная последовательность.
Строку можно представить в виде , где  правильные скобочные последовательности.
Формат входных данных
В первой строке входных данных дано три числа
Во второй строке дана строка  длины , состоящая из символов "(" и ")".

Замечание
В примере можно поменять 3-ий и 4-ый символы местами за 4 монеты и 6-ой символ на ")" за 3 монеты.
ввод
3 4 3
())(((
вывод
7*/
import java.util.Scanner;
import java.util.Stack;

public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int n = scanner.nextInt();
        String s = scanner.next();

        Stack<Integer> stack = new Stack<>();
        int[] mismatch = new int[n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    mismatch[i] = 1;
                }
            }
        }
        while (!stack.isEmpty()) {
            mismatch[stack.pop()] = -1;
        }

        int swaps = 0;
        int changes = 0;

        if (a < 2 * b) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                while (left < right && mismatch[left] != 1) left++;
                while (left < right && mismatch[right] != -1) right--;
                if (left < right) {
                    swaps++;
                    mismatch[left] = 0;
                    mismatch[right] = 0;
                    left++;
                    right--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (mismatch[i] != 0) changes++;
        }

        int totalCost = swaps * a + changes * b;
        System.out.println(totalCost);
    }
}
