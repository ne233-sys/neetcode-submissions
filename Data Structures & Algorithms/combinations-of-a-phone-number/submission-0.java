class Solution {
    private List<String> result;

    public List<String> letterCombinations(String digits) {
        this.result = new LinkedList<>();
        if(digits.length() == 0) return result;

        dtree("", digits, 0);

        return result;
    }

    private void dtree(String comb, String digits, int index) {
        if(index == digits.length()) result.add(comb);
        else switch(digits.charAt(index)){
            case '2':
                dtree(comb + "a", digits, index + 1);
                dtree(comb + "b", digits, index + 1);
                dtree(comb + "c", digits, index + 1);
                break;
            case '3':
                dtree(comb + "d", digits, index + 1);
                dtree(comb + "e", digits, index + 1);
                dtree(comb + "f", digits, index + 1);
                break;
            case '4':
                dtree(comb + "g", digits, index + 1);
                dtree(comb + "h", digits, index + 1);
                dtree(comb + "i", digits, index + 1);
                break;
            case '5':
                dtree(comb + "j", digits, index + 1);
                dtree(comb + "k", digits, index + 1);
                dtree(comb + "l", digits, index + 1);
                break;
            case '6':
                dtree(comb + "m", digits, index + 1);
                dtree(comb + "n", digits, index + 1);
                dtree(comb + "o", digits, index + 1);
                break;
            case '7':
                dtree(comb + "p", digits, index + 1);
                dtree(comb + "q", digits, index + 1);
                dtree(comb + "r", digits, index + 1);
                dtree(comb + "s", digits, index + 1);
                break;
            case '8':
                dtree(comb + "t", digits, index + 1);
                dtree(comb + "u", digits, index + 1);
                dtree(comb + "v", digits, index + 1);
                break;
            case '9':
                dtree(comb + "w", digits, index + 1);
                dtree(comb + "x", digits, index + 1);
                dtree(comb + "y", digits, index + 1);
                dtree(comb + "z", digits, index + 1);
                break;
            default:
                break;
        }
    }
}
