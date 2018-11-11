import java.util.Random;
import java.util.ArrayList;

public class Sudoku {

	private int[][] board;

public Sudoku() {
		
	this.board = new int[9][9];
	
	for(int i=0; i<9; i++) {
		
		for(int j =0; j<9; j++) {	
		
			this.board[i][j] = (3*i + i/3 + j) % 9 + 1;
			
		}
		
		
	}
	
	
	}

public Sudoku(int n) {
	
	Sudoku result = new Sudoku();
	
	this.board = new int[9][9];
	
	if(n==0) {
	
	result.randomRow();
	
	}
	
	else {
		
		result.randomPermutation(n);
		
	}
	
	for(int i=0; i<9; i++) {
		
		for(int j=0; j<9; j++) {
		
		this.board[i][j] = result.board[i][j];
		
	}
		
	}
	
	
}


	public String toString() {
		
		String output = "";
		
		output += "-------------------------\r";
		
		for(int i=0; i<9; i++) {
			
			if(i==3 || i==6) {
				
				output += "-------------------------\r| ";
				
			}
			
			else {
				
				output += "| ";
				
			}
			
			for(int j=0; j<9; j++) {
				
				if(j==2 || j==5 || j==8) {
					
					if(this.board[i][j] == 0) {
					
					output += " " + " | ";
					
					}
					
					else {
						
						output += this.board[i][j] + " | ";
						
					}
					
				}
				
				else {
					
					if(this.board[i][j]==0) {
					
					output += " " + " ";
					
					}
					
					else {
						
						output += this.board[i][j] + " ";
						
					}
					
				}
				
			}
			
			output += "\r";
			
		}
		
		output += "-------------------------";
		
		return output;
		
	}
	
	
	public static boolean randomBool() {
		
		return Math.random() < 0.5;
		
	}
	
	public Sudoku changeValues(int a, int b) {
		
		Sudoku result = new Sudoku();
		
		for(int i=0; i<result.board.length; i++) {
			
			for(int j=0; j<result.board.length; j++) {
				
				
				if(result.board[i][j] == a ) {
					
					result.board[i][j] = b;
					
					
					
				}
				
				else if(result.board[i][j] == b) {
					
					result.board[i][j] = a;
					
				}
				
			}
			
			
			
		}
		
		
		return result;
		
		
	}
	
	
	public void permutateColumns(int a, int b) {

		
		int[] copy_a = new int[9];
		
		if((a==0 && b==1) || (a==1 && b==0) || (a==0 && b==2) || (a==2 && b==0) || (a==1 && b==2) || (a==2 && b==1) || (a==3 && b==4) || (a==4 && b==3) || (a==3 && b==5) || (a==5 && b==3) || (a==4 && b==5) || (a==5 && b==4) || (a==6 && b==8) || (a==8 && b==6) || (a==6 && b==7) || (a==7 && b==6) || (a==7 && b==8) || (a==8 && b==7)) {
			
		for(int j=0; j<9; j++) {
			
			copy_a[j] = this.board[j][a];
			
			this.board[j][a] = this.board[j][b];
			
			this.board[j][b] = copy_a[j];
			
		}
		}
		
		
	}
	
	public void permutateRows(int a, int b) {
		

		
		int[] copy_a = new int[9];
	
		
		if((a==0 && b==1) || (a==1 && b==0) || (a==0 && b==2) || (a==2 && b==0) || (a==1 && b==2) || (a==2 && b==1) || (a==3 && b==4) || (a==4 && b==3) || (a==3 && b==5) || (a==5 && b==3) || (a==4 && b==5) || (a==5 && b==4) || (a==6 && b==8) || (a==8 && b==6) || (a==6 && b==7) || (a==7 && b==6) || (a==7 && b==8) || (a==8 && b==7)) {

		
		for(int j=0; j<9; j++) {
			
			copy_a[j] = this.board[a][j];
			
			this.board[a][j] = this.board[b][j];
			
			this.board[b][j] = copy_a[j];
			
			
		}
		
		}
		
		
	}
	
	public void permutateRows() {
		
		Random rand = new Random();
		
		int random_parameter1 = rand.nextInt(8); 
		
		int random_parameter2 = rand.nextInt(8);
		
		permutateRows(random_parameter1, random_parameter2);
		
	}
	
	public void permutateColumns() {
		
		Random rand = new Random();
		
		int random_parameter1 = rand.nextInt(8);
		
		int random_parameter2 = rand.nextInt(8);
		
		permutateColumns(random_parameter1, random_parameter2);
		
	}
	
	public void permutateStack() {
		
		Random rand = new Random();
		
		int random_parameter1 = rand.nextInt((3-1)) + 1;
		
		int random_parameter2 = rand.nextInt((3-1)) + 1;
		
		permutateStack(random_parameter1, random_parameter2);
	
		
	}
	
	public void permutateBand() {
		
		Random rand = new Random();
		
		int random_parameter1 = rand.nextInt((3-1)) + 1;
		
		int random_parameter2 = rand.nextInt((3-1)) + 1;
		
		permutateBand(random_parameter1, random_parameter2);
		
		
	}
	
	public void randomPermutation() {
		
		Random rand = new Random();
		
		int random_parameter = rand.nextInt(4-1) + 1;
		
		switch(random_parameter) {
		
		case 1: {
			
			permutateRows();
			
		}
		
		case 2: {
			
			permutateColumns();
			
		}
		
		case 3: {
			
			permutateStack();
			
		}
		
		case 4: {
			
			permutateBand();
			
		}
		
		}
		
		
	}
	
	public void randomPermutation(int n) {
		
		int counter = 1;
		
		for(counter=1; counter<=n; counter++) {
			
			randomPermutation();
			
		}
	
		
	}
	
	public void permutateStack(int a, int b) {
		
		
		if((a==1 && b==2) || (a==2 && b==1)) {
			
			int[] copy_a = new int[9];
			
			
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[j][0];
				
				this.board[j][0] = this.board[j][3];
				
				this.board[j][3] = copy_a[j];
				
			}
			
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[j][1];
				
				this.board[j][1] = this.board[j][4];
				
				this.board[j][4] = copy_a[j];
				
			}
			
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[j][2];
				
				this.board[j][2] = this.board[j][5];
				
				this.board[j][5] = copy_a[j];
				
			}
			
		}
		
		else if((a==1 && b==3) || (a==3 && b==1)) {
			
			int[] copy_a = new int[9];
			
			
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[j][0];
				
				this.board[j][0] = this.board[j][6];
				
				this.board[j][6] = copy_a[j];
				
			}
			
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[j][1];
				
				this.board[j][1] = this.board[j][7];
				
				this.board[j][7] = copy_a[j];
				
			}
			
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[j][2];
				
				this.board[j][2] = this.board[j][8];
				
				this.board[j][8] = copy_a[j];
				
			}
		}
		
		else if((a==2 && b==3) || (a==3 && b==2)) {
			
			int[] copy_a = new int[9];
			
			
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[j][3];
				
				this.board[j][3] = this.board[j][6];
				
				this.board[j][6] = copy_a[j];
				
			}
			
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[j][4];
				
				this.board[j][4] = this.board[j][7];
				
				this.board[j][7] = copy_a[j];
				
			}
			
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[j][5];
				
				this.board[j][5] = this.board[j][8];
				
				this.board[j][8] = copy_a[j];
				
			}
		}
		
		else if(a==b) {
			this.board = this.board;
		}
		
		
		
	}
	
	
	public void permutateBand(int a, int b) {
		
		
	if((a==1 && b==2) || (a==2 && b==1)) {
			
			int[] copy_a = new int[9];
			
						
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[0][j];
				
				this.board[0][j] = this.board[3][j];
				
				this.board[3][j] = copy_a[j];
				
				
			}
			
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[1][j];
				
				this.board[1][j] = this.board[4][j];
				
				this.board[4][j] = copy_a[j];
				
				
			}
			
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[2][j];
				
				this.board[2][j] = this.board[5][j];
				
				this.board[5][j] = copy_a[j];
				
				
			}
			
			
		}
		
		else if((a==1 && b==3) || (a==3 && b==1)) {
			
			int[] copy_a = new int[9];
			
			
				for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[0][j];
				
				this.board[0][j] = this.board[6][j];
				
				this.board[6][j] = copy_a[j];
				
				
			}
				
				for(int j=0; j<9; j++) {
					
					copy_a[j] = this.board[1][j];
					
					this.board[1][j] = this.board[7][j];
					
					this.board[7][j] = copy_a[j];
					
					
				}
				
				for(int j=0; j<9; j++) {
					
					copy_a[j] = this.board[2][j];
					
					this.board[2][j] = this.board[8][j];
					
					this.board[8][j] = copy_a[j];
					
					
				}
		}
		
		else if((a==2 && b==3) || (a==3 && b==2)) {
			
			int[] copy_a = new int[9];
			
			
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[3][j];
				
				this.board[3][j] = this.board[6][j];
				
				this.board[6][j] = copy_a[j];
				
				
			}
			
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[4][j];
				
				this.board[4][j] = this.board[7][j];
				
				this.board[7][j] = copy_a[j];
				
				
			}
			
			for(int j=0; j<9; j++) {
				
				copy_a[j] = this.board[5][j];
				
				this.board[5][j] = this.board[8][j];
				
				this.board[8][j] = copy_a[j];
				
				
			}
		}
	
		else if(a==b) {
			this.board = this.board;
		}
		
		
	}
	
	public void transpose() {
		
		Sudoku copy = new Sudoku();
		
		for(int i=0; i<9; i++) {
			
			for(int j=0; j<9; j++) {
				
				 {
					
					this.board[i][j] = copy.board[j][i];
					
					this.board[j][i] = copy.board[i][j];
										
				}
				
			}
			
		}
		
		for(int i=0; i<9; i++) {
				
				this.board[i][i] = copy.board[8-i][8-i];
				
				this.board[8-i][8-i] = copy.board[i][i];
				
			}
		
	}
	
	public void randomRow() {
		
		
		Random rand = new Random();
		
		int random_parameter = rand.nextInt(362880) + 1;
		
		for(int i=1; i<=random_parameter; i++) {
			
			randomPermutation();
				
			}
		
	}
	
	
	public void hide(int n) {
		
		int counter = 0;
		
		boolean wipe;
		
		for(int i=0; i<9; i++) {
			
			for(int j=0; j<9; j++) {
				
				wipe = randomBool();
				
				if(wipe && counter <=n) {
					
					this.board[i][j] = 0;
					
					counter++;
					
				}
				
				else {
					
					counter++;
				}
				
			}
			
		}

	}
	

	public static void main(String[] args) {
		
	//	Sudoku test = new Sudoku();
		
	//	System.out.println(test.hide(80).toString());
		
	//	Sudoku test3 = test.permutateColumns(1, 5);
		
	//	System.out.println(test3.toString());
		
	//	Sudoku test4 = test.permutateRows(1, 2);
		
	//	System.out.println(test4.toString());
		
	//	 test.permutateRows(7,8);
		
	//	System.out.println(test.toString());
		
	//	Sudoku test6 = test.permutateColumns();
		
	//	System.out.println(test6.toString());
		
	//	Sudoku test7 = test.permutateStack(2, 2);
		
	//	System.out.println(test7.toString());
		
	//	Sudoku test8 = test.permutateBand(2, 2);
		
	//	System.out.println(test8.toString());
		
	//	Sudoku test9 = test.permutateStack();
		
	//	System.out.println(test9.toString());
		
	//	Sudoku test10 = test.permutateBand();
		
	//	System.out.println(test10.toString());

	//	Sudoku test11 = test.randomPermutation();
		
	//	System.out.println(test11.toString());
		
	//	Sudoku test12 = test.randomPermutation(3);
		
	//	System.out.println(test12.toString());
		
	//	Sudoku test13 = new Sudoku(2);
		
	//	System.out.println(test13.toString());
		
	//	test.permutateBand(2,3);
		
	//	test.permutateRows(4,5);
		
	//	test.randomPermutation(10);
		
	//	System.out.println(test.toString());
		
		Sudoku last_test = new Sudoku(0);
		
	//	last_test.permutateColumns();
		
		last_test.hide(80);
		
	//	last_test.permutateStack();
		
		System.out.println(last_test);
		
	//	Sudoku test_again = new Sudoku();
		
	//	test_again.randomRow();
	
	//	System.out.println(test_again);
		
	//	Sudoku transpose_test = new Sudoku();
		
	//	System.out.println(transpose_test);
		
	//	transpose_test.transpose();
		
	//	System.out.println(transpose_test);
		
	}

}
	
	
