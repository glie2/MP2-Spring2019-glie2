package edu.illinois.cs.cs125.spring2019.mp2.lib;

/**
 * A class that implements a Connect4-like game.
 */
public class ConnectN {

    /**Minimum board width.*/
    public static final int MIN_WIDTH = 6;
    /**Maximum board width.*/
    public static final int MAX_WIDTH = 16;
    /**Minimum board height.*/
    public static final int MIN_HEIGHT = 6;
    /**Maximum board height.*/
    public static final int MAX_HEIGHT = 16;
    /**Minimum board N value.*/
    public static final int MIN_N = 4;
    /**Board width.*/
    private int width;
    /**Board height.*/
    private int height;
    /**Board count.*/
    private int n;
    /**Board.*/
    private Player[][] board;
    /**Start game*/
    private boolean startGame = false;

    /**
     * Creates a new ConnectN board with a given width, height, and N value.
     * @param setWidth the width for the new ConnectN board
     * @param setHeight the height for the new ConnectN board
     * @param setN the N value for the new ConnectN board
     */
    ConnectN(final int setWidth, final int setHeight, final int setN) {
        width = setWidth;
        height = setHeight;
        n = setN;
        if (setWidth < MIN_WIDTH || setWidth > MAX_WIDTH) {
            width = 0;
            n = 0;
        }
        if (setHeight < MIN_HEIGHT || setHeight > MAX_HEIGHT) {
            height = 0;
        }
        if (setN < MIN_N || setN > setWidth - 1 || setN > setHeight - 1) {
            n = 0;
        }
        board = new Player[width][height];
    }

    /**
     * Create a new ConnectN board with given width and height, but uninitialized N value.
     * @param setWidth the width for the new ConnectN board
     * @param setHeight the height for the new ConnectN board
     */
    ConnectN(final int setWidth, final int setHeight) {
        this(setWidth, setHeight, 0);
    }

    /**
     * Create a new ConnectN board with uninitialized width, height, and N value.
     */
    ConnectN() {
        this(0, 0, 0);
    }

    /**
     * Create a new ConnectN board with dimensions and N value copied from another board.
     * @param otherBoard the ConnectN board to copy width, height, and N from
     */
    ConnectN(final ConnectN otherBoard) {
        width = otherBoard.getWidth();
        height = otherBoard.getHeight();
        n = otherBoard.getN();
    }


    /**
     * Class method to create a new ConnectN board.
     * @param setWidth the width of the new ConnectN instance to create
     * @param setHeight the height of the new ConnectN instance to create
     * @param setN the n value of the new Connect N instance to create
     * @return
     */
    public static ConnectN create(final int setWidth, final int setHeight, final int setN) {
        if (setWidth < MIN_WIDTH || setWidth > MAX_WIDTH) {
            return null;
        } else if (setHeight < MIN_HEIGHT || setHeight > MAX_HEIGHT) {
            return null;
        } else if (setN < MIN_N) {
            return null;
        } else {
            ConnectN instance = new ConnectN(setWidth, setHeight, setN);
            return instance;
        }
    }

    /**
     * Creates multiple new ConnectN instances.
     * @param number the number of new ConnectN instances to create
     * @param setWidth the width of the new ConnectN instances to create
     * @param setHeight the height of the new ConnectN instances to create
     * @param setN the n value of the new ConnectN instances to create
     * @return
     */
    public static ConnectN[] createMany(final int number, final int setWidth, final int setHeight, final int setN) {
        ConnectN[] arrayConnectN = new ConnectN[number];

        if (setWidth < MIN_WIDTH || setWidth > MAX_WIDTH) {
            return null;
        } else if (setHeight < MIN_HEIGHT || setHeight > MAX_HEIGHT) {
            return null;
        } else if (setN < MIN_N) {
            return null;
        }

        for (int i = 0; i < arrayConnectN.length; i++) {
            arrayConnectN[i] = create(setWidth, setHeight, setN);
        }
        return arrayConnectN;
    }

    public static boolean compareBoards(ConnectN firstBoard, ConnectN secondBoard) {
        return false;
    }
    public static boolean compareBoards(ConnectN... boards) {
        return false;
    }



    /**
     * Get the current board width.
     * @return the current board width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Attempt to set the board width.
     * @param setWidth the new width to set
     * @return true if the width was set successfully, false on error
     */
    public boolean setWidth(final int setWidth) {
        if (startGame) {
            return false;
        }
        int maxDimension;
        if (setWidth > height) {
            maxDimension = setWidth;
        } else {
            maxDimension = height;
        }
        //Check valid width
        if (setWidth < MIN_WIDTH || setWidth > MAX_WIDTH) {
            return false;
        } else if (n > maxDimension - 1) {
            width = setWidth;
            n = 0;
            return true;
        } else {
            width = setWidth;
            return true;
        }
    }
    /**
     * Get the current board height.
     * @return the current board height
     */
    public int getHeight() {
        return height;
    }
    /**
     * Attempt to set the board height.
     * @param setHeight the new height to set
     * @return true if the height was set successfully, false on error
     */
    public boolean setHeight(final int setHeight) {
        if (startGame) {
            return false;
        }
        int maxDimension;
        if (width > setHeight) {
            maxDimension = width;
        } else {
            maxDimension = setHeight;
        }
        //Check valid height
        if (setHeight < MIN_HEIGHT || setHeight > MAX_HEIGHT) {
            return false;
        } else if (n > maxDimension - 1) {
            height = setHeight;
            n = 0;
            return true;
        } else {
            height = setHeight;
            return true;
        }
    }
    /**
     * Get the current board N value.
     * @return the current board N value
     */
    public int getN() {
        return n;
    }

    /**
     * Attempt to set the current board N value.
     * @param newN the new N
     * @return true if N was set successfully, false otherwise
     */
    public boolean setN(final int newN) {
        if (startGame) {
            return false;
        }
        int maxDimension;
        if (width > height) {
            maxDimension = width;
        } else {
            maxDimension = height;
        }
        //Check N is in bounds
        if (newN < MIN_N) {
            return false;
        }
        if (width == 0 || height == 0) {
            return false;
        }
        if (newN > maxDimension - 1) {
            return false;
        } else {
            n = newN;
            return true;
        }
    }

    /**
     * Return a copy of the board.
     * @return a copy of the current board
     */
    public Player[][] getBoard() {
        if (width == 0 || height == 0) {
            return null;
        }
        Player[][] copy = new Player[this.getWidth()][this.getHeight()];

        for (int i = 0; i < width - 1; i++) {
            for (int j = 0; j < height - 1; j++) {
                if (this.getBoardAt(i, j) != null) {
                    Player c1 = new Player(this.getBoardAt(i, j));
                    copy[i][j] = c1;
                } else {
                    copy[i][j] = null;
                }

            }
        }
        return copy;
    }
    /**
     * Get the player at a specific board position.
     * @param getX the X coordinate to get the player at
     * @param getY the Y coordinate to get the player at
     * @return the player whose tile is at that position, or null if nobody has played at that position
     */
    public Player getBoardAt(final int getX, final int getY) {
        if (getX >= 0 && getX <= board.length - 1 && getY >= 0 && getY <= board[0].length - 1) {
            return board[getX][getY];
        } else {
            return null;
        }
    }

    /**
     * Set the board at a specific position.
     * @param player the player attempting the move
     * @param setX the X coordinate that they are trying to place a tile at
     * @param setY the Y coordinate that they are trying to place a tile at
     * @return true if the move succeeds, false on error
     */
    public boolean setBoardAt(final Player player, final int setX, final int setY) {
        //Fail: any board parameters remain uninitialized (width, height, N)
        if (width == 0 || height == 0 || n  == 0) {
            return false;
        }
        //Fail: the player is invalid
        if (player.getName() == null) {
            return false;
        }
        //Fail: the position is invalid for this board (out of range)
        if ((setX < 0 || setX > board.length - 1) || (setY < 0 || setY > board[0].length - 1)) {
            return false;
        }
        //Fail: the position is already taken
        if (board[setX][setY] != null) {
            return false;
        }
        if (setY == 0) {
            board[setX][setY] = player;
            startGame = true;
        } else if (board[setX][setY - 1] == null) {
            return false;
        }
        /**for (int i = 0; i < width; i++) {
            for (int j = 0; j < setY; j++) {
                if (board[i][j] == null) {
                    return false;
                }
            }
        }*/
        board[setX][setY] = player;
        startGame = true;
        return true;
    }

    /**
     * Drop a tile in a particular column.
     * @param player the player attempting the move
     * @param setX the X coordinate for the stack that they are trying to drop a tile in
     * @return true if the move succeeds, false on errer
     */
    public boolean setBoardAt(final Player player, final int setX) {
        /**
        //Fail: any board parameters remain uninitialized (width, height, N)
        if (width == 0 || height == 0 || n  == 0) {
            return false;
        }
         */
        //Fail: the player is invalid
        if (player.getName() == null) {
            return false;
        }
        //Fail: the position is invalid for this board (out of range)
        if (setX < 0 || setX > board.length - 1) {
            return false;
        }

        int yC = 0;
        while (board[setX][yC] != null && yC <= height - 1) {
            if (yC == height - 1) {
                return false;
            }
            yC++;
        }
        board[setX][yC] = player;
        return true;
    }

    /**
     * Return the winner of the game, or null if the game has not ended.
     * @return the winner of the game, or null if the game has not ended
     */
    public Player getWinner() {
        return null;
    }




}