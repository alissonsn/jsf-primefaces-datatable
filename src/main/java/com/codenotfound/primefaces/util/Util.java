package com.codenotfound.primefaces.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Util {
	
	public static <T> List<T> concatenatedList(List<T>... collections) {
        return Arrays.stream(collections).flatMap(Collection::stream).collect(Collectors.toList()); 
}

}
