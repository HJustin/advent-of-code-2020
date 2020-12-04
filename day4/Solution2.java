package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution2 {
    public static void main(String[] args) throws FileNotFoundException {
        int ans = solve();
        System.out.println(ans);
    }

    private static int solve() throws FileNotFoundException {
        Map<String, Integer> m = new HashMap<>();
        // byr (Birth Year)
        // iyr (Issue Year)
        // eyr (Expiration Year)
        // hgt (Height)
        // hcl (Hair Color)
        // ecl (Eye Color)
        // pid (Passport ID)
        // cid (Country ID)
        m.put("byr", 0);
        m.put("iyr", 1);
        m.put("eyr", 2);
        m.put("hgt", 3);
        m.put("hcl", 4);
        m.put("ecl", 5);
        m.put("pid", 6);
        m.put("cid", 7);

        File input = new File("day4/input.txt");
        Scanner s = new Scanner(input);
        int valid = 0, bits = 0b0;
        boolean validFields = true;
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if (!line.isEmpty()) {
                for (String str : line.split(" ")) {
                    String key = str.split(":")[0];
                    String value = str.split(":")[1];
                    validFields &= checkFieldValid(key, value);
                    bits |= (1 << m.get(key));
                }
            } else {
                if (validFields && (bits == 0b01111111 || bits == 0b11111111)) {
                    valid++;
                }
                bits = 0;
                validFields = true;
            }
        }
        s.close();
        return valid;
    }

    private static boolean checkFieldValid(String key, String value) {
        if (key.equals("byr")) {
            Pattern pattern = Pattern.compile("[0-9]{4}");
            Matcher matcher = pattern.matcher(value);
            return matcher.matches() && Integer.parseInt(value) >= 1920 && Integer.parseInt(value) <= 2002;
        }
        if (key.equals("iyr")) {
            Pattern pattern = Pattern.compile("[0-9]{4}");
            Matcher matcher = pattern.matcher(value);
            return matcher.matches() && Integer.parseInt(value) >= 2010 && Integer.parseInt(value) <= 2020;
        }
        if (key.equals("eyr")) {
            Pattern pattern = Pattern.compile("[0-9]{4}");
            Matcher matcher = pattern.matcher(value);
            return matcher.matches() && Integer.parseInt(value) >= 2020 && Integer.parseInt(value) <= 2030;
        }
        if (key.equals("hgt")) {
            if (value.contains("cm")) {
                String hgt = value.split("cm")[0];
                Pattern pattern = Pattern.compile("[0-9]{3}");
                Matcher matcher = pattern.matcher(hgt);
                return matcher.matches() && Integer.parseInt(hgt) >= 150 && Integer.parseInt(hgt) <= 193;
            } else if (value.contains("in")) {
                String hgt = value.split("in")[0];
                Pattern pattern = Pattern.compile("[0-9]{2}");
                Matcher matcher = pattern.matcher(hgt);
                return matcher.matches() && Integer.parseInt(hgt) >= 59 && Integer.parseInt(hgt) <= 76;
            }
        }
        if (key.equals("hcl")) {
            Pattern pattern = Pattern.compile("#[0-9a-f]{6}");
            Matcher matcher = pattern.matcher(value);
            return matcher.matches();
        }
        if (key.equals("ecl")) {
            return value.equals("amb") || value.equals("blu") || value.equals("brn") || value.equals("gry")
                    || value.equals("grn") || value.equals("hzl") || value.equals("oth");
        }
        if (key.equals("pid")) {
            Pattern pattern = Pattern.compile("[0-9]{9}");
            Matcher matcher = pattern.matcher(value);
            return matcher.matches();
        }
        return key.equals("cid");
    }
}
