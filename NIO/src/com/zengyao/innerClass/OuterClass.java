package com.zengyao.innerClass;





public class OuterClass {
    public InnerClass getInnerClass(final int num,String str2){
        return new InnerClass(){
            int number = num+2;
            public int getNumber(){
            	number=num+3;
            	System.out.println("number: "+number+",num="+num);
            	System.out.println("num: "+number+",str2="+str2);
                return number;
            }
        };        /* 注意：分号不能省 */
    }
     
    public static void main(String[] args) {
        OuterClass out = new OuterClass();
        InnerClass inner = out.getInnerClass(2, "chenssy");
        System.out.println(inner.getNumber());
    }
}
 
interface InnerClass {
    int getNumber();
}
