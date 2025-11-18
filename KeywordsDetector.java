public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
                "Our product will transform the market",
                "Programming is both painful and engaging",
                "This has nothing to do with machine learning",
                "We need to leverage our core competencies",
                "Let's talk about data and algorithms",
                "Chatbots are great but must be used carefully",
                "This blockchain-based solution will disrupt the industry",
                "The team showed great Synergy in the last project",
                "Use simple words without hype and fluff",
                "Our new technology presents a significant paradigm shift",
                "Effective presentations must be clear, concise, and humble"
        };

        String[] keywords = { "synergy", "disrupt", "leverage", "Paradigm", "transform" };

        detectAndPrint(sentences, keywords);
    }

    public static String toLowerCase(String str) {
        String result = "";

        int A = (int) 'A';
        int Z = (int) 'Z';
        int delta = (int) 'a' - A;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int code = (int) c;

            if (code >= A && code <= Z) {
                result += (char) (code + delta);
            } else {
                result += c;
            }
        }

        return result;
    }

    public static boolean contains(String str1, String str2) {
        if (str2.length() == 0)
            return true;
        if (str2.length() > str1.length())
            return false;

        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            boolean match = true;

            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    match = false;
                    break;
                }
            }

            if (match)
                return true;
        }

        return false;
    }

    public static void detectAndPrint(String[] sentences, String[] keywords) {

        for (int i = 0; i < sentences.length; i++) {
            String sentenceLower = toLowerCase(sentences[i]);

            for (int j = 0; j < keywords.length; j++) {
                String keywordLower = toLowerCase(keywords[j]);

                if (contains(sentenceLower, keywordLower)) {
                    System.out.println(sentences[i]);
                    break;
                }
            }
        }
    }
}
