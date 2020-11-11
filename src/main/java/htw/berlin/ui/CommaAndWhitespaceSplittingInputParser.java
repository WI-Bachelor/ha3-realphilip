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
                int mainCounter = 0;
                for (int i = 0; i < inputLength; i++) {
                    if (lineSplit[i].contains(inputKeywords)) mainCounter++;
                }
//if keyword is included once in input, value = 1, if keyword is included multiple times, value = # of times mentioned, else value = 0
                if(mainCounter == 1){
                    keywordsCounted.put(inputKeywords, 1);
                } else {
                    keywordsCounted.put(inputKeywords, mainCounter);
                }
            }else{
                keywordsCounted.put(inputKeywords, 0);
            }
        }
        return keywordsCounted;
    }
    }
