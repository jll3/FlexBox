public class FlexBox extends Box {
	private int Grade=0;
	private int Colour=0;
	private boolean Reinforcedbottom=false;
	private boolean Reinforcedcorners=false;
	private boolean Sealedtop=false;
	private int Quantity=0;
	private double Price=0;
	private double Pricetotal=0;
	
    public FlexBox(double Length, double Width, double Height, int Grade, int Colour, boolean Reinforcedbottom, boolean Reinforcedcorners, boolean Sealedtop, int Quantity, double Price, double Pricetotal) {
   	      super(Length, Width, Height);//access methods and properties of parent class
		this.Grade = Grade;
		this.Colour = Colour;
		this.Reinforcedbottom = Reinforcedbottom;
		this.Reinforcedcorners = Reinforcedcorners;
		this.Sealedtop = Sealedtop;
		this.Quantity = Quantity;
		this.Price = Price;
		this.Pricetotal=Pricetotal;
    }

   private double meterArea()
   {
   	return((getWidth() + getLength()+getWidth()) * 2);
   }

    private double Price()
    {
     if (Grade == 1)
     {
     double Price = meterArea()*0.45;
     setPrice(Price);
     return Price;
     }
     
     if (Grade == 2)
     {
     double Price = meterArea()*0.59;
     setPrice(Price);
     return Price;
     }
     
     if (Grade == 3)
     {
     double Price=meterArea()*0.68;
     setPrice(Price);
     return Price;
     }
     
     if (Grade == 4)
     {
     double Price=meterArea()*0.92;
     setPrice(Price);
     return Price;
     }
     
     if (Grade == 5)
     {
     double Price=meterArea()*1.30;
     setPrice(Price);
     return Price;
     }
      return getPrice();
    }
    
    public double Pricetotal()
    {
     if (Sealedtop == true)
     {
     	Pricetotal=(Price()*105/100)*getQuantity();
        setPricetotal(Pricetotal); 
        return Pricetotal;
     }
     
     if (Reinforcedbottom == true)
     {
     	Pricetotal=(Price()*110/100)*getQuantity();
        setPricetotal(Pricetotal); 
        return Pricetotal;
      }
     
     if (Reinforcedcorners == true)
     {
     	Pricetotal=(Price()*107/100)*getQuantity();
        setPricetotal(Pricetotal); 
        return Pricetotal;
     }
     
      if (Colour == 0)
     {
      return Price();
     }
     if (Colour == 1)
     {
     	Pricetotal=(Price()*112/100)*getQuantity();
        setPricetotal(Pricetotal); 
        return Pricetotal;
     }
     
     if(Colour == 2)
     {
     	Pricetotal=(Price()*115/100)*getQuantity();
        setPricetotal(Pricetotal); 
        return Pricetotal;	
     }
     return Price();  
     
    }

	public int getGrade(){return Grade;}
	public void setGrade(int Grade){this.Grade = Grade;}	

	public int getColour(){return Colour;}
	public void setColour(int Colour){this.Colour = Colour;}
	
	public boolean getReinforcedbottom(){return Reinforcedbottom;}
	public void setReinforcedbottom(boolean Reinforcedbottom){this.Reinforcedbottom = Reinforcedbottom;}
	
	public boolean getReinforcedcorners(){return Reinforcedcorners;}
	public void setReinforcedcorners(boolean Reinforcedcorners){this.Reinforcedcorners = Reinforcedcorners;}
	
	public boolean getSealedtop(){return Sealedtop;}
	public void setSealedtop(boolean Sealedtop){this.Sealedtop = Sealedtop;}
	
	public int getQuantity(){return Quantity;}
	public void setQuantity(int Quantity){this.Quantity = Quantity;}
	
	public double getPrice(){return Price;}
	public void setPrice(double Price){this.Price = Price;}
	
	public double getPricetotal(){return Pricetotal;}
	public void setPricetotal(double Pricetotal){this.Pricetotal = Pricetotal;}
    
    public String chooseTypes()
    {
        if (Grade >= 1 && Grade<=3 && Colour == 0  &&  Reinforcedbottom == false && Reinforcedcorners == false) 
        {
         return "You have chosen Box Type 1, Your checkout price is: " + Pricetotal();
        }
        
        if  (Grade >= 2 && Grade<=4  && Colour == 1  && Reinforcedbottom == false && Reinforcedcorners == false) 
        {
          return "You have chosen Box Type 2, Your checkout price is: " + Pricetotal();
        }
        
        if (Grade >= 2 && Grade<=5 && Colour == 2 && Reinforcedbottom == false && Reinforcedcorners == false )
        {
         return "You have chosen Box Type 3, Your checkout price is: " + Pricetotal();
        }
        
          
       if (Grade >= 2 && Grade<=5 && Colour == 2 && Reinforcedbottom == true && Reinforcedcorners == false)
        {
         return "You have chosen Box Type 4, Your checkout price is: " + Pricetotal();
        }
        
       if (Grade >= 3 && Grade<=5 && Colour == 2 && Reinforcedbottom == true && Reinforcedcorners == true)
        {
          return "You have chosen Box Type 5, Your checkout price is: " + Pricetotal();
        }
        return "Box type does not exist and will have to be specially ordered";
    }
     public String toString()
    {
     return "Length:" +getLength()+"Width:"+getWidth()+"Height"+getHeight()+"Grade:"+getGrade()+"Colour:"+getColour()+"Quantity:"+getQuantity()+
     	"Sealable top:"+getSealedtop()+ "Reinforced Bottom:"+ getReinforcedbottom()+"Reinforced Corners: "+getReinforcedcorners();
    }
}
