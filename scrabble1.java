import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class scrabble1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the quantity of strings
        int n = scanner.nextInt();
        
        scanner.nextLine(); // Consume the newline
        

        // Read the words into an array
        String[] words = new String[n];
        //Reads each word from the user and stores it in the array words
        for (int i = 0; i < n; i++) {
            System.out.print("Enter word #" + (i + 1) + ": ");
            words[i] = scanner.nextLine();
            
        }
        scanner.close();

        /// Splits words if they are on the same line using whitespace as a delimiter and stores them in splitWords array.
        
        //Arrays.stream(words): This converts the array words (which contains the words entered by the user) into a stream of strings.
        String[] splitWords = Arrays.stream(words)
        
        // flatMap  to transform each word into a stream of sub-words

        
        //word.split("\\s+"): This method splits the word into an array of sub-words using regular expression \\s+, where \\s represents a whitespace character, and + means one or more occurrences. This allows for splitting the words even if they are entered on the same line with spaces in between
                .flatMap(word -> Arrays.stream(word.split("\\s+")))
                .toArray(String[]::new);

        // Sort the words based on Scrabble scores and alphabetical order
        //.toArray(String[]::new) his collects the elements of the stream into a new array of strings. The method reference String[]::new is used as the array constructor to create a new array of the appropriate type.
        Arrays.sort(splitWords, Comparator.comparing(scrabble1::getScrabbleScore).thenComparing(String::compareTo));

        // Output the sorted words
        System.out.println("\nSorted words:");
        for (String word : splitWords) {
            System.out.println(word);
        }
    }
//calculates the Scrabble score for a given word
    private static int getScrabbleScore(String word) {
        int score = 0;
        
        //word.toUpperCase(): Converts the entire word to uppercase. This is done to ensure that the scoring is case-insensitive, as Scrabble scores are typically not affected by the case of the letters.
        //toCharArray(): Converts the string into an array of character allowing iteration over each individual letter.
    //  for (char letter : ...) his enhanced for loop iterates over each letter in the array.
        for (char letter : word.toUpperCase().toCharArray()) {
            
            //the score is increased by the value returned by the getLetterScore method for the current letter.
            //returns the Scrabble score for the given letter.score +=  the score for the current letter into the total score
            score += getLetterScore(letter);
        }
        return score;
    }
// If the letter matches a case, the corresponding score is returned immediately, and the switch statement exits.
    private static int getLetterScore(char letter) {
        switch (letter) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'L':
            case 'N':
            case 'S':
            case 'T':
                return 1;
            case 'D':
            case 'G':
                return 2;
            case 'B':
            case 'C':
            case 'M':
            case 'P':
                return 3;
            case 'F':
            case 'H':
            case 'V':
            case 'W':
            case 'Y':
                return 4;
            case 'K':
                return 5;
            case 'J':
            case 'X':
                return 8;
            case 'Q':
            case 'Z':
                return 10;
            default:
                return 0;
                // Handle other characters (not in Scrabble letters)
                 
        }
    }
}