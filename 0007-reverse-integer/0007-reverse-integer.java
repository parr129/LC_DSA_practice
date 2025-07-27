class Solution {
  public static int reverse(int x) {
    int reversed = 0;

    while (x != 0) {
      int digit = x % 10; // Extract last digit
      x /= 10; // Remove last digit

      // Check overflow before multiplying by 10
      if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
      if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && digit < -8)) return 0;

      reversed = reversed * 10 + digit; // Append digit
    }
    
    return reversed;
  }

  public static void main(String[] args) {
    System.out.println(reverse(123));   // Output: 321
    System.out.println(reverse(-123));  // Output: -321
    System.out.println(reverse(120));   // Output: 21
    System.out.println(reverse(0));     // Output: 0
  }
}
