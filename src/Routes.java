import java.util.ArrayList;

public class Routes {

    static void solve(int a, int b, int c, int d, int[] arr) {
        if (a + 1 > b) return;
        arr[a + 1] = (a + 1) % d == 0 ? arr[(a + 1) - c] + arr[(a + 1) / d] : arr[(a + 1) - c];
        a++;
        solve(a, b, c, d, arr);
    }

    static void get_routes(int a, int b, int c, int d, ArrayList<String> s_array) {
        StringBuilder s_result = new StringBuilder(new String());
        int result = a;
        int[] operation = new int[b + 1];

        for (int i = 0; i < b + 1; i++) {
            for (int j = 0; j < b + 1; j++) {

                result = operation[j] == 0 ? result + c : result * d;

                if (result < b) {
                    s_result.append(operation[j] == 0 ? "+" + Integer.toString(c) + " " : "*" + Integer.toString(d) + " ");
                }

                if (result == b) {
                    s_result.append(operation[j] == 0 ? "+" + Integer.toString(c) + " " : "*" + Integer.toString(d) + " ");
                    s_array.add(s_result.toString());
                    s_result = new StringBuilder();
                    result = a;
                    break;
                }

                if (result > b) {
                    s_result = new StringBuilder();
                    result = a;
                    break;
                }

            }
            operation[i] = 1;
        }
    }


    public static void main(String[] args) {
        int a = 3;
        int b = 15;
        int c = 1;
        int d = 2;
        int[] arr = new int[b + 1];
        arr[a] = 1;
        solve(a, b, c, d, arr); // Вызов рекурсивной функции

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%d -> %d\n", i, arr[i]);
        }
        ArrayList<String> operations = new ArrayList<>();
        get_routes(a, b, c, d, operations); // Нашел несколько маршрутов
        System.out.println(operations);
    }
}


