package com.zengyao.innerClass;

public class TestInnerClass{
    public static void main(String args[]){
        Goods good = new Goods();
        
        Contents content = good.dest("zengyao");
        System.out.println(content.value());
        
        
      
    }
}
interface Contents{
    int value();
}
interface Destination{
    String readLabel();
}
class Goods{
    
    private int valueRate = 2;
    private class Content implements Contents{
        private int i = 11 * Goods.this.valueRate;
        private int valueRate=3;
        private String name=null;
        public  Content(String name) {
        	this.name=name;
        }
        public int value(){
        	int valueRate=4;
        	int x=valueRate*2;
        	int y=this.valueRate*2;
        	int z=Goods.this.valueRate*2;
        	System.out.println("x: "+x+"，y="+y+",z="+z+",name="+this.name);
            return i;
        }
    }
    protected class GDestination implements Destination{
    	
        private String label;
        public GDestination(String whereTo){
            label = whereTo;
        }
        public String readLabel(){
            return label;
        }
    }
    public Content dest(String name){
        return new Content(name);
    }
    public GDestination cont(String s){
        return new GDestination(s);
    }
}
