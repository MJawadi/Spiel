import java.util.*;
public class Othello {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
				
		int[][] table = new int[8][8];
		boolean check = true;
		int player1=1, player2=2;
		
		
		
		//table[4][7]=2;
		table[3][3]=1;
		//table[4][4]=1;
		table[3][4]=1;
		table[2][4]=2;
		table[4][2]=1;
		table[3][2]=2;
		//table[5][4]=2;
		//table[3][2]=2;
		
		while(true) {
			
			int[][] playerInput2 = new int[8][8];
			int[][] playerInput1 = new int[8][8];
			
			checkPosiblePlaces(table, player2);
			print(table);
			System.out.println("Go X-->");
			getInput(playerInput2, player2);
			if(checkForEmpty(check, table, playerInput2)) {
				rules(table, playerInput2, player2);
			}else {
				System.out.println("error");
			}
			
			checkPosiblePlaces(table, player1);
			print(table);
			System.out.println("Go O-->");
			getInput(playerInput1, player1);
			if(checkForEmpty(check, table, playerInput1)) {
				rules(table, playerInput1, player1);
			}else {
				System.out.println("error");
			}
			
			
		}

		
	}
	
	
	private static int[][] getInput(int[][] entery, int player){
		
		
		System.out.print("A-H-->: ");
		char x = scan.next().charAt(0);
		int get = 0;
		
		switch(x) {
			case 'a':
				get=0;
				break;
			case 'b':
				get=1;
				break;
			case 'c':
				get=2;
				break;
			case 'd':
				get=3;
				break;
			case 'e':
				get=4;
				break;
			case 'f':
				get=5;
				break;
			case 'g':
				get=6;
				break;
			case 'h':
				get=7;
				break;
			default:
				break;
		}
		System.out.print("1-8-->: ");
		int y = scan.nextInt();
		entery[get][y-1]= player;
		System.out.println(get +" "+ (y-1));
		return entery;
		
	}
	
	
	
	private static int[][] rules(int[][] cells, int[][] playerIn, int player){
		
		int otherPlayer = 1;
		if(player==1) {
			otherPlayer=2;
		}
		
		for(int x=0; x<cells.length; x++) {
			for(int y=0; y<cells.length; y++) {
				
				if(playerIn[x][y]==player) {
					
					
				}
			}
		}
		
		return cells;
		
	}

	
	
	private static int[][] allDir(int[][] cells, int x, int y, int player, boolean found) {

		
		int otherPlayer = 1;
		if(player==1) {
			otherPlayer=2;
		}
		int up = x;
		int down = x;
		int right = y;
		int left = y;
		boolean go = true;
		int count = 0;
		while(up!=0 || down!=cells.length || right!=cells.length || left!=0) {
			
			if(up!=0) {
				up--;
			}
			if(left!=0) {
				left--;
			}
			if(right!=cells.length) {
				right++;
			}
			if(down!=cells.length) {
				down++;
			}
			
			
			if(cells[up][y]==player) {
				found = true;
				break;
			}else {
				if(cells[down][y]==player){
					
				}
			}
			if(cells[x][right]==otherPlayer) {
				
			}else {
				if(cells[x][left]==otherPlayer) {
					
				}
			}
			if(cells[up][left]==otherPlayer) {
				
			}else {
				if(cells[up][right]==otherPlayer) {
					
				}
			}
			if(cells[down][left]==otherPlayer) {
				
			}else {
				if(cells[down][right]==otherPlayer) {
					
				}
			}
			
		}
		return cells;
		
	}
	
	//private static int[][] turnCells(int[][] cells, )


	public static boolean checkForEmpty(boolean result, int[][] cells, int[][] player){
		
		
		
		for(int x=0; x<cells.length; x++) {
			for(int y=0; y<cells.length; y++) {
				if((player[x][y]==1 || player[x][y]==2) && (cells[x][y]==1 || cells[x][y]==2)) {
					result = false;
					System.out.println("\n\tThis place is not empty!!! plase take another one!!");
					break;
				}
				if((player[x][y]==1 || player[x][y]==2) && cells[x][y]!=3) {
					System.out.println("Wrong Place!!!");
					result = false;
					break;
				}
			}
		}
		
		return result;
	}
	
	
	
	public static int[][] checkPosiblePlaces(int[][] cells, int player) {
		
		int player2=1;
		
		if(player==1) {
			player2=2;
		}
		
		for(int r=0; r<cells.length; r++) {
			for(int u=0; u<cells.length; u++) {
				if(cells[r][u]==3) {
					cells[r][u]=0;
				}
			}
		}
		
		
		
		for(int x=0; x<cells.length; x++) {
			for(int y=0; y<cells.length; y++) {
				if((x>0 && x<7) && (y>0 && y<7)) {
					
					if(cells[x][y]==player2) {
						for(int a=x-1; a<x+2; a++) {
							for(int b=y-1; b<y+2; b++) {
								if(cells[a][b]==0) {
									cells[a][b]=3;
								}
							}
						}
					}
				}else {
					if(cells[x][y]==player2) {
						if(x==0 && y==0) {
							for(int s=x; s<x+2; s++) {
								for(int j=y; j<y+2; j++) {
									if(cells[s][j]==0) {
										cells[s][j]=3;
									}
								}
							}
						}
						if(x==0 && y==7) {
							for(int s=x; s<x+2; s++) {
								for(int j=y-1; j<y+1; j++) {
									if(cells[s][j]==0) {
										cells[s][j]=3;
									}
								}
							}
						}
						if(x==7 && y==0) {
							for(int s=x-1; s<x+1; s++) {
								for(int j=y; j<y+2; j++) {
									if(cells[s][j]==0) {
										cells[s][j]=3;
									}
								}
							}
						}
						if(x==7 && y==7) {
							for(int s=x-1; s<x+1; s++) {
								for(int j=y-1; j<y+1; j++) {
									if(cells[s][j]==0) {
										cells[s][j]=3;
									}
								}
							}
						}
						if(x==0 && (y>=1 && y<=6)) {
							for(int u=x; u<x+2; u++) {
								for(int b=y-1; b<y+2; b++) {
									if(cells[u][b]==0) {
										cells[u][b]=3;
									}
								}
							}
						}
						if(x==7 && (y>=1 && y<=6)) {
							for(int u=x-1; u<x+1; u++) {
								for(int b=y-1; b<y+2; b++) {
									if(cells[u][b]==0) {
										cells[u][b]=3;
									}
								}
							}
						}
						if((x>=1 && x<=6) && y==0) {
							for(int u=x-1; u<x+2; u++) {
								for(int b=y; b<y+2; b++) {
									if(cells[u][b]==0) {
										cells[u][b]=3;
									}
								}
							}
						}
						if((x>=1 && x<=6) && y==7) {
							for(int u=x-1; u<x+2; u++) {
								for(int b=y-1; b<y+1; b++) {
									if(cells[u][b]==0) {
										cells[u][b]=3;
									}
								}
							}
						}
					}
				}
			}
		}
		
		
		return cells;
	}
	
	
	
	public static void print(int[][] cells){
		
		
		
		int player1=1, player2=2;
		char word = 'A';
		System.out.println("\n\t\tOthello Game Boeard by M.Jawadi");
		System.out.println("\t_____________________________________________________");
		System.out.println("\t| * |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |");
		System.out.println("\t|———————————————————————————————————————————————————|");
		for(int x=0; x<8; x++) {
			System.out.print("\t| "+word +" |  ");
			word +=1;
			for(int y=0; y<8; y++) {
				if(cells[x][y]==player1) {
					System.out.print("O");
				}else {
					if(cells[x][y]==player2) {
						System.out.print("X");
					}else {
						if(cells[x][y]==3) {
							System.out.print("+");
						}else {
							System.out.print(".");
						}
					}
				}
				
				System.out.print("  |  ");
			}
			System.out.print("\n\t|———————————————————————————————————————————————————|");
			System.out.print("\n");
		}
		
		
	}

}
