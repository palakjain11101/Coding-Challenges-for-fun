static long repeatedString(String s, long n){
        long num = n/s.length();
        long rem = n%s.length();
        long ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a'){
                ans += num;
                if(i < rem){
                    ans = ans + 1;
                }
            }   
        }
        return ans;
    }
