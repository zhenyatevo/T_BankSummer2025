/*Эта задача настолько легендарная, что даже в условии нет легенды.
Пусть дано рациональное число  и у него существует представление в виде , где  и  взаимнопростые, тогда его красотой называется
Вам даны целое число  и массив целых положительных чисел
Последовательность  из целых положительных чисел длины  называется прекрасной, если выполнены следующие условия:
Для всех  выполнено, что красота
Наибольший общий делитель всех чисел  равен 1.
Интересностью последовательности  называется произведение
Требуется найти сумму интересностей всех прекрасных последовательностей. Так как ответ может быть большим, то нужно найти его по модулю .
Формат входных данных
В первой строке данных дано число n
Во второй строке дан массив целых положительных чисел
Формат выходных данных
Выведите ответ на задачу.
ввод
5
4 1 1 2
вывод
712
ввод
2
4
вывод
8*/
import java.util.*;
import java.math.BigInteger;

public class task7 {
    static final int MOD = 1000000007;
    static final int MAX_A = 10000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        List<List<Integer>> aOptions = new ArrayList<>();
        for (int bi : b) {
            List<Integer> options = new ArrayList<>();
            for (int p = 1; p < bi; p++) {
                int q = bi - p;
                if (gcd(p, q) == 1) {
                    options.add(p * q);
                }
            }
            aOptions.add(options);
        }

        long[] dp = new long[MAX_A + 1];
        dp[0] = 1;

        for (List<Integer> options : aOptions) {
            long[] newDp = new long[MAX_A + 1];
            for (int currentGcd = 0; currentGcd <= MAX_A; currentGcd++) {
                if (dp[currentGcd] == 0) continue;
                for (int a : options) {
                    int newGcd = gcdFast(currentGcd, a);
                    newDp[newGcd] = (newDp[newGcd] + dp[currentGcd] * a) % MOD;
                }
            }
            dp = newDp;
        }

        System.out.println(dp[1]);
    }

    private static int gcdFast(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private static int gcd(int a, int b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue();
    }
}
