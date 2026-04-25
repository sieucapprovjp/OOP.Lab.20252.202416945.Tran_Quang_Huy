package AIMS;

import java.util.Random;

public class ConcatenationInLoop{
    public static void main(String[] args) {
        Random r = new Random(123);

        // --- Test 1: Nối chuỗi bằng toán tử '+' (String) ---
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("Thời gian dùng String (+): " + (System.currentTimeMillis() - start) + " ms"); // Thường mất vài ngàn ms

        // --- Test 2: Nối chuỗi bằng StringBuilder ---
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println("Thời gian dùng StringBuilder: " + (System.currentTimeMillis() - start) + " ms"); // Thường chỉ mất ~5ms

        // --- Test 3: Nối chuỗi bằng StringBuffer (Tương tự StringBuilder nhưng an toàn cho đa luồng) ---
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sBuffer.append(r.nextInt(2));
        }
        s = sBuffer.toString();
        System.out.println("Thời gian dùng StringBuffer: " + (System.currentTimeMillis() - start) + " ms");
    }
}