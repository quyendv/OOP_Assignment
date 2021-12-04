package Week12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Week10_From_Github {
    public static List<String> simp = Arrays.asList(
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
    public static List<String> comp = Arrays.asList(
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
    public static HashMap<String, String> map = new HashMap<String, String>();

//    public static Map<String, String> map = new HashMap<>() {{
//        for (int i = 0; i < _import.size(); i++) put(_type.get(i), _import.get(i));
//    }};

    /**
     * get function.
     * @param fileContent is a string
     * @return list string
     */
    public static List<String> getAllFunctions(String fileContent) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < simp.size(); ++i) {
            map.put(simp.get(i), comp.get(i));
        }

        // xoa comment
        boolean comment = false;
        Scanner sc1 = new Scanner(fileContent);
        while (sc1.hasNextLine()) {
            String line = sc1.nextLine();
            line = line.trim();
            if (line.length() == 0 || line.charAt(0) == '/' || line.charAt(0) == '*') {
                if (line.length() >= 2 && line.charAt(0) == '/' && line.charAt(1) == '*') {
                    comment = true;
                }
                if (line.length() >= 2 && line.charAt(0) == '*' && line.charAt(1) == '/') {
                    comment = false;
                }
                continue;
            }
            if (!comment) {
                sb.append(line + "\n");
            }
        }
        sc1.close();
        fileContent = sb.toString();

        // Processing line by line.0
        sb.setLength(0);
        Scanner sc2 = new Scanner(fileContent);
        while (sc2.hasNextLine()) {
            String line = sc2.nextLine();
            if (line.startsWith("private static")
                    || line.startsWith("public static")
                    || line.startsWith(("static"))) {       // if: dong chua ten ham/class static
                if (line.contains("(")) {
                    if (line.charAt(line.length() - 1) == '{') {    // function or class or property
                        List<String> pr = new ArrayList<String>(Arrays.asList(line.split(" ")));  // why convert to List ??
                        String tup = "?????";
                        for (String i : pr) {
                            if (i.contains("(")) {      // verify is a function. find nameMethod(..., ...)  || nameMethod()
                                tup = i;                // ex: nameMethod(...
                            }
                        }
                        tup = line.substring(line.indexOf(tup), line.length() - 2);
                        sb.append(tup).append("\n");
                    } else if (line.charAt(line.length() - 1) == '(') {
                        line = line + sc2.nextLine();
                        List<String> pr = new ArrayList<String>(Arrays.asList(line.split(" ")));
                        String tup = "?????";
                        for (String i : pr) {
                            if (i.contains("(")) {
                                tup = i;
                            }
                        }
                        tup = line.substring(line.indexOf(tup), line.length() - 2);
                        sb.append(tup).append("\n");
                    } else if (line.contains(
                            "randomDouble(double startInclusive, double endExclusive)")) {
                        sb.append("randomDouble(double startInclusive, double endExclusive)\n");
                    } else if (line.contains("randomNegativeLong()")) {
                        sb.append("randomNegativeLong()\n");
                    }
                }
            }
        }
        sc2.close();
        fileContent = sb.toString();
        sb.setLength(0);

        // Processing Parameter.
        List<String> res = new ArrayList<String>();
        Scanner sc3 = new Scanner((fileContent));
        while (sc3.hasNextLine()) {
            String line = sc3.nextLine();
            List<String> pr = new ArrayList<String>(Arrays.asList(line.split(" ")));
            if (pr.size() == 1) {   // ex: sayHello() <no param>
                res.add(line);
                continue;
            }
            // Remove name of Param. ex: add(int a, int b)
            List<String> prr = new ArrayList<String>();
            for (String str : pr) {
                if (str.contains(",") || str.contains(")")) {
                    continue;
                }
                prr.add(str);   // -> ["add(int", "int", "int"]
            }
            // Head Process.
            List<String> prrr = new ArrayList<String>(Arrays.asList(prr.get(0).split("\\(")));  // "add", "("
            String rs = prrr.get(0) + "(";
            if (simp.contains(prrr.get(1))) {
                if (!map.get(prrr.get(1)).equals("?")) {
                    rs = rs + map.get(prrr.get(1));
                } else {
                    rs = rs + prrr.get(1);
                }
            }
            // Body Process.
            for (int i = 1; i < prr.size(); ++i) {
                if (simp.contains(prr.get(i))) {
                    rs = rs + ",";
                    if (!map.get(prr.get(i)).equals("?")) {
                        rs = rs + map.get(prr.get(i));
                    } else {
                        rs = rs + prr.get(i);
                    }
                }
            }
            rs = rs + ")";
            res.add(rs);
        }
        sc3.close();
        return res;
    }

    public static void main(String[] args) {
        List<String> res = getAllFunctions("package com.nordstrom.common.params;\n" +
                "\n" +
                "import java.util.Collections;\n" +
                "import java.util.HashMap;\n" +
                "import java.util.Map;\n" +
                "\n" +
                "import com.google.common.base.Optional;\n" +
                "\n" +
                "/**\n" +
                " * This interface enables implementers to provide methods to support for concisely-defined parameters.\n" +
                " */\n" +
                "public interface Params {\n" +
                "    \n" +
                "    /**\n" +
                "     * Get the defined parameters.\n" +
                "     * \n" +
                "     * @return optional map of named parameters\n" +
                "     */\n" +
                "    Optional<Map<String, Object>> getParameters();\n" +
                "    \n" +
                "    /**\n" +
                "     * This class defines a parameter object.\n" +
                "     */\n" +
                "    static class Param {\n" +
                "        \n" +
                "        private final String key;\n" +
                "        private final Object val;\n" +
                "        \n" +
                "        /**\n" +
                "         * Constructor for parameter object.\n" +
                "         * \n" +
                "         * @param key parameter key\n" +
                "         * @param val parameter value\n" +
                "         */\n" +
                "        public Param(String key, Object val) {\n" +
                "            if ((key == null) || key.isEmpty()) {\n" +
                "                throw new IllegalArgumentException(\"[key] must be a non-empty string\");\n" +
                "            }\n" +
                "            this.key = key;\n" +
                "            this.val = val;\n" +
                "        }\n" +
                "        \n" +
                "        /**\n" +
                "         * Get key of this parameter.\n" +
                "         * \n" +
                "         * @return parameter key\n" +
                "         */\n" +
                "        public String getKey() {\n" +
                "            return key;\n" +
                "        }\n" +
                "        \n" +
                "        /**\n" +
                "         * Get value of this parameter.\n" +
                "         * \n" +
                "         * @return parameter value\n" +
                "         */\n" +
                "        public Object getVal() {\n" +
                "            return val;\n" +
                "        }\n" +
                "        \n" +
                "        /**\n" +
                "         * Assemble a map of parameters.\n" +
                "         * \n" +
                "         * @param params array of {@link Param} objects; may be {@code null} or empty\n" +
                "         * @return optional map of parameters (may be empty)\n" +
                "         */\n" +
                "        public static Optional<Map<String, Object>> mapOf(Param... params) {\n" +
                "            if ((params == null) || (params.length == 0)) {\n" +
                "                return Optional.absent();\n" +
                "            }\n" +
                "            Map<String, Object> paramMap = new HashMap<>();\n" +
                "            for (Param param : params) {\n" +
                "                paramMap.put(param.key, param.val);\n" +
                "            }\n" +
                "            return Optional.of(Collections.unmodifiableMap(paramMap));\n" +
                "        }\n" +
                "        \n" +
                "        /**\n" +
                "         * Create a parameter object for the specified key/value pair.\n" +
                "         * \n" +
                "         * @param key parameter key (name)\n" +
                "         * @param val parameter value\n" +
                "         * @return parameter object\n" +
                "         */\n" +
                "        public static Param param(String key, Object val) {\n" +
                "            return new Param(key, val);\n" +
                "        }\n" +
                "    }\n" +
                "}");
        System.out.println(res);
    }
}