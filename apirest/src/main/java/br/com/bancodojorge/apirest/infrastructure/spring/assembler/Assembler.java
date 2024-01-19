package br.com.bancodojorge.apirest.infrastructure.spring.assembler;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface Assembler {
    <S, T> T from(S source, Class<T> targetClass);

    <S, T> List<T> from(List<S> list, Class<T> targetClass);

    <S, T> Set<T> from(Set<S> list, Class<T> targetClass);

    <S, T> Collection<T> from(Collection<S> list, Class<T> targetClass);

    void initialize(Object object);
}
