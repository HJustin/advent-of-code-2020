package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution1 {
    public static void main(String[] args) throws FileNotFoundException {
        long ans = solve();
        System.out.println(ans);
    }

    private static int solve() throws FileNotFoundException {
        List<Integer> nums = new ArrayList<>();

        File input = new File("day1/input.txt");
        Scanner s = new Scanner(input);
        while (s.hasNextLine()) {
            String line = s.nextLine();
            nums.add(Integer.parseInt(line));
        }
        s.close();

        return sumAndMultiply(nums);
    }

    private static int sumAndMultiply(List<Integer> nums) {
        Collections.sort(nums);
        int l = 0, r = nums.size() - 1;
        while (nums.get(l) + nums.get(r) != 2020) {
            if (nums.get(l) + nums.get(r) < 2020)
                l++;
            else if (nums.get(l) + nums.get(r) > 2020)
                r--;
        }
        return nums.get(l) * nums.get(r);
    }
}
