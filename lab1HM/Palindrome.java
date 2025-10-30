public class Palindrome {
    public static void main(String [] args){
        for(int i = 0; i < args.length; i++){
            String s = args[i];
            if (isPalindrome(s)){
                System.out.println(s+" - палиндром");
            }
            else{
                System.out.println(s+" - не палиндром");
            }
        }
    }
    //public static String reverseString(String s){
      //  String reverse = "";
        //for(int i= s.length() - 1; i>=0; i--){
          //  reverse +=s.charAt(i);
        //}
        //return reverse;
    //}
    public static String reverseString(String s) {
    String reverse = "";
    for (int i = 0; i < s.length(); i++) {
        reverse = s.charAt(i) + reverse;
    }
    return reverse;
}
    public static boolean isPalindrome(String s){
        String reverse = reverseString(s);
        return s.equals(reverse);
    }
}