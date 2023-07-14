package com.surpriseassignment;

import java.io.*;
public class Assign1 {
    public static void main(String[] args) {

        try {
            File file = new File("property.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("<!DOCTYPE html>\n");
            writer.write("<html lang=\"en\">\n");
            writer.write("<head>\n\t");
            writer.write("<meta charset= \"UTF-8\"/>\n\t");
            writer.write("<style>table {border-collapse:collapse; width:100%;}th,td{border:solid 1px #000} </style>\n");
            writer.write("</head>\n");

            writer.write("<body>\n\t");
            writer.write("<h1>자바 환경정보</h1>\n\n\t\t");
            writer.write("<table>\n\t\t\t");
            writer.write("<tr>\n\t\t\t\t");
            writer.write("<th>키</th><th></th>\n\t\t\t");
            writer.write("</tr>\n\t\t\t");

            for (Object k : System.getProperties().keySet()){
                String key = k.toString();
                String value = System.getProperty(key);
                writer.write("<tr>\n\t\t\t\t");
                writer.write("<td>" + key+"</td>"+"<td>" + value + "</td>\n\t\t\t");
                writer.write("</tr>\n\t\t\t");
            }
            writer.write("\n\t\t");
            writer.write("</table>\n");
            writer.write("</body>\n");
            writer.write("</html>");
            writer.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
