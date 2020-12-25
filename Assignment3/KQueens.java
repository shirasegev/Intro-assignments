public class KQueens {

    //Use these constants in your code
    final static int QUEEN = 1;
    final static int WALL = -1;
    final static int EMPTY = 0;


    /**
     * Checks if the input parameters are valid
     *
     * @param k number of queens
     * @param rows number of rows to be on a board
     * @param cols number of columns to be on a board
     * @param walls locations of walls on a board
     * @return true if all parameters are valid, false otherwise.
     */
    public static boolean isValidInput(int k, int rows, int cols, int[][] walls){
    	boolean valid = true;

    	if (k < 1 || rows < 1 || cols < 1 || walls == null || walls.length != rows) {
    		valid = false;
    	}
    	else {
    		int counter = 0;
    		for (int i = 0; valid && i < rows; i = i + 1) {
    			if (walls[i] == null) {
    				valid = false;
    			}
    			else {
        			counter = counter + walls[i].length;
        			for (int j = 0; valid && j < walls[i].length; j = j + 1) {
        				if (walls[i][j] >= cols) {
        					valid = false;
        				}
        			}
    			}
    		}
    		if (k > rows * cols - counter) {
    			valid = false;
    		}
    	}
        return valid;
    }

    /**
     * Creates a board of size rows x cols with walls
     *
     * @param rows number of rows in board. Assume valid value.
     * @param cols number of columns in board. Assume valid value.
     * @param walls locations of walls on board. Assume valid value.
     * @return rows x cols board with walls
     */
    public static int[][] createBoard(int rows, int cols, int[][] walls){
    	// Assume all inputs are valid
    	// Create a new board according to the given walls places
    	int [][] board = new int [rows][cols];
    	for (int index = 0; index < walls.length; index = index + 1) {
    		for (int part: walls[index]) {
    			board[index][part] = WALL;
    		}
    	}
    	return board;
    }

    /**
     * Print the representation of a board with queens and walls
     *
     * @param board to be printed. Assume valid value.
     */
    public static void printBoard(int[][] board){
    	// Assume board is a legal input
    	if (board.length == 0 || board[0].length == 0) {
    		System.out.println("There is no solution");
    	}
    	for (int i = 0; i < board.length; i = i + 1) {
    		for (int j = 0; j < board[i].length; j = j + 1) {
    			if (board[i][j] == QUEEN) {
    				System.out.print("Q ");
    			}
    			else if (board[i][j] == WALL) {
    				System.out.print("X ");
    			}
    			else {
    				System.out.print("* ");
    			}
    		}
    		System.out.println();
    	}
    }

    /**
     * Validate that the walls in board match the walls locations in walls
     *
     * @param walls locations of walls in board. Assume valid value.
     * @param board a board with walls
     * @return true if walls on boards match the walls locations, false otherwise
     */
    public static boolean validateWalls(int[][] walls, int[][] board){
    	boolean valid = true;
    	// Use creatBoard function, which represents a board only with its walls,
    	// To check if the given board and walls at this function are valid
    	int[][] boardWalls = createBoard(board.length, board[0].length, walls);
    	for (int i = 0; i < board.length && valid; i = i + 1) {
    		for (int j = 0; j < board[i].length && valid; j = j + 1) {
    			if ((board[i][j] == WALL && boardWalls[i][j] != WALL) || (board[i][j] != WALL && boardWalls[i][j] == WALL)) {
    				valid = false;
    			}
    		}
    	}
        return valid;
    }

    /**
     * Check if the queen located in board[row][col] is threatened by another queen on the board
     *
     * @param board a queen is located on this board
     * @param row the row in which the queen is located
     * @param col the column in which the queen is located
     * @return true if queen is threatened, false otherwise
     */
    public static boolean isQueenThreatened(int[][] board, int row, int col){
    	// Assume board is a legal input
        boolean isThreatened = false;
        boolean isProtected = false;
        
        // Check if queen is threatened at each direction (8 of them)
        // the function will check each direction separately, and return true if the queen is threatened,
        // And there will be no need to keep checking rest of the directions.
        // Otherwise, if at some directions there is no danger to the queen, we still have to keep looking all around.
        // QUEEN = danger, WALL = protection.
        isProtected = false;
        for (int i = col + 1; !isThreatened && !isProtected && i < board[0].length; i = i + 1) {
        	// on row to the right
        	if (board[row][i] == QUEEN) {
        		isThreatened = true;
        	}
        	else if (board[row][i] == WALL) {
        		isProtected = true;
        	}
        }
        
        isProtected = false;
        for (int i = col - 1; !isThreatened && !isProtected && i >= 0; i = i - 1) {
        	// on row to the left
        	if (board[row][i] == QUEEN) {
        		isThreatened = true;
        	}
        	else if (board[row][i] == WALL) {
        		isProtected = true;
        	}
        }
        
        isProtected = false;
        for (int i = row - 1; !isThreatened && !isProtected && i >= 0; i = i -1) {
        	// on col up
        	if (board[i][col] == QUEEN) {
        		isThreatened = true;
        	}
        	else if (board[i][col] == WALL) {
        		isProtected = true;
        	}
        }
        
        isProtected = false;
        for (int i = row + 1; !isThreatened && !isProtected && i < board.length; i = i + 1) {
        	// on col down
        	if (board[i][col] == QUEEN) {
        		isThreatened = true;
        	}
        	else if (board[i][col] == WALL) {
        		isProtected = true;
        	}
        }
        
        isProtected = false;
        for (int i = row - 1, j = col + 1; !isThreatened && !isProtected && i >= 0 && j < board[0].length; i = i - 1, j = j + 1) {
        	// Diagonal to the right up side
	    	if (board[i][j] == QUEEN) {
	    		isThreatened = true;
	    	}
	    	else if (board[i][j] == WALL) {
	    		isProtected = true;
	    	}
        }
        
        isProtected = false;
        for (int i = row + 1, j = col + 1; !isThreatened && !isProtected && i < board.length & j < board[0].length ; i = i + 1, j = j + 1) {
        	// Diagonal to the right down side
        	if (board[i][j] == QUEEN) {
        		isThreatened = true;
        	}
        	else if (board[i][j] == WALL) {
        		isProtected = true;
        	}
        }
        
        isProtected = false;
        for (int i = row - 1, j = col - 1; !isThreatened && !isProtected && j >= 0 && i >= 0; i = i - 1, j = j - 1) {
        	// Diagonal to the left up side
        	if (board[i][j] == QUEEN) {
        		isThreatened = true;
        	}
        	else if (board[i][j] == WALL) {
        		isProtected = true;
        	}
        }
        
        isProtected = false;
        for (int i = row + 1, j = col - 1; !isThreatened && !isProtected && i < board.length & j >= 0; i = i + 1, j = j - 1) {
        	// Diagonal to the left down side
        	if (board[i][j] == QUEEN) {
        		isThreatened = true;
        	}
        	else if (board[i][j] == WALL) {
        		isProtected = true;
        	}
        }
        
        return isThreatened;
    }

    /**
     * Check if board is a legal solution for k queens
     *
     * @param board a solution for the k-queens problem. Assume board not null and not empty, and each cell not null.
     * @param k number of queens that must be on the board. Assume k>=1.
     * @param rows number of rows that must be on the board. Assume rows>=1.
     * @param cols number of columns that must be on the board. Assume cols>=1.
     * @param walls locations of walls that must be on board. Assume valid value.
     * @return true if board is a legal solution for k queens, otherwise false
     */
    public static boolean isLegalSolution(int[][] board, int k, int rows, int cols, int[][] walls){
    	// Assume all inputs are valid
    	// Use isQueenThreatened, isValidInput, validateWalls previous functions to check if the solution is legal
    	boolean legal = true;
    	int kCounter = 0;
    	
    	if (!isValidInput(k, rows, cols, walls) || !validateWalls(walls, board)) {
        	legal = false;
        }
    	else {
    		for (int i = 0; i < board.length && legal; i = i + 1) {
    			for (int j = 0; j < board[i].length && legal; j = j + 1) {
	    			if (board[i][j] == QUEEN) {
	    				kCounter = kCounter + 1;
	    				legal = !isQueenThreatened (board, i, j);
	    			}
	    			else if (board[i][j] != WALL && board[i][j] != EMPTY) {
	    				legal = false;
	    			}
    			}
    		}
    		if (k != kCounter) {
    			legal = false;
    		}
    	}
    	
    	return legal;
    }

    /**
     * Adds queen to cell board[row][col] if the board obtained by adding the queen is legal
     *
     * @param board represents a partial solution for k'<k queens. Assume valid value.
     * @param row queen must be added to this row. Assume valid value.
     * @param col queen must be added to this column. Assume valid value.
     * @return true if queen was added, otherwise false.
     */
    public static boolean addQueen(int[][] board, int row, int col) {
    	// Assume board is a partial solution for k' queens
    	// Assume all inputs are valid
    	// Use isQueenThreatened function to make sure adding a queen doesn't damage the final solution
    	boolean posible = false;
    	if (board[row][col] == EMPTY && !isQueenThreatened(board, row, col)) {
        	posible = true;
        	board[row][col] = QUEEN;
        }
        return posible;
    }

    /**
     * Solves the k queens problem.
     *
     * @param k number of queens to be located on the board
     * @param rows number of rows in the board
     * @param cols number of columns in the board
     * @param walls locations of walls on the board
     * @return board that is a legal solution, empty board if there is no solution
     */
    public static int[][] kQueens(int k, int rows, int cols, int[][] walls){
    	// This function returns a legal board, if possible
    	// While calling kQueens (6b) function, we assume:
    	// The partial solution is valid
    	// The range where the rest of the queens can be placed is only where specified
    	int[][] board;
    	boolean foundSolution;
    	
    	if (!isValidInput(k, rows, cols, walls)) {
    		board = new int [0][0];
    	}
    	else {
	    	board = createBoard(rows, cols, walls);
	    	foundSolution = kQueens(board, k, 0, 0, 0);
	    	if (!foundSolution) {
	    		board = new int [0][0];
	    	}
    	}
        return board;
    }
  
    /**
     * Recursive helper function for the k queens problem
     * @param board
     * @param k
     * @param row
     * @param col
     * @param numOfQueens
     * @return
     */
    private static boolean kQueens(int[][] board, int k, int row, int col, int numOfQueens){
        // At each step board represents a *partial* solution, only for numOfQueens <= k
    	// While k is the final number of queens on final board
    	boolean solution = true;
    	
    	// Done with adding all queens
    	if (k == numOfQueens) {
    		solution = true;
    	}
    	// Out of array bounds
    	else if (row >= board.length || col >= board[row].length) {
			solution = false;
		}
    	else {
    		int[][] blankBoard = new int [board.length][board[0].length];
        	copyBoard(blankBoard, board);
        	
			boolean queenAdded = addQueen(board, row, col);
    		if (queenAdded) {
    			numOfQueens = numOfQueens + 1;
    		}
    		col = (col + 1) % board[row].length;
			if (col == 0) {
				row = row + 1;
			}
			
			// If the first solution is a false one, it doesn't mean there is no solution at all,
			// It means that even if at a current square addQueen function says it is allow to place a queen there,
			// It still may cause a problem later.
			// That is why we use the benefits of recursion here to fix it during the solution searchings
			// at the end, given board must represent the final board solution,
			// And that is why we copy the board with the final solution to "board"
    		solution = kQueens(board, k, row, col, numOfQueens);
    		if (!solution && queenAdded) {
    			solution = kQueens(blankBoard, k, row, col, numOfQueens - 1);
    			copyBoard(board, blankBoard);
    		}
    	}
    	return solution;
    }
    
    // Assisting function for Task 6b 
    // BoardA represents the final wanted board
    // BoardB represents the temporary "copy" board
    private static void copyBoard (int[][] boardA, int[][] boardB){
		for (int i = 0; i < boardA.length; i = i + 1) {
			for (int j = 0; j < boardA[0].length; j = j + 1) {
				boardA[i][j] = boardB[i][j]; 
			}
		}
    }
    
}