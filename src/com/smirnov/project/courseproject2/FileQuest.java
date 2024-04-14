package com.smirnov.project.courseproject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Создает квест из файла.
 */
public class FileQuest {

    private final String separator = File.separator;
    /**
     * Путь к текстовому квесту.
     */
    private final String patchToFileQuest = "C:%sJava_Education%sITMO%sLessons%ssrc%scom%ssmirnov%sproject%scourseproject2%sтекст-параграфов.md".formatted(separator, separator, separator, separator, separator, separator, separator, separator, separator);

    private final String patchToSave = "C:%sJava_Education%sITMO%sLessons%ssrc%scom%ssmirnov%sproject%scourseproject2%sProgress.md".formatted(separator, separator, separator, separator, separator, separator, separator, separator, separator);
    private final File fileQuest = new File(patchToFileQuest);
    private final File file = new File(patchToFileQuest);

    private final Scanner scanner;

    {
        try {
            scanner = new Scanner(fileQuest);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Map заголовков и текстов, где ключи - заголовки квестов.
     */

    private final Map<String, List<String>> mapText = new LinkedHashMap<>();

    FileQuest() throws FileNotFoundException {
        String returnMenu="Вернуться в меню";
        String line;
        String heading = "";
        StringBuilder newstring = new StringBuilder();
        List<String> answerList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            line = scanner.nextLine();
            if (line.contains("#")){
                if (!newstring.isEmpty()){
                    mapText.put(heading, new ArrayList<>());
                    mapText.get(heading).add(newstring.toString());
                    for (String answer : answerList){
                        mapText.get(heading).add(answer);
                    }
                    mapText.get(heading).add("3. Выйти в главное меню.");
                    answerList.clear();
                    newstring = new StringBuilder();
                }
                heading = line.replace("#", "").trim();
            } else{
                newstring.append(line);
                if (!line.isBlank() && (line.charAt(0) == '1' || line.charAt(0) == '2')) {
                    answerList.add(line);
                }
            }
        }
        mapText.put(heading, new ArrayList<>());
        mapText.get(heading).add(newstring.toString());
        for (String answer : answerList){
            mapText.get(heading).add(answer);
        }
    }

    private FileQuest buildFileQuest(){

        return this;
    }

    public Map<String, List<String>> getMapText() {
        return mapText;
    }
}
