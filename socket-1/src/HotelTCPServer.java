import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HotelTCPServer {
    public static void main(String arg[]) {
        try {
            /* 通信の準備をする */
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            scanner.close();
            while (true) {
                
            System.out.println("localhostの" + port + "番ポートで待機します");
            ServerSocket server = new ServerSocket(port); // ポート番号を指定し、クライアントとの接続の準備を行う

            Socket socket = server.accept(); // クライアントからの接続要求を待ち、
            // 要求があればソケットを取得し接続を行う
            System.out.println("接続しました。相手の入力を待っています......");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            HotelInfo info = (HotelInfo) ois.readObject();// Integerクラスでキャスト。

            String msgPresent = info.getMessage();
            System.out.println("部屋番号は" + msgPresent);
            String presentFromClient = info.getContent();
            System.out.println("外観は" + presentFromClient);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            HotelInfo infomation = new HotelInfo();
            infomation.setMessage("支配人です。\n　部屋番号" + msgPresent + "に関するコメントありがとうございます。\nアンケートにお答えいただいたささやかな特典です。");
            infomation.setContent("次回ご利用いただける10％引きクーポン");
            oos.writeObject(infomation);
            oos.flush();

            // close処理

            ois.close();
            oos.close();
            // socketの終了。
            socket.close();
            server.close();
            }

        } // エラーが発生したらエラーメッセージを表示してプログラムを終了する
        catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}
