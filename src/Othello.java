import java.util.*;
public class Othello {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
				
		int[][] table = new int[8][8];
		
		int player1=1, player2=2;
		int[][] playerInput = new int [8][8];
		
		boolean check = true;
		/*
		System.out.print("X-->: ");
		int X= scan.nextInt();
		System.out.print("Y-->: ");
		int Y= scan.nextInt();
		*/
		
		
		table[3][3]=1;
		table[4][4]=1;
		//table[3][1]=1;
		table[3][4]=2;
		table[4][3]=2;
		//table[4][6]=1;
		//table[4][7]=2;
		//table[3][2]=2;
		playerInput[1][3]= 2;
		
		checkPosiblePlaces(table, player2);
		if(checkForEmpty(check, table, playerInput)) {
			rules(table, playerInput, player2);
		}else {
			table[1][3]=0;
		}
		print(table);
		
		
	}
	
	
	
	public static int[][] rules(int[][] cells, int[][] playerIn, int player){
		
		
		int[][] temp = new int[8][8];
		temp = cells;
		
		int otherPlayer = 1;
		if(player==1) {
			otherPlayer=2;
		}
		
		
		for(int x=0; x<temp.length; x++) {
			for(int y=0; y<temp.length; y++) {
				
				if(playerIn[x][y]!=0) {
					temp[x][y] = playerIn[x][y];
					if((x>0 && x<7) && (y>0 && y<7)) {
						for(int j=x-1; j<x+2; j++) {
							for(int s=y-1; s<y+2; s++) {
								if(temp[j][s]==otherPlayer) {
									if(j==x && s<y) {
										temp[j][s]= playerIn[x][y];
										int left = s;
										while(left!=0) {
											left--;
											if(temp[j][left]==otherPlayer) {
												temp[j][left]=playerIn[x][y];
											}
											if(temp[j][left]==playerIn[x][y]) {
												return temp;
											}
										}
									}
									
									if(j==x && s>y) {
										temp[j][s]= playerIn[x][y];
										int right = s;
										while(right!=7) {
											right++;
											if(temp[j][right]==otherPlayer) {
												temp[j][right]=playerIn[x][y];
											}
											if(temp[j][right]==playerIn[x][y]) {
												return temp;
											}
										}
									}
									
									if(j<x && s==y) {
										temp[j][s]= playerIn[x][y];
										int up = j;
										while(up!=0) {
											up--;
											if(temp[j][up]==otherPlayer) {
												temp[j][up]=playerIn[x][y];
											}
											if(temp[j][up]==playerIn[x][y]) {
												return temp;
											}
										}
									}
									
									if(j>x && s==y) {
										temp[j][s]= playerIn[x][y];
										int down = j;
										while(down!=7) {
											down++;
											if(temp[j][down]==otherPlayer) {
												temp[j][down]=playerIn[x][y];
											}
											if(temp[j][down]==playerIn[x][y]) {
												return temp;
											}
										}
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
