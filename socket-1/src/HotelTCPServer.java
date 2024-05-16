import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.Socket; //ネットワーク関連のパッケージを利用する
import java.util.Scanner;

public class HotelTCPServer {

    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポートを入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートに接続を要求します");
            Socket socket = new Socket("localhost", port);
            System.out.println("接続されました");

            System.out.println("部屋の情報を送ります");
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            System.out.println("部屋番号を入力してください(例:503) ↓");
            String message = scanner.next();
            System.out.println("部屋の外観を入力してください(例:海) ↓");
            String content = scanner.next();
            scanner.close();

            HotelInfo Infomation = new HotelInfo();
            Infomation.setMessage(message);
            Infomation.setContent(content);

            oos.writeObject(Infomation);
            oos.flush();

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

            HotelInfo RoomInfo = (HotelInfo) ois.readObject();

            String replayMsg = RoomInfo.getMessage();
            System.out.println("サーバからのメッセージは" + replayMsg);
            String replayContent = RoomInfo.getContent();
            System.out.println(replayContent + "をもらいました！");

            ois.close();
            oos.close();
            socket.close();

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
