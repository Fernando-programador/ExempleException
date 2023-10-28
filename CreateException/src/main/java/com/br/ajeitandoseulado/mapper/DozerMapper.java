package com.br.ajeitandoseulado.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.github.dozermapper.core.MappingException;

public class DozerMapper {
	
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	  public static <D> D map(Object obj, Class<D> destinationClass) throws MappingException{
		  return mapper.map(obj, destinationClass);
	  }
	  
	  public static <O, D> List<D> listMap(List<O> obj, Class<D> destinationClass)throws MappingException{
		  List<D> listObj = new ArrayList<>();
		  for(O o: obj) {
			  listObj.add(mapper.map(o, destinationClass));
		  }
		  return listObj;
	  }
	  
}
