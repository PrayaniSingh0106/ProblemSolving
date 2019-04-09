package WePay;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {

		int left = 0;
		List<String> result = new ArrayList<>();

		while (left < words.length) {
			int right = findRight(left, words, maxWidth);
			result.add(justify(left, right, words, maxWidth));
			left = right + 1;
		}

		return result;
	}

	private int findRight(int left, String[] words, int maxWidth) {
		int right = left;
		int sum = words[right++].length();

		// while words fit in the line:
		// while we don't exhaust all the words of word array && the sum of words don't
		// exceed maximum line width
		while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
			sum += 1 + words[right++].length();

		// subtracting the extra space at the end
		return right - 1;
	}

	private String justify(int left, int right, String[] words, int maxWidth) {
		if (right - left == 0)
			return padResult(words[left], maxWidth);

		boolean isLastLine = right == words.length - 1;
		int numSpaces = right - left;
		int totalSpace = maxWidth - wordsLength(left, right, words);

		// Calculate equal amount of space that is left and has to be divided
		String space = isLastLine ? " " : blank(totalSpace / numSpaces);

		// if the space can't be divided evenly, pad the extra space towards the left
		// according to the question
		int remainder = isLastLine ? 0 : totalSpace % numSpaces;

		StringBuilder result = new StringBuilder();
		for (int i = left; i <= right; i++)
			result.append(words[i]).append(space).append(remainder-- > 0 ? " " : "");

		return padResult(result.toString().trim(), maxWidth);
	}

	private int wordsLength(int left, int right, String[] words) {
		int wordsLength = 0;
		for (int i = left; i <= right; i++)
			wordsLength += words[i].length();
		return wordsLength;
	}

	private String padResult(String result, int maxWidth) {
		return result + blank(maxWidth - result.length());
	}

	private String blank(int length) {
		return new String(new char[length]).replace('\0', ' ');
	}
}
