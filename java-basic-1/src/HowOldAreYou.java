
// C言語では、#include に相当する
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HowOldAreYou {

    /**
     * @param args
     */
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader というのは、データ読み込みのクラス(型)
        // クラスの変数を作るには、new を使う。

        // readLine() は、入出力エラーの可能性がある。エラー処理がないとコンパイルできない。
        // Java では、 try{ XXXXXXXX } catch(エラーの型 変数) { XXXXXXXXXXXXXXXXXX} と書く
        while (true) {
            try {
                System.out.println("何歳ですか?");
                String line = reader.readLine();
                if (line.equals("q") || line.equals("e"))
                    break;
                int age = Integer.parseInt(line);
                if (age < 0 || age >= 120) {
                    System.out.println("正しい年齢を入力してください");
                    age = Integer.parseInt(line);
                } else {
                    System.out.println("あなたは" + age + "歳ですね。");
                    System.out.println("あなたは2030年、" + (age + 6) + "歳ですね。");

                    if (113 <= age && age < 120)
                        System.out.println("あなたの元号は明治" + (120 - age) + "年です");

                    if (99 <= age && age < 113) {
                        if (age == 112)
                            System.out.println("あなたの元号は大正元年です");
                        else
                            System.out.println("あなたの元号は大正" + (112 - age) + "年です");
                    }

                    if (36 <= age && age < 99) {
                        if (age == 98)
                            System.out.println("あなたの元号は昭和元年です");
                        else
                            System.out.println("あなたの元号は昭和" + (98 - age) + "年です");
                    }
                    if (7 <= age && age < 36) {
                        if (age == 35)
                            System.out.println("あなたの元号は平成元年です");
                        else
                            System.out.println("あなたの元号は平成" + (35 - age) + "年です");
                    }
                    if (age < 7) {
                        if (age == 6)
                            System.out.println("あなたの元号は大正元年です");
                        else
                            System.out.println("あなたの元号は令和" + (6 - age) + "年です");
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }

        }
    }
}

// 課題 キーボードから数字を打ち込む
// その結果、 あなたは、???歳ですね、と画面に表示させる。
// その後、あなたは10年後、????歳ですね、と画面に表示させる。
