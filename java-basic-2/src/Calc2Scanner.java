import java.util.Scanner;

public class Calc2Scanner {

	public static void main(String[] args) {
		int i=0;
		while(i<10) {
			Scanner scan = new Scanner(System.in);
            try{
                System.out.println("数字を入力してください");
			String str = scan.next();
			System.out.println("最初のトークンは: " + str);
            int x = Integer.parseInt(str);
			str = scan.next();
			System.out.println("次のトークンは  : " + str);
            int y = Integer.parseInt(str);
            System.out.println("数値の合計は" + (x + y));
			i++;
            }
            catch
                (NumberFormatException e){
                System.out.println("数字ではありません。");
            }
        }


	}
}

//  課題    キーボードから2つの数字を打ち込む
//     その足し算結果を、出力する。