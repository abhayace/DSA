package recursioin;

import java.util.ArrayList;
import java.util.List;

public class RecursionProblems {

    public List<String> stringPermutations (String baseString){
        return stringPermutationsIterative(baseString);
    }

    private List<String> stringPermutationsIterative(String baseString) {
        if(baseString.length() == 0) {
            return new ArrayList<>();
        }
        List<String> combinations = new ArrayList<>();
        combinations.add("");
        for(char c: baseString.toCharArray()){
            List<String> newCombinations = new ArrayList<>();
            for (String str: combinations){
                newCombinations.add(str + c);
                for(int j=0; j<str.length(); j++)
                    newCombinations.add(str.substring(0,j)+c+str.substring(j));
            }
            combinations = newCombinations;
        }
        return  combinations;
    }

    public List<List<String>> getAllSubsets(List<String> coll) {

        List<List<String>> baseSet= new ArrayList<>();
        baseSet.add(new ArrayList<>());

        return getSubsetsRecursive(coll, 0, baseSet);
    }

    private List<List<String>> getSubsetsRecursive (List<String> coll, int recursionLevel, List<List<String>> subsets) {
        if (recursionLevel == coll.size())
            return subsets;
        List<List<String>> allcombinations = new ArrayList<>();
        for (List<String> subset: subsets){
            List<String> combination = new ArrayList<>();
            combination.addAll(subset);
            combination.add(coll.get(recursionLevel));
            allcombinations.add(combination);
        }
        subsets.addAll(allcombinations);
        return getSubsetsRecursive(coll, recursionLevel+1, subsets);
    }

}
