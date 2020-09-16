public static void main(String[] args){
        int n = 6;
        PrintStream out = System.out;
        int[][] array = new int[n][n];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                array[i][j] = sc.nextInt();
            }
        }
        int maxSum, sum;
        maxSum = -64;
        for(int i = 0; i < n-2; i++){
            for(int j = 0; j < n-2; j++){
                sum = 0;
                sum += array[i][j] + array[i][j+1] + array[i][j+2];
                sum += array[i+1][j+1];
                sum +=array [i+2][j] + array[i+2][j+1] + array[i+2][j+2];
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }
        out.println(maxSum);
    }
