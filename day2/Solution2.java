package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution2 {
    public static void main(String[] args) throws FileNotFoundException {
        int ans = solve();
        System.out.println(ans);
    }

    private static int solve() throws FileNotFoundException {
        int validPassword = 0;

        File input = new File("day2/input.txt");
        Scanner s = new Scanner(input);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (valid(line)) {
                validPassword++;
            }
        }
        s.close();

        return validPassword;
    }

    private static boolean valid(String line) {
        String policy = line.split(":")[0];
        String password = line.split(":")[1].strip();
        int low = Integer.parseInt(policy.split("-")[0]);
        int high = Integer.parseInt(policy.split("-")[1].split(" ")[0]);
        String target = policy.split("-")[1].split(" ")[1];

        boolean pos1 = false, pos2 = false;
        if (low - 1 < password.length()) {
            pos1 = target.equals(Character.toString(password.charAt(low - 1)));
        }
        if (high - 1 < password.length()) {
            pos2 = target.equals(Character.toString(password.charAt(high - 1)));
        }

        return pos1 ^ pos2;
    }
}