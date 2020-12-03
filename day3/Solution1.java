package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution1 {
    public static void main(String[] args) throws FileNotFoundException {
        int ans = solve();
        System.out.println(ans);
    }

    private static int solve() throws FileNotFoundException {
        List<List<Character>> m = new ArrayList<>();

        File input = new File("day3/input.txt");
        Scanner s = new Scanner(input);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            List<Character> l = new ArrayList<>();
            for (int i = 0; i < line.strip().length(); i++) {
                l.add(line.charAt(i));
            }
            m.add(l);
        }
        s.close();

        return countTrees(m);
    }

    private static int countTrees(List<List<Character>> m) {
        int row = 0, col = 0, count = 0;
        int R = m.size(), C = m.get(0).size();
        while (row < R) {
            Character ch = m.get(row).get(col);
            if (ch == '#')
                count++;
            row++;
            col = (col + 3) % C;
        }
        return count;
    }
}