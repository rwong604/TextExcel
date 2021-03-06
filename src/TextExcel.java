/**
 * TextExcel Project
 * @date 11/24/14
 * @author Rebecca
 * Meets Checkpoint: #1
 */
import java.util.*;

public class TextExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanIn=new Scanner(System.in);
		System.out.println("Welcome to TextExcel!");
//		System.out.print("Enter rows:");
//		int rows=input.nextInt();
//		System.out.print("Enter columns (up to 26):");
//		int columns=input.nextInt();
		CellMatrix matrix=new CellMatrix();
		System.out.print("Enter command (or \"help\" for help):");
		String userInput=scanIn.nextLine();
		while(!userInput.equalsIgnoreCase("exit")){
				checkInput(userInput, matrix);
				System.out.print("Enter command (or \"help\" for help):");
				userInput=scanIn.nextLine();
		}
		System.out.println("Exiting TextExcel");
		scanIn.close();
	}

	private static void checkInput(String input, CellMatrix matrix) {
		// TODO Auto-generated method stub
		String cellIdRegex="[A-G](10|[1-9])";
		if(input.equalsIgnoreCase("print"))
			CellMatrix.printSheet(matrix);
		else if(input.equalsIgnoreCase("help")){
			System.out.println("exit: exits TextExcel program");
			System.out.println("print: prints entire spreadsheet with values");
			System.out.println("[column][row]: returns input value of specified cell, i.e. A5");
			System.out.println("[column][row] = [data]: sets the value of specified cell, i.e. A5 = \"hello\" ");
		}
		else if(input.matches(cellIdRegex)){ //user: get command
			char cellAddrColumn=input.charAt(0);
			int cellAddrRow=Character.getNumericValue(input.charAt(1));
			System.out.println(input+" = "+matrix.getCell(cellAddrRow, cellAddrColumn));
		}
		else if(input.length()>5 && input.substring(0, 5).matches(cellIdRegex+" = ")){ //user: set command
			char cellAddrColumn=input.charAt(0);
			int cellAddrRow=Character.getNumericValue(input.charAt(1));
			String data=input.substring(5);
			matrix.setCell(cellAddrRow, cellAddrColumn, data);
		}
		else
			System.out.println("Not A Valid Input");
	}
	
}

