import java.util.ArrayList;
import java.util.Scanner;
public class MorseCodeConverter
{
   private static MorseCodeTree tree1 = new MorseCodeTree();
   public MorseCodeConverter()
   {
   }
   public static java.lang.String convertToEnglish(java.lang.String code)
   {
       String finished = "";
       String[] input, case1; 
       input = code.split(" / ");
       for(int k = 0; k < input.length; k++)
       {  
    	   case1 = input[k].split(" ");
           for(int l = 0; l < case1.length; l++)
           {
        	   finished = finished + tree1.fetch(case1[l]);  
           }
           finished = finished + " ";
       }  
       finished = finished.trim();
       return finished;
   }
   public static java.lang.String printTree()
   {
       ArrayList<String> data = new ArrayList<String>();
       data = tree1.toArrayList();
       String output = "";
       for(int k = 0; k < data.size(); k ++)
       {
           output = output + data.get(k) + " ";  
       }
       return output;
   }
   public static java.lang.String convertToEnglish(java.io.File codeFile) throws java.io.FileNotFoundException
   {
       String outputString = "";
       ArrayList<String> arrList = new ArrayList<String>();
       String[] input, testCase;
       Scanner inputFile;
       inputFile = new Scanner(codeFile);
       while (inputFile.hasNext())
       {  
    	   arrList.add(inputFile.nextLine());
       }
          
       inputFile.close();
       for(int l = 0; l < arrList.size(); l++)
       {
           input = arrList.get(l).split(" / ");
           for(int m = 0; m < input.length; m++)
           {
        	   testCase = input[m].split(" ");
              
               for(int n = 0; n < testCase.length; n++)
               {
            	   outputString = outputString + tree1.fetch(testCase[n]);  
               }
               outputString = outputString + " ";
           }
       }
       outputString = outputString.trim();
       return outputString;
   }
   
}