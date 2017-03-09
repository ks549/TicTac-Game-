package codility;

import java.util.HashMap;
import java.io.*;
class tictac{
	public static void main (String args[])throws Exception {
		String [][]a = { {"O", "X", "O", "."}, 
				 {"O", ".", ".", "."},
		                 {"X", ".", ".", "."},
		                 {"X", ".", ".", "."} };
		int n = a.length;
                int t = 0;
		HashMap<String,Integer> X = new HashMap<String,Integer>();
		HashMap<String,Integer> O = new HashMap<String,Integer>();
                X.put("horizontal", 0);
		O.put("horizontal", 0);
		X.put("vertical", 0);
		O.put("vertical", 0);
		X.put("diagonal1", 0);
		O.put("diagonal1", 0);
		X.put("diagonal2", 0);
		O.put("diagonal2", 0);
		String output = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				t = (a[i][j] == ".") ? t + 1 : t;
				if ((a[i][j] == "X") || (a[i][j] == "T"))
					X.put("horizontal", X.get("horizontal") + 1);
				else if ((a[i][j] == "O") || (a[i][j] == "T"))
					O.put("horizontal", O.get("horizontal") + 1);
				if ((a[j][i] == "X") || (a[i][j] == "T"))
					X.put("vertical", X.get("vertical") + 1);
				else if ((a[j][i] == "O") || (a[i][j] == "T"))
					O.put("vertical", O.get("vertical") + 1);
				if (i == j) {
					if ((a[i][j] == "X") || (a[i][j] == "T"))
						X.put("diagonal1", X.get("diagonal1") + 1);
					else if ((a[i][j] == "O") || (a[i][j] == "T"))
						O.put("diagonal1", O.get("diagonal1") + 1);
			}
			if (i + j == (n - 1)) {
				if ((a[i][j] == "X") || (a[i][j] == "T"))
					X.put("diagonal2", X.get("diagonal2") + 1);
				else if ((a[i][j] == "O") || (a[i][j] == "T"))
					O.put("diagonal2", O.get("diagonal2") + 1);
			}
     		}
		if (X.containsValue(4)) {
			output = "X won";
			break;
		}
		if (O.containsValue(4)) {
			output = "O won";
			break;
		}
		X.put("horizontal", 0);
		O.put("horizontal", 0);	
		X.put("vertical", 0);
		O.put("vertical", 0);	
		}

		if ((output == "X won") || (output == "O won"))
			output = output;
		else if (t > 0)
			output = "Game is incomplete";
		else if (t == 0)
			output = "draw";
		System.out.println(output);
	}
}
