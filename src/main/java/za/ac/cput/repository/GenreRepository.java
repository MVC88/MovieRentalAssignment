package za.ac.cput.repository;

import za.ac.cput.entity.Genre;

import java.util.HashSet;
import java.util.Set;

public class GenreRepository implements IGenreRepository {
    private static GenreRepository repository = null;
    private Set<Genre> genreDB = null;

    private GenreRepository(){
        genreDB = new HashSet<Genre>();
    }

    public static GenreRepository getRepository(){
        if(repository ==null){
            repository = new GenreRepository();
        }
        return repository;
    }

    @Override
    public Set<Genre> getAll() {
        return genreDB;
    }

    @Override
    public Genre create(Genre genre) {
        boolean success = genreDB.add(genre);
        if(!success)
            return null;
        return genre;
    }

    @Override
    public Genre read(String genreId) { // add String genreName
        for(Genre g : genreDB)
            if(g.toString().equals(genreId)){ // getClass should be getId or something (tostring should be getId)
                return g;
            }
        return null;

    }

    @Override
    public Genre update(Genre genre) {
        Genre oldGenre = read(genre.toString());  //getId (tostring should be getId or genreId)
        if(oldGenre != null){
            genreDB.remove(oldGenre);
            genreDB.add(genre);
            return genre;
        }
        return null;
    }

    @Override
    public boolean delete(String genreId) {
        Genre genreToDelete = read(genreId);
        if(genreToDelete == null)
            return false;
        genreDB.remove(genreToDelete);
        return true;
    }
}
