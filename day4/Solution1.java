package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution1 {
    public static void main(String[] args) throws FileNotFoundException {
        int ans = solve();
        System.out.println(ans);
    }

    private static int solve() throws FileNotFoundException {
        // byr (Birth Year)
        // iyr (Issue Year)
        // eyr (Expiration Year)
        // hgt (Height)
        // hcl (Hair Color)
        // ecl (Eye Color)
        // pid (Passport ID)
        // cid (Country ID)
        Map<String, Integer> m = new HashMap<>();
        m.put("byr", 0);
        m.put("iyr", 1);
        m.put("eyr", 2);
        m.put("hgt", 3);
        m.put("hcl", 4);
        m.put("ecl", 5);
        m.put("pid", 6);
        m.put("cid", 7);

        int valid = 0;
        File input = new File("day4/input.txt");
        Scanner s = new Scanner(input);
        int bits = 0b0;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (!line.isEmpty()) {
                for (String str : line.split(" ")) {
                    String key = str.split(":")[0];
                    bits |= (1 << m.get(key));
                }
            }
            else {
                if (bits == 0b01111111 || bits == 0b11111111) {
                    valid++;
                }
                bits = 0;
            }
        }
        s.close();

        return valid;
    }
}
