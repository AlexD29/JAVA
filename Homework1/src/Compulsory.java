public class Compulsory {
    public static int sumDigits(int nr) {
        int sum = 0;
        while(nr != 0) {
            sum = sum + nr%10;
            nr = nr/10;
        }
        if(sum > 9) {
            sum = sumDigits(sum);
        }
        return sum;
    }
    public static void main(String[] args) {
        String languages[]= {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n = n*3;
        int decimal = Integer.parseInt("10101",2);
        n = n + decimal;
        int hex = Integer.parseInt("FF",16);
        n = n + hex;
        n = n * 6;
        System.out.println("Willy-nilly, this semester I will learn " + languages[sumDigits(n)]);
    }
}
