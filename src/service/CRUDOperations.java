package service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;

import model.Blog;

public class CRUDOperations {
	static List<Blog> list=new ArrayList<Blog>(); // Store the blog in the list
	
	public List<Blog> createBlog(Blog blog) throws IOException {
		list.add(blog);
		return list;
	}
	
	public void viewBlog(Blog blog) throws IOException{
		for(Blog x:list) {
			if(x==blog) {
			System.out.println(x.getBlogTitle());
			System.out.println(x.getBlogDescription());
			System.out.println(x.getDate());
			}
		}
		
	}
	public List<Blog> updateBlog(Blog blog) throws IOException{
		for(Blog x:list) {
			//Asumming that title is the parameter on which updation take place
			if(x.getBlogTitle().equals(blog.getBlogTitle())) {
			x.setBlogDescription(blog.getBlogDescription());
			x.setDate(blog.getDate());
			System.out.println("After Updation");
			System.out.println(x.getBlogTitle());
			System.out.println(x.getBlogDescription());
			System.out.println(x.getDate());
			}
		}
		return list;
	
	}
	public List<Blog> deleteBlog(Blog blog) throws IOException{
		list.remove(blog);
		System.out.println("After Deletion");
		for(Blog x:list) {
			System.out.println(x.getBlogTitle());
			System.out.println(x.getBlogDescription());
			System.out.println(x.getDate());
		}
		return list;
		
	}
	
	//Using List
	public List<Blog> SortByTitle(){
		//Using List
		Collections.sort(list,(b1,b2)->b1.getBlogTitle().compareTo(b2.getBlogTitle()));
		System.out.println("After Sorting By Title Using List");
		for(Blog x:list) {
			System.out.println(x.getBlogTitle());
			System.out.println(x.getBlogDescription());
			System.out.println(x.getDate());
		}
		
		//Using Set
		TreeSet<Blog> ts=new TreeSet<Blog>(list);
		System.out.println("After Sorting By Title Using Set");
		for(Blog x:ts) {
			System.out.println(x.getBlogTitle());
			System.out.println(x.getBlogDescription());
			System.out.println(x.getDate());
		}
		
		//Using map
		TreeMap<String,Blog> tm=new TreeMap<String,Blog>();
		for(Blog x:list) 
			tm.put(x.getBlogTitle(), x);
		System.out.println("After Sorting By Title Using Map");
		for(Map.Entry<String,Blog> x:tm.entrySet()) {
			Blog b=x.getValue();
			System.out.println(b.getBlogTitle());
			System.out.println(b.getBlogDescription());
			System.out.println(b.getDate());
		}
		return list;
	}
	
	public List<Blog> SortByDate(){
		//Using List
		Collections.sort(list,(b1,b2)->b1.getDate().compareTo(b2.getDate()));
		System.out.println("After Sorting By Date Using List");
		for(Blog x:list) {
			System.out.println(x.getBlogTitle());
			System.out.println(x.getBlogDescription());
			System.out.println(x.getDate());
		}
		
		//Using map
		TreeMap<LocalDate,Blog> tm=new TreeMap<LocalDate,Blog>();
		for(Blog x:list) 
			tm.put(x.getDate(), x);
		System.out.println("After Sorting By Date Using Map");
		for(Map.Entry<LocalDate,Blog> x:tm.entrySet()) {
			Blog b=x.getValue();
			System.out.println(b.getBlogTitle());
			System.out.println(b.getBlogDescription());
			System.out.println(b.getDate());
		}
		return list;
		
	}
	
	
	
}
