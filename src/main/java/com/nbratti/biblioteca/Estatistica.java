package com.nbratti.biblioteca;

import java.util.Map;
import java.util.stream.Collectors;

public class Estatistica implements IEstatistica{
    @Override
    public int mediaDeLivrosPorAutor(IAcervo acervo) {
        return acervo.livrosDoAcervo().size() / acervo.autoresDoAcervo().size();
    }

    @Override
    public Map<Integer, Integer> anoELivros(IAcervo acervo) {
        return acervo.livrosDoAcervo()
                .stream()
                .collect(Collectors.groupingBy(
                        Livro::getAno,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ));
    }

    @Override
    public String autorComMaisLivros(IAcervo acervo) {
        return acervo.livrosDoAcervo()
                .stream()
                .collect(Collectors.groupingBy(
                        Livro::getAutor,
                        Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("");
    }

}
