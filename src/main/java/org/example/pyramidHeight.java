package org.example;

import java.util.*;

public class pyramidHeight {

    public static void main(String[] args) {
      /*  Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] widths = new int[n];
        for (int i = 0; i < n; i++) {
            widths[i] = scanner.nextInt();
        }
*/
        int[] widths = {40, 100, 20, 30};
        int n = widths.length;

        Arrays.sort(widths); // 排序

        int height = 0;
        int prevBlocks = 0;
        int prevWidth = 0;

        int i = 0;
        while (i < n) {
            int currBlocks = 0;
            int currWidth = 0;

            // 当前层需要比上一层多块数和更宽
            while (i < n && (currBlocks <= prevBlocks || currWidth <= prevWidth)) {
                currWidth += widths[i];
                currBlocks++;
                i++;
            }

            if (currBlocks > prevBlocks && currWidth > prevWidth) {
                height++;
                prevBlocks = currBlocks;
                prevWidth = currWidth;
            } else {
                break; // 无法构造更高的层
            }
        }

        System.out.println(height);
    }
}
