import java.util.HashMap;

public class CodeTest01 {

    //For a given string that only contains alphabet characters a-z, if 3 or more consecutive
    //characters are identical, remove them from the string. Repeat this process until
    //there is no more than 3 identical characters sitting besides each other
    public void test01(String msg, int start, int repeatNum) {
        int length = msg.length();
        if (msg != null && length > 0) {
            try {
                char firstChar = msg.charAt(start);
                char nextChar = msg.charAt(start + 1);
                if (firstChar == nextChar) {
                    start = start + 1;
                    repeatNum = repeatNum + 1;
                    test01(msg, start, repeatNum);
                } else {
                    if (repeatNum >= 3) {
                        msg = msg.substring(0, start - repeatNum + 1) + msg.substring(start + 1);
                        System.out.println("-> " + msg);
                        start = 0;
                        repeatNum = 1;
                        test01(msg, start, repeatNum);
                    } else {
                        repeatNum = 1;
                        start = start + 1;
                        test01(msg, start, repeatNum);
                    }
                }
            } catch (StringIndexOutOfBoundsException e) {
                if (repeatNum >= 3) {
                    msg = msg.substring(0, start - repeatNum + 1) + msg.substring(start + 1);
                    System.out.println("-> " + msg);
                } else if (start != 0) {
                    System.out.println("-> " + msg);
                }
            }
        } else {
            System.out.println("-> " + msg);
        }
    }

    //Stage 2 - advanced requirement
    //Instead of removing the consecutively identical characters, replace them with a
    //single character that comes before it alphabetically.
    public void test02(String msg, int start, int repeatNum) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        dataPre(map1, map2);

        int length = msg.length();
        if (msg != null && length > 0) {
            char firstChar = msg.charAt(start);
            try {
                char nextChar = msg.charAt(start + 1);
                if (firstChar == nextChar) {
                    start = start + 1;
                    repeatNum = repeatNum + 1;
                    test02(msg, start, repeatNum);
                } else {
                    if (repeatNum >= 3) {
                        String firstStr = firstChar + "";
                        Integer index = map1.get(firstStr);
                        if (index != 1) {
                            String repleStr = map2.get(index - 1);
                            msg = msg.substring(0, start - repeatNum + 1) + repleStr + msg.substring(start + 1);
                            String repeatStr = "";
                            for (int i = 0; i < repeatNum; i++) {
                                repeatStr += firstChar;
                            }
                            System.out.println("-> " + msg + "," + repeatStr + " is replaced by " + repleStr);
                            start = 0;
                            repeatNum = 1;
                            test02(msg, start, repeatNum);
                        } else {
                            msg = msg.substring(0, start - repeatNum + 1) + msg.substring(start + 1);
                            System.out.println("-> " + msg);
                        }
                    } else {
                        repeatNum = 1;
                        start = start + 1;
                        test02(msg, start, repeatNum);
                    }
                }
            } catch (StringIndexOutOfBoundsException e) {
                if (repeatNum >= 3) {
                    String firstStr = firstChar + "";
                    Integer index = map1.get(firstStr);
                    if (index != 1 || msg.length() > 0) {
                        String repleStr = map2.get(index - 1);
                        msg = msg.substring(0, start - repeatNum + 1) + repleStr + msg.substring(start + 1);
                        String repeatStr = "";
                        for (int i = 0; i < repeatNum; i++) {
                            repeatStr += firstChar;
                        }
                        System.out.println("-> " + msg + "," + repeatStr + " is replaced by " + repleStr);
                    } else {
                        System.out.println("-> " + msg);
                    }
                } else if (start != 0) {
                    System.out.println("-> " + msg);
                }
            }
        } else {
            System.out.println("-> " + msg);
        }
    }

    private static void dataPre(HashMap<String, Integer> map1, HashMap<Integer, String> map2) {
        map1.put("a", 1);
        map1.put("b", 2);
        map1.put("c", 3);
        map1.put("d", 4);
        map1.put("e", 5);
        map1.put("f", 6);
        map1.put("g", 7);
        map1.put("h", 8);
        map1.put("i", 9);
        map1.put("j", 10);
        map1.put("k", 11);
        map1.put("l", 12);
        map1.put("m", 13);
        map1.put("n", 14);
        map1.put("o", 15);
        map1.put("p", 16);
        map1.put("q", 17);
        map1.put("r", 18);
        map1.put("s", 19);
        map1.put("t", 20);
        map1.put("u", 21);
        map1.put("v", 22);
        map1.put("w", 23);
        map1.put("x", 24);
        map1.put("y", 25);
        map1.put("z", 26);

        map2.put(1, "a");
        map2.put(2, "b");
        map2.put(3, "c");
        map2.put(4, "d");
        map2.put(5, "e");
        map2.put(6, "f");
        map2.put(7, "g");
        map2.put(8, "h");
        map2.put(9, "i");
        map2.put(10, "j");
        map2.put(11, "k");
        map2.put(12, "l");
        map2.put(13, "m");
        map2.put(14, "n");
        map2.put(15, "o");
        map2.put(16, "p");
        map2.put(17, "q");
        map2.put(18, "r");
        map2.put(19, "s");
        map2.put(20, "t");
        map2.put(21, "u");
        map2.put(22, "v");
        map2.put(23, "w");
        map2.put(24, "x");
        map2.put(25, "y");
        map2.put(26, "z");
    }
}
