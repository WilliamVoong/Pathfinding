public enum MARKER {
    PLAYER('o'),
    GOAL('G'),
    EMPTY('-'),
    OBSTACLE('x'),
    PATH('I'),
    VISITED('v');

    private char charvalue;

    MARKER(char c){
        this.charvalue=c;
    }
    char getCharVal() {
        return charvalue;
    }

}
