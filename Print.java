 public void searchNode(node ancestor,node searchNode)
    {
        if(ancestor.bookName.compareTo(searchNode.bookName)>0)
            searchNode(ancestor.left, searchNode);
        if (ancestor.bookName.compareTo(searchNode.bookName)<0)
            searchNode(ancestor.right, searchNode);
        if (ancestor.bookName.compareTo(searchNode.bookName)==0)
            System.out.println(ancestor.bookName+"******"+ancestor.authName1);
    }