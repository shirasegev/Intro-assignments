
public class Assignment2 {

	// Task 1
	public static boolean isSquareMatrix(boolean[][] matrix){
		boolean isSquare = true;
		
		// Taking care of a null input case, otherwise we'll get an error
		if (matrix == null) {
			isSquare = false;
		}
		else {
			for (int i = 0; (i < matrix.length) & isSquare ; i = i + 1) {
				if ((matrix[i] == null) || (matrix.length != matrix[i].length)) {
					isSquare = false;
				}
			}
		}
		return isSquare;
	}
	
	// Assisting function, like Task 1, to check if map (an int array) is a square matrix
	public static boolean isSquareMatrix(int[][] matrix){
		boolean isSquare = true;
		
		// Taking care of a null input case, otherwise we'll get an error
		if (matrix == null) {
			isSquare = false;
		}
		else {
			for (int i = 0; (i < matrix.length) & isSquare ; i = i + 1) {
				if ((matrix[i] == null) || (matrix.length != matrix[i].length)) {
					isSquare = false;
				}
			}
		}
		return isSquare;
	}
	
	// Task 2	
	public static boolean isSymmetricMatrix(boolean[][] matrix){
		// Assume the matrix is square
		boolean isSymmetric = true;
		for (int i = 0; i < matrix.length & isSymmetric; i = i + 1) {
			for (int j = 0; j < i & isSymmetric; j = j + 1) {
				if (matrix[i][j] != matrix [j][i]) {
					isSymmetric = false;
				}
			}
		}
		return isSymmetric;
	}
	
	// Task 3
	public static boolean isAntiReflexiveMatrix(boolean[][] matrix){
		// Assume the matrix is square
		boolean isAntiReflexsive = true;
				
		for (int i = 0; i < matrix.length & isAntiReflexsive; i = i + 1) {
			if (matrix[i][i]) {
				isAntiReflexsive = false;
			}
		}
		return isAntiReflexsive;
	}
	
	// Task 4
	public static boolean isLegalInstance(boolean[][] matrix){
		// Making sure all matrix conditions are valid
		boolean isLegal = false;
		if (isSquareMatrix(matrix) && (isSymmetricMatrix(matrix) & isAntiReflexiveMatrix(matrix))) {
			isLegal = true;
		}
		return isLegal;
	}
	
	// Task 5
	public static boolean isPermutation(int[] array){
		// Assume array is not null
		// In the following boolean array, the default values are "false"
		boolean[] found = new boolean [array.length];
		boolean permutation = true;
		for (int i = 0; i < array.length & permutation; i = i + 1) {
			int city = array[i];
			if ((city >= 0 & city < array.length) && !(found[city])) {
				found[city] = true;
			}
			else {
				permutation = false;
			}
				
		}
		return permutation;
	}
	
	// Task 6
	public static boolean hasLegalSteps(boolean[][] flights, int[] tour){
		// Assume flights is legal for all cities
		// The length of tour array is n and his values are between 0 to n-1
		boolean legal = true;
		int n = tour.length;
		// Modulo (%) takes care of last element with the first one (0)
		for (int i = 0; i < n & legal; i = i + 1) {
			if (!(flights[tour[i]][tour[(i+1)%n]])) {
				legal = false;
			}
		}
		return legal;
	}
	
	// Task 7
	public static boolean isSolution(boolean[][] flights, int[] tour){
		// Make sure that tour length is valid
		if (tour == null || tour.length != flights.length) {
			throw new IllegalArgumentException( "Illegal argument provided: Tour array is not of flights length");
		}
		//Assume the solution is not correct, as long as I wont prove the other way
		boolean solution = false;
		if (tour[0] == 0 && isPermutation(tour) && hasLegalSteps(flights, tour)) {
			solution = true;
		}
		return solution;
	}
	
	// Task 8
	// return the input I got as a double array
	// Assume input is legal
	public static int[][] atLeastOne(int[] vars) {
		int [][] atLeast = new int [1][vars.length];
		for (int i = 0; i < vars.length; i = i + 1) {
			atLeast[0][i] = vars[i];
		}
		return atLeast;
	}
	
	// Task 9
	// Assume input is legal
	public static int[][] atMostOne(int[] vars) {
		int [][] atMost = new int [(vars.length * (vars.length - 1)) / 2][2];
		int step = 0;
		for (int i = 0; i < vars.length-1; i = i + 1) {
			for (int j = i + 1; j < vars.length; j = j + 1) {
				atMost[step][0] = (-1) * vars[i];
				atMost[step][1] = (-1) * vars[j];
				step = step + 1;
			}
		}
		return atMost;
	}

	// Task 10
	// combine Tasks 8&9 to create an array that gives a solution for exactly one city at a step
	// Assume input is legal
	public static int[][] exactlyOne(int[] vars) {
		int[][] exactly = new int [((vars.length * (vars.length - 1)) / 2 ) + 1][];
		int[][] atMost = atMostOne(vars);
		exactly[0] = atLeastOne(vars)[0];
		for (int i = 0; i < atMost.length; i = i + 1) {
			exactly[i+1]= atMost[i];
		}
		return exactly;
	}
	
	// Task 11
	public static boolean[] solveExactlyOneForEachSet(int[][] varSets) {
		SATSolver.init(maxVar(varSets));
		for (int i = 0; i < varSets.length ; i = i + 1 ) {
			SATSolver.addClauses(exactlyOne(varSets[i]));
		}
		boolean[] assignment = SATSolver.getSolution();
		// According to SAT way of work, the following results are an option
		if (assignment == null) {
			throw new RuntimeException("TIMEOUT") ;
		}
		return assignment;
	}
	
	// Assisting function to find the amount of variables
	// Assume all variables are positive
	public static int maxVar (int[][] varSets) {
		int max = 0;
		for (int i = 0; i < varSets.length ; i = i + 1) {
			for (int j = 0; j < varSets[i].length; j = j + 1) {
				if (max < varSets[i][j]) {
					max = varSets[i][j];
				}
			}
		}
		return max;
	}
	
	// Task 12
	//Assume n is a positive input
	public static int[][] createVarsMap(int n) {
		int[][] map = new int [n][n];
		for (int i = 0; i < n; i = i + 1) {
			for (int j = 0; j < n; j = j + 1) {
				map [i][j] = (i * n) + j + 1;
			}
		}
		return map;
	}
	
	// Task 13
	//Assume map is a reasonable matrix for n cities 
	public static int[][] oneCityInEachStep(int[][] map) {
		int n = map.length;
		int m = 0;
		// Create the matrix that will contain the full CNF
		int [][] cnf = new int [n*(n*(n-1)/2 + 1)][];
		// For each line in map
		for (int i = 0; i < n; i = i + 1) {
			// Get the CNF for the line
			int[][] rowCNF = exactlyOne(map[i]);
			// Add it to the full CNF
			for (int j = 0; j < rowCNF.length ; j = j + 1) {
				cnf[m] = rowCNF[j];
				m = m + 1;
			}
		}
		return cnf;
	}
	
	// Task 14
	//Assume map is a reasonable matrix for n cities
	public static int[][] fixSourceCity(int[][] map) {
		int[] source = {map [0][0]};
		int[][] cnf = new int [1][];
		cnf [0] = source;
		return cnf;
	}
	
	// Task 15
	//Assume map is a reasonable matrix for n cities
	public static int[][] eachCityIsVisitedOnce(int[][] map) {
		int n = map.length;
		int m = 0;
		// Create the matrix that will contain the full CNF	
		int [][] cnf = new int [n*(n*(n-1)/2 + 1)][];
		// For each column
		for (int i = 0; i < n; i = i + 1) {
			int[][] colCNF = exactlyOne(getCol(map, i));
			// Add the column to the full CNF
			for (int j = 0; j < colCNF.length ; j = j + 1) {
				cnf[m] = colCNF[j];
				m = m + 1;
			}
		}
		return cnf;
	}
	
	//Assisting function for Task 15. Check all cities in a column
	public static int[] getCol(int[][] matrix, int j) {
		int[] col = new int [matrix.length];
		// A way to check all variables in a column instead of a row 
		for (int i = 0; i < matrix.length; i = i + 1) {
			col[i] = matrix[i][j];
		}
		return col;
	}
	
	// Task 16
	// Assume map is a reasonable matrix for n cities
	public static int[][] noIllegalSteps(boolean[][] flights, int[][] map) {
		int n = map.length;
		
		// Count the number of cities that doesn't have a flight between them
		int size = 0;
		for (int from = 1; from < n; from = from + 1) {
			for (int to = 0; to < from; to = to + 1) {
				if (!flights[from][to]) {
					size = size + 2*n;
					if (to == 0) {
						size = size + 1;
					}
				}
			}
		}

		//create CNF
		int[][] cnf = new int [size][];
		int k = 0;
		for (int from = 1; from < n; from = from + 1) {
			for (int to = 0; to < from; to = to + 1) {
				if (!flights[from][to]) {
					// Add all clauses for the different step
					for (int step = 0; step < n; step = step + 1) {
						int[] clause1 = {-1 * map[step][from], -1 * map[(step+1)%n][to]};
						int[] clause2 = {-1 * map[step][to], -1 * map[(step+1)%n][from]};
						cnf[k] = clause1;
						cnf[k+1] = clause2;
						k = k + 2;
					}
					// If no flight to city 0, make sure it is not the last step
					if (to == 0) {
						int[] clause = {-1 * map[n-1][from]};
						cnf[k] = clause;
						k = k + 1;
					}
				}
			}
		}
		
		return cnf;
	}
	
	// Task 17
	// from input to CNF
	public static void encode(boolean[][] flights, int[][] map) {
		int n = map.length;
		
		// Check that the input is valid
		if (!isLegalInstance(flights) | !isSquareMatrix(map)) {
			throw new IllegalArgumentException ("illegal values or inputs");
		}
		//i saw this on
		//https://stackoverflow.com/questions/29202242/how-to-run-through-a-2d-array-with-a-single-loop
		for (int i = 0; i < n*n; i = i + 1) {
			int value = map[i/n][i%n];
			if(value <= 0 | value > n*n) {
				throw new IllegalArgumentException ("illegal values or inputs");
			}
		}

		// make sure input matches the big trip problem wanted structure
		SATSolver.addClauses(oneCityInEachStep(map));
		SATSolver.addClauses(fixSourceCity(map));
		SATSolver.addClauses(eachCityIsVisitedOnce(map));
		SATSolver.addClauses(noIllegalSteps(flights, map));
	}
	
	// Task 18
	// A conversion from the assignment, through the map, to a wanted output 
	public static int[] decode(boolean[] assignment, int[][] map) {
		int n = map.length;
		if (assignment.length != n*n + 1) {
			throw new IllegalArgumentException ("illegal assignment input");
		}
		int [] tour = new int[n];
		for (int i = 0; i < n; i = i + 1) {
			for (int j = 0; j < n; j = j + 1) {
				if (assignment[map[i][j]]) {
					tour[i] = j;		
				}
			}
		}
		return tour;
	}
	
	// Task 19
	// Find an actual solution for the big trip problem 
	public static int[] solve(boolean[][] flights) {
		int n = flights.length;
		if(!isLegalInstance(flights)) {
			throw new IllegalArgumentException("flights is not legal");
		}
		int [][] map = createVarsMap(n);
		
		// Use the SAT solver
		SATSolver.init(n*n);
		encode(flights, map);
		boolean[] assignment = SATSolver.getSolution() ;

		if (assignment == null) {
			throw new RuntimeException("TIMEOUT");
		}
		if (assignment.length == 0) {
			return null;
		}
		int[] tour = decode(assignment, map);
		if (isSolution(flights, tour)) {
			return tour;
		}
		else {
			throw new RuntimeException("UNSAT");
		}
	}
	
	/***
	 * @param flights adjacency matrix of cities
	 * @return whether there is at least 2 non-equivalent solutions for a instance of the the problem
	 */
	// Task 20
	public static boolean solve2(boolean[][] flights) {
		if (!isLegalInstance(flights)) {
			throw new IllegalArgumentException ("flights matrix input is...");
		}
		
		int n = flights.length;
		int[][] map = createVarsMap(n);

		//get 1st solution
		SATSolver.init(n*n);
		encode(flights, map);
		boolean[] assignment1 = SATSolver.getSolution();
		
		//check 1st solution
		if (assignment1 == null) {
			throw new RuntimeException("TIMEOUT");
		}
		else if (assignment1.length != n*n + 1) {
			return false;
		}
		if(!isSolution(flights, decode(assignment1,map))) {
			throw new RuntimeException("not a satisfying assignment");
		}
			
		//Calculate the equivalent assignment 
		boolean[] assignment1equivalent = new boolean[assignment1.length];
		for (int j = 0; j < n; j = j + 1) {
			assignment1equivalent[j+1] = assignment1[j+1];
		}
		for (int i = 1; i < n; i = i + 1) {
			for (int j = 0; j < n; j = j + 1) {
				assignment1equivalent[map[i][j]] = assignment1[map[n-i][j]];
			}
		}
		SATSolver.init(n*n);
		encode(flights,map);
		SATSolver.addClause(assignmentToClause(assignment1));
		SATSolver.addClause(assignmentToClause(assignment1equivalent));
		boolean[] assignment2 = SATSolver.getSolution();
		
		//check 2nd solution
		if (assignment2 == null) {
			throw new RuntimeException("TIMEOUT");
		}
		else if (assignment2.length != n*n + 1) {
			return false;
		}
		if (!isSolution(flights, decode(assignment2, map))) {
			throw new RuntimeException("not a satisfying assignment");
		}
		return true;
	}

	// Assisting function for Task 20
	public static int[] assignmentToClause(boolean[] assignment) {
		int[] clause = new int[assignment.length - 1];
		for (int i = 1; i < assignment.length; i = i + 1) {
			if (assignment[i]) {
				clause[i-1] = -1 * i;
			}
			else {
				clause[i-1] = i;
			}
		}
		return clause;
	}
}