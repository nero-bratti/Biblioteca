package com.nbratti.biblioteca.model;

import com.nbratti.biblioteca.interfaces.IAcervoRepository;
import com.nbratti.biblioteca.interfaces.IEstatistica;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class Estatistica implements IEstatistica {
    @Override
    public int mediaDeLivrosPorAutor(IAcervoRepository acervo) {
        return acervo.livrosDoAcervo().size() / acervo.autoresDoAcervo().size();
    }

    @Override
    public Map<Integer, Integer> anoELivros(IAcervoRepository acervo) {
        return acervo.livrosDoAcervo()
                .stream()
                .collect(Collectors.groupingBy(
                        Livro::getAno,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ));
    }

    @Override
    public String autorComMaisLivros(IAcervoRepository acervo) {
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
