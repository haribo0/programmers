public class P72410 {
    public String solution(String new_id) {
        String modifiedId = new_id;

        modifiedId = modifiedId.toLowerCase();
        modifiedId = modifiedId.replaceAll("[^a-z0-9-_.]", "");
        modifiedId = modifiedId.replaceAll("\\.{2,}", ".");
        modifiedId = modifiedId.replaceAll("^\\.|\\.$", "");

        if(modifiedId.isEmpty()) modifiedId="a";
        if(modifiedId.length()>=16) {
            modifiedId=modifiedId.substring(0,15);
            modifiedId = modifiedId.replaceAll("\\.$", "");
        }
        while (modifiedId.length()<3) {
            modifiedId+=modifiedId.charAt(modifiedId.length()-1);
        }
        
        return modifiedId;
    }
    public static void main(String[] args) {
        P72410 solver = new P72410();
        String[] inputs = {
            "...!@BaT#*..y.abcdefghijklm",
            "z-+.^.",
            "=.=",
            "123_.def",
            "abcdefghijklmn.p"
        };

        String[] expectedOutputs = {
            "bat.y.abcdefghi",
            "z--",
            "aaa",
            "123_.def",
            "abcdefghijklmn"
        };

        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            String expected = expectedOutputs[i];
            String result = solver.solution(input);
            System.out.printf("Test %d: Input: %-30s → Output: %-20s [%s]\n",
                    i + 1, input, result, result.equals(expected) ? "PASS" : "FAIL");
        }
    }
}
