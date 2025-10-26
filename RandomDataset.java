import java.io.*;
import java.util.*;

public class RandomDataset {
    static String[] FN = { "John", "Jane", "Mike", "Emma", "Chris", "Olivia" };
    static String[] LN = { "Smith", "Brown", "Jones", "Miller", "Davis", "Garcia" };
    static String[] LOC = { "NY", "LA", "Chicago", "Houston", "Phoenix", "Philly" };

    public static void main(String[] a) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter records: ");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter file name: ");
        String file = sc.nextLine() + ".csv";
        sc.close();

        Random r = new Random();
        Set<String> used = new HashSet<>();
        try (FileWriter w = new FileWriter(file)) {
            w.write("First,Last,Mobile,ID,Email,Age,Location\n");
            for (int i = 0; i < n; i++) {
                String first = FN[r.nextInt(FN.length)];
                String last = LN[r.nextInt(LN.length)];
                String full = first + last;
                if (used.contains(full)) {
                    i--;
                    continue;
                }
                used.add(full);
                String mobile = "9" + String.format("%09d", r.nextInt(1_000_000_000));
                String id = "ID" + String.format("%06d", r.nextInt(1_000_000));
                String email = (first + "." + last + r.nextInt(1000) + "@ex.com").toLowerCase();
                int age = 18 + r.nextInt(63);
                String loc = LOC[r.nextInt(LOC.length)];
                w.write(String.join(",", first, last, mobile, id, email, String.valueOf(age), loc) + "\n");
            }
        }
        System.out.println("Done!");
    }
}
