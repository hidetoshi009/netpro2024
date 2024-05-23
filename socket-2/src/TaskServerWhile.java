import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.BindException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TaskServerWhile{
    public static void main(String arg[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("ポート番号を入力してください(5000など) → ");
            int port = scanner.nextInt();
            System.out.println("localhostの" + port + "番ポートで待機します");
            scanner.close();
            while(true){
            ServerSocket server = new ServerSocket(port);
            Socket socket = server.accept();
            System.out.println("接続しました。相手の入力を待っています......");
            
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            TaskObject task = (TaskObject) ois.readObject();
            if(task.getExecNumber() <= 1){
            socket.close();
            server.close();
            }
            task.exec();

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(task);
            oos.flush();

            ois.close();
            oos.close();
            }
        } catch (BindException be) {
            be.printStackTrace();
            System.out.println("ポート番号が不正、ポートが使用中です");
            System.err.println("別のポート番号を指定してください(6000など)");
        } catch (Exception e) {
            System.err.println("エラーが発生したのでプログラムを終了します");
            throw new RuntimeException(e);
        }
    }
}