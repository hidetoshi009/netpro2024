import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class TaskClientWhile {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            System.out.println("素数を計算します");  
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            while (true) {  
            System.out.println("数値を入力してください↓");
        
            int num = scanner.nextInt();
            if(num <= 1){
            System.out.println("入力値が不正のためプログラムを終了します");
            num = -1;
            scanner.close();
            socket.close();
            }
            TaskObject number = new TaskObject();
            number.setExecNumber(num);
            oos.writeObject(number);
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            TaskObject maxsosuu = (TaskObject)ois.readObject();

            int replaySosuu = maxsosuu.getResult();
            System.out.println("最大の素数は"+replaySosuu);

            ois.close();
            oos.close();
            }
            
        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.err.println("ポート番号が不正か、サーバが起動していません");
            System.err.println("サーバが起動しているか確認してください");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
