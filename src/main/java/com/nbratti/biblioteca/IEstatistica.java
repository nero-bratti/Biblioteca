package com.nbratti.biblioteca;

import java.util.Map;

public interface IEstatistica {
    int mediaDeLivrosPorAutor(IAcervo acervo);
    Map<Integer,Integer> anoELivros(IAcervo acervo);
    String autorComMaisLivros(IAcervo acervo);
}
