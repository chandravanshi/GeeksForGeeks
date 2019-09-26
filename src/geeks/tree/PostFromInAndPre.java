package geeks.tree;

public class PostFromInAndPre {

  public static void main(String [] args) {
    int [] inorder = {1,2,3,4,5,6};
    int [] preorder = {1,2,3,4,5,6};
    int [] result = convertToPost(inorder, preorder);
    for(int m =0; m< result.length; m++) {
      System.out.print(result[m] + " ");
    }
  }


  public static int[] convertToPost(int [] inOrder, int [] preOrder) {
    if(inOrder.length < 2) {
      return inOrder;
    }

    if(inOrder.length == 2) {
      if(inOrder[0] == preOrder[0]) {
        swap(inOrder);
      }
      return inOrder;
    }

    int root = preOrder[0];
    int k = 0;

    while(inOrder[k] != root) {
      k++;
    }
    int [] newInorder = new int[k];
    int [] newPreOrder = new int[k];
    for(int i=0; i< k; i++) {
      newInorder[i] = inOrder[i];
      newPreOrder[i] = preOrder[i+1];
    }

    int [] secondInorder = new int[inOrder.length - k -1];
    int [] secondPreOrder = new int[inOrder.length -k -1];
    for(int i=k+1; i< inOrder.length; i++) {
      secondInorder[i-k-1] = inOrder[i];
      secondPreOrder[i-k-1] = preOrder[i];
    }

    return combine(convertToPost(newInorder, newPreOrder), convertToPost(secondInorder, secondPreOrder), root);

  }

  private static int [] combine(int [] first, int [] second, int root) {
    int n1 = first.length;
    int n2 = second.length;

    int [] result = new int[n1 + n2 + 1];

    for(int j = 0; j< n1 + n2 +1; j++) {
      if(j< n1) {
        result[j] = first[j];
      } else if(j < n2+n1 && j >= n1) {
        result[j] = second[j-n1];
      } else {
        result[j] = root;
      }

    }
    return result;
  }


  private static void swap(int [] inorder) {
    int temp = inorder[0];
    inorder[0] = inorder[1];
    inorder[1] = temp;
  }



}
