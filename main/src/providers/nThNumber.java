/**
 * nThNumber
 */
public class nThNumber {

    class Node{
        int data;
        Node next;
        public Node( int data, Node next){
            this.data = data;
            this.next = next;
        }
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6,7,8,9};
        Node res = arrToLL(arr);

        while(res.next !=null){
            System.out.println(res.data);
            res = res.next;
        }

    }

    // 1->2->3->4->5->6->7->8->9->10->11
    //                    ^            ^

    public static Node arrToLL(int [] arr){
        Node res = new Node();
        for(int i: arr){
            res.data = i;
            // res.next = new Node(0,new Node());
            // res = res.next;
        }

        return res;
    }
    
}