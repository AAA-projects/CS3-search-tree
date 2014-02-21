public void insertNode(node ancestor,node child)
    {
        if (ancestor.bookName.compareTo(child.bookName)>0)
        {
            if (ancestor.getLeft()==null) 
//check whether there is a left node
                ancestor.setLeft(child);
            else
                insertNode(ancestor.getLeft(), child);   

 //using recursion of insertNode............ 
        }
        if (ancestor.bookName.compareTo(child.bookName)<0)
        {
            if (ancestor.getRight()==null)
                ancestor.setRight(child);
            else
                insertNode(ancestor.getRight(), child);  
 //using recursion of insertNode.................
        }
    }