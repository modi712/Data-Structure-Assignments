//Created data type mobile phone
class MobilePhone
{ protected int id;
  protected Boolean status;
  protected Exchange basestation;
  
  public MobilePhone()
  { id = 0;
    status = true;
	Exchange basestation = new Exchange();
	}
  public MobilePhone(int Number)
  {
  id = Number;
  }
  public int number()
  {
    return id;
  }	
  public Boolean status()
  {
   return status;
  }
  public void switchOn()
  {
  status = true;
  }
  public void switchOff()
  {
  status = false;
  }
  public Exchange location()
  {
	 if(status = true)		 {return basestation;}
	 else throw new IllegalArgumentException("Error");
  }
} 



/*  Class Node  */
class Node
{
    protected Object data;
    protected Node link;
 
    /*  Constructor  */
    public Node()
    {
        link = null;
        Object data;
    }    
    /*  Constructor  */
    public Node(Object d,Node n)
    {
        data = d;
        link = n;
    }    
    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        link = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(Object d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Node getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node  */
    public MobilePhone getData()
    {
        return (MobilePhone)data;
    }
}
/* class Myset */
class Myset
{
  protected Node start;
  protected Node end;
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
  public Boolean IsMember(Object x)
  {   
	  Node ptr = start;
	  
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
	
  public Boolean IsMember1(int x)
  {
    Node ptr = start;
	
	int counter = 0;
	for(int i=1; i<= (size); i++)
	{
		if (ptr.getData().number() == x)
			counter = counter + 1;
		else 
			 ptr = ptr.getLink();
	}
	if(counter == 0) { return false;}
	else return true;
  }

    
    
    public void Insert(Object val)
    {
        Node nptr = new Node(val,null);  
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
            d = d + String.valueOf(start.getData().number() );
            return d;
        }
        Node ptr = start;
        d = String.valueOf(start.getData().number())+ ", ";
        ptr = start.getLink();
        while (ptr != null)
        {
            d = d + String.valueOf(ptr.getData().number()) + ", ";
            ptr = ptr.getLink();
            
        }
        
        return  d.substring(0, (d.length()-2));
    }
	public void Delete(Object x)
	{Node ptr = start;
	 Node tmp = start;
	if(IsMember(x)) 
	{
		for(int i = 0; i <= size; i++)
		{  tmp = ptr.getLink();
	       
			if(tmp.getData() == x)
			{tmp = tmp.getLink();
		     ptr.setLink(tmp);
			 break;}
			 ptr = ptr.getLink();
		} size--;
	} else System.out.println("Error");		 
	}
	
	public void Delete1(int x)
	{Node ptr = start;
	 Node tmp = start;
	if(IsMember1(x)) 
	{  if(ptr.getData().number() == x) {start = start.getLink(); size--; return;}
		for(int i = 0; i <= size; i++)
		{  
	
	       tmp = ptr.getLink();
	       
			if(tmp.getData().number() == x)
			{tmp = tmp.getLink();
		     ptr.setLink(tmp);
			 break;}
			 ptr = ptr.getLink();
		} size--;
	} else System.out.println("Error");		 
	}
	
	
    public Myset Union(Myset a)
    {Node ptr = start;
	 
     
      for(int i = 0; i <= (size-1); i++)
	  { a.Insert(ptr.getData());
        ptr = ptr.getLink();
		}
		return a;
    }
	public Myset Intersection(MobilePhoneSet a)
	{Node ptr = start;
	 Myset b = new Myset();
	 
	  for(int i = 0; i <= (size - 1); i++)
	  { if(a.IsMember(ptr.getData()))
		  {b.Insert(ptr.getData());}
	    ptr = ptr.getLink();
	  }
    return b;
	}
      		
}


class MobilePhoneSet
{public Myset MobilePhoneSet;

public MobilePhoneSet()
{
 MobilePhoneSet = new Myset(); 
}

Boolean IsEmpty()
{
	return MobilePhoneSet.IsEmpty();
}

void Insert(MobilePhone val)
{
	MobilePhoneSet.Insert(val);
}
Boolean IsMember1(int a)
{
   return MobilePhoneSet.IsMember1(a);	
}	

void Delete1(int x)
{
  MobilePhoneSet.Delete1(x);	
}	


Boolean IsMember(MobilePhone x)
{
   return MobilePhoneSet.IsMember(x);
}

String display()
{
   return MobilePhoneSet.display();	
}
	
}





class Exchange
{
protected int id;
protected MobilePhoneSet residentSet = new MobilePhoneSet();;
protected ExchangeList children = new ExchangeList();
protected Exchange parent = null;



public Exchange()
{
id = 0;
}

public Exchange(int number)
{
 id = number;
 }
 


 public int numChildren()
 {
	 return (children.getSize());
 }
 public int getid()
 {
	 return id;
 }
 
 public Exchange child(int i)
 { fode ptr = children.getStart();
        if(ptr == null){return null;}
		if(i == 0){ return ptr.getData();}
	 for(int j = 0; j <= (i-1); j++)
	 { ptr = ptr.getLink();}
    return ptr.getData(); 
 }
 

 
 public MobilePhoneSet residentSet()
 {
	 return residentSet;
 }

 public void setchildren(ExchangeList x)
 {
	 children = x;
 }

 public ExchangeList getchildren()
 {
	 return children;
 }

 public void setresidentSet(MobilePhoneSet x)
 {
	 residentSet = x;
 }

 
 public RoutingMapTree subtree(int i)
{RoutingMapTree subtree = new RoutingMapTree();

subtree.root = child(i);
	 return subtree;
		 
}


}




/*
 *  Java Program to Implement Singly Linked List
 */
 
//import java.util.Scanner;
 
/*  Class Node  */
class fode
{
    protected Exchange data;
    protected fode link;
 
    /*  Constructor  */
    public fode()
    {
        link = null;
        Exchange data = new Exchange();
    }    
    /*  Constructor  */
    public fode(Exchange d,fode n)
    {
        data = d;
        link = n;
    }    
    /*  Function to set link to next Node  */
    public void setLink(fode n)
    {
        link = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(Exchange d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public fode getLink()
    {
        return link;
    }    
    /*  Function to get data from current Node  */
    public Exchange getData()
    {
        return data;
    }
}
/* class Myset */
class ExchangeList
{
  protected fode start;
  protected fode end;
  protected int size;
  
  /* constructor */
  public ExchangeList()
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
  public Boolean IsMember(Exchange x)
  {   
	  fode ptr = start;
	  
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
   
	  public void insert(Exchange val)
    {
        fode nptr = new fode(val,null);    
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

	public void Delete(Exchange x)
	{fode ptr = start;
	 fode tmp = start;
	if(IsMember(x)) 
	{
		for(int i = 0; i <= size; i++)
		{  tmp = ptr.getLink();
	       
			if(tmp.getData() == x)
			{tmp = tmp.getLink();
		     ptr.setLink(tmp);
			 break;}
			 ptr = ptr.getLink();
		} size--;
	} else System.out.println("Error");		 
	}

	public int getSize()
    {
        return size;
    } 
	public fode getStart()
    {
        return start;
    }
      		
}




class RoutingMapTree
{
public Exchange root;

public RoutingMapTree()
{ root = new Exchange(0);
  
}
public void ch()
{
	if(root == null){System.out.println("hii");}
}






public void add(Exchange x, int y)
{   if(root.numChildren() == 0){if (root.getid()==y) root.children.insert(x);}
	
	else {if (root.getid()==y) root.children.insert(x);
		else {for(int j = 0; j < (root.numChildren()); j++)
		{root.subtree(j).add(x,y);}}
         }
}




//if (root.children.getStart() == null){System.out.println(1);}
public Boolean containsNode(int a)
{ 
  
  int counter = 0;
 // if (ptr == null) counter = counter; 
   if(root.numChildren() == 0){if(root.getid() == a) {counter = counter + 1;}}
   
   else if(root.getid() == a){counter = counter + 1;}
  else {for(int j = 0; j < (root.numChildren()); j++)
  { if(root.subtree(j).containsNode(a)) counter = counter + 1;}}
  if(counter == 0) return false;
  else return true;
    	
}

public String findpath(int a)
{String x = "";
if(root.residentSet().IsMember1(a)){x = String.valueOf(root.getid() + " ");}
for (int j = 0; j < (root.numChildren()); j++)
{
	x = x  + root.subtree(j).findpath(a);
}	
	
	if (!x.equals("")) return x.substring(0, x.length());
	return x;
}



public String FindPhone(int x)
{
  String y = findpath(x);

  if( !y.equals(""))
  {String[] f = y.split(" ");
  return f[f.length - 1];}
  return "Error - No mobile phone with identifier " + x + " found in the network queryFindPhone";
}

public String findCallPath(int a, int b)
{String y = findpath(a);
 String z = findpath(b);
 if(y.equals("")) { return "Error - Mobile phone with identifier " + a + " is currently switched off";}
 if(z.equals("")) { return "Error - Mobile phone with identifier " + b + " is currently switched off";}
 int w = z.length();
 if(y.length() <= z.length()) w = y.length(); 
 String n = "";
 for(int j = 0; j < w; j++)
 { 
   if(y.charAt(j) == z.charAt(j)){ n = n + y.charAt(j);}
   if(y.charAt(j) != z.charAt(j)){break;}
 }
 
 if(n.length() != 0) y = y.substring(n.length() );
 if(n.length() != 0) z = z.substring(n.length() - 2 );
 String bla = new StringBuilder(y).reverse().toString();
  
  
  //return n;
 String l = bla + " "  + z;
 l = l.substring(1, l.length() - 1);

 String p = "";
 
 for(int j = 0; j < l.length(); j++)
 {
   if(l.charAt(j) == ' ') { p = p + ", ";} else p = p + l.charAt(j);
 }	 
 
 return p;
}	




public String LowestRouter1(int a, int b)
{  String k = "";
if(containsNode(a) && containsNode(b))  k = String.valueOf(root.getid());
 
  for( int j = 0; j < (root.numChildren()); j++)
  {
	 k =  k + " " + root.subtree(j).LowestRouter1(a, b); 
  }
  
    String[] f = k.split(" ");
	return f[f.length - 1];
	
}


public void switchOn(MobilePhone a, int b)
{
	if (containsNode(b)) {root.residentSet().Insert(a);}
	for(int j = 0; j < (root.numChildren()); j++)
	{root.subtree(j).switchOn(a, b);
      if(root.getid() == b)
	  { break;}
	}

}

public void switchOff(int a)
{   
	if (root.residentSet().IsMember1(a)){root.residentSet.Delete1(a);}
	for(int j = 0; j < (root.numChildren()); j++)
	{
	  root.subtree(j).switchOff(a);	
	}	
}


public String query1(int a)
{   if(containsNode(a))
	{
    
	if(root.numChildren() == 0){if (root.getid()==a) return root.residentSet().display();}
	
	else {if (root.getid() == a) return root.residentSet().display();
		else {for(int j = 0; j < (root.numChildren()); j++)
		{ if(root.subtree(j).query1(a) != "Not exist"){return root.subtree(j).query1(a);}}}
         }
	}
         return "Not exist";
}


public String query(int x, int y)
{if(containsNode(x))
{  
 if(root.numChildren() == 0){if (root.getid()==x) return String.valueOf(root.child(y).getid());}
	
	else {if (root.getid() == x) return String.valueOf(root.child(y).getid());
		else {for(int j = 0; j < (root.numChildren()); j++)
		{ if(root.subtree(j).query(x,y) != "Not exist" ){return root.subtree(j).query(x,y);}}}
         }
} 
return "Not exist";


}

	
	
	

public String performAction(String actionMessage)
{   System.out.println(actionMessage); 
  String[] ary = actionMessage.split(" ");
	
	if(ary[0].equals("addExchange"))
		
	{int c = Integer.parseInt(ary[1]);
		int d = Integer.parseInt(ary[2]);
		
		Exchange b = new Exchange(d);
		Exchange m = new Exchange(7);
		
		add(b, c);
		
		
	
	}
	
	if(ary[0].equals("queryNthChild"))
		
		{int e = Integer.parseInt(ary[1]);
		int f = Integer.parseInt(ary[2]);
			System.out.println(actionMessage + ": " + query(e,f));
			return actionMessage + ": " + query(e,f);
		}
		
	if(ary[0].equals("switchOnMobile"))
	{int e = Integer.parseInt(ary[1]);
		int f = Integer.parseInt(ary[2]);
 
	MobilePhone a = new MobilePhone(e); 
	switchOn(a, f);
	}
	
	if(ary[0].equals("queryMobilePhoneSet"))
	{
		int h = Integer.parseInt(ary[1]);
		System.out.println(actionMessage + ": " + query1(h));
		return actionMessage + ": " + query1(h);
	}

	if(ary[0].equals("switchOffMobile"))
	{int e = Integer.parseInt(ary[1]);
		
 
	
	switchOff(e);
	}
	
	if(ary[0].equals("findPhone"))
	{ int e = Integer.parseInt(ary[1]);
       
       System.out.println(actionMessage + ": " + FindPhone(e));
	   return actionMessage + ": " + FindPhone(e);
	  

    }
	
	if(ary[0].equals("lowestRouter"))
	{ int e = Integer.parseInt(ary[1]);
      int f = Integer.parseInt(ary[2]);
       //if(FindPhone(e) != -10)
       {System.out.println(actionMessage + ": " + LowestRouter1(e,f));
	   return actionMessage + ": " + LowestRouter1(e,f);}
	   

    }
	
	if(ary[0].equals("findCallPath"))
		
	{int c = Integer.parseInt(ary[1]);
		int d = Integer.parseInt(ary[2]);
		
		
		System.out.println(findCallPath(c,d));
		return findCallPath(c,d);
		
		
	
	}
	
	if(ary[0].equals("movePhone"))
		
	{int c = Integer.parseInt(ary[1]);
		int d = Integer.parseInt(ary[2]);
		
		
		switchOff(c);
		MobilePhone a = new MobilePhone(c);
		switchOn(a,d);
		
		
	
	}
		
	return"";	
	
	
}
}
