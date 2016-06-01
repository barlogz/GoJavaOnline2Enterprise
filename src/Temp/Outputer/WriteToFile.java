//package com.goit.gojavaonline.enterprise.Outputer;
//
//import java.io.*;
//
//import static java.awt.SystemColor.text;
//
//public class WriteToFile {
//    PrintWriter printWriter;
//
//    public WriteToFile(String fileName, FileType fileType) {
//        File file = new File(fileName);
//
//        try {
//            if (file.exists()) file.delete();
//
//            file.createNewFile();
//
//            printWriter = new PrintWriter(file.getAbsoluteFile());
//        } catch (IOException ex) {
//            System.out.println(ex.getMessage());
//        }
//    }
//
//    public void close() {
//        printWriter.close();
//    }
//
//    public void writeToLine(String line) {
//        printWriter.print(line + "\n");
//    }
//
//    public enum FileType {
//        TXT_FILE, HTML_FILE
//    }
//
//}
