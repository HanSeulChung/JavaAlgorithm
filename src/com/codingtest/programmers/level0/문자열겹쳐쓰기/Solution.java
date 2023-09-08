package com.codingtest.programmers.level0.문자열겹쳐쓰기;

/**
 *  my_string	   overwrite_string	s	result
 * "He11oWor1d"	    "lloWorl"	    2	"HelloWorld"
 * "Program29b8UYP"	 "merS123"	    7	"ProgrammerS123"
 */
public class Solution {

    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder sb = new StringBuilder();

        sb.append(my_string.substring(0, s));
        sb.append(overwrite_string);
        if (my_string.length() > sb.length()){
            sb.append(my_string.substring(s + overwrite_string.length(), my_string.length()));
        }

        return sb.toString();
    }

    // 통과되지 않은 코드
    public String solution1(String my_string, String overwrite_string, int s) {
        StringBuilder sb = new StringBuilder();

        sb.append(my_string.substring(0, s));
        if (my_string.substring(s, my_string.length() - s).length() >= overwrite_string.length()) {
            sb.append(overwrite_string);
        } else {
            sb.append(overwrite_string);
            sb.append(my_string.substring(s + overwrite_string.length(), my_string.length()));
        }

        return sb.toString();
    }


}
