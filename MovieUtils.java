public class MovieUtils {
	// Return the movie with the given id if found, null otherwise.
	public static Movie findMovieById(List<Movie> movies, int id) {
		if(movies.empty())
			return null;
	
		movies.findFirst();	
		
	while(!movies.last()) {
		Movie temp=movies.retrieve();
			if(temp.id==id)
				return temp;
			movies.findNext();
		}
		Movie temp=movies.retrieve();
		if(temp.id==id)
			return temp;
		
		return null;
	}
	// Return the list of movies having a given title. If none is found, empty list is returned.
	public static List<Movie> findMovieByTitle(List<Movie> movies, String title) {
		List<Movie> list=new LinkedList<Movie>();
		
		if(movies.empty())
			return list;
		
movies.findFirst();	
		
		while(!movies.last()) {
			Movie temp=movies.retrieve();
				if(temp.title.equals(title))
					list.insert(temp);
				movies.findNext();
			}
			Movie temp=movies.retrieve();
			if(temp.title.equals(title))
				list.insert(temp);
				
		
		return list;
	}
	// Return the list of movies of a given genre. If none is found, empty list is returned.
	public static List<Movie> findMoviesByGenre(List<Movie> movies, String genre) {
		List<Movie> list=new LinkedList<Movie>();
		List<String> gen;

		StringEqualCond temp=new StringEqualCond(genre);

		if(movies.empty())
			return list;
		
		movies.findFirst();	
		
		while(!movies.last()) {
			
			if(movies.retrieve().genres.empty()) {
				movies.findNext();
			continue;}
			gen=movies.retrieve().genres;
			if(gen.findFirstEle(temp)) 
				list.insert(movies.retrieve());
				
			movies.findNext();
			
		}
		gen=movies.retrieve().genres;
		if(gen.findFirstEle(temp)) 
			list.insert(movies.retrieve());
			
		
		return list;
	}
	// Return the list of movies of given genres (a movie must have all genres to be in the list). If none is found, empty list is returned. Assume genres is not empty.
	public static List<Movie> findMoviesByGenres(List<Movie> movies, List<String> genres) {
		List<Movie> list=new LinkedList<>();
		List<String> gen;
		StringEqualCond temp;
		boolean flag=true;
		if(movies.empty())
			return list;
		
		movies.findFirst();
		while(!movies.last()) {
			
			if(movies.retrieve().genres.empty()) {
				movies.findNext();
			continue;}
			
			gen=movies.retrieve().genres;
			genres.findFirst();
			while(!genres.last() ) {
				temp=new StringEqualCond(genres.retrieve());
				flag=gen.findFirstEle(temp);
				
				if(!flag) 
				break; 
				
		genres.findNext();  	
				}
		if(flag) {
			temp=new StringEqualCond(genres.retrieve());
			if(gen.findFirstEle(temp))
			list.insert(movies.retrieve());
		}
		movies.findNext();
		
		}//movie
		
		if(movies.retrieve().genres.empty())
			return list;
		
		gen=movies.retrieve().genres;
		genres.findFirst();
		while(!genres.last() ) {
			temp=new StringEqualCond(genres.retrieve());
			flag=gen.findFirstEle(temp);
			
			if(!flag) 
			break;
			
	genres.findNext();  	
			}
	if(flag) {
		temp=new StringEqualCond(genres.retrieve());
		if(gen.findFirstEle(temp))
		list.insert(movies.retrieve());
	}
		
		return list;
	}
}
