public class App {
    public static void main(String[] args) throws Exception {
        boolean isPrime = false;
        int max = 0;
        int x = 100;
            // 4は素数ではないので計算しない
            // i += 2 をすることで偶数は素数計算しない（2以外の偶数は素数ではないため）
            for (int i = 5; i <= x; i += 2) {
                // 素数判定対象(i)は素数判定対象(j)の平方根以下で除算する
                for (int j = 2; j * j <= i; j++) {
                    // 除算できた場合は素数ではないため判定から抜ける
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                    isPrime = true;
                }
                if (isPrime) {
                    max = i; // 素数をカウント
                    // 遅くなるのでコメントアウト    
        }
    }
    System.out.println(max);
    }
}
