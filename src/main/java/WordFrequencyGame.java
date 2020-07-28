import java.util.Arrays;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String inputStr) {
        return Arrays.stream(inputStr.split("\\s+")).
                collect(Collectors.toMap(s -> s, s -> 1, Integer::sum))
                .entrySet().stream().sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .map(e -> e.getKey() + " " + e.getValue()).collect(Collectors.joining("\n"));
    }


}
