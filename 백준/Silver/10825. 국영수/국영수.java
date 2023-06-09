import java.io.*;
import java.util.*;

class Student{
	String name;
	int a;
	int b;
	int c;
	
	Student(String name, int a, int b, int c){
		this.name = name;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public String getName() {
        return this.name;
    }
	
	public int getA() {
        return this.a;
    }
	
	public int getB() {
        return this.b;
    }
	
	public int getC() {
        return this.c;
    }
}

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		
		List<Student> list = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			String[] sarr = br.readLine().split(" ");
			list.add(new Student(sarr[0], Integer.valueOf(sarr[1]),
					Integer.valueOf(sarr[2]), Integer.valueOf(sarr[3])));
		}
		
		Collections.sort(list, new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				if(s1.a>s2.a)
					return -1;
				else if(s1.a<s2.a)
					return 1;
				else if(s1.a==s2.a) {
					if(s1.b>s2.b)
						return 1;
					else if(s1.b<s2.b)
						return -1;
					else if(s1.b==s2.b) {
						if(s1.c>s2.c)
							return -1;
						else if(s1.c<s2.c)
							return 1;
						else if(s1.c==s2.c) {
							if(s1.name.compareTo(s2.name)>0)
								return 1;
							else if(s1.name.compareTo(s2.name)<0)
								return -1;
								
						}
							
					}
				}
				return 0;
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(list.get(i).getName());
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
