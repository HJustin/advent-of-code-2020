package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Solution1 {
    public static void main(String[] args) {
        int validPassword = readAndSolve();
        System.out.println(validPassword);
    }

    private static int readAndSolve() {
        int validPassword = 0;
        try {
            File input = new File("day2/input.txt");
            Scanner s = new Scanner(input);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (valid(line)) {
                    validPassword++;
                }
            }
            s.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return validPassword;
    }

    private static boolean valid(String line) {
        String policy = line.split(":")[0];
        String password = line.split(":")[1].strip();
        int low = Integer.parseInt(policy.split("-")[0]);
        int high = Integer.parseInt(policy.split("-")[1].split(" ")[0]);
        String target = policy.split("-")[1].split(" ")[1];

        int count = 0;
        for (int i=0; i<password.length(); i++) {
            if (target.equals(Character.toString(password.charAt(i)))) {
                count++;
            }
        }

        return count >= low && count <= high;
    } 
}