package hw14.HardTasks;

import java.util.*;

public class Hard {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> newWords = new ArrayList<String>();
        Set<String> set = new HashSet<>();
        for(int i = 0; i < words.length; ++i){
            for(int j = 0; i < words.length; ++j){
                if ( words[j].contains(words[i]) & !Objects.equals(words[j], words[i].concat("s")) & !Objects.equals(words[i], words[j].concat("s"))){
                    set.add(words[j]);
                }
            }
        }
        newWords.addAll(set);
        return newWords;
    }
}
