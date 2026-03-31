public class CreditCardValidator {

    public static boolean isValidCard(String cardNumber) {

        String regex = "^(4|5)\\d{15}$";
        return cardNumber.matches(regex);
    }

    public static void main(String[] args) {

        String[] cards = { "4123456789012345", "5123456789012345", "6123456789012345", "412345678901234",
                "4A23456789012345" };

        for (String card : cards) {
            System.out.println(card + " → " + isValidCard(card));
        }
    }
}
