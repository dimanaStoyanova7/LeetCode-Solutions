class StreamChecker {

    class CharacterTree{
        //array of 26 nodes as children - for each character
        CharacterTree[] children = new CharacterTree[26];
        boolean isWord;
    }
    private CharacterTree root;
    private StringBuilder sb;
    private int maxLength;

    public StreamChecker(String[] words) {
        root = new CharacterTree();
        sb = new StringBuilder();
        maxLength = 0;
        for(String word: words){
            maxLength = Math.max(maxLength, word.length());
            //insert the word in the character tree
            CharacterTree node = root;
            for(int i=word.length()-1; i>=0; i--){
                int index = word.charAt(i)-'a';
                if(node.children[index]==null){
                    node.children[index] = new CharacterTree();
                }
                node = node.children[index];
            }
            node.isWord = true;
        }
    }
    public boolean query(char letter) {
        sb.append(letter);
        CharacterTree node = root;
        for (int i = sb.length() - 1, count = 0;
             i >= 0 && count < maxLength;
             i--, count++){
            int index = sb.charAt(i)-'a';
            node = node.children[index];
            if(node==null){
                return false;
            }
            else if (node.isWord){
                return true;
            }
        } 
        return false;  
    }

}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */