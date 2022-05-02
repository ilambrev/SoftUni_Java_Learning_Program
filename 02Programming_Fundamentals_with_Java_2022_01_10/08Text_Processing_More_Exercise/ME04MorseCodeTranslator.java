package ME08TextProcessing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ME04MorseCodeTranslator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String codes = "A .- B -... C -.-. D -.. E . F ..-. G --. H .... I .. J .--- K -.- L .-.. M -- N -. O --- P .--. Q --.- R .-. S ... T - U ..- V ...- W .-- X -..- Y -.-- Z --..";
        String[] decoder = codes.split("\\s");
        Map<String, String> morseDecoder = new LinkedHashMap<>();

        for (int i = 0; i < decoder.length; i += 2) {
            morseDecoder.put(decoder[i + 1], decoder[i]);
        }

        String[] input = scanner.nextLine().split("\\s");

        StringBuilder decodedText = new StringBuilder();

        for (String s : input) {
            if (s.equals("|")) {
                decodedText.append(" ");
            } else {
                if (morseDecoder.containsKey(s)) {
                    decodedText.append(morseDecoder.get(s));
                }
            }
        }

        System.out.println(decodedText);
    }
}