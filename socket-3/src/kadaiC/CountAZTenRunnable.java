package kadaiC;

// Runnable インターフェースを実装することで、このクラスのインスタンスはスレッドとして実行可能になります。
public class CountAZTenRunnable implements Runnable {
    String myAlfabetStr= "noname";
    // main メソッドはプログラムのエントリーポイントです。
    public static void main(String[] args){
        // 2つの文字を初期化します。
        char c1 = (char)97; // ASCII値 97 は 'a' です
        char c2 = (char)(c1 + 1); // c1 に 1 を足すと ASCII値 98 になり、'b' になります
        char c3 = (char)(c2 + 1);
        
        // 初期化した文字をコンソールに出力します。
        System.out.println(c1); // 出力: a
        System.out.println(c2); // 出力: b
        System.out.println(c3); // 出力: b

        // CountTenRunnable クラスのインスタンスを作成します。
        CountAZTenRunnable[] list = new CountAZTenRunnable[26];

        // ct を実行する新しいスレッドを作成します。
        char[] colors = new char[26];
        Thread[] threads = new Thread[26];

        // スレッドを開始します。これにより、CountTenRunnable の run メソッドが呼び出されます
        for(int i=0; i<26;i++){
            colors[i] = (char) (97 + i);
            list[i] = new CountAZTenRunnable();
            list[i].setAlfabet(colors[i]+"");
            threads[i] = new Thread(list[i]); 
            threads[i].start();
            
        }
        
        // この try-catch ブロックは、0 から 9 までの値を 500 ミリ秒間隔で出力するループを実行します。
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println("main:i=" + i);

                // メインスレッドを 500 ミリ秒間一時停止します。
                Thread.sleep(500);  // ミリ秒単位のスリープ時間
            }
        }
        catch(InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }

    public void setAlfabet(String string) {
        myAlfabetStr = string;
    }

    // run メソッドは、新しいスレッドが実行するコードを含みます。
    public void run() {
        // この try-catch ブロックは、0 から 9 までの値を 1000 ミリ秒間隔で出力するループを実行します。
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println(myAlfabetStr+ i);

                // スレッドを 1000 ミリ秒間一時停止します。
                Thread.sleep(1000);  // ミリ秒単位のスリープ時間
            }
        }
        catch(InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }
}


