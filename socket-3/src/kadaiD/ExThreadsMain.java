package kadaiD;

public class ExThreadsMain implements Runnable {
    public static void main(String[] args) {
        // インスタンス作成
        ExThreadsMain[] task = new ExThreadsMain[3];
        // スレッドを作成して実行
        Thread[] threads = new Thread[3];
        for (int i = 0; i < 3; i++) {
            task[i] = new ExThreadsMain();
            threads[i] = new Thread(task[i]);
            threads[i].start();

        }
        try {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
                System.out.println("main=" + sum);
                Thread.sleep(500); // ミリ秒単位のスリープ時間
            }

        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }
    }

    public void run() {
        try {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
                System.out.println("threads=" + sum);

                // スレッドを 1000 ミリ秒間一時停止します。
                Thread.sleep(1000); // ミリ秒単位のスリープ時間
            }
        } catch (InterruptedException e) {
            // スレッドが中断された場合は、例外を出力します。
            System.err.println(e);
        }
    }
}
