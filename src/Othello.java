import java.util.*;
public class Othello {
	
	public static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int horizontal=8, vertical=8;
		
		char[][] playerInput = new char[horizontal][vertical];
		char[][] table = new char[horizontal][vertical];
		boolean check = false;
		char player1='X', player2='O';
		
		
		
		//table[4][7]=2;
		table[3][3]='X';
		table[4][4]='X';
		table[3][4]='O';
		//table[2][4]='X';
		table[4][3]='O';
		//table[3][2]='+';
		//table[5][4]=2;
		//table[3][2]=2;
		
		
		;
		print(checkPosiblePlaces(table, player1));

		
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
	

	
	private static char[][] upDir(char[][] cells, int x, int y, char player) {

		char otherPlayer = 'O';
		if(player=='O') {
			otherPlayer='X';
		}
		
		char[][] temp = new char[cells.length][cells.length];
		int up = x;
		int foundUp=0;
		boolean getSecond = false;
		while(up!=0) {
			
			if(getSecond==false && cells[up][y]==player) {
				foundUp=1;
				temp[up][y]=player;
			}
			if(foundUp==1) {
				if(cells[up][y]==otherPlayer) {
					getSecond = true;
					temp[up][y]=player;
				}
			}
			if(getSecond) {
				if(cells[up][y]==player) {
					foundUp=3;
					temp[up][y]=player;
					copyToAnother(cells, temp);
				}
			}
			
			if(up!=0) {
				up--;
			}
		}
		return cells;
	}
	
	private static char[][] downDir(char[][] cells, int x, int y, char player) {

		char otherPlayer = 'O';
		if(player=='O') {
			otherPlayer='X';
		}
		
		char[][] temp = new char[cells.length][cells.length];
		int down = x;
		int foundUp=0;
		boolean getSecond = false;
		while(down!=cells.length) {
			
			if(getSecond==false && cells[down][y]==player) {
				foundUp=1;
				temp[down][y]=player;
			}
			if(foundUp==1) {
				if(cells[down][y]==otherPlayer) {
					getSecond = true;
					temp[down][y]=player;
				}
			}
			if(getSecond) {
				if(cells[down][y]==player) {
					foundUp=3;
					temp[down][y]=player;
					copyToAnother(cells, temp);
				}
			}
			if(down!=cells.length) {
				down++;
			}
		}
		return cells;	
	}
	
	private static char[][] leftDir(char[][] cells, int x, int y, char player) {

		char otherPlayer = 'O';
		if(player=='O') {
			otherPlayer='X';
		}
		
		char[][] temp = new char[cells.length][cells.length];
		int left = y;
		int foundUp=0;
		boolean getSecond = false;
		while(left!=0) {
			
			if(getSecond==false && cells[x][left]==player) {
				foundUp=1;
				temp[x][left]=player;
			}
			if(foundUp==1) {
				if(cells[x][left]==otherPlayer) {
					getSecond = true;
					temp[x][left]=player;
				}
			}
			if(getSecond) {
				if(cells[x][left]==player) {
					foundUp=3;
					temp[x][left]=player;
					copyToAnother(cells, temp);
				}
			}
			if(left!=0) {
				left--;
			}
		}
		return cells;
		
	}
		
	private static char[][] rightDir(char[][] cells, int x, int y, char player) {

		char otherPlayer = 'O';
		if(player=='O') {
			otherPlayer='X';
		}
		
		char[][] temp = new char[cells.length][cells.length];
		int right = y;
		int foundUp=0;
		boolean getSecond = false;
		while(right!=cells.length) {
			
			if(getSecond==false && cells[x][right]==player) {
				foundUp=1;
				temp[x][right]=player;
			}
			if(foundUp==1) {
				if(cells[x][right]==otherPlayer) {
					getSecond = true;
					temp[x][right]=player;
				}
			}
			if(getSecond) {
				if(cells[x][right]==player) {
					foundUp=3;
					temp[x][right]=player;
					copyToAnother(cells, temp);
				}
			}
			if(right!=cells.length) {
				right++;
			}
		}
		return cells;
		
	}
	
	private static char[][] upLeftDir(char[][] cells, int x, int y, char player) {

		char otherPlayer = 'O';
		if(player=='O') {
			otherPlayer='X';
		}
		
		char[][] temp = new char[cells.length][cells.length];
		int up = x;
		int left = y;
		int foundUp=0;
		boolean getSecond = false;
		
		while(up!=0 || left!=0) {
			
			if(getSecond==false && cells[up][left]==player) {
				foundUp=1;
				temp[up][left]=player;
			}
			if(foundUp==1) {
				if(cells[up][left]==otherPlayer) {
					getSecond = true;
					temp[up][left]=player;
				}
			}
			if(getSecond) {
				if(cells[up][left]==player) {
					foundUp=3;
					temp[up][left]=player;
					copyToAnother(cells, temp);
				}
			}
			if(up!=0) {
				up--;
			}
			if(left!=0) {
				left--;
			}
		}
		return cells;
		
	}
	
	private static char[][] upRightDir(char[][] cells, int x, int y, char player) {

		char otherPlayer = 'O';
		if(player=='O') {
			otherPlayer='X';
		}
		
		char[][] temp = new char[cells.length][cells.length];
		int up = x;
		int right = y;
		int foundUp=0;
		boolean getSecond = false;
		while(up!=0 || right!=cells.length) {
			
			if(getSecond==false && cells[up][right]==player) {
				foundUp=1;
				temp[up][right]=player;
			}
			if(foundUp==1) {
				if(cells[up][right]==otherPlayer) {
					getSecond = true;
					temp[up][right]=player;
				}
			}
			if(getSecond) {
				if(cells[up][right]==player) {
					foundUp=3;
					temp[up][right]=player;
					copyToAnother(cells, temp);
				}
			}
			if(up!=0) {
				up--;
			}
			if(right!=cells.length) {
				right++;
			}
		}
		return cells;
	}
	
	private static char[][] downLeftDir(char[][] cells, int x, int y, char player) {

		char otherPlayer = 'O';
		if(player=='O') {
			otherPlayer='X';
		}
		
		char[][] temp = new char[cells.length][cells.length];
		int down = x;
		int left = y;
		int foundUp=0;
		boolean getSecond = false;
		while(down!=cells.length || left!=0) {
			
			if(getSecond==false && cells[down][left]==player) {
				foundUp=1;
				temp[down][left]=player;
			}
			if(foundUp==1) {
				if(cells[down][left]==otherPlayer) {
					getSecond = true;
					temp[down][left]=player;
				}
			}
			if(getSecond) {
				if(cells[down][left]==player) {
					foundUp=3;
					temp[down][left]=player;
					copyToAnother(cells, temp);
				}
			}
			if(left!=0) {
				left--;
			}
			if(down!=cells.length) {
				down++;
			}
		}
		return cells;
		
	}
	
	private static char[][] downRightDir(char[][] cells, int x, int y, char player) {

		char otherPlayer = 'O';
		if(player=='O') {
			otherPlayer='X';
		}
		char[][] temp = new char[cells.length][cells.length];
		int down = x;
		int right = y;
		int foundUp=0;
		boolean getSecond = false;
		while(down!=cells.length || right!=cells.length) {
			
			if(getSecond==false && cells[down][right]==player) {
				foundUp=1;
				temp[down][right]=player;
			}
			if(foundUp==1) {
				if(cells[down][right]==otherPlayer) {
					getSecond = true;
					temp[down][right]=player;
				}
			}
			if(getSecond) {
				if(cells[down][right]==player) {
					foundUp=3;
					temp[down][right]=player;
					copyToAnother(cells, temp);
				}
			}
			if(right!=cells.length) {
				right++;
			}
			if(down!=cells.length) {
				down++;
			}
		}
		return cells;
	}


	public static boolean checkForEmpty(boolean result, char[][] cells, char[][] player){
		
		for(int x=0; x<cells.length; x++) {
			for(int y=0; y<cells.length; y++) {
				if((player[x][y]=='X' || player[x][y]=='O') && (cells[x][y]=='X' || cells[x][y]=='O')) {
					result = false;
					System.out.println("\n\tThis place is not empty!!! plase take another one!!");
					break;
				}
				if((player[x][y]=='X' || player[x][y]=='O') && cells[x][y]!='+') {
					System.out.println("Wrong Place!!!");
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	
	public static char[][] checkPosiblePlaces(char[][] cells, char player) {
		
		char otherPlayer = 'O';
		if(player=='O') {
			otherPlayer='X';
		}
		
		for(int l=0; l<cells.length; l++) {
			for(int w=0; w<cells.length; w++) {
				if(cells[l][w]=='+') {
					cells[l][w]=' ';
				}
			}
		}
		
		for(int x=0; x<cells.length; x++) {
			for(int y=0; y<cells.length; y++) {
				if((x>0 && x<cells.length-1) && (y>0 && y<cells.length-1)) {
					
					if(cells[x][y]==otherPlayer) {
						for(int a=x-1; a<x+2; a++) {
							for(int b=y-1; b<y+2; b++) {
								if(cells[a][b]==' ') {
									cells[a][b]='+';
								}
							}
						}
					}
				}else {
					if(cells[x][y]==otherPlayer) {
						if(x==0 && y==0) {
							for(int s=x; s<x+2; s++) {
								for(int j=y; j<y+2; j++) {
									if(cells[s][j]==' ') {
										cells[s][j]='+';
									}
								}
							}
						}
						if(x==0 && y==cells.length) {
							for(int s=x; s<x+2; s++) {
								for(int j=y-1; j<y+1; j++) {
									if(cells[s][j]==' ') {
										cells[s][j]='+';
									}
								}
							}
						}
						if(x==cells.length && y==0) {
							for(int s=x-1; s<x+1; s++) {
								for(int j=y; j<y+2; j++) {
									if(cells[s][j]==' ') {
										cells[s][j]='+';
									}
								}
							}
						}
						if(x==cells.length && y==cells.length) {
							for(int s=x-1; s<x+1; s++) {
								for(int j=y-1; j<y+1; j++) {
									if(cells[s][j]==' ') {
										cells[s][j]='+';
									}
								}
							}
						}
						if(x==0 && (y>0 && y<cells.length)) {
							for(int u=x; u<x+2; u++) {
								for(int b=y-1; b<y+2; b++) {
									if(cells[u][b]==' ') {
										cells[u][b]='+';
									}
								}
							}
						}
						if(x==cells.length && (y>0 && y<cells.length)) {
							for(int u=x-1; u<x+1; u++) {
								for(int b=y-1; b<y+2; b++) {
									if(cells[u][b]==' ') {
										cells[u][b]='+';
									}
								}
							}
						}
						if((x>0 && x<cells.length) && y==0) {
							for(int u=x-1; u<x+2; u++) {
								for(int b=y; b<y+2; b++) {
									if(cells[u][b]==' ') {
										cells[u][b]='+';
									}
								}
							}
						}
						if((x>0 && x<cells.length) && y==cells.length) {
							for(int u=x-1; u<x+2; u++) {
								for(int b=y-1; b<y+1; b++) {
									if(cells[u][b]==' ') {
										cells[u][b]='+';
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
	
	
	public static char[][] copyToAnother(char[][] cells, char[][] temporary){
		
		for(int x=0; x<cells.length; x++) {
			for(int y=0; y<cells.length; y++) {
				cells[x][y]=temporary[x][y];
			}
		}
		return cells;
	}
	
	
	private static void print(char[][] cells){
		
		char word = 'A';
		System.out.println("\n\t\tOthello Game Boeard by M.Jawadi");
		System.out.println("\t_____________________________________________________");
		System.out.println("\t| * |  1  |  2  |  3  |  4  |  5  |  6  |  7  |  8  |");
		System.out.println("\t|———————————————————————————————————————————————————|");
		
		for(int x=0; x<8; x++) {
			System.out.print("\t| "+word +" |  ");
			word +=1;
			for(int y=0; y<8; y++) {
				
				System.out.print(cells[x][y]);
				
				System.out.print("  |  ");
			}
			System.out.print("\n\t|———————————————————————————————————————————————————|");
			System.out.print("\n");
		}
	}

}
