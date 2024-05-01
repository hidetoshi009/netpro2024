import java.util.Arrays;
import java.util.Random;

public class HeikinCKadai {
    public static void main(String[] args) {

        Kamoku[] math = new Kamoku[100];
        Random random = new Random();
        int b[] = new int[100];
        int N = 0; // 合格者の数
        int num = 0;
        int sum = 0;
        int ave = 0;
        // Kamokuクラスのインスタンスとして、math
        for (int i = 0; i < 100; i++) {
            math[i] = new Kamoku(random.nextInt(101));
            b[i] = math[i].getScore();
            sum += b[i];
            ave = (sum) / 100;
            // 合格者の数
            if (b[i] >= 80)
                N++;

        }
        System.out.println("平均点は" + ave + "ですね");
        System.out.println("以下合格者の点数です。");
        int gou[] = new int[N];
        for (int i = 0; i < 100; i++) {
            if (b[i] >= 80) {
                gou[num] = b[i];
                num++;
            }
        }

        Arrays.sort(gou);

        for (int i : gou) {
            System.out.println(i);
        }

    }
}
