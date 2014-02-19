package search_tree;

public class btree {

    static  class node
    {
        private  int key;
        private  node left;
        private  node right;

        //this is the first nod (root)

        public node(int key)
        {
            this.key=key;
            this.left=null;
            this.right=null;
        }

        //setting left node

        public void setLeft(node left)
        {
            this.left=left;
        }

        //setting right node

        public void setRight(node right)
        {
            this.right=right;
        }

        //setting left node

        public node getLeft()
        {
            return this.left;
        }

        //setting right node

        public node getRight()
        {
            return this.right;
        }

        //inserting new key (node)
        public  void insertNod(node ancestor,node child)
        {
            if (ancestor.key<child.key)    // if the childs key is lesser than ancestors chi8ld will be left,oposite will be right
            {
                if(ancestor.getLeft()==null)
                {
                   ancestor.setLeft(child);
                }
                else insertNod(ancestor.getLeft(),child);  //recursion
            }
            if (ancestor.key>child.key)
            {
                if(ancestor.getRight()==null)
                {
                    ancestor.setRight(child);
                }
                else insertNod(ancestor.getRight(),child);    //recursion
            }
        }
    }

}
