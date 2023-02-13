package hw14;

public class TaskTwo {
    public boolean isHappy(int n) {
        while (true) {
            if (n <= 3 & n != 1) {
                return false;
            } else if (n == 1) {
                return true;
            }
            String number = String.valueOf(n);
            String[] splitNumber = number.split("");
            n = happyCheck(splitNumber);
        }
    }
    public int happyCheck (String[]n){
        int currentValue = 0;
        for (int i = 0; i < n.length; i++) {
            currentValue += Integer.parseInt(n[i]) * Integer.parseInt(n[i]);
        }
        return currentValue;
    }
}
