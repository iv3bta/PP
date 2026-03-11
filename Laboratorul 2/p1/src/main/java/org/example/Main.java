package org.example;

import org.graalvm.polyglot.*;
import java.util.*;

class Polyglot {
    private static int SumCRC(String token, Context polyglot){
        String modifiedToken = token.length() >= 2 ? token.substring(1, token.length()-1) : "";
        if(modifiedToken.isEmpty()) return 0;

        Value result = polyglot.eval("python", "sum((ord(ch)**3 + 2*ord(ch) + 1) for ch in '" + modifiedToken + "')");
        return result.asInt();
    }

    public static void main(String[] args) {
        try (Context polyglot = Context.newBuilder().allowAllAccess(true).build()) {
            Value array = polyglot.eval("js",
                    "[\"If\",\"we\",\"run\",\"the\",\"java\",\"command\",\"included\",\"in\",\"GraalVM\","
                            + "\"we\",\"will\",\"be\",\"automatically\",\"using\",\"the\",\"Graal\",\"JIT\",\"compiler\","
                            + "\"no\",\"extra\",\"configuration\",\"is\",\"needed\",\"I\",\"will\",\"use\",\"the\",\"time\","
                            + "\"command\",\"to\",\"get\",\"the\",\"real\",\"wall\",\"clock\",\"elapsed\",\"time\",\"it\","
                            + "\"takes\",\"to\",\"run\",\"the\",\"entire\",\"program\",\"from\",\"start\",\"to\",\"finish\","
                            + "\"rather\",\"than\",\"setting\",\"up\",\"a\",\"complicated\",\"micro\",\"benchmark\",\"and\","
                            + "\"I\",\"will\",\"use\",\"a\",\"large\",\"input\",\"so\",\"that\",\"we\",\"arent\",\"quibbling\","
                            + "\"about\",\"a\",\"few\",\"seconds\",\"here\",\"or\",\"there\",\"The\",\"large.txt\",\"file\","
                            + "\"is\",\"150\",\"MB\"]");

            Map<Integer, List<String>> groupedWords = new HashMap<>();

            for (int i = 0; i < array.getArraySize(); i++) {
                String word = array.getArrayElement(i).asString().toUpperCase();
                int crc = SumCRC(word, polyglot);
                groupedWords.computeIfAbsent(crc, k -> new ArrayList<>()).add(word);
            }
            for (Map.Entry<Integer, List<String>> entry : groupedWords.entrySet()) {
                if(entry.getValue().size() > 1) {
                    System.out.println("CRC " + entry.getKey() + " -> " + entry.getValue());
                }
            }
        }
    }
}