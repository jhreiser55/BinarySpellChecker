import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
public class main{
	public static void main(String args[]) throws IOException {
		BinarySearchTree tree = new BinarySearchTree();
		try {
			BufferedReader br = new BufferedReader(new FileReader("words.txt"));
			String line = "";
			while((line = br.readLine()) != null){
				tree.insert(line);
			}
		} catch (IOException e){
			System.out.println("Please enter a valid file");
		}
		System.out.println("Loaded the words into a tree with height = " + tree.height(tree.getRoot()));	
	
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a word or phrase to check if you can spell!");
		String[] input = s.next().split(" ");
		if(input[0] == "END"){
			System.exit(0);
		}

		for(int i = 0; i < input.length; i++){
			if(tree.searchAt(input[i],tree.getRoot()) == null){
				System.out.println(input[i] + " is spelled wrong!");
			}	
		}
	}
}
