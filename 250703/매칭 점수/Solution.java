
/*
    [검색어에 대한 웹페이지의 매칭 점수를 계산하자.]
    특정 검색어 "hi"에 대해서 대소문자를 무시하고 해당 검색어가 등장하는 횟수 
        = 페이지의 기본 점수
    
    링크된 페이지의 기본 점수 % 링크된 페이지의 외부 링크 수의 총합 = 페이지의 링크 점수
    
    매칭 점수 = 기본 점수 + 링크 점수
             
*/
import java.util.*;
import java.util.regex.*;

class Solution {
    
    static class Page implements Comparable<Page> {
        int idx;
        String str;
        String url;
        float linkScore;
        int baseScore;
        String searchWord;
        List<String> linkUrl;
        
        float matchingScore;
        
        public Page(int idx, String str, String searchWord, int maxLinkCount) {
            this.idx = idx;
            this.str = str;
            this.searchWord = searchWord;
            this.linkUrl = new ArrayList<>(maxLinkCount);
        }
        
        @Override
        public int compareTo(Page p) {
            if (this.matchingScore != p.matchingScore) 
                return Float.compare(p.matchingScore, this.matchingScore);
            return this.idx - p.idx;
        }
        
        public void splitHTMLStr() {
            String[] headStr = this.str.split("<head>");
            String[] bodyStr = this.str.split("<body>")[1].split("</body>");
            String bodyMainStr = bodyStr[0]
                    .replaceAll("<a\\s+href=\"[^\"]*\">.*?</a>", "");
            
            this.getMyUrl(headStr[1].split("</head>")[0]);
            // this.calBaseScore(bodyMainStr.split(" "));
            this.calBaseScore(bodyMainStr);
            this.getLinkOtherUrl(bodyStr[0]);
            this.calLinkScore();
            // System.out.println(bodyStr[0]);
        }
        
        public void getMyUrl(String metaStr) {
            Pattern pattern = Pattern.compile("<meta property=\"og:url\" content=\"([^\"]*)\"/>");
            Matcher matcher = pattern.matcher(metaStr);
            matcher.find();
            
            this.url = matcher.group(1);
            // System.out.println("myUrl : " + this.url);
        }
        
        public void getLinkOtherUrl(String metaStr) {
            Pattern pattern = Pattern.compile("<a\\s+href=\"([^\"]*)\">");
            Matcher matcher = pattern.matcher(metaStr);
       
            while (matcher.find()) {
                this.linkUrl.add(matcher.group(1));
                // System.out.println("link Url: " + matcher.group(1));
            }
            // System.out.println("link된 갯수: "+ linkUrl.size());
        }
        
        // 깔끔한 정규식으로 word를 분리할 수 있음
        public void calBaseScore(String bodyMainStr) {
            this.baseScore = 0;
            String[] words = bodyMainStr.split("[^a-z]+");

            for (String word : words) {
                if (word.equals(searchWord)) {
                    this.baseScore++;
                }
            }
        }
        
        // .. 
        public void calBaseScore(String[] mainWord) {
            this.baseScore = 0;

            for (String word: mainWord) {
                String regexWord = word.replaceAll("[^a-z]", " ");
                String[] regexStrs = regexWord.split(" ");
                // System.out.println(Arrays.toString(regexStrs));
                if (regexStrs.length == 1) {
                    if (regexStrs[0].equals(searchWord)) {
                        this.baseScore++;
                        // System.out.println(regexStrs[0]);
                    }
                } else {
                    for (String regexStr : regexStrs) {
                        // System.out.println(regexStr);
                        if (regexStr.equals(searchWord)) {
                            this.baseScore++;
                            // System.out.println(regexStr);
                        }     
                    } 
                }
                // System.out.println("! =" + word);
            }
            
            // System.out.println("baseScore : " + this.baseScore);
        }
        
        public void calLinkScore() {
            if (this.linkUrl.size() > 0) {
                this.linkScore = (float) this.baseScore / this.linkUrl.size();
            } else {
                this.linkScore = 0;
            }
            // System.out.println("link Score: " + this.linkScore);
        }
        
        public void calMatchingScore() {
            this.matchingScore = this.baseScore;
        }
        
        public void addLinkScore(float linkScore) {
            // System.out.println("add LinkScore: " +linkScore);
            this.matchingScore += linkScore;
        }
    }
    
    static int maxLinkCount;
    static List<Page> pageList;
    
    public int solution(String word, String[] pages) {
        maxLinkCount = pages.length;
        pageList = new ArrayList<>(maxLinkCount);
        word = word.toLowerCase();
        
        for (int idx = 0; idx < maxLinkCount; idx++) {
            Page onePage = new Page(idx, pages[idx].toLowerCase(), word, maxLinkCount);
            onePage.splitHTMLStr();
            
            pageList.add(onePage);
        }
        
        for (int idx1 = 0; idx1 < pageList.size(); idx1++) {
            Page onePage = pageList.get(idx1);
            onePage.calMatchingScore();
            String url = onePage.url;
            
            for (int idx2 = 0; idx2 < pageList.size(); idx2++) {
                if (idx1 == idx2) continue;
                Page otherPage = pageList.get(idx2);
                for (String linkUrl : otherPage.linkUrl) {
                    if (url.equals(linkUrl)) {
                        onePage.addLinkScore(otherPage.linkScore);
                    }
                }
            }
            // System.out.println("matchingScore: " + onePage.matchingScore);
        }
        
        
        Collections.sort(pageList);
        
        return pageList.get(0).idx;
    }
}
