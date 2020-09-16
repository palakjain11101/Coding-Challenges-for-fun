static int jumpingOnClouds(int[] ar) {
        int count = 0;
        int i = 0;
        int rounds = ar.length;
        while(i != rounds - 1){
            if(i != ar.length - 2 && ar[i+2] == 0){
                i+=2;
            } else{
                i++;
            }
            count++;
        }
        System.out.println(count);
        return count;
}
