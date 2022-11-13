# Решить задачу с маршрутами через рекурсию

```markdown
public class app {

  static int[] solve(int a, int b, int c, int d) {
    int[] arr = new int[b + 1];
    arr[a] = 1;
    for (int index = a + 1; index <= b; index++) {
      if (index % d == 0) {
        arr[index] = arr[index - c] + arr[index / d];
      } else {
        arr[index] = arr[index - c];
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    int a = 6;
    int b = 78;
    int c = 3;
    int d = 5;
    var so = solve(a, b, c, d);

    for (int i = 0; i < so.length; i++) {
      System.out.printf("%d -> %d\n", i, so[i]);
    }
  }
}
```

*Переделал функцию поиска количества маршрутов в рекурсивную. Добавил поиск маршрутов.*

