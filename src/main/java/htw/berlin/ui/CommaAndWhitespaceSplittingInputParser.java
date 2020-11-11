package htw.berlin.ui;

import htw.berlin.ui.InputParser;

import java.util.*;
import java.util.stream.Collectors;

public class CommaAndWhitespaceSplittingInputParser implements InputParser {

    @Override
        public Map<String, Integer> countKeywords(String line, Set<String> keywords) {
            // TODO (1) zuerst hier implementieren.
        HashMap<String,Integer> keywordsCounted = new HashMap<>();
        for (String inputKeywords : keywords){
            if (line.contains(inputKeywords)) {
                String[] lineSplit = line.split(" ");
                int inputLength = lineSplit.length;
//if keyword is included in input, value = 1, else 0
                keywordsCounted.put(inputKeywords, 1);
            }else{
                keywordsCounted.put(inputKeywords, 0);
            }
        }
        return keywordsCounted;
    }
    }
