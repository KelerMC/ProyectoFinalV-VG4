/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unsch.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class EstrategiaExclusion implements ExclusionStrategy {

    private final Class<?> typeToSkip;

    public EstrategiaExclusion(Class<?> typeToSkip) {
        this.typeToSkip = typeToSkip;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return (clazz == typeToSkip);
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getAnnotation(Omitir.class) != null;
    }
}
