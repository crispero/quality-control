package com.company;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String URL = "http://52.136.215.164/broken-links/";
    private static final Set<String> errorUrls = new HashSet<>();
    private static final Set<String> validUrls = new HashSet<>();
    private static final Set<String> links = new HashSet<>();

    private static void CheckCode(String url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        String str = url + " " + connection.getResponseCode();

        if (connection.getResponseCode() > 300) {
            errorUrls.add(str);
            return;
        }

        try {
            final int bufferSize = 1024;
            final char[] buffer = new char[bufferSize];
            final StringBuilder out = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            for (; ; ) {
                int rsz = reader.read(buffer, 0, buffer.length);
                if (rsz < 0)
                    break;
                out.append(buffer, 0, rsz);
            }

            validUrls.add(str);
            GetLinks(out.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void GetLinks(String dom) throws IOException {
        Pattern pattern = Pattern.compile("<a.*href=\"([^@]*?)\".*>");
        Matcher matcher = pattern.matcher(dom);
        while (matcher.find()) {
            if (!links.contains(matcher.group(1))) {
                links.add(matcher.group(1));
                if (!matcher.group(1).startsWith("http")) {
                    CheckCode(URL + matcher.group(1));
                } else {
                    HttpURLConnection connection = (HttpURLConnection) new URL(matcher.group(1)).openConnection();
                    String str = matcher.group(1) + " " + connection.getResponseCode();

                    if (connection.getResponseCode() > 300) {
                        errorUrls.add(str);
                    } else {
                        validUrls.add(str);
                    }
                }
            }
        }
    }

    private static void WriteLinksInFile(Set<String> links, FileWriter file) throws IOException {
        for (String str : links) {
            file.write(str + "\n");
            file.flush();
        }

        file.write("Count: " + links.size() + "\n");
        file.write("Date: " + new Date() + "\n");
        file.flush();
    }

    public static void main(String[] args) {
        try {
            CheckCode(URL);

            FileWriter validLinksFile = new FileWriter("validLinks.txt");
            FileWriter errorLinksFile = new FileWriter("errorLinks.txt");

            WriteLinksInFile(validUrls, validLinksFile);
            WriteLinksInFile(errorUrls, errorLinksFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
