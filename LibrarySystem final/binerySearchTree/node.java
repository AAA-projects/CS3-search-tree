package binerySearchTree;

import java.util.ArrayList;
/**
 * Created with IntelliJ IDEA.
 * User: chin
 * Date: 2/23/14
 * Time: 5:50 PM
 * To change this template use File | Settings | File Templates.
 */

public class node
{
    public String bookName;
    public String authName1;
    public String authName2;
    public int  isbn;
    public node left;
    public node right;

    /*this is the root
    default is set to middle of dictionary
    */
    public node()
    {
        this.bookName="k";
        this.authName1="";
        this.authName2="";
        this.isbn=0;
        this.left=null;
        this.right=null;
    }

    public node(String bookName,String name1,String name2,int isbn)         //node structure (book properties)
    {
        this.bookName=bookName;
        this.authName1=name1;
        this.authName2=name2;
        this.isbn=isbn;
        this.left=null;
        this.right=null;
    }

    public  void  setLeft(node newNode)      //setting left side element
    {
        this.left=newNode;
    }

    public  void  setRight(node newNode)    //setting right side element
    {
        this.right=newNode;
    }

    public node getLeft()     //getting left side element
    {
        return this.left;
    }

    public node getRight()     //getting right side element
    {
        return this.right;
    }

    /*inserting new node......................................................................................
    returning 1 for success
    returning 0 for duplication(overwrite)
    */
    public int insertFlag=1;
    public int insertNode(node ancestor,node child)
    {
        insertFlag=1;
        insertNewNode(ancestor,child);
        return insertFlag;
    }   
    
    public node insertNewNode(node ancestor,node child)
    {
        if( ancestor == null ){
            return child;
        }
        else if(ancestor.bookName.compareTo(child.bookName)>0)
            ancestor.setLeft(insertNewNode(ancestor.left, child));
        else if (ancestor.bookName.compareTo(child.bookName)<0)
            ancestor.setRight(insertNewNode(ancestor.right, child));
        else
        {
            insertFlag=0;
            child.left=ancestor.left; //setting childs links..
            child.right=ancestor.right;
            return child;  // on duplicate overwrites the node
        }
        return ancestor;
    }

    /* call the Printtree function
    returns node array list
    */
    
    ArrayList<node> treeList;
    public ArrayList<node> printAll(node root)
    {
        treeList=new ArrayList<node>();
        printTree(root);
        return treeList;
    }
    
    public void printTree(node root)
    {
        if(root != null)                      //in-order traversal..........
        {
            printTree(root.getLeft());                    //recursion.................
            treeList.add(root);
            printTree(root.getRight());                   //recursion.................
        }
        
    }

    /*searching for a node....................................................................................
    returning node for success
    returning null for no match
    */
    public node searchNode(node ancestor,node searchNode)
    {
        if(ancestor==null)
            return  null;
        if(ancestor.bookName.compareTo(searchNode.bookName)>0)
            ancestor= searchNode(ancestor.left, searchNode);
        else if (ancestor.bookName.compareTo(searchNode.bookName)<0)
            ancestor= searchNode(ancestor.right, searchNode);
        else
            return ancestor;

        return  ancestor;
    }
    
    /*searching for a keyword....................................................................................
    returning node[] for success
    */
    
    ArrayList<node> nodesList;
    public ArrayList<node> keysearch(node root,String Kword)
    {
        nodesList=new ArrayList<node>();
        searchKeyword(root,Kword);
        return nodesList;
    }
    
   public void searchKeyword(node root,String Kword)
    {
        if(root != null)                      //in-order traversal..........
        {
            searchKeyword(root.getLeft(),Kword);                    //recursion.................
            if(root.bookName.indexOf(Kword,0)>=0)
            nodesList.add(root);
            searchKeyword(root.getRight(),Kword);                   //recursion.................
        }
        
    }
   
   
    /*searching by a ISBN....................................................................................
    returning node for success
    */
   
   node isbnResult=null;
   public node searchISBN(node root,String Isbn)
   {
       isbnResult=null;
       searchIsbn(root,Isbn);
       return isbnResult;
   }
   
   public void searchIsbn(node root,String Isbn)
    {
        if(root != null)                      //in-order traversal..........
        {
            searchIsbn(root.getLeft(),Isbn);                    //recursion.................
            if(root.isbn==Integer.parseInt(Isbn))               //checking isbn
            isbnResult=root;
            searchIsbn(root.getRight(),Isbn);                   //recursion.................
        }
        
    }
   

    /*removing node ..........................................................................................
    returns 1 if succeeded
    returns 0 if no item
    */
    
    public int deleteFlag=1;
    public int removeNode(node ancestor,node child)
    {
        deleteFlag=1;
        remNode(ancestor,child);
        return deleteFlag;
    }   
    
    
    public node leftTree,rightTree; //to track left and right trees of node to be deleted
    public node remNode(node ancestor,node child)
    {
        if(ancestor==null)
        {
            deleteFlag=0;
            return  null; //node not found doing nothing
        }
        if(ancestor.bookName.compareTo(child.bookName)>0)
            ancestor.setLeft(remNode(ancestor.left, child));
        else if (ancestor.bookName.compareTo(child.bookName)<0)
            ancestor.setRight(remNode(ancestor.right, child));
        else if( ancestor.getLeft() != null &&   ancestor.getRight() != null ) // Two children
        {
            leftTree=ancestor.left;
            rightTree=ancestor.right;
            ancestor = searchMin( ancestor.right );   //setting right side least key to deleted node
            ancestor.setRight(remNode( rightTree,ancestor ));
            ancestor.left=leftTree;
        }
        else
            ancestor = ( ancestor.getLeft() != null ) ? ancestor.getLeft() : ancestor.getRight();
        return ancestor;
    }

    /*searching minimum node..................................................................................
    this function is used for remove function
    */
    public node searchMin(node ancestor)
    {
        if (ancestor.getLeft()==null)
            return ancestor;
        return (searchMin(ancestor.getLeft()));
    }

    //********************************************************************************************************

}




