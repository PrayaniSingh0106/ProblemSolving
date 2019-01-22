package leetCode;

public class ReverseDigit {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseDigit s = new ReverseDigit();
		System.out.println("Result is : " + s.reverse(2147483641));
	}

	public int reverse(int x) {
		long rev = 0;
		int y = x;
		int rem = 0;

		if (x <= Integer.MAX_VALUE && x >= Integer.MIN_VALUE) {

			while (y != 0) {
				rem = y % 10;

				rev = rev * 10 + rem;
				y = y / 10;

				if (y != 0)
					if (rev * 10 + y % 10 < Integer.MAX_VALUE && rev * 10 + y % 10 > Integer.MIN_VALUE)
						continue;

					else {
						rev = 0;
						break;
					}

			}
		}

		else
			return 0;

		return (int) rev;
	}
	
	/*
	  int rev = 0;
      while (x != 0) {
          int pop = x % 10;
          x /= 10;
          if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
          if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
          rev = rev * 10 + pop;
      }
      return rev;*/
}
