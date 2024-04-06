package com.smirnov.project.courseproject2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class FileQuestNotMapa {

    private final String separator = File.separator;
    private final String patchToFileQuest = "C:" + separator + "Java_Education" + separator + "ITMO" + separator + "Lessons" + separator + "src" + separator +
            "com" + separator + "smirnov" + separator + "project" + separator + "courseproject2" + separator + "текст-параграфов.md";
    private final File fileQuest = new File(patchToFileQuest);

    private final Scanner scanner;

    {
        try {
            scanner = new Scanner(fileQuest);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    void execute(String string) throws FileNotFoundException {
        int userInput;
        Scanner scanner1 = new Scanner(fileQuest);
        Scanner scannerInput = new Scanner(System.in);
        boolean sout = false;
        String line;
        List<String> answers = new ArrayList<>();
        while (scanner1.hasNextLine()) {
            line = scanner1.nextLine();
            if (sout) {
                if (line.contains("#")) {
                    scanner1.close();
                    if (!answers.isEmpty()) {
                        userInput = scannerInput.nextInt();
                        execute(answers.get(userInput - 1));
                    }
                    break;
                }
                out.println(line);
                if (!line.isBlank() && (line.substring(0, 1).equals("1") || line.substring(0, 1).equals("2"))) {
                    answers.add(line);
                }
            }
            if (line.contains("#") && string.contains(line.replace("#", "").trim())) {
                sout = true;
            }
        }
    }
}
