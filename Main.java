/*
Недавно Кирилл нашел строку из четырех символов. Ему стало интересно, является ли она почти палиндромом. Строка называется почти палиндромом, если из нее можно удалить один символ, чтобы она читалась слева направо также, как и справа налево.
Помогите Кириллу это проверить.
Формат входных данных
В единственной строке входных данных дается строка из четырех латинских символов.
Формат выходных данных
Выведите , если строка является почти палиндромом,  в ином случае.

Замечание
В первом примере можно удалить второй символ из строки, тогда останется строка "aba"

пример входных данных
acba
вывод YES
dcba
вывод NO
* */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(isAlmostPalindrome(s) ? "YES" : "NO");
    }

    public static boolean isAlmostPalindrome(String s) {
        // Проверяем, является ли строка палиндромом без изменений
        if (isPalindrome(s)) {
            return true;
        }

        // Проверяем все возможные варианты удаления одного символа
        for (int i = 0; i < s.length(); i++) {
            String modified = s.substring(0, i) + s.substring(i + 1);
            if (isPalindrome(modified)) {
                return true;
            }
        }

        return false;
    }

    // Проверяет, является ли строка палиндромом
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
