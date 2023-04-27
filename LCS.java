// public class LCS {
//     public static void printArray(int arr[][]) {
//         for (int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < arr.length; j++) {
//                 System.out.print(arr[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }

//     public static void printArray1(String arr[][]) {
//         for (int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < arr.length; j++) {
//                 System.out.print(arr[i][j] + " ");
//             }
//             System.out.println();
//         }
//     }

//     public static String lcs(String s1, String s2) {
//         int n = s1.length();
//         int m = s2.length();
//         int dp[][] = new int[n + 1][m + 1];
//         String dm[][] = new String[n][m];
//         for (int i = 0; i < n; i++) {
//             dp[i][0] = 0;
//             dm[i][0] = "0";
//         }
//         for (int i = 0; i < m; i++) {
//             dp[0][i] = 0;
//             dm[0][i] = "0";
//         }
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= m; j++) {
//                 if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                     dm[i - 1][j - 1] = "D";
//                 } else {
//                     if (dp[i - 1][j] > dp[i][j - 1]) {
//                         dp[i][j] = dp[i - 1][j];
//                         dm[i - 1][j - 1] = "U";
//                     } else {
//                         dp[i][j] = dp[i][j - 1];
//                         dm[i - 1][j - 1] = "L";
//                     }
//                 }
//             }
//         }

//         int len = dp[n][m];
//         if (len == 0) {
//             return "none";
//         }
//         int i = n, j = m;
//         int idx = len - 1;
//         String str = "";

//         while (i > 0 && j > 0) {
//             if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//                 str = s1.charAt(i - 1) + str;
//                 idx--;
//                 i--;
//                 j--;
//             } else if (dp[i - 1][j] > dp[i][j - 1]) {
//                 i--;

//             } else {
//                 j--;

//             }
//         }
//         printArray(dp);
//         printArray1(dm);
//         return str;
//     }

//     public static void main(String[] args) {
//         String s1 = "stone";
//         String s2 = "longest";
//         String fin = lcs(s1, s2);
//         System.out.println(fin + " " + fin.length());
//     }
// }
public class LCS {
    public static String lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        int len = dp[n][m];
        if (len == 0) {
            return "none";
        }
        int i = n, j = m;
        int idx = len - 1;
        String str = "";
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                str = s1.charAt(i - 1) + str;
                idx--;
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }
        return str;
    }

    public static void main(String[] args) {
        String s1 = "stone";
        String s2 = "longest";
        String fin = lcs(s1, s2);
        System.out.println(fin + " " + fin.length());
    }
}
