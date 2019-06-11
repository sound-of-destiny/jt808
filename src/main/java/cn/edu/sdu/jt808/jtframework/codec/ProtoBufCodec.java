package cn.edu.sdu.jt808.jtframework.codec;

import cn.edu.sdu.jt808.jtframework.annotation.ProtoBuf;
import cn.edu.sdu.jt808.jtframework.commons.JavaType;
import com.google.protobuf.ByteString;
import com.google.protobuf.Descriptors.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ProtoBufCodec {

    public static Object javaBeanToProtoBean(Object javaBean, Object protoBuilder) throws Exception {
        try {
            Method getDescriptorForType = protoBuilder.getClass().getMethod("getDescriptorForType");
            Descriptor descriptor = (Descriptor) getDescriptorForType.invoke(protoBuilder);

            Field[] fields = javaBean.getClass().getDeclaredFields();

            for (Field field : fields) {
                String fName = field.getName();
                field.setAccessible(true);
                Object value = field.get(javaBean);
                if (value == null) continue;
                FieldDescriptor fd = descriptor.findFieldByName(fName);
                String fNameFirstCharUpCase = fName.toUpperCase().charAt(0) + fName.substring(1);
                if (fd == null) continue;
                if (fd.isRepeated()) {
                    if (fd.getType() == FieldDescriptor.Type.MESSAGE) {
                        Method newBuilder = protoBuilder.getClass().getMethod("get" + fNameFirstCharUpCase, int.class)
                                .getReturnType().getMethod("newBuilder");

                        Object childBuilder = newBuilder.invoke(null);
                        List<Object> oList = (List<Object>) value;
                        List<Object> pBeanList = new ArrayList<>();
                        for (Object oItem : oList) {
                            Object pBean = javaBeanToProtoBean(oItem, childBuilder);
                            if (pBean != null) pBeanList.add(pBean);
                        }
                        Method addAll = protoBuilder.getClass().getMethod("addAll" + fNameFirstCharUpCase, Iterable.class);
                        addAll.invoke(protoBuilder, pBeanList);

                    } else {
                        if (!field.isAnnotationPresent(ProtoBuf.class)) continue;
                        ProtoBuf protoBuf = field.getAnnotation(ProtoBuf.class);
                        JavaType javaType = protoBuf.type();

                        switch (javaType) {
                            case INT:
                                int[] iList = (int[]) value;
                                Method mInt = protoBuilder.getClass().getMethod("add" + fNameFirstCharUpCase, int.class);
                                for (int item : iList) {
                                    mInt.invoke(protoBuilder, item);
                                }
                                break;
                            case LONG:
                                long[] lList = (long[]) value;
                                Method mLong = protoBuilder.getClass().getMethod("add" + fNameFirstCharUpCase, long.class);
                                for (long item : lList) {
                                    mLong.invoke(protoBuilder, item);
                                }
                                break;
                            case FLOAT:
                                float[] fList = (float[]) value;
                                Method mFloat = protoBuilder.getClass().getMethod("add" + fNameFirstCharUpCase, float.class);
                                for (float item : fList) {
                                    mFloat.invoke(protoBuilder, item);
                                }
                                break;
                            case DOUBLE:
                                double[] dList = (double[]) value;
                                Method mDouble = protoBuilder.getClass().getMethod("add" + fNameFirstCharUpCase, double.class);
                                for (double item : dList) {
                                    mDouble.invoke(protoBuilder, item);
                                }
                                break;
                            case STRING:
                                String[] sList = (String[]) value;
                                Method mString = protoBuilder.getClass().getMethod("add" + fNameFirstCharUpCase, String.class);
                                for (String item : sList) {
                                    mString.invoke(protoBuilder, item);
                                }
                                break;
                            default:
                                break;
                        }
                    }

                } else {

                    Method getFieldBuilder = protoBuilder.getClass().getMethod("getFieldBuilder", FieldDescriptor.class);

                    if (fd.getType() == FieldDescriptor.Type.MESSAGE) {
                        Object subBuilder = getFieldBuilder.invoke(protoBuilder, fd);
                        Object pBean = javaBeanToProtoBean(value, subBuilder);
                        Method setField = protoBuilder.getClass().getMethod("setField", FieldDescriptor.class, Object.class);
                        setField.invoke(protoBuilder, fd, pBean);
                    } else {
                        if (field.isAnnotationPresent(ProtoBuf.class)) {
                            ProtoBuf protoBuf = field.getAnnotation(ProtoBuf.class);
                            if (protoBuf.type() == JavaType.BYTE) {
                                byte[] bList = (byte[]) value;
                                Method mByte = protoBuilder.getClass().getMethod("set" + fNameFirstCharUpCase, ByteString.class);
                                mByte.invoke(protoBuilder, ByteString.copyFrom(bList));

                            }
                        } else {
                            Method setField = protoBuilder.getClass().getMethod("setField", FieldDescriptor.class, Object.class);
                            setField.invoke(protoBuilder, fd, value);
                        }
                    }
                }

            }

            Method buildM = protoBuilder.getClass().getMethod("build");
            return buildM.invoke(protoBuilder);
            /*    Method byteM = rObject.getClass().getMethod("toByteArray");
            Object byteObject =  byteM.invoke(rObject);
            byte[] pbByte = (byte[]) byteObject;  
            String pbStr = new String(Base64.getEncoder().encode(pbByte), "UTF-8");*/

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Object protoBeanToJavaBean(Object protoBean, Object javaBean) throws Exception {
        Method getDescriptorForType = protoBean.getClass().getMethod("getDescriptorForType");
        Descriptor descriptor = (Descriptor) getDescriptorForType.invoke(protoBean);
        List<FieldDescriptor> fieldDescriptors = descriptor.getFields();

        for (FieldDescriptor fieldDescriptor : fieldDescriptors) {
            String fdName = fieldDescriptor.getName();
            Field field = javaBean.getClass().getDeclaredField(fdName);
            field.setAccessible(true);
            String firstUpCaseFName = fdName.toUpperCase().charAt(0) + fdName.substring(1);

            if (fieldDescriptor.getType() == FieldDescriptor.Type.BYTES) {
                Method m = protoBean.getClass().getMethod("get" + firstUpCaseFName);
                ByteString bytes = (ByteString) m.invoke(protoBean);
                field.set(javaBean, bytes.toByteArray());
                continue;
            }

            if (fieldDescriptor.isRepeated()) {
                Method m = protoBean.getClass().getMethod("get" + firstUpCaseFName + "List");
                List list = (List) m.invoke(protoBean);

                if (fieldDescriptor.getType() == FieldDescriptor.Type.MESSAGE) {
                    List<Object> resList = new ArrayList<>();
                    for(Object l : list) {
                        try {
                            Type clazz = ((ParameterizedType) javaBean.getClass()
                                    .getMethod("get" + firstUpCaseFName)
                                    .getGenericReturnType())
                                    .getActualTypeArguments()[0];
                            Object o = ((Class<Object>) clazz).getDeclaredConstructor().newInstance();
                            Object res = protoBeanToJavaBean(l, o);
                            resList.add(res);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    field.set(javaBean, resList);
                } else {
                    switch (fieldDescriptor.getType().getJavaType()) {
                        case INT:
                            int[] ints = new int[list.size()];
                            for(int i = 0; i < list.size(); i++) {
                                ints[i] = (int) list.get(i);
                            }
                            field.set(javaBean, ints);
                            break;
                        case LONG:
                            long[] longs = new long[list.size()];
                            for(int i = 0; i < list.size(); i++) {
                                longs[i] = (long) list.get(i);
                            }
                            field.set(javaBean, longs);
                            break;
                        case FLOAT:
                            float[] floats = new float[list.size()];
                            for(int i = 0; i < list.size(); i++) {
                                floats[i] = (float) list.get(i);
                            }
                            field.set(javaBean, floats);
                            break;
                        case DOUBLE:
                            double[] doubles = new double[list.size()];
                            for(int i = 0; i < list.size(); i++) {
                                doubles[i] = (double) list.get(i);
                            }
                            field.set(javaBean, doubles);
                            break;
                        case STRING:
                            String[] strings = new String[list.size()];
                            for(int i = 0; i < list.size(); i++) {
                                strings[i] = (String) list.get(i);
                            }
                            field.set(javaBean, strings);
                            break;
                        default:
                            break;
                    }
                }

            } else {
                Method m = protoBean.getClass().getMethod("get" + firstUpCaseFName);
                Object object = m.invoke(protoBean);
                if (fieldDescriptor.getType() == FieldDescriptor.Type.MESSAGE) {
                    Type clazz = javaBean.getClass().getMethod("get" + firstUpCaseFName).getReturnType();
                    Object o = ((Class<Object>) clazz).getDeclaredConstructor().newInstance();
                    Object res = protoBeanToJavaBean(object, o);
                    field.set(javaBean, res);
                } else {
                    field.set(javaBean, object);
                }
            }

        }
        return javaBean;
    }
}
