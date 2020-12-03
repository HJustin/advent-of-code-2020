package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution2 {
    public static void main(String[] args) throws FileNotFoundException {
        long ans = solve();
        System.out.println(ans);
    }

    private static long solve() throws FileNotFoundException {
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

        return countTrees(m, 1, 1) * 247 * countTrees(m, 5, 1) * countTrees(m, 7, 1) * countTrees(m, 1, 2);
    }

    private static long countTrees(List<List<Character>> m, int right, int down) {
        int row = 0, col = 0;
        long count = 0;
        int R = m.size(), C = m.get(0).size();
        while (row < R) {
            Character ch = m.get(row).get(col);
            if (ch == '#')
                count++;
            row = row + down;
            col = (col + right) % C;
        }
        return count;
    }
}
