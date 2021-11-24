import java.util.ArrayList;
public class MorseCodeTree implements LinkedConverterTreeInterface<java.lang.String>
{
   private TreeNode<String> root = null;
   private String l1;
   public MorseCodeTree()
   {
       buildTree();
   }
   @Override
   public MorseCodeTree insert(java.lang.String code, java.lang.String letter)
   {
       addNode(root, code, letter);
      
       return this;      
   }
   @Override
   public void setRoot(TreeNode<String> newNode) {
       root = newNode;  
   }

   @Override
   public java.lang.String fetch(java.lang.String code)
   {
       String letter = fetchNode(root, code);
      
       return letter;
   }
   @Override
   public void addNode(TreeNode<String> root, String code, String letter)
   {  
	   String test = code;
       if(test.length() == 1)
        {
           if (test.equals("."))
           {
               root.left = new TreeNode<String>(letter);
           }
           else
           {
        	   root.right = new TreeNode<String>(letter);
           }
           return;
        }
        else if(test.substring(0, 1).equals("."))
        {  
               addNode(root.left, test.substring(1), letter);
        }else
        {
               addNode(root.right, test.substring(1), letter);      
        }      
   }
@Override
   public void buildTree()
   {
       root = new TreeNode<String>("");
       insert(".", "e");
       insert("-", "t");
       insert("..", "i");
       insert(".-", "a");
       insert("-.", "n");
       insert("--", "m");
       insert("...", "s");
       insert("..-", "u");
       insert(".-.", "r");
       insert(".--", "w");
       insert("-..", "d");
       insert("-.-", "k");
       insert("--.", "g");
       insert("---", "o");
       insert("....", "h");
       insert("...-", "v");
       insert("..-.", "f");
       insert(".-..", "l");
       insert(".--.", "p");
       insert(".---", "j");
       insert("-...", "b");
       insert("-..-", "x");
       insert("-.-.", "c");
       insert("-.--", "y");
       insert("--..", "z");
       insert("--.-", "q");                  
   }
   @Override
   public TreeNode<String> getRoot()
   {
       return this.root;
   }
   
   @Override
   public java.lang.String fetchNode(TreeNode<java.lang.String> root, java.lang.String code)
   {  
       if(code.length() == 1)
        {
           if (code.equals("."))
           {
        	   l1 = root.left.getData();
           }
           else
           {
        	   l1 = root.right.getData();
           }
       }
        else if(code.substring(0, 1).equals("."))
        {  
               fetchNode(root.left, code.substring(1));
        }else
           {
               fetchNode(root.right, code.substring(1));      
           }      
       return l1;  
   }
   @Override
   public java.util.ArrayList<java.lang.String> toArrayList()
   {
       ArrayList<String> output = new ArrayList<String>();
       LNRoutputTraversal(root, output);      
       return output;
   }
   @Override
   public void LNRoutputTraversal(TreeNode<java.lang.String> root, java.util.ArrayList<java.lang.String> l1)
   {
       if(root != null)
       {
           LNRoutputTraversal(root.left, l1);
           l1.add(root.getData());
           LNRoutputTraversal(root.right, l1);
       }
   }
   @Override
   public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
       return null;
   }
   @Override
   public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
       return null;
   }

}