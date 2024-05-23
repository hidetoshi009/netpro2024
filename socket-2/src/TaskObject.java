
public class TaskObject implements ITask {
    
        String message;
        String content;
        int x;
        int max = 1;
        
        public String getMessage() {
            return message;
        }
    
        public void setMessage(String message) {
            this.message = message;
        }
        
        public String getContent() {
            return content;
        }
    
        public void setContent(String present) {
            this.content = present;
        }
        

        @Override
        public void setExecNumber(int x) {
            this.x=x;
        }
        @Override
        public int getExecNumber() {
            return x;
        }

        @Override
        public void exec() {
            boolean isPrime = false;
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
                    this.max = i; // 素数をカウント
                    // 遅くなるのでコメントアウト    
        }
    }
}

        @Override
        public int getResult() {
            return max;   
        }
    
    }
