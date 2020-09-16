static int countingValleys(int n, String s) {
        char[] listChars = new char[n];
        listChars = s.toCharArray();
        int level  = 0; 
        int count = 0;
        for(char a: listChars){
            System.out.println(a);
            if(a == 'U'){
                level++;
            } else if(a == 'D'){
                if(level == 0){
                    count++;
                }
                level--;
            }
        }

        System.out.println(count);
        return count;
    }

