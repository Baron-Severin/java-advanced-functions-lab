import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by erikrudie on 6/28/16.
 */
public class AdvancedFunctions {

    public static void main (String [] args) {


        // tests
        isThisEven(2);
        isThisEven(5);
        isThisEven(-1);
        isThisEven(-6);

        isSpellingTheSame("Here's a phrase", "here's a phrase");
        isSpellingTheSame("Is this even", "the same phrase?");

        iHateWs("heyo");
        iHateWs("this has a word with w in it w");

        randomNumber();
        randomNumber();
        randomNumber();
        randomNumber();


        dayMonthYear(31, 10, 2010);
        dayMonthYear(29, 3, 5);
        dayMonthYear(30, 8, 700123);
        dayMonthYear(30, 11, 2016);
        dayMonthYear(31, 12, 2020);
        dayMonthYear(35, 2, 2016);
        dayMonthYear(0, 5, 2010);

        alternatingWord("my word");
        alternatingWord("onamatapeamispelled");

        printNumbers(8);
        printNumbers(3);
        printNumbers(15);

        sumNums(2, 6);
        sumNums(6000, 12);
        sumNums(0, 0);

        countries("De");
        countries("hU");
        countries("BEL");

        // cases exist for vowel, consonant, multiple characters, and non-letters
        typeInNumber();
        typeInNumber();
        typeInNumber();
        typeInNumber();

    }

    private static boolean isThisEven (int number) {

        boolean tempBool = ((number % 2) == 0);
        System.out.println(tempBool);
        return tempBool;

    }

    private static boolean isSpellingTheSame (String firstWord, String secondWord) {

        boolean tempBool = (firstWord.toLowerCase().equals(secondWord.toLowerCase()));
        System.out.println(tempBool);
        return tempBool;

    }

    private static void iHateWs (String word) {

        for (int i = 0; i < word.length(); i++) {

            if (word.toLowerCase().charAt(i) != 'w'){
                System.out.println(word.charAt(i));
            } else {
                break;
            }

        }

    }

    private static double randomNumber () {

        double randomNum = Math.random()*100;

        if (randomNum > 50) {
            System.out.println(randomNum);
            return randomNum;
        } else {
            System.out.println(-1);
            return -1;
        }

    }

    private static String dayMonthYear (int day, int month, int year) {

        day += 1;

        switch (day) {

            case 32: day = 1;
                if (month == 12) {
                    year += 1;
                    month = 1;
                } else {
                    month += 1;
                }
                break;
            case 31:
                if (month == 4 || month == 6 || month == 9 || month == 11) {
                    day = 1;
                    month += 1;
                }
                break;
            case 30:
                if (month == 2 && ((2016 - year) % 4) == 0) {
                    day = 1;
                    month +=1;
                }
                break;
            case 29:
                if (month == 2 && ((2016 - year) % 4) != 0) {
                    day = 1;
                    month +=1;
                }
                break;
            case 1-28:
                break;
            default:
                System.out.println("Invalid date selected");


        }

        String dateString = "Day: " + day + ", Month: " + month + ", Year: " + year;
        System.out.println(dateString);
        return(dateString);

    }

    private static String alternatingWord (String inputWord) {

        String outputWord = "";

        for (int i = 0; i < inputWord.length(); i++) {
            if ((i % 2) == 0 ) {

                outputWord += inputWord.charAt(i);

            }
        }

        System.out.println(outputWord);
        return(outputWord);

    }

    private static void printNumbers (int number) {
        if (number > 5) {

            int countUp = 1;

            while (countUp < number) {

                if (countUp != 4) {

                    System.out.println(countUp);

                }

                countUp++;

            }

        }
    }

    private static int sumNums (int first, int second) {

        if (first == second) {
            int answer = (first + second + 4);
            System.out.println(answer);
            return(answer);
        } else {
            int answer = (first + second + 2);
            System.out.println(answer);
            return (answer);
        }

    }

    private static String countries (String countryCode) {

        countryCode = countryCode.toLowerCase();
        String answer = "";
        System.out.println(countryCode);

        switch (countryCode) {

            case "us": answer = "United States";
                break;

            case "de": answer = "Germany";
                break;

            case "hu": answer = "Hungary";
                break;

            default: answer = "Unknown";
                break;

        }

        System.out.println(answer);
        return(answer);

    }

    public static void typeInNumber() {

        System.out.println("Please type in a single letter: ");
        Scanner userInput = new Scanner(System.in);
        String inputText = userInput.next();

        String[] vowels = {"a", "e", "i", "o", "u", "y"};
        String[] consonants = {"b", "c", "d", "f", "g", "h", "j", "k", "l", "m", "n", "p", "q", "r", "s", "t", "v", "w", "x", "z"};

        if (inputText.length() > 1) {
            System.out.println("ONE character, please.");
            typeInNumber();
        } else {
            boolean vowelOrCon = false;
            for (int i = 0; i < vowels.length; i++) {
                if (vowels[i].equals(inputText.toLowerCase())){
                    System.out.println("This was a vowel!");
                    vowelOrCon = true;
                    break;
                }
            }
            if (!vowelOrCon) {
                for (int i = 0; i < consonants.length; i++) {
                    if (consonants[i].equals(inputText.toLowerCase())) {
                        System.out.println("This was a consonant!");
                        vowelOrCon = true;
                        break;
                    }
                }
            }
            if (!vowelOrCon) {
                System.out.println("That... that wasn't even a letter.");
                typeInNumber();
            }
        }
    }

}
