import com.sun.istack.internal.NotNull;

/**
 * This class allow to find word into a specific characters's matrix.
 * First, you need to enter a matrix, with all of characters. Than you can use
 * {@link CruciPuzzle&findWord} to search a specific word.
 *
 * @author emilio
 * @see CruciPuzzle&findWord
 */

public class CruciPuzzle {
    private char[][] characters;
    private int columns;
    private int rows;

    /**
     * Allow to init a CruciPuzzle, without use other method.
     * @param characters characters of matrix
     * @param columns number of columns
     * @param rows number of rows
     * @see CruciPuzzle&setCharacters
     * @see CruciPuzzle&setColumns
     * @see CruciPuzzle&setRows
     */
    public CruciPuzzle(char[][] characters, int columns, int rows){
        setCharacters(characters);
        setColumns(columns);
        setRows(rows);
    }

    /**
     * Allow to get a matrix chars
     * @return characters matrix
     */
    public char[][] getCharacters() {
        return characters;
    }

    /**
     * Allow to set a characters of matrix
     * @param characters characters of matrix
     */
    public void setCharacters(char[][] characters) {
        this.characters = characters;
    }

    /**
     * Allow to get number of rows
     * @return number of rows
     */
    public int getRows() {
        return rows;
    }

    /**
     * Allow to set number of columns
     * @param columns number of columns
     */
    public void setColumns(int columns) {
        this.columns = columns;
    }

    /**
     * Allow to set number of rows
     * @param rows number of row
     */
    public void setRows(int rows) {
        this.rows = rows;
    }

    /**
     * Allow to get number of columns
     * @return number of columns
     */
    public int getColumns() {
        return columns;
    }

    /**
     * This method allow to search any word that you want. When you enter a word
     * it'll try to search in each kind of position, like vertical horizontal ecc.
     * There are a specific method for each of position
     * @param word specific word to search
     * @see CruciPuzzle&findWordFromBottom
     * @see CruciPuzzle&findWordFromBottomLeft
     * @see CruciPuzzle&findWordFromBottomRight
     * @see CruciPuzzle&findWordFromTop
     * @see CruciPuzzle&findWordFromTopLeft
     * @see CruciPuzzle&findWordFromTopRight
     * @see CruciPuzzle&findWordFromLeft
     * @see CruciPuzzle&findWordFromRight
     */

    public void findWord(@NotNull String word){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(findWordFromBottom(word,i,j) || findWordFromLeft(word,i,j)
                        || findWordFromRight(word,i,j) || findWordFromTop(word,i,j)
                        || findWordFromBottomLeft(word,i,j) || findWordFromBottomRight(word,i,j)
                        || findWordFromTopLeft(word,i,j) || findWordFromTopRight(word,i,j)){
                    System.out.println("FOUND");
                }
            }
        }
    }

    private boolean findWordFromRight(String word, int z, int f){
        boolean CONTINUE = true;
        String info_coordinators = "";
        try{
            for(int i = 0; i< word.length() && CONTINUE; i++){
                CONTINUE = characters[z][f - i] == word.charAt(i);
                info_coordinators += "("+(z + 1)+","+(f - i + 1)+"); ";
            }
        }catch (Exception e){
            CONTINUE = false;
            //e.printStackTrace();
        }

        if(CONTINUE){
            System.out.println(info_coordinators + " orizzontale da destra a sinistra");
        }

        return CONTINUE;
    }

    private boolean findWordFromLeft(String word, int z, int f){
        boolean CONTINUE = true;
        String info_coordinators = "";
        try{
            for(int i = 0; i< word.length() && CONTINUE; i++){
                CONTINUE = characters[z][f + i] == word.charAt(i);
                info_coordinators += "("+(z + 1)+","+(f + i + 1)+"); ";
            }
        }catch (Exception e){
            CONTINUE = false;
            //e.printStackTrace();
        }

        if(CONTINUE)
            System.out.println(info_coordinators + " orizzontale da sinistra a destra");

        return CONTINUE;
    }

    private boolean findWordFromBottom(String word, int z, int f){
        boolean CONTINUE = true;
        String info_coordinators = "";
        try{
            for(int i = 0; i< word.length() && CONTINUE; i++){
                CONTINUE = characters[z - i][f] == word.charAt(i);
                info_coordinators += "("+(z - i + 1)+","+(f + 1)+"); ";
            }
        }catch (Exception e){
            CONTINUE = false;
            //e.printStackTrace();
        }

        if(CONTINUE)
            System.out.println(info_coordinators + " verticale dal basso verso l'alto");

        return CONTINUE;
    }

    private boolean findWordFromTop(String word, int z, int f){
        boolean CONTINUE = true;
        String info_coordinators = "";
        try{
            for(int i = 0; i< word.length() && CONTINUE; i++){
                CONTINUE = characters[z + i][f] == word.charAt(i);
                info_coordinators += "("+(z + i +1)+","+(f + 1)+"); ";
            }
        }catch (Exception e){
            CONTINUE = false;
            //e.printStackTrace();
        }

        if(CONTINUE)
            System.out.println(info_coordinators + " verticale dall'alto verso il basso");

        return CONTINUE;
    }

    private boolean findWordFromBottomRight(String word, int z, int f){
        boolean CONTINUE = true;
        String info_coordinators = "";
        try{
            for(int i = 0; i< word.length() && CONTINUE; i++){
                CONTINUE = characters[z + i][f - i] == word.charAt(i);
                info_coordinators += "("+(z + i + 1)+","+(f - i + 1)+"); ";
            }
        }catch (Exception e){
            CONTINUE = false;
            //e.printStackTrace();
        }

        if(CONTINUE)
            System.out.println(info_coordinators + " diagonale da sud-est verso nord-ovest");

        return CONTINUE;
    }

    private boolean findWordFromBottomLeft(String word, int z, int f){
        boolean CONTINUE = true;
        String info_coordinators = "";
        try{
            for(int i = 0; i< word.length() && CONTINUE; i++){
                CONTINUE = characters[z + i][f + i] == word.charAt(i);
                info_coordinators += "("+(z+i+1)+","+(f+i+1)+"); ";
            }
        }catch (Exception e){
            CONTINUE = false;
            //e.printStackTrace();
        }

        if(CONTINUE)
            System.out.println(info_coordinators + " diagoanle da sud-ovest verso nord-est");

        return CONTINUE;
    }

    private boolean findWordFromTopRight(String word, int z, int f){
        boolean CONTINUE = true;
        String info_coordinators = "";
        try{
            for(int i = 0; i< word.length() && CONTINUE; i++){
                CONTINUE = characters[z - i][f + i] == word.charAt(i);
                info_coordinators += "("+(z-i+1)+","+(f+i+1)+"); ";
            }
        }catch (Exception e){
            CONTINUE = false;
            //e.printStackTrace();
        }

        if(CONTINUE)
            System.out.println(info_coordinators + " diagonale da nord-est verso sud-ovest");

        return CONTINUE;
    }

    private boolean findWordFromTopLeft(String word, int z, int f){
        boolean CONTINUE = true;
        String info_coordinators = "";
        try{
            for(int i = 0; i< word.length() && CONTINUE; i++){
                CONTINUE = characters[z - i][f - i] == word.charAt(i);
                info_coordinators += "("+(z-i+1)+","+(f-i+1)+"); ";
            }
        }catch (Exception e){
            CONTINUE = false;
            //e.printStackTrace();
        }

        if(CONTINUE)
            System.out.println(info_coordinators + " diagonale da nord-ovest verso sud-est");

        return CONTINUE;
    }
}