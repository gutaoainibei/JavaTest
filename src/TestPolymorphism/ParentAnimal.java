package TestPolymorphism;

public class ParentAnimal {
    public void voice (){
    	System.out.println("动物的声音");
    }
}
class Cat extends ParentAnimal{
	public void voice(){
		System.out.println("喵喵喵");
	}
	public void catchmouse(){
		System.out.println("抓老鼠");
	}
}
class Dog extends ParentAnimal{
	public void voice(){
		System.out.println("汪汪汪");
	}
	public void catchhuairen(){
		System.out.println("抓坏人");
	}
}
class Tiger extends ParentAnimal{
	public void voice(){
		System.out.println("哇哇哇");
	}
	public void catchyang(){
		System.out.println("抓羊");
	}
}