package com.mood.copy;


import com.mood.Pager;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.util.List;

/**
 * 描述:
 *
 * @author chaiwei
 * @create 2018-12-28 下午2:38
 */
public final class OrikaMapper {

    private static final MapperFacade FACADE;

    static {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
//        final ConverterFactory converterFactory = mapperFactory.getConverterFactory();
//        converterFactory.registerConverter(new InstantConverter());
//        converterFactory.registerConverter(new LocalDateConverter());
//        converterFactory.registerConverter(new LocalDateTimeConverter());
//        converterFactory.registerConverter(new LocalTimeConverter());
//        converterFactory.registerConverter(new OffsetDateTimeConverter());
//        converterFactory.registerConverter(new ZonedDateTimeConverter());
        FACADE = mapperFactory.getMapperFacade();
    }

    private OrikaMapper() {
    }

    /**
     * 基于Dozer转换对象的类型.
     */
    public static <S, D> D map(S source, Class<D> destinationClass) {
        return FACADE.map(source, destinationClass);
    }

    /**
     * 基于Dozer转换Collection中对象的类型.
     */
    public static <S, D> List<D> mapList(Iterable<S> sourceList, Class<D> destinationClass) {
        return FACADE.mapAsList(sourceList, destinationClass);
    }

    /**
     * 基于Dozer转换Collection中对象的类型.
     */
    public static <S, D> Pager<D> mapPager(Pager<S> pager, Class<D> destinationClass) {
        return new Pager(pager.getPageIndex(),pager.getPageSize(),pager.getTotal(),FACADE.mapAsList(pager.getContent(), destinationClass));
    }

}