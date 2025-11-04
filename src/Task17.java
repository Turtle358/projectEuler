public class Task17 {
    static int length = 0;
    public static int convertToWordAndCalculateLength() {
        for(int i = 0; i < 1000; i++){
            String wordformNumber = NumberToWords.convertToWord(i+1);
            wordformNumber = removeFormating(wordformNumber);
            length +=  calculateLetters(wordformNumber);
        }
        return length;
    }

    private static int calculateLetters(String word) {
        return word.length();
    }
    private static String removeFormating(String word) {
        return word.replaceAll("[ -]", "");
    }
}

class NumberToWords {

    private static final String[] units = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen"
    };

    private static final String[] tens = {
            "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public static String convertToWord(int number) {
        if (number == 0) {
            return "Zero";
        }

        StringBuilder words = new StringBuilder();

        if ((number / 1000) > 0) {
            words.append(units[number / 1000]).append(" Thousand"); // "One Thousand"
            number %= 1000;
        }

        if ((number / 100) > 0) {
            // Hundreds part
            words.append(units[number / 100]).append(" Hundred");
            number %= 100;
            if (number > 0) {
                words.append(" and ");
            }
        }

        if (number > 0) {
            if (number < 20) {
                words.append(units[number]);
            } else {
                words.append(tens[number / 10]);
                number %= 10;
                if (number > 0) {
                    words.append("-").append(units[number]);
                }
            }
        }
        return words.toString().trim();
    }
}
