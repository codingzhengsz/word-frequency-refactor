import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class WordFrequencyGame {
    public String getResult(String sentence) {
        List<Entry<String, Integer>> list = getInputListSortedByFrequency(sentence);

        return getStringFromInputList(list);
    }

    private List<Entry<String, Integer>> getInputListSortedByFrequency(String sentence) {
        Map<String, Integer> wordMap = getWordFrequencyMap(sentence);
        List<Entry<String, Integer>> list = new ArrayList<>(wordMap.entrySet());
        list.sort((w1, w2) -> w2.getValue() - w1.getValue());
        return list;
    }


    private String getStringFromInputList(List<Entry<String, Integer>> list) {
        return list.stream()
                .map(word -> String.format("%s %d", word.getKey(), word.getValue()))
                .collect(Collectors.joining("\n"));
    }

    private Map<String, Integer> getWordFrequencyMap(String sentence) {
        String[] words = sentence.split("\\s+");

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        return wordMap;
    }


}
