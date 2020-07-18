import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

public class MultiThreadedMaps {
    public static void main(String... args) {

      test(new TreeMap<>());
     // test(new HashMap<>());
		/*
		 * for (int i = 0; i < 30; i++) { test(new ConcurrentHashMap<>()); }
		 */
  }

  private static void test(Map<Integer, Integer> numbers) {
      long time = System.nanoTime();
      try {
          try {
              System.out.println(numbers.getClass());
              ThreadLocalRandom.current().ints(3_000_000)
                      .parallel().forEach((n) -> {numbers.put(n, n);});
              System.out.println("OK");
          } catch (Exception e) {
              System.out.println(e);
          }
      } finally {
          time = System.nanoTime() - time;
          System.out.printf("time = %dms%n", (time / 1_000_000));
      }
  }
}
