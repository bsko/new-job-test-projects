package com.mycompany.app.ip;

import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Scanner;

public class IpAddrCounter {
    private static final String SOURCE_IN_CLASSPATH = "ipv4.txt";
    private static final IpAddrFormatter FORMATTER = new IpAddrFormatter();

    public static void main(String[] args) throws Exception {
        IpAddrStorage storage = new IpAddrStorage();
        try (InputStream lines = readFile()) {
            Scanner scanner = new Scanner(lines);
            while (scanner.hasNextLine()) {
                storage.count(FORMATTER.format(scanner.nextLine()));
            }
        }
        System.out.println("Total unique IP addresses count is: " + storage.getTotalCount());
    }

    private static InputStream readFile() throws Exception {
        Path sourceFile = Path.of(ClassLoader.getSystemResource(SOURCE_IN_CLASSPATH).toURI());
        return new FileInputStream(sourceFile.toFile());
    }
}
