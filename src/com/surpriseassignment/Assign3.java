package com.surpriseassignment;

import java.io.*;

class Paper {
    final int postLimit = 10;
    final int pageBlockLimit = 10;
    long postTotalCount;
    long pageTotalCount;
    long pageIndex;
    String html;

    public Paper(long totalCount){
        this.postTotalCount = totalCount;
        if (postTotalCount % postLimit == 0){
            this.pageTotalCount = totalCount / postLimit;
        } else {
            this.pageTotalCount = totalCount / postLimit + 1;
        }
    }

    public String html(long pageIndex){
        StringBuilder sb = new StringBuilder();

        sb.append("<!DOCTYPE html>\n").append("<html lang=\"en\">\n").append("<head>\n").append("<meta charset= \"UTF-8\"/>\n");
        sb.append("<style>.on{color : red;}</style>");
        sb.append("</head>\n");

        sb.append("<body>\n\t");
        sb.append("<a href='#'>[처음]</a>\n\t");
        sb.append("<a href='#'>[이전]</a>\n\t").append("\n\t");

        long q = pageIndex / pageBlockLimit;

        if (pageIndex <= (pageTotalCount / pageBlockLimit) * pageBlockLimit){ // 총 페이지의 갯수가 10의 배수가 아니여도(ex 26개) 지금 들어온 인덱스가 20이하면 10페이지씩 보여주면됨
            for (int showpageIdx = (int)q*pageBlockLimit + 1; showpageIdx <= (int)(q + 1)*pageBlockLimit ; showpageIdx++){
                if (showpageIdx == pageIndex){
                    sb.append(String.format("<a href='#' class='on'>%d</a>\n\t",showpageIdx));
                } else {
                    sb.append(String.format("<a href='#'>%d</a>\n\t",showpageIdx));
                }
            }
        } else { // 반대로 총 페이지 갯수가 10의 배수가 아닌 경우(ex 26) 21이 들어오면 26까지만 보여줘야함
            for (int showpageIdx = (int)q*pageBlockLimit + 1; showpageIdx <= pageTotalCount; showpageIdx++){
                if (showpageIdx == pageIndex){
                    sb.append(String.format("<a href='#' class='on'>%d</a>\n\t",showpageIdx));
                } else {
                    sb.append(String.format("<a href='#'>%d</a>\n\t",showpageIdx));
                }
            }
        }
        sb.append("\n\t");
        sb.append("<a href='#'>[다음]</a>\n\t");
        sb.append("<a href='#'>[마지막]</a>\n");
        sb.append("</body>\n");
        sb.append("</html>\n");

        html = sb.toString();
        makeHtml(html);

        return html;
    }

    public void makeHtml(String str){
        try {
            File file = new File("paging.html");
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            writer.write(html);

            writer.close();

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
public class Assign3 {

    public static void main(String[] args) {

        long totalCount = 127;
        long pageIndex = 6;

        Paper paper = new Paper(totalCount);
        System.out.println(paper.html(pageIndex));
    }
}
