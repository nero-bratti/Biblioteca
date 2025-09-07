package com.nbratti.biblioteca.interfaces;

import java.util.Map;

public interface IEstatistica {
    int mediaDeLivrosPorAutor(IAcervoRepository acervo);
    Map<Integer,Integer> anoELivros(IAcervoRepository acervo);
    String autorComMaisLivros(IAcervoRepository acervo);
}
