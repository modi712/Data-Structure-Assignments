import java.util.Scanner;
import java.io.*;


 class Node<T>
{
    protected T data;
    protected Node<T> link;
 
    /*  Constructor  */
    public Node()
    {
        this.link = null;
        this.data = null;
    }    
    /*  Constructor  */
    public Node(T d,Node<T> n)
    {
        this.data = d;
        this.link = n;
    }    
    /*  Function to set link to next Node  */
    public void setLink(Node<T> n)
    {
        this.link = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(T d)
    {
        this.data = d;
    }    
    /*  Function to get link to next node  */
    public Node<T> getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node  */
    public T getData()
    {
        return data;
    }
}


class Myset<T>
{
   Node<T> start = new Node<T>();
  protected Node<T> end;
  protected int size;
  
  
  
  
  /* constructor */
  public Myset()
  {  start = null;
     end = null;
	 size = 0;
	}
 /* function to check if the set is empty */
  public Boolean IsEmpty()
  {
     return start == null;
  }
 /* function to check is member */
  public Boolean IsMember(T x)
  {   
	  Node<T> ptr = start;
	  
	  int counter = 0;
	  for(int i=1; i <= (size); i++)
	  { 
		  if(ptr.getData() == x)
			   counter = counter + 1;
		   else 
	            
				 ptr = ptr.getLink();
	  }
       if(counter==0) {return false;}
	   else return true;
	  
  }


    
    
    public void Insert(T val)
    {
        Node<T> nptr = new Node<T>(val,null);  
        if(!(IsMember(val)))
        {			
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            end.setLink(nptr);
            end = nptr;
        }
		}
    }
    
    
	   public String display()
    { String d = "";
        
        if (size == 0) 
        {
          
            d = d;
        }    
        if (start.getLink() == null) 
        {
            d = d + String.valueOf(start.getData() );
            return d;
        }
        Node<T> ptr = start;
        d = String.valueOf(start.getData())+ ", ";
        ptr = start.getLink();
        while (ptr != null)
        {
            d = d + String.valueOf(ptr.getData()) + ", ";
            ptr = ptr.getLink();
            
        }
        
        return  d;
    }

	
	
    public Myset<T> Union(Myset<T> a)
    {Node<T> ptr = start;
	 
     
      for(int i = 0; i <= (size-1); i++)
	  { a.Insert(ptr.getData());
        ptr = ptr.getLink();
		}
		return a;
    }
	
	
	public Myset<T> Intersection(Myset<T> a)
	{Node<T> ptr = start;
	 Myset<T> b = new Myset<T>();
	 
	  for(int i = 0; i <= (size - 1); i++)
	  { if(a.IsMember(ptr.getData()))
		  {b.Insert(ptr.getData());}
	    ptr = ptr.getLink();
	  }
    return b;
	}
	
	public Node<T> getStart()
	{
	  return start;	
	}	
	
	public int getSize()
	{
		return size;
	}
      		
}


class MyLinkedList<T>
{
   Node<T> start = new Node<T>();
  protected Node<T> end;
  protected int size;
  
  
  
  
  /* constructor */
  public MyLinkedList()
  {  start = null;
     end = null;
	 size = 0;
	}
 /* function to check if the set is empty */
  public Boolean IsEmpty()
  {
     return start == null;
  }
 /* function to check is member */
  public Boolean IsMember(T x)
  {   
	  Node<T> ptr = start;
	  
	  int counter = 0;
	  for(int i=1; i <= (size); i++)
	  { 
		  if(ptr.getData() == x)
			   counter = counter + 1;
		   else 
	            
				 ptr = ptr.getLink();
	  }
       if(counter==0) {return false;}
	   else return true;
	  
  }


    
    
    public void Insert(T val)
    {
        Node<T> nptr = new Node<T>(val,null);  
        //if(!(IsMember(val)))
        {			
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            end.setLink(nptr);
            end = nptr;
        }
		}
    }
    
    
	   public String display()
    { String d = "";
        
        if (size == 0) 
        {
          
            d = d;
        }    
        if (start.getLink() == null) 
        {
            d = d + String.valueOf(start.getData() );
            return d;
        }
        Node<T> ptr = start;
        d = String.valueOf(start.getData())+ ", ";
        ptr = start.getLink();
        while (ptr != null)
        {
            d = d + String.valueOf(ptr.getData()) + ", ";
            ptr = ptr.getLink();
            
        }
        
        return  d;
    }

	
	
    public MyLinkedList<T> Union(MyLinkedList<T> a)
    {Node<T> ptr = start;
	 
     
      for(int i = 0; i <= (size-1); i++)
	  { a.Insert(ptr.getData());
        ptr = ptr.getLink();
		}
		return a;
    }
	
	public Node<T> getStart()
	{
	  return start;	
	}	
	
	public int getSize()
	{
		return size;
	}	
	
      		
}



 /* Class AVLNode */
 class AVLNode
 {    
     AVLNode left, right;
     Position data;
     int height;
 
     /* Constructor */
     public AVLNode()
     {
         left = null;
         right = null;
        // data = new Position();
         height = 0;
     }
     /* Constructor */
     public AVLNode(Position n)
     {
         left = null;
         right = null;
         data = n;
         height = 0;
     }     
 }
 
 /* Class AVLTree */
 class AVLTree
 {
     private AVLNode root;     
 
     /* Constructor */
     public AVLTree()
     {
         root = null;
     }
     /* Function to check if tree is empty */
     public boolean isEmpty()
     {
         return root == null;
     }
     /* Make the tree logically empty */
     public void makeEmpty()
     {
         root = null;
     }
     /* Function to insert data */
     public void Insert(Position data)
     {
         root = insert(data, root);
     }
     /* Function to get height of node */
     private int height(AVLNode t )
     {
         return t == null ? -1 : t.height;
     }
     /* Function to max of left/right node */
     private int max(int lhs, int rhs)
     {
         return lhs > rhs ? lhs : rhs;
     }
     /* Function to insert data recursively */
     private AVLNode insert(Position x, AVLNode t)
     {
         if (t == null)
             t = new AVLNode(x);
         else if (x.getWordIndex() < t.data.getWordIndex())
         {
             t.left = insert( x, t.left );
             if( height( t.left ) - height( t.right ) == 2 )
                 if( x.getWordIndex() < t.left.data.getWordIndex() )
                     t = rotateWithLeftChild( t );
                 else
                     t = doubleWithLeftChild( t );
         }
         else if( x.getWordIndex() > t.data.getWordIndex() )
         {
             t.right = insert( x, t.right );
             if( height( t.right ) - height( t.left ) == 2 )
                 if( x.getWordIndex() > t.right.data.getWordIndex())
                     t = rotateWithRightChild( t );
                 else
                     t = doubleWithRightChild( t );
         }
         else
           ;  // Duplicate; do nothing
         t.height = max( height( t.left ), height( t.right ) ) + 1;
         return t;
     }
     /* Rotate binary tree node with left child */     
     private AVLNode rotateWithLeftChild(AVLNode k2)
     {
         AVLNode k1 = k2.left;
         k2.left = k1.right;
         k1.right = k2;
         k2.height = max( height( k2.left ), height( k2.right ) ) + 1;
         k1.height = max( height( k1.left ), k2.height ) + 1;
         return k1;
     }
 
     /* Rotate binary tree node with right child */
     private AVLNode rotateWithRightChild(AVLNode k1)
     {
         AVLNode k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         k1.height = max( height( k1.left ), height( k1.right ) ) + 1;
         k2.height = max( height( k2.right ), k1.height ) + 1;
         return k2;
     }
     /**
      * Double rotate binary tree node: first left child
      * with its right child; then node k3 with new left child */
     private AVLNode doubleWithLeftChild(AVLNode k3)
     {
         k3.left = rotateWithRightChild( k3.left );
         return rotateWithLeftChild( k3 );
     }
     /**
      * Double rotate binary tree node: first right child
      * with its left child; then node k1 with new right child */      
     private AVLNode doubleWithRightChild(AVLNode k1)
     {
         k1.right = rotateWithLeftChild( k1.right );
         return rotateWithRightChild( k1 );
     }    
     /* Functions to count number of nodes */
     public int countNodes()
     {
         return countNodes(root);
     }
     private int countNodes(AVLNode r)
     {
         if (r == null)
             return 0;
         else
         {
             int l = 1;
             l += countNodes(r.left);
             l += countNodes(r.right);
             return l;
         }
     }
     /* Functions to search for an element */
     public boolean search(int val)
     {
         return search(root, val);
     }
     private boolean search(AVLNode r, int val)
     {
         boolean found = false;
         while ((r != null) && !found)
         {
             int rval = r.data.getWordIndex();
             if (val < rval)
                 r = r.left;
             else if (val > rval)
                 r = r.right;
             else
             {
                 found = true;
                 break;
             }
             found = search(r, val);
         }
         return found;
     }
     /* Function for inorder traversal */
     public void inorder()
     {
         inorder(root);
     }
     private void inorder(AVLNode r)
     {
         if (r != null)
         {
             inorder(r.left);
             System.out.print(r.data.getWordIndex() +" ");
             inorder(r.right);
         }
     }
	 
	 
	 public Myset<PageEntry> inorder1()
     {
        return inorderr(root);
     }
     public Myset<PageEntry> inorderr(AVLNode r)
     {  Myset<PageEntry> l = new Myset<PageEntry>(); 
         if (r != null)
         {
             inorderr(r.left);
             l.Insert(r.data.getPageEntry());
             inorderr(r.right);
         }
		 return l;
     }
     /* Function for preorder traversal */
     public void preorder()
     {
         preorder(root);
     }
     private void preorder(AVLNode r)
     {
         if (r != null)
         {
             System.out.print(r.data.getWordIndex() +" ");
             preorder(r.left);             
             preorder(r.right);
         }
     }
     /* Function for postorder traversal */
     public void postorder()
     {
         postorder(root);
     }
     private void postorder(AVLNode r)
     {
         if (r != null)
         {
             postorder(r.left);             
             postorder(r.right);
             System.out.print(r.data.getWordIndex() +" ");
         }
     }     
 }


class Position
{ PageEntry page;
  int wordPosition;  
public Position(PageEntry p, int wordIndex)
{  
     page = p;
	 wordPosition = wordIndex;

}

PageEntry getPageEntry() 
{
return page;
}

int getWordIndex() 
{
return wordPosition;
}
}

class WordEntry
{
MyLinkedList<Position> entrylist;	
 String str;
	


public WordEntry(String word)
{
	str = word;
	entrylist = new MyLinkedList<Position>();
}	

public String getstr()
{
	
 return str;	
	
}	


public void addPosition(Position position)	
{
 entrylist.Insert(position);
}

public void addPositions(MyLinkedList<Position> positions)
{
	entrylist = entrylist.Union(positions);
	
}

public String getWord()
{
  return str;	
}	

public MyLinkedList<Position> getAllPositionsForThisWord()
{
  return entrylist; 
}

	

/*float getTermFrequency(String word)
{
	
}*/	
}


class PageIndex	
{ MyLinkedList<WordEntry> pageEntrylist; 
	
	public PageIndex()
	{
		pageEntrylist = new MyLinkedList<WordEntry>();
		
	}	
	
	public Boolean containsword(String x)
	{ Node<WordEntry> ptr = pageEntrylist.getStart();
	   int count = 0;
	  
	  for(int i = 0; i < pageEntrylist.getSize(); i++)
	  {
		  
		 if((ptr.getData().getWord()).equals(x))
		  {count = count + 1;}
		 
		 
		 ptr = ptr.getLink();
	  }
	   
		if(count == 0) return false;
		else return true;
		
	}	
	
	
	
	public void addPositionForWord(String str, Position p)
	 
	  {Node<WordEntry> ptr = pageEntrylist.getStart();
	 if(containsword(str))
	 {
		for(int i = 0; i < pageEntrylist.getSize(); i++)
		{  //tmp = ptr.getLink();
	       
			if((ptr.getData().getWord()).equals(str))
			{
				(ptr.getData().getAllPositionsForThisWord()).Insert(p);
				
			}
			 ptr = ptr.getLink();
		} 
	}
	else
	{ WordEntry w = new WordEntry(str);
      w.addPosition(p);
	  pageEntrylist.Insert(w);
		
	}	


    		 
	}
	
		
		
	
	public MyLinkedList<WordEntry> getWordEntries()
	{
		return pageEntrylist;
	}	
	
}




class PageEntry
 {
	String name; 
	PageIndex one;
	 
public PageEntry(String pageName)
{  one = new PageIndex();
   name = pageName;
try{   
   
	 
 
    File file = new File(pageName);
    Scanner input = new Scanner(file); 
	
 
    int count = 0;
    while (input.hasNextLine()) {
		int i;
      String word  = input.nextLine();
	  word = word.replaceAll("[-|=|.|,|;|:|<|>|?|{|}|'|\"|\\|(|)|#|!|1|2|3|4|5|6|7|8|9|0|]", " ");
	  word = word.toLowerCase();
	  String[] arr = word.split(" +"); 
	  for(i = 0; i < arr.length; i++)
	  { 
	   Position p = new Position( this , count);
	  one.addPositionForWord(arr[i], p);
	  count = count++;
	  
      }
	  
	  
	  
      
    }
}catch(FileNotFoundException e){};
  
}

public String getName()
{
	return name;
	
}	


public PageIndex getPageIndex()
{
	return one;
}	
}

class MyHashTable
{
	MyLinkedList<WordEntry>[] ary;
	
	
public MyHashTable()	
{

	ary = new MyLinkedList[27];	

for(int i = 0; i < 27; i++)
	{
		ary[i] = new MyLinkedList<WordEntry>();
	}	
}
public int getHashIndex(String str)
{  if(!str.equals(""))
	{char ch = str.charAt(0);
        int ascii = ch;
        // You can also cast char to int
        int castAscii = (int) ch;
    if (castAscii > 96) return (castAscii - 97);
	 else return (castAscii - 65);
	} else return 26;
}

void addPositionsForWord(WordEntry w)
{  String a = w.getstr();
	int b = getHashIndex(a);
	ary[b].Insert(w);
	
}

public MyLinkedList<WordEntry>[] getary()
{
	return ary;
}	
}

class InvertedPageIndex
{  MyHashTable table;
	
	public InvertedPageIndex()
	{
		table = new MyHashTable();
		
		
	}

    public void addPage(String p)
	{
        PageEntry x = new PageEntry(p);
		PageIndex y = x.getPageIndex();
		MyLinkedList<WordEntry> z = y.getWordEntries();
		
		Node<WordEntry> ptr = z.getStart();
		try{
		for(int i = 0; i <= z.getSize(); i++)
		{ String d = ptr.getData().getstr();
	      int e = table.getHashIndex(d);
		  MyLinkedList<WordEntry>[] ary1 = table.getary();
		  ary1[e].Insert(ptr.getData());
			
			ptr = ptr.getLink();
			
			
		}	
		}catch(NullPointerException e){};
	}
	
	
	public Myset<PageEntry> getPagesWhichContainWord(String str)
	{   Myset<PageEntry> l = new Myset<PageEntry>();
		int d = table.getHashIndex(str);
		MyLinkedList<WordEntry>[] ary1 = table.getary();
		MyLinkedList<WordEntry> ary2 = ary1[d];
		Node<WordEntry> ptr = ary2.getStart();
		
        		
		for(int i = 0; i < ary2.getSize(); i++)
		{
		   if((ptr.getData().getWord()).equals(str))
		   {
			   Node<Position> ptrm = ptr.getData().getAllPositionsForThisWord().getStart();
			   for(int j = 0; j < ptr.getData().getAllPositionsForThisWord().getSize(); j++)
			   {
				   l.Insert(ptrm.getData().getPageEntry());
				   ptrm = ptrm.getLink();
			   
			   } 
			   
			   
		   }ptr = ptr.getLink(); 


		
		}	return l;
	}

    public String getPages(Myset<PageEntry> x)
    { String d = "";
      Node<PageEntry> ptr = x.getStart();
	  //if(ptr.getData() != null)
	  {
	  
     for(int i = 0; i < x.getSize(); i++)
	 {
       d =  ptr.getData().getName() + ", " + d;
	    ptr = ptr.getLink();

	  } }
	  
	  if(d.equals("")) return "hum";

     return d.substring(0, d.length() - 2);

	}
	
	public String queryFindPositionsOfWordInAPage(String x, String y)
	{   String z = "";
		PageEntry a = new PageEntry(y);
		MyLinkedList<WordEntry> b = a.getPageIndex().getWordEntries();
		Node<WordEntry> ptr = b.getStart();
		for(int i = 0; i < b.getSize(); i++)
		{
          if((ptr.getData().getWord()).equals(x))
          {    MyLinkedList<Position> l = ptr.getData().getAllPositionsForThisWord();
	            Node<Position> ptrm = l.getStart();
				for(int j = 0; j < l.getSize(); j++)
 				{
                  z = z + ptrm.getData().getWordIndex();
				  ptrm = ptrm.getLink();
			    }
	  
		  }			  
			ptr = ptr.getLink();
			
		} 
		
		if(z.equals("")) return "Webpage " + y +  " does not contain word " + x;
		
		else return z;	
		
		
	}	
	
	
	
	
}




class SearchEngine
{
	
	
	
InvertedPageIndex IP;	
	
public SearchEngine()
{
	IP = new InvertedPageIndex();
}	


void performAction(String actionMessage)
{
		

	
	
	System.out.println(actionMessage); 
  String[] ary = actionMessage.split(" ");
	
	if(ary[0].equals("addPage"))
		
	{String c = (ary[1]);
	 IP.addPage(c);
		
		
		
		
	}
	
	
	
	
	if(ary[0].equals("queryFindPagesWhichContainWord"))
		
	{String c = (ary[1]).toLowerCase();
	 
	if((IP.getPages(IP.getPagesWhichContainWord(c))).equals("hum")) System.out.println("No webpage contains word " + c);
   else System.out.println(IP.getPages(IP.getPagesWhichContainWord(c)));
    
		
		
		
	}
	
	if(ary[0].equals("queryFindPositionsOfWordInAPage"))
		
	{String c = (ary[1]);
	 String d = (ary[2]);
	 
	 System.out.println(IP.queryFindPositionsOfWordInAPage(c, d));
	 
		
		
		
		
	}
	
	if(ary[0].equals("queryFindPagesWhichContainAnyOfTheseWords"))
		
	{String c = (ary[1]).toLowerCase();
	 
	if((IP.getPages(IP.getPagesWhichContainWord(c))).equals("hum")) System.out.println("No webpage contains word " + c);
   else System.out.println(IP.getPages(IP.getPagesWhichContainWord(c)));
	 
	 
	 //System.out.println(IP.queryFindPositionsOfWordInAPage(c, d));
	 
		
		
		
		
	}
	
	if(ary[0].equals("queryFindPagesWhichContainAllWords"))
		
	{String c = (ary[1]).toLowerCase();
	 
	if((IP.getPages(IP.getPagesWhichContainWord(c))).equals("hum")) System.out.println("No webpage contains word " + c);
   else System.out.println(IP.getPages(IP.getPagesWhichContainWord(c)));
	 
	 
	 //System.out.println(IP.queryFindPositionsOfWordInAPage(c, d));
	 
		
		
		
		
	}
	
	
	
	
	
}	



}