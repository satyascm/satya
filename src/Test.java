public class Test 
{
	class innerclass
	{
		public void m1()
		{
			System.out.println("Original Innerclass");	
		}
		
	}
	
	public static void main(String[] args)
	{
		System.out.println("Outerclass");//Outerclass
		Test t = new Test();
		Test.innerclass i = t.new innerclass()
			{
			@Override
				public void m1()
				{
					System.out.println("First Ananymous inner class");	
				}	
			};
			i.m1();//First Ananymous inner class
			System.out.println(i.getClass().getName());//com.innerclass.Test$1
			new Test().new innerclass().m1();//"Original Innerclass"
			Test t1 = new Test();
			Test.innerclass i1 = t.new innerclass()
				{
				@Override
					public void m1()
					{
						System.out.println("second Ananymous inner class");	
					}	
				};
				i1.m1();//second Ananymous inner class
			System.out.println(i1.getClass().getName());//com.innerclass.Test$2
			new Test().new innerclass().m1();//"Original Innerclass"
	}

}
