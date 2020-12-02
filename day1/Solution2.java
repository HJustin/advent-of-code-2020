package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Solution2 {
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
        for (int i = 0; i < nums.size(); i++) {
            int target = 2020 - nums.get(i);
            int l = i + 1, r = nums.size() - 1;
            while (l < r && nums.get(l) + nums.get(r) != target) {
                if (nums.get(l) + nums.get(r) < target)
                    l++;
                else if (nums.get(l) + nums.get(r) > target)
                    r--;
            }
            if (l < r && nums.get(l) + nums.get(r) == target)
                return nums.get(i) * nums.get(l) * nums.get(r);
        }
        return 0;
    }
}
