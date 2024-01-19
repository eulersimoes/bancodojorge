package br.com.bancodojorge.apirest.infrastructure.spring.assembler;

import org.springframework.stereotype.Component;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Component
public class ConversionServiceAssembler implements Assembler, InitializingBean {
    @Autowired(required = false)
    private Set<Converter> converters;
    @Autowired(required = false)
    private Set<GenericConverter> genericConverters;
    private GenericConversionService conversionService;

    @Override
    public void afterPropertiesSet() {
        conversionService = new DefaultConversionService();
        ConversionServiceFactory.registerConverters(this.converters, this.conversionService);
        ConversionServiceFactory.registerConverters(this.genericConverters, this.conversionService);
    }

    @Override
    public <S, T> T from(S source, Class<T> targetClass) {
        return conversionService.convert(source, targetClass);
    }

    @Override
    public <S, T> List<T> from(List<S> list, Class<T> targetClass) {
        return (List<T>) from(list, List.class, targetClass);
    }

    @Override
    public <S, T> Set<T> from(Set<S> list, Class<T> targetClass) {
        return (Set<T>) from(list, Set.class, targetClass);
    }

    @Override
    public <S, T> Collection<T> from(Collection<S> col, Class<T> targetClass) {
        return from(col, Collection.class, targetClass);
    }

    @Override
    public void initialize(Object object) {
        Hibernate.initialize(object);
    }

    private <S, T> Collection<T> from(Collection<S> col, Class collectionClass, Class<T> targetClass) {
        Class sourceClass = null;

        for (S s : col) {
            if (s != null) {
                sourceClass = s.getClass();
                break;
            }
        }

        if (sourceClass == null) {
            return (Set.class == collectionClass) ? Collections.EMPTY_SET : Collections.EMPTY_LIST;
        }

        return (Collection<T>) conversionService.convert(col,
                TypeDescriptor.collection(collectionClass, TypeDescriptor.valueOf(sourceClass)),
                TypeDescriptor.collection(collectionClass, TypeDescriptor.valueOf(targetClass)));
    }
}
