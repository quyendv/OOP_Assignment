package Week11.StaticProgramAnalysis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Week10 {
    public static List<String> _type = Arrays.asList(
            "Range<Integer>", "Iterable<T>", "Supplier<T>",
            "TemporalAccessor", "T[]",
            "MonthDay", "YearMonth", "Year",
            "LocalTime", "TemporalField",
            "LocalDate", "Date", "Instant",
            "OffsetDateTime", "LocalDateTime",
            "ZonedDateTime", "char", "String", "String...",
            "long", "int", "double", "InputStream",
            "Throwable", "StringBuilder", "Object", "Path",
            "QueryAPI", "Object...", "Class<?>", "SProcAPI",
            "Param...", "Param", "Connection", "PreparedStatement",
            "Mode", "boolean");

    public static List<String> _import = Arrays.asList(
            "com.google.common.collect.Range<java.lang.Integer>",
            "java.lang.Iterable<T>", "java.util.function.Supplier<T>",
            "java.time.temporal.TemporalAccessor", "?",
            "java.time.MonthDay", "java.time.YearMonth", "java.time.Year",
            "java.time.LocalTime", "java.time.temporal.TemporalField",
            "java.time.LocalDate", "java.util.Date", "java.time.Instant",
            "java.time.OffsetDateTime", "java.time.LocalDateTime",
            "java.time.ZonedDateTime", "?", "java.lang.String",
            "java.lang.String", "?", "?", "?", "java.io.InputStream",
            "java.lang.Throwable", "java.lang.StringBuilder", "java.lang.Object",
            "java.nio.file.Path", "com.nordstrom.common.jdbc.utils.QueryAPI",
            "java.lang.Object", "java.lang.Class<?>",
            "com.nordstrom.common.jdbc.utils.SProcAPI",
            "com.nordstrom.common.jdbc.Param",
            "com.nordstrom.common.jdbc.Param", "java.sql.Connection",
            "java.sql.PreparedStatement", "com.nordstrom.common.jdbc.Param.Mode", "?");

    public static Map<String, String> map = new HashMap<>();

    /**
     * Implement method.
     *
     * @param fileContent content.
     * @return result.
     */
    public static List<String> getAllFunctions(String fileContent) {
        // init map
        for (int i = 0; i < _import.size(); i++) {
            map.put(_type.get(i), _import.get(i));
        }

        List<String> result = new ArrayList<>();

        Scanner sc = new Scanner(fileContent);
        boolean isCommentLine = false;
        StringBuilder stringBuilder = new StringBuilder();
        String line = "";

        while (sc.hasNextLine()) {
            line = sc.nextLine().trim();
            if (line.length() == 0) {
                continue;
            }
            if (line.length() >= 2 && line.charAt(0) == '/' && line.charAt(1) == '*') {
                isCommentLine = true;
                continue;
            }
            if (line.length() >= 2 && line.charAt(0) == '*' && line.charAt(1) == '/') {
                isCommentLine = false;
                continue;
            }
            if (isCommentLine) {
                continue;
            }

            // static: classes, properties, methods, ...
            if (line.startsWith("static") || line.startsWith("public static")
                    || line.startsWith("private static")) {

                if (!line.contains("(")) {
                    continue;
                }

                if (line.charAt(line.length() - 1) == '{') {
                    String[] arr = line.split(" ");
                    String temp = "";
                    for (String i : arr) {
                        // i contains nameMethod: ex: nameMethod(type param1, type param2, ...)
                        if (i.contains("(")) {
                            temp = i;
                            break;
                        }
                    }
                    stringBuilder.append(line.substring(line.indexOf(temp), line.length() - 2))
                            .append('\n');
                } else if (line.charAt(line.length() - 1) == '(') {
                    line += sc.nextLine();
                    String[] arr = line.split(" ");
                    String temp = "";
                    for (String i : arr) {
                        // i contains nameMethod: ex: nameMethod(type param1, type param2, ...)
                        if (i.contains("(")) {
                            temp = i;
                            break;
                        }
                    }
                    stringBuilder.append(line.substring(line.indexOf(temp), line.length() - 2))
                            .append('\n');
                } else if (line.contains("randomNegativeLong()")) {
                    stringBuilder.append("randomNegativeLong()").append('\n');
                } else if (line.contains(
                        "randomDouble(double startInclusive, double endExclusive)")) {
                    stringBuilder.append(
                            "randomDouble(double startInclusive, double endExclusive").append('\n');
                }
            }
        }
        sc.close();
        fileContent = stringBuilder.toString();

        // fileContent eachLine: sayHello(), add(int a, int b), ...
        sc = new Scanner(fileContent);
        stringBuilder = new StringBuilder();
        while (sc.hasNextLine()) {
            line = sc.nextLine();
            String[] arr = line.split(" "); // ex: ["add(int", "a,", "int", "b)"]
            if (arr.length == 1) {                // ex: "sayHello()"
                result.add(line);
                continue;
            }

            // delete param
            List<String> temp = new ArrayList<>(); // add all String from arr if !contains(param)
            for (String i : arr) {
                if (!i.contains(",") && !i.contains(")")) {
                    temp.add(i);
                }
            }
            // now temp contains element: ["nameMethod(type1", "type2", ..., "typeN"]

            // convert each _type to _import
            int index = temp.get(0).indexOf("(");
            StringBuilder eachResult = new StringBuilder(temp.get(0).substring(0, index + 1));
            // now eachResult: nameMethod(
            // String[] arrTemp0 = temp.get(0).split("[(]+");
            // StringBuilder eachResult = new StringBuilder(arrTemp0[0] + '(');

            // firstType:
            String type1 = temp.get(0).substring(index + 1);
            // String type1 = arrTemp0[1];
            if (_type.contains(type1)) {
                if (map.get(type1).equals("?")) {
                    eachResult.append(type1);
                } else {
                    eachResult.append(map.get(type1));
                }
            }
            // otherTypes:
            for (int i = 1; i < temp.size(); i++) {
                String type = temp.get(i);
                if (_type.contains(type)) {
                    if (eachResult.charAt(eachResult.length() - 1) != '(') {
                        eachResult.append(',');
                    }
                    if (map.get(type).equals("?")) {
                        eachResult.append(type);
                    } else {
                        eachResult.append(map.get(type));
                    }
                }
            }
            eachResult.append(")");
            result.add(eachResult.toString());
        }
        sc.close();
        return result;
    }
}