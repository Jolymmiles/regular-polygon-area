import java.util.Scanner;

public class RegularPolygon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        double s = Double.parseDouble(makeNormal(sc.nextLine()));
        System.out.print(area(n, s));
    }

    private static Object area (int n, double side) {
        if (n > 2) {
            return (Math.pow(side, 2) * n) / (4 * Math.tan(Math.PI / n));
        } else
            return "NO";
    }

    private static String makeNormal (String s) {
        return s.replace("," , ".");
    }
}
