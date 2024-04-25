import java.util.Arrays;

 //print the lexicographically smallest string of length N consisting of lower-case English alphabets
 // such that the sum of the characters of the string equals K
 // where ‘a’ = 1, ‘b’ = 2, ‘c’ = 3, ….. and ‘z’ = 26.
public class SmallestStringWithGivenNumberValue {

    //O/P WRONG CORRECT PROGRAM

    public static void main(String args[]){
        int n=5, sum=42;
        //1+1+21 = 23
        //1+ 3+ 26 = 30

        char[] arr=new char[n];
        Arrays.fill(arr,'a');
        sum=sum-(n); //n-1 because eg for n=5 there will be 4 char
        for(int i=n-1;i>=0;i--){ //iterate from last element
            if(sum>=26){
                arr[i]='z';
            }else{
                //System.out.println('z'-'a'); return diff in ascii value in int
                //ascii of a is 97
                int i1 = (sum+96)+1;
                arr[i]=(char) i1;
            System.out.println(i1);
            }
            sum=sum-(arr[i]-96);
            if(sum<=0){
                break;
            }
        }

        System.out.println(arr);
    }
}
