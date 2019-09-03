package diskCleaner;

import java.io.File;
import java.util.Date;
import java.util.Scanner;

public class DiskCleaners {

    public static void main(String[] args) {
// C:\Users\DiaryOfNPC\Desktop\tester
        Scanner input = new Scanner(System.in);
        System.out.print("Dir path: ");
        String dir = input.nextLine();

        int x = cleaner(0, dir);
        System.out.println(x);
    }


    public static int cleaner(int day, String dir) {
        int count = -1;
        File di = new File(dir);
        File[] f = di.listFiles();

        long daysInMiSec = day * 24 * 60 * 60 * 1000;

        // .lastModified() doesn't return the actually time when last modified.
        // you have to consider system time too
        for (int i = 0; i < f.length; i++) {
            long diff = (System.currentTimeMillis() - f[i].lastModified())
                - daysInMiSec;

            if (diff > 0) {
                f[i].delete();
                count = 0;
            }
        }

        return count;
    }

}
