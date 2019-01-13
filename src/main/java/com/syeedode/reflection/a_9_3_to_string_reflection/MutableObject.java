package com.syeedode.reflection.a_9_3_to_string_reflection;

import com.syeedode.reflection.constraints.ObjectConstraint;

import java.lang.Object;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class MutableObject implements Serializable {

    /**
     * toString
     *
     *      Method utilizes reflection to implement the printing of
     *      properties of all of its subclasses.
     *
     *      The benefit of this method is that it can dynamically
     *      determine the properties. So whether you have 4 data model
     *      objects or 40,000.
     *
     * @return
     */
    public String toString() {
        try {
            /** Reflection toolkit usage */
            /**    Obtain the bean info for this class and any super
             *     class up to but excluding Object.
             */
            final BeanInfo info = Introspector.getBeanInfo(this.getClass(), Object.class);
            /** Reflection toolkit usage */
            /**    This provides access to all of the properties. */
            final PropertyDescriptor[] props = info.getPropertyDescriptors();
            final StringBuffer buf = new StringBuffer(500);
            Object value = null;
            buf.append(getClass().getName());
            buf.append("@");
            buf.append(hashCode());
            buf.append("={");
            // Loop through the properties for this object and its super class
            for(int idx = 0; idx < props.length; idx++) {
                if(idx != 0) {
                    buf.append(",");
                }
                buf.append(props[idx].getName());
                buf.append("=");
                /** This is needed just in case the method is write-only */
                if(props[idx].getReadMethod() != null) {

                    /** Reflection toolkit usage */
                    value = props[idx].getReadMethod().invoke(this, null);
                    // This is to guard against an endless loop. If this class
                    // has an a reference to MutableObject than that
                    // MutableObject's toString mehtod would cause an infinite
                    // loop. In this case we just print the hashCode
                    if(value instanceof MutableObject) {
                        buf.append("@");
                        buf.append(value.hashCode());
                    } else if (value instanceof Collection) {
                        buf.append("{");
                        for(Iterator iter = ((Collection) value).iterator();
                            iter.hasNext();) {
                            Object element = iter.next();
                            /** Reflection toolkit usage */
                            if(element instanceof MutableObject) {
                                buf.append("@");
                                buf.append(element.hashCode());
                            } else {
                                buf.append(element.toString());
                            }
                        }
                        buf.append("}");
                    }
                    /** Reflection toolkit usage */
                    else if (value instanceof Map) {
                        buf.append("{");
                        Map map = (Map) value;
                        for(Iterator iter = map.keySet().iterator(); iter.hasNext();) {
                            Object key = iter.next();
                            Object element = map.get(key);
                            buf.append(key.toString());
                            buf.append("=");
                            /** Reflection toolkit usage */
                            if(element instanceof MutableObject) {
                                buf.append("@");
                                buf.append(element.hashCode());
                            } else {
                                buf.append(element.toString());
                            }
                        }
                        buf.append("}");
                    } else {
                        buf.append(value);
                    }
                }
            }
            buf.append("}");
            return buf.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /** pg 342 of 456 */
    public static final Map buildConsgraintMap(final Class dataType)
            throws IllegalAccessException{
        final int modifiers = Modifier.PUBLIC | Modifier.FINAL | Modifier.STATIC;

        Map constraintMap = new HashMap();
        /** bold */
        final Field[] fields = dataType.getFields();
        Object value = null;
        for(int idx = 0; idx < fields.length; idx++) {
            if((fields[idx].getModifiers() & modifiers) == modifiers) {
                value = fields[idx].get(null);
                if(value instanceof ObjectConstraint) {
                    // constraintMap.put(((ObjectConstraint)value).getName(), value);
                }
            }
        }
        return new HashMap();
    }
}
