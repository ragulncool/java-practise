package com.ragul.demo.java17;

public class TextBlockMultiLineString {
        public static void main(String[] args) {
            String longText = """
            This is a text block in Java 17.
            It allows you to write multi-line strings
            without needing to escape newline characters.
            
            You can also preserve leading whitespace for formatting.
            \tIndented text is also preserved.
            """;

            System.out.println(longText);
        }
    }


