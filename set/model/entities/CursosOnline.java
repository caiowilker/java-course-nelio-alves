package set.model.entities;

import java.util.List;
import java.util.Objects;

public class CursosOnline {

    private char curso;
    private List<Integer> id;

    public CursosOnline(char curso, List<Integer> id) {
        this.curso = curso;
        this.id = id;
    }

    public char getCurso() {
        return curso;
    }

    public List<Integer> getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursosOnline that = (CursosOnline) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
