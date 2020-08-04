package com.wy.interview;

//class LRUCache {
//    public static int solution(int n) {
//        int[] d = new int[30];
//        int l = 0;
//        int p;
//        while (n > 0) {
//            d[l] = n % 2;
//            n /= 2;
//            l++;
//        }
//        for (p = 1; p < l; ++p) {
//            int i;
//            boolean ok = true;
//            for (i = 0; i < l - p; ++i) {
//                if (d[i] != d[i + p]) {
//                    ok = false;
//                    break;
//                }
//            }
//            if (ok && p < l/2) {
//                return p;
//            }
//        }
//        return -1;
//    }
//
//    public static void main(String[] args) {
//        System.out.println(solution(995));
//        Math.min()
//    }
//}
class Solution {
    public static int solution(int[] A, int X, int Y, int Z) {
        // write your code in Java SE 8
        int waitingTime = 0;
        int waitingTimeX = 0;
        int waitingTimeY = 0;
        int waitingTimeZ = 0;
        for (int i = 0; i < A.length; i++){
            if (A[i] <= X){
                X = X - A[i];
                waitingTimeX += A[i];
            }else if (A[i] <= Y){
                Y = Y - A[i];
                waitingTimeY += A[i];
            }else if (A[i] <=Z){
                Z = Z - A[i];
                waitingTimeZ += A[i];
            }else {
                return -1;
            }
        }
        waitingTime = Math.min(waitingTimeX, Math.min(waitingTimeY, waitingTimeZ));
        return waitingTime;
    }

    public static void main(String[] args) {
//        int[] array = {2, 8, 4, 3, 2};
        int[] array = {5};
        System.out.println(solution(array, 7, 11, 3));
    }
}
