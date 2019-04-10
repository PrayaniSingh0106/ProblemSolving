package WePay;

public class ValidNum {
	public boolean isNumber(String s) {

		// String regex = "[-+]?[0-9]+(\\.[0-9]+)?([Ee][-+]?[0-9]+)?";
		boolean numberSeen = false;
		boolean eSeen = false;
		boolean decimalSeen = false;
		boolean numberAfterE = true;
		s = s.trim();

		for (int i = 0; i < s.length(); i++) {

			if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
				numberSeen = true;
				numberAfterE = true;
			} else if (s.charAt(i) == '.') {
				if (eSeen || decimalSeen)
					return false;
				decimalSeen = true;
			} else if (s.charAt(i) == 'e') {

				if (eSeen || !numberSeen)
					return false;

				eSeen = true;
				numberAfterE = false;
			}

			else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
				if (i != 0 && s.charAt(i - 1) != 'e')
					return false;

			} else
				return false;

		}

		return numberSeen && numberAfterE;
	}
}
