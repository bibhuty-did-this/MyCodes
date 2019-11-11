package Java.ReadingExternalFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ExternalFileReading {
    public static void main(String[] args) throws IOException {
        String filePath="/home/vedantu/Documents/Docs/Topic Tree/docs/all.txt";
        File file=new File(filePath);
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));

        Map<String,Set<String>> subjectProblemMap=new HashMap<>();
        String line;
        while((line=bufferedReader.readLine())!=null){
            String[] strings = line.split("\\$");
            Set<String> requiredSet =
                    Arrays.stream(strings)
                            .filter(ExternalFileReading::isRequiredString)
                            .map(String::trim)
                            .collect(Collectors.toSet());
            if(!requiredSet.isEmpty()){
                if(subjectProblemMap.containsKey(strings[0])){
                    subjectProblemMap.get(strings[0]).addAll(requiredSet);
                }else{
                    subjectProblemMap.put(strings[0],requiredSet);
                }
            }
        }
        subjectProblemMap
                .keySet()
                .stream()
                .peek(ExternalFileReading::printSubjectTitle)
                .map(subjectProblemMap::get)
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }

    private static void printSubjectTitle(String key) {
        System.out.println("\n-----"+key.toUpperCase()+"-----");
    }

    private static boolean isRequiredString(String string) {
        return string.contains("’") || string.contains("“") || string.contains("”") || string.contains("‘");
    }
}