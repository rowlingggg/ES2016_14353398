class A{
   synchronized void methodA(B b){
        b.last();
   }

   synchronized void last(){
        System.out.println("Inside A.last()");
   }      
 }


class B{
   synchronized void methodB(A a){
        a.last();
   }

   synchronized void last(){
        System.out.println("Inside B.last()");
   }      
 }
//一个线程在后台默默运行
//每次调度到他的执行时就运行run（）中的语句
class Deadlock implements Runnable{
	A a=new A();
	B b=new B();

	//构造函数
	Deadlock(){
		Thread t=new Thread(this);
		int count = 10000;

		t.start();//线程t开始
		while(count-->0);//等待10000
		a.methodA(b);
	}
	//runnable运行时调用的方法
	public void run(){
		b.methodB(a);
	}
	public static void main(String args[]){
		new Deadlock();
	}
}
