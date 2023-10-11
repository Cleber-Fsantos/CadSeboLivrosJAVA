import java.time.LocalDate;
import java.time.Period;

public class Livro {
    public String titulo;
    public double preco;
    public LocalDate dataLancamento;
    public Autor autor;

    //public void cadastrarLivro(Livro livro){
        //listaLivro.add(livro);

    //}
    //public List<Livro> listarLivro(){

    //}

    public int verificarTempoLanc(LocalDate date){
        Period periodo = Period.between(date, LocalDate.now());

        return periodo.getYears();

    }

}
