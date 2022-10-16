//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
    
    public void insertSorted(Stack<Integer> stack, int x){
        if(stack.isEmpty()) {
            stack.push(x);
            return;
        }
        int top=stack.peek();
        if(top<x){
            // we need to push now
            stack.push(x);return;
        }
        else{
        
            int item=stack.pop();
            insertSorted(stack, x);
            stack.push(item);
            return;
        }
    }
    
	public Stack<Integer> sort(Stack<Integer> s)
	{
	    if(s.isEmpty()) return s;
	    
	    int item=s.pop();
	    sort(s);
	    insertSorted(s, item);
	    return s;
		
	}
}