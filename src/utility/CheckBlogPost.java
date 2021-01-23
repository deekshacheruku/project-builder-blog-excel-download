package utility;

import model.Blog;

public class CheckBlogPost extends OffensiveWordsChecker implements OffensiveWordsInterface{
	
	String[] bad_words = {"2 girls 1 cup","2g1c","arsehole","ass","5hit","a$$","a$$hole","a_s_s","a2m","a54","a55","a55hole","acrotomophilia","ass fuck","ahole","alabama hot pocket","alaskan pipeline","anal","anal impaler","anal leakage","ass hole","anilingus","anus","apeshit","b1tch"};
	
	private boolean Check(String str) {
		String[] sample=str.split(" ");
		for(int i=0;i<sample.length;i++) {
			for(int j=0;j<bad_words.length;j++) {
				if (sample[i].equalsIgnoreCase(bad_words[j]))
					return false;
			}
		}
		return true;
	}
	@Override
	public boolean checkBlogTitle(Blog blog) {
		if (Check(blog.getBlogTitle()))
			return true;
		return false;
	}

	@Override
	public boolean checkBlogDescription(Blog blog) {
		if(Check(blog.getBlogDescription()))
			return true;
		return false;
	}

	@Override
	public boolean checkBlog(Blog blog) {
		if(checkBlogDescription(blog) && checkBlogTitle(blog))
			return true;
		return false;
	}
	
}