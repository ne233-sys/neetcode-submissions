class Solution {
    private List<String> result;

    public List<String> letterCombinations(String digits) {
        this.result = new LinkedList<>();
        if(digits.length() == 0) return result;

        dtree(digits.toCharArray(), 0);

        return result;
    }

    private void dtree(char[] comb, int index) {
        if(index == comb.length){
            result.add(new String(comb));
            return;
        }

        char curr = comb[index];

        switch(curr){
            case '2':
                comb[index] = 'a';
                dtree(comb, index + 1);
                comb[index] = 'b';
                dtree(comb, index + 1);
                comb[index] = 'c';
                dtree(comb, index + 1);
                break;
            case '3':
                comb[index] = 'd';
                dtree(comb, index + 1);
                comb[index] = 'e';
                dtree(comb, index + 1);
                comb[index] = 'f';
                dtree(comb, index + 1);
                break;
            case '4':
                comb[index] = 'g';
                dtree(comb, index + 1);
                comb[index] = 'h';
                dtree(comb, index + 1);
                comb[index] = 'i';
                dtree(comb, index + 1);
                break;
            case '5':
                comb[index] = 'j';
                dtree(comb, index + 1);
                comb[index] = 'k';
                dtree(comb, index + 1);
                comb[index] = 'l';
                dtree(comb, index + 1);
                break;
            case '6':
                comb[index] = 'm';
                dtree(comb, index + 1);
                comb[index] = 'n';
                dtree(comb, index + 1);
                comb[index] = 'o';
                dtree(comb, index + 1);
                break;
            case '7':
                comb[index] = 'p';
                dtree(comb, index + 1);
                comb[index] = 'q';
                dtree(comb, index + 1);
                comb[index] = 'r';
                dtree(comb, index + 1);
                comb[index] = 's';
                dtree(comb, index + 1);
                break;
            case '8':
                comb[index] = 't';
                dtree(comb, index + 1);
                comb[index] = 'u';
                dtree(comb, index + 1);
                comb[index] = 'v';
                dtree(comb, index + 1);
                break;
            case '9':
                comb[index] = 'w';
                dtree(comb, index + 1);
                comb[index] = 'x';
                dtree(comb, index + 1);
                comb[index] = 'y';
                dtree(comb, index + 1);
                comb[index] = 'z';
                dtree(comb, index + 1);
                break;
            default:
                break;
        }

        comb[index] = curr;
    }
}
